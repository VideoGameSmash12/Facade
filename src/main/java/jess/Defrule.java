package jess;

import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.io.Serializable;

public class Defrule extends HasLHS implements Serializable
{
    private HashMap<Token, Activation> m_activations;
    private Funcall[] m_actions;
    private int m_nActions;
    private int m_salience;
    Value m_salienceVal;
    private boolean m_autoFocus;
    private LogicalNode m_logicalNode;
    
    public final int getSalience() {
        return this.m_salience;
    }
    
    void setSalience(final Value salienceVal, final Rete rete) throws JessException {
        this.m_salienceVal = salienceVal;
        this.evalSalience(rete);
    }
    
    public boolean getAutoFocus() {
        return this.m_autoFocus;
    }
    
    public void setAutoFocus(final boolean autoFocus) {
        this.m_autoFocus = autoFocus;
    }
    
    void addCE(final LHSComponent lhsComponent, final Rete rete) throws JessException {
        if (lhsComponent.getLogical() && this.getGroupSize() > 0 && !this.getLHSComponent(this.getGroupSize() - 1).getLogical()) {
            throw new JessException("Defrule.addCE", "Logical CEs can't follow non-logical CEs", this.m_name);
        }
        super.addCE(lhsComponent, rete);
    }
    
    public synchronized int evalSalience(final Rete rete) throws JessException {
        final Context push = rete.getGlobalContext().push();
        try {
            this.m_salience = this.m_salienceVal.intValue(push);
        }
        finally {
            push.pop();
        }
        push.pop();
        return this.m_salience;
    }
    
    private final void doAddCall(final Token token, final Rete rete) throws JessException {
        final Activation activation = new Activation(token, this);
        rete.addActivation(activation);
        this.m_activations.put(token, activation);
    }
    
    private final void possiblyDoAddCall(final Token token, final Rete rete) throws JessException {
        if (!this.m_new) {
            return;
        }
        if (this.m_activations.get(token) != null) {
            return;
        }
        this.doAddCall(token, rete);
    }
    
    public void callNodeLeft(final Token token, final Context context) throws JessException {
        this.broadcastEvent(32768, token);
        switch (token.m_tag) {
            case 0: {
                this.doAddCall(token, context.getEngine());
                break;
            }
            case 1: {
                final Activation activation = this.m_activations.remove(token);
                if (activation != null) {
                    context.getEngine().removeActivation(activation);
                }
                break;
            }
            case 2: {
                this.possiblyDoAddCall(token, context.getEngine());
                break;
            }
            case 3: {
                this.m_activations.clear();
                break;
            }
        }
    }
    
    private final void ready(final Token token, final Context context) {
        final Enumeration<BindingValue> elements = (Enumeration<BindingValue>)this.getBindings().elements();
        while (elements.hasMoreElements()) {
            final BindingValue bindingValue = elements.nextElement();
            if (bindingValue.getSlotIndex() == -2) {
                continue;
            }
            final Fact fact = token.fact(bindingValue.getFactNumber());
            try {
                Value value;
                if (bindingValue.getSlotIndex() == -1) {
                    value = new FactIDValue(fact);
                }
                else if (bindingValue.getSubIndex() == -1) {
                    value = fact.get(bindingValue.getSlotIndex());
                }
                else {
                    value = fact.get(bindingValue.getSlotIndex()).listValue(context).get(bindingValue.getSubIndex());
                }
                context.setVariable(bindingValue.getName(), value);
            }
            catch (Throwable t) {}
        }
        if (this.m_logicalNode != null) {
            Token parent = token;
            for (int i = token.size(); i > this.m_logicalNode.getTokenSize(); --i) {
                parent = parent.getParent();
            }
            context.setLogicalSupportNode(this.m_logicalNode);
            context.setToken(parent);
        }
    }
    
    synchronized void fire(final Token token, final Rete rete) throws JessException {
        this.m_activations.remove(token);
        final Context push = rete.getGlobalContext().push();
        push.clearReturnValue();
        this.ready(token, push);
        try {
            for (int i = 0; i < this.m_nActions; ++i) {
                this.m_actions[i].execute(push);
                if (push.returning()) {
                    push.clearReturnValue();
                    push.pop();
                    rete.popFocus(this.getModule());
                    return;
                }
            }
        }
        catch (JessException ex) {
            ex.addContext("defrule " + this.getDisplayName());
            throw ex;
        }
        finally {
            push.pop();
        }
        push.pop();
    }
    
    void debugPrint(final Token token, final int n, final PrintWriter printWriter) {
        printWriter.print("FIRE ");
        printWriter.print(n);
        printWriter.print(" ");
        printWriter.print(this.getDisplayName());
        for (int i = 0; i < token.size(); ++i) {
            final Fact fact = token.fact(i);
            if (fact.getFactId() != -1) {
                printWriter.print(" f-" + fact.getFactId());
            }
            if (i < token.size() - 1) {
                printWriter.print(",");
            }
        }
        printWriter.println();
        printWriter.flush();
    }
    
    public int getNActions() {
        return this.m_nActions;
    }
    
    public Funcall getAction(final int n) {
        return this.m_actions[n];
    }
    
    void addAction(final Funcall funcall) {
        if (this.m_actions == null || this.m_nActions == this.m_actions.length) {
            final Funcall[] actions = this.m_actions;
            this.m_actions = new Funcall[this.m_nActions + 5];
            if (actions != null) {
                System.arraycopy(actions, 0, this.m_actions, 0, this.m_nActions);
            }
        }
        this.m_actions[this.m_nActions++] = funcall;
    }
    
    public Object accept(final Visitor visitor) {
        return visitor.visitDefrule(this);
    }
    
    void setLogicalInformation(final LogicalNode logicalNode) {
        this.m_logicalNode = logicalNode;
    }
    
    public String toString() {
        return "Defrule " + this.getName();
    }
    
    LogicalNode getLogicalNode() {
        return this.m_logicalNode;
    }
    
    Defrule(final String s, final String s2, final Rete rete) throws JessException {
        super(s, s2, rete);
        this.m_activations = new HashMap<>();
        this.m_autoFocus = false;
        this.m_logicalNode = null;
        this.m_salience = 0;
        this.m_salienceVal = new Value(0, 4);
    }
}
