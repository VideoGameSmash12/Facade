package jess;

import java.util.HashMap;
import java.io.Serializable;

class ViewFunctions implements Userpackage, IntrinsicPackage, Serializable
{
    public void add(final Rete rete) {
        rete.addUserfunction(new View());
        rete.addUserfunction(new Matches());
    }
    
    public void add(final HashMap hashMap) {
        this.addFunction(new View(), hashMap);
        this.addFunction(new Matches(), hashMap);
    }
    
    private final void addFunction(final Userfunction userfunction, final HashMap hashMap) {
        hashMap.put(userfunction.getName(), userfunction);
    }
}
