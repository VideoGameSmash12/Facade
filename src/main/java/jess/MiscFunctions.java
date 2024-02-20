package jess;

import java.util.HashMap;
import java.io.Serializable;

class MiscFunctions implements IntrinsicPackage, Serializable
{
    private final void addFunction(final Userfunction userfunction, final HashMap hashMap) {
        hashMap.put(userfunction.getName(), userfunction);
    }
    
    public void add(final HashMap hashMap) {
        this.addFunction(new GetStrategy(), hashMap);
        this.addFunction(new SetStrategy(), hashMap);
        this.addFunction(new JessSocket(), hashMap);
        this.addFunction(new JessFormat(), hashMap);
        this.addFunction(new JessSystem(), hashMap);
        this.addFunction(new LoadPkg(), hashMap);
        this.addFunction(new LoadFn(), hashMap);
        this.addFunction(new Time(), hashMap);
        this.addFunction(new Build("build"), hashMap);
        this.addFunction(new Build("eval"), hashMap);
        this.addFunction(new ListFunctions(), hashMap);
        this.addFunction(new RunQuery(0), hashMap);
        this.addFunction(new RunQuery(1), hashMap);
        this.addFunction(new ShowAgenda(), hashMap);
        this.addFunction(new ListRules(), hashMap);
        this.addFunction(new ListFacts(), hashMap);
        this.addFunction(new ListDeftemplates(), hashMap);
        this.addFunction(new Bits("bit-and"), hashMap);
        this.addFunction(new Bits("bit-or"), hashMap);
        this.addFunction(new Bits("bit-not"), hashMap);
        this.addFunction(new Setgen(), hashMap);
        this.addFunction(new ResetGlobals(0), hashMap);
        this.addFunction(new ResetGlobals(1), hashMap);
        this.addFunction(new EvalSalience(0), hashMap);
        this.addFunction(new EvalSalience(1), hashMap);
        this.addFunction(new SetNodeIndexing(), hashMap);
        this.addFunction(new SetFactory(), hashMap);
        this.addFunction(new JessLong(), hashMap);
        this.addFunction(new CallOnEngine(), hashMap);
        this.addFunction(new MakeFactID(), hashMap);
        this.addFunction(new Asc(), hashMap);
        this.addFunction(new Synchronized(), hashMap);
        this.addFunction(new Dependents(), hashMap);
        this.addFunction(new Dependencies(), hashMap);
    }
}
