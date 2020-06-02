package TemplateCompiler;

import java.util.StringTokenizer;
import jess.ValueVector;
import jess.Fact;
import jess.JessException;
import jess.Userpackage;
import jess.Defglobal;
import jess.Value;
import jess.Rete;

public class Preprocessor
{
    public static void initializeReteEngine(final Rete rete) throws JessException {
        try {
            rete.reset();
            rete.executeCommand("(defclass WordCompileSearch TemplateCompiler.SearchUnit)");
            rete.addDefglobal(new Defglobal("mysearch", new Value(new SearchUnit())));
            rete.addUserpackage(new MyRules());
            rete.executeCommand("(batch nlu/templates/TemplateSupport.jess)");
        }
        catch (JessException ex) {
            JessExceptionHelper.processJessException(ex);
        }
    }
    
    public static String replaceAll(final String s, final String s2, final String s3) {
        int i = s.indexOf(s2);
        if (i == -1) {
            return s;
        }
        StringBuffer sb;
        for (sb = new StringBuffer(s); i != -1; i = sb.toString().indexOf(s2, i + s3.length())) {
            sb.delete(i, i + s2.length());
            sb.insert(i, s3);
            if (s.length() < i + s3.length()) {
                break;
            }
        }
        return sb.toString();
    }
    
    private static final void addWOFact(final String s, final Rete rete, final int n, final int n2) throws JessException {
        final Fact fact = new Fact("wo-" + s, rete);
        final ValueVector valueVector = new ValueVector();
        valueVector.add(new Value(n, 4));
        valueVector.add(new Value(n2, 4));
        fact.setSlotValue("__data", new Value(valueVector, 512));
        rete.assertFact(fact);
    }
    
