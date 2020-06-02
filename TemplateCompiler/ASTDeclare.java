package TemplateCompiler;

import java.io.IOException;
import java.io.BufferedWriter;

class ASTDeclare extends ASTJessRule
{
    private String name;
    private static final /* synthetic */ boolean $noassert;
    
    void setName(final String name) {
        this.name = name;
    }
    
    int getSalience() throws CompileException {
        final Token next = this.firstToken.next;
        if (next.image.equals("salience")) {
            final String image = next.next.image;
            try {
                return Integer.parseInt(image);
            }
            catch (NumberFormatException ex) {
                throw new CompileException(this.getFirstLineNumber(), ex.getMessage());
            }
        }
        return -255;
    }
    
    void compileToJess(final BufferedWriter bufferedWriter) throws IOException, CompileException {
        final Token next = this.firstToken.next;
        final String image = next.image;
        if (image.equals("timeout")) {
            if (!ASTDeclare.$noassert && this.name == null) {
                throw new AssertionError();
            }
            final String image2 = next.next.image;
            final String substring = image2.substring(image2.length() - 1, image2.length());
            try {
                final int int1 = Integer.parseInt(image2.substring(0, image2.length() - 1));
                if (substring.equals("u")) {
                    bufferedWriter.write("(assert (_timeout " + this.name + ' ' + int1 + " 10))");
                }
                else if (substring.equals("b")) {
                    bufferedWriter.write("(assert (_timeout " + this.name + ' ' + int1 + " 4))");
                }
                else {
                    if (!substring.equals("s")) {
                        throw new CompileException(this.getFirstLineNumber(), "Expected 'b' or 's' or 'u' as a suffix to timeout declaration");
                    }
                    bufferedWriter.write("(assert (_timeout " + this.name + ' ' + int1 + " 7))");
                }
            }
            catch (NumberFormatException ex) {
                throw new CompileException(this.getFirstLineNumber(), ex.getMessage());
            }
        }
        else if (!image.equals("salience")) {
            throw new CompileException(this.getFirstLineNumber(), "Expected 'timeout' or 'salience' keyword here.");
        }
    }
    
    ASTDeclare(final int n) {
        super(n);
    }
    
    ASTDeclare(final NLU nlu, final int n) {
        super(nlu, n);
    }
    
    static {
        $noassert = (Class.forName("[LTemplateCompiler.ASTDeclare;").getComponentType().desiredAssertionStatus() ^ true);
    }
}
