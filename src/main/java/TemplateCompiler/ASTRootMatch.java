package TemplateCompiler;

import wordnet.wn.FileBackedDictionary;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import wordnet.wn.POS;
import java.io.IOException;
import java.io.BufferedWriter;
import wordnet.wn.DictionaryDatabase;

class ASTRootMatch extends ASTJessRule implements PatternProducingNode
{
    private static DictionaryDatabase dictionary;
    private String word;
    
    void compileToJess(final BufferedWriter bufferedWriter) throws IOException, CompileException {
        this.word = this.dumpTokens().substring(2, this.dumpTokens().indexOf(":") - 1);
    }
    
    public String getRuleName() {
        return null;
    }
    
    public String getPatternHead() {
        if (ASTRootMatch.dictionary.lookupIndexWord(POS.NOUN, this.word) == null && ASTRootMatch.dictionary.lookupIndexWord(POS.VERB, this.word) == null && ASTRootMatch.dictionary.lookupIndexWord(POS.ADJ, this.word) == null) {
            System.out.println("Warning: stemming ignored for " + this.word);
            return "wo-" + this.word;
        }
        return "ro-" + this.word;
    }
    
    public String getPatternToMatch(final int n) {
        return null;
    }
    
    public HashSet getPatternBindingVariables() {
        return new HashSet();
    }
    
    public List getPatternBindingVariablesCanonical() {
        return new ArrayList();
    }
    
    boolean isRegexp() {
        return true;
    }
    
    private final /* synthetic */ void this() {
        this.word = null;
    }
    
    ASTRootMatch(final int n) {
        super(n);
        this.this();
    }
    
    ASTRootMatch(final NLU nlu, final int n) {
        super(nlu, n);
        this.this();
    }
    
    static {
        ASTRootMatch.dictionary = new FileBackedDictionary("C:\\WN16\\DICT");
    }
}