    private static final String[] expandContractions(final String s) {
        final String[] array = new String[2];
        if (s.equals("can't") || s.equals("cant") || s.equals("cannot")) {
            array[0] = "can";
            array[1] = "not";
        }
        else if (s.equals("don't") || s.equals("dont")) {
            array[0] = "do";
            array[1] = "not";
        }
        else if (s.equals("won't") || s.equals("wont")) {
            array[0] = "will";
            array[1] = "not";
        }
        else if (s.equals("shan't") || s.equals("shant")) {
            array[0] = "shall";
            array[1] = "not";
        }
        else if (s.equals("couldn't") || s.equals("couldnt")) {
            array[0] = "could";
            array[1] = "not";
        }
        else if (s.equals("shouldn't") || s.equals("shouldnt")) {
            array[0] = "should";
            array[1] = "not";
        }
        else if (s.equals("wouldn't") || s.equals("wouldnt")) {
            array[0] = "would";
            array[1] = "not";
        }
        else if (s.equals("doesn't") || s.equals("doesnt")) {
            array[0] = "does";
            array[1] = "not";
        }
        else if (s.equals("didn't") || s.equals("didnt")) {
            array[0] = "did";
            array[1] = "not";
        }
        else if (s.equals("hasn't") || s.equals("hasnt")) {
            array[0] = "has";
            array[1] = "not";
        }
        else if (s.equals("haven't") || s.equals("havent")) {
            array[0] = "have";
            array[1] = "not";
        }
        else if (s.equals("hadn't") || s.equals("hadnt")) {
            array[0] = "had";
            array[1] = "not";
        }
        else if (s.equals("isn't") || s.equals("isnt")) {
            array[0] = "is";
            array[1] = "not";
        }
        else if (s.equals("aren't") || s.equals("arent")) {
            array[0] = "are";
            array[1] = "not";
        }
        else if (s.equals("wasn't") || s.equals("wasnt")) {
            array[0] = "was";
            array[1] = "not";
        }
        else if (s.equals("ain't") || s.equals("aint")) {
            array[0] = "is";
            array[1] = "not";
        }
        else if (s.equals("could've") || s.equals("couldve")) {
            array[0] = "could";
            array[1] = "have";
        }
        else if (s.equals("should've") || s.equals("shouldve")) {
            array[0] = "should";
            array[1] = "have";
        }
        else if (s.equals("would've") || s.equals("wouldve")) {
            array[0] = "would";
            array[1] = "have";
        }
        else if (s.equals("i've") || s.equals("ive")) {
            array[0] = "i";
            array[1] = "have";
        }
        else if (s.equals("you've") || s.equals("youve")) {
            array[0] = "you";
            array[1] = "have";
        }
        else if (s.equals("we've") || s.equals("weve")) {
            array[0] = "we";
            array[1] = "have";
        }
        else if (s.equals("they've") || s.equals("theyve")) {
            array[0] = "they";
            array[1] = "have";
        }
        else if (s.equals("what've") || s.equals("whatve")) {
            array[0] = "what";
            array[1] = "have";
        }
        else if (s.equals("where've") || s.equals("whereve")) {
            array[0] = "where";
            array[1] = "have";
        }
        else if (s.equals("when've") || s.equals("whenve")) {
            array[0] = "when";
            array[1] = "have";
        }
        else if (s.equals("who've") || s.equals("whove")) {
            array[0] = "who";
            array[1] = "have";
        }
        else if (s.equals("why've") || s.equals("whyve")) {
            array[0] = "why";
            array[1] = "have";
        }
        else if (s.equals("how've") || s.equals("howve")) {
            array[0] = "how";
            array[1] = "have";
        }
        else if (s.equals("i'll") || s.equals("ill")) {
            array[0] = "i";
            array[1] = "will";
        }
        else if (s.equals("he'll") || s.equals("hell")) {
            array[0] = "he";
            array[1] = "will";
        }
        else if (s.equals("she'll") || s.equals("shell")) {
            array[0] = "she";
            array[1] = "will";
        }
        else if (s.equals("we'll") || s.equals("well")) {
            array[0] = "we";
            array[1] = "will";
        }
        else if (s.equals("they'll") || s.equals("theyll")) {
            array[0] = "they";
            array[1] = "will";
        }
        else if (s.equals("you'll") || s.equals("youll")) {
            array[0] = "you";
            array[1] = "will";
        }
        else if (s.equals("it'll") || s.equals("itll")) {
            array[0] = "it";
            array[1] = "will";
        }
        else if (s.equals("that'll") || s.equals("thatll")) {
            array[0] = "that";
            array[1] = "will";
        }
        else if (s.equals("there'll") || s.equals("therell")) {
            array[0] = "there";
            array[1] = "will";
        }
        else if (s.equals("what'll") || s.equals("whatll")) {
            array[0] = "what";
            array[1] = "will";
        }
        else if (s.equals("where'll") || s.equals("wherell")) {
            array[0] = "where";
            array[1] = "will";
        }
        else if (s.equals("when'll") || s.equals("whenll")) {
            array[0] = "when";
            array[1] = "will";
        }
        else if (s.equals("who'll") || s.equals("wholl")) {
            array[0] = "who";
            array[1] = "will";
        }
        else if (s.equals("why'll") || s.equals("whyll")) {
            array[0] = "why";
            array[1] = "will";
        }
        else if (s.equals("how'll") || s.equals("howll")) {
            array[0] = "how";
            array[1] = "will";
        }
        else if (s.equals("i'm") || s.equals("im")) {
            array[0] = "i";
            array[1] = "am";
        }
        else if (s.equals("he's") || s.equals("hes")) {
            array[0] = "he";
            array[1] = "is";
        }
        else if (s.equals("she's") || s.equals("shes")) {
            array[0] = "she";
            array[1] = "is";
        }
        else if (s.equals("it's") || s.equals("its")) {
            array[0] = "it";
            array[1] = "is";
        }
        else if (s.equals("that's") || s.equals("thats")) {
            array[0] = "that";
            array[1] = "is";
        }
        else if (s.equals("there's") || s.equals("theres")) {
            array[0] = "there";
            array[1] = "is";
        }
        else if (s.equals("what's") || s.equals("whats")) {
            array[0] = "what";
            array[1] = "is";
        }
        else if (s.equals("where's") || s.equals("wheres")) {
            array[0] = "where";
            array[1] = "is";
        }
        else if (s.equals("when's") || s.equals("whens")) {
            array[0] = "when";
            array[1] = "is";
        }
        else if (s.equals("who's") || s.equals("whos")) {
            array[0] = "who";
            array[1] = "is";
        }
        else if (s.equals("why's") || s.equals("whys")) {
            array[0] = "why";
            array[1] = "is";
        }
        else if (s.equals("how's") || s.equals("hows")) {
            array[0] = "how";
            array[1] = "is";
        }
        else if (s.equals("let's") || s.equals("lets")) {
            array[0] = "let";
            array[1] = "us";
        }
        else if (s.equals("nothing's") || s.equals("nothings")) {
            array[0] = "nothing";
            array[1] = "is";
        }
        else if (s.equals("life's")) {
            array[0] = "life";
            array[1] = "is";
        }
        else if (s.equals("you're") || s.equals("youre") || s.equals("your")) {
            array[0] = "you";
            array[1] = "are";
        }
        else if (s.equals("we're")) {
            array[0] = "we";
            array[1] = "are";
        }
        else if (s.equals("they're") || s.equals("theyre") || s.equals("their")) {
            array[0] = "they";
            array[1] = "are";
        }
        else if (s.equals("what're") || s.equals("whatre")) {
            array[0] = "what";
            array[1] = "are";
        }
        else if (s.equals("where're") || s.equals("wherere")) {
            array[0] = "where";
            array[1] = "are";
        }
        else if (s.equals("when're") || s.equals("whenre")) {
            array[0] = "when";
            array[1] = "are";
        }
        else if (s.equals("who're") || s.equals("whore")) {
            array[0] = "who";
            array[1] = "are";
        }
        else if (s.equals("why're") || s.equals("whyre")) {
            array[0] = "why";
            array[1] = "are";
        }
        else if (s.equals("how're") || s.equals("howre")) {
            array[0] = "how";
            array[1] = "are";
        }
        else if (s.equals("i'd") || s.equals("id")) {
            array[0] = "i";
            array[1] = "had";
        }
        else if (s.equals("he'd") || s.equals("hed")) {
            array[0] = "he";
            array[1] = "had";
        }
        else if (s.equals("she'd") || s.equals("shed")) {
            array[0] = "she";
            array[1] = "had";
        }
        else if (s.equals("you'd") || s.equals("youd")) {
            array[0] = "you";
            array[1] = "had";
        }
        else if (s.equals("we'd") || s.equals("wed")) {
            array[0] = "we";
            array[1] = "had";
        }
        else if (s.equals("they'd") || s.equals("theyd")) {
            array[0] = "they";
            array[1] = "had";
        }
        else if (s.equals("it'd") || s.equals("itd")) {
            array[0] = "it";
            array[1] = "had";
        }
        else if (s.equals("that'd") || s.equals("thatd")) {
            array[0] = "that";
            array[1] = "had";
        }
        else if (s.equals("there'd") || s.equals("thered")) {
            array[0] = "there";
            array[1] = "had";
        }
        else if (s.equals("what'd") || s.equals("whatd")) {
            array[0] = "what";
            array[1] = "did";
        }
        else if (s.equals("when'd") || s.equals("whend")) {
            array[0] = "when";
            array[1] = "did";
        }
        else if (s.equals("where'd") || s.equals("whered")) {
            array[0] = "where";
            array[1] = "did";
        }
        else if (s.equals("who'd") || s.equals("whod")) {
            array[0] = "who";
            array[1] = "did";
        }
        else if (s.equals("why'd") || s.equals("whyd")) {
            array[0] = "why";
            array[1] = "did";
        }
        else if (s.equals("how'd") || s.equals("howd")) {
            array[0] = "how";
            array[1] = "did";
        }
        else if (s.equals("alot")) {
            array[0] = "lot";
        }
        else if (s.equals("em")) {
            array[0] = "them";
        }
        if (array[0] == null) {
            return null;
        }
        return array;
    }
    
