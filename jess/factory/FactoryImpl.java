package jess.factory;

import jess.JessException;
import jess.Token;
import jess.Fact;
import java.io.Serializable;

public class FactoryImpl implements Factory, Serializable
{
    public Token newToken(final Fact fact, final int n) throws JessException {
        return new Token(fact, n);
    }
    
    public Token newToken(final Token token, final Fact fact) throws JessException {
        return new Token(token, fact);
    }
    
    public Token newToken(final Token token, final Token token2) throws JessException {
        return new Token(token, token2);
    }
    
    public Token newToken(final Token token) throws JessException {
        return new Token(token);
    }
}
