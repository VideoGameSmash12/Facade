package dramaman.compiler;

import jd.CodeStringDescriptor;
import jd.NestableCodeDescriptor;
import jd.FieldDescriptor;
import java.util.Iterator;
import jd.MethodDescriptor;
import java.io.File;
import java.util.Vector;

public class ASTBeatDefinition extends BeatScopeMaintainer implements BeatParserTreeConstants
{
    private String beatName;
    private boolean staticWeightDefined;
    private boolean staticPriorityDefined;
    private float weight;
    private int priority;
    private String discourseRulesFilename;
    private String beatBehaviorsFilename;
    private int beatID;
    private boolean beatIDDefined;
    private Vector effects;
    private Vector preconditions;
    private Vector weightTests;
    private Vector priorityTests;
    private ASTInitAction initAction;
    private ASTSelectAction selectAction;
    private ASTAbortAction abortAction;
    private ASTSucceedAction succeedAction;
    private static final /* synthetic */ boolean $noassert;
    
    void setBeatName(final String s) {
        this.beatName = BeatParseNode.uppercaseFirstCharacter(s);
    }
    
    String getBeatName() {
        return new String(this.beatName);
    }
    
    boolean getStaticWeightDefined() {
        return this.staticWeightDefined;
    }
    
    boolean getStaticPriorityDefined() {
        return this.staticPriorityDefined;
    }
    
    float getWeight() {
        return this.weight;
    }
    
    void setWeight(final float weight) throws CompileException {
        if (!this.staticWeightDefined) {
            this.weight = weight;
            this.staticWeightDefined = true;
            return;
        }
        throw new CompileException("Multiple static weights for beat " + this.beatName);
    }
    
    int getPriority() {
        return this.priority;
    }
    
    void setPriority(final int priority) throws CompileException {
        if (!this.staticPriorityDefined) {
            this.priority = priority;
            this.staticPriorityDefined = true;
            return;
        }
        throw new CompileException("Multiple static priorities for beat " + this.beatName);
    }
    
    float getBeatID() {
        return (float)this.beatID;
    }
    
    void setBeatID(final int beatID) throws CompileException {
        if (!this.beatIDDefined) {
            this.beatID = beatID;
            this.beatIDDefined = true;
            return;
        }
        throw new CompileException("Multiple beatIDs for beat " + this.beatName);
    }
    
    ASTEffect[] getEffects() {
        return this.effects.toArray(new ASTEffect[this.effects.size()]);
    }
    
    void addEffect(final ASTEffect astEffect) {
        this.effects.add(astEffect);
    }
    
    ASTPrecondition[] getPreconditions() {
        return this.preconditions.toArray(new ASTPrecondition[this.preconditions.size()]);
    }
    
    void addPrecondition(final ASTPrecondition astPrecondition) {
        this.preconditions.add(astPrecondition);
    }
    
    ASTWeightTest[] getWeightTests() {
        return this.weightTests.toArray(new ASTWeightTest[this.weightTests.size()]);
    }
    
    void addWeightTest(final ASTWeightTest astWeightTest) {
        this.weightTests.add(astWeightTest);
    }
    
    ASTPriorityTest[] getPriorityTests() {
        return this.priorityTests.toArray(new ASTPriorityTest[this.priorityTests.size()]);
    }
    
    void addPriorityTest(final ASTPriorityTest astPriorityTest) {
        this.priorityTests.add(astPriorityTest);
    }
    
    File getDiscourseRulesFilename() {
        if (!ASTBeatDefinition.$noassert && this.discourseRulesFilename == null) {
            throw new AssertionError();
        }
        return new File(this.discourseRulesFilename);
    }
    
    void setDiscourseRulesFilename(final String discourseRulesFilename) {
        if (!ASTBeatDefinition.$noassert && this.discourseRulesFilename != null) {
            throw new AssertionError();
        }
        this.discourseRulesFilename = discourseRulesFilename;
    }
    
