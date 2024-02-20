package TemplateCompiler;

public class CompileException extends ParseException
{
    public CompileException() {
    }
    
    public CompileException(final String s) {
        super(s);
    }
    
    public CompileException(final int n, final String s) {
        super("line " + n + ": " + s);
    }
}
