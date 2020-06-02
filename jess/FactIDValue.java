package jess;

import java.io.Serializable;

public class FactIDValue extends Value implements Serializable
{
    public FactIDValue(final Fact fact) throws JessException {
        super(fact);
    }
}