    File getBeatBehaviorsFilename() {
        if (!ASTBeatDefinition.$noassert && this.beatBehaviorsFilename == null) {
            throw new AssertionError();
        }
        return new File(this.beatBehaviorsFilename);
    }
    
    void setBeatBehaviorsFilename(final String beatBehaviorsFilename) {
        if (!ASTBeatDefinition.$noassert && this.beatBehaviorsFilename != null) {
            throw new AssertionError();
        }
        this.beatBehaviorsFilename = beatBehaviorsFilename;
    }
    
    ASTInitAction getInitAction() {
        return this.initAction;
    }
    
    void setInitAction(final ASTInitAction initAction) throws CompileException {
        if (this.initAction != null) {
            throw new CompileException("Multiple init actions for beat " + this.beatName);
        }
        this.initAction = initAction;
    }
    
    ASTSelectAction getSelectAction() {
        return this.selectAction;
    }
    
    void setSelectAction(final ASTSelectAction selectAction) throws CompileException {
        if (this.selectAction != null) {
            throw new CompileException("Multiple select actions for beat " + this.beatName);
        }
        this.selectAction = selectAction;
    }
    
    ASTAbortAction getAbortAction() {
        return this.abortAction;
    }
    
    void setAbortAction(final ASTAbortAction abortAction) throws CompileException {
        if (this.abortAction != null) {
            throw new CompileException("Multiple abort actions for beat " + this.beatName);
        }
        this.abortAction = abortAction;
    }
    
    ASTSucceedAction getSucceedAction() {
        return this.succeedAction;
    }
    
    void setSucceedAction(final ASTSucceedAction succeedAction) throws CompileException {
        if (this.succeedAction != null) {
            throw new CompileException("Multiple succeed actions for beat " + this.beatName);
        }
        this.succeedAction = succeedAction;
    }
    
    BeatScopeMaintainer getEnclosingBeatScope() {
        return this;
    }
    
    Vector compileTestsToJava() throws CompileException {
        final Vector<MethodDescriptor> vector = new Vector<MethodDescriptor>();
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        final Iterator<ASTPrecondition> iterator = this.preconditions.iterator();
        while (iterator.hasNext()) {
            ++n;
            vector.add(iterator.next().compileToJava(this.beatName, n));
        }
        final Iterator<ASTWeightTest> iterator2 = (Iterator<ASTWeightTest>)this.weightTests.iterator();
        while (iterator2.hasNext()) {
            ++n2;
            vector.add(iterator2.next().compileToJava(this.beatName, n2));
        }
        final Iterator<ASTPriorityTest> iterator3 = (Iterator<ASTPriorityTest>)this.priorityTests.iterator();
        while (iterator3.hasNext()) {
            ++n3;
            vector.add(iterator3.next().compileToJava(this.beatName, n3));
        }
        return vector;
    }
    
    Vector compileActionsToJava() throws CompileException {
        final Vector<MethodDescriptor> vector = new Vector<MethodDescriptor>();
        if (this.initAction != null) {
            vector.add(this.initAction.compileToJava(this.beatName));
        }
        if (this.selectAction != null) {
            vector.add(this.selectAction.compileToJava(this.beatName));
        }
        if (this.abortAction != null) {
            vector.add(this.abortAction.compileToJava(this.beatName));
        }
        if (this.succeedAction != null) {
            vector.add(this.succeedAction.compileToJava(this.beatName));
        }
        return vector;
    }
    
