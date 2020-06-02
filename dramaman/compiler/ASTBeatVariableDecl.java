package dramaman.compiler;

import jd.FieldDescriptor;

public class ASTBeatVariableDecl extends BeatParseNode
{
    public String getType() {
        for (int i = 0; i < this.jjtGetNumChildren(); ++i) {
            final BeatParseNode beatParseNode = (BeatParseNode)this.jjtGetChild(i);
            if (BeatParserTreeConstants.jjtNodeName[beatParseNode.id] == "JavaType") {
                return beatParseNode.dumpTokens();
            }
        }
        throw new CompileError("A BeatVariableDecl node is missing its JavaType child.");
    }
    
    public FieldDescriptor getFieldDescriptor() {
        final FieldDescriptor fieldDescriptor = new FieldDescriptor();
        for (int i = 0; i < this.jjtGetNumChildren(); ++i) {
            final BeatParseNode beatParseNode = (BeatParseNode)this.jjtGetChild(i);
            if (BeatParserTreeConstants.jjtNodeName[beatParseNode.id] == "JavaType") {
                fieldDescriptor.fieldType = beatParseNode.dumpTokens();
            }
            else if (BeatParserTreeConstants.jjtNodeName[beatParseNode.id] == "VariableDeclaratorID") {
                fieldDescriptor.addFieldName(beatParseNode.dumpTokens());
            }
            else {
                if (BeatParserTreeConstants.jjtNodeName[beatParseNode.id] != "VariableInitializer") {
                    throw new CompileError("Unexpected child node of ASTBeatVariableDecl");
                }
                fieldDescriptor.initializer = beatParseNode.prettyPrintTokens();
            }
        }
        return fieldDescriptor;
    }
    
    public ASTBeatVariableDecl(final int n) {
        super(n);
    }
    
    public ASTBeatVariableDecl(final BeatParser beatParser, final int n) {
        super(beatParser, n);
    }
}
