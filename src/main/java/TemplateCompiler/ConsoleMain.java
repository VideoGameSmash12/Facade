package TemplateCompiler;

import java.util.Iterator;
import jess.JessException;
import wm.WME;
import facade.characters.wmedef.PostBeatMixinInfoWME;
import facade.characters.wmedef.AnaphoricReferenceWME;
import java.util.HashSet;
import abl.runtime.RuntimeError;
import java.io.ObjectInputStream;
import java.io.InputStream;
import java.util.zip.InflaterInputStream;
import java.io.FileInputStream;
import java.awt.Component;
import javax.swing.JFrame;
import wm.WorkingMemory;
import jess.JessListener;
import java.io.IOException;
import java.util.Hashtable;
import jess.Rete;

public class ConsoleMain
{
    private static Rete nluEngine;
    private static Hashtable beatNameToTemplateName;
    private static Hashtable templateNameToTemplates;
    
    public static String readString() {
        String string = "";
        boolean b = false;
        while (!b) {
            try {
                final int read = System.in.read();
                if (read < 0 || (char)read == '\n') {
                    b = true;
                }
                else {
                    string += (char)read;
                }
            }
            catch (IOException ex) {
                b = true;
            }
        }
        return string.substring(0, string.length() - 1);
    }
    
    private static final void usage() {
        System.out.println("Usage:");
        System.out.println("java TemplateCompiler/ConsoleMain <rule_file> <map_file> <initial_beat_name>");
        System.exit(0);
    }
    
    public static void main(final String[] array) throws IOException {
        if (array.length == 0) {
            usage();
        }
        ConsoleMain.nluEngine = new RefCountRete();
        final TimeOut timeOut = new TimeOut(ConsoleMain.nluEngine);
        ConsoleMain.nluEngine.addJessListener(new DebugListener(false));
        ConsoleMain.nluEngine.setEventMask(ConsoleMain.nluEngine.getEventMask() | 0x10 | 0x2 | 0x1000);
        final WorkingMemory workingMemory = new WorkingMemory("TripMemory");
        final JFrame frame = new JFrame("Test Memory Debugger");
        frame.getContentPane().add(workingMemory.getWMDebugInterface());
        frame.pack();
        frame.setVisible(true);
        ConsoleMain.nluEngine.addJessListener(new FactListener(new TimeOut(ConsoleMain.nluEngine)));
        if (array.length != 3) {
            usage();
        }
        final String s = array[0];
        final String s2 = array[1];
        final String s3 = array[2];
        try {
            System.out.println("InitializeReteEngine...");
            Preprocessor.initializeReteEngine(ConsoleMain.nluEngine);
            final FileInputStream fileInputStream = new FileInputStream(s);
            ConsoleMain.templateNameToTemplates = (Hashtable)new ObjectInputStream(new InflaterInputStream(fileInputStream)).readObject();
            fileInputStream.close();
            final FileInputStream fileInputStream2 = new FileInputStream(s2);
            ConsoleMain.beatNameToTemplateName = (Hashtable)new ObjectInputStream(new InflaterInputStream(fileInputStream2)).readObject();
            fileInputStream2.close();
        }
        catch (Exception ex) {
            throw new RuntimeError("NLU: While loading objects " + ex);
        }
        final HashSet<String> set = ConsoleMain.beatNameToTemplateName.get(s3);
        final HashSet<String> set2 = ConsoleMain.templateNameToTemplates.get("_CONST");
        final Iterator<String> iterator = set.iterator();
        final Iterator<String> iterator2 = set2.iterator();
        try {
            final long currentTimeMillis = System.currentTimeMillis();
            System.out.println("Reading template rules...");
            int n = 0;
            while (iterator.hasNext()) {
                ((RefCountRete)ConsoleMain.nluEngine).executeCommands((String)ConsoleMain.templateNameToTemplates.get(iterator.next()));
                if (n % 10 == 0) {
                    System.out.print(new StringBuffer().append(n).append(' ').toString());
                }
                ++n;
            }
            System.out.println(n + " done");
            System.out.println("Unique Rules: " + ((RefCountRete)ConsoleMain.nluEngine).getUniqueRules());
            System.out.println("Shared refs to unique rules: " + ((RefCountRete)ConsoleMain.nluEngine).getSharedRuleRefs());
            System.out.println("Redefined shared rules (because of salience): " + ((RefCountRete)ConsoleMain.nluEngine).getRedefinedRules());
            System.out.println("Reading constants...");
            while (iterator2.hasNext()) {
                ConsoleMain.nluEngine.executeCommand(iterator2.next());
            }
            System.out.println("Load time = " + (System.currentTimeMillis() - currentTimeMillis) / 1000.0f);
            System.out.println("NLU is started");
            final AnaphoricReferenceWME anaphoricReferenceWME = new AnaphoricReferenceWME();
            final PostBeatMixinInfoWME postBeatMixinInfoWME = new PostBeatMixinInfoWME();
            workingMemory.addWME(anaphoricReferenceWME);
            workingMemory.addWME(postBeatMixinInfoWME);
            ConsoleMain.nluEngine.store("__factKey", "anaphoricRef");
            ConsoleMain.nluEngine.store("__wmeKey", anaphoricReferenceWME);
            ConsoleMain.nluEngine.executeCommand("(shadowWME __factKey __wmeKey)");
            ConsoleMain.nluEngine.store("__factKey", "postBeatMixinInfo");
            ConsoleMain.nluEngine.store("__wmeKey", postBeatMixinInfoWME);
            ConsoleMain.nluEngine.executeCommand("(shadowWME __factKey __wmeKey)");
        }
        catch (JessException ex2) {
            throw new Error(ex2.getMessage());
        }
        System.out.println("NLU is started");
        while (true) {
            System.out.println("Waiting for input...  Type 'q' to quit\n");
            final String string = readString();
            final long currentTimeMillis2 = System.currentTimeMillis();
            try {
                if (string.equals("q") || string.equals("Q")) {
                    System.out.println("### Player quit the experience");
                    System.exit(0);
                }
                if (string.charAt(0) == '(') {
                    ConsoleMain.nluEngine.executeCommand(string);
                }
                else {
                    Preprocessor.Process(string, ConsoleMain.nluEngine);
                    ConsoleMain.nluEngine.run();
                    ConsoleMain.nluEngine.reset();
                    System.out.println("Time taken for engine to run: " + (System.currentTimeMillis() - currentTimeMillis2));
                }
            }
            catch (JessException ex3) {
                JessExceptionHelper.processJessException(ex3);
            }
        }
    }
}
