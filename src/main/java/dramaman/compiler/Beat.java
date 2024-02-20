package dramaman.compiler;

import java.util.ListIterator;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.File;
import java.util.LinkedList;

public class Beat
{
    private static LinkedList sourceFiles;
    private static String objectDirectoryName;
    static File objectDirectory;
    private static boolean dumpTree;
    
    private static final void processCommandlineArgs(final String[] array) {
        for (int i = 0; i < array.length; ++i) {
            if (array[i].startsWith("-d")) {
                if (++i >= array.length) {
                    usage();
                    System.exit(1);
                }
                else {
                    Beat.objectDirectoryName = array[i];
                }
            }
            else if (array[i].startsWith("-X")) {
                if (++i >= array.length) {
                    usage();
                    System.exit(1);
                }
                else if (array[i].equals("dumpTree")) {
                    Beat.dumpTree = true;
                }
                else {
                    usage();
                    System.exit(1);
                }
            }
            else {
                Beat.sourceFiles.add(array[i]);
            }
        }
        if (Beat.objectDirectoryName != null) {
            Beat.objectDirectory = new File(Beat.objectDirectoryName);
        }
        else {
            Beat.objectDirectory = new File(".");
        }
    }
    
    private static final void usage() {
        System.out.println("beat [-d <object directory>] [-X dumpTree] <beat source file>+");
    }
    
    public static void main(final String[] array) throws CompileException {
        processCommandlineArgs(array);
        if (array.length == 0) {
            usage();
        }
        else {
            final ListIterator listIterator = Beat.sourceFiles.listIterator();
            while (listIterator.hasNext()) {
                final String s = listIterator.next();
                System.out.println("Reading from file " + s + " . . .");
                try {
                    final BeatParser beatParser = new BeatParser(new FileInputStream(s));
                    final ASTBeatTopLevel beatTopLevel = BeatParser.BeatTopLevel();
                    System.out.println(s + " parsed successfully.");
                    if (Beat.dumpTree) {
                        beatTopLevel.dump("");
                    }
                    System.out.println("Generating code . . .");
                    beatTopLevel.compileToJava();
                }
                catch (FileNotFoundException ex3) {
                    System.out.println("Beat Parser: File " + s + " not found.");
                }
                catch (ParseException ex) {
                    System.out.println(ex.getMessage());
                    System.out.println("Beat Parser: Encountered errors during parse.");
                }
                catch (CompileException ex2) {
                    System.out.println(ex2.getMessage());
                }
            }
        }
    }
    
    static {
        Beat.sourceFiles = new LinkedList();
        Beat.objectDirectoryName = null;
        Beat.dumpTree = false;
    }
}
