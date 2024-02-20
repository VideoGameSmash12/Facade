package TemplateCompiler;

public class Token
{
    public int kind;
    public int beginLine;
    public int beginColumn;
    public int endLine;
    public int endColumn;
    public String image;
    public Token next;
    public Token specialToken;
    
    public final String toString() {
        return this.image;
    }
    
    public static final Token newToken(final int n) {
        return new Token();
    }
}
