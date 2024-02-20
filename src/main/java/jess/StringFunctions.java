package jess;

import java.util.HashMap;
import java.io.Serializable;

class StringFunctions implements IntrinsicPackage, Serializable
{
    private final void addFunction(final Userfunction userfunction, final HashMap hashMap) {
        hashMap.put(userfunction.getName(), userfunction);
    }
    
    public void add(final HashMap hashMap) {
        this.addFunction(new StrCat(), hashMap);
        this.addFunction(new StrCompare(), hashMap);
        this.addFunction(new StrIndex(), hashMap);
        this.addFunction(new SubString(), hashMap);
        this.addFunction(new StrSimple(0), hashMap);
        this.addFunction(new StrSimple(1), hashMap);
        this.addFunction(new StrSimple(2), hashMap);
    }
}
