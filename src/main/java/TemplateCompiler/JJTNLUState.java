package TemplateCompiler;

import java.util.Stack;

class JJTNLUState
{
    private Stack nodes;
    private Stack marks;
    private int sp;
    private int mk;
    private boolean node_created;
    
    boolean nodeCreated() {
        return this.node_created;
    }
    
    void reset() {
        this.nodes.removeAllElements();
        this.marks.removeAllElements();
        this.sp = 0;
        this.mk = 0;
    }
    
    Node rootNode() {
        return (Node)this.nodes.elementAt(0);
    }
    
    void pushNode(final Node node) {
        this.nodes.push(node);
        ++this.sp;
    }
    
    Node popNode() {
        final int sp = this.sp - 1;
        this.sp = sp;
        if (sp < this.mk) {
            this.mk = this.marks.pop();
        }
        return this.nodes.pop();
    }
    
    Node peekNode() {
        return this.nodes.peek();
    }
    
    int nodeArity() {
        return this.sp - this.mk;
    }
    
    void clearNodeScope(final Node node) {
        while (this.sp > this.mk) {
            this.popNode();
        }
        this.mk = this.marks.pop();
    }
    
    void openNodeScope(final Node node) {
        this.marks.push(new Integer(this.mk));
        this.mk = this.sp;
        node.jjtOpen();
    }
    
    void closeNodeScope(final Node node, int n) {
        this.mk = this.marks.pop();
        while (n-- > 0) {
            final Node popNode = this.popNode();
            popNode.jjtSetParent(node);
            node.jjtAddChild(popNode, n);
        }
        node.jjtClose();
        this.pushNode(node);
        this.node_created = true;
    }
    
    void closeNodeScope(final Node node, final boolean b) {
        if (b) {
            int nodeArity = this.nodeArity();
            this.mk = this.marks.pop();
            while (nodeArity-- > 0) {
                final Node popNode = this.popNode();
                popNode.jjtSetParent(node);
                node.jjtAddChild(popNode, nodeArity);
            }
            node.jjtClose();
            this.pushNode(node);
            this.node_created = true;
        }
        else {
            this.mk = this.marks.pop();
            this.node_created = false;
        }
    }
    
    JJTNLUState() {
        this.nodes = new Stack();
        this.marks = new Stack();
        this.sp = 0;
        this.mk = 0;
    }
}
