package nlu.reaction;

import java.util.Iterator;
import java.util.LinkedList;
import jess.JessListener;
import facade.characters.wmedef.PostBeatMixinInfoWME;
import facade.characters.wmedef.PatternCountWME;
import facade.characters.wmedef.PlayerInfoWME;
import facade.characters.wmedef.TopicReferenceCountWME;
import facade.characters.wmedef.RxnDeciderMiscWME;
import facade.characters.wmedef.RxnCategoryLevelWME;
import facade.characters.wmedef.PushTooFarReactionInfoWME;
import facade.characters.wmedef.DAReactionInfoWME;
import facade.characters.wmedef.SatelliteReactionInfoWME;
import facade.characters.wmedef.ObjectReactionInfoWME;
import java.util.Enumeration;
import facade.util.StringUtil;
import facade.nativeinterface.NativeAnimationInterface;
import java.util.List;
import facade.characters.wmedef.DAWME;
import wm.WME;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.OutputStream;
import java.util.zip.DeflaterOutputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.zip.InflaterInputStream;
import java.io.FileInputStream;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import jess.JessException;
import java.io.IOException;
import java.io.File;
import java.util.HashSet;
import java.util.Hashtable;
import wm.WorkingMemory;
import jess.Rete;
import facade.util.BeatID;
import facade.util.SpriteID;
import dramaman.runtime.DramaManagerConstants;
import facade.util.DAType;
import facade.util.ReactionID;

public class ReactionDecider implements ReactionID, DAType, DramaManagerConstants, SpriteID, BeatID
{
    private final Rete engine;
    private final WorkingMemory storyMemory;
    private final Hashtable activeContexts;
    private final HashSet activeReactionPriorityMaps;
    private String activeContextPriorityMap;
    private String activeSelector;
    private int centricCharID;
    private static final /* synthetic */ boolean $noassert;
    
    private final void readAndExecute(final String s) throws IOException, JessException {
        final File file = new File(s + ".jess");
        final File file2 = new File(s + ".bin");
        if (file.exists() && file2.exists()) {
            if (file.lastModified() > file2.lastModified()) {
                final String jessFile = this.readJessFile(file);
                this.engine.executeCommand(jessFile);
                this.writeBinFile(file2, jessFile);
            }
            else {
                this.engine.executeCommand(this.readBinFile(file2));
            }
        }
        else if (file.exists() && !file2.exists()) {
            final String jessFile2 = this.readJessFile(file);
            this.engine.executeCommand(jessFile2);
            this.writeBinFile(file2, jessFile2);
        }
        else {
            if (file.exists() || !file2.exists()) {
                System.out.println("No .jess or .bin file found for " + s);
                throw new RuntimeException("No .jess or .bin file found for " + s);
            }
            this.engine.executeCommand(this.readBinFile(file2));
        }
    }
    
    private final String readJessFile(final File file) throws IOException {
        System.out.println("Reading " + file.getName());
        final BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        final StringBuffer sb = new StringBuffer(50000);
        while (bufferedReader.ready()) {
            final char[] array = new char[10000];
            final int read = bufferedReader.read(array);
            if (!ReactionDecider.$noassert && read == -1) {
                throw new AssertionError();
            }
            sb.append(array);
        }
        bufferedReader.close();
        return sb.toString();
    }
    
