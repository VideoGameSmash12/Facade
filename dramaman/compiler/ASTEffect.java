package dramaman.compiler;

public class ASTEffect extends BeatParseNode
{
    static final int INCREMENT = 0;
    static final int DECREMENT = 1;
    private String effectName;
    private int relativeValueDirection;
    private float effectValue;
    private static final /* synthetic */ boolean $noassert;
    
    String getEffectName() {
        return new String(this.effectName);
    }
    
    void setEffectName(final String effectName) {
        if (!ASTEffect.$noassert && this.effectName != null) {
            throw new AssertionError();
        }
        this.effectName = effectName;
    }
    
    int getRelativeValueDirection() {
        return this.relativeValueDirection;
    }
    
    void setRelativeValueDirection(final int relativeValueDirection) {
        if (!ASTEffect.$noassert && this.relativeValueDirection != -1) {
            throw new AssertionError();
        }
        this.relativeValueDirection = relativeValueDirection;
    }
    
    float getEffectValue() {
        return this.effectValue;
    }
    
    void setEffectValue(final float effectValue) {
        if (!ASTEffect.$noassert && this.effectValue != Float.MAX_VALUE) {
            throw new AssertionError();
        }
        this.effectValue = effectValue;
    }
    
    public String compileToJava() throws CompileException {
        if (!ASTEffect.$noassert && (this.effectName == null || this.effectValue == Float.MAX_VALUE)) {
            throw new AssertionError((Object)("effectName = " + this.effectName + ", effectValue = " + this.effectValue));
        }
        final StringBuffer sb = new StringBuffer();
        sb.append("new StoryEffect(\"" + this.effectName + "\", ");
        switch (this.relativeValueDirection) {
            case 0: {
                sb.append("+");
                break;
            }
            case 1: {
                sb.append("-");
                break;
            }
        }
        sb.append(this.effectValue + "f, ");
        if (this.relativeValueDirection == -1) {
            sb.append("true)");
        }
        else {
            sb.append("false)");
        }
        return sb.toString();
    }
    
    private final /* synthetic */ void this() {
        this.effectName = null;
        this.relativeValueDirection = -1;
        this.effectValue = Float.MAX_VALUE;
    }
    
    public ASTEffect(final int n) {
        super(n);
        this.this();
    }
    
    public ASTEffect(final BeatParser beatParser, final int n) {
        super(beatParser, n);
        this.this();
    }
    
    static {
        $noassert = (Class.forName("[Ldramaman.compiler.ASTEffect;").getComponentType().desiredAssertionStatus() ^ true);
    }
}
