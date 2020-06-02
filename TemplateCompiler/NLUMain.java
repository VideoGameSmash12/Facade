package TemplateCompiler;

import java.io.ObjectInputStream;
import java.io.InputStream;
import java.util.zip.InflaterInputStream;
import java.io.FileInputStream;
import jess.JessListener;
import facade.characters.wmedef.PostBeatMixinInfoWME;
import facade.characters.wmedef.AnaphoricReferenceWME;
import jess.Value;
import jess.ValueVector;
import jess.Fact;
import java.util.Collection;
import java.util.HashSet;
import abl.runtime.RuntimeError;
import java.util.Iterator;
import facade.util.StringUtil;
import wm.WME;
import facade.characters.wmedef.UserTestWME;
import facade.characters.wmedef.PlayerRecentlyTypedTextWME;
import facade.nativeinterface.NativeAnimationInterface;
import java.util.LinkedList;
import dramaman.runtime.DramaManager;
import dramaman.runtime.StoryStatusWME;
import jess.JessException;
import wm.WorkingMemory;
import java.util.Hashtable;
import jess.Rete;
import java.util.Set;
import facade.util.FullExpressions;
import facade.util.BeatConstants;

public class NLUMain implements BeatConstants, FullExpressions
{
    private static final Set activeContexts;
    private Rete nluEngine;
    private Hashtable beatNameToTemplateName;
    private Hashtable templateNameToTemplates;
    private TimeOut to;
    private WorkingMemory playerMemory;
    private WorkingMemory tripMemory;
    private WorkingMemory graceMemory;
    private boolean bWaitForGToStartDramaManager;
    private boolean bStartedTheDramaManager;
    private static final /* synthetic */ boolean $noassert;
    
    static void processJessException(final JessException ex) {
        if (ex.getCause() != null) {
            System.out.println(ex.getCause());
        }
        System.out.println(ex.getRoutine() + ' ' + ex.getContext() + ' ' + ex.getProgramText() + ' ' + ex.getData() + ' ' + ex.getLineNumber());
        throw new RuntimeException(ex.getMessage());
    }
    
    private final synchronized void StartTheDramaManager() {
        System.out.println("Starting the drama manager...");
        final LinkedList lookupWME = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME");
        if (!NLUMain.$noassert && lookupWME.size() != 1) {
            throw new AssertionError();
        }
        ((StoryStatusWME)lookupWME.get(0)).setDramaManagerEnabled(true);
        DramaManager.getDramaManager().initializeDramaManagerState();
        DramaManager.getDramaManager().startManaging();
    }
    
