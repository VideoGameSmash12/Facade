package TemplateCompiler;

import java.io.InputStream;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.StringWriter;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Collection;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Deflater;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.Reader;
import java.io.FileReader;
import java.io.File;
import java.io.FileWriter;
import java.util.Vector;
import java.io.BufferedReader;
import java.util.Hashtable;
import java.util.HashSet;

public class NLU implements NLUTreeConstants, NLUConstants
{
    protected static JJTNLUState jjtree;
    public static int count;
    public static int flag;
    public static HashSet templateNames;
    public static HashSet templateNamesForBeat;
    public static HashSet beatNames;
    public static HashSet consts;
    public static HashSet compiled;
    public static HashSet initialFiles;
    public static HashSet retractThese;
    public static Hashtable templateNameToTemplate;
    public static Hashtable beatNameToTemplateName;
    public static Hashtable beatNameToIncludes;
    public static Hashtable fileNameToTemplates;
    public static Hashtable beatNameToFileName;
    private static BufferedReader in;
    public static String currentbeat;
    public static String currentfile;
    public static int salience;
    static boolean generateRuleRetractionRules;
    static String startDependency;
    static String endDependency;
    private static boolean jj_initialized_once;
    public static NLUTokenManager token_source;
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
        ((SimpleNode)node).firstToken = getToken(1);
    }
    
    static void jjtreeCloseNodeScope(final Node node) {
        ((SimpleNode)node).lastToken = getToken(0);
    }
    
    public static void usage() {
        System.out.println("The command line options are:");
        System.out.println("<filename> -o <rule object file> -m <rule map file> \n\n");
        System.exit(0);
    }
    
    public static void Preprocess(final FileWriter fileWriter, final Vector vector) throws IOException {
        if (!vector.isEmpty()) {
            final File file = new File(vector.remove(0));
            final BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            fileWriter.write("%fromfile " + file.getAbsolutePath() + '\n');
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                final StringTokenizer stringTokenizer = new StringTokenizer(line);
                if (stringTokenizer.hasMoreTokens()) {
                    if (stringTokenizer.nextToken().equals("include")) {
                        final File file2 = new File(stringTokenizer.nextToken());
                        final String absolutePath = file2.getAbsolutePath();
                        if (!NLU.compiled.contains(absolutePath)) {
                            vector.addElement(absolutePath);
                            NLU.compiled.add(absolutePath);
                        }
                        fileWriter.write("include " + file2.getAbsolutePath() + '\n');
                    }
                    else {
                        fileWriter.write(line + '\n');
                    }
                }
                else {
                    fileWriter.write(line + '\n');
                }
            }
            final char[] array = new char[4096];
            for (int i = 0; i < 4096; ++i) {
                array[i] = ' ';
            }
            fileWriter.write("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
            if (!vector.isEmpty()) {
                fileWriter.write(array);
            }
            fileWriter.write("\n");
            Preprocess(fileWriter, vector);
        }
    }
    
    public static void main(final String[] array) throws ParseException, IOException, CompileException {
        final Vector<String> vector = new Vector<String>();
        String s = "default.rul";
        String s2 = "default.map";
        boolean b = true;
        if (array.length < 5) {
            usage();
        }
        for (int i = 0; i < array.length; ++i) {
            if (array[i].equals("-o")) {
                s = array[++i];
            }
            else if (array[i].equals("-m")) {
                s2 = array[++i];
            }
            else if (array[i].equals("-noBeatSwitch")) {
                NLU.generateRuleRetractionRules = false;
            }
            else if (array[i].equals("-noDep")) {
                NLU.startDependency = "";
                NLU.endDependency = "";
            }
            else if (array[i].equals("-nobin")) {
                b = false;
            }
            else {
                final String absolutePath = new File(array[i]).getAbsolutePath();
                vector.addElement(absolutePath);
                NLU.compiled.add(absolutePath);
                NLU.initialFiles.add(absolutePath);
            }
        }
        System.out.println("Writing mapping to " + s2);
        System.out.println("Writing rules to " + s);
        final FileOutputStream fileOutputStream = new FileOutputStream(s);
        final FileOutputStream fileOutputStream2 = new FileOutputStream(s2);
        final FileWriter fileWriter = new FileWriter(new File("TEMPORARY"));
        ObjectOutputStream objectOutputStream;
        ObjectOutputStream objectOutputStream2;
        if (b) {
            final DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(fileOutputStream, new Deflater(1));
            final DeflaterOutputStream deflaterOutputStream2 = new DeflaterOutputStream(fileOutputStream2, new Deflater(1));
            objectOutputStream = new ObjectOutputStream(deflaterOutputStream);
            objectOutputStream2 = new ObjectOutputStream(deflaterOutputStream2);
        }
        else {
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream2 = new ObjectOutputStream(fileOutputStream2);
        }
        Preprocess(fileWriter, vector);
        fileWriter.flush();
        NLU.in = new BufferedReader(new FileReader("TEMPORARY"));
        final NLU nlu = new NLU(NLU.in);
        NLU.count = 0;
        NLU.flag = 0;
        TopLevel();
        while (NLU.in.ready()) {
            ReInit(NLU.in);
            NLU.count = 0;
            NLU.flag = 0;
            TopLevel();
        }
        boolean b2 = true;
        while (b2) {
            b2 = false;
            for (final String s3 : NLU.beatNames) {
                final HashSet<String> set = NLU.beatNameToIncludes.get(s3);
                if (set == null) {
                    continue;
                }
                final Iterator<String> iterator2 = set.iterator();
                while (iterator2.hasNext()) {
                    final HashSet<?> set2 = NLU.fileNameToTemplates.get(iterator2.next());
                    HashSet<?> set3 = NLU.beatNameToTemplateName.get(s3);
                    if (set3 == null) {
                        set3 = new HashSet<Object>();
                    }
                    final int size = set3.size();
                    set3.addAll(set2);
                    if (set3.size() - size > 0) {
                        NLU.beatNameToTemplateName.put(s3, set3);
                        final String s4 = NLU.beatNameToFileName.get(s3);
                        final HashSet set4 = NLU.fileNameToTemplates.get(s4);
                        set4.addAll(set2);
                        NLU.fileNameToTemplates.put(s4, set4);
                        b2 = true;
                    }
                }
            }
        }
        final Enumeration<String> keys = NLU.beatNameToTemplateName.keys();
        while (keys.hasMoreElements()) {
            final String s5 = keys.nextElement();
            if (s5.startsWith("_FILE_")) {
                NLU.beatNameToTemplateName.remove(s5);
            }
        }
        NLU.templateNameToTemplate.put("_CONST", NLU.consts);
        objectOutputStream.writeObject(NLU.templateNameToTemplate);
        objectOutputStream2.writeObject(NLU.beatNameToTemplateName);
        objectOutputStream.flush();
        objectOutputStream2.flush();
        objectOutputStream.close();
        objectOutputStream2.close();
        ASTJessRule.printIDKeysToFile("keyfile");
    }
    
    public static final void TopLevel() throws ParseException {
        final ASTTopLevel astTopLevel = new ASTTopLevel(0);
        int n = 1;
        NLU.jjtree.openNodeScope(astTopLevel);
        jjtreeOpenNodeScope(astTopLevel);
        try {
            IncludeFile();
            if (jj_2_1(2)) {
                BeatLevel();
            }
            else {
                switch ((NLU.jj_ntk == -1) ? jj_ntk() : NLU.jj_ntk) {
                    case 0: {
                        NonBeatLevel();
                        break;
                    }
                    default: {
                        NLU.jj_la1[0] = NLU.jj_gen;
                        jj_consume_token(-1);
                        throw new ParseException();
                    }
                }
            }
            jj_consume_token(28);
            NLU.jjtree.closeNodeScope(astTopLevel, true);
            n = 0;
            jjtreeCloseNodeScope(astTopLevel);
            NLU.fileNameToTemplates.put(NLU.currentfile, NLU.templateNames.clone());
            NLU.templateNames.clear();
        }
        catch (Throwable t) {
            if (n != 0) {
                NLU.jjtree.clearNodeScope(astTopLevel);
                n = 0;
            }
            else {
                NLU.jjtree.popNode();
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
                NLU.jjtree.closeNodeScope(astTopLevel, true);
                jjtreeCloseNodeScope(astTopLevel);
            }
        }
        if (n != 0) {
            NLU.jjtree.closeNodeScope(astTopLevel, true);
            jjtreeCloseNodeScope(astTopLevel);
        }
    }
    
    public static final void IncludeFile() throws ParseException {
        jj_consume_token(18);
        NLU.currentfile = FileName();
        if (!NLU.initialFiles.contains(NLU.currentfile)) {
            throw new CompileException(getToken(0).endLine - 1, "File " + NLU.currentfile + " was included. But it contains a beat called: " + NLU.currentbeat);
        }
        System.out.println("Compiling: " + NLU.currentfile);
    }
    
    public static final String FileName() throws ParseException {
        final String name = Name();
        jj_consume_token(23);
        jj_consume_token(30);
        return name + ':' + getToken(0).image;
    }
    
    public static final String Name() throws ParseException {
        jj_consume_token(29);
        return getToken(0).image;
    }
    
    public static final void Include() throws ParseException {
        final ASTInclude astInclude = new ASTInclude(2);
        int n = 1;
        NLU.jjtree.openNodeScope(astInclude);
        jjtreeOpenNodeScope(astInclude);
        try {
            jj_consume_token(19);
            final String fileName = FileName();
            NLU.jjtree.closeNodeScope(astInclude, true);
            n = 0;
            jjtreeCloseNodeScope(astInclude);
            HashSet<String> set = NLU.beatNameToIncludes.get(NLU.currentbeat);
            if (set == null) {
                set = new HashSet<String>();
            }
            set.add(fileName);
            NLU.beatNameToIncludes.put(NLU.currentbeat, set);
        }
        catch (Throwable t) {
            if (n != 0) {
                NLU.jjtree.clearNodeScope(astInclude);
                n = 0;
            }
            else {
                NLU.jjtree.popNode();
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
                NLU.jjtree.closeNodeScope(astInclude, true);
                jjtreeCloseNodeScope(astInclude);
            }
        }
        if (n != 0) {
            NLU.jjtree.closeNodeScope(astInclude, true);
            jjtreeCloseNodeScope(astInclude);
        }
    }
    
    public static final void NonBeatLevel() throws ParseException {
        while (true) {
            if (jj_2_2(2)) {
                JessRule();
            }
            else if (jj_2_3(2)) {
                TypeDef();
            }
            else {
                switch ((NLU.jj_ntk == -1) ? jj_ntk() : NLU.jj_ntk) {
                    case 13: {
                        MapDef();
                        break;
                    }
                    default: {
                        NLU.jj_la1[1] = NLU.jj_gen;
                        jj_consume_token(-1);
                        throw new ParseException();
                    }
                }
            }
            switch ((NLU.jj_ntk == -1) ? jj_ntk() : NLU.jj_ntk) {
                case 13: {
                    continue;
                }
                default: {
                    NLU.jj_la1[2] = NLU.jj_gen;
                    NLU.currentbeat = "_FILE_" + NLU.currentfile;
                    NLU.beatNames.add(NLU.currentbeat);
                    NLU.beatNameToTemplateName.put(NLU.currentbeat, NLU.templateNamesForBeat.clone());
                    NLU.beatNameToFileName.put(NLU.currentbeat, NLU.currentfile);
                    NLU.templateNamesForBeat.clear();
                }
            }
        }
    }
    
    public static final void BeatLevel() throws ParseException {
    Label_0000:
        while (true) {
            while (true) {
                jj_consume_token(13);
                jj_consume_token(11);
                NLU.currentbeat = Name();
                while (true) {
                    switch ((NLU.jj_ntk == -1) ? jj_ntk() : NLU.jj_ntk) {
                        case 13:
                        case 19: {
                            if (jj_2_4(2)) {
                                Include();
                            }
                            else if (jj_2_5(2)) {
                                JessRule();
                            }
                            else if (jj_2_6(2)) {
                                TypeDef();
                            }
                            else {
                                switch ((NLU.jj_ntk == -1) ? jj_ntk() : NLU.jj_ntk) {
                                    case 13: {
                                        MapDef();
                                        continue;
                                    }
                                    default: {
                                        NLU.jj_la1[4] = NLU.jj_gen;
                                        jj_consume_token(-1);
                                        throw new ParseException();
                                    }
                                }
                            }
                            continue;
                        }
                        default: {
                            NLU.jj_la1[3] = NLU.jj_gen;
                            jj_consume_token(14);
                            System.out.println("Compiled Beat: " + NLU.currentbeat);
                            NLU.beatNames.add(NLU.currentbeat);
                            NLU.beatNameToTemplateName.put(NLU.currentbeat, NLU.templateNamesForBeat.clone());
                            NLU.beatNameToFileName.put(NLU.currentbeat, NLU.currentfile);
                            NLU.templateNamesForBeat.clear();
                            switch ((NLU.jj_ntk == -1) ? jj_ntk() : NLU.jj_ntk) {
                                case 13: {
                                    continue Label_0000;
                                }
                                default: {
                                    NLU.jj_la1[5] = NLU.jj_gen;
                                    return;
                                }
                            }
                            break;
                        }
                    }
                }
            }
            break;
        }
    }
    
    public static final ASTStart TemplateTopLevel() throws ParseException {
        final ASTStart astStart = new ASTStart(3);
        int n = 1;
        NLU.jjtree.openNodeScope(astStart);
        jjtreeOpenNodeScope(astStart);
        try {
            jj_consume_token(13);
            jj_consume_token(7);
            Template();
            NLUTokenManager.SwitchTo(0);
            jj_consume_token(14);
            NLU.jjtree.closeNodeScope(astStart, true);
            n = 0;
            jjtreeCloseNodeScope(astStart);
            return astStart;
        }
        catch (Throwable t) {
            if (n != 0) {
                NLU.jjtree.clearNodeScope(astStart);
                n = 0;
            }
            else {
                NLU.jjtree.popNode();
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
                NLU.jjtree.closeNodeScope(astStart, true);
                jjtreeCloseNodeScope(astStart);
            }
        }
    }
    
    public static final void Declare() throws ParseException {
        final ASTDeclare astDeclare = new ASTDeclare(4);
        final boolean b = true;
        NLU.jjtree.openNodeScope(astDeclare);
        jjtreeOpenNodeScope(astDeclare);
        Label_0143: {
            try {
                while (true) {
                    jj_consume_token(13);
                    jj_consume_token(29);
                    jj_consume_token(29);
                    jj_consume_token(14);
                    switch ((NLU.jj_ntk == -1) ? jj_ntk() : NLU.jj_ntk) {
                        case 0: {
                            continue;
                        }
                        default: {
                            NLU.jj_la1[6] = NLU.jj_gen;
                            break Label_0143;
                        }
                    }
                }
            }
            finally {
                if (b) {
                    NLU.jjtree.closeNodeScope(astDeclare, true);
                    jjtreeCloseNodeScope(astDeclare);
                }
            }
        }
        if (b) {
            NLU.jjtree.closeNodeScope(astDeclare, true);
            jjtreeCloseNodeScope(astDeclare);
        }
    }
    
    public static final void DeclareTop() throws ParseException {
        jj_consume_token(13);
        jj_consume_token(12);
        Declare();
        jj_consume_token(14);
    }
    
    public static final void JessRule() throws ParseException {
        final ASTJessRule astJessRule = new ASTJessRule(5);
        int n = 1;
        NLU.jjtree.openNodeScope(astJessRule);
        jjtreeOpenNodeScope(astJessRule);
        final StringWriter stringWriter = new StringWriter();
        final BufferedWriter bufferedWriter = new BufferedWriter(stringWriter);
        ASTStart templateTopLevel = null;
        final StringWriter stringWriter2 = new StringWriter();
        final BufferedWriter bufferedWriter2 = new BufferedWriter(stringWriter2);
        Label_0710: {
            try {
                jj_consume_token(13);
                jj_consume_token(8);
                final String name = Name();
                if (jj_2_7(2)) {
                    DeclareTop();
                }
                while (true) {
                    if (jj_2_8(2)) {
                        templateTopLevel = TemplateTopLevel();
                    }
                    else {
                        switch ((NLU.jj_ntk == -1) ? jj_ntk() : NLU.jj_ntk) {
                            case 0:
                            case 12:
                            case 16: {
                                LHside();
                                break;
                            }
                            default: {
                                NLU.jj_la1[7] = NLU.jj_gen;
                                jj_consume_token(-1);
                                throw new ParseException();
                            }
                        }
                    }
                    switch ((NLU.jj_ntk == -1) ? jj_ntk() : NLU.jj_ntk) {
                        case 0:
                        case 12:
                        case 16: {
                            continue;
                        }
                        default: {
                            NLU.jj_la1[8] = NLU.jj_gen;
                            jj_consume_token(26);
                            while (true) {
                                RHside();
                                switch ((NLU.jj_ntk == -1) ? jj_ntk() : NLU.jj_ntk) {
                                    case 0: {
                                        continue;
                                    }
                                    default: {
                                        NLU.jj_la1[9] = NLU.jj_gen;
                                        jj_consume_token(14);
                                        NLU.jjtree.closeNodeScope(astJessRule, true);
                                        n = 0;
                                        jjtreeCloseNodeScope(astJessRule);
                                        final StringWriter stringWriter3 = new StringWriter();
                                        final StringWriter stringWriter4 = new StringWriter();
                                        NLU.salience = 50;
                                        final int handleDeclare = astJessRule.handleDeclare(bufferedWriter2);
                                        if (templateTopLevel != null) {
                                            templateTopLevel.compileToplevel(stringWriter3, stringWriter4, bufferedWriter, null);
                                            bufferedWriter.flush();
                                        }
                                        astJessRule.compileToJessRule(stringWriter3.getBuffer().toString(), stringWriter4.getBuffer().toString(), bufferedWriter2, handleDeclare);
                                        bufferedWriter2.write(stringWriter.getBuffer().toString());
                                        bufferedWriter2.flush();
                                        if (NLU.templateNameToTemplate.get(name) != null) {
                                            throw new CompileException(getToken(0).endLine - 1, "Attempt to redefine rule " + name);
                                        }
                                        NLU.templateNameToTemplate.put(name, stringWriter2.getBuffer().toString());
                                        NLU.templateNames.add(name);
                                        NLU.templateNamesForBeat.add(name);
                                        break Label_0710;
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
                    NLU.jjtree.clearNodeScope(astJessRule);
                    n = 0;
                }
                else {
                    NLU.jjtree.popNode();
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
                    NLU.jjtree.closeNodeScope(astJessRule, true);
                    jjtreeCloseNodeScope(astJessRule);
                }
            }
        }
        if (n != 0) {
            NLU.jjtree.closeNodeScope(astJessRule, true);
            jjtreeCloseNodeScope(astJessRule);
        }
    }
    
    public static final void TypeDefOr() throws ParseException {
        final ASTTypeDefOr astTypeDefOr = new ASTTypeDefOr(6);
        int n = 1;
        NLU.jjtree.openNodeScope(astTypeDefOr);
        jjtreeOpenNodeScope(astTypeDefOr);
        Label_0204: {
            try {
                jj_consume_token(13);
                TypeDefArg();
                while (true) {
                    jj_consume_token(17);
                    TypeDefArg();
                    switch ((NLU.jj_ntk == -1) ? jj_ntk() : NLU.jj_ntk) {
                        case 0: {
                            continue;
                        }
                        default: {
                            NLU.jj_la1[10] = NLU.jj_gen;
                            jj_consume_token(14);
                            break Label_0204;
                        }
                    }
                }
            }
            catch (Throwable t) {
                if (n != 0) {
                    NLU.jjtree.clearNodeScope(astTypeDefOr);
                    n = 0;
                }
                else {
                    NLU.jjtree.popNode();
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
                    NLU.jjtree.closeNodeScope(astTypeDefOr, true);
                    jjtreeCloseNodeScope(astTypeDefOr);
                }
            }
        }
        if (n != 0) {
            NLU.jjtree.closeNodeScope(astTypeDefOr, true);
            jjtreeCloseNodeScope(astTypeDefOr);
        }
    }
    
    public static final void TypeDefArg() throws ParseException {
        final ASTTypeDefArg astTypeDefArg = new ASTTypeDefArg(7);
        final boolean b = true;
        NLU.jjtree.openNodeScope(astTypeDefArg);
        jjtreeOpenNodeScope(astTypeDefArg);
        try {
            switch ((NLU.jj_ntk == -1) ? jj_ntk() : NLU.jj_ntk) {
                case 0: {
                    jj_consume_token(29);
                    break;
                }
                case 16: {
                    jj_consume_token(45);
                    break;
                }
                default: {
                    NLU.jj_la1[11] = NLU.jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
                }
            }
        }
        finally {
            if (b) {
                NLU.jjtree.closeNodeScope(astTypeDefArg, true);
                jjtreeCloseNodeScope(astTypeDefArg);
            }
        }
        if (b) {
            NLU.jjtree.closeNodeScope(astTypeDefArg, true);
            jjtreeCloseNodeScope(astTypeDefArg);
        }
    }
    
    public static final void TypeDef() throws ParseException {
        final ASTTypeDef astTypeDef = new ASTTypeDef(8);
        int n = 1;
        NLU.jjtree.openNodeScope(astTypeDef);
        jjtreeOpenNodeScope(astTypeDef);
        Label_0545: {
            try {
                jj_consume_token(13);
                jj_consume_token(10);
                jj_consume_token(29);
                while (true) {
                    switch ((NLU.jj_ntk == -1) ? jj_ntk() : NLU.jj_ntk) {
                        case 0:
                        case 16:
                        case 32: {
                            switch ((NLU.jj_ntk == -1) ? jj_ntk() : NLU.jj_ntk) {
                                case 0: {
                                    TypeDefOr();
                                    continue;
                                }
                                case 16:
                                case 32: {
                                    TypeDefArg();
                                    continue;
                                }
                                default: {
                                    NLU.jj_la1[13] = NLU.jj_gen;
                                    jj_consume_token(-1);
                                    throw new ParseException();
                                }
                            }
                            continue;
                        }
                        default: {
                            NLU.jj_la1[12] = NLU.jj_gen;
                            jj_consume_token(14);
                            NLU.jjtree.closeNodeScope(astTypeDef, true);
                            n = 0;
                            jjtreeCloseNodeScope(astTypeDef);
                            astTypeDef.AddToList();
                            break Label_0545;
                        }
                    }
                }
            }
            catch (Throwable t) {
                if (n != 0) {
                    NLU.jjtree.clearNodeScope(astTypeDef);
                    n = 0;
                }
                else {
                    NLU.jjtree.popNode();
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
                    NLU.jjtree.closeNodeScope(astTypeDef, true);
                    jjtreeCloseNodeScope(astTypeDef);
                }
            }
        }
        if (n != 0) {
            NLU.jjtree.closeNodeScope(astTypeDef, true);
            jjtreeCloseNodeScope(astTypeDef);
        }
    }
    
    public static final void MapDef() throws ParseException {
        final ASTMapDef astMapDef = new ASTMapDef(9);
        boolean b = true;
        NLU.jjtree.openNodeScope(astMapDef);
        jjtreeOpenNodeScope(astMapDef);
        try {
            jj_consume_token(13);
            jj_consume_token(9);
            jj_consume_token(29);
            jj_consume_token(29);
            jj_consume_token(14);
            NLU.jjtree.closeNodeScope(astMapDef, true);
            b = false;
            jjtreeCloseNodeScope(astMapDef);
            astMapDef.AddDef(NLU.consts);
        }
        finally {
            if (b) {
                NLU.jjtree.closeNodeScope(astMapDef, true);
                jjtreeCloseNodeScope(astMapDef);
            }
        }
        if (b) {
            NLU.jjtree.closeNodeScope(astMapDef, true);
            jjtreeCloseNodeScope(astMapDef);
        }
    }
    
    public static final void LHside() throws ParseException {
        final ASTLHside astlHside = new ASTLHside(10);
        int n = 1;
        NLU.jjtree.openNodeScope(astlHside);
        jjtreeOpenNodeScope(astlHside);
        try {
            Label_1045: {
                if (jj_2_14(2)) {
                    jj_consume_token(13);
                Label_0036:
                    while (true) {
                        while (true) {
                            jj_consume_token(29);
                            while (true) {
                                switch ((NLU.jj_ntk == -1) ? jj_ntk() : NLU.jj_ntk) {
                                    case 0: {
                                        jj_consume_token(24);
                                        jj_consume_token(23);
                                        LHside();
                                        continue;
                                    }
                                    default: {
                                        NLU.jj_la1[14] = NLU.jj_gen;
                                        if (!jj_2_9(2)) {
                                            break Label_0036;
                                        }
                                        continue Label_0036;
                                    }
                                }
                            }
                        }
                        break;
                    }
                    while (true) {
                        switch ((NLU.jj_ntk == -1) ? jj_ntk() : NLU.jj_ntk) {
                            case 0:
                            case 12:
                            case 16: {
                                LHside();
                                continue;
                            }
                            default: {
                                NLU.jj_la1[15] = NLU.jj_gen;
                                jj_consume_token(14);
                                break Label_1045;
                            }
                        }
                    }
                }
                else {
                    switch ((NLU.jj_ntk == -1) ? jj_ntk() : NLU.jj_ntk) {
                        case 0: {
                            jj_consume_token(29);
                            jj_consume_token(27);
                            LHside();
                            break;
                        }
                        default: {
                            NLU.jj_la1[22] = NLU.jj_gen;
                            if (jj_2_15(2)) {
                                jj_consume_token(13);
                                jj_consume_token(20);
                                LHside();
                                while (true) {
                                    LHside();
                                    switch ((NLU.jj_ntk == -1) ? jj_ntk() : NLU.jj_ntk) {
                                        case 0:
                                        case 12:
                                        case 16: {
                                            continue;
                                        }
                                        default: {
                                            NLU.jj_la1[16] = NLU.jj_gen;
                                            jj_consume_token(14);
                                            break Label_1045;
                                        }
                                    }
                                }
                            }
                            else if (jj_2_16(2)) {
                                jj_consume_token(13);
                                jj_consume_token(21);
                                LHside();
                                while (true) {
                                    LHside();
                                    switch ((NLU.jj_ntk == -1) ? jj_ntk() : NLU.jj_ntk) {
                                        case 0:
                                        case 12:
                                        case 16: {
                                            continue;
                                        }
                                        default: {
                                            NLU.jj_la1[17] = NLU.jj_gen;
                                            jj_consume_token(14);
                                            break Label_1045;
                                        }
                                    }
                                }
                            }
                            else {
                                if (jj_2_17(2)) {
                                    jj_consume_token(13);
                                    jj_consume_token(25);
                                    if (jj_2_10(2)) {
                                        LHside();
                                    }
                                    else {
                                        switch ((NLU.jj_ntk == -1) ? jj_ntk() : NLU.jj_ntk) {
                                            case 0: {
                                                jj_consume_token(29);
                                                break;
                                            }
                                            default: {
                                                NLU.jj_la1[18] = NLU.jj_gen;
                                                jj_consume_token(-1);
                                                throw new ParseException();
                                            }
                                        }
                                    }
                                    if (jj_2_11(2)) {
                                        LHside();
                                    }
                                    else {
                                        switch ((NLU.jj_ntk == -1) ? jj_ntk() : NLU.jj_ntk) {
                                            case 0: {
                                                jj_consume_token(29);
                                                break;
                                            }
                                            default: {
                                                NLU.jj_la1[19] = NLU.jj_gen;
                                                jj_consume_token(-1);
                                                throw new ParseException();
                                            }
                                        }
                                    }
                                    jj_consume_token(14);
                                    break;
                                }
                                switch ((NLU.jj_ntk == -1) ? jj_ntk() : NLU.jj_ntk) {
                                    case 0: {
                                        jj_consume_token(25);
                                        if (jj_2_12(2)) {
                                            LHside();
                                        }
                                        else {
                                            switch ((NLU.jj_ntk == -1) ? jj_ntk() : NLU.jj_ntk) {
                                                case 0: {
                                                    jj_consume_token(29);
                                                    break;
                                                }
                                                default: {
                                                    NLU.jj_la1[20] = NLU.jj_gen;
                                                    jj_consume_token(-1);
                                                    throw new ParseException();
                                                }
                                            }
                                        }
                                        if (jj_2_13(2)) {
                                            LHside();
                                        }
                                        else {
                                            switch ((NLU.jj_ntk == -1) ? jj_ntk() : NLU.jj_ntk) {
                                                case 0: {
                                                    jj_consume_token(29);
                                                    break;
                                                }
                                                default: {
                                                    NLU.jj_la1[21] = NLU.jj_gen;
                                                    jj_consume_token(-1);
                                                    throw new ParseException();
                                                }
                                            }
                                        }
                                        NLU.jjtree.closeNodeScope(astlHside, true);
                                        n = 0;
                                        jjtreeCloseNodeScope(astlHside);
                                        astlHside.typeCheck(NLU.consts);
                                        break Label_1045;
                                    }
                                    default: {
                                        NLU.jj_la1[23] = NLU.jj_gen;
                                        jj_consume_token(-1);
                                        throw new ParseException();
                                    }
                                }
                            }
                            break;
                        }
                    }
                }
            }
        }
        catch (Throwable t) {
            if (n != 0) {
                NLU.jjtree.clearNodeScope(astlHside);
                n = 0;
            }
            else {
                NLU.jjtree.popNode();
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
                NLU.jjtree.closeNodeScope(astlHside, true);
                jjtreeCloseNodeScope(astlHside);
            }
        }
        if (n != 0) {
            NLU.jjtree.closeNodeScope(astlHside, true);
            jjtreeCloseNodeScope(astlHside);
        }
    }
    
    public static final void RHside() throws ParseException {
        final ASTRHside astrHside = new ASTRHside(11);
        int n = 1;
        NLU.jjtree.openNodeScope(astrHside);
        jjtreeOpenNodeScope(astrHside);
        Label_0272: {
            try {
                jj_consume_token(13);
                while (true) {
                    jj_consume_token(29);
                    switch ((NLU.jj_ntk == -1) ? jj_ntk() : NLU.jj_ntk) {
                        case 0: {
                            continue;
                        }
                        default: {
                            NLU.jj_la1[24] = NLU.jj_gen;
                            while (true) {
                                switch ((NLU.jj_ntk == -1) ? jj_ntk() : NLU.jj_ntk) {
                                    case 0: {
                                        RHside();
                                        continue;
                                    }
                                    default: {
                                        NLU.jj_la1[25] = NLU.jj_gen;
                                        jj_consume_token(14);
                                        NLU.jjtree.closeNodeScope(astrHside, true);
                                        n = 0;
                                        jjtreeCloseNodeScope(astrHside);
                                        astrHside.typeCheck(NLU.consts);
                                        break Label_0272;
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
                    NLU.jjtree.clearNodeScope(astrHside);
                    n = 0;
                }
                else {
                    NLU.jjtree.popNode();
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
                    NLU.jjtree.closeNodeScope(astrHside, true);
                    jjtreeCloseNodeScope(astrHside);
                }
            }
        }
        if (n != 0) {
            NLU.jjtree.closeNodeScope(astrHside, true);
            jjtreeCloseNodeScope(astrHside);
        }
    }
    
    public static final int DoWeRetract() throws ParseException {
        jj_consume_token(41);
        return 1;
    }
    
    public static final void Template() throws ParseException {
        final ASTTemplate astTemplate = new ASTTemplate(12);
        int n = 1;
        NLU.jjtree.openNodeScope(astTemplate);
        jjtreeOpenNodeScope(astTemplate);
        int n2 = 0;
        try {
            if (jj_2_18(3)) {
                switch ((NLU.jj_ntk == -1) ? jj_ntk() : NLU.jj_ntk) {
                    case 0: {
                        n2 = DoWeRetract();
                        break;
                    }
                    default: {
                        NLU.jj_la1[26] = NLU.jj_gen;
                        break;
                    }
                }
                Occursexp();
            }
            else if (jj_2_19(3)) {
                switch ((NLU.jj_ntk == -1) ? jj_ntk() : NLU.jj_ntk) {
                    case 0: {
                        n2 = DoWeRetract();
                        break;
                    }
                    default: {
                        NLU.jj_la1[27] = NLU.jj_gen;
                        break;
                    }
                }
                Regexp();
            }
            else if (jj_2_20(Integer.MAX_VALUE)) {
                switch ((NLU.jj_ntk == -1) ? jj_ntk() : NLU.jj_ntk) {
                    case 0: {
                        n2 = DoWeRetract();
                        break;
                    }
                    default: {
                        NLU.jj_la1[28] = NLU.jj_gen;
                        break;
                    }
                }
                jj_consume_token(35);
                jj_consume_token(34);
                Occursexp();
                jj_consume_token(36);
            }
            else {
                switch ((NLU.jj_ntk == -1) ? jj_ntk() : NLU.jj_ntk) {
                    case 0:
                    case 6: {
                        switch ((NLU.jj_ntk == -1) ? jj_ntk() : NLU.jj_ntk) {
                            case 0: {
                                n2 = DoWeRetract();
                                break;
                            }
                            default: {
                                NLU.jj_la1[29] = NLU.jj_gen;
                                break;
                            }
                        }
                        jj_consume_token(35);
                        jj_consume_token(34);
                        Regexp();
                        jj_consume_token(36);
                        break;
                    }
                    default: {
                        NLU.jj_la1[30] = NLU.jj_gen;
                        jj_consume_token(-1);
                        throw new ParseException();
                    }
                }
            }
            NLU.jjtree.closeNodeScope(astTemplate, true);
            n = 0;
            jjtreeCloseNodeScope(astTemplate);
            if (n2 == 1) {
                astTemplate.setRetraction(true);
            }
        }
        catch (Throwable t) {
            if (n != 0) {
                NLU.jjtree.clearNodeScope(astTemplate);
                n = 0;
            }
            else {
                NLU.jjtree.popNode();
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
                NLU.jjtree.closeNodeScope(astTemplate, true);
                jjtreeCloseNodeScope(astTemplate);
            }
        }
        if (n != 0) {
            NLU.jjtree.closeNodeScope(astTemplate, true);
            jjtreeCloseNodeScope(astTemplate);
        }
    }
    
    public static final void Occursexp() throws ParseException {
        if (jj_2_21(2)) {
            Oand();
        }
        else if (jj_2_22(2)) {
            Oor();
        }
        else {
            switch ((NLU.jj_ntk == -1) ? jj_ntk() : NLU.jj_ntk) {
                case 35: {
                    Osingle();
                    break;
                }
                default: {
                    NLU.jj_la1[31] = NLU.jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
                }
            }
        }
        if (NLU.count == 0) {
            NLU.flag = 1;
        }
    }
    
    public static final void wordmatch() throws ParseException {
        final ASTWordMatch astWordMatch = new ASTWordMatch(13);
        final boolean b = true;
        NLU.jjtree.openNodeScope(astWordMatch);
        jjtreeOpenNodeScope(astWordMatch);
        try {
            switch ((NLU.jj_ntk == -1) ? jj_ntk() : NLU.jj_ntk) {
                case 0: {
                    jj_consume_token(46);
                    break;
                }
                case 7: {
                    jj_consume_token(53);
                    break;
                }
                default: {
                    NLU.jj_la1[32] = NLU.jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
                }
            }
        }
        finally {
            if (b) {
                NLU.jjtree.closeNodeScope(astWordMatch, true);
                jjtreeCloseNodeScope(astWordMatch);
            }
        }
        if (b) {
            NLU.jjtree.closeNodeScope(astWordMatch, true);
            jjtreeCloseNodeScope(astWordMatch);
        }
    }
    
    public static final void wildcardmatch() throws ParseException {
        final ASTWildMatch astWildMatch = new ASTWildMatch(14);
        final boolean b = true;
        NLU.jjtree.openNodeScope(astWildMatch);
        jjtreeOpenNodeScope(astWildMatch);
        try {
            jj_consume_token(45);
        }
        finally {
            if (b) {
                NLU.jjtree.closeNodeScope(astWildMatch, true);
                jjtreeCloseNodeScope(astWildMatch);
            }
        }
        if (b) {
            NLU.jjtree.closeNodeScope(astWildMatch, true);
            jjtreeCloseNodeScope(astWildMatch);
        }
    }
    
    public static final void TermExpand() throws ParseException {
        final ASTTermExpand astTermExpand = new ASTTermExpand(15);
        final boolean b = true;
        NLU.jjtree.openNodeScope(astTermExpand);
        jjtreeOpenNodeScope(astTermExpand);
        try {
            jj_consume_token(39);
            jj_consume_token(46);
            jj_consume_token(50);
            jj_consume_token(40);
        }
        finally {
            if (b) {
                NLU.jjtree.closeNodeScope(astTermExpand, true);
                jjtreeCloseNodeScope(astTermExpand);
            }
        }
        if (b) {
            NLU.jjtree.closeNodeScope(astTermExpand, true);
            jjtreeCloseNodeScope(astTermExpand);
        }
    }
    
    public static final void RootMatch() throws ParseException {
        final ASTRootMatch astRootMatch = new ASTRootMatch(16);
        final boolean b = true;
        NLU.jjtree.openNodeScope(astRootMatch);
        jjtreeOpenNodeScope(astRootMatch);
        try {
            jj_consume_token(39);
            jj_consume_token(46);
            jj_consume_token(51);
            jj_consume_token(40);
        }
        finally {
            if (b) {
                NLU.jjtree.closeNodeScope(astRootMatch, true);
                jjtreeCloseNodeScope(astRootMatch);
            }
        }
        if (b) {
            NLU.jjtree.closeNodeScope(astRootMatch, true);
            jjtreeCloseNodeScope(astRootMatch);
        }
    }
    
    public static final void PositionalFact() throws ParseException {
        final ASTPositional astPositional = new ASTPositional(17);
        final boolean b = true;
        NLU.jjtree.openNodeScope(astPositional);
        jjtreeOpenNodeScope(astPositional);
        Label_0258: {
            try {
                jj_consume_token(42);
                jj_consume_token(46);
                while (true) {
                    switch ((NLU.jj_ntk == -1) ? jj_ntk() : NLU.jj_ntk) {
                        case 0:
                        case 6: {
                            switch ((NLU.jj_ntk == -1) ? jj_ntk() : NLU.jj_ntk) {
                                case 6: {
                                    jj_consume_token(52);
                                    continue;
                                }
                                case 0: {
                                    jj_consume_token(46);
                                    continue;
                                }
                                default: {
                                    NLU.jj_la1[34] = NLU.jj_gen;
                                    jj_consume_token(-1);
                                    throw new ParseException();
                                }
                            }
                            continue;
                        }
                        default: {
                            NLU.jj_la1[33] = NLU.jj_gen;
                            jj_consume_token(43);
                            break Label_0258;
                        }
                    }
                }
            }
            finally {
                if (b) {
                    NLU.jjtree.closeNodeScope(astPositional, true);
                    jjtreeCloseNodeScope(astPositional);
                }
            }
        }
        if (b) {
            NLU.jjtree.closeNodeScope(astPositional, true);
            jjtreeCloseNodeScope(astPositional);
        }
    }
    
    public static final void Regexp() throws ParseException {
        Label_0250: {
            switch ((NLU.jj_ntk == -1) ? jj_ntk() : NLU.jj_ntk) {
                case 46:
                case 53: {
                    wordmatch();
                    break;
                }
                case 37: {
                    Regexpopt();
                    break;
                }
                case 42: {
                    PositionalFact();
                    break;
                }
                default: {
                    NLU.jj_la1[35] = NLU.jj_gen;
                    if (jj_2_23(Integer.MAX_VALUE)) {
                        Regexpand();
                        break;
                    }
                    switch ((NLU.jj_ntk == -1) ? jj_ntk() : NLU.jj_ntk) {
                        case 35: {
                            Regexpor();
                            break Label_0250;
                        }
                        case 45: {
                            wildcardmatch();
                            break Label_0250;
                        }
                        default: {
                            NLU.jj_la1[36] = NLU.jj_gen;
                            jj_consume_token(-1);
                            throw new ParseException();
                        }
                    }
                    break;
                }
            }
        }
    }
    
    public static final void Regexpopt() throws ParseException {
        final ASTRegexpopt astRegexpopt = new ASTRegexpopt(18);
        int n = 1;
        NLU.jjtree.openNodeScope(astRegexpopt);
        jjtreeOpenNodeScope(astRegexpopt);
        try {
            jj_consume_token(37);
            Template();
            jj_consume_token(38);
        }
        catch (Throwable t) {
            if (n != 0) {
                NLU.jjtree.clearNodeScope(astRegexpopt);
                n = 0;
            }
            else {
                NLU.jjtree.popNode();
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
                NLU.jjtree.closeNodeScope(astRegexpopt, true);
                jjtreeCloseNodeScope(astRegexpopt);
            }
        }
        if (n != 0) {
            NLU.jjtree.closeNodeScope(astRegexpopt, true);
            jjtreeCloseNodeScope(astRegexpopt);
        }
    }
    
    public static final void Regexpor() throws ParseException {
        final ASTRegexpor astRegexpor = new ASTRegexpor(19);
        int n = 1;
        NLU.jjtree.openNodeScope(astRegexpor);
        jjtreeOpenNodeScope(astRegexpor);
        Label_0204: {
            try {
                jj_consume_token(35);
                Template();
                while (true) {
                    jj_consume_token(44);
                    Template();
                    switch ((NLU.jj_ntk == -1) ? jj_ntk() : NLU.jj_ntk) {
                        case 0: {
                            continue;
                        }
                        default: {
                            NLU.jj_la1[37] = NLU.jj_gen;
                            jj_consume_token(36);
                            break Label_0204;
                        }
                    }
                }
            }
            catch (Throwable t) {
                if (n != 0) {
                    NLU.jjtree.clearNodeScope(astRegexpor);
                    n = 0;
                }
                else {
                    NLU.jjtree.popNode();
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
                    NLU.jjtree.closeNodeScope(astRegexpor, true);
                    jjtreeCloseNodeScope(astRegexpor);
                }
            }
        }
        if (n != 0) {
            NLU.jjtree.closeNodeScope(astRegexpor, true);
            jjtreeCloseNodeScope(astRegexpor);
        }
    }
    
    public static final void Regexpand() throws ParseException {
        final ASTRegexpand astRegexpand = new ASTRegexpand(20);
        int n = 1;
        NLU.jjtree.openNodeScope(astRegexpand);
        jjtreeOpenNodeScope(astRegexpand);
        Label_0271: {
            try {
                jj_consume_token(35);
                Template();
                while (true) {
                    switch ((NLU.jj_ntk == -1) ? jj_ntk() : NLU.jj_ntk) {
                        case 0:
                        case 2:
                        case 6:
                        case 7:
                        case 10:
                        case 11:
                        case 18: {
                            Template();
                            continue;
                        }
                        default: {
                            NLU.jj_la1[38] = NLU.jj_gen;
                            jj_consume_token(36);
                            break Label_0271;
                        }
                    }
                }
            }
            catch (Throwable t) {
                if (n != 0) {
                    NLU.jjtree.clearNodeScope(astRegexpand);
                    n = 0;
                }
                else {
                    NLU.jjtree.popNode();
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
                    NLU.jjtree.closeNodeScope(astRegexpand, true);
                    jjtreeCloseNodeScope(astRegexpand);
                }
            }
        }
        if (n != 0) {
            NLU.jjtree.closeNodeScope(astRegexpand, true);
            jjtreeCloseNodeScope(astRegexpand);
        }
    }
    
    public static final void Oand() throws ParseException {
        final ASTOand astOand = new ASTOand(21);
        int n = 1;
        NLU.jjtree.openNodeScope(astOand);
        jjtreeOpenNodeScope(astOand);
        Label_0276: {
            try {
                jj_consume_token(35);
                jj_consume_token(31);
                Template();
                while (true) {
                    Template();
                    switch ((NLU.jj_ntk == -1) ? jj_ntk() : NLU.jj_ntk) {
                        case 0:
                        case 2:
                        case 6:
                        case 7:
                        case 10:
                        case 11:
                        case 18: {
                            continue;
                        }
                        default: {
                            NLU.jj_la1[39] = NLU.jj_gen;
                            jj_consume_token(36);
                            break Label_0276;
                        }
                    }
                }
            }
            catch (Throwable t) {
                if (n != 0) {
                    NLU.jjtree.clearNodeScope(astOand);
                    n = 0;
                }
                else {
                    NLU.jjtree.popNode();
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
                    NLU.jjtree.closeNodeScope(astOand, true);
                    jjtreeCloseNodeScope(astOand);
                }
            }
        }
        if (n != 0) {
            NLU.jjtree.closeNodeScope(astOand, true);
            jjtreeCloseNodeScope(astOand);
        }
    }
    
    public static final void Oor() throws ParseException {
        final ASTOor astOor = new ASTOor(22);
        int n = 1;
        NLU.jjtree.openNodeScope(astOor);
        jjtreeOpenNodeScope(astOor);
        Label_0276: {
            try {
                jj_consume_token(35);
                jj_consume_token(32);
                Template();
                while (true) {
                    Template();
                    switch ((NLU.jj_ntk == -1) ? jj_ntk() : NLU.jj_ntk) {
                        case 0:
                        case 2:
                        case 6:
                        case 7:
                        case 10:
                        case 11:
                        case 18: {
                            continue;
                        }
                        default: {
                            NLU.jj_la1[40] = NLU.jj_gen;
                            jj_consume_token(36);
                            break Label_0276;
                        }
                    }
                }
            }
            catch (Throwable t) {
                if (n != 0) {
                    NLU.jjtree.clearNodeScope(astOor);
                    n = 0;
                }
                else {
                    NLU.jjtree.popNode();
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
                    NLU.jjtree.closeNodeScope(astOor, true);
                    jjtreeCloseNodeScope(astOor);
                }
            }
        }
        if (n != 0) {
            NLU.jjtree.closeNodeScope(astOor, true);
            jjtreeCloseNodeScope(astOor);
        }
    }
    
    public static final void Osingle() throws ParseException {
        final ASTOsingle astOsingle = new ASTOsingle(23);
        int n = 1;
        NLU.jjtree.openNodeScope(astOsingle);
        jjtreeOpenNodeScope(astOsingle);
        try {
            jj_consume_token(35);
            jj_consume_token(33);
            Template();
            jj_consume_token(36);
        }
        catch (Throwable t) {
            if (n != 0) {
                NLU.jjtree.clearNodeScope(astOsingle);
                n = 0;
            }
            else {
                NLU.jjtree.popNode();
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
                NLU.jjtree.closeNodeScope(astOsingle, true);
                jjtreeCloseNodeScope(astOsingle);
            }
        }
        if (n != 0) {
            NLU.jjtree.closeNodeScope(astOsingle, true);
            jjtreeCloseNodeScope(astOsingle);
        }
    }
    
    private static final boolean jj_2_1(final int jj_la) {
        NLU.jj_la = jj_la;
        NLU.jj_lastpos = (NLU.jj_scanpos = NLU.token);
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
        NLU.jj_la = jj_la;
        NLU.jj_lastpos = (NLU.jj_scanpos = NLU.token);
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
        NLU.jj_la = jj_la;
        NLU.jj_lastpos = (NLU.jj_scanpos = NLU.token);
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
        NLU.jj_la = jj_la;
        NLU.jj_lastpos = (NLU.jj_scanpos = NLU.token);
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
        NLU.jj_la = jj_la;
        NLU.jj_lastpos = (NLU.jj_scanpos = NLU.token);
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
        NLU.jj_la = jj_la;
        NLU.jj_lastpos = (NLU.jj_scanpos = NLU.token);
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
        NLU.jj_la = jj_la;
        NLU.jj_lastpos = (NLU.jj_scanpos = NLU.token);
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
        NLU.jj_la = jj_la;
        NLU.jj_lastpos = (NLU.jj_scanpos = NLU.token);
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
        NLU.jj_la = jj_la;
        NLU.jj_lastpos = (NLU.jj_scanpos = NLU.token);
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
        NLU.jj_la = jj_la;
        NLU.jj_lastpos = (NLU.jj_scanpos = NLU.token);
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
        NLU.jj_la = jj_la;
        NLU.jj_lastpos = (NLU.jj_scanpos = NLU.token);
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
        NLU.jj_la = jj_la;
        NLU.jj_lastpos = (NLU.jj_scanpos = NLU.token);
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
        NLU.jj_la = jj_la;
        NLU.jj_lastpos = (NLU.jj_scanpos = NLU.token);
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
        NLU.jj_la = jj_la;
        NLU.jj_lastpos = (NLU.jj_scanpos = NLU.token);
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
        NLU.jj_la = jj_la;
        NLU.jj_lastpos = (NLU.jj_scanpos = NLU.token);
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
        NLU.jj_la = jj_la;
        NLU.jj_lastpos = (NLU.jj_scanpos = NLU.token);
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
        NLU.jj_la = jj_la;
        NLU.jj_lastpos = (NLU.jj_scanpos = NLU.token);
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
        NLU.jj_la = jj_la;
        NLU.jj_lastpos = (NLU.jj_scanpos = NLU.token);
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
        NLU.jj_la = jj_la;
        NLU.jj_lastpos = (NLU.jj_scanpos = NLU.token);
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
        NLU.jj_la = jj_la;
        NLU.jj_lastpos = (NLU.jj_scanpos = NLU.token);
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
        NLU.jj_la = jj_la;
        NLU.jj_lastpos = (NLU.jj_scanpos = NLU.token);
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
        NLU.jj_la = jj_la;
        NLU.jj_lastpos = (NLU.jj_scanpos = NLU.token);
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
        NLU.jj_la = jj_la;
        NLU.jj_lastpos = (NLU.jj_scanpos = NLU.token);
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
    
    private static final boolean jj_3R_54() {
        if (jj_scan_token(42)) {
            return true;
        }
        if (jj_scan_token(46)) {
            return true;
        }
        Token jj_scanpos;
        do {
            jj_scanpos = NLU.jj_scanpos;
        } while (!jj_3R_59());
        NLU.jj_scanpos = jj_scanpos;
        return jj_scan_token(43);
    }
    
    private static final boolean jj_3R_62() {
        return jj_3R_48();
    }
    
    private static final boolean jj_3R_26() {
        return jj_scan_token(13) || jj_scan_token(7);
    }
    
    private static final boolean jj_3R_63() {
        return jj_3R_40();
    }
    
    private static final boolean jj_3R_61() {
        return jj_3R_48();
    }
    
    private static final boolean jj_3_3() {
        return jj_3R_23();
    }
    
    private static final boolean jj_3_22() {
        return jj_3R_34();
    }
    
    private static final boolean jj_3_11() {
        return jj_3R_28();
    }
    
    private static final boolean jj_3R_23() {
        return jj_scan_token(13) || jj_scan_token(10);
    }
    
    private static final boolean jj_3R_56() {
        return jj_scan_token(45);
    }
    
    private static final boolean jj_3R_49() {
        return jj_3R_48();
    }
    
    private static final boolean jj_3R_36() {
        return jj_scan_token(13) || jj_scan_token(11);
    }
    
    private static final boolean jj_3R_21() {
        if (jj_3R_36()) {
            return true;
        }
        Token jj_scanpos;
        do {
            jj_scanpos = NLU.jj_scanpos;
        } while (!jj_3R_36());
        NLU.jj_scanpos = jj_scanpos;
        return false;
    }
    
    private static final boolean jj_3R_52() {
        final Token jj_scanpos = NLU.jj_scanpos;
        if (jj_scan_token(46)) {
            NLU.jj_scanpos = jj_scanpos;
            if (jj_scan_token(53)) {
                return true;
            }
        }
        return false;
    }
    
    private static final boolean jj_3R_51() {
        return jj_scan_token(35) || jj_scan_token(33) || jj_3R_48() || jj_scan_token(36);
    }
    
    private static final boolean jj_3_6() {
        return jj_3R_23();
    }
    
    private static final boolean jj_3_7() {
        return jj_3R_25();
    }
    
    private static final boolean jj_3R_60() {
        return jj_scan_token(44) || jj_3R_48();
    }
    
    private static final boolean jj_3R_34() {
        if (jj_scan_token(35)) {
            return true;
        }
        if (jj_scan_token(32)) {
            return true;
        }
        if (jj_3R_48()) {
            return true;
        }
        if (jj_3R_62()) {
            return true;
        }
        Token jj_scanpos;
        do {
            jj_scanpos = NLU.jj_scanpos;
        } while (!jj_3R_62());
        NLU.jj_scanpos = jj_scanpos;
        return jj_scan_token(36);
    }
    
    private static final boolean jj_3_21() {
        return jj_3R_33();
    }
    
    private static final boolean jj_3_13() {
        return jj_3R_28();
    }
    
    private static final boolean jj_3R_30() {
        final Token jj_scanpos = NLU.jj_scanpos;
        if (jj_3_21()) {
            NLU.jj_scanpos = jj_scanpos;
            if (jj_3_22()) {
                NLU.jj_scanpos = jj_scanpos;
                if (jj_3R_41()) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private static final boolean jj_3R_31() {
        return jj_3R_40();
    }
    
    private static final boolean jj_3_2() {
        return jj_3R_22();
    }
    
    private static final boolean jj_3R_33() {
        if (jj_scan_token(35)) {
            return true;
        }
        if (jj_scan_token(31)) {
            return true;
        }
        if (jj_3R_48()) {
            return true;
        }
        if (jj_3R_61()) {
            return true;
        }
        Token jj_scanpos;
        do {
            jj_scanpos = NLU.jj_scanpos;
        } while (!jj_3R_61());
        NLU.jj_scanpos = jj_scanpos;
        return jj_scan_token(36);
    }
    
    private static final boolean jj_3_20() {
        return jj_scan_token(35) || jj_scan_token(34) || jj_3R_30();
    }
    
    private static final boolean jj_3R_29() {
        return jj_3R_40();
    }
    
    private static final boolean jj_3R_35() {
        if (jj_scan_token(35)) {
            return true;
        }
        if (jj_3R_48()) {
            return true;
        }
        Token jj_scanpos;
        do {
            jj_scanpos = NLU.jj_scanpos;
        } while (!jj_3R_49());
        NLU.jj_scanpos = jj_scanpos;
        return jj_scan_token(36);
    }
    
    private static final boolean jj_3R_64() {
        return jj_3R_40();
    }
    
    private static final boolean jj_3R_58() {
        final Token jj_scanpos = NLU.jj_scanpos;
        if (jj_3R_64()) {
            NLU.jj_scanpos = jj_scanpos;
        }
        return jj_scan_token(35) || jj_scan_token(34) || jj_3R_32() || jj_scan_token(36);
    }
    
    private static final boolean jj_3_10() {
        return jj_3R_28();
    }
    
    private static final boolean jj_3R_27() {
        return jj_scan_token(24);
    }
    
    private static final boolean jj_3R_57() {
        final Token jj_scanpos = NLU.jj_scanpos;
        if (jj_3R_63()) {
            NLU.jj_scanpos = jj_scanpos;
        }
        return jj_scan_token(35) || jj_scan_token(34) || jj_3R_30() || jj_scan_token(36);
    }
    
    private static final boolean jj_3R_55() {
        if (jj_scan_token(35)) {
            return true;
        }
        if (jj_3R_48()) {
            return true;
        }
        if (jj_3R_60()) {
            return true;
        }
        Token jj_scanpos;
        do {
            jj_scanpos = NLU.jj_scanpos;
        } while (!jj_3R_60());
        NLU.jj_scanpos = jj_scanpos;
        return jj_scan_token(36);
    }
    
    private static final boolean jj_3_19() {
        final Token jj_scanpos = NLU.jj_scanpos;
        if (jj_3R_31()) {
            NLU.jj_scanpos = jj_scanpos;
        }
        return jj_3R_32();
    }
    
    private static final boolean jj_3R_24() {
        return jj_scan_token(19) || jj_3R_37();
    }
    
    private static final boolean jj_3_5() {
        return jj_3R_22();
    }
    
    private static final boolean jj_3_18() {
        final Token jj_scanpos = NLU.jj_scanpos;
        if (jj_3R_29()) {
            NLU.jj_scanpos = jj_scanpos;
        }
        return jj_3R_30();
    }
    
    private static final boolean jj_3R_48() {
        final Token jj_scanpos = NLU.jj_scanpos;
        if (jj_3_18()) {
            NLU.jj_scanpos = jj_scanpos;
            if (jj_3_19()) {
                NLU.jj_scanpos = jj_scanpos;
                if (jj_3R_57()) {
                    NLU.jj_scanpos = jj_scanpos;
                    if (jj_3R_58()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private static final boolean jj_3_8() {
        return jj_3R_26();
    }
    
    private static final boolean jj_3R_22() {
        return jj_scan_token(13) || jj_scan_token(8);
    }
    
    private static final boolean jj_3R_50() {
        return jj_scan_token(29);
    }
    
    private static final boolean jj_3R_40() {
        return jj_scan_token(41);
    }
    
    private static final boolean jj_3_12() {
        return jj_3R_28();
    }
    
    private static final boolean jj_3R_53() {
        return jj_scan_token(37) || jj_3R_48() || jj_scan_token(38);
    }
    
    private static final boolean jj_3_9() {
        if (jj_scan_token(29)) {
            return true;
        }
        Token jj_scanpos;
        do {
            jj_scanpos = NLU.jj_scanpos;
        } while (!jj_3R_27());
        NLU.jj_scanpos = jj_scanpos;
        return false;
    }
    
    private static final boolean jj_3_23() {
        return jj_3R_35();
    }
    
    private static final boolean jj_3R_37() {
        return jj_3R_50();
    }
    
    private static final boolean jj_3R_47() {
        return jj_3R_56();
    }
    
    private static final boolean jj_3R_59() {
        final Token jj_scanpos = NLU.jj_scanpos;
        if (jj_scan_token(52)) {
            NLU.jj_scanpos = jj_scanpos;
            if (jj_scan_token(46)) {
                return true;
            }
        }
        return false;
    }
    
    private static final boolean jj_3R_46() {
        return jj_3R_55();
    }
    
    private static final boolean jj_3_4() {
        return jj_3R_24();
    }
    
    private static final boolean jj_3R_45() {
        return jj_3R_35();
    }
    
    private static final boolean jj_3R_44() {
        return jj_3R_54();
    }
    
    private static final boolean jj_3_1() {
        return jj_3R_21();
    }
    
    private static final boolean jj_3R_39() {
        if (jj_scan_token(25)) {
            return true;
        }
        final Token jj_scanpos = NLU.jj_scanpos;
        if (jj_3_12()) {
            NLU.jj_scanpos = jj_scanpos;
            if (jj_scan_token(29)) {
                return true;
            }
        }
        return false;
    }
    
    private static final boolean jj_3R_25() {
        return jj_scan_token(13) || jj_scan_token(12);
    }
    
    private static final boolean jj_3R_43() {
        return jj_3R_53();
    }
    
    private static final boolean jj_3_17() {
        return jj_scan_token(13) || jj_scan_token(25);
    }
    
    private static final boolean jj_3_16() {
        return jj_scan_token(13) || jj_scan_token(21);
    }
    
    private static final boolean jj_3_15() {
        return jj_scan_token(13) || jj_scan_token(20);
    }
    
    private static final boolean jj_3R_41() {
        return jj_3R_51();
    }
    
    private static final boolean jj_3R_38() {
        return jj_scan_token(29) || jj_scan_token(27);
    }
    
    private static final boolean jj_3R_42() {
        return jj_3R_52();
    }
    
    private static final boolean jj_3R_32() {
        final Token jj_scanpos = NLU.jj_scanpos;
        if (jj_3R_42()) {
            NLU.jj_scanpos = jj_scanpos;
            if (jj_3R_43()) {
                NLU.jj_scanpos = jj_scanpos;
                if (jj_3R_44()) {
                    NLU.jj_scanpos = jj_scanpos;
                    if (jj_3R_45()) {
                        NLU.jj_scanpos = jj_scanpos;
                        if (jj_3R_46()) {
                            NLU.jj_scanpos = jj_scanpos;
                            if (jj_3R_47()) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    private static final boolean jj_3_14() {
        if (jj_scan_token(13)) {
            return true;
        }
        if (jj_3_9()) {
            return true;
        }
        Token jj_scanpos;
        do {
            jj_scanpos = NLU.jj_scanpos;
        } while (!jj_3_9());
        NLU.jj_scanpos = jj_scanpos;
        return false;
    }
    
    private static final boolean jj_3R_28() {
        final Token jj_scanpos = NLU.jj_scanpos;
        if (jj_3_14()) {
            NLU.jj_scanpos = jj_scanpos;
            if (jj_3R_38()) {
                NLU.jj_scanpos = jj_scanpos;
                if (jj_3_15()) {
                    NLU.jj_scanpos = jj_scanpos;
                    if (jj_3_16()) {
                        NLU.jj_scanpos = jj_scanpos;
                        if (jj_3_17()) {
                            NLU.jj_scanpos = jj_scanpos;
                            if (jj_3R_39()) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    private static final void jj_la1_0() {
        NLU.jj_la1_0 = new int[] { 8192, 8192, 8192, 532480, 8192, 8192, 8192, 570433536, 570433536, 8192, 131072, 536870912, 536879104, 536879104, 16777216, 570433536, 570433536, 570433536, 536870912, 536870912, 536870912, 536870912, 536870912, 33554432, 536870912, 8192, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    }
    
    private static final void jj_la1_1() {
        NLU.jj_la1_1 = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8192, 8192, 8192, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 512, 512, 512, 512, 520, 8, 2113536, 1064960, 1064960, 2114592, 8200, 4096, 2123304, 2123304, 2123304 };
    }
    
    public static void ReInit(final InputStream inputStream) {
        NLU.jj_input_stream.ReInit(inputStream, 1, 1);
        NLUTokenManager.ReInit(NLU.jj_input_stream);
        NLU.token = new Token();
        NLU.jj_ntk = -1;
        NLU.jjtree.reset();
        NLU.jj_gen = 0;
        for (int i = 0; i < 41; ++i) {
            NLU.jj_la1[i] = -1;
        }
        for (int j = 0; j < NLU.jj_2_rtns.length; ++j) {
            NLU.jj_2_rtns[j] = new JJCalls();
        }
    }
    
    public static void ReInit(final Reader reader) {
        NLU.jj_input_stream.ReInit(reader, 1, 1);
        NLUTokenManager.ReInit(NLU.jj_input_stream);
        NLU.token = new Token();
        NLU.jj_ntk = -1;
        NLU.jjtree.reset();
        NLU.jj_gen = 0;
        for (int i = 0; i < 41; ++i) {
            NLU.jj_la1[i] = -1;
        }
        for (int j = 0; j < NLU.jj_2_rtns.length; ++j) {
            NLU.jj_2_rtns[j] = new JJCalls();
        }
    }
    
    public void ReInit(final NLUTokenManager token_source) {
        NLU.token_source = token_source;
        NLU.token = new Token();
        NLU.jj_ntk = -1;
        NLU.jjtree.reset();
        NLU.jj_gen = 0;
        for (int i = 0; i < 41; ++i) {
            NLU.jj_la1[i] = -1;
        }
        for (int j = 0; j < NLU.jj_2_rtns.length; ++j) {
            NLU.jj_2_rtns[j] = new JJCalls();
        }
    }
    
    private static final Token jj_consume_token(final int jj_kind) throws ParseException {
        final Token token;
        if ((token = NLU.token).next != null) {
            NLU.token = NLU.token.next;
        }
        else {
            final Token token2 = NLU.token;
            final Token nextToken = NLUTokenManager.getNextToken();
            token2.next = nextToken;
            NLU.token = nextToken;
        }
        NLU.jj_ntk = -1;
        if (NLU.token.kind == jj_kind) {
            ++NLU.jj_gen;
            if (++NLU.jj_gc > 100) {
                NLU.jj_gc = 0;
                for (int i = 0; i < NLU.jj_2_rtns.length; ++i) {
                    for (JJCalls next = NLU.jj_2_rtns[i]; next != null; next = next.next) {
                        if (next.gen < NLU.jj_gen) {
                            next.first = null;
                        }
                    }
                }
            }
            return NLU.token;
        }
        NLU.token = token;
        NLU.jj_kind = jj_kind;
        throw generateParseException();
    }
    
    private static final boolean jj_scan_token(final int n) {
        if (NLU.jj_scanpos == NLU.jj_lastpos) {
            --NLU.jj_la;
            if (NLU.jj_scanpos.next == null) {
                final Token jj_scanpos = NLU.jj_scanpos;
                final Token nextToken = NLUTokenManager.getNextToken();
                jj_scanpos.next = nextToken;
                NLU.jj_scanpos = nextToken;
                NLU.jj_lastpos = nextToken;
            }
            else {
                NLU.jj_lastpos = (NLU.jj_scanpos = NLU.jj_scanpos.next);
            }
        }
        else {
            NLU.jj_scanpos = NLU.jj_scanpos.next;
        }
        if (NLU.jj_rescan) {
            int n2 = 0;
            Token token;
            for (token = NLU.token; token != null && token != NLU.jj_scanpos; token = token.next) {
                ++n2;
            }
            if (token != null) {
                jj_add_error_token(n, n2);
            }
        }
        if (NLU.jj_scanpos.kind != n) {
            return true;
        }
        if (NLU.jj_la == 0 && NLU.jj_scanpos == NLU.jj_lastpos) {
            throw NLU.jj_ls;
        }
        return false;
    }
    
    public static final Token getNextToken() {
        if (NLU.token.next != null) {
            NLU.token = NLU.token.next;
        }
        else {
            final Token token = NLU.token;
            final Token nextToken = NLUTokenManager.getNextToken();
            token.next = nextToken;
            NLU.token = nextToken;
        }
        NLU.jj_ntk = -1;
        ++NLU.jj_gen;
        return NLU.token;
    }
    
    public static final Token getToken(final int n) {
        Token next = NLU.lookingAhead ? NLU.jj_scanpos : NLU.token;
        for (int i = 0; i < n; ++i) {
            if (next.next != null) {
                next = next.next;
            }
            else {
                final Token token = next;
                final Token nextToken = NLUTokenManager.getNextToken();
                token.next = nextToken;
                next = nextToken;
            }
        }
        return next;
    }
    
    private static final int jj_ntk() {
        if ((NLU.jj_nt = NLU.token.next) == null) {
            final Token token = NLU.token;
            final Token nextToken = NLUTokenManager.getNextToken();
            token.next = nextToken;
            return NLU.jj_ntk = nextToken.kind;
        }
        return NLU.jj_ntk = NLU.jj_nt.kind;
    }
    
    private static final void jj_add_error_token(final int n, final int jj_endpos) {
        if (jj_endpos >= 100) {
            return;
        }
        if (jj_endpos == NLU.jj_endpos + 1) {
            NLU.jj_lasttokens[NLU.jj_endpos++] = n;
        }
        else if (NLU.jj_endpos != 0) {
            NLU.jj_expentry = new int[NLU.jj_endpos];
            for (int i = 0; i < NLU.jj_endpos; ++i) {
                NLU.jj_expentry[i] = NLU.jj_lasttokens[i];
            }
            boolean b = false;
            final Enumeration<int[]> elements = (Enumeration<int[]>)NLU.jj_expentries.elements();
            while (elements.hasMoreElements()) {
                final int[] array = elements.nextElement();
                if (array.length == NLU.jj_expentry.length) {
                    b = true;
                    for (int j = 0; j < NLU.jj_expentry.length; ++j) {
                        if (array[j] != NLU.jj_expentry[j]) {
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
                NLU.jj_expentries.addElement(NLU.jj_expentry);
            }
            if (jj_endpos != 0) {
                NLU.jj_lasttokens[(NLU.jj_endpos = jj_endpos) - 1] = n;
            }
        }
    }
    
    public static ParseException generateParseException() {
        NLU.jj_expentries.removeAllElements();
        final boolean[] array = new boolean[64];
        for (int i = 0; i < 64; ++i) {
            array[i] = false;
        }
        if (NLU.jj_kind >= 0) {
            array[NLU.jj_kind] = true;
            NLU.jj_kind = -1;
        }
        for (int j = 0; j < 41; ++j) {
            if (NLU.jj_la1[j] == NLU.jj_gen) {
                for (int k = 0; k < 32; ++k) {
                    if ((NLU.jj_la1_0[j] & 1 << k) != 0x0) {
                        array[k] = true;
                    }
                    if ((NLU.jj_la1_1[j] & 1 << k) != 0x0) {
                        array[32 + k] = true;
                    }
                }
            }
        }
        for (int l = 0; l < 64; ++l) {
            if (array[l]) {
                (NLU.jj_expentry = new int[1])[0] = l;
                NLU.jj_expentries.addElement(NLU.jj_expentry);
            }
        }
        NLU.jj_endpos = 0;
        jj_rescan_token();
        jj_add_error_token(0, 0);
        final int[][] array2 = new int[NLU.jj_expentries.size()][];
        for (int n = 0; n < NLU.jj_expentries.size(); ++n) {
            array2[n] = (int[])NLU.jj_expentries.elementAt(n);
        }
        return new ParseException(NLU.token, array2, NLU.tokenImage);
    }
    
    public static final void enable_tracing() {
    }
    
    public static final void disable_tracing() {
    }
    
    private static final void jj_rescan_token() {
        NLU.jj_rescan = true;
        for (int i = 0; i < 23; ++i) {
            JJCalls next = NLU.jj_2_rtns[i];
            do {
                if (next.gen > NLU.jj_gen) {
                    NLU.jj_la = next.arg;
                    NLU.jj_lastpos = (NLU.jj_scanpos = next.first);
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
                    }
                }
                next = next.next;
            } while (next != null);
        }
        NLU.jj_rescan = false;
    }
    
    private static final void jj_save(final int n, final int arg) {
        JJCalls next;
        for (next = NLU.jj_2_rtns[n]; next.gen > NLU.jj_gen; next = next.next) {
            if (next.next == null) {
                final JJCalls jjCalls = next;
                final JJCalls next2 = new JJCalls();
                jjCalls.next = next2;
                next = next2;
                break;
            }
        }
        next.gen = NLU.jj_gen + arg - NLU.jj_la;
        next.first = NLU.token;
        next.arg = arg;
    }
    
    public NLU(final InputStream inputStream) {
        if (NLU.jj_initialized_once) {
            System.out.println("ERROR: Second call to constructor of static parser.  You must");
            System.out.println("       either use ReInit() or set the JavaCC option STATIC to false");
            System.out.println("       during parser generation.");
            throw new Error();
        }
        NLU.jj_initialized_once = true;
        NLU.jj_input_stream = new JavaCharStream(inputStream, 1, 1);
        NLU.token_source = new NLUTokenManager(NLU.jj_input_stream);
        NLU.token = new Token();
        NLU.jj_ntk = -1;
        NLU.jj_gen = 0;
        for (int i = 0; i < 41; ++i) {
            NLU.jj_la1[i] = -1;
        }
        for (int j = 0; j < NLU.jj_2_rtns.length; ++j) {
            NLU.jj_2_rtns[j] = new JJCalls();
        }
    }
    
    public NLU(final Reader reader) {
        if (NLU.jj_initialized_once) {
            System.out.println("ERROR: Second call to constructor of static parser.  You must");
            System.out.println("       either use ReInit() or set the JavaCC option STATIC to false");
            System.out.println("       during parser generation.");
            throw new Error();
        }
        NLU.jj_initialized_once = true;
        NLU.jj_input_stream = new JavaCharStream(reader, 1, 1);
        NLU.token_source = new NLUTokenManager(NLU.jj_input_stream);
        NLU.token = new Token();
        NLU.jj_ntk = -1;
        NLU.jj_gen = 0;
        for (int i = 0; i < 41; ++i) {
            NLU.jj_la1[i] = -1;
        }
        for (int j = 0; j < NLU.jj_2_rtns.length; ++j) {
            NLU.jj_2_rtns[j] = new JJCalls();
        }
    }
    
    public NLU(final NLUTokenManager token_source) {
        if (NLU.jj_initialized_once) {
            System.out.println("ERROR: Second call to constructor of static parser.  You must");
            System.out.println("       either use ReInit() or set the JavaCC option STATIC to false");
            System.out.println("       during parser generation.");
            throw new Error();
        }
        NLU.jj_initialized_once = true;
        NLU.token_source = token_source;
        NLU.token = new Token();
        NLU.jj_ntk = -1;
        NLU.jj_gen = 0;
        for (int i = 0; i < 41; ++i) {
            NLU.jj_la1[i] = -1;
        }
        for (int j = 0; j < NLU.jj_2_rtns.length; ++j) {
            NLU.jj_2_rtns[j] = new JJCalls();
        }
    }
    
    static {
        NLU.jjtree = new JJTNLUState();
        NLU.templateNames = new HashSet();
        NLU.templateNamesForBeat = new HashSet();
        NLU.beatNames = new HashSet();
        NLU.consts = new HashSet();
        NLU.compiled = new HashSet();
        NLU.initialFiles = new HashSet();
        NLU.retractThese = new HashSet();
        NLU.templateNameToTemplate = new Hashtable();
        NLU.beatNameToTemplateName = new Hashtable();
        NLU.beatNameToIncludes = new Hashtable();
        NLU.fileNameToTemplates = new Hashtable();
        NLU.beatNameToFileName = new Hashtable();
        NLU.generateRuleRetractionRules = false;
        NLU.startDependency = "(logical";
        NLU.endDependency = ")";
        NLU.jj_initialized_once = false;
        NLU.lookingAhead = false;
        jj_la1 = new int[41];
        jj_la1_0();
        jj_la1_1();
        jj_2_rtns = new JJCalls[23];
        NLU.jj_rescan = false;
        NLU.jj_gc = 0;
        jj_ls = new LookaheadSuccess();
        NLU.jj_expentries = new Vector();
        NLU.jj_kind = -1;
        NLU.jj_lasttokens = new int[100];
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
