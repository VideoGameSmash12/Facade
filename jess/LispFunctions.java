package jess;

import java.util.HashMap;
import java.io.Serializable;

class LispFunctions implements IntrinsicPackage, Serializable
{
    private final void addFunction(final Userfunction userfunction, final HashMap hashMap) {
        hashMap.put(userfunction.getName(), userfunction);
    }
    
    public void add(final HashMap hashMap) {
        this.addFunction(new Progn(), hashMap);
        this.addFunction(new Apply(), hashMap);
    }
}