    private final synchronized void processPlayerText() {
        final String textSensor = NativeAnimationInterface.textSensor();
        if (textSensor.equals(" ")) {
            final LinkedList lookupWME = this.playerMemory.lookupWME("PlayerRecentlyTypedTextWME");
            if (lookupWME.size() != 0) {
                final PlayerRecentlyTypedTextWME playerRecentlyTypedTextWME = lookupWME.get(0);
                playerRecentlyTypedTextWME.setB(true);
                playerRecentlyTypedTextWME.setTimestamp(System.currentTimeMillis());
            }
        }
        else if (!textSensor.equals("")) {
            final LinkedList lookupWME2 = this.playerMemory.lookupWME("PlayerRecentlyTypedTextWME");
            if (lookupWME2.size() != 0) {
                ((PlayerRecentlyTypedTextWME)lookupWME2.get(0)).setB(false);
            }
            if (this.bWaitForGToStartDramaManager && !this.bStartedTheDramaManager && textSensor.equals("g")) {
                this.bStartedTheDramaManager = true;
                this.StartTheDramaManager();
            }
            else if (textSensor.equals(":g:b:pl")) {
                this.graceMemory.addWME(new UserTestWME(2, 0, 0, 0));
            }
            else if (textSensor.equals(":g:b:sm")) {
                this.graceMemory.addWME(new UserTestWME(2, 1, 0, 0));
            }
            else if (textSensor.equals(":g:b:im")) {
                this.graceMemory.addWME(new UserTestWME(2, 2, 0, 0));
            }
            else if (textSensor.equals(":g:b:ho")) {
                this.graceMemory.addWME(new UserTestWME(2, 3, 0, 0));
            }
            else if (textSensor.equals(":g:b:sk")) {
                this.graceMemory.addWME(new UserTestWME(2, 4, 0, 0));
            }
            else if (textSensor.equals(":g:b:se")) {
                this.graceMemory.addWME(new UserTestWME(2, 5, 0, 0));
            }
            else if (textSensor.equals(":g:b:fr")) {
                this.graceMemory.addWME(new UserTestWME(2, 6, 0, 0));
            }
            else if (textSensor.equals(":g:b:su")) {
                this.graceMemory.addWME(new UserTestWME(2, 7, 0, 0));
            }
            else if (textSensor.equals(":g:b:sh")) {
                this.graceMemory.addWME(new UserTestWME(2, 8, 0, 0));
            }
            else if (textSensor.equals(":g:m:n:b")) {
                this.graceMemory.addWME(new UserTestWME(1, 0, 0, 0));
            }
            else if (textSensor.equals(":g:m:n:l")) {
                this.graceMemory.addWME(new UserTestWME(1, 0, 1, 0));
            }
            else if (textSensor.equals(":g:m:n:m")) {
                this.graceMemory.addWME(new UserTestWME(1, 0, 2, 0));
            }
            else if (textSensor.equals(":g:m:n:h")) {
                this.graceMemory.addWME(new UserTestWME(1, 0, 3, 0));
            }
            else if (textSensor.equals(":g:m:h:b")) {
                this.graceMemory.addWME(new UserTestWME(1, 1, 0, 0));
            }
            else if (textSensor.equals(":g:m:h:l")) {
                this.graceMemory.addWME(new UserTestWME(1, 1, 1, 0));
            }
            else if (textSensor.equals(":g:m:h:m")) {
                this.graceMemory.addWME(new UserTestWME(1, 1, 2, 0));
            }
            else if (textSensor.equals(":g:m:h:h")) {
                this.graceMemory.addWME(new UserTestWME(1, 1, 3, 0));
            }
            else if (textSensor.equals(":g:m:a:b")) {
                this.graceMemory.addWME(new UserTestWME(1, 2, 0, 0));
            }
            else if (textSensor.equals(":g:m:a:l")) {
                this.graceMemory.addWME(new UserTestWME(1, 2, 1, 0));
            }
            else if (textSensor.equals(":g:m:a:m")) {
                this.graceMemory.addWME(new UserTestWME(1, 2, 2, 0));
            }
            else if (textSensor.equals(":g:m:a:h")) {
                this.graceMemory.addWME(new UserTestWME(1, 2, 3, 0));
            }
            else if (textSensor.equals(":g:m:x:b")) {
                this.graceMemory.addWME(new UserTestWME(1, 3, 0, 0));
            }
            else if (textSensor.equals(":g:m:x:l")) {
                this.graceMemory.addWME(new UserTestWME(1, 3, 1, 0));
            }
            else if (textSensor.equals(":g:m:x:m")) {
                this.graceMemory.addWME(new UserTestWME(1, 3, 2, 0));
            }
            else if (textSensor.equals(":g:m:x:h")) {
                this.graceMemory.addWME(new UserTestWME(1, 3, 3, 0));
            }
            else if (textSensor.equals(":g:m:r:b")) {
                this.graceMemory.addWME(new UserTestWME(1, 4, 0, 0));
            }
            else if (textSensor.equals(":g:m:r:l")) {
                this.graceMemory.addWME(new UserTestWME(1, 4, 1, 0));
            }
            else if (textSensor.equals(":g:m:r:m")) {
                this.graceMemory.addWME(new UserTestWME(1, 4, 2, 0));
            }
            else if (textSensor.equals(":g:m:r:h")) {
                this.graceMemory.addWME(new UserTestWME(1, 4, 3, 0));
            }
            else if (textSensor.equals(":g:m:i:b")) {
                this.graceMemory.addWME(new UserTestWME(1, 5, 0, 0));
            }
            else if (textSensor.equals(":g:m:i:l")) {
                this.graceMemory.addWME(new UserTestWME(1, 5, 1, 0));
            }
            else if (textSensor.equals(":g:m:i:m")) {
                this.graceMemory.addWME(new UserTestWME(1, 5, 2, 0));
            }
            else if (textSensor.equals(":g:m:i:h")) {
                this.graceMemory.addWME(new UserTestWME(1, 5, 3, 0));
            }
            else if (textSensor.equals(":g:la:t:s:b")) {
                this.graceMemory.addWME(new UserTestWME(0, 0, 1, 0));
            }
            else if (textSensor.equals(":g:la:t:s:l")) {
                this.graceMemory.addWME(new UserTestWME(0, 0, 1, 1));
            }
            else if (textSensor.equals(":g:la:t:s:m")) {
                this.graceMemory.addWME(new UserTestWME(0, 0, 1, 2));
            }
            else if (textSensor.equals(":g:la:t:s:h")) {
                this.graceMemory.addWME(new UserTestWME(0, 0, 1, 3));
            }
            else if (textSensor.equals(":g:la:t:h:b")) {
                this.graceMemory.addWME(new UserTestWME(0, 0, 2, 0));
            }
            else if (textSensor.equals(":g:la:t:h:l")) {
                this.graceMemory.addWME(new UserTestWME(0, 0, 2, 1));
            }
            else if (textSensor.equals(":g:la:t:h:m")) {
                this.graceMemory.addWME(new UserTestWME(0, 0, 2, 2));
            }
            else if (textSensor.equals(":g:la:t:h:h")) {
                this.graceMemory.addWME(new UserTestWME(0, 0, 2, 3));
            }
            else if (textSensor.equals(":g:la:t:x:b")) {
                this.graceMemory.addWME(new UserTestWME(0, 0, 3, 0));
            }
            else if (textSensor.equals(":g:la:t:x:l")) {
                this.graceMemory.addWME(new UserTestWME(0, 0, 3, 1));
            }
            else if (textSensor.equals(":g:la:t:x:m")) {
                this.graceMemory.addWME(new UserTestWME(0, 0, 3, 2));
            }
            else if (textSensor.equals(":g:la:t:x:h")) {
                this.graceMemory.addWME(new UserTestWME(0, 0, 3, 3));
            }
            else if (textSensor.equals(":g:la:t:a:b")) {
                this.graceMemory.addWME(new UserTestWME(0, 0, 4, 0));
            }
            else if (textSensor.equals(":g:la:t:a:l")) {
                this.graceMemory.addWME(new UserTestWME(0, 0, 4, 1));
            }
            else if (textSensor.equals(":g:la:t:a:m")) {
                this.graceMemory.addWME(new UserTestWME(0, 0, 4, 2));
            }
            else if (textSensor.equals(":g:la:t:a:h")) {
                this.graceMemory.addWME(new UserTestWME(0, 0, 4, 3));
            }
            else if (textSensor.equals(":g:la:t:i:b")) {
                this.graceMemory.addWME(new UserTestWME(0, 0, 5, 0));
            }
            else if (textSensor.equals(":g:la:t:i:l")) {
                this.graceMemory.addWME(new UserTestWME(0, 0, 5, 1));
            }
            else if (textSensor.equals(":g:la:t:i:m")) {
                this.graceMemory.addWME(new UserTestWME(0, 0, 5, 2));
            }
            else if (textSensor.equals(":g:la:t:i:h")) {
                this.graceMemory.addWME(new UserTestWME(0, 0, 5, 3));
            }
            else if (textSensor.equals(":g:la:r:s:b")) {
                this.graceMemory.addWME(new UserTestWME(0, 1, 1, 0));
            }
            else if (textSensor.equals(":g:la:r:s:l")) {
                this.graceMemory.addWME(new UserTestWME(0, 1, 1, 1));
            }
            else if (textSensor.equals(":g:la:r:s:m")) {
                this.graceMemory.addWME(new UserTestWME(0, 1, 1, 2));
            }
            else if (textSensor.equals(":g:la:r:s:h")) {
                this.graceMemory.addWME(new UserTestWME(0, 1, 1, 3));
            }
            else if (textSensor.equals(":g:la:r:h:b")) {
                this.graceMemory.addWME(new UserTestWME(0, 1, 2, 0));
            }
            else if (textSensor.equals(":g:la:r:h:l")) {
                this.graceMemory.addWME(new UserTestWME(0, 1, 2, 1));
            }
            else if (textSensor.equals(":g:la:r:h:m")) {
                this.graceMemory.addWME(new UserTestWME(0, 1, 2, 2));
            }
            else if (textSensor.equals(":g:la:r:h:h")) {
                this.graceMemory.addWME(new UserTestWME(0, 1, 2, 3));
            }
            else if (textSensor.equals(":g:la:r:x:b")) {
                this.graceMemory.addWME(new UserTestWME(0, 1, 3, 0));
            }
            else if (textSensor.equals(":g:la:r:x:l")) {
                this.graceMemory.addWME(new UserTestWME(0, 1, 3, 1));
            }
            else if (textSensor.equals(":g:la:r:x:m")) {
                this.graceMemory.addWME(new UserTestWME(0, 1, 3, 2));
            }
            else if (textSensor.equals(":g:la:r:x:h")) {
                this.graceMemory.addWME(new UserTestWME(0, 1, 3, 3));
            }
            else if (textSensor.equals(":g:la:r:a:b")) {
                this.graceMemory.addWME(new UserTestWME(0, 1, 4, 0));
            }
            else if (textSensor.equals(":g:la:r:a:l")) {
                this.graceMemory.addWME(new UserTestWME(0, 1, 4, 1));
            }
            else if (textSensor.equals(":g:la:r:a:m")) {
                this.graceMemory.addWME(new UserTestWME(0, 1, 4, 2));
            }
            else if (textSensor.equals(":g:la:r:a:h")) {
                this.graceMemory.addWME(new UserTestWME(0, 1, 4, 3));
            }
            else if (textSensor.equals(":g:la:r:i:b")) {
                this.graceMemory.addWME(new UserTestWME(0, 1, 5, 0));
            }
            else if (textSensor.equals(":g:la:r:i:l")) {
                this.graceMemory.addWME(new UserTestWME(0, 1, 5, 1));
            }
            else if (textSensor.equals(":g:la:r:i:m")) {
                this.graceMemory.addWME(new UserTestWME(0, 1, 5, 2));
            }
            else if (textSensor.equals(":g:la:r:i:h")) {
                this.graceMemory.addWME(new UserTestWME(0, 1, 5, 3));
            }
            else if (textSensor.equals(":t:b:pl")) {
                this.tripMemory.addWME(new UserTestWME(2, 0, 0, 0));
            }
            else if (textSensor.equals(":t:b:sm")) {
                this.tripMemory.addWME(new UserTestWME(2, 1, 0, 0));
            }
            else if (textSensor.equals(":t:b:im")) {
                this.tripMemory.addWME(new UserTestWME(2, 2, 0, 0));
            }
            else if (textSensor.equals(":t:b:ho")) {
                this.tripMemory.addWME(new UserTestWME(2, 3, 0, 0));
            }
            else if (textSensor.equals(":t:b:sk")) {
                this.tripMemory.addWME(new UserTestWME(2, 4, 0, 0));
            }
            else if (textSensor.equals(":t:b:se")) {
                this.tripMemory.addWME(new UserTestWME(2, 5, 0, 0));
            }
            else if (textSensor.equals(":t:b:fr")) {
                this.tripMemory.addWME(new UserTestWME(2, 6, 0, 0));
            }
            else if (textSensor.equals(":t:b:su")) {
                this.tripMemory.addWME(new UserTestWME(2, 7, 0, 0));
            }
            else if (textSensor.equals(":t:b:sh")) {
                this.tripMemory.addWME(new UserTestWME(2, 8, 0, 0));
            }
            else if (textSensor.equals(":t:m:n:b")) {
                this.tripMemory.addWME(new UserTestWME(1, 0, 0, 0));
            }
            else if (textSensor.equals(":t:m:n:l")) {
                this.tripMemory.addWME(new UserTestWME(1, 0, 1, 0));
            }
            else if (textSensor.equals(":t:m:n:m")) {
                this.tripMemory.addWME(new UserTestWME(1, 0, 2, 0));
            }
            else if (textSensor.equals(":t:m:n:h")) {
                this.tripMemory.addWME(new UserTestWME(1, 0, 3, 0));
            }
            else if (textSensor.equals(":t:m:h:b")) {
                this.tripMemory.addWME(new UserTestWME(1, 1, 0, 0));
            }
            else if (textSensor.equals(":t:m:h:l")) {
                this.tripMemory.addWME(new UserTestWME(1, 1, 1, 0));
            }
            else if (textSensor.equals(":t:m:h:m")) {
                this.tripMemory.addWME(new UserTestWME(1, 1, 2, 0));
            }
            else if (textSensor.equals(":t:m:h:h")) {
                this.tripMemory.addWME(new UserTestWME(1, 1, 3, 0));
            }
            else if (textSensor.equals(":t:m:a:b")) {
                this.tripMemory.addWME(new UserTestWME(1, 2, 0, 0));
            }
            else if (textSensor.equals(":t:m:a:l")) {
                this.tripMemory.addWME(new UserTestWME(1, 2, 1, 0));
            }
            else if (textSensor.equals(":t:m:a:m")) {
                this.tripMemory.addWME(new UserTestWME(1, 2, 2, 0));
            }
            else if (textSensor.equals(":t:m:a:h")) {
                this.tripMemory.addWME(new UserTestWME(1, 2, 3, 0));
            }
            else if (textSensor.equals(":t:m:x:b")) {
                this.tripMemory.addWME(new UserTestWME(1, 3, 0, 0));
            }
            else if (textSensor.equals(":t:m:x:l")) {
                this.tripMemory.addWME(new UserTestWME(1, 3, 1, 0));
            }
            else if (textSensor.equals(":t:m:x:m")) {
                this.tripMemory.addWME(new UserTestWME(1, 3, 2, 0));
            }
            else if (textSensor.equals(":t:m:x:h")) {
                this.tripMemory.addWME(new UserTestWME(1, 3, 3, 0));
            }
            else if (textSensor.equals(":t:m:r:b")) {
                this.tripMemory.addWME(new UserTestWME(1, 4, 0, 0));
            }
            else if (textSensor.equals(":t:m:r:l")) {
                this.tripMemory.addWME(new UserTestWME(1, 4, 1, 0));
            }
            else if (textSensor.equals(":t:m:r:m")) {
                this.tripMemory.addWME(new UserTestWME(1, 4, 2, 0));
            }
            else if (textSensor.equals(":t:m:r:h")) {
                this.tripMemory.addWME(new UserTestWME(1, 4, 3, 0));
            }
            else if (textSensor.equals(":t:m:i:b")) {
                this.tripMemory.addWME(new UserTestWME(1, 5, 0, 0));
            }
            else if (textSensor.equals(":t:m:i:l")) {
                this.tripMemory.addWME(new UserTestWME(1, 5, 1, 0));
            }
            else if (textSensor.equals(":t:m:i:m")) {
                this.tripMemory.addWME(new UserTestWME(1, 5, 2, 0));
            }
            else if (textSensor.equals(":t:m:i:h")) {
                this.tripMemory.addWME(new UserTestWME(1, 5, 3, 0));
            }
            else if (textSensor.equals(":t:la:t:s:b")) {
                this.tripMemory.addWME(new UserTestWME(0, 0, 1, 0));
            }
            else if (textSensor.equals(":t:la:t:s:l")) {
                this.tripMemory.addWME(new UserTestWME(0, 0, 1, 1));
            }
            else if (textSensor.equals(":t:la:t:s:m")) {
                this.tripMemory.addWME(new UserTestWME(0, 0, 1, 2));
            }
            else if (textSensor.equals(":t:la:t:s:h")) {
                this.tripMemory.addWME(new UserTestWME(0, 0, 1, 3));
            }
            else if (textSensor.equals(":t:la:t:h:b")) {
                this.tripMemory.addWME(new UserTestWME(0, 0, 2, 0));
            }
            else if (textSensor.equals(":t:la:t:h:l")) {
                this.tripMemory.addWME(new UserTestWME(0, 0, 2, 1));
            }
            else if (textSensor.equals(":t:la:t:h:m")) {
                this.tripMemory.addWME(new UserTestWME(0, 0, 2, 2));
            }
            else if (textSensor.equals(":t:la:t:h:h")) {
                this.tripMemory.addWME(new UserTestWME(0, 0, 2, 3));
            }
            else if (textSensor.equals(":t:la:t:x:b")) {
                this.tripMemory.addWME(new UserTestWME(0, 0, 3, 0));
            }
            else if (textSensor.equals(":t:la:t:x:l")) {
                this.tripMemory.addWME(new UserTestWME(0, 0, 3, 1));
            }
            else if (textSensor.equals(":t:la:t:x:m")) {
                this.tripMemory.addWME(new UserTestWME(0, 0, 3, 2));
            }
            else if (textSensor.equals(":t:la:t:x:h")) {
                this.tripMemory.addWME(new UserTestWME(0, 0, 3, 3));
            }
            else if (textSensor.equals(":t:la:t:a:b")) {
                this.tripMemory.addWME(new UserTestWME(0, 0, 4, 0));
            }
            else if (textSensor.equals(":t:la:t:a:l")) {
                this.tripMemory.addWME(new UserTestWME(0, 0, 4, 1));
            }
            else if (textSensor.equals(":t:la:t:a:m")) {
                this.tripMemory.addWME(new UserTestWME(0, 0, 4, 2));
            }
            else if (textSensor.equals(":t:la:t:a:h")) {
                this.tripMemory.addWME(new UserTestWME(0, 0, 4, 3));
            }
            else if (textSensor.equals(":t:la:t:i:b")) {
                this.tripMemory.addWME(new UserTestWME(0, 0, 5, 0));
            }
            else if (textSensor.equals(":t:la:t:i:l")) {
                this.tripMemory.addWME(new UserTestWME(0, 0, 5, 1));
            }
            else if (textSensor.equals(":t:la:t:i:m")) {
                this.tripMemory.addWME(new UserTestWME(0, 0, 5, 2));
            }
            else if (textSensor.equals(":t:la:t:i:h")) {
                this.tripMemory.addWME(new UserTestWME(0, 0, 5, 3));
            }
            else if (textSensor.equals(":t:la:r:s:b")) {
                this.tripMemory.addWME(new UserTestWME(0, 1, 1, 0));
            }
            else if (textSensor.equals(":t:la:r:s:l")) {
                this.tripMemory.addWME(new UserTestWME(0, 1, 1, 1));
            }
            else if (textSensor.equals(":t:la:r:s:m")) {
                this.tripMemory.addWME(new UserTestWME(0, 1, 1, 2));
            }
            else if (textSensor.equals(":t:la:r:s:h")) {
                this.tripMemory.addWME(new UserTestWME(0, 1, 1, 3));
            }
            else if (textSensor.equals(":t:la:r:h:b")) {
                this.tripMemory.addWME(new UserTestWME(0, 1, 2, 0));
            }
            else if (textSensor.equals(":t:la:r:h:l")) {
                this.tripMemory.addWME(new UserTestWME(0, 1, 2, 1));
            }
            else if (textSensor.equals(":t:la:r:h:m")) {
                this.tripMemory.addWME(new UserTestWME(0, 1, 2, 2));
            }
            else if (textSensor.equals(":t:la:r:h:h")) {
                this.tripMemory.addWME(new UserTestWME(0, 1, 2, 3));
            }
            else if (textSensor.equals(":t:la:r:x:b")) {
                this.tripMemory.addWME(new UserTestWME(0, 1, 3, 0));
            }
            else if (textSensor.equals(":t:la:r:x:l")) {
                this.tripMemory.addWME(new UserTestWME(0, 1, 3, 1));
            }
            else if (textSensor.equals(":t:la:r:x:m")) {
                this.tripMemory.addWME(new UserTestWME(0, 1, 3, 2));
            }
            else if (textSensor.equals(":t:la:r:x:h")) {
                this.tripMemory.addWME(new UserTestWME(0, 1, 3, 3));
            }
            else if (textSensor.equals(":t:la:r:a:b")) {
                this.tripMemory.addWME(new UserTestWME(0, 1, 4, 0));
            }
            else if (textSensor.equals(":t:la:r:a:l")) {
                this.tripMemory.addWME(new UserTestWME(0, 1, 4, 1));
            }
            else if (textSensor.equals(":t:la:r:a:m")) {
                this.tripMemory.addWME(new UserTestWME(0, 1, 4, 2));
            }
            else if (textSensor.equals(":t:la:r:a:h")) {
                this.tripMemory.addWME(new UserTestWME(0, 1, 4, 3));
            }
            else if (textSensor.equals(":t:la:r:i:b")) {
                this.tripMemory.addWME(new UserTestWME(0, 1, 5, 0));
            }
            else if (textSensor.equals(":t:la:r:i:l")) {
                this.tripMemory.addWME(new UserTestWME(0, 1, 5, 1));
            }
            else if (textSensor.equals(":t:la:r:i:m")) {
                this.tripMemory.addWME(new UserTestWME(0, 1, 5, 2));
            }
            else if (textSensor.equals(":t:la:r:i:h")) {
                this.tripMemory.addWME(new UserTestWME(0, 1, 5, 3));
            }
            else if (textSensor.equals("q") || textSensor.equals("qabl")) {
                Runtime.getRuntime().exit(0);
            }
            else if (!textSensor.startsWith(":")) {
                StringUtil.println("");
                StringUtil.println("PLAYER");
                StringUtil.println(textSensor);
                StringUtil.println("");
                final LinkedList lookupWME3 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME");
                if (lookupWME3.size() != 0) {
                    ((StoryStatusWME)lookupWME3.get(0)).setNLPProcessingStarted(System.currentTimeMillis());
                    System.out.println("## Starting NLP at " + System.currentTimeMillis());
                }
                else {
                    System.out.println("## Error: processPlayerText() in NLUMain.java can't find StoryStatusWME");
                }
                try {
                    this.nluEngine.reset();
                    Preprocessor.Process(textSensor, this.nluEngine);
                    final Iterator<String> iterator = NLUMain.activeContexts.iterator();
                    while (iterator.hasNext()) {
                        this.nluEngine.executeCommand("(assert (activeContext " + iterator.next() + "))");
                    }
                    this.nluEngine.run();
                    this.nluEngine.halt();
                }
                catch (JessException ex) {
                    JessExceptionHelper.processJessException(ex);
                }
                try {
                    this.to.UttSweep(this.nluEngine);
                }
                catch (JessException ex2) {
                    JessExceptionHelper.processJessException(ex2);
                }
            }
        }
        else if (textSensor.equals("")) {
            final LinkedList lookupWME4 = this.playerMemory.lookupWME("PlayerRecentlyTypedTextWME");
            if (lookupWME4.size() != 0) {
                final PlayerRecentlyTypedTextWME playerRecentlyTypedTextWME2 = lookupWME4.get(0);
                if (playerRecentlyTypedTextWME2.getB() && System.currentTimeMillis() - playerRecentlyTypedTextWME2.getTimestamp() > 5000L) {
                    playerRecentlyTypedTextWME2.setB(false);
                }
            }
        }
    }
    
