package TemplateCompiler;

import java.io.IOException;
import java.io.BufferedWriter;
import java.util.Vector;

public class ASTTypeDef extends ASTRHside
{
    String name;
    private static final /* synthetic */ boolean $noassert;
    
    public void AddToList() throws ParseException {
        this.name = this.firstToken.next.next.image;
        final Vector<String> vector = new Vector<String>();
        if (this.children != null) {
            for (int i = 0; i < this.children.length; ++i) {
                final ASTJessRule astJessRule = (ASTJessRule)this.children[i];
                if (astJessRule != null) {
                    if (astJessRule.toString().equals("TypeDefArg")) {
                        vector.addElement(((ASTTypeDefArg)this.children[i]).extractargs());
                    }
                    else {
                        vector.addElement((String)((ASTTypeDefOr)this.children[i]).extractargs());
                    }
                }
            }
        }
        ASTTypeDef.tableOfConsts.put(this.name, vector);
    }
    
    public void compileToJess(final BufferedWriter bufferedWriter) throws IOException {
        if (!ASTTypeDef.$noassert) {
            throw new AssertionError((Object)"don't call compileToJess on ASTTypeDef");
        }
    }
    
    public ASTTypeDef(final int n) {
        super(n);
    }
    
    public ASTTypeDef(final NLU nlu, final int n) {
        super(nlu, n);
    }
    
    static {
        $noassert = (Class.forName("[LTemplateCompiler.ASTTypeDef;").getComponentType().desiredAssertionStatus() ^ true);
    }
}
