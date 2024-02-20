package jess;

import java.util.HashMap;
import java.io.Serializable;

class MultiFunctions implements IntrinsicPackage, Serializable
{
    private final void addFunction(final Userfunction userfunction, final HashMap hashMap) {
        hashMap.put(userfunction.getName(), userfunction);
    }
    
    public void add(final HashMap hashMap) {
        this.addFunction(new CreateMF(), hashMap);
        this.addFunction(new DeleteMF(), hashMap);
        this.addFunction(new ExplodeMF(), hashMap);
        this.addFunction(new FirstMF(), hashMap);
        this.addFunction(new ImplodeMF(), hashMap);
        this.addFunction(new InsertMF(), hashMap);
        this.addFunction(new LengthMF(), hashMap);
        this.addFunction(new MemberMF(), hashMap);
        this.addFunction(new NthMF(), hashMap);
        this.addFunction(new ReplaceMF(), hashMap);
        this.addFunction(new RestMF(), hashMap);
        this.addFunction(new SubseqMF(), hashMap);
        this.addFunction(new SubsetP(), hashMap);
        this.addFunction(new Union(), hashMap);
        this.addFunction(new Intersection(), hashMap);
        this.addFunction(new Complement(), hashMap);
    }
}