    public final void startNLU() {
        this.playerMemory = WorkingMemory.lookupRegisteredMemory("PlayerMemory");
        this.tripMemory = WorkingMemory.lookupRegisteredMemory("TripMemory");
        this.graceMemory = WorkingMemory.lookupRegisteredMemory("GraceMemory");
        if (!this.bWaitForGToStartDramaManager && !this.bStartedTheDramaManager) {
            this.bStartedTheDramaManager = true;
            this.StartTheDramaManager();
        }
        while (true) {
            this.processPlayerText();
            try {
                Thread.currentThread();
                Thread.sleep(300L);
            }
            catch (InterruptedException ex) {
                throw new RuntimeError("Sleep interrupted " + ex);
            }
        }
    }
    
    public static final synchronized void activateContext(final String s) {
        NLUMain.activeContexts.add(s);
    }
    
    public static final synchronized void deactivateContext(final String s) {
        NLUMain.activeContexts.remove(s);
    }
    
    public static final synchronized void deactivateAllContexts() {
        NLUMain.activeContexts.clear();
    }
    
    public static final synchronized void deactivateAllContextsExcept(final String s) {
        for (final String s2 : NLUMain.activeContexts) {
            if (!s2.equals(s)) {
                NLUMain.activeContexts.remove(s2);
            }
        }
    }
    