    private static final boolean includeOriginalWord(final String s) {
        return s.equals("cant") || s.equals("wont") || s.equals("ill") || s.equals("shell") || s.equals("well") || s.equals("hell") || s.equals("were") || s.equals("whore") || s.equals("id") || s.equals("wed") || s.equals("shed");
    }
    
    private static final String deleteApostraphe(final String s) {
        final char[] charArray = s.toCharArray();
        final char[] array = new char[s.length()];
        int n = 0;
        for (int i = 0; i < charArray.length; ++i) {
            if (charArray[i] != '\'') {
                array[n] = charArray[i];
                ++n;
            }
        }
        return new String(array, 0, n);
    }
    
    private static final String RemoveUnnecessaryWords(final String s) {
        int i = 0;
        final String s2 = new String();
        String s3 = new String();
        int n = 1;
        while (i < s.length()) {
            while (i < s.length() && s.charAt(i) == ' ') {
                ++i;
            }
            final int n2 = i;
            while (i < s.length() && s.charAt(i) != ' ') {
                ++i;
            }
            final String substring = s.substring(n2, i);
            if (!substring.equals("a") && !substring.equals("an") && !substring.equals("the") && !substring.equals("teh")) {
                if (n == 0) {
                    s3 += ' ';
                }
                s3 += substring;
                n = 0;
            }
        }
        return s3;
    }
    
