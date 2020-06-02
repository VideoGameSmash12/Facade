package abl.runtime;

import java.util.EventListener;

public interface AblListener extends EventListener
{
    void eventHappened(final AblEvent p0);
}
