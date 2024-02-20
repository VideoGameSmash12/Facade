package wordnet.wn;

import java.util.StringTokenizer;

public class TokenizerParser extends StringTokenizer
{
    public int nextByte() {
        return Byte.parseByte(this.nextToken());
    }
    
    public int nextShort() {
        return Short.parseShort(this.nextToken());
    }
    
    public int nextInt() {
        return Integer.parseInt(this.nextToken());
    }
    
    public int nextInt(final int n) {
        return Integer.parseInt(this.nextToken(), n);
    }
    
    public int nextHexInt() {
        return this.nextInt(16);
    }
    
    public long nextLong() {
        return Long.parseLong(this.nextToken());
    }
    
    public TokenizerParser(final String s, final String s2) {
        super(s, s2);
    }
}
