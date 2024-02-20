package TemplateCompiler;

import jess.Userfunction;
import jess.Rete;
import jess.Userpackage;

public class MyRules implements Userpackage
{
    public void add(final Rete rete) {
        rete.addUserfunction(new definerule());
        rete.addUserfunction(new undefinerule());
        rete.addUserfunction(new conditionalretract());
        rete.addUserfunction(new MyEquals());
        rete.addUserfunction(new MyGreater());
        rete.addUserfunction(new MyPlus());
    }
}
