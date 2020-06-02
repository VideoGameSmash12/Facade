package dramaman.compiler;

public class ParseException extends Exception
{
    protected boolean specialConstructor;
    public Token currentToken;
    public int[][] expectedTokenSequences;
    public String[] tokenImage;
    protected String eol;
    
    public String getMessage() {
        if (!this.specialConstructor) {
            return super.getMessage();
        }
        String s = "";
        int length = 0;
        for (int i = 0; i < this.expectedTokenSequences.length; ++i) {
            if (length < this.expectedTokenSequences[i].length) {
                length = this.expectedTokenSequences[i].length;
            }
            for (int j = 0; j < this.expectedTokenSequences[i].length; ++j) {
                s = s + this.tokenImage[this.expectedTokenSequences[i][j]] + ' ';
            }
            if (this.expectedTokenSequences[i][this.expectedTokenSequences[i].length - 1] != 0) {
                s += "...";
            }
            s = s + this.eol + "    ";
        }
        String s2 = "Encountered \"";
        Token token = this.currentToken.next;
        for (int k = 0; k < length; ++k) {
            if (k != 0) {
                s2 += ' ';
            }
            if (token.kind == 0) {
                s2 += this.tokenImage[0];
                break;
            }
            s2 += this.add_escapes(token.image);
            token = token.next;
        }
        final String string = s2 + "\" at line " + this.currentToken.next.beginLine + ", column " + this.currentToken.next.beginColumn + '.' + this.eol;
        String s3;
        if (this.expectedTokenSequences.length == 1) {
            s3 = string + "Was expecting:" + this.eol + "    ";
        }
        else {
            s3 = string + "Was expecting one of:" + this.eol + "    ";
        }
        return s3 + s;
    }
    
    protected String add_escapes(final String s) {
        final StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); ++i) {
            switch (s.charAt(i)) {
                case '\0': {
                    break;
                }
                case '\b': {
                    sb.append("\\b");
                    break;
                }
                case '\t': {
                    sb.append("\\t");
                    break;
                }
                case '\n': {
                    sb.append("\\n");
                    break;
                }
                case '\f': {
                    sb.append("\\f");
                    break;
                }
                case '\r': {
                    sb.append("\\r");
                    break;
                }
                case '\"': {
                    sb.append("\\\"");
                    break;
                }
                case '\'': {
                    sb.append("\\'");
                    break;
                }
                case '\\': {
                    sb.append("\\\\");
                    break;
                }
                default: {
                    final char char1;
                    if ((char1 = s.charAt(i)) < ' ' || char1 > '~') {
                        final String string = "0000" + Integer.toString(char1, 16);
                        sb.append("\\u" + string.substring(string.length() - 4, string.length()));
                        break;
                    }
                    sb.append(char1);
                    break;
                }
            }
        }
        return sb.toString();
    }
    
    private final /* synthetic */ void this() {
        this.eol = System.getProperty("line.separator", "\n");
    }
    
    public ParseException(final Token currentToken, final int[][] expectedTokenSequences, final String[] tokenImage) {
        super("");
        this.this();
        this.specialConstructor = true;
        this.currentToken = currentToken;
        this.expectedTokenSequences = expectedTokenSequences;
        this.tokenImage = tokenImage;
    }
    
    public ParseException() {
        this.this();
        this.specialConstructor = false;
    }
    
    public ParseException(final String s) {
        super(s);
        this.this();
        this.specialConstructor = false;
    }
}