    MethodDescriptor compileFactory() throws CompileException {
        if (!this.beatIDDefined) {
            throw new CompileError("No beatID defined for beat " + this.beatName);
        }
        final MethodDescriptor methodDescriptor = new MethodDescriptor();
        methodDescriptor.methodName = "_" + this.beatName + "_factory";
        methodDescriptor.addModifier("public");
        methodDescriptor.addModifier("static");
        methodDescriptor.addModifier("Beat");
        final Iterator<ASTEffect> iterator = (Iterator<ASTEffect>)this.effects.iterator();
        final StringBuffer sb = new StringBuffer();
        if (iterator.hasNext()) {
            sb.append("{");
            while (iterator.hasNext()) {
                sb.append(iterator.next().compileToJava());
                if (iterator.hasNext()) {
                    sb.append(", ");
                }
                else {
                    sb.append("}");
                }
            }
        }
        else {
            sb.append("new StoryEffect[0]");
        }
        final FieldDescriptor fieldDescriptor = new FieldDescriptor();
        fieldDescriptor.fieldType = "StoryEffect[]";
        fieldDescriptor.addFieldName("effects");
        fieldDescriptor.initializer = sb.toString();
        methodDescriptor.addToBlockBody(fieldDescriptor);
        final StringBuffer sb2 = new StringBuffer();
        final Iterator<ASTPrecondition> iterator2 = (Iterator<ASTPrecondition>)this.preconditions.iterator();
        if (iterator2.hasNext()) {
            sb2.append("{");
            int n = 0;
            while (iterator2.hasNext()) {
                sb2.append("\"" + iterator2.next().preconditionName(this.beatName, ++n) + '\"');
                if (iterator2.hasNext()) {
                    sb2.append(", ");
                }
                else {
                    sb2.append("}");
                }
            }
        }
        else {
            sb2.append("new String[0]");
        }
        final FieldDescriptor fieldDescriptor2 = new FieldDescriptor();
        fieldDescriptor2.fieldType = "String[]";
        fieldDescriptor2.addFieldName("preconditionNames");
        fieldDescriptor2.initializer = sb2.toString();
        methodDescriptor.addToBlockBody(fieldDescriptor2);
        final StringBuffer sb3 = new StringBuffer();
        final Iterator<ASTWeightTest> iterator3 = (Iterator<ASTWeightTest>)this.weightTests.iterator();
        if (iterator3.hasNext()) {
            sb3.append("{");
            int n2 = 0;
            while (iterator3.hasNext()) {
                final ASTWeightTest astWeightTest = iterator3.next();
                sb3.append("new Beat.WeightTest(\"" + astWeightTest.weightTestName(this.beatName, ++n2) + "\", " + astWeightTest.getWeight() + "f)");
                if (iterator3.hasNext()) {
                    sb3.append(", ");
                }
                else {
                    sb3.append("}");
                }
            }
        }
        else {
            sb3.append("new Beat.WeightTest[0]");
        }
        final FieldDescriptor fieldDescriptor3 = new FieldDescriptor();
        fieldDescriptor3.fieldType = "Beat.WeightTest[]";
        fieldDescriptor3.addFieldName("weightTestArray");
        fieldDescriptor3.initializer = sb3.toString();
        methodDescriptor.addToBlockBody(fieldDescriptor3);
        final StringBuffer sb4 = new StringBuffer();
        final Iterator<ASTPriorityTest> iterator4 = (Iterator<ASTPriorityTest>)this.priorityTests.iterator();
        if (iterator4.hasNext()) {
            sb4.append("{");
            int n3 = 0;
            while (iterator4.hasNext()) {
                final ASTPriorityTest astPriorityTest = iterator4.next();
                sb4.append("new Beat.PriorityTest(\"" + astPriorityTest.priorityTestName(this.beatName, ++n3) + "\", " + astPriorityTest.getPriority() + ')');
                if (iterator4.hasNext()) {
                    sb4.append(", ");
                }
                else {
                    sb4.append("}");
                }
            }
        }
        else {
            sb4.append("new Beat.PriorityTest[0]");
        }
        final FieldDescriptor fieldDescriptor4 = new FieldDescriptor();
        fieldDescriptor4.fieldType = "Beat.PriorityTest[]";
        fieldDescriptor4.addFieldName("priorityTestArray");
        fieldDescriptor4.initializer = sb4.toString();
        methodDescriptor.addToBlockBody(fieldDescriptor4);
        this.initializeScope(0, "beatName_scope", null);
        this.addChildVariableDeclarations();
        this.defineRuntimeScope(methodDescriptor, this.beatName, "null");
        final FieldDescriptor fieldDescriptor5 = new FieldDescriptor();
        fieldDescriptor5.fieldType = "String";
        fieldDescriptor5.addFieldName("initActionMethodName");
        if (this.initAction != null) {
            fieldDescriptor5.initializer = "\"" + this.initAction.initActionName(this.beatName) + '\"';
        }
        methodDescriptor.addToBlockBody(fieldDescriptor5);
        if (this.initAction == null) {
            methodDescriptor.addToBlockBody(new CodeStringDescriptor("initActionMethodName = null;"));
        }
        final FieldDescriptor fieldDescriptor6 = new FieldDescriptor();
        fieldDescriptor6.fieldType = "String";
        fieldDescriptor6.addFieldName("selectActionMethodName");
        if (this.selectAction != null) {
            fieldDescriptor6.initializer = "\"" + this.selectAction.selectActionName(this.beatName) + '\"';
        }
        methodDescriptor.addToBlockBody(fieldDescriptor6);
        if (this.selectAction == null) {
            methodDescriptor.addToBlockBody(new CodeStringDescriptor("selectActionMethodName = null;"));
        }
        final FieldDescriptor fieldDescriptor7 = new FieldDescriptor();
        fieldDescriptor7.fieldType = "String";
        fieldDescriptor7.addFieldName("succeedActionMethodName");
        if (this.succeedAction != null) {
            fieldDescriptor7.initializer = "\"" + this.succeedAction.succeedActionName(this.beatName) + '\"';
        }
        methodDescriptor.addToBlockBody(fieldDescriptor7);
        if (this.succeedAction == null) {
            methodDescriptor.addToBlockBody(new CodeStringDescriptor("succeedActionMethodName = null;"));
        }
        final FieldDescriptor fieldDescriptor8 = new FieldDescriptor();
        fieldDescriptor8.fieldType = "String";
        fieldDescriptor8.addFieldName("abortActionMethodName");
        if (this.abortAction != null) {
            fieldDescriptor8.initializer = "\"" + this.abortAction.abortActionName(this.beatName) + '\"';
        }
        methodDescriptor.addToBlockBody(fieldDescriptor8);
        if (this.abortAction == null) {
            methodDescriptor.addToBlockBody(new CodeStringDescriptor("abortActionMethodName = null;"));
        }
        methodDescriptor.addToBlockBody(new CodeStringDescriptor("return new Beat(" + this.beatID + ", \"" + this.beatName + "\", effects, " + this.weight + "f, " + this.priority + ", preconditionNames, weightTestArray, priorityTestArray, _scope, initActionMethodName, selectActionMethodName, succeedActionMethodName, abortActionMethodName);"));
        return methodDescriptor;
    }
    
    public ASTBeatDefinition(final int n) {
        super(n);
        this.beatName = null;
        this.staticWeightDefined = false;
        this.staticPriorityDefined = false;
        this.weight = 1.0f;
        this.priority = 0;
        this.beatIDDefined = false;
        this.effects = new Vector();
        this.preconditions = new Vector();
        this.weightTests = new Vector();
        this.priorityTests = new Vector();
        this.initAction = null;
        this.selectAction = null;
        this.abortAction = null;
        this.succeedAction = null;
    }
    
    public ASTBeatDefinition(final BeatParser beatParser, final int n) {
        super(beatParser, n);
        this.beatName = null;
        this.staticWeightDefined = false;
        this.staticPriorityDefined = false;
        this.weight = 1.0f;
        this.priority = 0;
        this.beatIDDefined = false;
        this.effects = new Vector();
        this.preconditions = new Vector();
        this.weightTests = new Vector();
        this.priorityTests = new Vector();
        this.initAction = null;
        this.selectAction = null;
        this.abortAction = null;
        this.succeedAction = null;
    }
    
    static {
        $noassert = (Class.forName("[Ldramaman.compiler.ASTBeatDefinition;").getComponentType().desiredAssertionStatus() ^ true);
    }
}
