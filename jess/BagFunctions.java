package jess;

import java.util.HashMap;
import java.io.Serializable;

class BagFunctions implements Userpackage, IntrinsicPackage, Serializable
{
    public void add(final Rete rete) {
        rete.addUserfunction(new Bag());
    }
    
    public void add(final HashMap hashMap) {
        hashMap.put("bag", new Bag());
    }
}
