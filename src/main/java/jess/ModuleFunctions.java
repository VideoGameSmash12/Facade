package jess;

import java.util.HashMap;
import java.io.Serializable;

class ModuleFunctions implements IntrinsicPackage, Serializable
{
    private final void addFunction(final Userfunction userfunction, final HashMap hashMap) {
        hashMap.put(userfunction.getName(), userfunction);
    }
    
    public void add(final HashMap hashMap) {
        this.addFunction(new SetFocus(), hashMap);
        this.addFunction(new GetFocus(), hashMap);
        this.addFunction(new SetCurrentModule(), hashMap);
        this.addFunction(new GetCurrentModule(), hashMap);
        this.addFunction(new ListFocusStack(), hashMap);
        this.addFunction(new GetFocusStack(), hashMap);
        this.addFunction(new ClearFocusStack(), hashMap);
        this.addFunction(new PopFocus(), hashMap);
    }
}
