package TemplateCompiler;

import jess.JessException;
import jess.Activation;
import facade.nativeinterface.NativeAnimationInterface;
import facade.util.StringUtil;
import jess.Fact;
import jess.JessEvent;
import jess.Context;
import jess.JessListener;

public class DebugListener implements JessListener
{
    private Context c;
    private final boolean useEventLog;
    
    private final boolean compilerGeneratedFact(final String s) {
        return s.equals("splat") || s.equals("initial-fact") || s.startsWith("po-") || s.startsWith("occurs-single") || s.startsWith("optoc") || s.startsWith("occurs-or") || s.startsWith("notoccurs-single") || s.startsWith("to-") || s.equals("DefConst") || s.equals("anaphoricRef") || s.equals("postBeatMixinInfo");
    }
    
    public void eventHappened(final JessEvent jessEvent) throws JessException {
        final int type = jessEvent.getType();
        if ((type & 0x10) != 0x0) {
            final Fact fact = (Fact)jessEvent.getObject();
            if (!this.compilerGeneratedFact(fact.getDeftemplate().getBaseName())) {
                final String substring = fact.toString().substring(7);
                if ((type & Integer.MIN_VALUE) == 0x0) {
                    StringUtil.println("==> (" + substring);
                    if (this.useEventLog) {
                        NativeAnimationInterface.addEventInfoToLog("==> (" + substring);
                    }
                }
                else if ((type & Integer.MIN_VALUE) != 0x0) {
                    StringUtil.println("<== (" + substring);
                    if (this.useEventLog) {
                        NativeAnimationInterface.addEventInfoToLog("<== (" + substring);
                    }
                }
            }
        }
        else if (type == 2) {
            final String substring2 = ((Activation)jessEvent.getObject()).getRule().getName().substring(6);
            if (!substring2.startsWith("andtest") && !substring2.startsWith("occurssingletest") && !substring2.startsWith("ortest") && !substring2.startsWith("opttest") && !substring2.startsWith("occursortest")) {
                StringUtil.println("FIRE " + substring2);
                if (this.useEventLog) {
                    NativeAnimationInterface.addEventInfoToLog("FIRE " + substring2);
                }
            }
        }
    }
    
    public DebugListener() {
        this.useEventLog = true;
    }
    
    public DebugListener(final boolean useEventLog) {
        this.useEventLog = useEventLog;
    }
}