    private static final String RemoveIllegalCharacters(final String s, final Rete rete) {
        String s2 = new String();
        try {
            int i = 0;
            String string = new String();
            while (i < s.length()) {
                char char1 = s.charAt(i);
                char c = '\0';
                if (char1 == ',' || char1 == '.' || char1 == '!' || char1 == '?' || char1 == '-' || char1 == '/' || char1 == '\\' || char1 == '(' || char1 == ')' || char1 == '@' || char1 == '#' || char1 == '$' || char1 == '%' || char1 == '^' || char1 == '&' || char1 == '*' || char1 == '_' || char1 == '=' || char1 == '+' || char1 == '[' || char1 == ']' || char1 == '{' || char1 == '}' || char1 == ';' || char1 == ':' || char1 == '\"' || char1 == '<' || char1 == '>' || char1 == '`' || char1 == '~') {
                    if (char1 == '?' || char1 == ':' || char1 == ';') {
                        c = char1;
                    }
                    char1 = ' ';
                }
                string += char1;
                ++i;
                if (c == '?') {
                    addWOFact("questionmark", rete, 1, 1);
                }
                if (c == ':' || c == ';') {
                    int n = i;
                    String s3 = new String() + c;
                    boolean b = false;
                    boolean b2 = false;
                    for (boolean b3 = false; n < s.length() && !b && !b2 && !b3; ++n) {
                        final char char2 = s.charAt(n);
                        if (char2 == ')' || char2 == '}' || char2 == 'p' || char2 == 'd') {
                            b = true;
                        }
                        if (char2 == '(' || char2 == '{') {
                            b2 = true;
                        }
                        if (char2 == '-' || char2 == '0' || b || b2) {
                            s3 += char2;
                        }
                        else {
                            b3 = true;
                        }
                    }
                    if (s3.length() <= 1 || (!b && !b2)) {
                        continue;
                    }
                    System.out.println("got emoticon " + s3);
                    if (b) {
                        addWOFact(":)", rete, 1, 1);
                    }
                    if (!b2) {
                        continue;
                    }
                    addWOFact(":(", rete, 1, 1);
                }
            }
            for (int j = 0; j < string.length(); ++j) {
                if (string.charAt(j) != ' ' || (j != 0 && string.charAt(j - 1) != ' ')) {
                    s2 += string.charAt(j);
                }
            }
            if (s2.length() > 0 && s2.charAt(s2.length() - 1) == ' ') {
                s2 = s2.substring(0, s2.length() - 1);
            }
            if (s2.length() <= 0) {
                s2 = "nowords";
            }
        }
        catch (JessException ex) {
            JessExceptionHelper.processJessException(ex);
        }
        return s2;
    }
    
    public static void Process(String s, final Rete rete) {
        try {
            s = s.toLowerCase();
            s = RemoveUnnecessaryWords(s);
            s = RemoveIllegalCharacters(s, rete);
            System.out.println(" ");
            System.out.println("Begin NLU rules on: " + s);
            System.out.println(" ");
            System.out.println("ASSERTING " + s);
            final Fact fact = new Fact("SENTENCE", rete);
            final ValueVector valueVector = new ValueVector();
            valueVector.add(new Value(s, 2));
            fact.setSlotValue("__data", new Value(valueVector, 512));
            rete.assertFact(fact);
            final StringTokenizer stringTokenizer = new StringTokenizer(s);
            int n = 0;
            while (stringTokenizer.hasMoreTokens()) {
                ++n;
                final String nextToken = stringTokenizer.nextToken();
                final String[] expandContractions = expandContractions(nextToken);
                if (expandContractions == null) {
                    addWOFact(deleteApostraphe(nextToken), rete, n, n);
                }
                else {
                    if (includeOriginalWord(nextToken)) {
                        addWOFact(nextToken, rete, n, n + 1);
                    }
                    addWOFact(expandContractions[0], rete, n, n);
                    ++n;
                    addWOFact(expandContractions[1], rete, n, n);
                }
            }
            final Fact fact2 = new Fact("_wordcount", rete);
            final ValueVector valueVector2 = new ValueVector();
            valueVector2.add(new Value(n, 4));
            fact2.setSlotValue("__data", new Value(valueVector2, 512));
            rete.assertFact(fact2);
        }
        catch (JessException ex) {
            JessExceptionHelper.processJessException(ex);
        }
    }
}