    public static final synchronized boolean isContextActive(final String s) {
        final Iterator<String> iterator = NLUMain.activeContexts.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(s)) {
                return true;
            }
        }
        return false;
    }
    
    public void SwitchBeat(final String s, final String s2) throws JessException {
        final HashSet<?> set = this.beatNameToTemplateName.get(s);
        final HashSet<?> set2 = this.beatNameToTemplateName.get(s2);
        final HashSet<String> set3 = (HashSet<String>)set.clone();
        set3.removeAll(set2);
        final HashSet set4 = (HashSet)set2.clone();
        set4.removeAll(set);
        final Iterator<String> iterator = set3.iterator();
        while (iterator.hasNext()) {
            final Fact fact = new Fact("RETRACT" + iterator.next(), this.nluEngine);
            fact.setSlotValue("__data", new Value(new ValueVector(), 512));
            this.nluEngine.assertFact(fact);
        }
        this.nluEngine.run();
        final Iterator<Object> iterator2 = set4.iterator();
        while (iterator2.hasNext()) {
            ((RefCountRete)this.nluEngine).executeCommands((String)this.templateNameToTemplates.get(iterator2.next()));
        }
        this.to.BeatSweep(this.nluEngine);
    }
    
    private final /* synthetic */ void this() {
        this.bWaitForGToStartDramaManager = false;
        this.bStartedTheDramaManager = false;
    }
    
    public NLUMain(final String s, final String s2, final String s3, final AnaphoricReferenceWME anaphoricReferenceWME, final PostBeatMixinInfoWME postBeatMixinInfoWME) {
        this(s, s2, s3);
        try {
            this.nluEngine.store("__factKey", "anaphoricRef");
            this.nluEngine.store("__wmeKey", anaphoricReferenceWME);
            this.nluEngine.executeCommand("(shadowWME __factKey __wmeKey)");
            this.nluEngine.store("__factKey", "postBeatMixinInfo");
            this.nluEngine.store("__wmeKey", postBeatMixinInfoWME);
            this.nluEngine.executeCommand("(shadowWME __factKey __wmeKey)");
        }
        catch (JessException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public NLUMain(final String s, final String s2, final String s3) {
        this.this();
        this.nluEngine = new RefCountRete();
        this.to = new TimeOut(this.nluEngine);
        this.nluEngine.addJessListener(new DebugListener());
        this.nluEngine.addJessListener(new FactListener(this.to));
        this.nluEngine.setEventMask(this.nluEngine.getEventMask() | 0x10 | 0x2 | 0x1000 | 0x4000);
        try {
            final FileInputStream fileInputStream = new FileInputStream(s);
            final ObjectInputStream objectInputStream = new ObjectInputStream(new InflaterInputStream(fileInputStream));
            System.out.println("Reading Templates...");
            this.templateNameToTemplates = (Hashtable)objectInputStream.readObject();
            fileInputStream.close();
            final FileInputStream fileInputStream2 = new FileInputStream(s2);
            final ObjectInputStream objectInputStream2 = new ObjectInputStream(new InflaterInputStream(fileInputStream2));
            System.out.println("Reading Mappings...");
            this.beatNameToTemplateName = (Hashtable)objectInputStream2.readObject();
            fileInputStream2.close();
        }
        catch (Exception ex) {
            throw new RuntimeError("NLU: While loading objects " + ex);
        }
        final HashSet<Object> set = this.beatNameToTemplateName.get(s3);
        final HashSet<String> set2 = this.templateNameToTemplates.get("_CONST");
        final Iterator<Object> iterator = set.iterator();
        final Iterator<String> iterator2 = set2.iterator();
        try {
            Preprocessor.initializeReteEngine(this.nluEngine);
            System.out.println("Reading template rules...");
            int n = -1;
            while (iterator.hasNext()) {
                ((RefCountRete)this.nluEngine).executeCommands((String)this.templateNameToTemplates.get(iterator.next()));
                if (++n % 10 == 0) {
                    System.out.print(new StringBuffer().append(n).append(' ').toString());
                }
            }
            System.out.println(n + " done");
            System.out.println("Unique Rules: " + ((RefCountRete)this.nluEngine).getUniqueRules());
            System.out.println("Shared refs to unique rules: " + ((RefCountRete)this.nluEngine).getSharedRuleRefs());
            System.out.println("Redefined shared rules (because of salience): " + ((RefCountRete)this.nluEngine).getRedefinedRules());
            System.out.println("Loading Constants...");
            while (iterator2.hasNext()) {
                this.nluEngine.executeCommand(iterator2.next());
            }
            System.out.println("NLU is started");
        }
        catch (JessException ex2) {
            JessExceptionHelper.processJessException(ex2);
        }
    }
    
    static {
        $noassert = (Class.forName("[LTemplateCompiler.NLUMain;").getComponentType().desiredAssertionStatus() ^ true);
        activeContexts = new HashSet();
    }
}