    private final String readBinFile(final File file) throws IOException {
        System.out.println("Reading " + file.getName());
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new InflaterInputStream(new FileInputStream(file))));
        final StringBuffer sb = new StringBuffer(50000);
        while (bufferedReader.ready()) {
            final char[] array = new char[10000];
            if (bufferedReader.read(array) != -1) {
                sb.append(array);
            }
        }
        bufferedReader.close();
        return sb.toString();
    }
    
    private final void writeBinFile(final File file, final String s) throws IOException {
        System.out.println("Writing " + file.getName());
        final BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new DeflaterOutputStream(new FileOutputStream(file))));
        bufferedWriter.write(s);
        bufferedWriter.close();
    }
    
    public void createShadowFact(final String s, final WME wme) {
        this.engine.store("__factKey", s);
        this.engine.store("__wmeKey", wme);
        try {
            this.engine.executeCommand("(shadowWME __factKey __wmeKey)");
        }
        catch (JessException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public void createShadowFact(final String s, final String s2, final WME wme) {
        this.engine.store("__factKey", s);
        this.engine.store("__wmeKey", wme);
        try {
            this.engine.executeCommand("(set-current-module " + s2 + ')');
            this.engine.executeCommand("(shadowWME __factKey __wmeKey)");
        }
        catch (JessException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public void deleteShadowFact(final WME wme) {
        this.engine.store("__wmeKey", wme);
        try {
            this.engine.executeCommand("(unshadowWME __wmeKey)");
        }
        catch (JessException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    private final void addDA(final DAWME dawme) throws JessException {
        this.engine.store("__externalDA", dawme);
        this.engine.executeCommand("(modify (assert (DA (type " + dawme.getId() + ") (charID " + dawme.getCharID() + ") (param " + dawme.getParam1() + ") (param2 " + dawme.getParam2() + ") (param3 " + dawme.getParam3() + ")))(daWME (fetch __externalDA)))");
    }
    
    public int getCentricChar() {
        return this.centricCharID;
    }
    
    public void setCentricChar(final int centricCharID) {
        this.centricCharID = centricCharID;
    }
    
    public void chooseReaction(final List list) {
        final ReactionThread reactionThread = new ReactionThread(list);
        reactionThread.setPriority(Thread.currentThread().getPriority() + 1);
        reactionThread.start();
    }
    
    public void activateContext(final String s, final int n) {
        final Enumeration<String> keys = this.activeContexts.keys();
        String s2 = null;
        while (keys.hasMoreElements()) {
            final String s3 = keys.nextElement();
            if (!s3.equals(s) && (int)this.activeContexts.get(s3) == n) {
                s2 = s3;
            }
        }
        if (s2 != null) {
            final String string = "WARNING: Activating context " + s + " with same priority as already activated context " + s2 + ". When multiple contexts with the same priority are active, the selector will choose among them randomly.";
            NativeAnimationInterface.addEventInfoToLog(string);
            StringUtil.println(string);
        }
        this.activeContexts.put(s, new Integer(n));
    }
    
    public void deactivateContext(final String s) {
        this.activeContexts.remove(s);
    }
    
    public void deactivateAllContexts() {
        final Enumeration<String> keys = this.activeContexts.keys();
        while (keys.hasMoreElements()) {
            this.activeContexts.remove(keys.nextElement());
        }
    }
    
    public void deactivateAllContextsExcept(final String s) {
        final Enumeration<String> keys = this.activeContexts.keys();
        while (keys.hasMoreElements()) {
            final String s2 = keys.nextElement();
            if (!s2.equals(s)) {
                this.activeContexts.remove(s2);
            }
        }
    }
    
    public void activateReactionPriorityMapper(final String s) {
        this.activeReactionPriorityMaps.add(s);
    }
    
    public void deactivateReactionPriorityMapper(final String s) {
        this.activeReactionPriorityMaps.remove(s);
    }
    
    public void activateContextPriorityMap(final String activeContextPriorityMap) {
        this.activeContextPriorityMap = activeContextPriorityMap;
    }
    
    public void deactivateContextPriorityMap(final String s) {
        this.activeContextPriorityMap = null;
    }
    
    public void activateReactionSelector(final String activeSelector) {
        this.activeSelector = activeSelector;
    }
    
    private final void createObjectReactionInfoWMEs() {
        final ObjectReactionInfoWME objectReactionInfoWME = new ObjectReactionInfoWME(2, true, 1, 0, 1, 1, 0, 2, 90);
        this.storyMemory.addWME(objectReactionInfoWME);
        this.createShadowFact("objectReactionInfo", objectReactionInfoWME);
        final ObjectReactionInfoWME objectReactionInfoWME2 = new ObjectReactionInfoWME(2, true, 1, 0, 1, 1, -2, -1, 90);
        this.storyMemory.addWME(objectReactionInfoWME2);
        this.createShadowFact("objectReactionInfo", objectReactionInfoWME2);
        final ObjectReactionInfoWME objectReactionInfoWME3 = new ObjectReactionInfoWME(2, true, 0, 0, 1, 1, 1, 2, 97);
        this.storyMemory.addWME(objectReactionInfoWME3);
        this.createShadowFact("objectReactionInfo", objectReactionInfoWME3);
        final ObjectReactionInfoWME objectReactionInfoWME4 = new ObjectReactionInfoWME(2, true, 0, 0, 1, 1, -2, 0, 97);
        this.storyMemory.addWME(objectReactionInfoWME4);
        this.createShadowFact("objectReactionInfo", objectReactionInfoWME4);
        final ObjectReactionInfoWME objectReactionInfoWME5 = new ObjectReactionInfoWME(2, true, 1, 0, 1, 1, 0, 2, 91);
        this.storyMemory.addWME(objectReactionInfoWME5);
        this.createShadowFact("objectReactionInfo", objectReactionInfoWME5);
        final ObjectReactionInfoWME objectReactionInfoWME6 = new ObjectReactionInfoWME(2, true, 1, 0, 1, 1, -2, -1, 91);
        this.storyMemory.addWME(objectReactionInfoWME6);
        this.createShadowFact("objectReactionInfo", objectReactionInfoWME6);
        final ObjectReactionInfoWME objectReactionInfoWME7 = new ObjectReactionInfoWME(2, true, 0, 0, 1, 1, 1, 2, 92);
        this.storyMemory.addWME(objectReactionInfoWME7);
        this.createShadowFact("objectReactionInfo", objectReactionInfoWME7);
        final ObjectReactionInfoWME objectReactionInfoWME8 = new ObjectReactionInfoWME(2, true, 0, 0, 1, 1, -2, 0, 92);
        this.storyMemory.addWME(objectReactionInfoWME8);
        this.createShadowFact("objectReactionInfo", objectReactionInfoWME8);
        final ObjectReactionInfoWME objectReactionInfoWME9 = new ObjectReactionInfoWME(2, true, 0, 0, 1, 1, 0, 2, 82);
        this.storyMemory.addWME(objectReactionInfoWME9);
        this.createShadowFact("objectReactionInfo", objectReactionInfoWME9);
        final ObjectReactionInfoWME objectReactionInfoWME10 = new ObjectReactionInfoWME(2, true, 0, 0, 1, 1, -2, -1, 82);
        this.storyMemory.addWME(objectReactionInfoWME10);
        this.createShadowFact("objectReactionInfo", objectReactionInfoWME10);
        final ObjectReactionInfoWME objectReactionInfoWME11 = new ObjectReactionInfoWME(2, true, 0, 0, 1, 1, 1, 2, 88);
        this.storyMemory.addWME(objectReactionInfoWME11);
        this.createShadowFact("objectReactionInfo", objectReactionInfoWME11);
        final ObjectReactionInfoWME objectReactionInfoWME12 = new ObjectReactionInfoWME(2, true, 0, 0, 1, 1, -2, 0, 88);
        this.storyMemory.addWME(objectReactionInfoWME12);
        this.createShadowFact("objectReactionInfo", objectReactionInfoWME12);
        final ObjectReactionInfoWME objectReactionInfoWME13 = new ObjectReactionInfoWME(2, true, 0, 0, 1, 1, 0, 2, 96);
        this.storyMemory.addWME(objectReactionInfoWME13);
        this.createShadowFact("objectReactionInfo", objectReactionInfoWME13);
        final ObjectReactionInfoWME objectReactionInfoWME14 = new ObjectReactionInfoWME(2, true, 0, 0, 1, 1, -2, -1, 96);
        this.storyMemory.addWME(objectReactionInfoWME14);
        this.createShadowFact("objectReactionInfo", objectReactionInfoWME14);
        final ObjectReactionInfoWME objectReactionInfoWME15 = new ObjectReactionInfoWME(2, true, 1, 0, 1, 1, 0, 2, 86);
        this.storyMemory.addWME(objectReactionInfoWME15);
        this.createShadowFact("objectReactionInfo", objectReactionInfoWME15);
        final ObjectReactionInfoWME objectReactionInfoWME16 = new ObjectReactionInfoWME(2, true, 1, 0, 1, 1, -2, -1, 86);
        this.storyMemory.addWME(objectReactionInfoWME16);
        this.createShadowFact("objectReactionInfo", objectReactionInfoWME16);
        final ObjectReactionInfoWME objectReactionInfoWME17 = new ObjectReactionInfoWME(2, true, 1, 0, 1, 1, 0, 2, 95);
        this.storyMemory.addWME(objectReactionInfoWME17);
        this.createShadowFact("objectReactionInfo", objectReactionInfoWME17);
        final ObjectReactionInfoWME objectReactionInfoWME18 = new ObjectReactionInfoWME(2, true, 1, 0, 1, 1, -2, -1, 95);
        this.storyMemory.addWME(objectReactionInfoWME18);
        this.createShadowFact("objectReactionInfo", objectReactionInfoWME18);
        final ObjectReactionInfoWME objectReactionInfoWME19 = new ObjectReactionInfoWME(2, true, 1, 0, 1, 1, 0, 2, 93);
        this.storyMemory.addWME(objectReactionInfoWME19);
        this.createShadowFact("objectReactionInfo", objectReactionInfoWME19);
        final ObjectReactionInfoWME objectReactionInfoWME20 = new ObjectReactionInfoWME(2, true, 1, 0, 1, 1, -2, -1, 93);
        this.storyMemory.addWME(objectReactionInfoWME20);
        this.createShadowFact("objectReactionInfo", objectReactionInfoWME20);
        final ObjectReactionInfoWME objectReactionInfoWME21 = new ObjectReactionInfoWME(2, true, 1, -1, 1, 2, -2, 2, 90);
        this.storyMemory.addWME(objectReactionInfoWME21);
        this.createShadowFact("objectReactionInfo", objectReactionInfoWME21);
        final ObjectReactionInfoWME objectReactionInfoWME22 = new ObjectReactionInfoWME(2, true, 0, -1, 1, 2, -2, 2, 97);
        this.storyMemory.addWME(objectReactionInfoWME22);
        this.createShadowFact("objectReactionInfo", objectReactionInfoWME22);
        final ObjectReactionInfoWME objectReactionInfoWME23 = new ObjectReactionInfoWME(2, true, 1, -1, 1, 2, -2, 2, 91);
        this.storyMemory.addWME(objectReactionInfoWME23);
        this.createShadowFact("objectReactionInfo", objectReactionInfoWME23);
        final ObjectReactionInfoWME objectReactionInfoWME24 = new ObjectReactionInfoWME(2, true, 0, -1, 1, 2, -2, 2, 92);
        this.storyMemory.addWME(objectReactionInfoWME24);
        this.createShadowFact("objectReactionInfo", objectReactionInfoWME24);
        final ObjectReactionInfoWME objectReactionInfoWME25 = new ObjectReactionInfoWME(2, true, 0, -1, 1, 2, -2, 2, 82);
        this.storyMemory.addWME(objectReactionInfoWME25);
        this.createShadowFact("objectReactionInfo", objectReactionInfoWME25);
        final ObjectReactionInfoWME objectReactionInfoWME26 = new ObjectReactionInfoWME(2, true, 0, -1, 1, 2, -2, 2, 88);
        this.storyMemory.addWME(objectReactionInfoWME26);
        this.createShadowFact("objectReactionInfo", objectReactionInfoWME26);
        final ObjectReactionInfoWME objectReactionInfoWME27 = new ObjectReactionInfoWME(2, true, 0, -1, 1, 2, -2, 2, 96);
        this.storyMemory.addWME(objectReactionInfoWME27);
        this.createShadowFact("objectReactionInfo", objectReactionInfoWME27);
        final ObjectReactionInfoWME objectReactionInfoWME28 = new ObjectReactionInfoWME(2, true, 1, -1, 1, 2, -2, 2, 86);
        this.storyMemory.addWME(objectReactionInfoWME28);
        this.createShadowFact("objectReactionInfo", objectReactionInfoWME28);
        final ObjectReactionInfoWME objectReactionInfoWME29 = new ObjectReactionInfoWME(2, true, 1, -1, 1, 2, -2, 2, 95);
        this.storyMemory.addWME(objectReactionInfoWME29);
        this.createShadowFact("objectReactionInfo", objectReactionInfoWME29);
        final ObjectReactionInfoWME objectReactionInfoWME30 = new ObjectReactionInfoWME(2, true, 1, -1, 1, 2, -2, 2, 93);
        this.storyMemory.addWME(objectReactionInfoWME30);
        this.createShadowFact("objectReactionInfo", objectReactionInfoWME30);
    }
    
    public void createExtraT2ObjectReactionInfoWMEs() {
        System.out.println("### createExtraT2ObjectReactionInfoWMEs()");
        final ObjectReactionInfoWME objectReactionInfoWME = new ObjectReactionInfoWME(2, true, 1, -1, 1, 3, -2, 2, 90);
        this.storyMemory.addWME(objectReactionInfoWME);
        this.createShadowFact("objectReactionInfo", "CONTEXT_GLOBALMIXIN", objectReactionInfoWME);
        final ObjectReactionInfoWME objectReactionInfoWME2 = new ObjectReactionInfoWME(2, true, 0, -1, 1, 3, -2, 2, 97);
        this.storyMemory.addWME(objectReactionInfoWME2);
        this.createShadowFact("objectReactionInfo", "CONTEXT_GLOBALMIXIN", objectReactionInfoWME2);
        final ObjectReactionInfoWME objectReactionInfoWME3 = new ObjectReactionInfoWME(2, true, 1, -1, 1, 3, -2, 2, 91);
        this.storyMemory.addWME(objectReactionInfoWME3);
        this.createShadowFact("objectReactionInfo", "CONTEXT_GLOBALMIXIN", objectReactionInfoWME3);
        final ObjectReactionInfoWME objectReactionInfoWME4 = new ObjectReactionInfoWME(2, true, 0, -1, 1, 3, -2, 2, 92);
        this.storyMemory.addWME(objectReactionInfoWME4);
        this.createShadowFact("objectReactionInfo", "CONTEXT_GLOBALMIXIN", objectReactionInfoWME4);
        final ObjectReactionInfoWME objectReactionInfoWME5 = new ObjectReactionInfoWME(2, true, 0, -1, 1, 3, -2, 2, 82);
        this.storyMemory.addWME(objectReactionInfoWME5);
        this.createShadowFact("objectReactionInfo", "CONTEXT_GLOBALMIXIN", objectReactionInfoWME5);
        final ObjectReactionInfoWME objectReactionInfoWME6 = new ObjectReactionInfoWME(2, true, 0, -1, 1, 3, -2, 2, 88);
        this.storyMemory.addWME(objectReactionInfoWME6);
        this.createShadowFact("objectReactionInfo", "CONTEXT_GLOBALMIXIN", objectReactionInfoWME6);
        final ObjectReactionInfoWME objectReactionInfoWME7 = new ObjectReactionInfoWME(2, true, 0, -1, 1, 3, -2, 2, 96);
        this.storyMemory.addWME(objectReactionInfoWME7);
        this.createShadowFact("objectReactionInfo", "CONTEXT_GLOBALMIXIN", objectReactionInfoWME7);
        final ObjectReactionInfoWME objectReactionInfoWME8 = new ObjectReactionInfoWME(2, true, 1, -1, 1, 3, -2, 2, 86);
        this.storyMemory.addWME(objectReactionInfoWME8);
        this.createShadowFact("objectReactionInfo", "CONTEXT_GLOBALMIXIN", objectReactionInfoWME8);
        final ObjectReactionInfoWME objectReactionInfoWME9 = new ObjectReactionInfoWME(2, true, 1, -1, 1, 3, -2, 2, 95);
        this.storyMemory.addWME(objectReactionInfoWME9);
        this.createShadowFact("objectReactionInfo", "CONTEXT_GLOBALMIXIN", objectReactionInfoWME9);
        final ObjectReactionInfoWME objectReactionInfoWME10 = new ObjectReactionInfoWME(2, true, 1, -1, 1, 3, -2, 2, 93);
        this.storyMemory.addWME(objectReactionInfoWME10);
        this.createShadowFact("objectReactionInfo", "CONTEXT_GLOBALMIXIN", objectReactionInfoWME10);
    }
    
    private final void createSatelliteReactionInfoWMEs() {
        final SatelliteReactionInfoWME satelliteReactionInfoWME = new SatelliteReactionInfoWME(1, true, 1, 0, 1, 1, 0, 2, 71);
        this.storyMemory.addWME(satelliteReactionInfoWME);
        this.createShadowFact("satelliteReactionInfo", satelliteReactionInfoWME);
        final SatelliteReactionInfoWME satelliteReactionInfoWME2 = new SatelliteReactionInfoWME(1, true, 1, 0, 1, 1, -2, -1, 71);
        this.storyMemory.addWME(satelliteReactionInfoWME2);
        this.createShadowFact("satelliteReactionInfo", satelliteReactionInfoWME2);
        final SatelliteReactionInfoWME satelliteReactionInfoWME3 = new SatelliteReactionInfoWME(1, true, 1, 0, 1, 1, 0, 2, 72);
        this.storyMemory.addWME(satelliteReactionInfoWME3);
        this.createShadowFact("satelliteReactionInfo", satelliteReactionInfoWME3);
        final SatelliteReactionInfoWME satelliteReactionInfoWME4 = new SatelliteReactionInfoWME(1, true, 1, 0, 1, 1, -2, -1, 72);
        this.storyMemory.addWME(satelliteReactionInfoWME4);
        this.createShadowFact("satelliteReactionInfo", satelliteReactionInfoWME4);
        final SatelliteReactionInfoWME satelliteReactionInfoWME5 = new SatelliteReactionInfoWME(1, true, 1, 0, 1, 1, 0, 2, 73);
        this.storyMemory.addWME(satelliteReactionInfoWME5);
        this.createShadowFact("satelliteReactionInfo", satelliteReactionInfoWME5);
        final SatelliteReactionInfoWME satelliteReactionInfoWME6 = new SatelliteReactionInfoWME(1, true, 1, 0, 1, 1, -2, -1, 73);
        this.storyMemory.addWME(satelliteReactionInfoWME6);
        this.createShadowFact("satelliteReactionInfo", satelliteReactionInfoWME6);
        final SatelliteReactionInfoWME satelliteReactionInfoWME7 = new SatelliteReactionInfoWME(1, true, 1, 0, 1, 1, 0, 2, 75);
        this.storyMemory.addWME(satelliteReactionInfoWME7);
        this.createShadowFact("satelliteReactionInfo", satelliteReactionInfoWME7);
        final SatelliteReactionInfoWME satelliteReactionInfoWME8 = new SatelliteReactionInfoWME(1, true, 1, 0, 1, 1, -2, -1, 75);
        this.storyMemory.addWME(satelliteReactionInfoWME8);
        this.createShadowFact("satelliteReactionInfo", satelliteReactionInfoWME8);
        final SatelliteReactionInfoWME satelliteReactionInfoWME9 = new SatelliteReactionInfoWME(1, true, 1, 0, 1, 1, 1, 2, 74);
        this.storyMemory.addWME(satelliteReactionInfoWME9);
        this.createShadowFact("satelliteReactionInfo", satelliteReactionInfoWME9);
        final SatelliteReactionInfoWME satelliteReactionInfoWME10 = new SatelliteReactionInfoWME(1, true, 1, 0, 1, 1, -2, 0, 74);
        this.storyMemory.addWME(satelliteReactionInfoWME10);
        this.createShadowFact("satelliteReactionInfo", satelliteReactionInfoWME10);
        final SatelliteReactionInfoWME satelliteReactionInfoWME11 = new SatelliteReactionInfoWME(1, true, 0, -1, 1, 2, -2, 2, 71);
        this.storyMemory.addWME(satelliteReactionInfoWME11);
        this.createShadowFact("satelliteReactionInfo", satelliteReactionInfoWME11);
        final SatelliteReactionInfoWME satelliteReactionInfoWME12 = new SatelliteReactionInfoWME(1, true, 1, -1, 1, 2, -2, 2, 72);
        this.storyMemory.addWME(satelliteReactionInfoWME12);
        this.createShadowFact("satelliteReactionInfo", satelliteReactionInfoWME12);
        final SatelliteReactionInfoWME satelliteReactionInfoWME13 = new SatelliteReactionInfoWME(1, true, 0, -1, 1, 2, -2, 2, 73);
        this.storyMemory.addWME(satelliteReactionInfoWME13);
        this.createShadowFact("satelliteReactionInfo", satelliteReactionInfoWME13);
        final SatelliteReactionInfoWME satelliteReactionInfoWME14 = new SatelliteReactionInfoWME(1, true, 1, -1, 1, 2, -2, 2, 75);
        this.storyMemory.addWME(satelliteReactionInfoWME14);
        this.createShadowFact("satelliteReactionInfo", satelliteReactionInfoWME14);
        final SatelliteReactionInfoWME satelliteReactionInfoWME15 = new SatelliteReactionInfoWME(1, true, 0, -1, 1, 2, -2, 2, 74);
        this.storyMemory.addWME(satelliteReactionInfoWME15);
        this.createShadowFact("satelliteReactionInfo", satelliteReactionInfoWME15);
    }
    
    public void createExtraT2SatelliteReactionInfoWMEs() {
        System.out.println("### createExtraT2SatelliteReactionInfoWMEs()");
        final SatelliteReactionInfoWME satelliteReactionInfoWME = new SatelliteReactionInfoWME(1, true, 0, -1, 1, 3, -2, 2, 71);
        this.storyMemory.addWME(satelliteReactionInfoWME);
        this.createShadowFact("satelliteReactionInfo", "CONTEXT_GLOBALMIXIN", satelliteReactionInfoWME);
        final SatelliteReactionInfoWME satelliteReactionInfoWME2 = new SatelliteReactionInfoWME(1, true, 1, -1, 1, 3, -2, 2, 72);
        this.storyMemory.addWME(satelliteReactionInfoWME2);
        this.createShadowFact("satelliteReactionInfo", "CONTEXT_GLOBALMIXIN", satelliteReactionInfoWME2);
        final SatelliteReactionInfoWME satelliteReactionInfoWME3 = new SatelliteReactionInfoWME(1, true, 0, -1, 1, 3, -2, 2, 73);
        this.storyMemory.addWME(satelliteReactionInfoWME3);
        this.createShadowFact("satelliteReactionInfo", "CONTEXT_GLOBALMIXIN", satelliteReactionInfoWME3);
        final SatelliteReactionInfoWME satelliteReactionInfoWME4 = new SatelliteReactionInfoWME(1, true, 1, -1, 1, 3, -2, 2, 75);
        this.storyMemory.addWME(satelliteReactionInfoWME4);
        this.createShadowFact("satelliteReactionInfo", "CONTEXT_GLOBALMIXIN", satelliteReactionInfoWME4);
        final SatelliteReactionInfoWME satelliteReactionInfoWME5 = new SatelliteReactionInfoWME(1, true, 0, -1, 1, 3, -2, 2, 74);
        this.storyMemory.addWME(satelliteReactionInfoWME5);
        this.createShadowFact("satelliteReactionInfo", "CONTEXT_GLOBALMIXIN", satelliteReactionInfoWME5);
    }
    
    private final void createDAReactionInfoWMEs() {
        final DAReactionInfoWME daReactionInfoWME = new DAReactionInfoWME(3, true, 1, 0, 1, 1, -2, 2, 11, 0);
        this.storyMemory.addWME(daReactionInfoWME);
        this.createShadowFact("daReactionInfo", daReactionInfoWME);
        final DAReactionInfoWME daReactionInfoWME2 = new DAReactionInfoWME(3, true, 0, 0, 1, 1, -2, 2, 11, 1);
        this.storyMemory.addWME(daReactionInfoWME2);
        this.createShadowFact("daReactionInfo", daReactionInfoWME2);
        final DAReactionInfoWME daReactionInfoWME3 = new DAReactionInfoWME(3, true, 0, 0, 1, 1, -2, 2, 12, 0);
        this.storyMemory.addWME(daReactionInfoWME3);
        this.createShadowFact("daReactionInfo", daReactionInfoWME3);
        final DAReactionInfoWME daReactionInfoWME4 = new DAReactionInfoWME(3, true, 1, 0, 1, 1, -2, 2, 12, 1);
        this.storyMemory.addWME(daReactionInfoWME4);
        this.createShadowFact("daReactionInfo", daReactionInfoWME4);
        final DAReactionInfoWME daReactionInfoWME5 = new DAReactionInfoWME(3, true, 1, 0, 1, 1, -2, 2, 15, 0);
        this.storyMemory.addWME(daReactionInfoWME5);
        this.createShadowFact("daReactionInfo", daReactionInfoWME5);
        final DAReactionInfoWME daReactionInfoWME6 = new DAReactionInfoWME(3, true, 0, 0, 1, 1, -2, 2, 15, 1);
        this.storyMemory.addWME(daReactionInfoWME6);
        this.createShadowFact("daReactionInfo", daReactionInfoWME6);
        final DAReactionInfoWME daReactionInfoWME7 = new DAReactionInfoWME(3, true, 1, 0, 1, 1, -2, 2, 16, 0);
        this.storyMemory.addWME(daReactionInfoWME7);
        this.createShadowFact("daReactionInfo", daReactionInfoWME7);
        final DAReactionInfoWME daReactionInfoWME8 = new DAReactionInfoWME(3, true, 0, 0, 1, 1, -2, 2, 16, 1);
        this.storyMemory.addWME(daReactionInfoWME8);
        this.createShadowFact("daReactionInfo", daReactionInfoWME8);
        final DAReactionInfoWME daReactionInfoWME9 = new DAReactionInfoWME(3, true, 1, 0, 1, 1, -2, 2, 29, 0);
        this.storyMemory.addWME(daReactionInfoWME9);
        this.createShadowFact("daReactionInfo", daReactionInfoWME9);
        final DAReactionInfoWME daReactionInfoWME10 = new DAReactionInfoWME(3, true, 1, 0, 1, 1, -2, 2, 29, 1);
        this.storyMemory.addWME(daReactionInfoWME10);
        this.createShadowFact("daReactionInfo", daReactionInfoWME10);
        final DAReactionInfoWME daReactionInfoWME11 = new DAReactionInfoWME(3, true, 0, 0, 1, 1, -2, 2, 19, 0);
        this.storyMemory.addWME(daReactionInfoWME11);
        this.createShadowFact("daReactionInfo", daReactionInfoWME11);
        final DAReactionInfoWME daReactionInfoWME12 = new DAReactionInfoWME(3, true, 1, 0, 1, 1, -2, 2, 19, 1);
        this.storyMemory.addWME(daReactionInfoWME12);
        this.createShadowFact("daReactionInfo", daReactionInfoWME12);
        final DAReactionInfoWME daReactionInfoWME13 = new DAReactionInfoWME(3, true, 0, 0, 1, 1, -2, 2, 20, 0);
        this.storyMemory.addWME(daReactionInfoWME13);
        this.createShadowFact("daReactionInfo", daReactionInfoWME13);
        final DAReactionInfoWME daReactionInfoWME14 = new DAReactionInfoWME(3, true, 1, 0, 1, 1, -2, 2, 20, 1);
        this.storyMemory.addWME(daReactionInfoWME14);
        this.createShadowFact("daReactionInfo", daReactionInfoWME14);
        final DAReactionInfoWME daReactionInfoWME15 = new DAReactionInfoWME(3, true, 0, 0, 1, 1, -2, 2, 21, 0);
        this.storyMemory.addWME(daReactionInfoWME15);
        this.createShadowFact("daReactionInfo", daReactionInfoWME15);
        final DAReactionInfoWME daReactionInfoWME16 = new DAReactionInfoWME(3, true, 1, 0, 1, 1, -2, 2, 21, 1);
        this.storyMemory.addWME(daReactionInfoWME16);
        this.createShadowFact("daReactionInfo", daReactionInfoWME16);
        final DAReactionInfoWME daReactionInfoWME17 = new DAReactionInfoWME(3, true, 0, 0, 1, 1, -2, 2, 22, 0);
        this.storyMemory.addWME(daReactionInfoWME17);
        this.createShadowFact("daReactionInfo", daReactionInfoWME17);
        final DAReactionInfoWME daReactionInfoWME18 = new DAReactionInfoWME(3, true, 1, 0, 1, 1, -2, 2, 22, 1);
        this.storyMemory.addWME(daReactionInfoWME18);
        this.createShadowFact("daReactionInfo", daReactionInfoWME18);
        final DAReactionInfoWME daReactionInfoWME19 = new DAReactionInfoWME(3, true, 0, 0, 1, 1, -2, 2, 18, 0);
        this.storyMemory.addWME(daReactionInfoWME19);
        this.createShadowFact("daReactionInfo", daReactionInfoWME19);
        final DAReactionInfoWME daReactionInfoWME20 = new DAReactionInfoWME(3, true, 1, 0, 1, 1, -2, 2, 18, 1);
        this.storyMemory.addWME(daReactionInfoWME20);
        this.createShadowFact("daReactionInfo", daReactionInfoWME20);
        final DAReactionInfoWME daReactionInfoWME21 = new DAReactionInfoWME(3, true, 0, 0, 1, 1, -2, 2, 23, 0);
        this.storyMemory.addWME(daReactionInfoWME21);
        this.createShadowFact("daReactionInfo", daReactionInfoWME21);
        final DAReactionInfoWME daReactionInfoWME22 = new DAReactionInfoWME(3, true, 1, 0, 1, 1, -2, 2, 23, 1);
        this.storyMemory.addWME(daReactionInfoWME22);
        this.createShadowFact("daReactionInfo", daReactionInfoWME22);
        final DAReactionInfoWME daReactionInfoWME23 = new DAReactionInfoWME(3, true, 0, 0, 1, 1, -2, 2, 24, 0);
        this.storyMemory.addWME(daReactionInfoWME23);
        this.createShadowFact("daReactionInfo", daReactionInfoWME23);
        final DAReactionInfoWME daReactionInfoWME24 = new DAReactionInfoWME(3, true, 1, 0, 1, 1, -2, 2, 24, 1);
        this.storyMemory.addWME(daReactionInfoWME24);
        this.createShadowFact("daReactionInfo", daReactionInfoWME24);
        final DAReactionInfoWME daReactionInfoWME25 = new DAReactionInfoWME(3, true, 0, 0, 1, 1, -2, 2, 25, 0);
        this.storyMemory.addWME(daReactionInfoWME25);
        this.createShadowFact("daReactionInfo", daReactionInfoWME25);
        final DAReactionInfoWME daReactionInfoWME26 = new DAReactionInfoWME(3, true, 1, 0, 1, 1, -2, 2, 25, 1);
        this.storyMemory.addWME(daReactionInfoWME26);
        this.createShadowFact("daReactionInfo", daReactionInfoWME26);
        final DAReactionInfoWME daReactionInfoWME27 = new DAReactionInfoWME(3, true, 0, 0, 1, 1, -2, 2, 26, 0);
        this.storyMemory.addWME(daReactionInfoWME27);
        this.createShadowFact("daReactionInfo", daReactionInfoWME27);
        final DAReactionInfoWME daReactionInfoWME28 = new DAReactionInfoWME(3, true, 1, 0, 1, 1, -2, 2, 26, 1);
        this.storyMemory.addWME(daReactionInfoWME28);
        this.createShadowFact("daReactionInfo", daReactionInfoWME28);
        final DAReactionInfoWME daReactionInfoWME29 = new DAReactionInfoWME(3, true, 0, 0, 1, 1, -2, 2, 27, 0);
        this.storyMemory.addWME(daReactionInfoWME29);
        this.createShadowFact("daReactionInfo", daReactionInfoWME29);
        final DAReactionInfoWME daReactionInfoWME30 = new DAReactionInfoWME(3, true, 1, 0, 1, 1, -2, 2, 27, 1);
        this.storyMemory.addWME(daReactionInfoWME30);
        this.createShadowFact("daReactionInfo", daReactionInfoWME30);
        final DAReactionInfoWME daReactionInfoWME31 = new DAReactionInfoWME(3, true, 0, 0, 1, 1, -2, 2, 28, 0);
        this.storyMemory.addWME(daReactionInfoWME31);
        this.createShadowFact("daReactionInfo", daReactionInfoWME31);
        final DAReactionInfoWME daReactionInfoWME32 = new DAReactionInfoWME(3, true, 1, 0, 1, 1, -2, 2, 28, 1);
        this.storyMemory.addWME(daReactionInfoWME32);
        this.createShadowFact("daReactionInfo", daReactionInfoWME32);
        final DAReactionInfoWME daReactionInfoWME33 = new DAReactionInfoWME(3, true, 0, 0, 1, 1, -2, 2, 14, 0);
        this.storyMemory.addWME(daReactionInfoWME33);
        this.createShadowFact("daReactionInfo", daReactionInfoWME33);
        final DAReactionInfoWME daReactionInfoWME34 = new DAReactionInfoWME(3, true, 1, 0, 1, 1, -2, 2, 14, 1);
        this.storyMemory.addWME(daReactionInfoWME34);
        this.createShadowFact("daReactionInfo", daReactionInfoWME34);
        final DAReactionInfoWME daReactionInfoWME35 = new DAReactionInfoWME(3, true, 0, 0, 1, 1, -2, 2, 34, 0);
        this.storyMemory.addWME(daReactionInfoWME35);
        this.createShadowFact("daReactionInfo", daReactionInfoWME35);
        final DAReactionInfoWME daReactionInfoWME36 = new DAReactionInfoWME(3, true, 1, 0, 1, 1, -2, 2, 34, 1);
        this.storyMemory.addWME(daReactionInfoWME36);
        this.createShadowFact("daReactionInfo", daReactionInfoWME36);
        final DAReactionInfoWME daReactionInfoWME37 = new DAReactionInfoWME(3, true, 1, 0, 1, 1, -2, 2, 36, -1);
        this.storyMemory.addWME(daReactionInfoWME37);
        this.createShadowFact("daReactionInfo", daReactionInfoWME37);
        final DAReactionInfoWME daReactionInfoWME38 = new DAReactionInfoWME(3, true, 1, 0, 1, 1, -2, 2, 37, -1);
        this.storyMemory.addWME(daReactionInfoWME38);
        this.createShadowFact("daReactionInfo", daReactionInfoWME38);
        final DAReactionInfoWME daReactionInfoWME39 = new DAReactionInfoWME(3, true, 1, 0, 1, 1, -2, 2, 38, -1);
        this.storyMemory.addWME(daReactionInfoWME39);
        this.createShadowFact("daReactionInfo", daReactionInfoWME39);
        final DAReactionInfoWME daReactionInfoWME40 = new DAReactionInfoWME(3, true, 1, 0, 1, 1, -2, 2, 39, -1);
        this.storyMemory.addWME(daReactionInfoWME40);
        this.createShadowFact("daReactionInfo", daReactionInfoWME40);
        final DAReactionInfoWME daReactionInfoWME41 = new DAReactionInfoWME(3, true, 1, 0, 1, 1, -2, 2, 40, -1);
        this.storyMemory.addWME(daReactionInfoWME41);
        this.createShadowFact("daReactionInfo", daReactionInfoWME41);
        final DAReactionInfoWME daReactionInfoWME42 = new DAReactionInfoWME(3, true, 1, 0, 1, 1, -2, 2, 41, -1);
        this.storyMemory.addWME(daReactionInfoWME42);
        this.createShadowFact("daReactionInfo", daReactionInfoWME42);
        final DAReactionInfoWME daReactionInfoWME43 = new DAReactionInfoWME(3, true, 1, -1, 1, 2, -2, 2, 11, 0);
        this.storyMemory.addWME(daReactionInfoWME43);
        this.createShadowFact("daReactionInfo", daReactionInfoWME43);
        final DAReactionInfoWME daReactionInfoWME44 = new DAReactionInfoWME(3, true, 0, -1, 1, 2, -2, 2, 11, 1);
        this.storyMemory.addWME(daReactionInfoWME44);
        this.createShadowFact("daReactionInfo", daReactionInfoWME44);
        final DAReactionInfoWME daReactionInfoWME45 = new DAReactionInfoWME(3, true, 0, -1, 1, 2, -2, 2, 12, 0);
        this.storyMemory.addWME(daReactionInfoWME45);
        this.createShadowFact("daReactionInfo", daReactionInfoWME45);
        final DAReactionInfoWME daReactionInfoWME46 = new DAReactionInfoWME(3, true, 1, -1, 1, 2, -2, 2, 12, 1);
        this.storyMemory.addWME(daReactionInfoWME46);
        this.createShadowFact("daReactionInfo", daReactionInfoWME46);
        final DAReactionInfoWME daReactionInfoWME47 = new DAReactionInfoWME(3, true, 1, -1, 1, 2, -2, 2, 15, 0);
        this.storyMemory.addWME(daReactionInfoWME47);
        this.createShadowFact("daReactionInfo", daReactionInfoWME47);
        final DAReactionInfoWME daReactionInfoWME48 = new DAReactionInfoWME(3, true, 0, -1, 1, 2, -2, 2, 15, 1);
        this.storyMemory.addWME(daReactionInfoWME48);
        this.createShadowFact("daReactionInfo", daReactionInfoWME48);
        final DAReactionInfoWME daReactionInfoWME49 = new DAReactionInfoWME(3, true, 1, -1, 1, 2, -2, 2, 16, 0);
        this.storyMemory.addWME(daReactionInfoWME49);
        this.createShadowFact("daReactionInfo", daReactionInfoWME49);
        final DAReactionInfoWME daReactionInfoWME50 = new DAReactionInfoWME(3, true, 0, -1, 1, 2, -2, 2, 16, 1);
        this.storyMemory.addWME(daReactionInfoWME50);
        this.createShadowFact("daReactionInfo", daReactionInfoWME50);
        final DAReactionInfoWME daReactionInfoWME51 = new DAReactionInfoWME(3, true, 1, 0, 1, 2, -2, 2, 29, 0);
        this.storyMemory.addWME(daReactionInfoWME51);
        this.createShadowFact("daReactionInfo", daReactionInfoWME51);
        final DAReactionInfoWME daReactionInfoWME52 = new DAReactionInfoWME(3, true, 1, 0, 1, 2, -2, 2, 29, 1);
        this.storyMemory.addWME(daReactionInfoWME52);
        this.createShadowFact("daReactionInfo", daReactionInfoWME52);
        final DAReactionInfoWME daReactionInfoWME53 = new DAReactionInfoWME(3, true, 0, 0, 1, 2, -2, 2, 19, 0);
        this.storyMemory.addWME(daReactionInfoWME53);
        this.createShadowFact("daReactionInfo", daReactionInfoWME53);
        final DAReactionInfoWME daReactionInfoWME54 = new DAReactionInfoWME(3, true, 1, 0, 1, 2, -2, 2, 19, 1);
        this.storyMemory.addWME(daReactionInfoWME54);
        this.createShadowFact("daReactionInfo", daReactionInfoWME54);
        final DAReactionInfoWME daReactionInfoWME55 = new DAReactionInfoWME(3, true, 0, 0, 1, 2, -2, 2, 20, 0);
        this.storyMemory.addWME(daReactionInfoWME55);
        this.createShadowFact("daReactionInfo", daReactionInfoWME55);
        final DAReactionInfoWME daReactionInfoWME56 = new DAReactionInfoWME(3, true, 1, 0, 1, 2, -2, 2, 20, 1);
        this.storyMemory.addWME(daReactionInfoWME56);
        this.createShadowFact("daReactionInfo", daReactionInfoWME56);
        final DAReactionInfoWME daReactionInfoWME57 = new DAReactionInfoWME(3, true, 0, 0, 1, 2, -2, 2, 21, 0);
        this.storyMemory.addWME(daReactionInfoWME57);
        this.createShadowFact("daReactionInfo", daReactionInfoWME57);
        final DAReactionInfoWME daReactionInfoWME58 = new DAReactionInfoWME(3, true, 1, 0, 1, 2, -2, 2, 21, 1);
        this.storyMemory.addWME(daReactionInfoWME58);
        this.createShadowFact("daReactionInfo", daReactionInfoWME58);
        final DAReactionInfoWME daReactionInfoWME59 = new DAReactionInfoWME(3, true, 0, 0, 1, 2, -2, 2, 22, 0);
        this.storyMemory.addWME(daReactionInfoWME59);
        this.createShadowFact("daReactionInfo", daReactionInfoWME59);
        final DAReactionInfoWME daReactionInfoWME60 = new DAReactionInfoWME(3, true, 1, 0, 1, 2, -2, 2, 22, 1);
        this.storyMemory.addWME(daReactionInfoWME60);
        this.createShadowFact("daReactionInfo", daReactionInfoWME60);
        final DAReactionInfoWME daReactionInfoWME61 = new DAReactionInfoWME(3, true, 0, 0, 1, 2, -2, 2, 18, 0);
        this.storyMemory.addWME(daReactionInfoWME61);
        this.createShadowFact("daReactionInfo", daReactionInfoWME61);
        final DAReactionInfoWME daReactionInfoWME62 = new DAReactionInfoWME(3, true, 1, 0, 1, 2, -2, 2, 18, 1);
        this.storyMemory.addWME(daReactionInfoWME62);
        this.createShadowFact("daReactionInfo", daReactionInfoWME62);
        final DAReactionInfoWME daReactionInfoWME63 = new DAReactionInfoWME(3, true, 0, 0, 1, 2, -2, 2, 23, 0);
        this.storyMemory.addWME(daReactionInfoWME63);
        this.createShadowFact("daReactionInfo", daReactionInfoWME63);
        final DAReactionInfoWME daReactionInfoWME64 = new DAReactionInfoWME(3, true, 1, 0, 1, 2, -2, 2, 23, 1);
        this.storyMemory.addWME(daReactionInfoWME64);
        this.createShadowFact("daReactionInfo", daReactionInfoWME64);
        final DAReactionInfoWME daReactionInfoWME65 = new DAReactionInfoWME(3, true, 0, 0, 1, 2, -2, 2, 24, 0);
        this.storyMemory.addWME(daReactionInfoWME65);
        this.createShadowFact("daReactionInfo", daReactionInfoWME65);
        final DAReactionInfoWME daReactionInfoWME66 = new DAReactionInfoWME(3, true, 1, 0, 1, 2, -2, 2, 24, 1);
        this.storyMemory.addWME(daReactionInfoWME66);
        this.createShadowFact("daReactionInfo", daReactionInfoWME66);
        final DAReactionInfoWME daReactionInfoWME67 = new DAReactionInfoWME(3, true, 0, 0, 1, 2, -2, 2, 25, 0);
        this.storyMemory.addWME(daReactionInfoWME67);
        this.createShadowFact("daReactionInfo", daReactionInfoWME67);
        final DAReactionInfoWME daReactionInfoWME68 = new DAReactionInfoWME(3, true, 1, 0, 1, 2, -2, 2, 25, 1);
        this.storyMemory.addWME(daReactionInfoWME68);
        this.createShadowFact("daReactionInfo", daReactionInfoWME68);
        final DAReactionInfoWME daReactionInfoWME69 = new DAReactionInfoWME(3, true, 0, 0, 1, 2, -2, 2, 26, 0);
        this.storyMemory.addWME(daReactionInfoWME69);
        this.createShadowFact("daReactionInfo", daReactionInfoWME69);
        final DAReactionInfoWME daReactionInfoWME70 = new DAReactionInfoWME(3, true, 1, 0, 1, 2, -2, 2, 26, 1);
        this.storyMemory.addWME(daReactionInfoWME70);
        this.createShadowFact("daReactionInfo", daReactionInfoWME70);
        final DAReactionInfoWME daReactionInfoWME71 = new DAReactionInfoWME(3, true, 0, 0, 1, 2, -2, 2, 27, 0);
        this.storyMemory.addWME(daReactionInfoWME71);
        this.createShadowFact("daReactionInfo", daReactionInfoWME71);
        final DAReactionInfoWME daReactionInfoWME72 = new DAReactionInfoWME(3, true, 1, 0, 1, 2, -2, 2, 27, 1);
        this.storyMemory.addWME(daReactionInfoWME72);
        this.createShadowFact("daReactionInfo", daReactionInfoWME72);
        final DAReactionInfoWME daReactionInfoWME73 = new DAReactionInfoWME(3, true, 0, 0, 1, 2, -2, 2, 28, 0);
        this.storyMemory.addWME(daReactionInfoWME73);
        this.createShadowFact("daReactionInfo", daReactionInfoWME73);
        final DAReactionInfoWME daReactionInfoWME74 = new DAReactionInfoWME(3, true, 1, 0, 1, 2, -2, 2, 28, 1);
        this.storyMemory.addWME(daReactionInfoWME74);
        this.createShadowFact("daReactionInfo", daReactionInfoWME74);
        final DAReactionInfoWME daReactionInfoWME75 = new DAReactionInfoWME(3, true, 0, 0, 1, 2, -2, 2, 14, 0);
        this.storyMemory.addWME(daReactionInfoWME75);
        this.createShadowFact("daReactionInfo", daReactionInfoWME75);
        final DAReactionInfoWME daReactionInfoWME76 = new DAReactionInfoWME(3, true, 1, 0, 1, 2, -2, 2, 14, 1);
        this.storyMemory.addWME(daReactionInfoWME76);
        this.createShadowFact("daReactionInfo", daReactionInfoWME76);
        final DAReactionInfoWME daReactionInfoWME77 = new DAReactionInfoWME(3, true, 0, 0, 1, 2, -2, 2, 34, 0);
        this.storyMemory.addWME(daReactionInfoWME77);
        this.createShadowFact("daReactionInfo", daReactionInfoWME77);
        final DAReactionInfoWME daReactionInfoWME78 = new DAReactionInfoWME(3, true, 1, 0, 1, 2, -2, 2, 34, 1);
        this.storyMemory.addWME(daReactionInfoWME78);
        this.createShadowFact("daReactionInfo", daReactionInfoWME78);
        final DAReactionInfoWME daReactionInfoWME79 = new DAReactionInfoWME(3, true, 1, 0, 1, 2, -2, 2, 36, -1);
        this.storyMemory.addWME(daReactionInfoWME79);
        this.createShadowFact("daReactionInfo", daReactionInfoWME79);
        final DAReactionInfoWME daReactionInfoWME80 = new DAReactionInfoWME(3, true, 1, 0, 1, 2, -2, 2, 37, -1);
        this.storyMemory.addWME(daReactionInfoWME80);
        this.createShadowFact("daReactionInfo", daReactionInfoWME80);
        final DAReactionInfoWME daReactionInfoWME81 = new DAReactionInfoWME(3, true, 1, 0, 1, 2, -2, 2, 38, -1);
        this.storyMemory.addWME(daReactionInfoWME81);
        this.createShadowFact("daReactionInfo", daReactionInfoWME81);
        final DAReactionInfoWME daReactionInfoWME82 = new DAReactionInfoWME(3, true, 1, 0, 1, 2, -2, 2, 39, -1);
        this.storyMemory.addWME(daReactionInfoWME82);
        this.createShadowFact("daReactionInfo", daReactionInfoWME82);
        final DAReactionInfoWME daReactionInfoWME83 = new DAReactionInfoWME(3, true, 1, 0, 1, 2, -2, 2, 40, -1);
        this.storyMemory.addWME(daReactionInfoWME83);
        this.createShadowFact("daReactionInfo", daReactionInfoWME83);
        final DAReactionInfoWME daReactionInfoWME84 = new DAReactionInfoWME(3, true, 1, 0, 1, 2, -2, 2, 41, -1);
        this.storyMemory.addWME(daReactionInfoWME84);
        this.createShadowFact("daReactionInfo", daReactionInfoWME84);
    }
    
    public void createExtraT2DAReactionInfoWMEs() {
        System.out.println("### createExtraT2DAReactionInfoWMEs()");
        final DAReactionInfoWME daReactionInfoWME = new DAReactionInfoWME(3, true, 1, 0, 1, 3, -2, 2, 11, 0);
        this.storyMemory.addWME(daReactionInfoWME);
        this.createShadowFact("daReactionInfo", "CONTEXT_GLOBALMIXIN", daReactionInfoWME);
        final DAReactionInfoWME daReactionInfoWME2 = new DAReactionInfoWME(3, true, 0, 0, 1, 3, -2, 2, 11, 1);
        this.storyMemory.addWME(daReactionInfoWME2);
        this.createShadowFact("daReactionInfo", "CONTEXT_GLOBALMIXIN", daReactionInfoWME2);
        final DAReactionInfoWME daReactionInfoWME3 = new DAReactionInfoWME(3, true, 0, 0, 1, 3, -2, 2, 12, 0);
        this.storyMemory.addWME(daReactionInfoWME3);
        this.createShadowFact("daReactionInfo", "CONTEXT_GLOBALMIXIN", daReactionInfoWME3);
        final DAReactionInfoWME daReactionInfoWME4 = new DAReactionInfoWME(3, true, 1, 0, 1, 3, -2, 2, 12, 1);
        this.storyMemory.addWME(daReactionInfoWME4);
        this.createShadowFact("daReactionInfo", "CONTEXT_GLOBALMIXIN", daReactionInfoWME4);
        final DAReactionInfoWME daReactionInfoWME5 = new DAReactionInfoWME(3, true, 1, 0, 1, 3, -2, 2, 15, 0);
        this.storyMemory.addWME(daReactionInfoWME5);
        this.createShadowFact("daReactionInfo", "CONTEXT_GLOBALMIXIN", daReactionInfoWME5);
        final DAReactionInfoWME daReactionInfoWME6 = new DAReactionInfoWME(3, true, 0, 0, 1, 3, -2, 2, 15, 1);
        this.storyMemory.addWME(daReactionInfoWME6);
        this.createShadowFact("daReactionInfo", "CONTEXT_GLOBALMIXIN", daReactionInfoWME6);
        final DAReactionInfoWME daReactionInfoWME7 = new DAReactionInfoWME(3, true, 1, 0, 1, 3, -2, 2, 16, 0);
        this.storyMemory.addWME(daReactionInfoWME7);
        this.createShadowFact("daReactionInfo", "CONTEXT_GLOBALMIXIN", daReactionInfoWME7);
        final DAReactionInfoWME daReactionInfoWME8 = new DAReactionInfoWME(3, true, 0, 0, 1, 3, -2, 2, 16, 1);
        this.storyMemory.addWME(daReactionInfoWME8);
        this.createShadowFact("daReactionInfo", "CONTEXT_GLOBALMIXIN", daReactionInfoWME8);
        final DAReactionInfoWME daReactionInfoWME9 = new DAReactionInfoWME(3, true, 1, 0, 1, 3, -2, 2, 29, 0);
        this.storyMemory.addWME(daReactionInfoWME9);
        this.createShadowFact("daReactionInfo", "CONTEXT_GLOBALMIXIN", daReactionInfoWME9);
        final DAReactionInfoWME daReactionInfoWME10 = new DAReactionInfoWME(3, true, 1, 0, 1, 3, -2, 2, 29, 1);
        this.storyMemory.addWME(daReactionInfoWME10);
        this.createShadowFact("daReactionInfo", "CONTEXT_GLOBALMIXIN", daReactionInfoWME10);
        final DAReactionInfoWME daReactionInfoWME11 = new DAReactionInfoWME(3, true, 0, 0, 1, 3, -2, 2, 19, 0);
        this.storyMemory.addWME(daReactionInfoWME11);
        this.createShadowFact("daReactionInfo", "CONTEXT_GLOBALMIXIN", daReactionInfoWME11);
        final DAReactionInfoWME daReactionInfoWME12 = new DAReactionInfoWME(3, true, 1, 0, 1, 3, -2, 2, 19, 1);
        this.storyMemory.addWME(daReactionInfoWME12);
        this.createShadowFact("daReactionInfo", "CONTEXT_GLOBALMIXIN", daReactionInfoWME12);
        final DAReactionInfoWME daReactionInfoWME13 = new DAReactionInfoWME(3, true, 0, 0, 1, 3, -2, 2, 20, 0);
        this.storyMemory.addWME(daReactionInfoWME13);
        this.createShadowFact("daReactionInfo", "CONTEXT_GLOBALMIXIN", daReactionInfoWME13);
        final DAReactionInfoWME daReactionInfoWME14 = new DAReactionInfoWME(3, true, 1, 0, 1, 3, -2, 2, 20, 1);
        this.storyMemory.addWME(daReactionInfoWME14);
        this.createShadowFact("daReactionInfo", "CONTEXT_GLOBALMIXIN", daReactionInfoWME14);
        final DAReactionInfoWME daReactionInfoWME15 = new DAReactionInfoWME(3, true, 0, 0, 1, 3, -2, 2, 21, 0);
        this.storyMemory.addWME(daReactionInfoWME15);
        this.createShadowFact("daReactionInfo", "CONTEXT_GLOBALMIXIN", daReactionInfoWME15);
        final DAReactionInfoWME daReactionInfoWME16 = new DAReactionInfoWME(3, true, 1, 0, 1, 3, -2, 2, 21, 1);
        this.storyMemory.addWME(daReactionInfoWME16);
        this.createShadowFact("daReactionInfo", "CONTEXT_GLOBALMIXIN", daReactionInfoWME16);
        final DAReactionInfoWME daReactionInfoWME17 = new DAReactionInfoWME(3, true, 0, 0, 1, 3, -2, 2, 22, 0);
        this.storyMemory.addWME(daReactionInfoWME17);
        this.createShadowFact("daReactionInfo", "CONTEXT_GLOBALMIXIN", daReactionInfoWME17);
        final DAReactionInfoWME daReactionInfoWME18 = new DAReactionInfoWME(3, true, 1, 0, 1, 3, -2, 2, 22, 1);
        this.storyMemory.addWME(daReactionInfoWME18);
        this.createShadowFact("daReactionInfo", "CONTEXT_GLOBALMIXIN", daReactionInfoWME18);
    }
    
    private final void createPushTooFarReactionInfoWMEs() {
        final PushTooFarReactionInfoWME pushTooFarReactionInfoWME = new PushTooFarReactionInfoWME(0, true, 0, -1, 1, 0);
        this.storyMemory.addWME(pushTooFarReactionInfoWME);
        this.createShadowFact("pushTooFarReactionInfo", pushTooFarReactionInfoWME);
        final PushTooFarReactionInfoWME pushTooFarReactionInfoWME2 = new PushTooFarReactionInfoWME(0, true, 0, -1, 1, 1);
        this.storyMemory.addWME(pushTooFarReactionInfoWME2);
        this.createShadowFact("pushTooFarReactionInfo", pushTooFarReactionInfoWME2);
        final PushTooFarReactionInfoWME pushTooFarReactionInfoWME3 = new PushTooFarReactionInfoWME(0, true, 1, -1, 1, 2);
        this.storyMemory.addWME(pushTooFarReactionInfoWME3);
        this.createShadowFact("pushTooFarReactionInfo", pushTooFarReactionInfoWME3);
        final PushTooFarReactionInfoWME pushTooFarReactionInfoWME4 = new PushTooFarReactionInfoWME(0, true, 1, -1, 1, 3);
        this.storyMemory.addWME(pushTooFarReactionInfoWME4);
        this.createShadowFact("pushTooFarReactionInfo", pushTooFarReactionInfoWME4);
        final PushTooFarReactionInfoWME pushTooFarReactionInfoWME5 = new PushTooFarReactionInfoWME(0, true, 0, -1, 1, 4);
        this.storyMemory.addWME(pushTooFarReactionInfoWME5);
        this.createShadowFact("pushTooFarReactionInfo", pushTooFarReactionInfoWME5);
        final PushTooFarReactionInfoWME pushTooFarReactionInfoWME6 = new PushTooFarReactionInfoWME(0, true, 0, -1, 1, 5);
        this.storyMemory.addWME(pushTooFarReactionInfoWME6);
        this.createShadowFact("pushTooFarReactionInfo", pushTooFarReactionInfoWME6);
        final PushTooFarReactionInfoWME pushTooFarReactionInfoWME7 = new PushTooFarReactionInfoWME(0, true, 1, -1, 1, 6);
        this.storyMemory.addWME(pushTooFarReactionInfoWME7);
        this.createShadowFact("pushTooFarReactionInfo", pushTooFarReactionInfoWME7);
        final PushTooFarReactionInfoWME pushTooFarReactionInfoWME8 = new PushTooFarReactionInfoWME(0, true, 1, -1, 1, 7);
        this.storyMemory.addWME(pushTooFarReactionInfoWME8);
        this.createShadowFact("pushTooFarReactionInfo", pushTooFarReactionInfoWME8);
        final PushTooFarReactionInfoWME pushTooFarReactionInfoWME9 = new PushTooFarReactionInfoWME(0, true, 0, -1, 1, 8);
        this.storyMemory.addWME(pushTooFarReactionInfoWME9);
        this.createShadowFact("pushTooFarReactionInfo", pushTooFarReactionInfoWME9);
        final PushTooFarReactionInfoWME pushTooFarReactionInfoWME10 = new PushTooFarReactionInfoWME(0, true, 1, -1, 1, 9);
        this.storyMemory.addWME(pushTooFarReactionInfoWME10);
        this.createShadowFact("pushTooFarReactionInfo", pushTooFarReactionInfoWME10);
        final PushTooFarReactionInfoWME pushTooFarReactionInfoWME11 = new PushTooFarReactionInfoWME(0, true, 1, -1, 1, 10);
        this.storyMemory.addWME(pushTooFarReactionInfoWME11);
        this.createShadowFact("pushTooFarReactionInfo", pushTooFarReactionInfoWME11);
        final PushTooFarReactionInfoWME pushTooFarReactionInfoWME12 = new PushTooFarReactionInfoWME(0, true, 0, -1, 1, 11);
        this.storyMemory.addWME(pushTooFarReactionInfoWME12);
        this.createShadowFact("pushTooFarReactionInfo", pushTooFarReactionInfoWME12);
        final PushTooFarReactionInfoWME pushTooFarReactionInfoWME13 = new PushTooFarReactionInfoWME(0, true, 0, -1, 1, 12);
        this.storyMemory.addWME(pushTooFarReactionInfoWME13);
        this.createShadowFact("pushTooFarReactionInfo", pushTooFarReactionInfoWME13);
        final PushTooFarReactionInfoWME pushTooFarReactionInfoWME14 = new PushTooFarReactionInfoWME(0, true, 0, -1, 1, 13);
        this.storyMemory.addWME(pushTooFarReactionInfoWME14);
        this.createShadowFact("pushTooFarReactionInfo", pushTooFarReactionInfoWME14);
        final PushTooFarReactionInfoWME pushTooFarReactionInfoWME15 = new PushTooFarReactionInfoWME(0, true, 1, -1, 1, 13);
        this.storyMemory.addWME(pushTooFarReactionInfoWME15);
        this.createShadowFact("pushTooFarReactionInfo", pushTooFarReactionInfoWME15);
        final PushTooFarReactionInfoWME pushTooFarReactionInfoWME16 = new PushTooFarReactionInfoWME(0, true, 0, -1, 1, 14);
        this.storyMemory.addWME(pushTooFarReactionInfoWME16);
        this.createShadowFact("pushTooFarReactionInfo", pushTooFarReactionInfoWME16);
        final PushTooFarReactionInfoWME pushTooFarReactionInfoWME17 = new PushTooFarReactionInfoWME(0, true, 1, -1, 1, 14);
        this.storyMemory.addWME(pushTooFarReactionInfoWME17);
        this.createShadowFact("pushTooFarReactionInfo", pushTooFarReactionInfoWME17);
        final PushTooFarReactionInfoWME pushTooFarReactionInfoWME18 = new PushTooFarReactionInfoWME(0, true, 0, -1, 1, 15);
        this.storyMemory.addWME(pushTooFarReactionInfoWME18);
        this.createShadowFact("pushTooFarReactionInfo", pushTooFarReactionInfoWME18);
        final PushTooFarReactionInfoWME pushTooFarReactionInfoWME19 = new PushTooFarReactionInfoWME(0, true, 1, -1, 1, 15);
        this.storyMemory.addWME(pushTooFarReactionInfoWME19);
        this.createShadowFact("pushTooFarReactionInfo", pushTooFarReactionInfoWME19);
    }
    
    private final void createRxnCategoryLevelWMEs() {
        final RxnCategoryLevelWME rxnCategoryLevelWME = new RxnCategoryLevelWME(0);
        this.storyMemory.addWME(rxnCategoryLevelWME);
        this.createShadowFact("rxnCategoryLevel", rxnCategoryLevelWME);
        final RxnCategoryLevelWME rxnCategoryLevelWME2 = new RxnCategoryLevelWME(1);
        this.storyMemory.addWME(rxnCategoryLevelWME2);
        this.createShadowFact("rxnCategoryLevel", rxnCategoryLevelWME2);
        final RxnCategoryLevelWME rxnCategoryLevelWME3 = new RxnCategoryLevelWME(2);
        this.storyMemory.addWME(rxnCategoryLevelWME3);
        this.createShadowFact("rxnCategoryLevel", rxnCategoryLevelWME3);
        final RxnCategoryLevelWME rxnCategoryLevelWME4 = new RxnCategoryLevelWME(3);
        this.storyMemory.addWME(rxnCategoryLevelWME4);
        this.createShadowFact("rxnCategoryLevel", rxnCategoryLevelWME4);
        final RxnCategoryLevelWME rxnCategoryLevelWME5 = new RxnCategoryLevelWME(4);
        this.storyMemory.addWME(rxnCategoryLevelWME5);
        this.createShadowFact("rxnCategoryLevel", rxnCategoryLevelWME5);
        final RxnCategoryLevelWME rxnCategoryLevelWME6 = new RxnCategoryLevelWME(5);
        this.storyMemory.addWME(rxnCategoryLevelWME6);
        this.createShadowFact("rxnCategoryLevel", rxnCategoryLevelWME6);
        final RxnCategoryLevelWME rxnCategoryLevelWME7 = new RxnCategoryLevelWME(6);
        this.storyMemory.addWME(rxnCategoryLevelWME7);
        this.createShadowFact("rxnCategoryLevel", rxnCategoryLevelWME7);
        final RxnCategoryLevelWME rxnCategoryLevelWME8 = new RxnCategoryLevelWME(7);
        this.storyMemory.addWME(rxnCategoryLevelWME8);
        this.createShadowFact("rxnCategoryLevel", rxnCategoryLevelWME8);
        final RxnCategoryLevelWME rxnCategoryLevelWME9 = new RxnCategoryLevelWME(8);
        this.storyMemory.addWME(rxnCategoryLevelWME9);
        this.createShadowFact("rxnCategoryLevel", rxnCategoryLevelWME9);
        final RxnCategoryLevelWME rxnCategoryLevelWME10 = new RxnCategoryLevelWME(9);
        this.storyMemory.addWME(rxnCategoryLevelWME10);
        this.createShadowFact("rxnCategoryLevel", rxnCategoryLevelWME10);
        final RxnCategoryLevelWME rxnCategoryLevelWME11 = new RxnCategoryLevelWME(10);
        this.storyMemory.addWME(rxnCategoryLevelWME11);
        this.createShadowFact("rxnCategoryLevel", rxnCategoryLevelWME11);
        final RxnCategoryLevelWME rxnCategoryLevelWME12 = new RxnCategoryLevelWME(11);
        this.storyMemory.addWME(rxnCategoryLevelWME12);
        this.createShadowFact("rxnCategoryLevel", rxnCategoryLevelWME12);
        final RxnCategoryLevelWME rxnCategoryLevelWME13 = new RxnCategoryLevelWME(12);
        this.storyMemory.addWME(rxnCategoryLevelWME13);
        this.createShadowFact("rxnCategoryLevel", rxnCategoryLevelWME13);
        final RxnCategoryLevelWME rxnCategoryLevelWME14 = new RxnCategoryLevelWME(13);
        this.storyMemory.addWME(rxnCategoryLevelWME14);
        this.createShadowFact("rxnCategoryLevel", rxnCategoryLevelWME14);
        final RxnCategoryLevelWME rxnCategoryLevelWME15 = new RxnCategoryLevelWME(14);
        this.storyMemory.addWME(rxnCategoryLevelWME15);
        this.createShadowFact("rxnCategoryLevel", rxnCategoryLevelWME15);
        final RxnCategoryLevelWME rxnCategoryLevelWME16 = new RxnCategoryLevelWME(15);
        this.storyMemory.addWME(rxnCategoryLevelWME16);
        this.createShadowFact("rxnCategoryLevel", rxnCategoryLevelWME16);
    }
    
    private final /* synthetic */ void this() {
        this.activeContexts = new Hashtable();
        this.activeReactionPriorityMaps = new HashSet();
        this.activeContextPriorityMap = null;
        this.activeSelector = "Selector_Standard";
        this.centricCharID = -1;
    }
    
    public ReactionDecider() {
        this.this();
        this.engine = new Rete();
        this.storyMemory = WorkingMemory.lookupRegisteredMemory("StoryMemory");
        if (this.storyMemory == null) {
            throw new RuntimeException("Couldn't find story memory. Unable to build ReactionDecider.");
        }
        try {
            this.readAndExecute("nlu/reaction/ReactionUtilities");
            this.readAndExecute("nlu/reaction/Proposer_GlobalMixIn");
            this.readAndExecute("nlu/reaction/Proposer_DuringMixin");
            this.readAndExecute("nlu/reaction/Proposer_DuringMixin_old");
            this.readAndExecute("nlu/reaction/Proposer_DuringBeatMixin");
            this.readAndExecute("nlu/reaction/Proposer_DuringTxnOut");
            this.readAndExecute("nlu/reaction/Proposer_IgnoreAllButRecovery");
            this.readAndExecute("nlu/reaction/Proposer_IgnoreMost");
            this.readAndExecute("nlu/reaction/Proposer_IgnoreThanks");
            this.readAndExecute("nlu/reaction/Proposer_TGreetsP");
            this.readAndExecute("nlu/reaction/Proposer_TGreetsP_TxnOut");
            this.readAndExecute("nlu/reaction/Proposer_GGreetsP");
            this.readAndExecute("nlu/reaction/Proposer_GGreetsPKiss");
            this.readAndExecute("nlu/reaction/Proposer_ExplDatAnniv");
            this.readAndExecute("nlu/reaction/Proposer_AA");
            this.readAndExecute("nlu/reaction/Proposer_AA_postTellMeMore");
            this.readAndExecute("nlu/reaction/Proposer_RM_ItalyGuessingGame");
            this.readAndExecute("nlu/reaction/Proposer_RM_PlayerNotAtPicture");
            this.readAndExecute("nlu/reaction/Proposer_FAskDrink");
            this.readAndExecute("nlu/reaction/Proposer_PhoneCall");
            this.readAndExecute("nlu/reaction/Proposer_TxnT1ToT2");
            this.readAndExecute("nlu/reaction/Proposer_OneOnOneAffChr");
            this.readAndExecute("nlu/reaction/Proposer_OneOnOneAffChr_xtra");
            this.readAndExecute("nlu/reaction/Proposer_OneOnOneNonAffChr");
            this.readAndExecute("nlu/reaction/Proposer_NonAffChrGReturns");
            this.readAndExecute("nlu/reaction/Proposer_NonAffChrGReturns_xtra");
            this.readAndExecute("nlu/reaction/Proposer_NonAffChrTReturns");
            this.readAndExecute("nlu/reaction/Proposer_RomanticProposal");
            this.readAndExecute("nlu/reaction/Proposer_BigQuestion");
            this.readAndExecute("nlu/reaction/Proposer_CrisisP1");
            this.readAndExecute("nlu/reaction/Proposer_C2TGGlue");
            this.readAndExecute("nlu/reaction/Proposer_TherapyGameP2");
            this.readAndExecute("nlu/reaction/Proposer_RevelationsP2");
            this.readAndExecute("nlu/reaction/Proposer_Ending");
            this.readAndExecute("nlu/reaction/ContextPriorityMap_GlobalTrumpsBeat");
            this.readAndExecute("nlu/reaction/ContextPriorityMap_GlobalTrumpsBeat_obj");
            this.readAndExecute("nlu/reaction/ContextPriorityMap_GlobalTrumpsBeat_veryHighPri");
            this.readAndExecute("nlu/reaction/Selector_Standard");
            this.engine.executeCommand("(set-current-module CONTEXT_GLOBALMIXIN)");
        }
        catch (JessException ex) {
            throw new RuntimeException(ex);
        }
        catch (IOException ex2) {
            throw new RuntimeException(ex2);
        }
        this.createObjectReactionInfoWMEs();
        this.createSatelliteReactionInfoWMEs();
        this.createDAReactionInfoWMEs();
        this.createPushTooFarReactionInfoWMEs();
        this.createRxnCategoryLevelWMEs();
        final RxnDeciderMiscWME rxnDeciderMiscWME = new RxnDeciderMiscWME();
        this.storyMemory.addWME(rxnDeciderMiscWME);
        this.createShadowFact("rxnDeciderMisc", rxnDeciderMiscWME);
        rxnDeciderMiscWME.setSatelliteFreebieCtr(0);
        rxnDeciderMiscWME.setOkayToPushTooFar(false);
        try {
            this.engine.executeCommand("(set-current-module MAIN)");
        }
        catch (JessException ex3) {
            throw new RuntimeException(ex3);
        }
        final TopicReferenceCountWME topicReferenceCountWME = new TopicReferenceCountWME(59);
        this.storyMemory.addWME(topicReferenceCountWME);
        this.createShadowFact("topicReferenceCount", topicReferenceCountWME);
        final TopicReferenceCountWME topicReferenceCountWME2 = new TopicReferenceCountWME(60);
        this.storyMemory.addWME(topicReferenceCountWME2);
        this.createShadowFact("topicReferenceCount", topicReferenceCountWME2);
        final TopicReferenceCountWME topicReferenceCountWME3 = new TopicReferenceCountWME(61);
        this.storyMemory.addWME(topicReferenceCountWME3);
        this.createShadowFact("topicReferenceCount", topicReferenceCountWME3);
        final LinkedList lookupWME = this.storyMemory.lookupWME("StoryStatusWME");
        if (!ReactionDecider.$noassert && lookupWME.size() != 1) {
            throw new AssertionError();
        }
        this.createShadowFact("storyStatus", (WME)lookupWME.get(0));
        final LinkedList lookupWME2 = this.storyMemory.lookupWME("TensionStoryValueWME");
        if (!ReactionDecider.$noassert && lookupWME2.size() != 1) {
            throw new AssertionError();
        }
        this.createShadowFact("tension", (WME)lookupWME2.get(0));
        final PlayerInfoWME playerInfoWME = new PlayerInfoWME();
        this.storyMemory.addWME(playerInfoWME);
        this.createShadowFact("playerInfo", playerInfoWME);
        final PatternCountWME patternCountWME = new PatternCountWME(0);
        this.storyMemory.addWME(patternCountWME);
        this.createShadowFact("patternCount", patternCountWME);
        final PatternCountWME patternCountWME2 = new PatternCountWME(1);
        this.storyMemory.addWME(patternCountWME2);
        this.createShadowFact("patternCount", patternCountWME2);
        final PatternCountWME patternCountWME3 = new PatternCountWME(2);
        this.storyMemory.addWME(patternCountWME3);
        this.createShadowFact("patternCount", patternCountWME3);
        final PatternCountWME patternCountWME4 = new PatternCountWME(3);
        this.storyMemory.addWME(patternCountWME4);
        this.createShadowFact("patternCount", patternCountWME4);
        final PatternCountWME patternCountWME5 = new PatternCountWME(4);
        this.storyMemory.addWME(patternCountWME5);
        this.createShadowFact("patternCount", patternCountWME5);
        final PatternCountWME patternCountWME6 = new PatternCountWME(5);
        this.storyMemory.addWME(patternCountWME6);
        this.createShadowFact("patternCount", patternCountWME6);
        final PatternCountWME patternCountWME7 = new PatternCountWME(6);
        this.storyMemory.addWME(patternCountWME7);
        this.createShadowFact("patternCount", patternCountWME7);
        final PatternCountWME patternCountWME8 = new PatternCountWME(7);
        this.storyMemory.addWME(patternCountWME8);
        this.createShadowFact("patternCount", patternCountWME8);
        final PatternCountWME patternCountWME9 = new PatternCountWME(8);
        this.storyMemory.addWME(patternCountWME9);
        this.createShadowFact("patternCount", patternCountWME9);
        final LinkedList lookupWME3 = this.storyMemory.lookupWME("PostBeatMixinInfoWME");
        if (!ReactionDecider.$noassert && lookupWME3.size() != 1) {
            throw new AssertionError();
        }
        this.createShadowFact("postBeatMixinInfo", (WME)lookupWME3.get(0));
        try {
            this.engine.executeCommand("(reset)");
        }
        catch (JessException ex4) {
            throw new RuntimeException(ex4);
        }
        this.engine.addJessListener(new FactListener());
        this.engine.setEventMask(20496);
    }
    
    static {
        $noassert = (Class.forName("[Lnlu.reaction.ReactionDecider;").getComponentType().desiredAssertionStatus() ^ true);
    }
    
    class ReactionThread extends Thread
    {
        final /* synthetic */ List val$das;
        private static final /* synthetic */ boolean $noassert;
        
        public void run() {
            try {
                ReactionDecider.this.engine.executeCommand("(reset)");
                ReactionDecider.this.engine.executeCommand("(assert (centricChar (id " + ReactionDecider.this.centricCharID + ")))");
                final Iterator<DAWME> iterator = this.val$das.iterator();
                while (iterator.hasNext()) {
                    ReactionDecider.this.addDA(iterator.next());
                }
                final Enumeration<String> keys = ReactionDecider.this.activeContexts.keys();
                while (keys.hasMoreElements()) {
                    final String s = keys.nextElement();
                    ReactionDecider.this.engine.executeCommand("(assert (activeContext (name " + s.toUpperCase() + ") (priority " + (int)ReactionDecider.this.activeContexts.get(s) + ")))");
                }
                final Iterator<String> iterator2 = ReactionDecider.this.activeReactionPriorityMaps.iterator();
                while (iterator2.hasNext()) {
                    ReactionDecider.this.engine.executeCommand("(assert (activePriorityMapper (name " + iterator2.next().toUpperCase() + ")))");
                }
                if (ReactionDecider.this.activeContextPriorityMap != null) {
                    ReactionDecider.this.engine.executeCommand("(assert (activeContextMapper (name " + ReactionDecider.this.activeContextPriorityMap.toUpperCase() + ")))");
                }
                if (!ReactionThread.$noassert && ReactionDecider.this.activeSelector == null) {
                    throw new AssertionError();
                }
                ReactionDecider.this.engine.executeCommand("(assert (activeSelector (name " + ReactionDecider.this.activeSelector.toUpperCase() + ")))");
                ReactionDecider.this.engine.executeCommand("(run)");
                ReactionDecider.this.engine.executeCommand("(halt)");
            }
            catch (JessException ex) {
                NativeAnimationInterface.addEventInfoToLog(ex.toString());
                if (ex.getCause() != null) {
                    System.out.println(ex.getCause());
                }
                System.out.println(ex.getRoutine() + ' ' + ex.getContext() + ' ' + ex.getProgramText() + ' ' + ex.getData() + ' ' + ex.getLineNumber());
                ex.printStackTrace();
            }
        }
        
        ReactionThread(final List val$das) {
            this.val$das = val$das;
        }
        
        static {
            $noassert = (Class.forName("[Lnlu.reaction.ReactionDecider;").getComponentType().desiredAssertionStatus() ^ true);
        }
    }
}
