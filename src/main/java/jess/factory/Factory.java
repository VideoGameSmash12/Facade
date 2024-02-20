package jess.factory;

import jess.JessException;
import jess.Token;
import jess.Fact;

public interface Factory
{
    Token newToken(final Fact p0, final int p1) throws JessException;
    
    Token newToken(final Token p0, final Fact p1) throws JessException;
    
    Token newToken(final Token p0, final Token p1) throws JessException;
    
    Token newToken(final Token p0) throws JessException;
}
