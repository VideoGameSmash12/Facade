package jess;

import java.util.HashMap;
import java.io.Serializable;

class PredFunctions implements IntrinsicPackage, Serializable
{
    private final void addFunction(final Userfunction userfunction, final HashMap hashMap) {
        hashMap.put(userfunction.getName(), userfunction);
    }
    
    public void add(final HashMap hashMap) {
        this.addFunction(new EvenP(), hashMap);
        this.addFunction(new OddP(), hashMap);
        this.addFunction(new TypeP("lexemep", 3), hashMap);
        this.addFunction(new TypeP("numberp", 65572), hashMap);
        this.addFunction(new TypeP("longp", 65536), hashMap);
        this.addFunction(new TypeP("floatp", 32), hashMap);
        this.addFunction(new TypeP("integerp", 4), hashMap);
        this.addFunction(new TypeP("stringp", 2), hashMap);
        this.addFunction(new TypeP("symbolp", 1), hashMap);
        this.addFunction(new TypeP("multifieldp", 512), hashMap);
        this.addFunction(new TypeP("external-addressp", 2048), hashMap);
    }
}
