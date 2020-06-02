package jess;

import java.io.Serializable;

interface Advice extends Userfunction, Serializable
{
    Userfunction getFunction();
    
    void addAction(final Value p0);
}
