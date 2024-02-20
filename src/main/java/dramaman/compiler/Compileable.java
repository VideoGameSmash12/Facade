package dramaman.compiler;

import jd.JavaCodeDescriptor;

public interface Compileable
{
    JavaCodeDescriptor compileToJava() throws CompileException;
}
