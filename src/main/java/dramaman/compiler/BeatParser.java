package dramaman.compiler;

import java.util.Enumeration;
import java.io.Reader;
import java.io.InputStream;
import java.util.Vector;

public class BeatParser implements BeatParserTreeConstants, BeatParserConstants
{
    protected static JJTBeatParserState jjtree;
    private static boolean jj_initialized_once;
    public static BeatParserTokenManager token_source;
    static JavaCharStream jj_input_stream;
    public static Token token;
    public static Token jj_nt;
    private static int jj_ntk;
    private static Token jj_scanpos;
    private static Token jj_lastpos;
    private static int jj_la;
    public static boolean lookingAhead;
    private static boolean jj_semLA;
    private static int jj_gen;
    private static final int[] jj_la1;
    private static int[] jj_la1_0;
    private static int[] jj_la1_1;
    private static int[] jj_la1_2;
    private static int[] jj_la1_3;
    private static int[] jj_la1_4;
    private static final JJCalls[] jj_2_rtns;
    private static boolean jj_rescan;
    private static int jj_gc;
    private static final LookaheadSuccess jj_ls;
    private static Vector jj_expentries;
    private static int[] jj_expentry;
    private static int jj_kind;
    private static int[] jj_lasttokens;
    private static int jj_endpos;
    
    static void jjtreeOpenNodeScope(final Node node) {
        ((BeatParseNode)node).firstToken = getToken(1);
    }
    
    static void jjtreeCloseNodeScope(final Node node) {
        ((BeatParseNode)node).lastToken = getToken(0);
    }
    
