package wordnet.util;

import java.util.NoSuchElementException;
import java.util.Enumeration;

public class LookaheadEnumeration implements Enumeration
{
    protected Enumeration ground;
    protected boolean peeked;
    protected Object nextObject;
    protected boolean more;
    
    protected void lookahead() {
        if (!this.peeked) {
            this.more = this.ground.hasMoreElements();
            if (this.more) {
                try {
                    this.nextObject = this.ground.nextElement();
                }
                catch (NoSuchElementException ex) {
                    this.more = false;
                }
            }
            this.peeked = true;
        }
    }
    
    public boolean hasMoreElements() {
        this.lookahead();
        return this.more;
    }
    
    public Object nextElement() {
        this.lookahead();
        if (this.more) {
            final Object nextObject = this.nextObject;
            this.nextObject = null;
            this.peeked = false;
            return nextObject;
        }
        throw new NoSuchElementException();
    }

    public LookaheadEnumeration(final Enumeration ground) {
        this.peeked = false;
        this.ground = ground;
    }
}
