package dramaman.compiler;

public interface BeatParserConstants
{
    public static final int EOF = 0;
    public static final int SINGLE_LINE_COMMENT = 9;
    public static final int FORMAL_COMMENT = 10;
    public static final int MULTI_LINE_COMMENT = 11;
    public static final int ABSTRACT = 13;
    public static final int BOOLEAN = 14;
    public static final int BREAK = 15;
    public static final int BYTE = 16;
    public static final int CASE = 17;
    public static final int CATCH = 18;
    public static final int CHAR = 19;
    public static final int CLASS = 20;
    public static final int CONST = 21;
    public static final int CONTINUE = 22;
    public static final int _DEFAULT = 23;
    public static final int DO = 24;
    public static final int DOUBLE = 25;
    public static final int ELSE = 26;
    public static final int EXTENDS = 27;
    public static final int FALSE = 28;
    public static final int FINAL = 29;
    public static final int FINALLY = 30;
    public static final int FLOAT = 31;
    public static final int FOR = 32;
    public static final int GOTO = 33;
    public static final int IF = 34;
    public static final int IMPLEMENTS = 35;
    public static final int IMPORT = 36;
    public static final int INSTANCEOF = 37;
    public static final int INT = 38;
    public static final int INTERFACE = 39;
    public static final int LONG = 40;
    public static final int NATIVE = 41;
    public static final int NEW = 42;
    public static final int NULL = 43;
    public static final int PACKAGE = 44;
    public static final int PRIVATE = 45;
    public static final int PROTECTED = 46;
    public static final int PUBLIC = 47;
    public static final int RETURN = 48;
    public static final int SHORT = 49;
    public static final int STATIC = 50;
    public static final int SUPER = 51;
    public static final int SWITCH = 52;
    public static final int SYNCHRONIZED = 53;
    public static final int THIS = 54;
    public static final int THROW = 55;
    public static final int THROWS = 56;
    public static final int TRANSIENT = 57;
    public static final int TRUE = 58;
    public static final int TRY = 59;
    public static final int VOID = 60;
    public static final int VOLATILE = 61;
    public static final int WHILE = 62;
    public static final int ABORT_ACTION = 63;
    public static final int DEFBEAT = 64;
    public static final int ID = 65;
    public static final int BEHAVIORS = 66;
    public static final int CONSTANTS = 67;
    public static final int DISCOURSE_RULES = 68;
    public static final int EFFECTS = 69;
    public static final int PRECONDITION = 70;
    public static final int INIT_ACTION = 71;
    public static final int PRIORITY = 72;
    public static final int PRIORITY_TEST = 73;
    public static final int SELECT_ACTION = 74;
    public static final int SUCCEED_ACTION = 75;
    public static final int WEIGHT = 76;
    public static final int WEIGHT_TEST = 77;
    public static final int V_BIND = 78;
    public static final int INTEGER_LITERAL = 79;
    public static final int DECIMAL_LITERAL = 80;
    public static final int HEX_LITERAL = 81;
    public static final int OCTAL_LITERAL = 82;
    public static final int FLOATING_POINT_LITERAL = 83;
    public static final int EXPONENT = 84;
    public static final int CHARACTER_LITERAL = 85;
    public static final int STRING_LITERAL = 86;
    public static final int IDENTIFIER = 87;
    public static final int LETTER = 88;
    public static final int DIGIT = 89;
    public static final int BACK_SLASH = 90;
    public static final int LPAREN = 91;
    public static final int RPAREN = 92;
    public static final int LBRACE = 93;
    public static final int RBRACE = 94;
    public static final int LBRACKET = 95;
    public static final int RBRACKET = 96;
    public static final int SEMICOLON = 97;
    public static final int COMMA = 98;
    public static final int DOT = 99;
    public static final int ASSIGN = 100;
    public static final int GT = 101;
    public static final int LT = 102;
    public static final int BANG = 103;
    public static final int TILDE = 104;
    public static final int HOOK = 105;
    public static final int COLON = 106;
    public static final int EQ = 107;
    public static final int LE = 108;
    public static final int GE = 109;
    public static final int NE = 110;
    public static final int SC_OR = 111;
    public static final int SC_AND = 112;
    public static final int INCR = 113;
    public static final int DECR = 114;
    public static final int PLUS = 115;
    public static final int MINUS = 116;
    public static final int STAR = 117;
    public static final int SLASH = 118;
    public static final int BIT_AND = 119;
    public static final int BIT_OR = 120;
    public static final int XOR = 121;
    public static final int REM = 122;
    public static final int LSHIFT = 123;
    public static final int RSIGNEDSHIFT = 124;
    public static final int RUNSIGNEDSHIFT = 125;
    public static final int PLUSASSIGN = 126;
    public static final int MINUSASSIGN = 127;
    public static final int STARASSIGN = 128;
    public static final int SLASHASSIGN = 129;
    public static final int ANDASSIGN = 130;
    public static final int ORASSIGN = 131;
    public static final int XORASSIGN = 132;
    public static final int REMASSIGN = 133;
    public static final int LSHIFTASSIGN = 134;
    public static final int RSIGNEDSHIFTASSIGN = 135;
    public static final int RUNSIGNEDSHIFTASSIGN = 136;
    public static final int DEFAULT = 0;
    public static final int IN_SINGLE_LINE_COMMENT = 1;
    public static final int IN_FORMAL_COMMENT = 2;
    public static final int IN_MULTI_LINE_COMMENT = 3;
    public static final String[] tokenImage = { "<EOF>", "\" \"", "\"\\t\"", "\"\\n\"", "\"\\r\"", "\"\\f\"", "\"//\"", "<token of kind 7>", "\"/*\"", "<SINGLE_LINE_COMMENT>", "\"*/\"", "\"*/\"", "<token of kind 12>", "\"abstract\"", "\"boolean\"", "\"break\"", "\"byte\"", "\"case\"", "\"catch\"", "\"char\"", "\"class\"", "\"const\"", "\"continue\"", "\"default\"", "\"do\"", "\"double\"", "\"else\"", "\"extends\"", "\"false\"", "\"final\"", "\"finally\"", "\"float\"", "\"for\"", "\"goto\"", "\"if\"", "\"implements\"", "\"import\"", "\"instanceof\"", "\"int\"", "\"interface\"", "\"long\"", "\"native\"", "\"new\"", "\"null\"", "\"package\"", "\"private\"", "\"protected\"", "\"public\"", "\"return\"", "\"short\"", "\"static\"", "\"super\"", "\"switch\"", "\"synchronized\"", "\"this\"", "\"throw\"", "\"throws\"", "\"transient\"", "\"true\"", "\"try\"", "\"void\"", "\"volatile\"", "\"while\"", "\"abort_action\"", "\"defbeat\"", "\"beatid\"", "\"behaviors\"", "\"constants\"", "\"discourse_rules\"", "\"effects\"", "\"precondition\"", "\"init_action\"", "\"priority\"", "\"priority_test\"", "\"select_action\"", "\"succeed_action\"", "\"weight\"", "\"weight_test\"", "\"::\"", "<INTEGER_LITERAL>", "<DECIMAL_LITERAL>", "<HEX_LITERAL>", "<OCTAL_LITERAL>", "<FLOATING_POINT_LITERAL>", "<EXPONENT>", "<CHARACTER_LITERAL>", "<STRING_LITERAL>", "<IDENTIFIER>", "<LETTER>", "<DIGIT>", "\"\\\\\"", "\"(\"", "\")\"", "\"{\"", "\"}\"", "\"[\"", "\"]\"", "\";\"", "\",\"", "\".\"", "\"=\"", "\">\"", "\"<\"", "\"!\"", "\"~\"", "\"?\"", "\":\"", "\"==\"", "\"<=\"", "\">=\"", "\"!=\"", "\"||\"", "\"&&\"", "\"++\"", "\"--\"", "\"+\"", "\"-\"", "\"*\"", "\"/\"", "\"&\"", "\"|\"", "\"^\"", "\"%\"", "\"<<\"", "\">>\"", "\">>>\"", "\"+=\"", "\"-=\"", "\"*=\"", "\"/=\"", "\"&=\"", "\"|=\"", "\"^=\"", "\"%=\"", "\"<<=\"", "\">>=\"", "\">>>=\"", "\":\\\\\"" };
}
