package TemplateCompiler;

import jess.Rete;
import jess.Main;

public class RuleMain extends Main
{
    public static RefCountRete r;
    
    public static void main(final String[] array) {
        final RuleMain ruleMain = new RuleMain();
        ruleMain.initialize(array, RuleMain.r);
        ruleMain.execute(true);
    }
    
    static {
        RuleMain.r = new RefCountRete();
    }
}
