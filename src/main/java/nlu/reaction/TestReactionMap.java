package nlu.reaction;

import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import jess.Main;
import java.awt.Component;
import javax.swing.JSplitPane;
import jess.ConsolePanel;
import facade.characters.wmedef.BeatAAp1WME;
import facade.characters.wmedef.PatternCountWME;
import dramaman.runtime.TensionStoryValueWME;
import dramaman.runtime.StoryStatusWME;
import facade.characters.wmedef.TopicReferenceCountWME;
import facade.characters.wmedef.BeatStatusWME;
import jess.JessException;
import wm.WME;
import jess.Rete;
import wm.WorkingMemoryDebugger;
import wm.WorkingMemory;
import facade.util.BeatID;
import facade.util.SpriteID;
import dramaman.runtime.DramaManagerConstants;
import facade.util.DAType;
import facade.util.ReactionID;
import javax.swing.JFrame;

public class TestReactionMap extends JFrame implements ReactionID, DAType, DramaManagerConstants, SpriteID, BeatID
{
    private WorkingMemory memory;
    private WorkingMemoryDebugger memoryDebugger;
    private Rete engine;
    
    private final void createShadowFact(final String s, final WME wme) {
        this.engine.store("__factKey", s);
        this.engine.store("__wmeKey", wme);
        try {
            this.engine.executeCommand("(shadowWME __factKey __wmeKey)");
        }
        catch (JessException ex) {
            throw new Error(ex.getMessage());
        }
    }
    
    private final void initializeDiscourseManager() {
        try {
            this.engine.executeCommand("(batch nlu/reaction/load.jess)");
            this.engine.executeCommand("(set-current-module CONTEXT_GLOBALMIXIN)");
        }
        catch (JessException ex) {
            throw new Error(ex.getMessage());
        }
        try {
            this.engine.executeCommand("(set-current-module MAIN)");
        }
        catch (JessException ex2) {
            throw new Error(ex2.getMessage());
        }
        final BeatStatusWME beatStatusWME = new BeatStatusWME(0, false, false);
        this.memory.addWME(beatStatusWME);
        this.createShadowFact("beatStatus", beatStatusWME);
        final TopicReferenceCountWME topicReferenceCountWME = new TopicReferenceCountWME(59);
        this.memory.addWME(topicReferenceCountWME);
        topicReferenceCountWME.setCount(0);
        this.createShadowFact("topicReferenceCount", topicReferenceCountWME);
        final TopicReferenceCountWME topicReferenceCountWME2 = new TopicReferenceCountWME(60);
        this.memory.addWME(topicReferenceCountWME2);
        topicReferenceCountWME2.setCount(0);
        this.createShadowFact("topicReferenceCount", topicReferenceCountWME2);
        final TopicReferenceCountWME topicReferenceCountWME3 = new TopicReferenceCountWME(61);
        this.memory.addWME(topicReferenceCountWME3);
        topicReferenceCountWME3.setCount(0);
        this.createShadowFact("topicReferenceCount", topicReferenceCountWME3);
        final StoryStatusWME storyStatusWME = new StoryStatusWME();
        this.memory.addWME(storyStatusWME);
        storyStatusWME.setAffinity(-1);
        storyStatusWME.setCurrentBeat(16);
        this.createShadowFact("storyStatus", storyStatusWME);
        final TensionStoryValueWME tensionStoryValueWME = new TensionStoryValueWME(1.0f);
        this.memory.addWME(tensionStoryValueWME);
        this.createShadowFact("tension", tensionStoryValueWME);
        final PatternCountWME patternCountWME = new PatternCountWME(0);
        this.memory.addWME(patternCountWME);
        this.createShadowFact("patternCount", patternCountWME);
        final PatternCountWME patternCountWME2 = new PatternCountWME(1);
        this.memory.addWME(patternCountWME2);
        this.createShadowFact("patternCount", patternCountWME2);
        final PatternCountWME patternCountWME3 = new PatternCountWME(2);
        this.memory.addWME(patternCountWME3);
        this.createShadowFact("patternCount", patternCountWME3);
        final PatternCountWME patternCountWME4 = new PatternCountWME(3);
        patternCountWME4.setCount(5);
        this.memory.addWME(patternCountWME4);
        this.createShadowFact("patternCount", patternCountWME4);
        final PatternCountWME patternCountWME5 = new PatternCountWME(4);
        this.memory.addWME(patternCountWME5);
        this.createShadowFact("patternCount", patternCountWME5);
        final PatternCountWME patternCountWME6 = new PatternCountWME(5);
        this.memory.addWME(patternCountWME6);
        this.createShadowFact("patternCount", patternCountWME6);
        final PatternCountWME patternCountWME7 = new PatternCountWME(6);
        this.memory.addWME(patternCountWME7);
        this.createShadowFact("patternCount", patternCountWME7);
        final PatternCountWME patternCountWME8 = new PatternCountWME(7);
        this.memory.addWME(patternCountWME8);
        this.createShadowFact("patternCount", patternCountWME8);
        final PatternCountWME patternCountWME9 = new PatternCountWME(8);
        this.memory.addWME(patternCountWME9);
        this.createShadowFact("patternCount", patternCountWME9);
        final BeatAAp1WME beatAAp1WME = new BeatAAp1WME();
        beatAAp1WME.setSubtopic(88);
        this.createShadowFact("beatAAp1Status", beatAAp1WME);
    }
    
    public void initialize() {
        this.engine = new Rete();
        final ConsolePanel consolePanel = new ConsolePanel(this.engine);
        final JSplitPane splitPane = new JSplitPane(0, true, this.memoryDebugger, consolePanel);
        splitPane.setOneTouchExpandable(true);
        this.getContentPane().add(splitPane);
        this.pack();
        this.setVisible(true);
        final Main main = new Main();
        main.initialize(new String[0], this.engine);
        consolePanel.setFocus();
        this.addWindowListener(new WindowAdapter() {
            public final void windowClosing(final WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        this.initializeDiscourseManager();
        while (true) {
            main.execute(true);
        }
    }
    
    public static void main(final String[] array) {
        new TestReactionMap().initialize();
    }
    
    public TestReactionMap() {
        this.memory = new WorkingMemory();
        this.memoryDebugger = new WorkingMemoryDebugger(this.memory);
    }
}
