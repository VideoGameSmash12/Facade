package jess;

import java.util.EventListener;

public interface JessListener extends EventListener
{
    void eventHappened(final JessEvent p0) throws JessException;
}
