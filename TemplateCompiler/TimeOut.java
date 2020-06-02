package TemplateCompiler;

import java.util.TimerTask;
import java.util.Timer;
import jess.JessException;
import java.util.Enumeration;
import jess.Rete;
import java.util.Vector;

public class TimeOut
{
    private Vector BeatTimeouts;
    private Vector SecondTimeouts;
    private Vector UttTimeouts;
    private Rete r;
    
    public void addnew(final String name, final int value, final int n) {
        final TimeOutObject timeOutObject = new TimeOutObject();
        timeOutObject.name = name;
        timeOutObject.value = value;
        switch (n) {
            case 10: {
                this.UttTimeouts.add(timeOutObject);
            }
            case 7: {
                this.SecondTimeouts.add(timeOutObject);
            }
            case 4: {
                this.BeatTimeouts.add(timeOutObject);
                break;
            }
        }
    }
    
    public void UttSweep(final Rete rete) throws JessException {
        final Enumeration<TimeOutObject> elements = (Enumeration<TimeOutObject>)this.UttTimeouts.elements();
        while (elements.hasMoreElements()) {
            final TimeOutObject timeOutObject2;
            final TimeOutObject timeOutObject = timeOutObject2 = elements.nextElement();
            --timeOutObject2.value;
            if (timeOutObject.value == 0) {
                rete.executeCommand("(assert (RETRACT" + timeOutObject.name + "))");
                rete.executeCommand("(undefrule " + timeOutObject.name + ')');
                rete.run();
                rete.reset();
                this.UttTimeouts.remove(timeOutObject);
            }
        }
    }
    
    public void BeatSweep(final Rete rete) throws JessException {
        final Enumeration<TimeOutObject> elements = (Enumeration<TimeOutObject>)this.BeatTimeouts.elements();
        while (elements.hasMoreElements()) {
            final TimeOutObject timeOutObject2;
            final TimeOutObject timeOutObject = timeOutObject2 = elements.nextElement();
            --timeOutObject2.value;
            if (timeOutObject.value == 0) {
                rete.executeCommand("(assert (RETRACT" + timeOutObject.name + "))");
                rete.executeCommand("(undefrule " + timeOutObject.name + ')');
                rete.run();
                rete.reset();
                this.BeatTimeouts.remove(timeOutObject);
            }
        }
    }
    
    private final /* synthetic */ void this() {
        this.BeatTimeouts = new Vector();
        this.SecondTimeouts = new Vector();
        this.UttTimeouts = new Vector();
    }
    
    public TimeOut(final Rete r) {
        this.this();
        this.r = r;
        new Timer().schedule(new TimeSweepThread(), 1000L, 1000L);
    }
    
    protected class TimeOutObject
    {
        public String name;
        public int value;
    }
    
    public class TimeSweepThread extends TimerTask
    {
        public void run() {
            final Enumeration<TimeOutObject> elements = (Enumeration<TimeOutObject>)TimeOut.this.SecondTimeouts.elements();
            while (elements.hasMoreElements()) {
                final TimeOutObject timeOutObject2;
                final TimeOutObject timeOutObject = timeOutObject2 = elements.nextElement();
                --timeOutObject2.value;
                if (timeOutObject.value == 0) {
                    try {
                        TimeOut.this.r.executeCommand("(assert (RETRACT" + timeOutObject.name + "))");
                        TimeOut.this.r.executeCommand("(undefrule " + timeOutObject.name + ')');
                        TimeOut.this.r.run();
                        TimeOut.this.r.reset();
                        TimeOut.this.SecondTimeouts.remove(timeOutObject);
                    }
                    catch (JessException ex) {
                        JessExceptionHelper.processJessException(ex);
                    }
                }
            }
        }
    }
}
