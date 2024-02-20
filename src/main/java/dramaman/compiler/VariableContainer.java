package dramaman.compiler;

abstract class VariableContainer extends BeatParseNode implements BeatParserTreeConstants
{
    public void processVariableReferences(final BeatScopeMaintainer beatScopeMaintainer) throws CompileException {
        for (int i = 0; i < this.jjtGetNumChildren(); ++i) {
            final BeatParseNode beatParseNode = (BeatParseNode)this.jjtGetChild(i);
            if (beatParseNode.id == 22) {
                try {
                    final ASTJavaName astJavaName = (ASTJavaName)beatParseNode;
                    if (astJavaName.isVariableReference(beatScopeMaintainer)) {
                        astJavaName.setJavaNameImage(astJavaName.getVariableReference(beatScopeMaintainer));
                    }
                }
                catch (ScopeException ex) {
                    throw new CompileException(ex.getMessage());
                }
            }
            else if (beatParseNode.id == 23) {
                ((ASTConditionalExpression)beatParseNode).processVariableReferences(beatScopeMaintainer);
            }
            else if (beatParseNode.id == 24) {
                ((ASTJavaStatement)beatParseNode).processVariableReferences(beatScopeMaintainer);
            }
        }
    }
    
    BeatScopeMaintainer getEnclosingScope() {
        return ((BeatParseNode)this.jjtGetParent()).getEnclosingScope();
    }
    
    public VariableContainer(final int n) {
        super(n);
    }
    
    public VariableContainer(final BeatParser beatParser, final int n) {
        super(beatParser, n);
    }
}