    public static final ASTBeatTopLevel BeatTopLevel() throws ParseException {
        final ASTBeatTopLevel astBeatTopLevel = new ASTBeatTopLevel(0);
        int n = 1;
        BeatParser.jjtree.openNodeScope(astBeatTopLevel);
        jjtreeOpenNodeScope(astBeatTopLevel);
        try {
            switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                case 0: {
                    jj_consume_token(44);
                    astBeatTopLevel.beatPackage = Name().dumpTokens();
                    jj_consume_token(97);
                    break;
                }
                default: {
                    BeatParser.jj_la1[0] = BeatParser.jj_gen;
                    break;
                }
            }
            while (true) {
                switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                    case 36:
                    case 67: {
                        switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                            case 36: {
                                astBeatTopLevel.addUserImport(ImportDeclaration());
                                continue;
                            }
                            case 67: {
                                astBeatTopLevel.addUserConstants(ConstantDeclaration());
                                continue;
                            }
                            default: {
                                BeatParser.jj_la1[2] = BeatParser.jj_gen;
                                jj_consume_token(-1);
                                throw new ParseException();
                            }
                        }
                        continue;
                    }
                    default: {
                        BeatParser.jj_la1[1] = BeatParser.jj_gen;
                        while (true) {
                            switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                                case 0: {
                                    BeatDefinition();
                                    continue;
                                }
                                default: {
                                    BeatParser.jj_la1[3] = BeatParser.jj_gen;
                                    jj_consume_token(0);
                                    BeatParser.jjtree.closeNodeScope(astBeatTopLevel, true);
                                    n = 0;
                                    jjtreeCloseNodeScope(astBeatTopLevel);
                                    return astBeatTopLevel;
                                }
                            }
                        }
                        break;
                    }
                }
            }
        }
        catch (Throwable t) {
            if (n != 0) {
                BeatParser.jjtree.clearNodeScope(astBeatTopLevel);
                n = 0;
            }
            else {
                BeatParser.jjtree.popNode();
            }
            if (t instanceof RuntimeException) {
                throw (RuntimeException)t;
            }
            if (t instanceof ParseException) {
                throw (ParseException)t;
            }
            throw (Error)t;
        }
        finally {
            if (n != 0) {
                BeatParser.jjtree.closeNodeScope(astBeatTopLevel, true);
                jjtreeCloseNodeScope(astBeatTopLevel);
            }
        }
    }
    
    public static final void BeatDefinition() throws ParseException {
        final ASTBeatDefinition astBeatDefinition = new ASTBeatDefinition(1);
        int n = 1;
        BeatParser.jjtree.openNodeScope(astBeatDefinition);
        jjtreeOpenNodeScope(astBeatDefinition);
        Label_0392: {
            try {
                jj_consume_token(64);
                astBeatDefinition.setBeatName(BeatName().image);
                jj_consume_token(93);
                while (true) {
                    switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                        case 14:
                        case 16:
                        case 19:
                        case 25:
                        case 31:
                        case 38:
                        case 40:
                        case 49:
                        case 87: {
                            BeatVariableDeclaration();
                            jj_consume_token(97);
                            continue;
                        }
                        default: {
                            BeatParser.jj_la1[4] = BeatParser.jj_gen;
                            while (true) {
                                BeatField(astBeatDefinition);
                                switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                                    case 0:
                                    case 2:
                                    case 3:
                                    case 5:
                                    case 6:
                                    case 7:
                                    case 8:
                                    case 9:
                                    case 10:
                                    case 11:
                                    case 12:
                                    case 13:
                                    case 14: {
                                        continue;
                                    }
                                    default: {
                                        BeatParser.jj_la1[5] = BeatParser.jj_gen;
                                        jj_consume_token(94);
                                        break Label_0392;
                                    }
                                }
                            }
                            break;
                        }
                    }
                }
            }
            catch (Throwable t) {
                if (n != 0) {
                    BeatParser.jjtree.clearNodeScope(astBeatDefinition);
                    n = 0;
                }
                else {
                    BeatParser.jjtree.popNode();
                }
                if (t instanceof RuntimeException) {
                    throw (RuntimeException)t;
                }
                if (t instanceof ParseException) {
                    throw (ParseException)t;
                }
                throw (Error)t;
            }
            finally {
                if (n != 0) {
                    BeatParser.jjtree.closeNodeScope(astBeatDefinition, true);
                    jjtreeCloseNodeScope(astBeatDefinition);
                }
            }
        }
        if (n != 0) {
            BeatParser.jjtree.closeNodeScope(astBeatDefinition, true);
            jjtreeCloseNodeScope(astBeatDefinition);
        }
    }
    
    public static final void BeatVariableDeclaration() throws ParseException {
        final ASTBeatVariableDecl astBeatVariableDecl = new ASTBeatVariableDecl(2);
        int n = 1;
        BeatParser.jjtree.openNodeScope(astBeatVariableDecl);
        jjtreeOpenNodeScope(astBeatVariableDecl);
        Label_0359: {
            try {
                final ASTJavaType astJavaType = new ASTJavaType(3);
                int n2 = 1;
                BeatParser.jjtree.openNodeScope(astJavaType);
                jjtreeOpenNodeScope(astJavaType);
                try {
                    Type();
                }
                catch (Throwable t) {
                    if (n2 != 0) {
                        BeatParser.jjtree.clearNodeScope(astJavaType);
                        n2 = 0;
                    }
                    else {
                        BeatParser.jjtree.popNode();
                    }
                    if (t instanceof RuntimeException) {
                        throw (RuntimeException)t;
                    }
                    if (t instanceof ParseException) {
                        throw (ParseException)t;
                    }
                    throw (Error)t;
                }
                finally {
                    if (n2 != 0) {
                        BeatParser.jjtree.closeNodeScope(astJavaType, true);
                        jjtreeCloseNodeScope(astJavaType);
                    }
                }
                if (n2 != 0) {
                    BeatParser.jjtree.closeNodeScope(astJavaType, true);
                    jjtreeCloseNodeScope(astJavaType);
                }
                VariableDeclarator();
                while (true) {
                    switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                        case 0: {
                            jj_consume_token(98);
                            VariableDeclarator();
                            continue;
                        }
                        default: {
                            BeatParser.jj_la1[6] = BeatParser.jj_gen;
                            break Label_0359;
                        }
                    }
                }
            }
            catch (Throwable t2) {
                if (n != 0) {
                    BeatParser.jjtree.clearNodeScope(astBeatVariableDecl);
                    n = 0;
                }
                else {
                    BeatParser.jjtree.popNode();
                }
                if (t2 instanceof RuntimeException) {
                    throw (RuntimeException)t2;
                }
                if (t2 instanceof ParseException) {
                    throw (ParseException)t2;
                }
                throw (Error)t2;
            }
            finally {
                if (n != 0) {
                    BeatParser.jjtree.closeNodeScope(astBeatVariableDecl, true);
                    jjtreeCloseNodeScope(astBeatVariableDecl);
                }
            }
        }
        if (n != 0) {
            BeatParser.jjtree.closeNodeScope(astBeatVariableDecl, true);
            jjtreeCloseNodeScope(astBeatVariableDecl);
        }
    }
    
    public static final void BeatField(final ASTBeatDefinition astBeatDefinition) throws ParseException {
        switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
            case 71: {
                InitAction(astBeatDefinition);
                break;
            }
            case 70: {
                Precondition(astBeatDefinition);
                break;
            }
            case 65: {
                BeatID(astBeatDefinition);
                break;
            }
            case 76: {
                Weight(astBeatDefinition);
                break;
            }
            case 77: {
                WeightTest(astBeatDefinition);
                break;
            }
            case 72: {
                Priority(astBeatDefinition);
                break;
            }
            case 73: {
                PriorityTest(astBeatDefinition);
                break;
            }
            case 69: {
                Effects(astBeatDefinition);
                break;
            }
            case 68: {
                DiscourseRules(astBeatDefinition);
                break;
            }
            case 66: {
                BeatBehaviors(astBeatDefinition);
                break;
            }
            case 74: {
                SelectAction(astBeatDefinition);
                break;
            }
            case 63: {
                AbortAction(astBeatDefinition);
                break;
            }
            case 75: {
                SucceedAction(astBeatDefinition);
                break;
            }
            default: {
                BeatParser.jj_la1[7] = BeatParser.jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
            }
        }
    }
    
    public static final void Precondition(final ASTBeatDefinition astBeatDefinition) throws ParseException {
        final ASTPrecondition astPrecondition = new ASTPrecondition(5);
        int n = 1;
        BeatParser.jjtree.openNodeScope(astPrecondition);
        jjtreeOpenNodeScope(astPrecondition);
        try {
            jj_consume_token(70);
            jj_consume_token(93);
            final ASTTestExpression testExpression = TestExpression();
            jj_consume_token(94);
            BeatParser.jjtree.closeNodeScope(astPrecondition, true);
            n = 0;
            jjtreeCloseNodeScope(astPrecondition);
            testExpression.setTestType(0);
            astBeatDefinition.addPrecondition(astPrecondition);
        }
        catch (Throwable t) {
            if (n != 0) {
                BeatParser.jjtree.clearNodeScope(astPrecondition);
                n = 0;
            }
            else {
                BeatParser.jjtree.popNode();
            }
            if (t instanceof RuntimeException) {
                throw (RuntimeException)t;
            }
            if (t instanceof ParseException) {
                throw (ParseException)t;
            }
            throw (Error)t;
        }
        finally {
            if (n != 0) {
                BeatParser.jjtree.closeNodeScope(astPrecondition, true);
                jjtreeCloseNodeScope(astPrecondition);
            }
        }
        if (n != 0) {
            BeatParser.jjtree.closeNodeScope(astPrecondition, true);
            jjtreeCloseNodeScope(astPrecondition);
        }
    }
    
    public static final void BeatID(final ASTBeatDefinition astBeatDefinition) throws ParseException {
        Token jj_consume_token = null;
        ASTJavaName name = null;
        jj_consume_token(65);
        switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
            case 87: {
                name = Name();
                break;
            }
            case 79: {
                jj_consume_token = jj_consume_token(79);
                break;
            }
            default: {
                BeatParser.jj_la1[8] = BeatParser.jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
            }
        }
        try {
            if (jj_consume_token != null) {
                astBeatDefinition.setBeatID(Integer.parseInt(jj_consume_token.image));
            }
            else {
                if (name.getConstantType() != "int") {
                    throw new ParseException(name.dumpTokens() + " is not a constant of type int");
                }
                astBeatDefinition.setBeatID((int)name.getConstantValue());
            }
        }
        catch (CompileException ex) {
            throw new ParseException(ex.getMessage());
        }
        jj_consume_token(97);
    }
    
    public static final void Weight(final ASTBeatDefinition astBeatDefinition) throws ParseException {
        Token token = null;
        ASTJavaName name = null;
        jj_consume_token(76);
        switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
            case 79: {
                token = jj_consume_token(79);
                break;
            }
            case 83: {
                token = jj_consume_token(83);
                break;
            }
            case 87: {
                name = Name();
                break;
            }
            default: {
                BeatParser.jj_la1[9] = BeatParser.jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
            }
        }
        try {
            if (token != null) {
                if (token.kind == 79) {
                    astBeatDefinition.setWeight((float)Integer.parseInt(token.image));
                }
                else {
                    astBeatDefinition.setWeight(Float.parseFloat(token.image));
                }
            }
            else if (name.getConstantType() == "int") {
                astBeatDefinition.setWeight((float)(int)name.getConstantValue());
            }
            else {
                if (name.getConstantType() == "float") {
                    throw new ParseException(name.dumpTokens() + " is not a constant of type int or float");
                }
                astBeatDefinition.setWeight((float)name.getConstantValue());
            }
        }
        catch (CompileException ex) {
            throw new ParseException(ex.getMessage());
        }
        jj_consume_token(97);
    }
    
    public static final void WeightTest(final ASTBeatDefinition astBeatDefinition) throws ParseException {
        final ASTWeightTest astWeightTest = new ASTWeightTest(6);
        int n = 1;
        BeatParser.jjtree.openNodeScope(astWeightTest);
        jjtreeOpenNodeScope(astWeightTest);
        Token token = null;
        ASTJavaName name = null;
        try {
            jj_consume_token(77);
            switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                case 0: {
                    token = jj_consume_token(79);
                    break;
                }
                case 4: {
                    token = jj_consume_token(83);
                    break;
                }
                case 8: {
                    name = Name();
                    break;
                }
                default: {
                    BeatParser.jj_la1[10] = BeatParser.jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
                }
            }
            try {
                if (token != null) {
                    if (token.kind == 79) {
                        astWeightTest.setWeight((float)Integer.parseInt(token.image));
                    }
                    else {
                        astWeightTest.setWeight(Float.parseFloat(token.image));
                    }
                }
                else if (name.getConstantType().equals("int")) {
                    astWeightTest.setWeight((float)(int)name.getConstantValue());
                }
                else {
                    if (!name.getConstantType().equals("float")) {
                        throw new ParseException(name.dumpTokens() + " is not a constant of type int or float");
                    }
                    astWeightTest.setWeight((float)name.getConstantValue());
                }
            }
            catch (CompileException ex) {
                throw new ParseException(ex.getMessage());
            }
            jj_consume_token(93);
            final ASTTestExpression testExpression = TestExpression();
            jj_consume_token(94);
            BeatParser.jjtree.closeNodeScope(astWeightTest, true);
            n = 0;
            jjtreeCloseNodeScope(astWeightTest);
            testExpression.setTestType(1);
            astBeatDefinition.addWeightTest(astWeightTest);
        }
        catch (Throwable t) {
            if (n != 0) {
                BeatParser.jjtree.clearNodeScope(astWeightTest);
                n = 0;
            }
            else {
                BeatParser.jjtree.popNode();
            }
            if (t instanceof RuntimeException) {
                throw (RuntimeException)t;
            }
            if (t instanceof ParseException) {
                throw (ParseException)t;
            }
            throw (Error)t;
        }
        finally {
            if (n != 0) {
                BeatParser.jjtree.closeNodeScope(astWeightTest, true);
                jjtreeCloseNodeScope(astWeightTest);
            }
        }
        if (n != 0) {
            BeatParser.jjtree.closeNodeScope(astWeightTest, true);
            jjtreeCloseNodeScope(astWeightTest);
        }
    }
    
    public static final void Priority(final ASTBeatDefinition astBeatDefinition) throws ParseException {
        Token jj_consume_token = null;
        ASTJavaName name = null;
        jj_consume_token(72);
        switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
            case 79: {
                jj_consume_token = jj_consume_token(79);
                break;
            }
            case 87: {
                name = Name();
                break;
            }
            default: {
                BeatParser.jj_la1[11] = BeatParser.jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
            }
        }
        try {
            if (jj_consume_token != null) {
                astBeatDefinition.setPriority(Integer.parseInt(jj_consume_token.image));
            }
            else {
                if (name.getConstantType() != "int") {
                    throw new ParseException(name.dumpTokens() + " is not a constant of type int");
                }
                astBeatDefinition.setPriority((int)name.getConstantValue());
            }
        }
        catch (CompileException ex) {
            throw new ParseException(ex.getMessage());
        }
        jj_consume_token(97);
    }
    
    public static final void PriorityTest(final ASTBeatDefinition astBeatDefinition) throws ParseException {
        final ASTPriorityTest astPriorityTest = new ASTPriorityTest(7);
        int n = 1;
        BeatParser.jjtree.openNodeScope(astPriorityTest);
        jjtreeOpenNodeScope(astPriorityTest);
        Token jj_consume_token = null;
        ASTJavaName name = null;
        try {
            jj_consume_token(73);
            switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                case 0: {
                    jj_consume_token = jj_consume_token(79);
                    break;
                }
                case 8: {
                    name = Name();
                    break;
                }
                default: {
                    BeatParser.jj_la1[12] = BeatParser.jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
                }
            }
            try {
                if (jj_consume_token != null) {
                    astPriorityTest.setPriority(Integer.parseInt(jj_consume_token.image));
                }
                else {
                    if (name.getConstantType() != "int") {
                        throw new ParseException(name.dumpTokens() + " is not a constant of type int");
                    }
                    astPriorityTest.setPriority((int)name.getConstantValue());
                }
            }
            catch (CompileException ex) {
                throw new ParseException(ex.getMessage());
            }
            jj_consume_token(93);
            final ASTTestExpression testExpression = TestExpression();
            jj_consume_token(94);
            BeatParser.jjtree.closeNodeScope(astPriorityTest, true);
            n = 0;
            jjtreeCloseNodeScope(astPriorityTest);
            testExpression.setTestType(2);
            astBeatDefinition.addPriorityTest(astPriorityTest);
        }
        catch (Throwable t) {
            if (n != 0) {
                BeatParser.jjtree.clearNodeScope(astPriorityTest);
                n = 0;
            }
            else {
                BeatParser.jjtree.popNode();
            }
            if (t instanceof RuntimeException) {
                throw (RuntimeException)t;
            }
            if (t instanceof ParseException) {
                throw (ParseException)t;
            }
            throw (Error)t;
        }
        finally {
            if (n != 0) {
                BeatParser.jjtree.closeNodeScope(astPriorityTest, true);
                jjtreeCloseNodeScope(astPriorityTest);
            }
        }
        if (n != 0) {
            BeatParser.jjtree.closeNodeScope(astPriorityTest, true);
            jjtreeCloseNodeScope(astPriorityTest);
        }
    }
    
    public static final void Effects(final ASTBeatDefinition astBeatDefinition) throws ParseException {
        jj_consume_token(69);
        while (true) {
            Effect(astBeatDefinition);
            switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                case 91: {
                    continue;
                }
                default: {
                    BeatParser.jj_la1[13] = BeatParser.jj_gen;
                    jj_consume_token(97);
                }
            }
        }
    }
    
    public static final void Effect(final ASTBeatDefinition astBeatDefinition) throws ParseException {
        final ASTEffect astEffect = new ASTEffect(8);
        int n = 1;
        BeatParser.jjtree.openNodeScope(astEffect);
        jjtreeOpenNodeScope(astEffect);
        try {
            jj_consume_token(91);
            astEffect.setEffectName(BeatName().image);
            switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                case 0:
                case 1: {
                    switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                        case 0: {
                            jj_consume_token(115);
                            astEffect.setRelativeValueDirection(0);
                            break;
                        }
                        case 1: {
                            jj_consume_token(116);
                            astEffect.setRelativeValueDirection(1);
                            break;
                        }
                        default: {
                            BeatParser.jj_la1[14] = BeatParser.jj_gen;
                            jj_consume_token(-1);
                            throw new ParseException();
                        }
                    }
                    break;
                }
                default: {
                    BeatParser.jj_la1[15] = BeatParser.jj_gen;
                    break;
                }
            }
            astEffect.setEffectValue((float)Integer.parseInt(jj_consume_token(79).image));
            jj_consume_token(92);
            BeatParser.jjtree.closeNodeScope(astEffect, true);
            n = 0;
            jjtreeCloseNodeScope(astEffect);
            astBeatDefinition.addEffect(astEffect);
        }
        catch (Throwable t) {
            if (n != 0) {
                BeatParser.jjtree.clearNodeScope(astEffect);
                n = 0;
            }
            else {
                BeatParser.jjtree.popNode();
            }
            if (t instanceof RuntimeException) {
                throw (RuntimeException)t;
            }
            if (t instanceof ParseException) {
                throw (ParseException)t;
            }
            throw (Error)t;
        }
        finally {
            if (n != 0) {
                BeatParser.jjtree.closeNodeScope(astEffect, true);
                jjtreeCloseNodeScope(astEffect);
            }
        }
        if (n != 0) {
            BeatParser.jjtree.closeNodeScope(astEffect, true);
            jjtreeCloseNodeScope(astEffect);
        }
    }
    
    public static final void DiscourseRules(final ASTBeatDefinition astBeatDefinition) throws ParseException {
        jj_consume_token(68);
        astBeatDefinition.setDiscourseRulesFilename(FileName());
        jj_consume_token(97);
    }
    
    public static final void BeatBehaviors(final ASTBeatDefinition astBeatDefinition) throws ParseException {
        jj_consume_token(66);
        astBeatDefinition.setBeatBehaviorsFilename(FileName());
        jj_consume_token(97);
    }
    
    public static final void InitAction(final ASTBeatDefinition astBeatDefinition) throws ParseException {
        final ASTInitAction initAction = new ASTInitAction(9);
        int n = 1;
        BeatParser.jjtree.openNodeScope(initAction);
        jjtreeOpenNodeScope(initAction);
        try {
            jj_consume_token(71);
            jj_consume_token(93);
            Code();
            jj_consume_token(94);
            BeatParser.jjtree.closeNodeScope(initAction, true);
            n = 0;
            jjtreeCloseNodeScope(initAction);
            try {
                astBeatDefinition.setInitAction(initAction);
            }
            catch (CompileException ex) {
                throw new ParseException(ex.getMessage());
            }
        }
        catch (Throwable t) {
            if (n != 0) {
                BeatParser.jjtree.clearNodeScope(initAction);
                n = 0;
            }
            else {
                BeatParser.jjtree.popNode();
            }
            if (t instanceof RuntimeException) {
                throw (RuntimeException)t;
            }
            if (t instanceof ParseException) {
                throw (ParseException)t;
            }
            throw (Error)t;
        }
        finally {
            if (n != 0) {
                BeatParser.jjtree.closeNodeScope(initAction, true);
                jjtreeCloseNodeScope(initAction);
            }
        }
        if (n != 0) {
            BeatParser.jjtree.closeNodeScope(initAction, true);
            jjtreeCloseNodeScope(initAction);
        }
    }
    
    public static final void SelectAction(final ASTBeatDefinition astBeatDefinition) throws ParseException {
        final ASTSelectAction selectAction = new ASTSelectAction(10);
        int n = 1;
        BeatParser.jjtree.openNodeScope(selectAction);
        jjtreeOpenNodeScope(selectAction);
        try {
            jj_consume_token(74);
            jj_consume_token(93);
            Code();
            jj_consume_token(94);
            BeatParser.jjtree.closeNodeScope(selectAction, true);
            n = 0;
            jjtreeCloseNodeScope(selectAction);
            try {
                astBeatDefinition.setSelectAction(selectAction);
            }
            catch (CompileException ex) {
                throw new ParseException(ex.getMessage());
            }
        }
        catch (Throwable t) {
            if (n != 0) {
                BeatParser.jjtree.clearNodeScope(selectAction);
                n = 0;
            }
            else {
                BeatParser.jjtree.popNode();
            }
            if (t instanceof RuntimeException) {
                throw (RuntimeException)t;
            }
            if (t instanceof ParseException) {
                throw (ParseException)t;
            }
            throw (Error)t;
        }
        finally {
            if (n != 0) {
                BeatParser.jjtree.closeNodeScope(selectAction, true);
                jjtreeCloseNodeScope(selectAction);
            }
        }
        if (n != 0) {
            BeatParser.jjtree.closeNodeScope(selectAction, true);
            jjtreeCloseNodeScope(selectAction);
        }
    }
    
    public static final void AbortAction(final ASTBeatDefinition astBeatDefinition) throws ParseException {
        final ASTAbortAction abortAction = new ASTAbortAction(11);
        int n = 1;
        BeatParser.jjtree.openNodeScope(abortAction);
        jjtreeOpenNodeScope(abortAction);
        try {
            jj_consume_token(63);
            jj_consume_token(93);
            Code();
            jj_consume_token(94);
            BeatParser.jjtree.closeNodeScope(abortAction, true);
            n = 0;
            jjtreeCloseNodeScope(abortAction);
            try {
                astBeatDefinition.setAbortAction(abortAction);
            }
            catch (CompileException ex) {
                throw new ParseException(ex.getMessage());
            }
        }
        catch (Throwable t) {
            if (n != 0) {
                BeatParser.jjtree.clearNodeScope(abortAction);
                n = 0;
            }
            else {
                BeatParser.jjtree.popNode();
            }
            if (t instanceof RuntimeException) {
                throw (RuntimeException)t;
            }
            if (t instanceof ParseException) {
                throw (ParseException)t;
            }
            throw (Error)t;
        }
        finally {
            if (n != 0) {
                BeatParser.jjtree.closeNodeScope(abortAction, true);
                jjtreeCloseNodeScope(abortAction);
            }
        }
        if (n != 0) {
            BeatParser.jjtree.closeNodeScope(abortAction, true);
            jjtreeCloseNodeScope(abortAction);
        }
    }
    
    public static final void SucceedAction(final ASTBeatDefinition astBeatDefinition) throws ParseException {
        final ASTSucceedAction succeedAction = new ASTSucceedAction(12);
        int n = 1;
        BeatParser.jjtree.openNodeScope(succeedAction);
        jjtreeOpenNodeScope(succeedAction);
        try {
            jj_consume_token(75);
            jj_consume_token(93);
            Code();
            jj_consume_token(94);
            BeatParser.jjtree.closeNodeScope(succeedAction, true);
            n = 0;
            jjtreeCloseNodeScope(succeedAction);
            try {
                astBeatDefinition.setSucceedAction(succeedAction);
            }
            catch (CompileException ex) {
                throw new ParseException(ex.getMessage());
            }
        }
        catch (Throwable t) {
            if (n != 0) {
                BeatParser.jjtree.clearNodeScope(succeedAction);
                n = 0;
            }
            else {
                BeatParser.jjtree.popNode();
            }
            if (t instanceof RuntimeException) {
                throw (RuntimeException)t;
            }
            if (t instanceof ParseException) {
                throw (ParseException)t;
            }
            throw (Error)t;
        }
        finally {
            if (n != 0) {
                BeatParser.jjtree.closeNodeScope(succeedAction, true);
                jjtreeCloseNodeScope(succeedAction);
            }
        }
        if (n != 0) {
            BeatParser.jjtree.closeNodeScope(succeedAction, true);
            jjtreeCloseNodeScope(succeedAction);
        }
    }
    
    public static final void Code() throws ParseException {
        while (jj_2_1(Integer.MAX_VALUE)) {
            BeatVariableDeclaration();
            jj_consume_token(97);
        }
        while (true) {
            switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                case 14:
                case 15:
                case 16:
                case 19:
                case 22:
                case 24:
                case 25:
                case 28:
                case 31:
                case 32:
                case 34:
                case 38:
                case 40:
                case 42:
                case 43:
                case 48:
                case 49:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 58:
                case 59:
                case 60:
                case 62:
                case 79:
                case 83:
                case 85:
                case 86:
                case 87:
                case 91:
                case 93:
                case 97:
                case 113:
                case 114: {
                    Statement();
                    continue;
                }
                default: {
                    BeatParser.jj_la1[16] = BeatParser.jj_gen;
                }
            }
        }
    }
    
    public static final String FileName() throws ParseException {
        final ASTFileName astFileName = new ASTFileName(13);
        boolean b = true;
        BeatParser.jjtree.openNodeScope(astFileName);
        jjtreeOpenNodeScope(astFileName);
        try {
            if (jj_2_2(2)) {
                jj_consume_token(87);
                jj_consume_token(137);
            }
            jj_consume_token(87);
            switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                case 0:
                case 17: {
                    switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                        case 17: {
                            jj_consume_token(116);
                            break;
                        }
                        case 0: {
                            jj_consume_token(99);
                            break;
                        }
                        default: {
                            BeatParser.jj_la1[17] = BeatParser.jj_gen;
                            jj_consume_token(-1);
                            throw new ParseException();
                        }
                    }
                    jj_consume_token(87);
                    break;
                }
                default: {
                    BeatParser.jj_la1[18] = BeatParser.jj_gen;
                    break;
                }
            }
            while (true) {
                jj_consume_token(90);
                jj_consume_token(87);
                switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                    case 0:
                    case 17: {
                        switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                            case 17: {
                                jj_consume_token(116);
                                break;
                            }
                            case 0: {
                                jj_consume_token(99);
                                break;
                            }
                            default: {
                                BeatParser.jj_la1[19] = BeatParser.jj_gen;
                                jj_consume_token(-1);
                                throw new ParseException();
                            }
                        }
                        jj_consume_token(87);
                        break;
                    }
                    default: {
                        BeatParser.jj_la1[20] = BeatParser.jj_gen;
                        break;
                    }
                }
                switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                    case 0: {
                        continue;
                    }
                    default: {
                        BeatParser.jj_la1[21] = BeatParser.jj_gen;
                        BeatParser.jjtree.closeNodeScope(astFileName, true);
                        b = false;
                        jjtreeCloseNodeScope(astFileName);
                        return astFileName.dumpTokens();
                    }
                }
            }
        }
        finally {
            if (b) {
                BeatParser.jjtree.closeNodeScope(astFileName, true);
                jjtreeCloseNodeScope(astFileName);
            }
        }
    }
    
    public static final Token BeatName() throws ParseException {
        return jj_consume_token(87);
    }
    
    public static final ASTTestExpression TestExpression() throws ParseException {
        final ASTTestExpression astTestExpression = new ASTTestExpression(14);
        int n = 1;
        BeatParser.jjtree.openNodeScope(astTestExpression);
        jjtreeOpenNodeScope(astTestExpression);
        String image = null;
        try {
            if (jj_2_3(Integer.MAX_VALUE)) {
                image = jj_consume_token(87).image;
            }
            while (true) {
                WMETestSequence(image);
                switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                    case 0:
                    case 4:
                    case 6:
                    case 16: {
                        continue;
                    }
                    default: {
                        BeatParser.jj_la1[22] = BeatParser.jj_gen;
                        BeatParser.jjtree.closeNodeScope(astTestExpression, true);
                        n = 0;
                        jjtreeCloseNodeScope(astTestExpression);
                        return astTestExpression;
                    }
                }
            }
        }
        catch (Throwable t) {
            if (n != 0) {
                BeatParser.jjtree.clearNodeScope(astTestExpression);
                n = 0;
            }
            else {
                BeatParser.jjtree.popNode();
            }
            if (t instanceof RuntimeException) {
                throw (RuntimeException)t;
            }
            if (t instanceof ParseException) {
                throw (ParseException)t;
            }
            throw (Error)t;
        }
        finally {
            if (n != 0) {
                BeatParser.jjtree.closeNodeScope(astTestExpression, true);
                jjtreeCloseNodeScope(astTestExpression);
            }
        }
    }
    
    public static final void DefaultMemoryLookahead() throws ParseException {
        jj_consume_token(87);
        WMETestSequence(null);
    }
    
    public static final void WMETestSequence(final String s) throws ParseException {
        Label_0445: {
            switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                case 93: {
                    jj_consume_token(93);
                    final Token jj_consume_token = jj_consume_token(87);
                    while (true) {
                        if (jj_2_4(Integer.MAX_VALUE)) {
                            WMETest(jj_consume_token.image);
                        }
                        else {
                            switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                                case 91: {
                                    jj_consume_token(91);
                                    ConditionalExpression();
                                    jj_consume_token(92);
                                    break;
                                }
                                default: {
                                    BeatParser.jj_la1[23] = BeatParser.jj_gen;
                                    jj_consume_token(-1);
                                    throw new ParseException();
                                }
                            }
                        }
                        switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                            case 87:
                            case 91:
                            case 103: {
                                continue;
                            }
                            default: {
                                BeatParser.jj_la1[24] = BeatParser.jj_gen;
                                jj_consume_token(94);
                                break Label_0445;
                            }
                        }
                    }
                    break;
                }
                case 87:
                case 91:
                case 103: {
                    if (jj_2_5(Integer.MAX_VALUE)) {
                        WMETest(s);
                    }
                    else {
                        switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                            case 91: {
                                jj_consume_token(91);
                                ConditionalExpression();
                                jj_consume_token(92);
                                break;
                            }
                            default: {
                                BeatParser.jj_la1[25] = BeatParser.jj_gen;
                                jj_consume_token(-1);
                                throw new ParseException();
                            }
                        }
                    }
                    break;
                }
                default: {
                    BeatParser.jj_la1[26] = BeatParser.jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
                }
            }
        }
    }
    
    public static final void WMETest(final String memoryName) throws ParseException {
        final ASTWMETest astwmeTest = new ASTWMETest(15);
        int n = 1;
        BeatParser.jjtree.openNodeScope(astwmeTest);
        jjtreeOpenNodeScope(astwmeTest);
        Label_0334: {
            try {
                astwmeTest.setMemoryName(memoryName);
                switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                    case 0: {
                        jj_consume_token(103);
                        astwmeTest.negated = true;
                        break;
                    }
                    default: {
                        BeatParser.jj_la1[27] = BeatParser.jj_gen;
                        break;
                    }
                }
                switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                    case 0: {
                        final ASTJavaName name = Name();
                        jj_consume_token(100);
                        astwmeTest.setWMEAssignmentVariable(name);
                        break;
                    }
                    default: {
                        BeatParser.jj_la1[28] = BeatParser.jj_gen;
                        break;
                    }
                }
                jj_consume_token(91);
                astwmeTest.wmeClassName = WMEClass().image;
                while (true) {
                    switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                        case 0: {
                            WMEFieldTest();
                            continue;
                        }
                        default: {
                            BeatParser.jj_la1[29] = BeatParser.jj_gen;
                            jj_consume_token(92);
                            break Label_0334;
                        }
                    }
                }
            }
            catch (Throwable t) {
                if (n != 0) {
                    BeatParser.jjtree.clearNodeScope(astwmeTest);
                    n = 0;
                }
                else {
                    BeatParser.jjtree.popNode();
                }
                if (t instanceof RuntimeException) {
                    throw (RuntimeException)t;
                }
                if (t instanceof ParseException) {
                    throw (ParseException)t;
                }
                throw (Error)t;
            }
            finally {
                if (n != 0) {
                    BeatParser.jjtree.closeNodeScope(astwmeTest, true);
                    jjtreeCloseNodeScope(astwmeTest);
                }
            }
        }
        if (n != 0) {
            BeatParser.jjtree.closeNodeScope(astwmeTest, true);
            jjtreeCloseNodeScope(astwmeTest);
        }
    }
    
    public static final Token WMEClass() throws ParseException {
        BeatName();
        return getToken(0);
    }
    
    public static final void WMEFieldTest() throws ParseException {
        final ASTWMEFieldTest astwmeFieldTest = new ASTWMEFieldTest(16);
        int n = 1;
        BeatParser.jjtree.openNodeScope(astwmeFieldTest);
        jjtreeOpenNodeScope(astwmeFieldTest);
        try {
            astwmeFieldTest.setWMEFieldName(jj_consume_token(87).image);
            switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                case 0: {
                    jj_consume_token(78);
                    break;
                }
                case 23: {
                    jj_consume_token(101);
                    break;
                }
                case 24: {
                    jj_consume_token(102);
                    break;
                }
                case 29: {
                    jj_consume_token(107);
                    break;
                }
                case 30: {
                    jj_consume_token(108);
                    break;
                }
                case 31: {
                    jj_consume_token(109);
                    break;
                }
                case 32: {
                    jj_consume_token(110);
                    break;
                }
                default: {
                    BeatParser.jj_la1[30] = BeatParser.jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
                }
            }
            astwmeFieldTest.setTestOp(getToken(0).kind);
            final ASTBeatExpression beatExpression = BeatExpression();
            BeatParser.jjtree.closeNodeScope(astwmeFieldTest, true);
            n = 0;
            jjtreeCloseNodeScope(astwmeFieldTest);
            astwmeFieldTest.setWMETestOperand(beatExpression);
        }
        catch (Throwable t) {
            if (n != 0) {
                BeatParser.jjtree.clearNodeScope(astwmeFieldTest);
                n = 0;
            }
            else {
                BeatParser.jjtree.popNode();
            }
            if (t instanceof RuntimeException) {
                throw (RuntimeException)t;
            }
            if (t instanceof ParseException) {
                throw (ParseException)t;
            }
            throw (Error)t;
        }
        finally {
            if (n != 0) {
                BeatParser.jjtree.closeNodeScope(astwmeFieldTest, true);
                jjtreeCloseNodeScope(astwmeFieldTest);
            }
        }
        if (n != 0) {
            BeatParser.jjtree.closeNodeScope(astwmeFieldTest, true);
            jjtreeCloseNodeScope(astwmeFieldTest);
        }
    }
    
    public static final String ConstantDeclaration() throws ParseException {
        final ASTConstantDeclaration astConstantDeclaration = new ASTConstantDeclaration(17);
        int n = 1;
        BeatParser.jjtree.openNodeScope(astConstantDeclaration);
        jjtreeOpenNodeScope(astConstantDeclaration);
        try {
            jj_consume_token(67);
            Name();
            switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                case 0: {
                    jj_consume_token(99);
                    jj_consume_token(117);
                    break;
                }
                default: {
                    BeatParser.jj_la1[31] = BeatParser.jj_gen;
                    break;
                }
            }
            jj_consume_token(97);
            BeatParser.jjtree.closeNodeScope(astConstantDeclaration, true);
            n = 0;
            jjtreeCloseNodeScope(astConstantDeclaration);
            return astConstantDeclaration.dumpTokens(1, astConstantDeclaration.numberOfTokens() - 1);
        }
        catch (Throwable t) {
            if (n != 0) {
                BeatParser.jjtree.clearNodeScope(astConstantDeclaration);
                n = 0;
            }
            else {
                BeatParser.jjtree.popNode();
            }
            if (t instanceof RuntimeException) {
                throw (RuntimeException)t;
            }
            if (t instanceof ParseException) {
                throw (ParseException)t;
            }
            throw (Error)t;
        }
        finally {
            if (n != 0) {
                BeatParser.jjtree.closeNodeScope(astConstantDeclaration, true);
                jjtreeCloseNodeScope(astConstantDeclaration);
            }
        }
    }
    
    public static final ASTBeatExpression BeatExpression() throws ParseException {
        final ASTBeatExpression astBeatExpression = new ASTBeatExpression(18);
        int n = 1;
        BeatParser.jjtree.openNodeScope(astBeatExpression);
        jjtreeOpenNodeScope(astBeatExpression);
        try {
            switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                case 87: {
                    Name();
                    break;
                }
                case 28:
                case 43:
                case 58:
                case 79:
                case 83:
                case 85:
                case 86: {
                    BeatLiteral();
                    break;
                }
                default: {
                    BeatParser.jj_la1[32] = BeatParser.jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
                }
            }
            BeatParser.jjtree.closeNodeScope(astBeatExpression, true);
            n = 0;
            jjtreeCloseNodeScope(astBeatExpression);
            return astBeatExpression;
        }
        catch (Throwable t) {
            if (n != 0) {
                BeatParser.jjtree.clearNodeScope(astBeatExpression);
                n = 0;
            }
            else {
                BeatParser.jjtree.popNode();
            }
            if (t instanceof RuntimeException) {
                throw (RuntimeException)t;
            }
            if (t instanceof ParseException) {
                throw (ParseException)t;
            }
            throw (Error)t;
        }
        finally {
            if (n != 0) {
                BeatParser.jjtree.closeNodeScope(astBeatExpression, true);
                jjtreeCloseNodeScope(astBeatExpression);
            }
        }
    }
    
    public static final Token BeatLiteral() throws ParseException {
        switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
            case 79: {
                jj_consume_token(79);
                break;
            }
            case 83: {
                jj_consume_token(83);
                break;
            }
            case 85: {
                jj_consume_token(85);
                break;
            }
            case 86: {
                jj_consume_token(86);
                break;
            }
            case 28:
            case 58: {
                BooleanLiteral();
                break;
            }
            case 43: {
                NullLiteral();
                break;
            }
            default: {
                BeatParser.jj_la1[33] = BeatParser.jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
            }
        }
        return getToken(0);
    }
    
    public static final void CompilationUnit() throws ParseException {
        switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
            case 44: {
                PackageDeclaration();
                break;
            }
            default: {
                BeatParser.jj_la1[34] = BeatParser.jj_gen;
                break;
            }
        }
        while (true) {
            switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                case 36: {
                    ImportDeclaration();
                    continue;
                }
                default: {
                    BeatParser.jj_la1[35] = BeatParser.jj_gen;
                    while (true) {
                        switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                            case 13:
                            case 20:
                            case 29:
                            case 39:
                            case 47:
                            case 97: {
                                TypeDeclaration();
                                continue;
                            }
                            default: {
                                BeatParser.jj_la1[36] = BeatParser.jj_gen;
                                jj_consume_token(0);
                                return;
                            }
                        }
                    }
                    break;
                }
            }
        }
    }
    
    public static final void PackageDeclaration() throws ParseException {
        jj_consume_token(44);
        Name();
        jj_consume_token(97);
    }
    
    public static final String ImportDeclaration() throws ParseException {
        final ASTImportDeclaration astImportDeclaration = new ASTImportDeclaration(19);
        int n = 1;
        BeatParser.jjtree.openNodeScope(astImportDeclaration);
        jjtreeOpenNodeScope(astImportDeclaration);
        try {
            jj_consume_token(36);
            Name();
            switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                case 0: {
                    jj_consume_token(99);
                    jj_consume_token(117);
                    break;
                }
                default: {
                    BeatParser.jj_la1[37] = BeatParser.jj_gen;
                    break;
                }
            }
            jj_consume_token(97);
            BeatParser.jjtree.closeNodeScope(astImportDeclaration, true);
            n = 0;
            jjtreeCloseNodeScope(astImportDeclaration);
            return astImportDeclaration.dumpTokens(1, astImportDeclaration.numberOfTokens() - 1);
        }
        catch (Throwable t) {
            if (n != 0) {
                BeatParser.jjtree.clearNodeScope(astImportDeclaration);
                n = 0;
            }
            else {
                BeatParser.jjtree.popNode();
            }
            if (t instanceof RuntimeException) {
                throw (RuntimeException)t;
            }
            if (t instanceof ParseException) {
                throw (ParseException)t;
            }
            throw (Error)t;
        }
        finally {
            if (n != 0) {
                BeatParser.jjtree.closeNodeScope(astImportDeclaration, true);
                jjtreeCloseNodeScope(astImportDeclaration);
            }
        }
    }
    
    public static final void TypeDeclaration() throws ParseException {
        if (jj_2_6(Integer.MAX_VALUE)) {
            ClassDeclaration();
        }
        else {
            switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                case 13:
                case 39:
                case 47: {
                    InterfaceDeclaration();
                    break;
                }
                case 97: {
                    jj_consume_token(97);
                    break;
                }
                default: {
                    BeatParser.jj_la1[38] = BeatParser.jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
                }
            }
        }
    }
    
    public static final void ClassDeclaration() throws ParseException {
        while (true) {
            switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                case 13:
                case 29:
                case 47: {
                    switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                        case 13: {
                            jj_consume_token(13);
                            continue;
                        }
                        case 29: {
                            jj_consume_token(29);
                            continue;
                        }
                        case 47: {
                            jj_consume_token(47);
                            continue;
                        }
                        default: {
                            BeatParser.jj_la1[40] = BeatParser.jj_gen;
                            jj_consume_token(-1);
                            throw new ParseException();
                        }
                    }
                    continue;
                }
                default: {
                    BeatParser.jj_la1[39] = BeatParser.jj_gen;
                    UnmodifiedClassDeclaration();
                }
            }
        }
    }
    
    public static final void UnmodifiedClassDeclaration() throws ParseException {
        jj_consume_token(20);
        jj_consume_token(87);
        switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
            case 27: {
                jj_consume_token(27);
                Name();
                break;
            }
            default: {
                BeatParser.jj_la1[41] = BeatParser.jj_gen;
                break;
            }
        }
        switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
            case 35: {
                jj_consume_token(35);
                NameList();
                break;
            }
            default: {
                BeatParser.jj_la1[42] = BeatParser.jj_gen;
                break;
            }
        }
        ClassBody();
    }
    
    public static final void ClassBody() throws ParseException {
        jj_consume_token(93);
        while (true) {
            switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                case 13:
                case 14:
                case 16:
                case 19:
                case 20:
                case 25:
                case 29:
                case 31:
                case 38:
                case 39:
                case 40:
                case 41:
                case 45:
                case 46:
                case 47:
                case 49:
                case 50:
                case 53:
                case 57:
                case 60:
                case 61:
                case 87:
                case 93: {
                    ClassBodyDeclaration();
                    continue;
                }
                default: {
                    BeatParser.jj_la1[43] = BeatParser.jj_gen;
                    jj_consume_token(94);
                }
            }
        }
    }
    
    public static final void NestedClassDeclaration() throws ParseException {
        while (true) {
            switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                case 13:
                case 29:
                case 45:
                case 46:
                case 47:
                case 50: {
                    switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                        case 50: {
                            jj_consume_token(50);
                            continue;
                        }
                        case 13: {
                            jj_consume_token(13);
                            continue;
                        }
                        case 29: {
                            jj_consume_token(29);
                            continue;
                        }
                        case 47: {
                            jj_consume_token(47);
                            continue;
                        }
                        case 46: {
                            jj_consume_token(46);
                            continue;
                        }
                        case 45: {
                            jj_consume_token(45);
                            continue;
                        }
                        default: {
                            BeatParser.jj_la1[45] = BeatParser.jj_gen;
                            jj_consume_token(-1);
                            throw new ParseException();
                        }
                    }
                    continue;
                }
                default: {
                    BeatParser.jj_la1[44] = BeatParser.jj_gen;
                    UnmodifiedClassDeclaration();
                }
            }
        }
    }
    
    public static final void ClassBodyDeclaration() throws ParseException {
        if (jj_2_7(2)) {
            Initializer();
        }
        else if (jj_2_8(Integer.MAX_VALUE)) {
            NestedClassDeclaration();
        }
        else if (jj_2_9(Integer.MAX_VALUE)) {
            NestedInterfaceDeclaration();
        }
        else if (jj_2_10(Integer.MAX_VALUE)) {
            ConstructorDeclaration();
        }
        else if (jj_2_11(Integer.MAX_VALUE)) {
            MethodDeclaration();
        }
        else {
            switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                case 14:
                case 16:
                case 19:
                case 25:
                case 29:
                case 31:
                case 38:
                case 40:
                case 45:
                case 46:
                case 47:
                case 49:
                case 50:
                case 57:
                case 61:
                case 87: {
                    FieldDeclaration();
                    break;
                }
                default: {
                    BeatParser.jj_la1[46] = BeatParser.jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
                }
            }
        }
    }
    
    public static final void MethodDeclarationLookahead() throws ParseException {
        while (true) {
            switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                case 13:
                case 29:
                case 41:
                case 45:
                case 46:
                case 47:
                case 50:
                case 53: {
                    switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                        case 47: {
                            jj_consume_token(47);
                            continue;
                        }
                        case 46: {
                            jj_consume_token(46);
                            continue;
                        }
                        case 45: {
                            jj_consume_token(45);
                            continue;
                        }
                        case 50: {
                            jj_consume_token(50);
                            continue;
                        }
                        case 13: {
                            jj_consume_token(13);
                            continue;
                        }
                        case 29: {
                            jj_consume_token(29);
                            continue;
                        }
                        case 41: {
                            jj_consume_token(41);
                            continue;
                        }
                        case 53: {
                            jj_consume_token(53);
                            continue;
                        }
                        default: {
                            BeatParser.jj_la1[48] = BeatParser.jj_gen;
                            jj_consume_token(-1);
                            throw new ParseException();
                        }
                    }
                    continue;
                }
                default: {
                    BeatParser.jj_la1[47] = BeatParser.jj_gen;
                    ResultType();
                    jj_consume_token(87);
                    jj_consume_token(91);
                }
            }
        }
    }
    
    public static final void InterfaceDeclaration() throws ParseException {
        while (true) {
            switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                case 13:
                case 47: {
                    switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                        case 13: {
                            jj_consume_token(13);
                            continue;
                        }
                        case 47: {
                            jj_consume_token(47);
                            continue;
                        }
                        default: {
                            BeatParser.jj_la1[50] = BeatParser.jj_gen;
                            jj_consume_token(-1);
                            throw new ParseException();
                        }
                    }
                    continue;
                }
                default: {
                    BeatParser.jj_la1[49] = BeatParser.jj_gen;
                    UnmodifiedInterfaceDeclaration();
                }
            }
        }
    }
    
    public static final void NestedInterfaceDeclaration() throws ParseException {
        while (true) {
            switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                case 13:
                case 29:
                case 45:
                case 46:
                case 47:
                case 50: {
                    switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                        case 50: {
                            jj_consume_token(50);
                            continue;
                        }
                        case 13: {
                            jj_consume_token(13);
                            continue;
                        }
                        case 29: {
                            jj_consume_token(29);
                            continue;
                        }
                        case 47: {
                            jj_consume_token(47);
                            continue;
                        }
                        case 46: {
                            jj_consume_token(46);
                            continue;
                        }
                        case 45: {
                            jj_consume_token(45);
                            continue;
                        }
                        default: {
                            BeatParser.jj_la1[52] = BeatParser.jj_gen;
                            jj_consume_token(-1);
                            throw new ParseException();
                        }
                    }
                    continue;
                }
                default: {
                    BeatParser.jj_la1[51] = BeatParser.jj_gen;
                    UnmodifiedInterfaceDeclaration();
                }
            }
        }
    }
    
    public static final void UnmodifiedInterfaceDeclaration() throws ParseException {
        jj_consume_token(39);
        jj_consume_token(87);
        switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
            case 27: {
                jj_consume_token(27);
                NameList();
                break;
            }
            default: {
                BeatParser.jj_la1[53] = BeatParser.jj_gen;
                break;
            }
        }
        jj_consume_token(93);
        while (true) {
            switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                case 13:
                case 14:
                case 16:
                case 19:
                case 20:
                case 25:
                case 29:
                case 31:
                case 38:
                case 39:
                case 40:
                case 41:
                case 45:
                case 46:
                case 47:
                case 49:
                case 50:
                case 53:
                case 57:
                case 60:
                case 61:
                case 87: {
                    InterfaceMemberDeclaration();
                    continue;
                }
                default: {
                    BeatParser.jj_la1[54] = BeatParser.jj_gen;
                    jj_consume_token(94);
                }
            }
        }
    }
    
    public static final void InterfaceMemberDeclaration() throws ParseException {
        if (jj_2_12(Integer.MAX_VALUE)) {
            NestedClassDeclaration();
        }
        else if (jj_2_13(Integer.MAX_VALUE)) {
            NestedInterfaceDeclaration();
        }
        else if (jj_2_14(Integer.MAX_VALUE)) {
            MethodDeclaration();
        }
        else {
            switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                case 14:
                case 16:
                case 19:
                case 25:
                case 29:
                case 31:
                case 38:
                case 40:
                case 45:
                case 46:
                case 47:
                case 49:
                case 50:
                case 57:
                case 61:
                case 87: {
                    FieldDeclaration();
                    break;
                }
                default: {
                    BeatParser.jj_la1[55] = BeatParser.jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
                }
            }
        }
    }
    
    public static final void FieldDeclaration() throws ParseException {
        while (true) {
            switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                case 29:
                case 45:
                case 46:
                case 47:
                case 50:
                case 57:
                case 61: {
                    switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                        case 47: {
                            jj_consume_token(47);
                            continue;
                        }
                        case 46: {
                            jj_consume_token(46);
                            continue;
                        }
                        case 45: {
                            jj_consume_token(45);
                            continue;
                        }
                        case 50: {
                            jj_consume_token(50);
                            continue;
                        }
                        case 29: {
                            jj_consume_token(29);
                            continue;
                        }
                        case 57: {
                            jj_consume_token(57);
                            continue;
                        }
                        case 61: {
                            jj_consume_token(61);
                            continue;
                        }
                        default: {
                            BeatParser.jj_la1[57] = BeatParser.jj_gen;
                            jj_consume_token(-1);
                            throw new ParseException();
                        }
                    }
                    continue;
                }
                default: {
                    BeatParser.jj_la1[56] = BeatParser.jj_gen;
                    Type();
                    VariableDeclarator();
                    while (true) {
                        switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                            case 98: {
                                jj_consume_token(98);
                                VariableDeclarator();
                                continue;
                            }
                            default: {
                                BeatParser.jj_la1[58] = BeatParser.jj_gen;
                                jj_consume_token(97);
                                return;
                            }
                        }
                    }
                    break;
                }
            }
        }
    }
    
    public static final void VariableDeclarator() throws ParseException {
        VariableDeclaratorId();
        switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
            case 100: {
                jj_consume_token(100);
                VariableInitializer();
                break;
            }
            default: {
                BeatParser.jj_la1[59] = BeatParser.jj_gen;
                break;
            }
        }
    }
    
    public static final void VariableDeclaratorId() throws ParseException {
        final ASTVariableDeclaratorID astVariableDeclaratorID = new ASTVariableDeclaratorID(20);
        final boolean b = true;
        BeatParser.jjtree.openNodeScope(astVariableDeclaratorID);
        jjtreeOpenNodeScope(astVariableDeclaratorID);
        Label_0139: {
            try {
                jj_consume_token(87);
                while (true) {
                    switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                        case 0: {
                            jj_consume_token(95);
                            jj_consume_token(96);
                            continue;
                        }
                        default: {
                            BeatParser.jj_la1[60] = BeatParser.jj_gen;
                            break Label_0139;
                        }
                    }
                }
            }
            finally {
                if (b) {
                    BeatParser.jjtree.closeNodeScope(astVariableDeclaratorID, true);
                    jjtreeCloseNodeScope(astVariableDeclaratorID);
                }
            }
        }
        if (b) {
            BeatParser.jjtree.closeNodeScope(astVariableDeclaratorID, true);
            jjtreeCloseNodeScope(astVariableDeclaratorID);
        }
    }
    
    public static final void VariableInitializer() throws ParseException {
        final ASTVariableInitializer astVariableInitializer = new ASTVariableInitializer(21);
        int n = 1;
        BeatParser.jjtree.openNodeScope(astVariableInitializer);
        jjtreeOpenNodeScope(astVariableInitializer);
        try {
            switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                case 93: {
                    ArrayInitializer();
                    break;
                }
                case 14:
                case 16:
                case 19:
                case 25:
                case 28:
                case 31:
                case 38:
                case 40:
                case 42:
                case 43:
                case 49:
                case 51:
                case 54:
                case 58:
                case 60:
                case 79:
                case 83:
                case 85:
                case 86:
                case 87:
                case 91:
                case 103:
                case 104:
                case 113:
                case 114:
                case 115:
                case 116: {
                    Expression();
                    break;
                }
                default: {
                    BeatParser.jj_la1[61] = BeatParser.jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
                }
            }
        }
        catch (Throwable t) {
            if (n != 0) {
                BeatParser.jjtree.clearNodeScope(astVariableInitializer);
                n = 0;
            }
            else {
                BeatParser.jjtree.popNode();
            }
            if (t instanceof RuntimeException) {
                throw (RuntimeException)t;
            }
            if (t instanceof ParseException) {
                throw (ParseException)t;
            }
            throw (Error)t;
        }
        finally {
            if (n != 0) {
                BeatParser.jjtree.closeNodeScope(astVariableInitializer, true);
                jjtreeCloseNodeScope(astVariableInitializer);
            }
        }
        if (n != 0) {
            BeatParser.jjtree.closeNodeScope(astVariableInitializer, true);
            jjtreeCloseNodeScope(astVariableInitializer);
        }
    }
    
    public static final void ArrayInitializer() throws ParseException {
        jj_consume_token(93);
        switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
            case 14:
            case 16:
            case 19:
            case 25:
            case 28:
            case 31:
            case 38:
            case 40:
            case 42:
            case 43:
            case 49:
            case 51:
            case 54:
            case 58:
            case 60:
            case 79:
            case 83:
            case 85:
            case 86:
            case 87:
            case 91:
            case 93:
            case 103:
            case 104:
            case 113:
            case 114:
            case 115:
            case 116: {
                VariableInitializer();
                while (jj_2_15(2)) {
                    jj_consume_token(98);
                    VariableInitializer();
                }
                break;
            }
            default: {
                BeatParser.jj_la1[62] = BeatParser.jj_gen;
                break;
            }
        }
        switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
            case 98: {
                jj_consume_token(98);
                break;
            }
            default: {
                BeatParser.jj_la1[63] = BeatParser.jj_gen;
                break;
            }
        }
        jj_consume_token(94);
    }
    
    public static final void MethodDeclaration() throws ParseException {
        while (true) {
            switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                case 13:
                case 29:
                case 41:
                case 45:
                case 46:
                case 47:
                case 50:
                case 53: {
                    switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                        case 47: {
                            jj_consume_token(47);
                            continue;
                        }
                        case 46: {
                            jj_consume_token(46);
                            continue;
                        }
                        case 45: {
                            jj_consume_token(45);
                            continue;
                        }
                        case 50: {
                            jj_consume_token(50);
                            continue;
                        }
                        case 13: {
                            jj_consume_token(13);
                            continue;
                        }
                        case 29: {
                            jj_consume_token(29);
                            continue;
                        }
                        case 41: {
                            jj_consume_token(41);
                            continue;
                        }
                        case 53: {
                            jj_consume_token(53);
                            continue;
                        }
                        default: {
                            BeatParser.jj_la1[65] = BeatParser.jj_gen;
                            jj_consume_token(-1);
                            throw new ParseException();
                        }
                    }
                    continue;
                }
                default: {
                    BeatParser.jj_la1[64] = BeatParser.jj_gen;
                    ResultType();
                    MethodDeclarator();
                    switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                        case 56: {
                            jj_consume_token(56);
                            NameList();
                            break;
                        }
                        default: {
                            BeatParser.jj_la1[66] = BeatParser.jj_gen;
                            break;
                        }
                    }
                    switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                        case 93: {
                            Block();
                            break;
                        }
                        case 97: {
                            jj_consume_token(97);
                            break;
                        }
                        default: {
                            BeatParser.jj_la1[67] = BeatParser.jj_gen;
                            jj_consume_token(-1);
                            throw new ParseException();
                        }
                    }
                }
            }
        }
    }
    
    public static final void MethodDeclarator() throws ParseException {
        jj_consume_token(87);
        FormalParameters();
        while (true) {
            switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                case 95: {
                    jj_consume_token(95);
                    jj_consume_token(96);
                    continue;
                }
                default: {
                    BeatParser.jj_la1[68] = BeatParser.jj_gen;
                }
            }
        }
    }
    
    public static final void FormalParameters() throws ParseException {
        jj_consume_token(91);
        Label_0187: {
            switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                case 14:
                case 16:
                case 19:
                case 25:
                case 29:
                case 31:
                case 38:
                case 40:
                case 49:
                case 87: {
                    FormalParameter();
                    while (true) {
                        switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                            case 98: {
                                jj_consume_token(98);
                                FormalParameter();
                                continue;
                            }
                            default: {
                                BeatParser.jj_la1[69] = BeatParser.jj_gen;
                                break Label_0187;
                            }
                        }
                    }
                    break;
                }
                default: {
                    BeatParser.jj_la1[70] = BeatParser.jj_gen;
                    break;
                }
            }
        }
        jj_consume_token(92);
    }
    
    public static final void FormalParameter() throws ParseException {
        switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
            case 29: {
                jj_consume_token(29);
                break;
            }
            default: {
                BeatParser.jj_la1[71] = BeatParser.jj_gen;
                break;
            }
        }
        Type();
        VariableDeclaratorId();
    }
    
    public static final void ConstructorDeclaration() throws ParseException {
        switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
            case 45:
            case 46:
            case 47: {
                switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                    case 47: {
                        jj_consume_token(47);
                        break;
                    }
                    case 46: {
                        jj_consume_token(46);
                        break;
                    }
                    case 45: {
                        jj_consume_token(45);
                        break;
                    }
                    default: {
                        BeatParser.jj_la1[72] = BeatParser.jj_gen;
                        jj_consume_token(-1);
                        throw new ParseException();
                    }
                }
                break;
            }
            default: {
                BeatParser.jj_la1[73] = BeatParser.jj_gen;
                break;
            }
        }
        jj_consume_token(87);
        FormalParameters();
        switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
            case 56: {
                jj_consume_token(56);
                NameList();
                break;
            }
            default: {
                BeatParser.jj_la1[74] = BeatParser.jj_gen;
                break;
            }
        }
        jj_consume_token(93);
        if (jj_2_16(Integer.MAX_VALUE)) {
            ExplicitConstructorInvocation();
        }
        while (true) {
            switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                case 14:
                case 15:
                case 16:
                case 19:
                case 20:
                case 22:
                case 24:
                case 25:
                case 28:
                case 29:
                case 31:
                case 32:
                case 34:
                case 38:
                case 39:
                case 40:
                case 42:
                case 43:
                case 48:
                case 49:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 58:
                case 59:
                case 60:
                case 62:
                case 79:
                case 83:
                case 85:
                case 86:
                case 87:
                case 91:
                case 93:
                case 97:
                case 113:
                case 114: {
                    BlockStatement();
                    continue;
                }
                default: {
                    BeatParser.jj_la1[75] = BeatParser.jj_gen;
                    jj_consume_token(94);
                }
            }
        }
    }
    
    public static final void ExplicitConstructorInvocation() throws ParseException {
        if (jj_2_18(Integer.MAX_VALUE)) {
            jj_consume_token(54);
            Arguments();
            jj_consume_token(97);
        }
        else {
            switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                case 14:
                case 16:
                case 19:
                case 25:
                case 28:
                case 31:
                case 38:
                case 40:
                case 42:
                case 43:
                case 49:
                case 51:
                case 54:
                case 58:
                case 60:
                case 79:
                case 83:
                case 85:
                case 86:
                case 87:
                case 91: {
                    if (jj_2_17(2)) {
                        PrimaryExpression();
                        jj_consume_token(99);
                    }
                    jj_consume_token(51);
                    Arguments();
                    jj_consume_token(97);
                    break;
                }
                default: {
                    BeatParser.jj_la1[76] = BeatParser.jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
                }
            }
        }
    }
    
    public static final void Initializer() throws ParseException {
        switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
            case 50: {
                jj_consume_token(50);
                break;
            }
            default: {
                BeatParser.jj_la1[77] = BeatParser.jj_gen;
                break;
            }
        }
        Block();
    }
    
    public static final ASTJavaType Type() throws ParseException {
        final ASTJavaType astJavaType = new ASTJavaType(3);
        int n = 1;
        BeatParser.jjtree.openNodeScope(astJavaType);
        jjtreeOpenNodeScope(astJavaType);
        try {
            switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                case 14:
                case 16:
                case 19:
                case 25:
                case 31:
                case 38:
                case 40:
                case 49: {
                    PrimitiveType();
                    break;
                }
                case 87: {
                    Name();
                    break;
                }
                default: {
                    BeatParser.jj_la1[78] = BeatParser.jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
                }
            }
            while (true) {
                switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                    case 0: {
                        jj_consume_token(95);
                        jj_consume_token(96);
                        continue;
                    }
                    default: {
                        BeatParser.jj_la1[79] = BeatParser.jj_gen;
                        BeatParser.jjtree.closeNodeScope(astJavaType, true);
                        n = 0;
                        jjtreeCloseNodeScope(astJavaType);
                        return astJavaType;
                    }
                }
            }
        }
        catch (Throwable t) {
            if (n != 0) {
                BeatParser.jjtree.clearNodeScope(astJavaType);
                n = 0;
            }
            else {
                BeatParser.jjtree.popNode();
            }
            if (t instanceof RuntimeException) {
                throw (RuntimeException)t;
            }
            if (t instanceof ParseException) {
                throw (ParseException)t;
            }
            throw (Error)t;
        }
        finally {
            if (n != 0) {
                BeatParser.jjtree.closeNodeScope(astJavaType, true);
                jjtreeCloseNodeScope(astJavaType);
            }
        }
    }
    
    public static final Token PrimitiveType() throws ParseException {
        switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
            case 14: {
                jj_consume_token(14);
                break;
            }
            case 19: {
                jj_consume_token(19);
                break;
            }
            case 16: {
                jj_consume_token(16);
                break;
            }
            case 49: {
                jj_consume_token(49);
                break;
            }
            case 38: {
                jj_consume_token(38);
                break;
            }
            case 40: {
                jj_consume_token(40);
                break;
            }
            case 31: {
                jj_consume_token(31);
                break;
            }
            case 25: {
                jj_consume_token(25);
                break;
            }
            default: {
                BeatParser.jj_la1[80] = BeatParser.jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
            }
        }
        return getToken(0);
    }
    
    public static final void ResultType() throws ParseException {
        switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
            case 60: {
                jj_consume_token(60);
                break;
            }
            case 14:
            case 16:
            case 19:
            case 25:
            case 31:
            case 38:
            case 40:
            case 49:
            case 87: {
                Type();
                break;
            }
            default: {
                BeatParser.jj_la1[81] = BeatParser.jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
            }
        }
    }
    
    public static final ASTJavaName Name() throws ParseException {
        final ASTJavaName astJavaName = new ASTJavaName(22);
        boolean b = true;
        BeatParser.jjtree.openNodeScope(astJavaName);
        jjtreeOpenNodeScope(astJavaName);
        try {
            jj_consume_token(87);
            while (jj_2_19(2)) {
                jj_consume_token(99);
                jj_consume_token(87);
            }
            BeatParser.jjtree.closeNodeScope(astJavaName, true);
            b = false;
            jjtreeCloseNodeScope(astJavaName);
            return astJavaName;
        }
        finally {
            if (b) {
                BeatParser.jjtree.closeNodeScope(astJavaName, true);
                jjtreeCloseNodeScope(astJavaName);
            }
        }
    }
    
    public static final void NameList() throws ParseException {
        Name();
        while (true) {
            switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                case 98: {
                    jj_consume_token(98);
                    Name();
                    continue;
                }
                default: {
                    BeatParser.jj_la1[82] = BeatParser.jj_gen;
                }
            }
        }
    }
    
    public static final void Expression() throws ParseException {
        ConditionalExpression();
        switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
            case 100:
            case 126:
            case 127:
            case 128:
            case 129:
            case 130:
            case 131:
            case 132:
            case 133:
            case 134:
            case 135:
            case 136: {
                AssignmentOperator();
                Expression();
                break;
            }
            default: {
                BeatParser.jj_la1[83] = BeatParser.jj_gen;
                break;
            }
        }
    }
    
    public static final void AssignmentOperator() throws ParseException {
        switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
            case 100: {
                jj_consume_token(100);
                break;
            }
            case 128: {
                jj_consume_token(128);
                break;
            }
            case 129: {
                jj_consume_token(129);
                break;
            }
            case 133: {
                jj_consume_token(133);
                break;
            }
            case 126: {
                jj_consume_token(126);
                break;
            }
            case 127: {
                jj_consume_token(127);
                break;
            }
            case 134: {
                jj_consume_token(134);
                break;
            }
            case 135: {
                jj_consume_token(135);
                break;
            }
            case 136: {
                jj_consume_token(136);
                break;
            }
            case 130: {
                jj_consume_token(130);
                break;
            }
            case 132: {
                jj_consume_token(132);
                break;
            }
            case 131: {
                jj_consume_token(131);
                break;
            }
            default: {
                BeatParser.jj_la1[84] = BeatParser.jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
            }
        }
    }
    
    public static final void ConditionalExpression() throws ParseException {
        final ASTConditionalExpression astConditionalExpression = new ASTConditionalExpression(23);
        int n = 1;
        BeatParser.jjtree.openNodeScope(astConditionalExpression);
        jjtreeOpenNodeScope(astConditionalExpression);
        try {
            ConditionalOrExpression();
            switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                case 0: {
                    jj_consume_token(105);
                    Expression();
                    jj_consume_token(106);
                    ConditionalExpression();
                    break;
                }
                default: {
                    BeatParser.jj_la1[85] = BeatParser.jj_gen;
                    break;
                }
            }
        }
        catch (Throwable t) {
            if (n != 0) {
                BeatParser.jjtree.clearNodeScope(astConditionalExpression);
                n = 0;
            }
            else {
                BeatParser.jjtree.popNode();
            }
            if (t instanceof RuntimeException) {
                throw (RuntimeException)t;
            }
            if (t instanceof ParseException) {
                throw (ParseException)t;
            }
            throw (Error)t;
        }
        finally {
            if (n != 0) {
                BeatParser.jjtree.closeNodeScope(astConditionalExpression, true);
                jjtreeCloseNodeScope(astConditionalExpression);
            }
        }
        if (n != 0) {
            BeatParser.jjtree.closeNodeScope(astConditionalExpression, true);
            jjtreeCloseNodeScope(astConditionalExpression);
        }
    }
    
    public static final void ConditionalOrExpression() throws ParseException {
        ConditionalAndExpression();
        while (true) {
            switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                case 111: {
                    jj_consume_token(111);
                    ConditionalAndExpression();
                    continue;
                }
                default: {
                    BeatParser.jj_la1[86] = BeatParser.jj_gen;
                }
            }
        }
    }
    
    public static final void ConditionalAndExpression() throws ParseException {
        InclusiveOrExpression();
        while (true) {
            switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                case 112: {
                    jj_consume_token(112);
                    InclusiveOrExpression();
                    continue;
                }
                default: {
                    BeatParser.jj_la1[87] = BeatParser.jj_gen;
                }
            }
        }
    }
    
    public static final void InclusiveOrExpression() throws ParseException {
        ExclusiveOrExpression();
        while (true) {
            switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                case 120: {
                    jj_consume_token(120);
                    ExclusiveOrExpression();
                    continue;
                }
                default: {
                    BeatParser.jj_la1[88] = BeatParser.jj_gen;
                }
            }
        }
    }
    
    public static final void ExclusiveOrExpression() throws ParseException {
        AndExpression();
        while (true) {
            switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                case 121: {
                    jj_consume_token(121);
                    AndExpression();
                    continue;
                }
                default: {
                    BeatParser.jj_la1[89] = BeatParser.jj_gen;
                }
            }
        }
    }
    
    public static final void AndExpression() throws ParseException {
        EqualityExpression();
        while (true) {
            switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                case 119: {
                    jj_consume_token(119);
                    EqualityExpression();
                    continue;
                }
                default: {
                    BeatParser.jj_la1[90] = BeatParser.jj_gen;
                }
            }
        }
    }
    
    public static final void EqualityExpression() throws ParseException {
        InstanceOfExpression();
        while (true) {
            switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                case 107:
                case 110: {
                    switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                        case 107: {
                            jj_consume_token(107);
                            break;
                        }
                        case 110: {
                            jj_consume_token(110);
                            break;
                        }
                        default: {
                            BeatParser.jj_la1[92] = BeatParser.jj_gen;
                            jj_consume_token(-1);
                            throw new ParseException();
                        }
                    }
                    InstanceOfExpression();
                    continue;
                }
                default: {
                    BeatParser.jj_la1[91] = BeatParser.jj_gen;
                }
            }
        }
    }
    
    public static final void InstanceOfExpression() throws ParseException {
        RelationalExpression();
        switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
            case 37: {
                jj_consume_token(37);
                Type();
                break;
            }
            default: {
                BeatParser.jj_la1[93] = BeatParser.jj_gen;
                break;
            }
        }
    }
    
    public static final void RelationalExpression() throws ParseException {
        ShiftExpression();
        while (true) {
            switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                case 101:
                case 102:
                case 108:
                case 109: {
                    switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                        case 102: {
                            jj_consume_token(102);
                            break;
                        }
                        case 101: {
                            jj_consume_token(101);
                            break;
                        }
                        case 108: {
                            jj_consume_token(108);
                            break;
                        }
                        case 109: {
                            jj_consume_token(109);
                            break;
                        }
                        default: {
                            BeatParser.jj_la1[95] = BeatParser.jj_gen;
                            jj_consume_token(-1);
                            throw new ParseException();
                        }
                    }
                    ShiftExpression();
                    continue;
                }
                default: {
                    BeatParser.jj_la1[94] = BeatParser.jj_gen;
                }
            }
        }
    }
    
    public static final void ShiftExpression() throws ParseException {
        AdditiveExpression();
        while (true) {
            switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                case 123:
                case 124:
                case 125: {
                    switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                        case 123: {
                            jj_consume_token(123);
                            break;
                        }
                        case 124: {
                            jj_consume_token(124);
                            break;
                        }
                        case 125: {
                            jj_consume_token(125);
                            break;
                        }
                        default: {
                            BeatParser.jj_la1[97] = BeatParser.jj_gen;
                            jj_consume_token(-1);
                            throw new ParseException();
                        }
                    }
                    AdditiveExpression();
                    continue;
                }
                default: {
                    BeatParser.jj_la1[96] = BeatParser.jj_gen;
                }
            }
        }
    }
    
    public static final void AdditiveExpression() throws ParseException {
        MultiplicativeExpression();
        while (true) {
            switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                case 115:
                case 116: {
                    switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                        case 115: {
                            jj_consume_token(115);
                            break;
                        }
                        case 116: {
                            jj_consume_token(116);
                            break;
                        }
                        default: {
                            BeatParser.jj_la1[99] = BeatParser.jj_gen;
                            jj_consume_token(-1);
                            throw new ParseException();
                        }
                    }
                    MultiplicativeExpression();
                    continue;
                }
                default: {
                    BeatParser.jj_la1[98] = BeatParser.jj_gen;
                }
            }
        }
    }
    
    public static final void MultiplicativeExpression() throws ParseException {
        UnaryExpression();
        while (true) {
            switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                case 117:
                case 118:
                case 122: {
                    switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                        case 117: {
                            jj_consume_token(117);
                            break;
                        }
                        case 118: {
                            jj_consume_token(118);
                            break;
                        }
                        case 122: {
                            jj_consume_token(122);
                            break;
                        }
                        default: {
                            BeatParser.jj_la1[101] = BeatParser.jj_gen;
                            jj_consume_token(-1);
                            throw new ParseException();
                        }
                    }
                    UnaryExpression();
                    continue;
                }
                default: {
                    BeatParser.jj_la1[100] = BeatParser.jj_gen;
                }
            }
        }
    }
    
    public static final void UnaryExpression() throws ParseException {
        switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
            case 115:
            case 116: {
                switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                    case 115: {
                        jj_consume_token(115);
                        break;
                    }
                    case 116: {
                        jj_consume_token(116);
                        break;
                    }
                    default: {
                        BeatParser.jj_la1[102] = BeatParser.jj_gen;
                        jj_consume_token(-1);
                        throw new ParseException();
                    }
                }
                UnaryExpression();
                break;
            }
            case 113: {
                PreIncrementExpression();
                break;
            }
            case 114: {
                PreDecrementExpression();
                break;
            }
            case 14:
            case 16:
            case 19:
            case 25:
            case 28:
            case 31:
            case 38:
            case 40:
            case 42:
            case 43:
            case 49:
            case 51:
            case 54:
            case 58:
            case 60:
            case 79:
            case 83:
            case 85:
            case 86:
            case 87:
            case 91:
            case 103:
            case 104: {
                UnaryExpressionNotPlusMinus();
                break;
            }
            default: {
                BeatParser.jj_la1[103] = BeatParser.jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
            }
        }
    }
    
    public static final void PreIncrementExpression() throws ParseException {
        jj_consume_token(113);
        PrimaryExpression();
    }
    
    public static final void PreDecrementExpression() throws ParseException {
        jj_consume_token(114);
        PrimaryExpression();
    }
    
    public static final void UnaryExpressionNotPlusMinus() throws ParseException {
        Label_0372: {
            switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                case 103:
                case 104: {
                    switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                        case 104: {
                            jj_consume_token(104);
                            break;
                        }
                        case 103: {
                            jj_consume_token(103);
                            break;
                        }
                        default: {
                            BeatParser.jj_la1[104] = BeatParser.jj_gen;
                            jj_consume_token(-1);
                            throw new ParseException();
                        }
                    }
                    UnaryExpression();
                    break;
                }
                default: {
                    BeatParser.jj_la1[105] = BeatParser.jj_gen;
                    if (jj_2_20(Integer.MAX_VALUE)) {
                        CastExpression();
                        break;
                    }
                    switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                        case 14:
                        case 16:
                        case 19:
                        case 25:
                        case 28:
                        case 31:
                        case 38:
                        case 40:
                        case 42:
                        case 43:
                        case 49:
                        case 51:
                        case 54:
                        case 58:
                        case 60:
                        case 79:
                        case 83:
                        case 85:
                        case 86:
                        case 87:
                        case 91: {
                            PostfixExpression();
                            break Label_0372;
                        }
                        default: {
                            BeatParser.jj_la1[106] = BeatParser.jj_gen;
                            jj_consume_token(-1);
                            throw new ParseException();
                        }
                    }
                    break;
                }
            }
        }
    }
    
    public static final void CastLookahead() throws ParseException {
        if (jj_2_21(2)) {
            jj_consume_token(91);
            PrimitiveType();
        }
        else if (jj_2_22(Integer.MAX_VALUE)) {
            jj_consume_token(91);
            Name();
            jj_consume_token(95);
            jj_consume_token(96);
        }
        else {
            switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                case 91: {
                    jj_consume_token(91);
                    Name();
                    jj_consume_token(92);
                    switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                        case 104: {
                            jj_consume_token(104);
                            break;
                        }
                        case 103: {
                            jj_consume_token(103);
                            break;
                        }
                        case 91: {
                            jj_consume_token(91);
                            break;
                        }
                        case 87: {
                            jj_consume_token(87);
                            break;
                        }
                        case 54: {
                            jj_consume_token(54);
                            break;
                        }
                        case 51: {
                            jj_consume_token(51);
                            break;
                        }
                        case 42: {
                            jj_consume_token(42);
                            break;
                        }
                        case 28:
                        case 43:
                        case 58:
                        case 79:
                        case 83:
                        case 85:
                        case 86: {
                            Literal();
                            break;
                        }
                        default: {
                            BeatParser.jj_la1[107] = BeatParser.jj_gen;
                            jj_consume_token(-1);
                            throw new ParseException();
                        }
                    }
                    break;
                }
                default: {
                    BeatParser.jj_la1[108] = BeatParser.jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
                }
            }
        }
    }
    
    public static final void PostfixExpression() throws ParseException {
        PrimaryExpression();
        switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
            case 113:
            case 114: {
                switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                    case 113: {
                        jj_consume_token(113);
                        break;
                    }
                    case 114: {
                        jj_consume_token(114);
                        break;
                    }
                    default: {
                        BeatParser.jj_la1[109] = BeatParser.jj_gen;
                        jj_consume_token(-1);
                        throw new ParseException();
                    }
                }
                break;
            }
            default: {
                BeatParser.jj_la1[110] = BeatParser.jj_gen;
                break;
            }
        }
    }
    
    public static final void CastExpression() throws ParseException {
        if (jj_2_23(Integer.MAX_VALUE)) {
            jj_consume_token(91);
            Type();
            jj_consume_token(92);
            UnaryExpression();
        }
        else {
            switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                case 91: {
                    jj_consume_token(91);
                    Type();
                    jj_consume_token(92);
                    UnaryExpressionNotPlusMinus();
                    break;
                }
                default: {
                    BeatParser.jj_la1[111] = BeatParser.jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
                }
            }
        }
    }
    
    public static final void PrimaryExpression() throws ParseException {
        PrimaryPrefix();
        while (jj_2_24(2)) {
            PrimarySuffix();
        }
    }
    
    public static final void PrimaryPrefix() throws ParseException {
        Label_0277: {
            switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                case 28:
                case 43:
                case 58:
                case 79:
                case 83:
                case 85:
                case 86: {
                    Literal();
                    break;
                }
                case 54: {
                    jj_consume_token(54);
                    break;
                }
                case 51: {
                    jj_consume_token(51);
                    jj_consume_token(99);
                    jj_consume_token(87);
                    break;
                }
                case 91: {
                    jj_consume_token(91);
                    Expression();
                    jj_consume_token(92);
                    break;
                }
                case 42: {
                    AllocationExpression();
                    break;
                }
                default: {
                    BeatParser.jj_la1[112] = BeatParser.jj_gen;
                    if (jj_2_25(Integer.MAX_VALUE)) {
                        ResultType();
                        jj_consume_token(99);
                        jj_consume_token(20);
                        break;
                    }
                    switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                        case 87: {
                            Name();
                            break Label_0277;
                        }
                        default: {
                            BeatParser.jj_la1[113] = BeatParser.jj_gen;
                            jj_consume_token(-1);
                            throw new ParseException();
                        }
                    }
                    break;
                }
            }
        }
    }
    
    public static final void PrimarySuffix() throws ParseException {
        if (jj_2_26(2)) {
            jj_consume_token(99);
            jj_consume_token(54);
        }
        else if (jj_2_27(2)) {
            jj_consume_token(99);
            AllocationExpression();
        }
        else {
            switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                case 95: {
                    jj_consume_token(95);
                    Expression();
                    jj_consume_token(96);
                    break;
                }
                case 99: {
                    jj_consume_token(99);
                    jj_consume_token(87);
                    break;
                }
                case 91: {
                    Arguments();
                    break;
                }
                default: {
                    BeatParser.jj_la1[114] = BeatParser.jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
                }
            }
        }
    }
    
    public static final void Literal() throws ParseException {
        switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
            case 79: {
                jj_consume_token(79);
                break;
            }
            case 83: {
                jj_consume_token(83);
                break;
            }
            case 85: {
                jj_consume_token(85);
                break;
            }
            case 86: {
                jj_consume_token(86);
                break;
            }
            case 28:
            case 58: {
                BooleanLiteral();
                break;
            }
            case 43: {
                NullLiteral();
                break;
            }
            default: {
                BeatParser.jj_la1[115] = BeatParser.jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
            }
        }
    }
    
    public static final void BooleanLiteral() throws ParseException {
        switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
            case 58: {
                jj_consume_token(58);
                break;
            }
            case 28: {
                jj_consume_token(28);
                break;
            }
            default: {
                BeatParser.jj_la1[116] = BeatParser.jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
            }
        }
    }
    
    public static final void NullLiteral() throws ParseException {
        jj_consume_token(43);
    }
    
    public static final void Arguments() throws ParseException {
        jj_consume_token(91);
        switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
            case 14:
            case 16:
            case 19:
            case 25:
            case 28:
            case 31:
            case 38:
            case 40:
            case 42:
            case 43:
            case 49:
            case 51:
            case 54:
            case 58:
            case 60:
            case 79:
            case 83:
            case 85:
            case 86:
            case 87:
            case 91:
            case 103:
            case 104:
            case 113:
            case 114:
            case 115:
            case 116: {
                ArgumentList();
                break;
            }
            default: {
                BeatParser.jj_la1[117] = BeatParser.jj_gen;
                break;
            }
        }
        jj_consume_token(92);
    }
    
    public static final void ArgumentList() throws ParseException {
        Expression();
        while (true) {
            switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                case 98: {
                    jj_consume_token(98);
                    Expression();
                    continue;
                }
                default: {
                    BeatParser.jj_la1[118] = BeatParser.jj_gen;
                }
            }
        }
    }
    
    public static final void AllocationExpression() throws ParseException {
        if (jj_2_28(2)) {
            jj_consume_token(42);
            PrimitiveType();
            ArrayDimsAndInits();
        }
        else {
            switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                case 42: {
                    jj_consume_token(42);
                    Name();
                    switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                        case 95: {
                            ArrayDimsAndInits();
                            break;
                        }
                        case 91: {
                            Arguments();
                            switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                                case 93: {
                                    ClassBody();
                                    break;
                                }
                                default: {
                                    BeatParser.jj_la1[119] = BeatParser.jj_gen;
                                    break;
                                }
                            }
                            break;
                        }
                        default: {
                            BeatParser.jj_la1[120] = BeatParser.jj_gen;
                            jj_consume_token(-1);
                            throw new ParseException();
                        }
                    }
                    break;
                }
                default: {
                    BeatParser.jj_la1[121] = BeatParser.jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
                }
            }
        }
    }
    
    public static final void ArrayDimsAndInits() throws ParseException {
        Label_0190: {
            if (jj_2_31(2)) {
                do {
                    jj_consume_token(95);
                    Expression();
                    jj_consume_token(96);
                } while (jj_2_29(2));
                while (jj_2_30(2)) {
                    jj_consume_token(95);
                    jj_consume_token(96);
                }
            }
            else {
                switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                    case 95: {
                        while (true) {
                            jj_consume_token(95);
                            jj_consume_token(96);
                            switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                                case 95: {
                                    continue;
                                }
                                default: {
                                    BeatParser.jj_la1[122] = BeatParser.jj_gen;
                                    ArrayInitializer();
                                    break Label_0190;
                                }
                            }
                        }
                        break;
                    }
                    default: {
                        BeatParser.jj_la1[123] = BeatParser.jj_gen;
                        jj_consume_token(-1);
                        throw new ParseException();
                    }
                }
            }
        }
    }
    
    public static final void Statement() throws ParseException {
        final ASTJavaStatement astJavaStatement = new ASTJavaStatement(24);
        int n = 1;
        BeatParser.jjtree.openNodeScope(astJavaStatement);
        jjtreeOpenNodeScope(astJavaStatement);
        try {
            if (jj_2_32(2)) {
                LabeledStatement();
            }
            else {
                switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                    case 93: {
                        Block();
                        break;
                    }
                    case 97: {
                        EmptyStatement();
                        break;
                    }
                    case 14:
                    case 16:
                    case 19:
                    case 25:
                    case 28:
                    case 31:
                    case 38:
                    case 40:
                    case 42:
                    case 43:
                    case 49:
                    case 51:
                    case 54:
                    case 58:
                    case 60:
                    case 79:
                    case 83:
                    case 85:
                    case 86:
                    case 87:
                    case 91:
                    case 113:
                    case 114: {
                        StatementExpression();
                        jj_consume_token(97);
                        break;
                    }
                    case 52: {
                        SwitchStatement();
                        break;
                    }
                    case 34: {
                        IfStatement();
                        break;
                    }
                    case 62: {
                        WhileStatement();
                        break;
                    }
                    case 24: {
                        DoStatement();
                        break;
                    }
                    case 32: {
                        ForStatement();
                        break;
                    }
                    case 15: {
                        BreakStatement();
                        break;
                    }
                    case 22: {
                        ContinueStatement();
                        break;
                    }
                    case 48: {
                        ReturnStatement();
                        break;
                    }
                    case 55: {
                        ThrowStatement();
                        break;
                    }
                    case 53: {
                        SynchronizedStatement();
                        break;
                    }
                    case 59: {
                        TryStatement();
                        break;
                    }
                    default: {
                        BeatParser.jj_la1[124] = BeatParser.jj_gen;
                        jj_consume_token(-1);
                        throw new ParseException();
                    }
                }
            }
        }
        catch (Throwable t) {
            if (n != 0) {
                BeatParser.jjtree.clearNodeScope(astJavaStatement);
                n = 0;
            }
            else {
                BeatParser.jjtree.popNode();
            }
            if (t instanceof RuntimeException) {
                throw (RuntimeException)t;
            }
            if (t instanceof ParseException) {
                throw (ParseException)t;
            }
            throw (Error)t;
        }
        finally {
            if (n != 0) {
                BeatParser.jjtree.closeNodeScope(astJavaStatement, true);
                jjtreeCloseNodeScope(astJavaStatement);
            }
        }
        if (n != 0) {
            BeatParser.jjtree.closeNodeScope(astJavaStatement, true);
            jjtreeCloseNodeScope(astJavaStatement);
        }
    }
    
    public static final void LabeledStatement() throws ParseException {
        jj_consume_token(87);
        jj_consume_token(106);
        Statement();
    }
    
    public static final void Block() throws ParseException {
        jj_consume_token(93);
        while (true) {
            switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                case 14:
                case 15:
                case 16:
                case 19:
                case 22:
                case 24:
                case 25:
                case 28:
                case 31:
                case 32:
                case 34:
                case 38:
                case 40:
                case 42:
                case 43:
                case 48:
                case 49:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 58:
                case 59:
                case 60:
                case 62:
                case 79:
                case 83:
                case 85:
                case 86:
                case 87:
                case 91:
                case 93:
                case 97:
                case 113:
                case 114: {
                    Statement();
                    continue;
                }
                default: {
                    BeatParser.jj_la1[125] = BeatParser.jj_gen;
                    jj_consume_token(94);
                }
            }
        }
    }
    
    public static final void BlockStatement() throws ParseException {
        if (jj_2_33(Integer.MAX_VALUE)) {
            LocalVariableDeclaration();
            jj_consume_token(97);
        }
        else {
            switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                case 14:
                case 15:
                case 16:
                case 19:
                case 22:
                case 24:
                case 25:
                case 28:
                case 31:
                case 32:
                case 34:
                case 38:
                case 40:
                case 42:
                case 43:
                case 48:
                case 49:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 58:
                case 59:
                case 60:
                case 62:
                case 79:
                case 83:
                case 85:
                case 86:
                case 87:
                case 91:
                case 93:
                case 97:
                case 113:
                case 114: {
                    Statement();
                    break;
                }
                case 20: {
                    UnmodifiedClassDeclaration();
                    break;
                }
                case 39: {
                    UnmodifiedInterfaceDeclaration();
                    break;
                }
                default: {
                    BeatParser.jj_la1[126] = BeatParser.jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
                }
            }
        }
    }
    
    public static final void LocalVariableDeclaration() throws ParseException {
        switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
            case 29: {
                jj_consume_token(29);
                break;
            }
            default: {
                BeatParser.jj_la1[127] = BeatParser.jj_gen;
                break;
            }
        }
        Type();
        VariableDeclarator();
        while (true) {
            switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                case 98: {
                    jj_consume_token(98);
                    VariableDeclarator();
                    continue;
                }
                default: {
                    BeatParser.jj_la1[128] = BeatParser.jj_gen;
                }
            }
        }
    }
    
    public static final void EmptyStatement() throws ParseException {
        jj_consume_token(97);
    }
    
    public static final void StatementExpression() throws ParseException {
        switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
            case 113: {
                PreIncrementExpression();
                break;
            }
            case 114: {
                PreDecrementExpression();
                break;
            }
            case 14:
            case 16:
            case 19:
            case 25:
            case 28:
            case 31:
            case 38:
            case 40:
            case 42:
            case 43:
            case 49:
            case 51:
            case 54:
            case 58:
            case 60:
            case 79:
            case 83:
            case 85:
            case 86:
            case 87:
            case 91: {
                PrimaryExpression();
                switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                    case 100:
                    case 113:
                    case 114:
                    case 126:
                    case 127:
                    case 128:
                    case 129:
                    case 130:
                    case 131:
                    case 132:
                    case 133:
                    case 134:
                    case 135:
                    case 136: {
                        switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                            case 113: {
                                jj_consume_token(113);
                                break;
                            }
                            case 114: {
                                jj_consume_token(114);
                                break;
                            }
                            case 100:
                            case 126:
                            case 127:
                            case 128:
                            case 129:
                            case 130:
                            case 131:
                            case 132:
                            case 133:
                            case 134:
                            case 135:
                            case 136: {
                                AssignmentOperator();
                                Expression();
                                break;
                            }
                            default: {
                                BeatParser.jj_la1[129] = BeatParser.jj_gen;
                                jj_consume_token(-1);
                                throw new ParseException();
                            }
                        }
                        break;
                    }
                    default: {
                        BeatParser.jj_la1[130] = BeatParser.jj_gen;
                        break;
                    }
                }
                break;
            }
            default: {
                BeatParser.jj_la1[131] = BeatParser.jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
            }
        }
    }
    
    public static final void SwitchStatement() throws ParseException {
        jj_consume_token(52);
        jj_consume_token(91);
        Expression();
        jj_consume_token(92);
        jj_consume_token(93);
    Label_0027:
        while (true) {
            while (true) {
                switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                    case 17:
                    case 23: {
                        SwitchLabel();
                        while (true) {
                            switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                                case 14:
                                case 15:
                                case 16:
                                case 19:
                                case 20:
                                case 22:
                                case 24:
                                case 25:
                                case 28:
                                case 29:
                                case 31:
                                case 32:
                                case 34:
                                case 38:
                                case 39:
                                case 40:
                                case 42:
                                case 43:
                                case 48:
                                case 49:
                                case 51:
                                case 52:
                                case 53:
                                case 54:
                                case 55:
                                case 58:
                                case 59:
                                case 60:
                                case 62:
                                case 79:
                                case 83:
                                case 85:
                                case 86:
                                case 87:
                                case 91:
                                case 93:
                                case 97:
                                case 113:
                                case 114: {
                                    BlockStatement();
                                    continue;
                                }
                                default: {
                                    BeatParser.jj_la1[133] = BeatParser.jj_gen;
                                    continue Label_0027;
                                }
                            }
                        }
                        break;
                    }
                    default: {
                        BeatParser.jj_la1[132] = BeatParser.jj_gen;
                        jj_consume_token(94);
                    }
                }
            }
            break;
        }
    }
    
    public static final void SwitchLabel() throws ParseException {
        switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
            case 17: {
                jj_consume_token(17);
                Expression();
                jj_consume_token(106);
                break;
            }
            case 23: {
                jj_consume_token(23);
                jj_consume_token(106);
                break;
            }
            default: {
                BeatParser.jj_la1[134] = BeatParser.jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
            }
        }
    }
    
    public static final void IfStatement() throws ParseException {
        jj_consume_token(34);
        jj_consume_token(91);
        Expression();
        jj_consume_token(92);
        Statement();
        switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
            case 26: {
                jj_consume_token(26);
                Statement();
                break;
            }
            default: {
                BeatParser.jj_la1[135] = BeatParser.jj_gen;
                break;
            }
        }
    }
    
    public static final void WhileStatement() throws ParseException {
        jj_consume_token(62);
        jj_consume_token(91);
        Expression();
        jj_consume_token(92);
        Statement();
    }
    
    public static final void DoStatement() throws ParseException {
        jj_consume_token(24);
        Statement();
        jj_consume_token(62);
        jj_consume_token(91);
        Expression();
        jj_consume_token(92);
        jj_consume_token(97);
    }
    
    public static final void ForStatement() throws ParseException {
        jj_consume_token(32);
        jj_consume_token(91);
        switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
            case 14:
            case 16:
            case 19:
            case 25:
            case 28:
            case 29:
            case 31:
            case 38:
            case 40:
            case 42:
            case 43:
            case 49:
            case 51:
            case 54:
            case 58:
            case 60:
            case 79:
            case 83:
            case 85:
            case 86:
            case 87:
            case 91:
            case 113:
            case 114: {
                ForInit();
                break;
            }
            default: {
                BeatParser.jj_la1[136] = BeatParser.jj_gen;
                break;
            }
        }
        jj_consume_token(97);
        switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
            case 14:
            case 16:
            case 19:
            case 25:
            case 28:
            case 31:
            case 38:
            case 40:
            case 42:
            case 43:
            case 49:
            case 51:
            case 54:
            case 58:
            case 60:
            case 79:
            case 83:
            case 85:
            case 86:
            case 87:
            case 91:
            case 103:
            case 104:
            case 113:
            case 114:
            case 115:
            case 116: {
                Expression();
                break;
            }
            default: {
                BeatParser.jj_la1[137] = BeatParser.jj_gen;
                break;
            }
        }
        jj_consume_token(97);
        switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
            case 14:
            case 16:
            case 19:
            case 25:
            case 28:
            case 31:
            case 38:
            case 40:
            case 42:
            case 43:
            case 49:
            case 51:
            case 54:
            case 58:
            case 60:
            case 79:
            case 83:
            case 85:
            case 86:
            case 87:
            case 91:
            case 113:
            case 114: {
                ForUpdate();
                break;
            }
            default: {
                BeatParser.jj_la1[138] = BeatParser.jj_gen;
                break;
            }
        }
        jj_consume_token(92);
        Statement();
    }
    
    public static final void ForInit() throws ParseException {
        if (jj_2_34(Integer.MAX_VALUE)) {
            LocalVariableDeclaration();
        }
        else {
            switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                case 14:
                case 16:
                case 19:
                case 25:
                case 28:
                case 31:
                case 38:
                case 40:
                case 42:
                case 43:
                case 49:
                case 51:
                case 54:
                case 58:
                case 60:
                case 79:
                case 83:
                case 85:
                case 86:
                case 87:
                case 91:
                case 113:
                case 114: {
                    StatementExpressionList();
                    break;
                }
                default: {
                    BeatParser.jj_la1[139] = BeatParser.jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
                }
            }
        }
    }
    
    public static final void StatementExpressionList() throws ParseException {
        StatementExpression();
        while (true) {
            switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                case 98: {
                    jj_consume_token(98);
                    StatementExpression();
                    continue;
                }
                default: {
                    BeatParser.jj_la1[140] = BeatParser.jj_gen;
                }
            }
        }
    }
    
    public static final void ForUpdate() throws ParseException {
        StatementExpressionList();
    }
    
    public static final void BreakStatement() throws ParseException {
        jj_consume_token(15);
        switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
            case 87: {
                jj_consume_token(87);
                break;
            }
            default: {
                BeatParser.jj_la1[141] = BeatParser.jj_gen;
                break;
            }
        }
        jj_consume_token(97);
    }
    
    public static final void ContinueStatement() throws ParseException {
        jj_consume_token(22);
        switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
            case 87: {
                jj_consume_token(87);
                break;
            }
            default: {
                BeatParser.jj_la1[142] = BeatParser.jj_gen;
                break;
            }
        }
        jj_consume_token(97);
    }
    
    public static final void ReturnStatement() throws ParseException {
        jj_consume_token(48);
        switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
            case 14:
            case 16:
            case 19:
            case 25:
            case 28:
            case 31:
            case 38:
            case 40:
            case 42:
            case 43:
            case 49:
            case 51:
            case 54:
            case 58:
            case 60:
            case 79:
            case 83:
            case 85:
            case 86:
            case 87:
            case 91:
            case 103:
            case 104:
            case 113:
            case 114:
            case 115:
            case 116: {
                Expression();
                break;
            }
            default: {
                BeatParser.jj_la1[143] = BeatParser.jj_gen;
                break;
            }
        }
        jj_consume_token(97);
    }
    
    public static final void ThrowStatement() throws ParseException {
        jj_consume_token(55);
        Expression();
        jj_consume_token(97);
    }
    
    public static final void SynchronizedStatement() throws ParseException {
        jj_consume_token(53);
        jj_consume_token(91);
        Expression();
        jj_consume_token(92);
        Block();
    }
    
    public static final void TryStatement() throws ParseException {
        jj_consume_token(59);
        Block();
        while (true) {
            switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                case 18: {
                    jj_consume_token(18);
                    jj_consume_token(91);
                    FormalParameter();
                    jj_consume_token(92);
                    Block();
                    continue;
                }
                default: {
                    BeatParser.jj_la1[144] = BeatParser.jj_gen;
                    switch ((BeatParser.jj_ntk == -1) ? jj_ntk() : BeatParser.jj_ntk) {
                        case 30: {
                            jj_consume_token(30);
                            Block();
                            break;
                        }
                        default: {
                            BeatParser.jj_la1[145] = BeatParser.jj_gen;
                            break;
                        }
                    }
                }
            }
        }
    }
    
    private static final boolean jj_2_1(final int jj_la) {
        BeatParser.jj_la = jj_la;
        BeatParser.jj_lastpos = (BeatParser.jj_scanpos = BeatParser.token);
        try {
            return jj_3_1() ^ true;
        }
        catch (LookaheadSuccess lookaheadSuccess) {
            return true;
        }
        finally {
            jj_save(0, jj_la);
        }
    }
    
    private static final boolean jj_2_2(final int jj_la) {
        BeatParser.jj_la = jj_la;
        BeatParser.jj_lastpos = (BeatParser.jj_scanpos = BeatParser.token);
        try {
            return jj_3_2() ^ true;
        }
        catch (LookaheadSuccess lookaheadSuccess) {
            return true;
        }
        finally {
            jj_save(1, jj_la);
        }
    }
    
    private static final boolean jj_2_3(final int jj_la) {
        BeatParser.jj_la = jj_la;
        BeatParser.jj_lastpos = (BeatParser.jj_scanpos = BeatParser.token);
        try {
            return jj_3_3() ^ true;
        }
        catch (LookaheadSuccess lookaheadSuccess) {
            return true;
        }
        finally {
            jj_save(2, jj_la);
        }
    }
    
    private static final boolean jj_2_4(final int jj_la) {
        BeatParser.jj_la = jj_la;
        BeatParser.jj_lastpos = (BeatParser.jj_scanpos = BeatParser.token);
        try {
            return jj_3_4() ^ true;
        }
        catch (LookaheadSuccess lookaheadSuccess) {
            return true;
        }
        finally {
            jj_save(3, jj_la);
        }
    }
    
    private static final boolean jj_2_5(final int jj_la) {
        BeatParser.jj_la = jj_la;
        BeatParser.jj_lastpos = (BeatParser.jj_scanpos = BeatParser.token);
        try {
            return jj_3_5() ^ true;
        }
        catch (LookaheadSuccess lookaheadSuccess) {
            return true;
        }
        finally {
            jj_save(4, jj_la);
        }
    }
    
    private static final boolean jj_2_6(final int jj_la) {
        BeatParser.jj_la = jj_la;
        BeatParser.jj_lastpos = (BeatParser.jj_scanpos = BeatParser.token);
        try {
            return jj_3_6() ^ true;
        }
        catch (LookaheadSuccess lookaheadSuccess) {
            return true;
        }
        finally {
            jj_save(5, jj_la);
        }
    }
    
    private static final boolean jj_2_7(final int jj_la) {
        BeatParser.jj_la = jj_la;
        BeatParser.jj_lastpos = (BeatParser.jj_scanpos = BeatParser.token);
        try {
            return jj_3_7() ^ true;
        }
        catch (LookaheadSuccess lookaheadSuccess) {
            return true;
        }
        finally {
            jj_save(6, jj_la);
        }
    }
    
    private static final boolean jj_2_8(final int jj_la) {
        BeatParser.jj_la = jj_la;
        BeatParser.jj_lastpos = (BeatParser.jj_scanpos = BeatParser.token);
        try {
            return jj_3_8() ^ true;
        }
        catch (LookaheadSuccess lookaheadSuccess) {
            return true;
        }
        finally {
            jj_save(7, jj_la);
        }
    }
    
    private static final boolean jj_2_9(final int jj_la) {
        BeatParser.jj_la = jj_la;
        BeatParser.jj_lastpos = (BeatParser.jj_scanpos = BeatParser.token);
        try {
            return jj_3_9() ^ true;
        }
        catch (LookaheadSuccess lookaheadSuccess) {
            return true;
        }
        finally {
            jj_save(8, jj_la);
        }
    }
    
    private static final boolean jj_2_10(final int jj_la) {
        BeatParser.jj_la = jj_la;
        BeatParser.jj_lastpos = (BeatParser.jj_scanpos = BeatParser.token);
        try {
            return jj_3_10() ^ true;
        }
        catch (LookaheadSuccess lookaheadSuccess) {
            return true;
        }
        finally {
            jj_save(9, jj_la);
        }
    }
    
    private static final boolean jj_2_11(final int jj_la) {
        BeatParser.jj_la = jj_la;
        BeatParser.jj_lastpos = (BeatParser.jj_scanpos = BeatParser.token);
        try {
            return jj_3_11() ^ true;
        }
        catch (LookaheadSuccess lookaheadSuccess) {
            return true;
        }
        finally {
            jj_save(10, jj_la);
        }
    }
    
    private static final boolean jj_2_12(final int jj_la) {
        BeatParser.jj_la = jj_la;
        BeatParser.jj_lastpos = (BeatParser.jj_scanpos = BeatParser.token);
        try {
            return jj_3_12() ^ true;
        }
        catch (LookaheadSuccess lookaheadSuccess) {
            return true;
        }
        finally {
            jj_save(11, jj_la);
        }
    }
    
    private static final boolean jj_2_13(final int jj_la) {
        BeatParser.jj_la = jj_la;
        BeatParser.jj_lastpos = (BeatParser.jj_scanpos = BeatParser.token);
        try {
            return jj_3_13() ^ true;
        }
        catch (LookaheadSuccess lookaheadSuccess) {
            return true;
        }
        finally {
            jj_save(12, jj_la);
        }
    }
    
    private static final boolean jj_2_14(final int jj_la) {
        BeatParser.jj_la = jj_la;
        BeatParser.jj_lastpos = (BeatParser.jj_scanpos = BeatParser.token);
        try {
            return jj_3_14() ^ true;
        }
        catch (LookaheadSuccess lookaheadSuccess) {
            return true;
        }
        finally {
            jj_save(13, jj_la);
        }
    }
    
    private static final boolean jj_2_15(final int jj_la) {
        BeatParser.jj_la = jj_la;
        BeatParser.jj_lastpos = (BeatParser.jj_scanpos = BeatParser.token);
        try {
            return jj_3_15() ^ true;
        }
        catch (LookaheadSuccess lookaheadSuccess) {
            return true;
        }
        finally {
            jj_save(14, jj_la);
        }
    }
    
    private static final boolean jj_2_16(final int jj_la) {
        BeatParser.jj_la = jj_la;
        BeatParser.jj_lastpos = (BeatParser.jj_scanpos = BeatParser.token);
        try {
            return jj_3_16() ^ true;
        }
        catch (LookaheadSuccess lookaheadSuccess) {
            return true;
        }
        finally {
            jj_save(15, jj_la);
        }
    }
    
    private static final boolean jj_2_17(final int jj_la) {
        BeatParser.jj_la = jj_la;
        BeatParser.jj_lastpos = (BeatParser.jj_scanpos = BeatParser.token);
        try {
            return jj_3_17() ^ true;
        }
        catch (LookaheadSuccess lookaheadSuccess) {
            return true;
        }
        finally {
            jj_save(16, jj_la);
        }
    }
    
    private static final boolean jj_2_18(final int jj_la) {
        BeatParser.jj_la = jj_la;
        BeatParser.jj_lastpos = (BeatParser.jj_scanpos = BeatParser.token);
        try {
            return jj_3_18() ^ true;
        }
        catch (LookaheadSuccess lookaheadSuccess) {
            return true;
        }
        finally {
            jj_save(17, jj_la);
        }
    }
    
    private static final boolean jj_2_19(final int jj_la) {
        BeatParser.jj_la = jj_la;
        BeatParser.jj_lastpos = (BeatParser.jj_scanpos = BeatParser.token);
        try {
            return jj_3_19() ^ true;
        }
        catch (LookaheadSuccess lookaheadSuccess) {
            return true;
        }
        finally {
            jj_save(18, jj_la);
        }
    }
    
    private static final boolean jj_2_20(final int jj_la) {
        BeatParser.jj_la = jj_la;
        BeatParser.jj_lastpos = (BeatParser.jj_scanpos = BeatParser.token);
        try {
            return jj_3_20() ^ true;
        }
        catch (LookaheadSuccess lookaheadSuccess) {
            return true;
        }
        finally {
            jj_save(19, jj_la);
        }
    }
    
    private static final boolean jj_2_21(final int jj_la) {
        BeatParser.jj_la = jj_la;
        BeatParser.jj_lastpos = (BeatParser.jj_scanpos = BeatParser.token);
        try {
            return jj_3_21() ^ true;
        }
        catch (LookaheadSuccess lookaheadSuccess) {
            return true;
        }
        finally {
            jj_save(20, jj_la);
        }
    }
    
    private static final boolean jj_2_22(final int jj_la) {
        BeatParser.jj_la = jj_la;
        BeatParser.jj_lastpos = (BeatParser.jj_scanpos = BeatParser.token);
        try {
            return jj_3_22() ^ true;
        }
        catch (LookaheadSuccess lookaheadSuccess) {
            return true;
        }
        finally {
            jj_save(21, jj_la);
        }
    }
    
    private static final boolean jj_2_23(final int jj_la) {
        BeatParser.jj_la = jj_la;
        BeatParser.jj_lastpos = (BeatParser.jj_scanpos = BeatParser.token);
        try {
            return jj_3_23() ^ true;
        }
        catch (LookaheadSuccess lookaheadSuccess) {
            return true;
        }
        finally {
            jj_save(22, jj_la);
        }
    }
    
    private static final boolean jj_2_24(final int jj_la) {
        BeatParser.jj_la = jj_la;
        BeatParser.jj_lastpos = (BeatParser.jj_scanpos = BeatParser.token);
        try {
            return jj_3_24() ^ true;
        }
        catch (LookaheadSuccess lookaheadSuccess) {
            return true;
        }
        finally {
            jj_save(23, jj_la);
        }
    }
    
    private static final boolean jj_2_25(final int jj_la) {
        BeatParser.jj_la = jj_la;
        BeatParser.jj_lastpos = (BeatParser.jj_scanpos = BeatParser.token);
        try {
            return jj_3_25() ^ true;
        }
        catch (LookaheadSuccess lookaheadSuccess) {
            return true;
        }
        finally {
            jj_save(24, jj_la);
        }
    }
    
    private static final boolean jj_2_26(final int jj_la) {
        BeatParser.jj_la = jj_la;
        BeatParser.jj_lastpos = (BeatParser.jj_scanpos = BeatParser.token);
        try {
            return jj_3_26() ^ true;
        }
        catch (LookaheadSuccess lookaheadSuccess) {
            return true;
        }
        finally {
            jj_save(25, jj_la);
        }
    }
    
    private static final boolean jj_2_27(final int jj_la) {
        BeatParser.jj_la = jj_la;
        BeatParser.jj_lastpos = (BeatParser.jj_scanpos = BeatParser.token);
        try {
            return jj_3_27() ^ true;
        }
        catch (LookaheadSuccess lookaheadSuccess) {
            return true;
        }
        finally {
            jj_save(26, jj_la);
        }
    }
    
    private static final boolean jj_2_28(final int jj_la) {
        BeatParser.jj_la = jj_la;
        BeatParser.jj_lastpos = (BeatParser.jj_scanpos = BeatParser.token);
        try {
            return jj_3_28() ^ true;
        }
        catch (LookaheadSuccess lookaheadSuccess) {
            return true;
        }
        finally {
            jj_save(27, jj_la);
        }
    }
    
    private static final boolean jj_2_29(final int jj_la) {
        BeatParser.jj_la = jj_la;
        BeatParser.jj_lastpos = (BeatParser.jj_scanpos = BeatParser.token);
        try {
            return jj_3_29() ^ true;
        }
        catch (LookaheadSuccess lookaheadSuccess) {
            return true;
        }
        finally {
            jj_save(28, jj_la);
        }
    }
    
    private static final boolean jj_2_30(final int jj_la) {
        BeatParser.jj_la = jj_la;
        BeatParser.jj_lastpos = (BeatParser.jj_scanpos = BeatParser.token);
        try {
            return jj_3_30() ^ true;
        }
        catch (LookaheadSuccess lookaheadSuccess) {
            return true;
        }
        finally {
            jj_save(29, jj_la);
        }
    }
    
    private static final boolean jj_2_31(final int jj_la) {
        BeatParser.jj_la = jj_la;
        BeatParser.jj_lastpos = (BeatParser.jj_scanpos = BeatParser.token);
        try {
            return jj_3_31() ^ true;
        }
        catch (LookaheadSuccess lookaheadSuccess) {
            return true;
        }
        finally {
            jj_save(30, jj_la);
        }
    }
    
    private static final boolean jj_2_32(final int jj_la) {
        BeatParser.jj_la = jj_la;
        BeatParser.jj_lastpos = (BeatParser.jj_scanpos = BeatParser.token);
        try {
            return jj_3_32() ^ true;
        }
        catch (LookaheadSuccess lookaheadSuccess) {
            return true;
        }
        finally {
            jj_save(31, jj_la);
        }
    }
    
    private static final boolean jj_2_33(final int jj_la) {
        BeatParser.jj_la = jj_la;
        BeatParser.jj_lastpos = (BeatParser.jj_scanpos = BeatParser.token);
        try {
            return jj_3_33() ^ true;
        }
        catch (LookaheadSuccess lookaheadSuccess) {
            return true;
        }
        finally {
            jj_save(32, jj_la);
        }
    }
    
    private static final boolean jj_2_34(final int jj_la) {
        BeatParser.jj_la = jj_la;
        BeatParser.jj_lastpos = (BeatParser.jj_scanpos = BeatParser.token);
        try {
            return jj_3_34() ^ true;
        }
        catch (LookaheadSuccess lookaheadSuccess) {
            return true;
        }
        finally {
            jj_save(33, jj_la);
        }
    }
    
    private static final boolean jj_3R_266() {
        return jj_scan_token(30) || jj_3R_85();
    }
    
    private static final boolean jj_3R_265() {
        return jj_scan_token(18) || jj_scan_token(91) || jj_3R_241() || jj_scan_token(92) || jj_3R_85();
    }
    
    private static final boolean jj_3R_125() {
        return jj_scan_token(91) || jj_3R_100() || jj_scan_token(92);
    }
    
    private static final boolean jj_3R_157() {
        if (jj_scan_token(59)) {
            return true;
        }
        if (jj_3R_85()) {
            return true;
        }
        Token jj_scanpos;
        do {
            jj_scanpos = BeatParser.jj_scanpos;
        } while (!jj_3R_265());
        BeatParser.jj_scanpos = jj_scanpos;
        final Token jj_scanpos2 = BeatParser.jj_scanpos;
        if (jj_3R_266()) {
            BeatParser.jj_scanpos = jj_scanpos2;
        }
        return false;
    }
    
    private static final boolean jj_3R_118() {
        return jj_scan_token(91) || jj_3R_100() || jj_scan_token(92);
    }
    
    private static final boolean jj_3R_162() {
        return jj_3R_158();
    }
    
    private static final boolean jj_3R_263() {
        return jj_3R_272();
    }
    
    private static final boolean jj_3R_156() {
        return jj_scan_token(53) || jj_scan_token(91) || jj_3R_75() || jj_scan_token(92) || jj_3R_85();
    }
    
    private static final boolean jj_3R_264() {
        return jj_3R_75();
    }
    
    private static final boolean jj_3R_127() {
        return jj_3R_145();
    }
    
    private static final boolean jj_3R_145() {
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_scan_token(79)) {
            BeatParser.jj_scanpos = jj_scanpos;
            if (jj_scan_token(83)) {
                BeatParser.jj_scanpos = jj_scanpos;
                if (jj_scan_token(85)) {
                    BeatParser.jj_scanpos = jj_scanpos;
                    if (jj_scan_token(86)) {
                        BeatParser.jj_scanpos = jj_scanpos;
                        if (jj_3R_162()) {
                            BeatParser.jj_scanpos = jj_scanpos;
                            if (jj_scan_token(43)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    private static final boolean jj_3R_155() {
        return jj_scan_token(55) || jj_3R_75() || jj_scan_token(97);
    }
    
    private static final boolean jj_3R_126() {
        return jj_3R_62();
    }
    
    private static final boolean jj_3R_279() {
        return jj_scan_token(98) || jj_3R_146();
    }
    
    private static final boolean jj_3R_119() {
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_3R_126()) {
            BeatParser.jj_scanpos = jj_scanpos;
            if (jj_3R_127()) {
                return true;
            }
        }
        return false;
    }
    
    private static final boolean jj_3R_154() {
        if (jj_scan_token(48)) {
            return true;
        }
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_3R_264()) {
            BeatParser.jj_scanpos = jj_scanpos;
        }
        return jj_scan_token(97);
    }
    
    private static final boolean jj_3R_153() {
        if (jj_scan_token(22)) {
            return true;
        }
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_scan_token(87)) {
            BeatParser.jj_scanpos = jj_scanpos;
        }
        return jj_scan_token(97);
    }
    
    private static final boolean jj_3R_262() {
        return jj_3R_75();
    }
    
    private static final boolean jj_3R_152() {
        if (jj_scan_token(15)) {
            return true;
        }
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_scan_token(87)) {
            BeatParser.jj_scanpos = jj_scanpos;
        }
        return jj_scan_token(97);
    }
    
    private static final boolean jj_3R_260() {
        return jj_scan_token(26) || jj_3R_120();
    }
    
    private static final boolean jj_3R_272() {
        return jj_3R_278();
    }
    
    private static final boolean jj_3_34() {
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_scan_token(29)) {
            BeatParser.jj_scanpos = jj_scanpos;
        }
        return jj_3R_54() || jj_scan_token(87);
    }
    
    private static final boolean jj_3R_104() {
        if (jj_scan_token(87)) {
            return true;
        }
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_scan_token(78)) {
            BeatParser.jj_scanpos = jj_scanpos;
            if (jj_scan_token(101)) {
                BeatParser.jj_scanpos = jj_scanpos;
                if (jj_scan_token(102)) {
                    BeatParser.jj_scanpos = jj_scanpos;
                    if (jj_scan_token(107)) {
                        BeatParser.jj_scanpos = jj_scanpos;
                        if (jj_scan_token(108)) {
                            BeatParser.jj_scanpos = jj_scanpos;
                            if (jj_scan_token(109)) {
                                BeatParser.jj_scanpos = jj_scanpos;
                                if (jj_scan_token(110)) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return jj_3R_119();
    }
    
    private static final boolean jj_3R_278() {
        if (jj_3R_146()) {
            return true;
        }
        Token jj_scanpos;
        do {
            jj_scanpos = BeatParser.jj_scanpos;
        } while (!jj_3R_279());
        BeatParser.jj_scanpos = jj_scanpos;
        return false;
    }
    
    private static final boolean jj_3R_261() {
        return jj_3R_271();
    }
    
    private static final boolean jj_3R_277() {
        return jj_3R_278();
    }
    
    private static final boolean jj_3R_276() {
        return jj_3R_255();
    }
    
    private static final boolean jj_3R_271() {
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_3R_276()) {
            BeatParser.jj_scanpos = jj_scanpos;
            if (jj_3R_277()) {
                return true;
            }
        }
        return false;
    }
    
    private static final boolean jj_3R_83() {
        return jj_3R_103();
    }
    
    private static final boolean jj_3R_84() {
        return jj_3R_104();
    }
    
    private static final boolean jj_3R_151() {
        if (jj_scan_token(32)) {
            return true;
        }
        if (jj_scan_token(91)) {
            return true;
        }
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_3R_261()) {
            BeatParser.jj_scanpos = jj_scanpos;
        }
        if (jj_scan_token(97)) {
            return true;
        }
        final Token jj_scanpos2 = BeatParser.jj_scanpos;
        if (jj_3R_262()) {
            BeatParser.jj_scanpos = jj_scanpos2;
        }
        if (jj_scan_token(97)) {
            return true;
        }
        final Token jj_scanpos3 = BeatParser.jj_scanpos;
        if (jj_3R_263()) {
            BeatParser.jj_scanpos = jj_scanpos3;
        }
        return jj_scan_token(92) || jj_3R_120();
    }
    
    private static final boolean jj_3R_82() {
        return jj_3R_62() || jj_scan_token(100);
    }
    
    private static final boolean jj_3_4() {
        return jj_3R_56();
    }
    
    private static final boolean jj_3_5() {
        return jj_3R_56();
    }
    
    private static final boolean jj_3R_81() {
        return jj_scan_token(103);
    }
    
    private static final boolean jj_3R_56() {
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_3R_81()) {
            BeatParser.jj_scanpos = jj_scanpos;
        }
        final Token jj_scanpos2 = BeatParser.jj_scanpos;
        if (jj_3R_82()) {
            BeatParser.jj_scanpos = jj_scanpos2;
        }
        if (jj_scan_token(91)) {
            return true;
        }
        if (jj_3R_83()) {
            return true;
        }
        Token jj_scanpos3;
        do {
            jj_scanpos3 = BeatParser.jj_scanpos;
        } while (!jj_3R_84());
        BeatParser.jj_scanpos = jj_scanpos3;
        return jj_scan_token(92);
    }
    
    private static final boolean jj_3R_150() {
        return jj_scan_token(24) || jj_3R_120() || jj_scan_token(62) || jj_scan_token(91) || jj_3R_75() || jj_scan_token(92) || jj_scan_token(97);
    }
    
    private static final boolean jj_3R_124() {
        return jj_3R_56();
    }
    
    private static final boolean jj_3R_116() {
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_3R_124()) {
            BeatParser.jj_scanpos = jj_scanpos;
            if (jj_3R_125()) {
                return true;
            }
        }
        return false;
    }
    
    private static final boolean jj_3R_149() {
        return jj_scan_token(62) || jj_scan_token(91) || jj_3R_75() || jj_scan_token(92) || jj_3R_120();
    }
    
    private static final boolean jj_3R_117() {
        return jj_3R_56();
    }
    
    private static final boolean jj_3R_102() {
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_3R_117()) {
            BeatParser.jj_scanpos = jj_scanpos;
            if (jj_3R_118()) {
                return true;
            }
        }
        return false;
    }
    
    private static final boolean jj_3R_270() {
        return jj_3R_233();
    }
    
    private static final boolean jj_3R_148() {
        if (jj_scan_token(34)) {
            return true;
        }
        if (jj_scan_token(91)) {
            return true;
        }
        if (jj_3R_75()) {
            return true;
        }
        if (jj_scan_token(92)) {
            return true;
        }
        if (jj_3R_120()) {
            return true;
        }
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_3R_260()) {
            BeatParser.jj_scanpos = jj_scanpos;
        }
        return false;
    }
    
    private static final boolean jj_3R_101() {
        if (jj_scan_token(93)) {
            return true;
        }
        if (jj_scan_token(87)) {
            return true;
        }
        if (jj_3R_116()) {
            return true;
        }
        Token jj_scanpos;
        do {
            jj_scanpos = BeatParser.jj_scanpos;
        } while (!jj_3R_116());
        BeatParser.jj_scanpos = jj_scanpos;
        return jj_scan_token(94);
    }
    
    private static final boolean jj_3R_80() {
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_3R_101()) {
            BeatParser.jj_scanpos = jj_scanpos;
            if (jj_3R_102()) {
                return true;
            }
        }
        return false;
    }
    
    private static final boolean jj_3_3() {
        return jj_3R_55();
    }
    
    private static final boolean jj_3R_275() {
        return jj_scan_token(23) || jj_scan_token(106);
    }
    
    private static final boolean jj_3R_274() {
        return jj_scan_token(17) || jj_3R_75() || jj_scan_token(106);
    }
    
    private static final boolean jj_3R_269() {
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_3R_274()) {
            BeatParser.jj_scanpos = jj_scanpos;
            if (jj_3R_275()) {
                return true;
            }
        }
        return false;
    }
    
    private static final boolean jj_3R_55() {
        return jj_scan_token(87) || jj_3R_80();
    }
    
    private static final boolean jj_3R_258() {
        return jj_scan_token(98) || jj_3R_223();
    }
    
    private static final boolean jj_3R_259() {
        if (jj_3R_269()) {
            return true;
        }
        Token jj_scanpos;
        do {
            jj_scanpos = BeatParser.jj_scanpos;
        } while (!jj_3R_270());
        BeatParser.jj_scanpos = jj_scanpos;
        return false;
    }
    
    private static final boolean jj_3R_147() {
        if (jj_scan_token(52)) {
            return true;
        }
        if (jj_scan_token(91)) {
            return true;
        }
        if (jj_3R_75()) {
            return true;
        }
        if (jj_scan_token(92)) {
            return true;
        }
        if (jj_scan_token(93)) {
            return true;
        }
        Token jj_scanpos;
        do {
            jj_scanpos = BeatParser.jj_scanpos;
        } while (!jj_3R_259());
        BeatParser.jj_scanpos = jj_scanpos;
        return jj_scan_token(94);
    }
    
    private static final boolean jj_3R_273() {
        return jj_3R_159() || jj_3R_75();
    }
    
    private static final boolean jj_3R_268() {
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_scan_token(113)) {
            BeatParser.jj_scanpos = jj_scanpos;
            if (jj_scan_token(114)) {
                BeatParser.jj_scanpos = jj_scanpos;
                if (jj_3R_273()) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private static final boolean jj_3R_103() {
        return jj_scan_token(87);
    }
    
    private static final boolean jj_3R_165() {
        if (jj_3R_68()) {
            return true;
        }
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_3R_268()) {
            BeatParser.jj_scanpos = jj_scanpos;
        }
        return false;
    }
    
    private static final boolean jj_3_1() {
        return jj_3R_54() || jj_scan_token(87);
    }
    
    private static final boolean jj_3R_164() {
        return jj_3R_169();
    }
    
    private static final boolean jj_3R_146() {
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_3R_163()) {
            BeatParser.jj_scanpos = jj_scanpos;
            if (jj_3R_164()) {
                BeatParser.jj_scanpos = jj_scanpos;
                if (jj_3R_165()) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private static final boolean jj_3R_163() {
        return jj_3R_168();
    }
    
    private static final boolean jj_3_2() {
        return jj_scan_token(87) || jj_scan_token(137);
    }
    
    private static final boolean jj_3R_255() {
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_scan_token(29)) {
            BeatParser.jj_scanpos = jj_scanpos;
        }
        if (jj_3R_54()) {
            return true;
        }
        if (jj_3R_223()) {
            return true;
        }
        Token jj_scanpos2;
        do {
            jj_scanpos2 = BeatParser.jj_scanpos;
        } while (!jj_3R_258());
        BeatParser.jj_scanpos = jj_scanpos2;
        return false;
    }
    
    private static final boolean jj_3_33() {
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_scan_token(29)) {
            BeatParser.jj_scanpos = jj_scanpos;
        }
        return jj_3R_54() || jj_scan_token(87);
    }
    
    private static final boolean jj_3R_247() {
        return jj_3R_212();
    }
    
    private static final boolean jj_3R_246() {
        return jj_3R_210();
    }
    
    private static final boolean jj_3R_245() {
        return jj_3R_120();
    }
    
    private static final boolean jj_3R_233() {
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_3R_244()) {
            BeatParser.jj_scanpos = jj_scanpos;
            if (jj_3R_245()) {
                BeatParser.jj_scanpos = jj_scanpos;
                if (jj_3R_246()) {
                    BeatParser.jj_scanpos = jj_scanpos;
                    if (jj_3R_247()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private static final boolean jj_3R_244() {
        return jj_3R_255() || jj_scan_token(97);
    }
    
    private static final boolean jj_3R_105() {
        return jj_3R_120();
    }
    
    private static final boolean jj_3R_85() {
        if (jj_scan_token(93)) {
            return true;
        }
        Token jj_scanpos;
        do {
            jj_scanpos = BeatParser.jj_scanpos;
        } while (!jj_3R_105());
        BeatParser.jj_scanpos = jj_scanpos;
        return jj_scan_token(94);
    }
    
    private static final boolean jj_3R_76() {
        return jj_scan_token(87) || jj_scan_token(106) || jj_3R_120();
    }
    
    private static final boolean jj_3R_140() {
        return jj_3R_157();
    }
    
    private static final boolean jj_3_30() {
        return jj_scan_token(95) || jj_scan_token(96);
    }
    
    private static final boolean jj_3R_139() {
        return jj_3R_156();
    }
    
    private static final boolean jj_3R_138() {
        return jj_3R_155();
    }
    
    private static final boolean jj_3R_137() {
        return jj_3R_154();
    }
    
    private static final boolean jj_3R_136() {
        return jj_3R_153();
    }
    
    private static final boolean jj_3R_135() {
        return jj_3R_152();
    }
    
    private static final boolean jj_3R_134() {
        return jj_3R_151();
    }
    
    private static final boolean jj_3R_133() {
        return jj_3R_150();
    }
    
    private static final boolean jj_3R_132() {
        return jj_3R_149();
    }
    
    private static final boolean jj_3R_131() {
        return jj_3R_148();
    }
    
    private static final boolean jj_3R_130() {
        return jj_3R_147();
    }
    
    private static final boolean jj_3R_129() {
        return jj_3R_146() || jj_scan_token(97);
    }
    
    private static final boolean jj_3R_128() {
        return jj_3R_85();
    }
    
    private static final boolean jj_3R_120() {
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_3_32()) {
            BeatParser.jj_scanpos = jj_scanpos;
            if (jj_3R_128()) {
                BeatParser.jj_scanpos = jj_scanpos;
                if (jj_scan_token(97)) {
                    BeatParser.jj_scanpos = jj_scanpos;
                    if (jj_3R_129()) {
                        BeatParser.jj_scanpos = jj_scanpos;
                        if (jj_3R_130()) {
                            BeatParser.jj_scanpos = jj_scanpos;
                            if (jj_3R_131()) {
                                BeatParser.jj_scanpos = jj_scanpos;
                                if (jj_3R_132()) {
                                    BeatParser.jj_scanpos = jj_scanpos;
                                    if (jj_3R_133()) {
                                        BeatParser.jj_scanpos = jj_scanpos;
                                        if (jj_3R_134()) {
                                            BeatParser.jj_scanpos = jj_scanpos;
                                            if (jj_3R_135()) {
                                                BeatParser.jj_scanpos = jj_scanpos;
                                                if (jj_3R_136()) {
                                                    BeatParser.jj_scanpos = jj_scanpos;
                                                    if (jj_3R_137()) {
                                                        BeatParser.jj_scanpos = jj_scanpos;
                                                        if (jj_3R_138()) {
                                                            BeatParser.jj_scanpos = jj_scanpos;
                                                            if (jj_3R_139()) {
                                                                BeatParser.jj_scanpos = jj_scanpos;
                                                                if (jj_3R_140()) {
                                                                    return true;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    private static final boolean jj_3_32() {
        return jj_3R_76();
    }
    
    private static final boolean jj_3R_178() {
        return jj_3R_182();
    }
    
    private static final boolean jj_3R_181() {
        return jj_scan_token(95) || jj_scan_token(96);
    }
    
    private static final boolean jj_3_29() {
        return jj_scan_token(95) || jj_3R_75() || jj_scan_token(96);
    }
    
    private static final boolean jj_3R_177() {
        if (jj_3R_181()) {
            return true;
        }
        Token jj_scanpos;
        do {
            jj_scanpos = BeatParser.jj_scanpos;
        } while (!jj_3R_181());
        BeatParser.jj_scanpos = jj_scanpos;
        return jj_3R_106();
    }
    
    private static final boolean jj_3_31() {
        if (jj_3_29()) {
            return true;
        }
        Token jj_scanpos;
        do {
            jj_scanpos = BeatParser.jj_scanpos;
        } while (!jj_3_29());
        BeatParser.jj_scanpos = jj_scanpos;
        Token jj_scanpos2;
        do {
            jj_scanpos2 = BeatParser.jj_scanpos;
        } while (!jj_3_30());
        BeatParser.jj_scanpos = jj_scanpos2;
        return false;
    }
    
    private static final boolean jj_3R_172() {
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_3_31()) {
            BeatParser.jj_scanpos = jj_scanpos;
            if (jj_3R_177()) {
                return true;
            }
        }
        return false;
    }
    
    private static final boolean jj_3R_174() {
        if (jj_3R_69()) {
            return true;
        }
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_3R_178()) {
            BeatParser.jj_scanpos = jj_scanpos;
        }
        return false;
    }
    
    private static final boolean jj_3R_122() {
        return jj_scan_token(98) || jj_3R_75();
    }
    
    private static final boolean jj_3R_173() {
        return jj_3R_172();
    }
    
    private static final boolean jj_3R_99() {
        if (jj_scan_token(42)) {
            return true;
        }
        if (jj_3R_62()) {
            return true;
        }
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_3R_173()) {
            BeatParser.jj_scanpos = jj_scanpos;
            if (jj_3R_174()) {
                return true;
            }
        }
        return false;
    }
    
    private static final boolean jj_3_28() {
        return jj_scan_token(42) || jj_3R_71() || jj_3R_172();
    }
    
    private static final boolean jj_3R_74() {
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_3_28()) {
            BeatParser.jj_scanpos = jj_scanpos;
            if (jj_3R_99()) {
                return true;
            }
        }
        return false;
    }
    
    private static final boolean jj_3R_113() {
        if (jj_3R_75()) {
            return true;
        }
        Token jj_scanpos;
        do {
            jj_scanpos = BeatParser.jj_scanpos;
        } while (!jj_3R_122());
        BeatParser.jj_scanpos = jj_scanpos;
        return false;
    }
    
    private static final boolean jj_3R_92() {
        return jj_3R_113();
    }
    
    private static final boolean jj_3R_69() {
        if (jj_scan_token(91)) {
            return true;
        }
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_3R_92()) {
            BeatParser.jj_scanpos = jj_scanpos;
        }
        return jj_scan_token(92);
    }
    
    private static final boolean jj_3R_158() {
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_scan_token(58)) {
            BeatParser.jj_scanpos = jj_scanpos;
            if (jj_scan_token(28)) {
                return true;
            }
        }
        return false;
    }
    
    private static final boolean jj_3R_114() {
        return jj_3R_121();
    }
    
    private static final boolean jj_3R_141() {
        return jj_3R_158();
    }
    
    private static final boolean jj_3R_121() {
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_scan_token(79)) {
            BeatParser.jj_scanpos = jj_scanpos;
            if (jj_scan_token(83)) {
                BeatParser.jj_scanpos = jj_scanpos;
                if (jj_scan_token(85)) {
                    BeatParser.jj_scanpos = jj_scanpos;
                    if (jj_scan_token(86)) {
                        BeatParser.jj_scanpos = jj_scanpos;
                        if (jj_3R_141()) {
                            BeatParser.jj_scanpos = jj_scanpos;
                            if (jj_scan_token(43)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    private static final boolean jj_3R_97() {
        return jj_3R_69();
    }
    
    private static final boolean jj_3R_96() {
        return jj_scan_token(99) || jj_scan_token(87);
    }
    
    private static final boolean jj_3R_95() {
        return jj_scan_token(95) || jj_3R_75() || jj_scan_token(96);
    }
    
    private static final boolean jj_3_27() {
        return jj_scan_token(99) || jj_3R_74();
    }
    
    private static final boolean jj_3_25() {
        return jj_3R_73() || jj_scan_token(99) || jj_scan_token(20);
    }
    
    private static final boolean jj_3_26() {
        return jj_scan_token(99) || jj_scan_token(54);
    }
    
    private static final boolean jj_3R_72() {
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_3_26()) {
            BeatParser.jj_scanpos = jj_scanpos;
            if (jj_3_27()) {
                BeatParser.jj_scanpos = jj_scanpos;
                if (jj_3R_95()) {
                    BeatParser.jj_scanpos = jj_scanpos;
                    if (jj_3R_96()) {
                        BeatParser.jj_scanpos = jj_scanpos;
                        if (jj_3R_97()) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    
    private static final boolean jj_3R_112() {
        return jj_3R_62();
    }
    
    private static final boolean jj_3_24() {
        return jj_3R_72();
    }
    
    private static final boolean jj_3R_111() {
        return jj_3R_73() || jj_scan_token(99) || jj_scan_token(20);
    }
    
    private static final boolean jj_3R_110() {
        return jj_3R_74();
    }
    
    private static final boolean jj_3R_109() {
        return jj_scan_token(91) || jj_3R_75() || jj_scan_token(92);
    }
    
    private static final boolean jj_3R_108() {
        return jj_scan_token(51) || jj_scan_token(99) || jj_scan_token(87);
    }
    
    private static final boolean jj_3R_267() {
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_scan_token(113)) {
            BeatParser.jj_scanpos = jj_scanpos;
            if (jj_scan_token(114)) {
                return true;
            }
        }
        return false;
    }
    
    private static final boolean jj_3R_107() {
        return jj_3R_121();
    }
    
    private static final boolean jj_3R_91() {
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_3R_107()) {
            BeatParser.jj_scanpos = jj_scanpos;
            if (jj_scan_token(54)) {
                BeatParser.jj_scanpos = jj_scanpos;
                if (jj_3R_108()) {
                    BeatParser.jj_scanpos = jj_scanpos;
                    if (jj_3R_109()) {
                        BeatParser.jj_scanpos = jj_scanpos;
                        if (jj_3R_110()) {
                            BeatParser.jj_scanpos = jj_scanpos;
                            if (jj_3R_111()) {
                                BeatParser.jj_scanpos = jj_scanpos;
                                if (jj_3R_112()) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    private static final boolean jj_3_23() {
        return jj_scan_token(91) || jj_3R_71();
    }
    
    private static final boolean jj_3R_68() {
        if (jj_3R_91()) {
            return true;
        }
        Token jj_scanpos;
        do {
            jj_scanpos = BeatParser.jj_scanpos;
        } while (!jj_3_24());
        BeatParser.jj_scanpos = jj_scanpos;
        return false;
    }
    
    private static final boolean jj_3R_257() {
        return jj_scan_token(91) || jj_3R_54() || jj_scan_token(92) || jj_3R_225();
    }
    
    private static final boolean jj_3R_249() {
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_3R_256()) {
            BeatParser.jj_scanpos = jj_scanpos;
            if (jj_3R_257()) {
                return true;
            }
        }
        return false;
    }
    
    private static final boolean jj_3R_256() {
        return jj_scan_token(91) || jj_3R_54() || jj_scan_token(92) || jj_3R_197();
    }
    
    private static final boolean jj_3_22() {
        return jj_scan_token(91) || jj_3R_62() || jj_scan_token(95);
    }
    
    private static final boolean jj_3R_250() {
        if (jj_3R_68()) {
            return true;
        }
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_3R_267()) {
            BeatParser.jj_scanpos = jj_scanpos;
        }
        return false;
    }
    
    private static final boolean jj_3R_94() {
        if (jj_scan_token(91)) {
            return true;
        }
        if (jj_3R_62()) {
            return true;
        }
        if (jj_scan_token(92)) {
            return true;
        }
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_scan_token(104)) {
            BeatParser.jj_scanpos = jj_scanpos;
            if (jj_scan_token(103)) {
                BeatParser.jj_scanpos = jj_scanpos;
                if (jj_scan_token(91)) {
                    BeatParser.jj_scanpos = jj_scanpos;
                    if (jj_scan_token(87)) {
                        BeatParser.jj_scanpos = jj_scanpos;
                        if (jj_scan_token(54)) {
                            BeatParser.jj_scanpos = jj_scanpos;
                            if (jj_scan_token(51)) {
                                BeatParser.jj_scanpos = jj_scanpos;
                                if (jj_scan_token(42)) {
                                    BeatParser.jj_scanpos = jj_scanpos;
                                    if (jj_3R_114()) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    private static final boolean jj_3R_93() {
        return jj_scan_token(91) || jj_3R_62() || jj_scan_token(95) || jj_scan_token(96);
    }
    
    private static final boolean jj_3_21() {
        return jj_scan_token(91) || jj_3R_71();
    }
    
    private static final boolean jj_3R_70() {
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_3_21()) {
            BeatParser.jj_scanpos = jj_scanpos;
            if (jj_3R_93()) {
                BeatParser.jj_scanpos = jj_scanpos;
                if (jj_3R_94()) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private static final boolean jj_3_20() {
        return jj_3R_70();
    }
    
    private static final boolean jj_3R_239() {
        return jj_3R_250();
    }
    
    private static final boolean jj_3R_238() {
        return jj_3R_249();
    }
    
    private static final boolean jj_3R_225() {
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_3R_237()) {
            BeatParser.jj_scanpos = jj_scanpos;
            if (jj_3R_238()) {
                BeatParser.jj_scanpos = jj_scanpos;
                if (jj_3R_239()) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private static final boolean jj_3R_237() {
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_scan_token(104)) {
            BeatParser.jj_scanpos = jj_scanpos;
            if (jj_scan_token(103)) {
                return true;
            }
        }
        return jj_3R_197();
    }
    
    private static final boolean jj_3R_169() {
        return jj_scan_token(114) || jj_3R_68();
    }
    
    private static final boolean jj_3R_208() {
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_scan_token(115)) {
            BeatParser.jj_scanpos = jj_scanpos;
            if (jj_scan_token(116)) {
                return true;
            }
        }
        return jj_3R_190();
    }
    
    private static final boolean jj_3R_226() {
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_scan_token(117)) {
            BeatParser.jj_scanpos = jj_scanpos;
            if (jj_scan_token(118)) {
                BeatParser.jj_scanpos = jj_scanpos;
                if (jj_scan_token(122)) {
                    return true;
                }
            }
        }
        return jj_3R_197();
    }
    
    private static final boolean jj_3R_168() {
        return jj_scan_token(113) || jj_3R_68();
    }
    
    private static final boolean jj_3R_207() {
        return jj_3R_225();
    }
    
    private static final boolean jj_3R_198() {
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_scan_token(123)) {
            BeatParser.jj_scanpos = jj_scanpos;
            if (jj_scan_token(124)) {
                BeatParser.jj_scanpos = jj_scanpos;
                if (jj_scan_token(125)) {
                    return true;
                }
            }
        }
        return jj_3R_187();
    }
    
    private static final boolean jj_3R_206() {
        return jj_3R_169();
    }
    
    private static final boolean jj_3R_205() {
        return jj_3R_168();
    }
    
    private static final boolean jj_3R_197() {
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_3R_204()) {
            BeatParser.jj_scanpos = jj_scanpos;
            if (jj_3R_205()) {
                BeatParser.jj_scanpos = jj_scanpos;
                if (jj_3R_206()) {
                    BeatParser.jj_scanpos = jj_scanpos;
                    if (jj_3R_207()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private static final boolean jj_3R_204() {
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_scan_token(115)) {
            BeatParser.jj_scanpos = jj_scanpos;
            if (jj_scan_token(116)) {
                return true;
            }
        }
        return jj_3R_197();
    }
    
    private static final boolean jj_3R_191() {
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_scan_token(102)) {
            BeatParser.jj_scanpos = jj_scanpos;
            if (jj_scan_token(101)) {
                BeatParser.jj_scanpos = jj_scanpos;
                if (jj_scan_token(108)) {
                    BeatParser.jj_scanpos = jj_scanpos;
                    if (jj_scan_token(109)) {
                        return true;
                    }
                }
            }
        }
        return jj_3R_183();
    }
    
    private static final boolean jj_3R_188() {
        return jj_scan_token(37) || jj_3R_54();
    }
    
    private static final boolean jj_3R_190() {
        if (jj_3R_197()) {
            return true;
        }
        Token jj_scanpos;
        do {
            jj_scanpos = BeatParser.jj_scanpos;
        } while (!jj_3R_226());
        BeatParser.jj_scanpos = jj_scanpos;
        return false;
    }
    
    private static final boolean jj_3R_184() {
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_scan_token(107)) {
            BeatParser.jj_scanpos = jj_scanpos;
            if (jj_scan_token(110)) {
                return true;
            }
        }
        return jj_3R_175();
    }
    
    private static final boolean jj_3R_187() {
        if (jj_3R_190()) {
            return true;
        }
        Token jj_scanpos;
        do {
            jj_scanpos = BeatParser.jj_scanpos;
        } while (!jj_3R_208());
        BeatParser.jj_scanpos = jj_scanpos;
        return false;
    }
    
    private static final boolean jj_3R_183() {
        if (jj_3R_187()) {
            return true;
        }
        Token jj_scanpos;
        do {
            jj_scanpos = BeatParser.jj_scanpos;
        } while (!jj_3R_198());
        BeatParser.jj_scanpos = jj_scanpos;
        return false;
    }
    
    private static final boolean jj_3R_180() {
        return jj_scan_token(119) || jj_3R_170();
    }
    
    private static final boolean jj_3R_179() {
        if (jj_3R_183()) {
            return true;
        }
        Token jj_scanpos;
        do {
            jj_scanpos = BeatParser.jj_scanpos;
        } while (!jj_3R_191());
        BeatParser.jj_scanpos = jj_scanpos;
        return false;
    }
    
    private static final boolean jj_3R_171() {
        return jj_scan_token(120) || jj_3R_160();
    }
    
    private static final boolean jj_3R_175() {
        if (jj_3R_179()) {
            return true;
        }
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_3R_188()) {
            BeatParser.jj_scanpos = jj_scanpos;
        }
        return false;
    }
    
    private static final boolean jj_3R_176() {
        return jj_scan_token(121) || jj_3R_166();
    }
    
    private static final boolean jj_3R_167() {
        return jj_scan_token(112) || jj_3R_143();
    }
    
    private static final boolean jj_3R_170() {
        if (jj_3R_175()) {
            return true;
        }
        Token jj_scanpos;
        do {
            jj_scanpos = BeatParser.jj_scanpos;
        } while (!jj_3R_184());
        BeatParser.jj_scanpos = jj_scanpos;
        return false;
    }
    
    private static final boolean jj_3R_161() {
        return jj_scan_token(111) || jj_3R_123();
    }
    
    private static final boolean jj_3R_166() {
        if (jj_3R_170()) {
            return true;
        }
        Token jj_scanpos;
        do {
            jj_scanpos = BeatParser.jj_scanpos;
        } while (!jj_3R_180());
        BeatParser.jj_scanpos = jj_scanpos;
        return false;
    }
    
    private static final boolean jj_3R_144() {
        return jj_scan_token(105) || jj_3R_75() || jj_scan_token(106) || jj_3R_100();
    }
    
    private static final boolean jj_3R_160() {
        if (jj_3R_166()) {
            return true;
        }
        Token jj_scanpos;
        do {
            jj_scanpos = BeatParser.jj_scanpos;
        } while (!jj_3R_176());
        BeatParser.jj_scanpos = jj_scanpos;
        return false;
    }
    
    private static final boolean jj_3R_143() {
        if (jj_3R_160()) {
            return true;
        }
        Token jj_scanpos;
        do {
            jj_scanpos = BeatParser.jj_scanpos;
        } while (!jj_3R_171());
        BeatParser.jj_scanpos = jj_scanpos;
        return false;
    }
    
    private static final boolean jj_3R_123() {
        if (jj_3R_143()) {
            return true;
        }
        Token jj_scanpos;
        do {
            jj_scanpos = BeatParser.jj_scanpos;
        } while (!jj_3R_167());
        BeatParser.jj_scanpos = jj_scanpos;
        return false;
    }
    
    private static final boolean jj_3R_115() {
        if (jj_3R_123()) {
            return true;
        }
        Token jj_scanpos;
        do {
            jj_scanpos = BeatParser.jj_scanpos;
        } while (!jj_3R_161());
        BeatParser.jj_scanpos = jj_scanpos;
        return false;
    }
    
    private static final boolean jj_3R_100() {
        if (jj_3R_115()) {
            return true;
        }
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_3R_144()) {
            BeatParser.jj_scanpos = jj_scanpos;
        }
        return false;
    }
    
    private static final boolean jj_3R_159() {
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_scan_token(100)) {
            BeatParser.jj_scanpos = jj_scanpos;
            if (jj_scan_token(128)) {
                BeatParser.jj_scanpos = jj_scanpos;
                if (jj_scan_token(129)) {
                    BeatParser.jj_scanpos = jj_scanpos;
                    if (jj_scan_token(133)) {
                        BeatParser.jj_scanpos = jj_scanpos;
                        if (jj_scan_token(126)) {
                            BeatParser.jj_scanpos = jj_scanpos;
                            if (jj_scan_token(127)) {
                                BeatParser.jj_scanpos = jj_scanpos;
                                if (jj_scan_token(134)) {
                                    BeatParser.jj_scanpos = jj_scanpos;
                                    if (jj_scan_token(135)) {
                                        BeatParser.jj_scanpos = jj_scanpos;
                                        if (jj_scan_token(136)) {
                                            BeatParser.jj_scanpos = jj_scanpos;
                                            if (jj_scan_token(130)) {
                                                BeatParser.jj_scanpos = jj_scanpos;
                                                if (jj_scan_token(132)) {
                                                    BeatParser.jj_scanpos = jj_scanpos;
                                                    if (jj_scan_token(131)) {
                                                        return true;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    private static final boolean jj_3R_142() {
        return jj_3R_159() || jj_3R_75();
    }
    
    private static final boolean jj_3R_75() {
        if (jj_3R_100()) {
            return true;
        }
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_3R_142()) {
            BeatParser.jj_scanpos = jj_scanpos;
        }
        return false;
    }
    
    private static final boolean jj_3R_243() {
        return jj_scan_token(98) || jj_3R_62();
    }
    
    private static final boolean jj_3R_232() {
        if (jj_3R_62()) {
            return true;
        }
        Token jj_scanpos;
        do {
            jj_scanpos = BeatParser.jj_scanpos;
        } while (!jj_3R_243());
        BeatParser.jj_scanpos = jj_scanpos;
        return false;
    }
    
    private static final boolean jj_3_19() {
        return jj_scan_token(99) || jj_scan_token(87);
    }
    
    private static final boolean jj_3R_62() {
        if (jj_scan_token(87)) {
            return true;
        }
        Token jj_scanpos;
        do {
            jj_scanpos = BeatParser.jj_scanpos;
        } while (!jj_3_19());
        BeatParser.jj_scanpos = jj_scanpos;
        return false;
    }
    
    private static final boolean jj_3R_79() {
        return jj_scan_token(95) || jj_scan_token(96);
    }
    
    private static final boolean jj_3R_98() {
        return jj_3R_54();
    }
    
    private static final boolean jj_3R_73() {
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_scan_token(60)) {
            BeatParser.jj_scanpos = jj_scanpos;
            if (jj_3R_98()) {
                return true;
            }
        }
        return false;
    }
    
    private static final boolean jj_3R_78() {
        return jj_3R_62();
    }
    
    private static final boolean jj_3R_71() {
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_scan_token(14)) {
            BeatParser.jj_scanpos = jj_scanpos;
            if (jj_scan_token(19)) {
                BeatParser.jj_scanpos = jj_scanpos;
                if (jj_scan_token(16)) {
                    BeatParser.jj_scanpos = jj_scanpos;
                    if (jj_scan_token(49)) {
                        BeatParser.jj_scanpos = jj_scanpos;
                        if (jj_scan_token(38)) {
                            BeatParser.jj_scanpos = jj_scanpos;
                            if (jj_scan_token(40)) {
                                BeatParser.jj_scanpos = jj_scanpos;
                                if (jj_scan_token(31)) {
                                    BeatParser.jj_scanpos = jj_scanpos;
                                    if (jj_scan_token(25)) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    private static final boolean jj_3R_77() {
        return jj_3R_71();
    }
    
    private static final boolean jj_3R_215() {
        return jj_scan_token(56) || jj_3R_232();
    }
    
    private static final boolean jj_3R_54() {
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_3R_77()) {
            BeatParser.jj_scanpos = jj_scanpos;
            if (jj_3R_78()) {
                return true;
            }
        }
        Token jj_scanpos2;
        do {
            jj_scanpos2 = BeatParser.jj_scanpos;
        } while (!jj_3R_79());
        BeatParser.jj_scanpos = jj_scanpos2;
        return false;
    }
    
    private static final boolean jj_3_18() {
        return jj_scan_token(54) || jj_3R_69() || jj_scan_token(97);
    }
    
    private static final boolean jj_3R_58() {
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_scan_token(50)) {
            BeatParser.jj_scanpos = jj_scanpos;
        }
        return jj_3R_85();
    }
    
    private static final boolean jj_3_16() {
        return jj_3R_67();
    }
    
    private static final boolean jj_3_17() {
        return jj_3R_68() || jj_scan_token(99);
    }
    
    private static final boolean jj_3R_234() {
        return jj_scan_token(95) || jj_scan_token(96);
    }
    
    private static final boolean jj_3R_90() {
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_3_17()) {
            BeatParser.jj_scanpos = jj_scanpos;
        }
        return jj_scan_token(51) || jj_3R_69() || jj_scan_token(97);
    }
    
    private static final boolean jj_3R_242() {
        return jj_scan_token(98) || jj_3R_241();
    }
    
    private static final boolean jj_3R_67() {
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_3R_89()) {
            BeatParser.jj_scanpos = jj_scanpos;
            if (jj_3R_90()) {
                return true;
            }
        }
        return false;
    }
    
    private static final boolean jj_3R_89() {
        return jj_scan_token(54) || jj_3R_69() || jj_scan_token(97);
    }
    
    private static final boolean jj_3R_220() {
        return jj_scan_token(56) || jj_3R_232();
    }
    
    private static final boolean jj_3R_217() {
        return jj_3R_233();
    }
    
    private static final boolean jj_3R_216() {
        return jj_3R_67();
    }
    
    private static final boolean jj_3R_213() {
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_scan_token(47)) {
            BeatParser.jj_scanpos = jj_scanpos;
            if (jj_scan_token(46)) {
                BeatParser.jj_scanpos = jj_scanpos;
                if (jj_scan_token(45)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private static final boolean jj_3R_201() {
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_3R_213()) {
            BeatParser.jj_scanpos = jj_scanpos;
        }
        if (jj_scan_token(87)) {
            return true;
        }
        if (jj_3R_214()) {
            return true;
        }
        final Token jj_scanpos2 = BeatParser.jj_scanpos;
        if (jj_3R_215()) {
            BeatParser.jj_scanpos = jj_scanpos2;
        }
        if (jj_scan_token(93)) {
            return true;
        }
        final Token jj_scanpos3 = BeatParser.jj_scanpos;
        if (jj_3R_216()) {
            BeatParser.jj_scanpos = jj_scanpos3;
        }
        Token jj_scanpos4;
        do {
            jj_scanpos4 = BeatParser.jj_scanpos;
        } while (!jj_3R_217());
        BeatParser.jj_scanpos = jj_scanpos4;
        return jj_scan_token(94);
    }
    
    private static final boolean jj_3_15() {
        return jj_scan_token(98) || jj_3R_66();
    }
    
    private static final boolean jj_3R_231() {
        if (jj_3R_241()) {
            return true;
        }
        Token jj_scanpos;
        do {
            jj_scanpos = BeatParser.jj_scanpos;
        } while (!jj_3R_242());
        BeatParser.jj_scanpos = jj_scanpos;
        return false;
    }
    
    private static final boolean jj_3R_241() {
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_scan_token(29)) {
            BeatParser.jj_scanpos = jj_scanpos;
        }
        return jj_3R_54() || jj_3R_235();
    }
    
    private static final boolean jj_3R_214() {
        if (jj_scan_token(91)) {
            return true;
        }
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_3R_231()) {
            BeatParser.jj_scanpos = jj_scanpos;
        }
        return jj_scan_token(92);
    }
    
    private static final boolean jj_3R_219() {
        if (jj_scan_token(87)) {
            return true;
        }
        if (jj_3R_214()) {
            return true;
        }
        Token jj_scanpos;
        do {
            jj_scanpos = BeatParser.jj_scanpos;
        } while (!jj_3R_234());
        BeatParser.jj_scanpos = jj_scanpos;
        return false;
    }
    
    private static final boolean jj_3R_221() {
        return jj_3R_85();
    }
    
    private static final boolean jj_3R_218() {
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_scan_token(47)) {
            BeatParser.jj_scanpos = jj_scanpos;
            if (jj_scan_token(46)) {
                BeatParser.jj_scanpos = jj_scanpos;
                if (jj_scan_token(45)) {
                    BeatParser.jj_scanpos = jj_scanpos;
                    if (jj_scan_token(50)) {
                        BeatParser.jj_scanpos = jj_scanpos;
                        if (jj_scan_token(13)) {
                            BeatParser.jj_scanpos = jj_scanpos;
                            if (jj_scan_token(29)) {
                                BeatParser.jj_scanpos = jj_scanpos;
                                if (jj_scan_token(41)) {
                                    BeatParser.jj_scanpos = jj_scanpos;
                                    if (jj_scan_token(53)) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    private static final boolean jj_3R_185() {
        if (jj_3R_66()) {
            return true;
        }
        Token jj_scanpos;
        do {
            jj_scanpos = BeatParser.jj_scanpos;
        } while (!jj_3_15());
        BeatParser.jj_scanpos = jj_scanpos;
        return false;
    }
    
    private static final boolean jj_3R_202() {
        Token jj_scanpos;
        do {
            jj_scanpos = BeatParser.jj_scanpos;
        } while (!jj_3R_218());
        BeatParser.jj_scanpos = jj_scanpos;
        if (jj_3R_73()) {
            return true;
        }
        if (jj_3R_219()) {
            return true;
        }
        final Token jj_scanpos2 = BeatParser.jj_scanpos;
        if (jj_3R_220()) {
            BeatParser.jj_scanpos = jj_scanpos2;
        }
        final Token jj_scanpos3 = BeatParser.jj_scanpos;
        if (jj_3R_221()) {
            BeatParser.jj_scanpos = jj_scanpos3;
            if (jj_scan_token(97)) {
                return true;
            }
        }
        return false;
    }
    
    private static final boolean jj_3R_236() {
        return jj_scan_token(100) || jj_3R_66();
    }
    
    private static final boolean jj_3R_224() {
        return jj_scan_token(98) || jj_3R_223();
    }
    
    private static final boolean jj_3R_248() {
        return jj_scan_token(95) || jj_scan_token(96);
    }
    
    private static final boolean jj_3R_106() {
        if (jj_scan_token(93)) {
            return true;
        }
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_3R_185()) {
            BeatParser.jj_scanpos = jj_scanpos;
        }
        final Token jj_scanpos2 = BeatParser.jj_scanpos;
        if (jj_scan_token(98)) {
            BeatParser.jj_scanpos = jj_scanpos2;
        }
        return jj_scan_token(94);
    }
    
    private static final boolean jj_3R_88() {
        return jj_3R_75();
    }
    
    private static final boolean jj_3R_66() {
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_3R_87()) {
            BeatParser.jj_scanpos = jj_scanpos;
            if (jj_3R_88()) {
                return true;
            }
        }
        return false;
    }
    
    private static final boolean jj_3R_87() {
        return jj_3R_106();
    }
    
    private static final boolean jj_3R_235() {
        if (jj_scan_token(87)) {
            return true;
        }
        Token jj_scanpos;
        do {
            jj_scanpos = BeatParser.jj_scanpos;
        } while (!jj_3R_248());
        BeatParser.jj_scanpos = jj_scanpos;
        return false;
    }
    
    private static final boolean jj_3R_223() {
        if (jj_3R_235()) {
            return true;
        }
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_3R_236()) {
            BeatParser.jj_scanpos = jj_scanpos;
        }
        return false;
    }
    
    private static final boolean jj_3R_229() {
        return jj_scan_token(27) || jj_3R_232();
    }
    
    private static final boolean jj_3_14() {
        return jj_3R_63();
    }
    
    private static final boolean jj_3R_222() {
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_scan_token(47)) {
            BeatParser.jj_scanpos = jj_scanpos;
            if (jj_scan_token(46)) {
                BeatParser.jj_scanpos = jj_scanpos;
                if (jj_scan_token(45)) {
                    BeatParser.jj_scanpos = jj_scanpos;
                    if (jj_scan_token(50)) {
                        BeatParser.jj_scanpos = jj_scanpos;
                        if (jj_scan_token(29)) {
                            BeatParser.jj_scanpos = jj_scanpos;
                            if (jj_scan_token(57)) {
                                BeatParser.jj_scanpos = jj_scanpos;
                                if (jj_scan_token(61)) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    private static final boolean jj_3R_65() {
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_scan_token(50)) {
            BeatParser.jj_scanpos = jj_scanpos;
            if (jj_scan_token(13)) {
                BeatParser.jj_scanpos = jj_scanpos;
                if (jj_scan_token(29)) {
                    BeatParser.jj_scanpos = jj_scanpos;
                    if (jj_scan_token(47)) {
                        BeatParser.jj_scanpos = jj_scanpos;
                        if (jj_scan_token(46)) {
                            BeatParser.jj_scanpos = jj_scanpos;
                            if (jj_scan_token(45)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    private static final boolean jj_3R_203() {
        Token jj_scanpos;
        do {
            jj_scanpos = BeatParser.jj_scanpos;
        } while (!jj_3R_222());
        BeatParser.jj_scanpos = jj_scanpos;
        if (jj_3R_54()) {
            return true;
        }
        if (jj_3R_223()) {
            return true;
        }
        Token jj_scanpos2;
        do {
            jj_scanpos2 = BeatParser.jj_scanpos;
        } while (!jj_3R_224());
        BeatParser.jj_scanpos = jj_scanpos2;
        return jj_scan_token(97);
    }
    
    private static final boolean jj_3_13() {
        Token jj_scanpos;
        do {
            jj_scanpos = BeatParser.jj_scanpos;
        } while (!jj_3R_65());
        BeatParser.jj_scanpos = jj_scanpos;
        return jj_scan_token(39);
    }
    
    private static final boolean jj_3R_64() {
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_scan_token(50)) {
            BeatParser.jj_scanpos = jj_scanpos;
            if (jj_scan_token(13)) {
                BeatParser.jj_scanpos = jj_scanpos;
                if (jj_scan_token(29)) {
                    BeatParser.jj_scanpos = jj_scanpos;
                    if (jj_scan_token(47)) {
                        BeatParser.jj_scanpos = jj_scanpos;
                        if (jj_scan_token(46)) {
                            BeatParser.jj_scanpos = jj_scanpos;
                            if (jj_scan_token(45)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    private static final boolean jj_3_12() {
        Token jj_scanpos;
        do {
            jj_scanpos = BeatParser.jj_scanpos;
        } while (!jj_3R_64());
        BeatParser.jj_scanpos = jj_scanpos;
        return jj_scan_token(20);
    }
    
    private static final boolean jj_3R_254() {
        return jj_3R_203();
    }
    
    private static final boolean jj_3R_253() {
        return jj_3R_202();
    }
    
    private static final boolean jj_3R_252() {
        return jj_3R_200();
    }
    
    private static final boolean jj_3R_230() {
        return jj_3R_240();
    }
    
    private static final boolean jj_3R_240() {
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_3R_251()) {
            BeatParser.jj_scanpos = jj_scanpos;
            if (jj_3R_252()) {
                BeatParser.jj_scanpos = jj_scanpos;
                if (jj_3R_253()) {
                    BeatParser.jj_scanpos = jj_scanpos;
                    if (jj_3R_254()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private static final boolean jj_3R_251() {
        return jj_3R_199();
    }
    
    private static final boolean jj_3R_212() {
        if (jj_scan_token(39)) {
            return true;
        }
        if (jj_scan_token(87)) {
            return true;
        }
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_3R_229()) {
            BeatParser.jj_scanpos = jj_scanpos;
        }
        if (jj_scan_token(93)) {
            return true;
        }
        Token jj_scanpos2;
        do {
            jj_scanpos2 = BeatParser.jj_scanpos;
        } while (!jj_3R_230());
        BeatParser.jj_scanpos = jj_scanpos2;
        return jj_scan_token(94);
    }
    
    private static final boolean jj_3R_211() {
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_scan_token(50)) {
            BeatParser.jj_scanpos = jj_scanpos;
            if (jj_scan_token(13)) {
                BeatParser.jj_scanpos = jj_scanpos;
                if (jj_scan_token(29)) {
                    BeatParser.jj_scanpos = jj_scanpos;
                    if (jj_scan_token(47)) {
                        BeatParser.jj_scanpos = jj_scanpos;
                        if (jj_scan_token(46)) {
                            BeatParser.jj_scanpos = jj_scanpos;
                            if (jj_scan_token(45)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    private static final boolean jj_3R_200() {
        Token jj_scanpos;
        do {
            jj_scanpos = BeatParser.jj_scanpos;
        } while (!jj_3R_211());
        BeatParser.jj_scanpos = jj_scanpos;
        return jj_3R_212();
    }
    
    private static final boolean jj_3R_86() {
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_scan_token(47)) {
            BeatParser.jj_scanpos = jj_scanpos;
            if (jj_scan_token(46)) {
                BeatParser.jj_scanpos = jj_scanpos;
                if (jj_scan_token(45)) {
                    BeatParser.jj_scanpos = jj_scanpos;
                    if (jj_scan_token(50)) {
                        BeatParser.jj_scanpos = jj_scanpos;
                        if (jj_scan_token(13)) {
                            BeatParser.jj_scanpos = jj_scanpos;
                            if (jj_scan_token(29)) {
                                BeatParser.jj_scanpos = jj_scanpos;
                                if (jj_scan_token(41)) {
                                    BeatParser.jj_scanpos = jj_scanpos;
                                    if (jj_scan_token(53)) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    private static final boolean jj_3R_228() {
        return jj_scan_token(35) || jj_3R_232();
    }
    
    private static final boolean jj_3_11() {
        return jj_3R_63();
    }
    
    private static final boolean jj_3R_61() {
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_scan_token(47)) {
            BeatParser.jj_scanpos = jj_scanpos;
            if (jj_scan_token(46)) {
                BeatParser.jj_scanpos = jj_scanpos;
                if (jj_scan_token(45)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private static final boolean jj_3R_63() {
        Token jj_scanpos;
        do {
            jj_scanpos = BeatParser.jj_scanpos;
        } while (!jj_3R_86());
        BeatParser.jj_scanpos = jj_scanpos;
        return jj_3R_73() || jj_scan_token(87) || jj_scan_token(91);
    }
    
    private static final boolean jj_3_10() {
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_3R_61()) {
            BeatParser.jj_scanpos = jj_scanpos;
        }
        return jj_3R_62() || jj_scan_token(91);
    }
    
    private static final boolean jj_3R_60() {
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_scan_token(50)) {
            BeatParser.jj_scanpos = jj_scanpos;
            if (jj_scan_token(13)) {
                BeatParser.jj_scanpos = jj_scanpos;
                if (jj_scan_token(29)) {
                    BeatParser.jj_scanpos = jj_scanpos;
                    if (jj_scan_token(47)) {
                        BeatParser.jj_scanpos = jj_scanpos;
                        if (jj_scan_token(46)) {
                            BeatParser.jj_scanpos = jj_scanpos;
                            if (jj_scan_token(45)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    private static final boolean jj_3_9() {
        Token jj_scanpos;
        do {
            jj_scanpos = BeatParser.jj_scanpos;
        } while (!jj_3R_60());
        BeatParser.jj_scanpos = jj_scanpos;
        return jj_scan_token(39);
    }
    
    private static final boolean jj_3R_59() {
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_scan_token(50)) {
            BeatParser.jj_scanpos = jj_scanpos;
            if (jj_scan_token(13)) {
                BeatParser.jj_scanpos = jj_scanpos;
                if (jj_scan_token(29)) {
                    BeatParser.jj_scanpos = jj_scanpos;
                    if (jj_scan_token(47)) {
                        BeatParser.jj_scanpos = jj_scanpos;
                        if (jj_scan_token(46)) {
                            BeatParser.jj_scanpos = jj_scanpos;
                            if (jj_scan_token(45)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    private static final boolean jj_3R_196() {
        return jj_3R_203();
    }
    
    private static final boolean jj_3_8() {
        Token jj_scanpos;
        do {
            jj_scanpos = BeatParser.jj_scanpos;
        } while (!jj_3R_59());
        BeatParser.jj_scanpos = jj_scanpos;
        return jj_scan_token(20);
    }
    
    private static final boolean jj_3R_195() {
        return jj_3R_202();
    }
    
    private static final boolean jj_3R_194() {
        return jj_3R_201();
    }
    
    private static final boolean jj_3R_193() {
        return jj_3R_200();
    }
    
    private static final boolean jj_3R_192() {
        return jj_3R_199();
    }
    
    private static final boolean jj_3R_227() {
        return jj_scan_token(27) || jj_3R_62();
    }
    
    private static final boolean jj_3_7() {
        return jj_3R_58();
    }
    
    private static final boolean jj_3R_189() {
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_3_7()) {
            BeatParser.jj_scanpos = jj_scanpos;
            if (jj_3R_192()) {
                BeatParser.jj_scanpos = jj_scanpos;
                if (jj_3R_193()) {
                    BeatParser.jj_scanpos = jj_scanpos;
                    if (jj_3R_194()) {
                        BeatParser.jj_scanpos = jj_scanpos;
                        if (jj_3R_195()) {
                            BeatParser.jj_scanpos = jj_scanpos;
                            if (jj_3R_196()) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    private static final boolean jj_3R_209() {
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_scan_token(50)) {
            BeatParser.jj_scanpos = jj_scanpos;
            if (jj_scan_token(13)) {
                BeatParser.jj_scanpos = jj_scanpos;
                if (jj_scan_token(29)) {
                    BeatParser.jj_scanpos = jj_scanpos;
                    if (jj_scan_token(47)) {
                        BeatParser.jj_scanpos = jj_scanpos;
                        if (jj_scan_token(46)) {
                            BeatParser.jj_scanpos = jj_scanpos;
                            if (jj_scan_token(45)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    private static final boolean jj_3R_186() {
        return jj_3R_189();
    }
    
    private static final boolean jj_3R_199() {
        Token jj_scanpos;
        do {
            jj_scanpos = BeatParser.jj_scanpos;
        } while (!jj_3R_209());
        BeatParser.jj_scanpos = jj_scanpos;
        return jj_3R_210();
    }
    
    private static final boolean jj_3R_182() {
        if (jj_scan_token(93)) {
            return true;
        }
        Token jj_scanpos;
        do {
            jj_scanpos = BeatParser.jj_scanpos;
        } while (!jj_3R_186());
        BeatParser.jj_scanpos = jj_scanpos;
        return jj_scan_token(94);
    }
    
    private static final boolean jj_3R_210() {
        if (jj_scan_token(20)) {
            return true;
        }
        if (jj_scan_token(87)) {
            return true;
        }
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_3R_227()) {
            BeatParser.jj_scanpos = jj_scanpos;
        }
        final Token jj_scanpos2 = BeatParser.jj_scanpos;
        if (jj_3R_228()) {
            BeatParser.jj_scanpos = jj_scanpos2;
        }
        return jj_3R_182();
    }
    
    private static final boolean jj_3R_57() {
        final Token jj_scanpos = BeatParser.jj_scanpos;
        if (jj_scan_token(13)) {
            BeatParser.jj_scanpos = jj_scanpos;
            if (jj_scan_token(29)) {
                BeatParser.jj_scanpos = jj_scanpos;
                if (jj_scan_token(47)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private static final boolean jj_3_6() {
        Token jj_scanpos;
        do {
            jj_scanpos = BeatParser.jj_scanpos;
        } while (!jj_3R_57());
        BeatParser.jj_scanpos = jj_scanpos;
        return jj_scan_token(20);
    }
    
    private static final void jj_la1_0() {
        BeatParser.jj_la1_0 = new int[] { 0, 0, 0, 0, -2113323008, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1823883264, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 268435456, 268435456, 0, 0, 537927680, 0, 8192, 536879104, 536879104, 134217728, 0, -1575395328, 536879104, 536879104, -1576452096, 536879104, 536879104, 8192, 8192, 536879104, 536879104, 134217728, -1575395328, -1576452096, 536870912, 536870912, 0, 0, 0, -1844887552, -1844887552, 0, 536879104, 536879104, 0, 0, 0, 0, -1576452096, 536870912, 0, 0, 0, -1285963776, -1844887552, 0, -2113323008, 0, -2113323008, -2113323008, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1844887552, 0, 0, -1844887552, 268435456, 0, 0, 0, 0, 268435456, 0, 0, 268435456, 268435456, -1844887552, 0, 0, 0, 0, 0, 0, -1823883264, -1823883264, -1822834688, 536870912, 0, 0, 0, -1844887552, 8519680, -1285963776, 8519680, 67108864, -1308016640, -1844887552, -1844887552, -1844887552, 0, 0, 0, -1844887552, 262144, 1073741824 };
    }
    
    private static final void jj_la1_1() {
        BeatParser.jj_la1_1 = new int[] { 4096, 16, 16, 0, 131392, Integer.MIN_VALUE, 0, Integer.MIN_VALUE, 0, 0, 0, 0, 0, 0, 0, 0, 1559956805, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 67110912, 67110912, 4096, 16, 32896, 0, 32896, 32768, 32768, 0, 8, 841409472, 319488, 319488, 570876224, 2417152, 2417152, 32768, 32768, 319488, 319488, 0, 841409472, 570876224, 570744832, 570744832, 0, 0, 0, 340397376, 340397376, 0, 2417152, 2417152, 16777216, 0, 0, 0, 131392, 0, 57344, 57344, 16777216, 1559956933, 340397376, 262144, 131392, 0, 131392, 268566848, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 340397376, 0, 0, 340397376, 71830528, 0, 0, 0, 0, 71830528, 0, 0, 67110912, 67108864, 340397376, 0, 0, 0, 1024, 0, 0, 1559956805, 1559956805, 1559956933, 0, 0, 0, 0, 340397376, 0, 1559956933, 0, 0, 340397376, 340397376, 340397376, 340397376, 0, 0, 0, 340397376, 0, 0 };
    }
    
    private static final void jj_la1_2() {
        BeatParser.jj_la1_2 = new int[] { 0, 8, 8, 1, 8388608, 16374, 0, 16374, 8421376, 8945664, 8945664, 8421376, 8421376, 134217728, 0, 0, 686325760, 0, 0, 0, 0, 67108864, 679477248, 134217728, 142606336, 134217728, 679477248, 0, 8388608, 8388608, 16384, 0, 15237120, 6848512, 0, 0, 0, 0, 0, 0, 0, 0, 0, 545259520, 0, 0, 8388608, 0, 0, 0, 0, 0, 0, 0, 8388608, 8388608, 0, 0, 0, 0, Integer.MIN_VALUE, 686325760, 686325760, 0, 0, 0, 0, 536870912, Integer.MIN_VALUE, 0, 8388608, 0, 0, 0, 0, 686325760, 149454848, 0, 8388608, Integer.MIN_VALUE, 0, 8388608, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 149454848, 0, 0, 149454848, 149454848, 134217728, 0, 0, 134217728, 141066240, 8388608, -2013265920, 6848512, 0, 149454848, 0, 536870912, -2013265920, 0, Integer.MIN_VALUE, Integer.MIN_VALUE, 686325760, 686325760, 686325760, 0, 0, 0, 0, 149454848, 0, 686325760, 0, 0, 149454848, 149454848, 149454848, 149454848, 0, 8388608, 8388608, 149454848, 0, 0 };
    }
    
    private static final void jj_la1_3() {
        BeatParser.jj_la1_3 = new int[] { 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 1572864, 1572864, 393218, 1048584, 1048584, 1048584, 1048584, 0, 128, 0, 128, 0, 128, 128, 0, 0, 30816, 8, 0, 0, 0, 0, 2, 8, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 16, 0, 1966464, 1966464, 4, 0, 0, 0, 2, 0, 4, 0, 0, 0, 0, 0, 393218, 0, 0, 0, 0, 0, 0, 4, -1073741808, -1073741808, 512, 32768, 65536, 16777216, 33554432, 8388608, 18432, 18432, 0, 12384, 12384, 939524096, 939524096, 1572864, 1572864, 73400320, 73400320, 1572864, 1966464, 384, 384, 0, 384, 0, 393216, 393216, 0, 0, 0, 8, 0, 0, 1966464, 4, 0, 0, 0, 0, 0, 393218, 393218, 393218, 0, 4, -1073348592, -1073348592, 393216, 0, 393218, 0, 0, 393216, 1966464, 393216, 393216, 4, 0, 0, 1966464, 0, 0 };
    }
    
    private static final void jj_la1_4() {
        BeatParser.jj_la1_4 = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 511, 511, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 511, 511, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    }
    
    public static void ReInit(final InputStream inputStream) {
        BeatParser.jj_input_stream.ReInit(inputStream, 1, 1);
        BeatParserTokenManager.ReInit(BeatParser.jj_input_stream);
        BeatParser.token = new Token();
        BeatParser.jj_ntk = -1;
        BeatParser.jjtree.reset();
        BeatParser.jj_gen = 0;
        for (int i = 0; i < 146; ++i) {
            BeatParser.jj_la1[i] = -1;
        }
        for (int j = 0; j < BeatParser.jj_2_rtns.length; ++j) {
            BeatParser.jj_2_rtns[j] = new JJCalls();
        }
    }
    
    public static void ReInit(final Reader reader) {
        BeatParser.jj_input_stream.ReInit(reader, 1, 1);
        BeatParserTokenManager.ReInit(BeatParser.jj_input_stream);
        BeatParser.token = new Token();
        BeatParser.jj_ntk = -1;
        BeatParser.jjtree.reset();
        BeatParser.jj_gen = 0;
        for (int i = 0; i < 146; ++i) {
            BeatParser.jj_la1[i] = -1;
        }
        for (int j = 0; j < BeatParser.jj_2_rtns.length; ++j) {
            BeatParser.jj_2_rtns[j] = new JJCalls();
        }
    }
    
    public void ReInit(final BeatParserTokenManager token_source) {
        BeatParser.token_source = token_source;
        BeatParser.token = new Token();
        BeatParser.jj_ntk = -1;
        BeatParser.jjtree.reset();
        BeatParser.jj_gen = 0;
        for (int i = 0; i < 146; ++i) {
            BeatParser.jj_la1[i] = -1;
        }
        for (int j = 0; j < BeatParser.jj_2_rtns.length; ++j) {
            BeatParser.jj_2_rtns[j] = new JJCalls();
        }
    }
    
    private static final Token jj_consume_token(final int jj_kind) throws ParseException {
        final Token token;
        if ((token = BeatParser.token).next != null) {
            BeatParser.token = BeatParser.token.next;
        }
        else {
            final Token token2 = BeatParser.token;
            final Token nextToken = BeatParserTokenManager.getNextToken();
            token2.next = nextToken;
            BeatParser.token = nextToken;
        }
        BeatParser.jj_ntk = -1;
        if (BeatParser.token.kind == jj_kind) {
            ++BeatParser.jj_gen;
            if (++BeatParser.jj_gc > 100) {
                BeatParser.jj_gc = 0;
                for (int i = 0; i < BeatParser.jj_2_rtns.length; ++i) {
                    for (JJCalls next = BeatParser.jj_2_rtns[i]; next != null; next = next.next) {
                        if (next.gen < BeatParser.jj_gen) {
                            next.first = null;
                        }
                    }
                }
            }
            return BeatParser.token;
        }
        BeatParser.token = token;
        BeatParser.jj_kind = jj_kind;
        throw generateParseException();
    }
    
    private static final boolean jj_scan_token(final int n) {
        if (BeatParser.jj_scanpos == BeatParser.jj_lastpos) {
            --BeatParser.jj_la;
            if (BeatParser.jj_scanpos.next == null) {
                final Token jj_scanpos = BeatParser.jj_scanpos;
                final Token nextToken = BeatParserTokenManager.getNextToken();
                jj_scanpos.next = nextToken;
                BeatParser.jj_scanpos = nextToken;
                BeatParser.jj_lastpos = nextToken;
            }
            else {
                BeatParser.jj_lastpos = (BeatParser.jj_scanpos = BeatParser.jj_scanpos.next);
            }
        }
        else {
            BeatParser.jj_scanpos = BeatParser.jj_scanpos.next;
        }
        if (BeatParser.jj_rescan) {
            int n2 = 0;
            Token token;
            for (token = BeatParser.token; token != null && token != BeatParser.jj_scanpos; token = token.next) {
                ++n2;
            }
            if (token != null) {
                jj_add_error_token(n, n2);
            }
        }
        if (BeatParser.jj_scanpos.kind != n) {
            return true;
        }
        if (BeatParser.jj_la == 0 && BeatParser.jj_scanpos == BeatParser.jj_lastpos) {
            throw BeatParser.jj_ls;
        }
        return false;
    }
    
    public static final Token getNextToken() {
        if (BeatParser.token.next != null) {
            BeatParser.token = BeatParser.token.next;
        }
        else {
            final Token token = BeatParser.token;
            final Token nextToken = BeatParserTokenManager.getNextToken();
            token.next = nextToken;
            BeatParser.token = nextToken;
        }
        BeatParser.jj_ntk = -1;
        ++BeatParser.jj_gen;
        return BeatParser.token;
    }
    
    public static final Token getToken(final int n) {
        Token next = BeatParser.lookingAhead ? BeatParser.jj_scanpos : BeatParser.token;
        for (int i = 0; i < n; ++i) {
            if (next.next != null) {
                next = next.next;
            }
            else {
                final Token token = next;
                final Token nextToken = BeatParserTokenManager.getNextToken();
                token.next = nextToken;
                next = nextToken;
            }
        }
        return next;
    }
    
    private static final int jj_ntk() {
        if ((BeatParser.jj_nt = BeatParser.token.next) == null) {
            final Token token = BeatParser.token;
            final Token nextToken = BeatParserTokenManager.getNextToken();
            token.next = nextToken;
            return BeatParser.jj_ntk = nextToken.kind;
        }
        return BeatParser.jj_ntk = BeatParser.jj_nt.kind;
    }
    
    private static final void jj_add_error_token(final int n, final int jj_endpos) {
        if (jj_endpos >= 100) {
            return;
        }
        if (jj_endpos == BeatParser.jj_endpos + 1) {
            BeatParser.jj_lasttokens[BeatParser.jj_endpos++] = n;
        }
        else if (BeatParser.jj_endpos != 0) {
            BeatParser.jj_expentry = new int[BeatParser.jj_endpos];
            for (int i = 0; i < BeatParser.jj_endpos; ++i) {
                BeatParser.jj_expentry[i] = BeatParser.jj_lasttokens[i];
            }
            boolean b = false;
            final Enumeration<int[]> elements = (Enumeration<int[]>)BeatParser.jj_expentries.elements();
            while (elements.hasMoreElements()) {
                final int[] array = elements.nextElement();
                if (array.length == BeatParser.jj_expentry.length) {
                    b = true;
                    for (int j = 0; j < BeatParser.jj_expentry.length; ++j) {
                        if (array[j] != BeatParser.jj_expentry[j]) {
                            b = false;
                            break;
                        }
                    }
                    if (b) {
                        break;
                    }
                    continue;
                }
            }
            if (!b) {
                BeatParser.jj_expentries.addElement(BeatParser.jj_expentry);
            }
            if (jj_endpos != 0) {
                BeatParser.jj_lasttokens[(BeatParser.jj_endpos = jj_endpos) - 1] = n;
            }
        }
    }
    
    public static ParseException generateParseException() {
        BeatParser.jj_expentries.removeAllElements();
        final boolean[] array = new boolean[138];
        for (int i = 0; i < 138; ++i) {
            array[i] = false;
        }
        if (BeatParser.jj_kind >= 0) {
            array[BeatParser.jj_kind] = true;
            BeatParser.jj_kind = -1;
        }
        for (int j = 0; j < 146; ++j) {
            if (BeatParser.jj_la1[j] == BeatParser.jj_gen) {
                for (int k = 0; k < 32; ++k) {
                    if ((BeatParser.jj_la1_0[j] & 1 << k) != 0x0) {
                        array[k] = true;
                    }
                    if ((BeatParser.jj_la1_1[j] & 1 << k) != 0x0) {
                        array[32 + k] = true;
                    }
                    if ((BeatParser.jj_la1_2[j] & 1 << k) != 0x0) {
                        array[64 + k] = true;
                    }
                    if ((BeatParser.jj_la1_3[j] & 1 << k) != 0x0) {
                        array[96 + k] = true;
                    }
                    if ((BeatParser.jj_la1_4[j] & 1 << k) != 0x0) {
                        array[128 + k] = true;
                    }
                }
            }
        }
        for (int l = 0; l < 138; ++l) {
            if (array[l]) {
                (BeatParser.jj_expentry = new int[1])[0] = l;
                BeatParser.jj_expentries.addElement(BeatParser.jj_expentry);
            }
        }
        BeatParser.jj_endpos = 0;
        jj_rescan_token();
        jj_add_error_token(0, 0);
        final int[][] array2 = new int[BeatParser.jj_expentries.size()][];
        for (int n = 0; n < BeatParser.jj_expentries.size(); ++n) {
            array2[n] = (int[])BeatParser.jj_expentries.elementAt(n);
        }
        return new ParseException(BeatParser.token, array2, BeatParser.tokenImage);
    }
    
    public static final void enable_tracing() {
    }
    
    public static final void disable_tracing() {
    }
    
    private static final void jj_rescan_token() {
        BeatParser.jj_rescan = true;
        for (int i = 0; i < 34; ++i) {
            JJCalls next = BeatParser.jj_2_rtns[i];
            do {
                if (next.gen > BeatParser.jj_gen) {
                    BeatParser.jj_la = next.arg;
                    BeatParser.jj_lastpos = (BeatParser.jj_scanpos = next.first);
                    switch (i) {
                        case 0: {
                            jj_3_1();
                            break;
                        }
                        case 1: {
                            jj_3_2();
                            break;
                        }
                        case 2: {
                            jj_3_3();
                            break;
                        }
                        case 3: {
                            jj_3_4();
                            break;
                        }
                        case 4: {
                            jj_3_5();
                            break;
                        }
                        case 5: {
                            jj_3_6();
                            break;
                        }
                        case 6: {
                            jj_3_7();
                            break;
                        }
                        case 7: {
                            jj_3_8();
                            break;
                        }
                        case 8: {
                            jj_3_9();
                            break;
                        }
                        case 9: {
                            jj_3_10();
                            break;
                        }
                        case 10: {
                            jj_3_11();
                            break;
                        }
                        case 11: {
                            jj_3_12();
                            break;
                        }
                        case 12: {
                            jj_3_13();
                            break;
                        }
                        case 13: {
                            jj_3_14();
                            break;
                        }
                        case 14: {
                            jj_3_15();
                            break;
                        }
                        case 15: {
                            jj_3_16();
                            break;
                        }
                        case 16: {
                            jj_3_17();
                            break;
                        }
                        case 17: {
                            jj_3_18();
                            break;
                        }
                        case 18: {
                            jj_3_19();
                            break;
                        }
                        case 19: {
                            jj_3_20();
                            break;
                        }
                        case 20: {
                            jj_3_21();
                            break;
                        }
                        case 21: {
                            jj_3_22();
                            break;
                        }
                        case 22: {
                            jj_3_23();
                            break;
                        }
                        case 23: {
                            jj_3_24();
                            break;
                        }
                        case 24: {
                            jj_3_25();
                            break;
                        }
                        case 25: {
                            jj_3_26();
                            break;
                        }
                        case 26: {
                            jj_3_27();
                            break;
                        }
                        case 27: {
                            jj_3_28();
                            break;
                        }
                        case 28: {
                            jj_3_29();
                            break;
                        }
                        case 29: {
                            jj_3_30();
                            break;
                        }
                        case 30: {
                            jj_3_31();
                            break;
                        }
                        case 31: {
                            jj_3_32();
                            break;
                        }
                        case 32: {
                            jj_3_33();
                            break;
                        }
                        case 33: {
                            jj_3_34();
                            break;
                        }
                    }
                }
                next = next.next;
            } while (next != null);
        }
        BeatParser.jj_rescan = false;
    }
    
    private static final void jj_save(final int n, final int arg) {
        JJCalls next;
        for (next = BeatParser.jj_2_rtns[n]; next.gen > BeatParser.jj_gen; next = next.next) {
            if (next.next == null) {
                final JJCalls jjCalls = next;
                final JJCalls next2 = new JJCalls();
                jjCalls.next = next2;
                next = next2;
                break;
            }
        }
        next.gen = BeatParser.jj_gen + arg - BeatParser.jj_la;
        next.first = BeatParser.token;
        next.arg = arg;
    }
    
    public BeatParser(final InputStream inputStream) {
        if (BeatParser.jj_initialized_once) {
            System.out.println("ERROR: Second call to constructor of static parser.  You must");
            System.out.println("       either use ReInit() or set the JavaCC option STATIC to false");
            System.out.println("       during parser generation.");
            throw new Error();
        }
        BeatParser.jj_initialized_once = true;
        BeatParser.jj_input_stream = new JavaCharStream(inputStream, 1, 1);
        BeatParser.token_source = new BeatParserTokenManager(BeatParser.jj_input_stream);
        BeatParser.token = new Token();
        BeatParser.jj_ntk = -1;
        BeatParser.jj_gen = 0;
        for (int i = 0; i < 146; ++i) {
            BeatParser.jj_la1[i] = -1;
        }
        for (int j = 0; j < BeatParser.jj_2_rtns.length; ++j) {
            BeatParser.jj_2_rtns[j] = new JJCalls();
        }
    }
    
    public BeatParser(final Reader reader) {
        if (BeatParser.jj_initialized_once) {
            System.out.println("ERROR: Second call to constructor of static parser.  You must");
            System.out.println("       either use ReInit() or set the JavaCC option STATIC to false");
            System.out.println("       during parser generation.");
            throw new Error();
        }
        BeatParser.jj_initialized_once = true;
        BeatParser.jj_input_stream = new JavaCharStream(reader, 1, 1);
        BeatParser.token_source = new BeatParserTokenManager(BeatParser.jj_input_stream);
        BeatParser.token = new Token();
        BeatParser.jj_ntk = -1;
        BeatParser.jj_gen = 0;
        for (int i = 0; i < 146; ++i) {
            BeatParser.jj_la1[i] = -1;
        }
        for (int j = 0; j < BeatParser.jj_2_rtns.length; ++j) {
            BeatParser.jj_2_rtns[j] = new JJCalls();
        }
    }
    
    public BeatParser(final BeatParserTokenManager token_source) {
        if (BeatParser.jj_initialized_once) {
            System.out.println("ERROR: Second call to constructor of static parser.  You must");
            System.out.println("       either use ReInit() or set the JavaCC option STATIC to false");
            System.out.println("       during parser generation.");
            throw new Error();
        }
        BeatParser.jj_initialized_once = true;
        BeatParser.token_source = token_source;
        BeatParser.token = new Token();
        BeatParser.jj_ntk = -1;
        BeatParser.jj_gen = 0;
        for (int i = 0; i < 146; ++i) {
            BeatParser.jj_la1[i] = -1;
        }
        for (int j = 0; j < BeatParser.jj_2_rtns.length; ++j) {
            BeatParser.jj_2_rtns[j] = new JJCalls();
        }
    }
    
    static {
        BeatParser.jjtree = new JJTBeatParserState();
        BeatParser.jj_initialized_once = false;
        BeatParser.lookingAhead = false;
        jj_la1 = new int[146];
        jj_la1_0();
        jj_la1_1();
        jj_la1_2();
        jj_la1_3();
        jj_la1_4();
        jj_2_rtns = new JJCalls[34];
        BeatParser.jj_rescan = false;
        BeatParser.jj_gc = 0;
        jj_ls = new LookaheadSuccess();
        BeatParser.jj_expentries = new Vector();
        BeatParser.jj_kind = -1;
        BeatParser.jj_lasttokens = new int[100];
    }
    
    private static final class LookaheadSuccess extends Error
    {
    }
    
    static final class JJCalls
    {
        int gen;
        Token first;
        int arg;
        JJCalls next;
    }
}
