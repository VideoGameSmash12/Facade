package facade.util;

import facade.nativeinterface.NativeAnimationInterface;
import java.io.IOException;
import java.io.PrintStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.io.File;
import java.text.SimpleDateFormat;

public class StringUtil implements SpriteID
{
    private static final boolean printToConsole = true;
    private static boolean printToFile;
    private static boolean printToFile_commandLine;
    private static final SimpleDateFormat dateFormatter;
    private static TStream logFile;
    
    public static void setGenerateEventLog() {
        StringUtil.printToFile_commandLine = true;
    }
    
    public static void initializeEventLog() {
        if (!StringUtil.printToFile && StringUtil.printToFile_commandLine) {
            StringUtil.printToFile = true;
        }
        if (StringUtil.printToFile) {
            final File file = new File("eventlogs/");
            if (!file.exists()) {
                file.mkdir();
            }
            final File file2 = new File("eventlogs/" + ("AI Log " + StringUtil.dateFormatter.format(new Date()) + ".txt"));
            try {
                final FileOutputStream fileOutputStream = new FileOutputStream(file2, true);
                Runtime.getRuntime().addShutdownHook(new FlushLogFileThread());
                System.setErr(StringUtil.logFile = new TStream(fileOutputStream));
            }
            catch (IOException ex) {
                throw new Error(ex);
            }
        }
        else {
            StringUtil.logFile = null;
        }
    }
    
    public static void println(final String s) {
        final int tickCount = NativeAnimationInterface.getTickCount();
        System.out.println(new StringBuffer().append(tickCount).append(' ').append(s).toString());
        if (StringUtil.printToFile) {
            StringUtil.logFile.printToLog(new StringBuffer().append(tickCount).append(' ').append(s).toString());
        }
    }
    
    public static boolean stringContains(String s, final String s2) {
        final char char1 = s.charAt(s.length() - 1);
        if (char1 == '.' || char1 == '?' || char1 == '!') {
            s = s.substring(0, s.length() - 1);
        }
        s = " " + s + ' ';
        return s.indexOf(" " + s2 + ' ') != -1 || s.equals(s2);
    }
    
    static {
        StringUtil.printToFile = false;
        StringUtil.printToFile_commandLine = false;
        dateFormatter = new SimpleDateFormat("EEE MMM d HH mm ss yyyy");
    }
    
    private static class FlushLogFileThread extends Thread
    {
        public void run() {
            if (StringUtil.logFile != null) {
                StringUtil.logFile.flush();
            }
        }
    }
    
    private static class TStream extends PrintStream
    {
        public void println(final String s) {
            super.println(s);
            System.out.println(s);
        }
        
        public void printToLog(final String s) {
            super.println(s);
        }
        
        public void flush() {
            super.flush();
            System.out.flush();
        }
        
        public TStream(final OutputStream outputStream) {
            super(outputStream);
        }
    }
}
