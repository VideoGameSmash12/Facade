package facade;

import facade.characters.wmedef.PostBeatMixinInfoWME;
import facade.characters.wmedef.AnaphoricReferenceWME;
import facade.characters.player.java.Player;
import facade.characters.grace.java.Grace;
import facade.characters.trip.java.Trip;
import facade.characters.wmedef.AnaphoricReferenceWME;
import facade.characters.wmedef.PostBeatMixinInfoWME;
import facade.util.StringUtil;
import facade.nativeinterface.NativeAnimationInterface;
import TemplateCompiler.NLUMain;

public class Main
{
    private static final String generateEventLog = "generateEventLog";
    private static final String noEventLog = "noEventLog";
    
    private static final void respondToError(final Throwable t, final boolean b) {
        NativeAnimationInterface.addEventInfoToLog(t.toString());
        StringUtil.println(t.toString());
        if (b) {
            System.exit(1);
        }
    }
    
    public static void main(final String[] p0) {
        if (paramArrayOfString.length > 0 && paramArrayOfString[0].equals("generateEventLog"))
            StringUtil.setGenerateEventLog(); 
        try {
            WorkingMemory workingMemory = new WorkingMemory("BeatMemory");
            DramaManager dramaManager = new DramaManager("facade.beats", false, false);
            ProvocativeContentArchive provocativeContentArchive = new ProvocativeContentArchive();
            IntermediateContentArchive intermediateContentArchive = new IntermediateContentArchive();
            CrisisAccusationMapping crisisAccusationMapping = new CrisisAccusationMapping();
            CrisisCalculus crisisCalculus = new CrisisCalculus();
            TherapyGameState therapyGameState = new TherapyGameState();
            RawReactionDAArchive rawReactionDAArchive = new RawReactionDAArchive();
            
            try {
                TripThread tripThread;
                GraceThread graceThread;
                NluTemplateThread nluTemplateThread;
                StringUtil.initializeEventLog();
                PostBeatMixinInfoWME postBeatMixinInfoWME = new PostBeatMixinInfoWME();
                WorkingMemory.addWME("StoryMemory", (WME)postBeatMixinInfoWME);
                PlayerThread playerThread = new PlayerThread();
                playerThread.setPriority(5);
                playerThread.start();
                
                synchronized (playerThread) {
                    playerThread.wait();
                    tripThread = new TripThread();
                    tripThread.setPriority(5);
                    tripThread.start();
                } 
                synchronized (tripThread) {
                    tripThread.wait();
                    graceThread = new GraceThread();
                    graceThread.setPriority(5);
                    graceThread.start();
                } 
                synchronized (graceThread) {
                    graceThread.wait();
                    AnaphoricReferenceWME anaphoricReferenceWME = new AnaphoricReferenceWME();
                    WorkingMemory.addWME("StoryMemory", (WME)anaphoricReferenceWME);
                    nluTemplateThread = new NluTemplateThread(anaphoricReferenceWME, postBeatMixinInfoWME);
                    nluTemplateThread.setPriority(6);
                    nluTemplateThread.start();
                } 
                synchronized (nluTemplateThread) {
                    nluTemplateThread.wait();
                } 
            } catch (InterruptedException interruptedException) {
                throw new RuntimeError("Wait interrupted " + interruptedException);
            } 
        } catch (Throwable throwable) {
            respondToError(throwable, true);
        } 
    }
    
    class TripThread extends Thread
    {
        private Trip trip;
        
        public void run() {
            try {
                this.trip = new Trip();
                synchronized (this) {
                    notify();
                    this.trip.startBehaving();
                } 
            } catch (Error error) {
                Main.respondToError(error, true);
            } 
        }
    }
    
    class GraceThread extends Thread
    {
        private Grace grace;
        
        public void run() {
            try {
                this.grace = new Grace();
                synchronized (this) {
                    notify();
                    this.grace.startBehaving();
                } 
            } catch (Error error) {
                Main.respondToError(error, true);
            }
        }
    }
    
    class PlayerThread extends Thread
    {
        private Player player;
        
        public void run() {
            try {
                this.player = new Player();
                synchronized (this) {
                    notify();
                    this.player.startBehaving();
                } 
            } catch (Error error) {
                Main.respondToError(error, true);
            } 
        }
    }
    
    class NluTemplateThread extends Thread
    {
        private final AnaphoricReferenceWME anaphoricRefWME;
        private final PostBeatMixinInfoWME postBeatMixinWME;
        
        public void run() {
            try {
                NLUMain nLUMain = new NLUMain("general.rul", "general.map", "DummyBeat", this.anaphoricRefWME, this.postBeatMixinWME);
                synchronized (this) {
                    notify();
                    nLUMain.startNLU();
                } 
            } catch (Error error) {
                Main.respondToError(error, true);
            } catch (RuntimeException runtimeException) {
                Main.respondToError(runtimeException, false);
            } 
        }
        
        NluTemplateThread(final AnaphoricReferenceWME anaphoricRefWME, final PostBeatMixinInfoWME postBeatMixinWME) {
            this.anaphoricRefWME = anaphoricRefWME;
            this.postBeatMixinWME = postBeatMixinWME;
        }
    }
}
