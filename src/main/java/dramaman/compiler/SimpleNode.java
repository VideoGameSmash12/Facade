package dramaman.compiler;

public class SimpleNode implements Node
{
    protected Node parent;
    protected Node[] children;
    protected int id;
    protected BeatParser parser;
    
    public void jjtOpen() {
    }
    
    public void jjtClose() {
    }
    
    public void jjtSetParent(final Node parent) {
        this.parent = parent;
    }
    
    public Node jjtGetParent() {
        return this.parent;
    }
    
    public void jjtAddChild(final Node node, final int n) {
        if (this.children == null) {
            this.children = new Node[n + 1];
        }
        else if (n >= this.children.length) {
            final Node[] children = new Node[n + 1];
            System.arraycopy(this.children, 0, children, 0, this.children.length);
            this.children = children;
        }
        this.children[n] = node;
    }
    
    public Node jjtGetChild(final int n) {
        return this.children[n];
    }
    
    public int jjtGetNumChildren() {
        int length = 0;
        if (this.children != null) {
            length = this.children.length;
        }
        return length;
    }
    
    public String toString() {
        return BeatParserTreeConstants.jjtNodeName[this.id];
    }
    
    public String toString(final String s) {
        return s + this.toString();
    }
    
    public void dump(final String s) {
        System.out.println(this.toString(s));
        if (this.children != null) {
            for (int i = 0; i < this.children.length; ++i) {
                final SimpleNode simpleNode = (SimpleNode)this.children[i];
                if (simpleNode != null) {
                    simpleNode.dump(s + ' ');
                }
            }
        }
    }
    
    public SimpleNode(final int id) {
        this.id = id;
    }
    
    public SimpleNode(final BeatParser parser, final int n) {
        this(n);
        this.parser = parser;
    }
}
