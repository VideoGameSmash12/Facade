package jess;

import java.util.HashMap;
import java.io.Serializable;

class MathFunctions implements IntrinsicPackage, Serializable
{
    private final void addFunction(final Userfunction userfunction, final HashMap hashMap) {
        hashMap.put(userfunction.getName(), userfunction);
    }
    
    public void add(final HashMap hashMap) {
        this.addFunction(new Abs(), hashMap);
        this.addFunction(new Div(), hashMap);
        this.addFunction(new JessFloat(), hashMap);
        this.addFunction(new JessInteger(), hashMap);
        this.addFunction(new Max(), hashMap);
        this.addFunction(new Min(), hashMap);
        this.addFunction(new Expt(), hashMap);
        this.addFunction(new Exp(), hashMap);
        this.addFunction(new Log(), hashMap);
        this.addFunction(new Log10(), hashMap);
        this.addFunction(new Constant("pi", 3.141592653589793), hashMap);
        this.addFunction(new Constant("e", 2.718281828459045), hashMap);
        this.addFunction(new Round(), hashMap);
        this.addFunction(new Sqrt(), hashMap);
        this.addFunction(new JessRandom(), hashMap);
    }
}
