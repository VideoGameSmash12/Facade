package macro;

import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.File;
import java.io.Writer;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.io.StringReader;

public class SimpleMacro
{
    private static final char macroAppendChar = '@';
    private static final boolean slashSlashComments = true;
    private static final boolean slashStarComments = true;
    private static final char singleLineCommentChar = '#';
    public final int maxArguments = 20;
    private boolean macroDefined;
    private String[] arguments;
    private int numberOfArguments;
    private String macroName;
    private String macroBody;
    
    private final int argLookup(final String s) {
        for (int i = 0; i < this.arguments.length; ++i) {
            if (s.equals(this.arguments[i])) {
                return i;
            }
        }
        return -1;
    }
    
    public String expand(final String[] array) throws SimpleMacroException {
        StringReader stringReader = null;
        try {
            if (array == null) {
                if (this.numberOfArguments != 0) {
                    throw new SimpleMacroException("The number of expansion arguments for macro " + this.macroName + " does not equal the number of macro arguments.");
                }
            }
            else if (array.length != this.numberOfArguments) {
                throw new SimpleMacroException("The number of expansion arguments for macro " + this.macroName + " does not equal the number of macro arguments.");
            }
            if (!this.macroDefined) {
                throw new SimpleMacroException("Macro not defined.");
            }
            final String property = System.getProperty("line.separator");
            final StringBuffer sb = new StringBuffer();
            stringReader = new StringReader(this.macroBody);
            final StreamTokenizer streamTokenizer = new StreamTokenizer(stringReader);
            streamTokenizer.slashSlashComments(true);
            streamTokenizer.slashStarComments(true);
            streamTokenizer.eolIsSignificant(true);
            streamTokenizer.ordinaryChar(32);
            streamTokenizer.ordinaryChar(9);
            streamTokenizer.ordinaryChar(34);
            streamTokenizer.ordinaryChar(39);
            streamTokenizer.ordinaryChar(46);
            streamTokenizer.wordChars(48, 57);
            for (int i = streamTokenizer.nextToken(); i != -1; i = streamTokenizer.nextToken()) {
                if (i == -3) {
                    final int argLookup = this.argLookup(streamTokenizer.sval);
                    if (argLookup != -1) {
                        sb.append(array[argLookup]);
                    }
                    else {
                        sb.append(streamTokenizer.sval);
                    }
                }
                else if (i == 10) {
                    sb.append(property);
                }
                else if (i == 35) {
                    sb.append("// ");
                }
                else {
                    sb.append((char)streamTokenizer.ttype);
                }
            }
            for (int j = 0; j < sb.length(); ++j) {
                if (sb.charAt(j) == '@') {
                    sb.deleteCharAt(j);
                }
            }
            final String property2 = System.getProperty("line.separator");
            if (sb.substring(0, property2.length()) == property2) {
                return sb.substring(property2.length(), sb.length());
            }
            return sb.toString();
        }
        catch (IOException ex) {
            throw new SimpleMacroException("Error occurred while reading tokens during expand of macro " + this.macroName + ". Error: " + ex.getMessage());
        }
        finally {
            if (stringReader != null) {
                stringReader.close();
            }
        }
    }
    
    public String toString() {
        final StringWriter stringWriter = new StringWriter();
        final PrintWriter printWriter = new PrintWriter(stringWriter);
        printWriter.println("Macro name: " + this.macroName);
        printWriter.print("Arguments: ");
        for (int i = 0; i < this.numberOfArguments; ++i) {
            printWriter.print(this.arguments[i] + ' ');
        }
        printWriter.println("");
        printWriter.println("Macro body:");
        printWriter.print(this.macroBody);
        return stringWriter.toString();
    }
    
    private final /* synthetic */ void this() {
        this.maxArguments = 20;
        this.macroDefined = false;
        this.arguments = new String[20];
        this.numberOfArguments = 0;
    }
    
    public SimpleMacro(final String s) {
        this.this();
        final StringReader stringReader = new StringReader(s);
        try {
            final StreamTokenizer streamTokenizer = new StreamTokenizer(stringReader);
            streamTokenizer.slashSlashComments(true);
            streamTokenizer.slashStarComments(true);
            streamTokenizer.eolIsSignificant(true);
            streamTokenizer.nextToken();
            if (!streamTokenizer.sval.equals("definemacro")) {
                throw new SimpleMacroError("Macro " + s + " doesn't start with 'definemacro'");
            }
            streamTokenizer.nextToken();
            this.macroName = streamTokenizer.sval;
            streamTokenizer.nextToken();
            if (streamTokenizer.ttype != 40) {
                throw new SimpleMacroError("Error finding beginning of argument list in " + s);
            }
            int n = 40;
            streamTokenizer.nextToken();
            while (streamTokenizer.ttype != 41) {
                if (streamTokenizer.ttype != 44 && streamTokenizer.ttype == -3 && (n == 44 || n == 40)) {
                    this.arguments[this.numberOfArguments++] = streamTokenizer.sval;
                    n = -3;
                }
                else if (streamTokenizer.ttype == 44 && n == -3) {
                    n = 44;
                }
                else if (streamTokenizer.ttype != 41) {
                    throw new SimpleMacroError("Error parsing the argument list of macro " + s);
                }
                streamTokenizer.nextToken();
            }
            final StringBuffer sb = new StringBuffer();
            for (int i = stringReader.read(); i != -1; i = stringReader.read()) {
                sb.append((char)i);
            }
            this.macroBody = sb.toString();
            this.macroDefined = true;
        }
        catch (IOException ex) {
            throw new SimpleMacroError("IO error occurred while reading macro " + s + ". Error: " + ex.getMessage());
        }
    }
    
    public SimpleMacro(final File file) {
        this.this();
        InputStreamReader inputStreamReader = null;
        try {
            inputStreamReader = new FileReader(file);
            final StreamTokenizer streamTokenizer = new StreamTokenizer(inputStreamReader);
            streamTokenizer.slashSlashComments(true);
            streamTokenizer.slashStarComments(true);
            streamTokenizer.eolIsSignificant(true);
            streamTokenizer.nextToken();
            if (!streamTokenizer.sval.equals("definemacro")) {
                throw new SimpleMacroError("Macro definition file " + file.getAbsolutePath() + " doesn't start with 'definemacro'");
            }
            streamTokenizer.nextToken();
            this.macroName = streamTokenizer.sval;
            streamTokenizer.nextToken();
            if (streamTokenizer.ttype != 40) {
                throw new SimpleMacroError("Error finding beginning of argument list in " + file.getAbsolutePath());
            }
            int n = 40;
            streamTokenizer.nextToken();
            while (streamTokenizer.ttype != 41) {
                if (streamTokenizer.ttype != 44 && streamTokenizer.ttype == -3 && (n == 44 || n == 40)) {
                    this.arguments[this.numberOfArguments++] = streamTokenizer.sval;
                    n = -3;
                }
                else if (streamTokenizer.ttype == 44 && n == -3) {
                    n = 44;
                }
                else if (streamTokenizer.ttype != 41) {
                    throw new SimpleMacroError("Error parsing the argument list of macro definition file " + file.getAbsolutePath());
                }
                streamTokenizer.nextToken();
            }
            final StringBuffer sb = new StringBuffer();
            for (int i = inputStreamReader.read(); i != -1; i = inputStreamReader.read()) {
                sb.append((char)i);
            }
            this.macroBody = sb.toString();
            this.macroDefined = true;
        }
        catch (FileNotFoundException ex2) {
            throw new SimpleMacroError("Macro definition file " + file.getAbsolutePath() + " not found.");
        }
        catch (IOException ex) {
            throw new SimpleMacroError("IO error occurred while reading macro definition file " + file.getAbsolutePath() + ". Error: " + ex.getMessage());
        }
        finally {
            try {
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
            }
            catch (IOException ex3) {
                throw new SimpleMacroError("Error closing macro definition file " + file.getAbsolutePath());
            }
        }
        try {
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
        }
        catch (IOException ex4) {
            throw new SimpleMacroError("Error closing macro definition file " + file.getAbsolutePath());
        }
    }
}
