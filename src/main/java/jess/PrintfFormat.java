package jess;

import java.util.Locale;
import java.util.Enumeration;
import java.text.DecimalFormatSymbols;
import java.util.Vector;

class PrintfFormat
{
    private Vector vFmt;
    private int cPos;
    private DecimalFormatSymbols dfs;
    
    private final String nonControl(final String s, final int n) {
        this.cPos = s.indexOf("%", n);
        if (this.cPos == -1) {
            this.cPos = s.length();
        }
        return s.substring(n, this.cPos);
    }
    
    public String sprintf(final Object[] array) {
        final Enumeration<ConversionSpecification> elements = this.vFmt.elements();
        int n = 0;
        final StringBuffer sb = new StringBuffer();
        while (elements.hasMoreElements()) {
            final ConversionSpecification conversionSpecification = elements.nextElement();
            final char conversionCharacter = conversionSpecification.getConversionCharacter();
            if (conversionCharacter == '\0') {
                sb.append(conversionSpecification.getLiteral());
            }
            else if (conversionCharacter == '%') {
                sb.append("%");
            }
            else if (conversionCharacter == 'n') {
                sb.append("\n");
            }
            else {
                if (conversionSpecification.isPositionalSpecification()) {
                    n = conversionSpecification.getArgumentPosition() - 1;
                    if (conversionSpecification.isPositionalFieldWidth()) {
                        conversionSpecification.setFieldWidthWithArg((int)array[conversionSpecification.getArgumentPositionForFieldWidth() - 1]);
                    }
                    if (conversionSpecification.isPositionalPrecision()) {
                        conversionSpecification.setPrecisionWithArg((int)array[conversionSpecification.getArgumentPositionForPrecision() - 1]);
                    }
                }
                else {
                    if (conversionSpecification.isVariableFieldWidth()) {
                        conversionSpecification.setFieldWidthWithArg((int)array[n]);
                        ++n;
                    }
                    if (conversionSpecification.isVariablePrecision()) {
                        conversionSpecification.setPrecisionWithArg((int)array[n]);
                        ++n;
                    }
                }
                if (array[n] instanceof Byte) {
                    sb.append(conversionSpecification.internalsprintf((byte)array[n]));
                }
                else if (array[n] instanceof Short) {
                    sb.append(conversionSpecification.internalsprintf((short)array[n]));
                }
                else if (array[n] instanceof Integer) {
                    sb.append(conversionSpecification.internalsprintf((int)array[n]));
                }
                else if (array[n] instanceof Long) {
                    sb.append(conversionSpecification.internalsprintf((long)array[n]));
                }
                else if (array[n] instanceof Float) {
                    sb.append(conversionSpecification.internalsprintf((float)array[n]));
                }
                else if (array[n] instanceof Double) {
                    sb.append(conversionSpecification.internalsprintf((double)array[n]));
                }
                else if (array[n] instanceof Character) {
                    sb.append(conversionSpecification.internalsprintf((char)array[n]));
                }
                else if (array[n] instanceof String) {
                    sb.append(conversionSpecification.internalsprintf((String)array[n]));
                }
                else {
                    sb.append(conversionSpecification.internalsprintf(array[n]));
                }
                if (conversionSpecification.isPositionalSpecification()) {
                    continue;
                }
                ++n;
            }
        }
        return sb.toString();
    }
    
    public String sprintf() {
        final Enumeration<ConversionSpecification> elements = this.vFmt.elements();
        final StringBuffer sb = new StringBuffer();
        while (elements.hasMoreElements()) {
            final ConversionSpecification conversionSpecification = elements.nextElement();
            final char conversionCharacter = conversionSpecification.getConversionCharacter();
            if (conversionCharacter == '\0') {
                sb.append(conversionSpecification.getLiteral());
            }
            else {
                if (conversionCharacter != '%') {
                    continue;
                }
                sb.append("%");
            }
        }
        return sb.toString();
    }
    
    public String sprintf(final int n) throws IllegalArgumentException {
        final Enumeration<ConversionSpecification> elements = this.vFmt.elements();
        final StringBuffer sb = new StringBuffer();
        while (elements.hasMoreElements()) {
            final ConversionSpecification conversionSpecification = elements.nextElement();
            final char conversionCharacter = conversionSpecification.getConversionCharacter();
            if (conversionCharacter == '\0') {
                sb.append(conversionSpecification.getLiteral());
            }
            else if (conversionCharacter == '%') {
                sb.append("%");
            }
            else {
                sb.append(conversionSpecification.internalsprintf(n));
            }
        }
        return sb.toString();
    }
    
    public String sprintf(final long n) throws IllegalArgumentException {
        final Enumeration<ConversionSpecification> elements = this.vFmt.elements();
        final StringBuffer sb = new StringBuffer();
        while (elements.hasMoreElements()) {
            final ConversionSpecification conversionSpecification = elements.nextElement();
            final char conversionCharacter = conversionSpecification.getConversionCharacter();
            if (conversionCharacter == '\0') {
                sb.append(conversionSpecification.getLiteral());
            }
            else if (conversionCharacter == '%') {
                sb.append("%");
            }
            else {
                sb.append(conversionSpecification.internalsprintf(n));
            }
        }
        return sb.toString();
    }
    
    public String sprintf(final double n) throws IllegalArgumentException {
        final Enumeration<ConversionSpecification> elements = this.vFmt.elements();
        final StringBuffer sb = new StringBuffer();
        while (elements.hasMoreElements()) {
            final ConversionSpecification conversionSpecification = elements.nextElement();
            final char conversionCharacter = conversionSpecification.getConversionCharacter();
            if (conversionCharacter == '\0') {
                sb.append(conversionSpecification.getLiteral());
            }
            else if (conversionCharacter == '%') {
                sb.append("%");
            }
            else {
                sb.append(conversionSpecification.internalsprintf(n));
            }
        }
        return sb.toString();
    }
    
    public String sprintf(final String s) throws IllegalArgumentException {
        final Enumeration<ConversionSpecification> elements = this.vFmt.elements();
        final StringBuffer sb = new StringBuffer();
        while (elements.hasMoreElements()) {
            final ConversionSpecification conversionSpecification = elements.nextElement();
            final char conversionCharacter = conversionSpecification.getConversionCharacter();
            if (conversionCharacter == '\0') {
                sb.append(conversionSpecification.getLiteral());
            }
            else if (conversionCharacter == '%') {
                sb.append("%");
            }
            else {
                sb.append(conversionSpecification.internalsprintf(s));
            }
        }
        return sb.toString();
    }
    
    public String sprintf(final Object o) throws IllegalArgumentException {
        final Enumeration<ConversionSpecification> elements = this.vFmt.elements();
        final StringBuffer sb = new StringBuffer();
        while (elements.hasMoreElements()) {
            final ConversionSpecification conversionSpecification = elements.nextElement();
            final char conversionCharacter = conversionSpecification.getConversionCharacter();
            if (conversionCharacter == '\0') {
                sb.append(conversionSpecification.getLiteral());
            }
            else if (conversionCharacter == '%') {
                sb.append("%");
            }
            else if (o instanceof Byte) {
                sb.append(conversionSpecification.internalsprintf((byte)o));
            }
            else if (o instanceof Short) {
                sb.append(conversionSpecification.internalsprintf((short)o));
            }
            else if (o instanceof Integer) {
                sb.append(conversionSpecification.internalsprintf((int)o));
            }
            else if (o instanceof Long) {
                sb.append(conversionSpecification.internalsprintf((long)o));
            }
            else if (o instanceof Float) {
                sb.append(conversionSpecification.internalsprintf((float)o));
            }
            else if (o instanceof Double) {
                sb.append(conversionSpecification.internalsprintf((double)o));
            }
            else if (o instanceof Character) {
                sb.append(conversionSpecification.internalsprintf((char)o));
            }
            else if (o instanceof String) {
                sb.append(conversionSpecification.internalsprintf((String)o));
            }
            else {
                sb.append(conversionSpecification.internalsprintf(o));
            }
        }
        return sb.toString();
    }
    
    private final /* synthetic */ void this() {
        this.vFmt = new Vector();
        this.cPos = 0;
        this.dfs = null;
    }
    
    public PrintfFormat(final String s) throws IllegalArgumentException {
        this(Locale.getDefault(), s);
    }
    
    public PrintfFormat(final Locale locale, final String s) throws IllegalArgumentException {
        this.this();
        this.dfs = new DecimalFormatSymbols(locale);
        final String nonControl = this.nonControl(s, 0);
        if (nonControl != null) {
            final ConversionSpecification conversionSpecification = new ConversionSpecification();
            conversionSpecification.setLiteral(nonControl);
            this.vFmt.addElement(conversionSpecification);
        }
        while (this.cPos != -1 && this.cPos < s.length()) {
            int i;
            for (i = this.cPos + 1; i < s.length(); ++i) {
                final char char1 = s.charAt(i);
                if (char1 == 'i') {
                    break;
                }
                if (char1 == 'd') {
                    break;
                }
                if (char1 == 'f') {
                    break;
                }
                if (char1 == 'g') {
                    break;
                }
                if (char1 == 'G') {
                    break;
                }
                if (char1 == 'o') {
                    break;
                }
                if (char1 == 'x') {
                    break;
                }
                if (char1 == 'X') {
                    break;
                }
                if (char1 == 'e') {
                    break;
                }
                if (char1 == 'E') {
                    break;
                }
                if (char1 == 'c') {
                    break;
                }
                if (char1 == 's') {
                    break;
                }
                if (char1 == 'n') {
                    break;
                }
                if (char1 == '%') {
                    break;
                }
            }
            final int min = Math.min(i + 1, s.length());
            this.vFmt.addElement(new ConversionSpecification(s.substring(this.cPos, min)));
            final String nonControl2 = this.nonControl(s, min);
            if (nonControl2 != null) {
                final ConversionSpecification conversionSpecification2 = new ConversionSpecification();
                conversionSpecification2.setLiteral(nonControl2);
                this.vFmt.addElement(conversionSpecification2);
            }
        }
    }
    
    private class ConversionSpecification
    {
        private static final int defaultDigits = 6;
        private boolean thousands;
        private boolean leftJustify;
        private boolean leadingSign;
        private boolean leadingSpace;
        private boolean alternateForm;
        private boolean leadingZeros;
        private boolean variableFieldWidth;
        private int fieldWidth;
        private boolean fieldWidthSet;
        private int precision;
        private boolean variablePrecision;
        private boolean precisionSet;
        private boolean positionalSpecification;
        private int argumentPosition;
        private boolean positionalFieldWidth;
        private int argumentPositionForFieldWidth;
        private boolean positionalPrecision;
        private int argumentPositionForPrecision;
        private boolean optionalh;
        private boolean optionall;
        private boolean optionalL;
        private char conversionCharacter;
        private int pos;
        private String fmt;
        
        void setLiteral(final String fmt) {
            this.fmt = fmt;
        }
        
        String getLiteral() {
            final StringBuffer sb = new StringBuffer();
            int i = 0;
            while (i < this.fmt.length()) {
                if (this.fmt.charAt(i) == '\\') {
                    if (++i < this.fmt.length()) {
                        switch (this.fmt.charAt(i)) {
                            case 'a': {
                                sb.append('\u0007');
                                break;
                            }
                            case 'b': {
                                sb.append('\b');
                                break;
                            }
                            case 'f': {
                                sb.append('\f');
                                break;
                            }
                            case 'n': {
                                sb.append(System.getProperty("line.separator"));
                                break;
                            }
                            case 'r': {
                                sb.append('\r');
                                break;
                            }
                            case 't': {
                                sb.append('\t');
                                break;
                            }
                            case 'v': {
                                sb.append('\u000b');
                                break;
                            }
                            case '\\': {
                                sb.append('\\');
                                break;
                            }
                        }
                        ++i;
                    }
                    else {
                        sb.append('\\');
                    }
                }
                else {
                    ++i;
                }
            }
            return this.fmt;
        }
        
        char getConversionCharacter() {
            return this.conversionCharacter;
        }
        
        boolean isVariableFieldWidth() {
            return this.variableFieldWidth;
        }
        
        void setFieldWidthWithArg(final int n) {
            if (n < 0) {
                this.leftJustify = true;
            }
            this.fieldWidthSet = true;
            this.fieldWidth = Math.abs(n);
        }
        
        boolean isVariablePrecision() {
            return this.variablePrecision;
        }
        
        void setPrecisionWithArg(final int n) {
            this.precisionSet = true;
            this.precision = Math.max(n, 0);
        }
        
        String internalsprintf(final int n) throws IllegalArgumentException {
            String s = null;
            switch (this.conversionCharacter) {
                case 'd':
                case 'i': {
                    if (this.optionalh) {
                        s = this.printDFormat((short)n);
                    }
                    else if (this.optionall) {
                        s = this.printDFormat((long)n);
                    }
                    else {
                        s = this.printDFormat(n);
                    }
                    break;
                }
                case 'X':
                case 'x': {
                    if (this.optionalh) {
                        s = this.printXFormat((short)n);
                    }
                    else if (this.optionall) {
                        s = this.printXFormat((long)n);
                    }
                    else {
                        s = this.printXFormat(n);
                    }
                    break;
                }
                case 'o': {
                    if (this.optionalh) {
                        s = this.printOFormat((short)n);
                    }
                    else if (this.optionall) {
                        s = this.printOFormat((long)n);
                    }
                    else {
                        s = this.printOFormat(n);
                    }
                    break;
                }
                case 'C':
                case 'c': {
                    s = this.printCFormat((char)n);
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Cannot format a int with a format using a " + this.conversionCharacter + " conversion character.");
                }
            }
            return s;
        }
        
        String internalsprintf(final long n) throws IllegalArgumentException {
            String s = null;
            switch (this.conversionCharacter) {
                case 'd':
                case 'i': {
                    if (this.optionalh) {
                        s = this.printDFormat((short)n);
                    }
                    else if (this.optionall) {
                        s = this.printDFormat(n);
                    }
                    else {
                        s = this.printDFormat((int)n);
                    }
                    break;
                }
                case 'X':
                case 'x': {
                    if (this.optionalh) {
                        s = this.printXFormat((short)n);
                    }
                    else if (this.optionall) {
                        s = this.printXFormat(n);
                    }
                    else {
                        s = this.printXFormat((int)n);
                    }
                    break;
                }
                case 'o': {
                    if (this.optionalh) {
                        s = this.printOFormat((short)n);
                    }
                    else if (this.optionall) {
                        s = this.printOFormat(n);
                    }
                    else {
                        s = this.printOFormat((int)n);
                    }
                    break;
                }
                case 'C':
                case 'c': {
                    s = this.printCFormat((char)n);
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Cannot format a long with a format using a " + this.conversionCharacter + " conversion character.");
                }
            }
            return s;
        }
        
        String internalsprintf(final double n) throws IllegalArgumentException {
            String s = null;
            switch (this.conversionCharacter) {
                case 'f': {
                    s = this.printFFormat(n);
                    break;
                }
                case 'E':
                case 'e': {
                    s = this.printEFormat(n);
                    break;
                }
                case 'G':
                case 'g': {
                    s = this.printGFormat(n);
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Cannot format a double with a format using a " + this.conversionCharacter + " conversion character.");
                }
            }
            return s;
        }
        
        String internalsprintf(final String s) throws IllegalArgumentException {
            if (this.conversionCharacter == 's' || this.conversionCharacter == 'S') {
                return this.printSFormat(s);
            }
            throw new IllegalArgumentException("Cannot format a String with a format using a " + this.conversionCharacter + " conversion character.");
        }
        
        String internalsprintf(final Object o) {
            if (this.conversionCharacter == 's' || this.conversionCharacter == 'S') {
                return this.printSFormat(o.toString());
            }
            throw new IllegalArgumentException("Cannot format a String with a format using a " + this.conversionCharacter + " conversion character.");
        }
        
        private final char[] fFormatDigits(final double n) {
            int int1 = 0;
            boolean b = false;
            String s;
            if (n > 0.0) {
                s = Double.toString(n);
            }
            else if (n < 0.0) {
                s = Double.toString(-n);
                b = true;
            }
            else {
                s = Double.toString(n);
                if (s.charAt(0) == '-') {
                    b = true;
                    s = s.substring(1);
                }
            }
            final int index = s.indexOf(69);
            final int index2 = s.indexOf(46);
            int length;
            if (index2 != -1) {
                length = index2;
            }
            else if (index != -1) {
                length = index;
            }
            else {
                length = s.length();
            }
            int n2;
            if (index2 != -1) {
                if (index != -1) {
                    n2 = index - index2 - 1;
                }
                else {
                    n2 = s.length() - index2 - 1;
                }
            }
            else {
                n2 = 0;
            }
            if (index != -1) {
                int n3 = index + 1;
                int1 = 0;
                if (s.charAt(n3) == '-') {
                    ++n3;
                    while (n3 < s.length() && s.charAt(n3) == '0') {
                        ++n3;
                    }
                    if (n3 < s.length()) {
                        int1 = -Integer.parseInt(s.substring(n3));
                    }
                }
                else {
                    if (s.charAt(n3) == '+') {
                        ++n3;
                    }
                    while (n3 < s.length() && s.charAt(n3) == '0') {
                        ++n3;
                    }
                    if (n3 < s.length()) {
                        int1 = Integer.parseInt(s.substring(n3));
                    }
                }
            }
            int precision;
            if (this.precisionSet) {
                precision = this.precision;
            }
            else {
                precision = 5;
            }
            final char[] charArray = s.toCharArray();
            final char[] array = new char[length + n2];
            int i;
            for (i = 0; i < length; ++i) {
                array[i] = charArray[i];
            }
            int n4 = i + 1;
            for (int j = 0; j < n2; ++j) {
                array[i] = charArray[n4];
                ++i;
                ++n4;
            }
            char[] array2;
            if (length + int1 <= 0) {
                array2 = new char[-int1 + n2];
                int n5 = 0;
                for (int k = 0; k < -length - int1; ++k, ++n5) {
                    array2[n5] = '0';
                }
                for (int l = 0; l < length + n2; ++l, ++n5) {
                    array2[n5] = array[l];
                }
            }
            else {
                array2 = array;
            }
            boolean b2 = false;
            if (precision < -int1 + n2) {
                int n6;
                if (int1 < 0) {
                    n6 = precision;
                }
                else {
                    n6 = precision + length;
                }
                b2 = this.checkForCarry(array2, n6);
                if (b2) {
                    b2 = this.startSymbolicCarry(array2, n6 - 1, 0);
                }
            }
            char[] array3;
            if (length + int1 <= 0) {
                array3 = new char[2 + precision];
                if (!b2) {
                    array3[0] = '0';
                }
                else {
                    array3[0] = '1';
                }
                if (this.alternateForm || !this.precisionSet || this.precision != 0) {
                    array3[1] = '.';
                    int n7;
                    int n8;
                    for (n7 = 0, n8 = 2; n7 < Math.min(precision, array2.length); ++n7, ++n8) {
                        array3[n8] = array2[n7];
                    }
                    while (n8 < array3.length) {
                        array3[n8] = '0';
                        ++n8;
                    }
                }
            }
            else {
                int n9;
                if (!b2) {
                    if (this.alternateForm || !this.precisionSet || this.precision != 0) {
                        array3 = new char[length + int1 + precision + 1];
                    }
                    else {
                        array3 = new char[length + int1];
                    }
                    n9 = 0;
                }
                else {
                    if (this.alternateForm || !this.precisionSet || this.precision != 0) {
                        array3 = new char[length + int1 + precision + 2];
                    }
                    else {
                        array3 = new char[length + int1 + 1];
                    }
                    array3[0] = '1';
                    n9 = 1;
                }
                int n10;
                for (n10 = 0; n10 < Math.min(length + int1, array2.length); ++n10, ++n9) {
                    array3[n9] = array2[n10];
                }
                while (n10 < length + int1) {
                    array3[n9] = '0';
                    ++n10;
                    ++n9;
                }
                if (this.alternateForm || !this.precisionSet || this.precision != 0) {
                    array3[n9] = '.';
                    ++n9;
                    for (int n11 = 0; n10 < array2.length && n11 < precision; ++n10, ++n9, ++n11) {
                        array3[n9] = array2[n10];
                    }
                    while (n9 < array3.length) {
                        array3[n9] = '0';
                        ++n9;
                    }
                }
            }
            int n12 = 0;
            if (!this.leftJustify && this.leadingZeros) {
                int n13 = 0;
                if (this.thousands) {
                    int n14 = 0;
                    if (array3[0] == '+' || array3[0] == '-' || array3[0] == ' ') {
                        n14 = 1;
                    }
                    int n15;
                    for (n15 = n14; n15 < array3.length && array3[n15] != '.'; ++n15) {}
                    n13 = (n15 - n14) / 3;
                }
                if (this.fieldWidthSet) {
                    n12 = this.fieldWidth - array3.length;
                }
                if ((!b && (this.leadingSign || this.leadingSpace)) || b) {
                    --n12;
                }
                n12 -= n13;
                if (n12 < 0) {
                    n12 = 0;
                }
            }
            int n16 = 0;
            char[] array4;
            if ((!b && (this.leadingSign || this.leadingSpace)) || b) {
                array4 = new char[array3.length + n12 + 1];
                ++n16;
            }
            else {
                array4 = new char[array3.length + n12];
            }
            if (!b) {
                if (this.leadingSign) {
                    array4[0] = '+';
                }
                if (this.leadingSpace) {
                    array4[0] = ' ';
                }
            }
            else {
                array4[0] = '-';
            }
            for (int n17 = 0; n17 < n12; ++n17, ++n16) {
                array4[n16] = '0';
            }
            for (int n18 = 0; n18 < array3.length; ++n18, ++n16) {
                array4[n16] = array3[n18];
            }
            int n19 = 0;
            if (array4[0] == '+' || array4[0] == '-' || array4[0] == ' ') {
                n19 = 1;
            }
            int n20;
            for (n20 = n19; n20 < array4.length && array4[n20] != '.'; ++n20) {}
            final int n21 = (n20 - n19) / 3;
            if (n20 < array4.length) {
                array4[n20] = PrintfFormat.this.dfs.getDecimalSeparator();
            }
            char[] array5 = array4;
            if (this.thousands && n21 > 0) {
                array5 = new char[array4.length + n21 + n19];
                array5[0] = array4[0];
                int n22 = n19;
                int n23 = n19;
                while (n22 < n20) {
                    if (n22 > 0 && (n20 - n22) % 3 == 0) {
                        array5[n23] = PrintfFormat.this.dfs.getGroupingSeparator();
                        array5[n23 + 1] = array4[n22];
                        n23 += 2;
                    }
                    else {
                        array5[n23] = array4[n22];
                        ++n23;
                    }
                    ++n22;
                }
                while (n22 < array4.length) {
                    array5[n23] = array4[n22];
                    ++n22;
                    ++n23;
                }
            }
            return array5;
        }
        
        private final String fFormatString(final double n) {
            char[] array;
            if (Double.isInfinite(n)) {
                if (n == Double.POSITIVE_INFINITY) {
                    if (this.leadingSign) {
                        array = "+Inf".toCharArray();
                    }
                    else if (this.leadingSpace) {
                        array = " Inf".toCharArray();
                    }
                    else {
                        array = "Inf".toCharArray();
                    }
                }
                else {
                    array = "-Inf".toCharArray();
                }
            }
            else if (Double.isNaN(n)) {
                if (this.leadingSign) {
                    array = "+NaN".toCharArray();
                }
                else if (this.leadingSpace) {
                    array = " NaN".toCharArray();
                }
                else {
                    array = "NaN".toCharArray();
                }
            }
            else {
                array = this.fFormatDigits(n);
            }
            return new String(this.applyFloatPadding(array, false));
        }
        
        private final char[] eFormatDigits(final double n, final char c) {
            int int1 = 0;
            boolean b = false;
            String s;
            if (n > 0.0) {
                s = Double.toString(n);
            }
            else if (n < 0.0) {
                s = Double.toString(-n);
                b = true;
            }
            else {
                s = Double.toString(n);
                if (s.charAt(0) == '-') {
                    b = true;
                    s = s.substring(1);
                }
            }
            int n2 = s.indexOf(69);
            if (n2 == -1) {
                n2 = s.indexOf(101);
            }
            final int index = s.indexOf(46);
            if (index == -1) {
                if (n2 == -1) {
                    s.length();
                }
            }
            if (index != -1) {
                if (n2 == -1) {
                    final int n3 = s.length() - index - 1;
                }
            }
            if (n2 != -1) {
                int n4 = n2 + 1;
                int1 = 0;
                if (s.charAt(n4) == '-') {
                    ++n4;
                    while (n4 < s.length() && s.charAt(n4) == '0') {
                        ++n4;
                    }
                    if (n4 < s.length()) {
                        int1 = -Integer.parseInt(s.substring(n4));
                    }
                }
                else {
                    if (s.charAt(n4) == '+') {
                        ++n4;
                    }
                    while (n4 < s.length() && s.charAt(n4) == '0') {
                        ++n4;
                    }
                    if (n4 < s.length()) {
                        int1 = Integer.parseInt(s.substring(n4));
                    }
                }
            }
            if (index != -1) {
                int1 += index - 1;
            }
            int precision;
            if (this.precisionSet) {
                precision = this.precision;
            }
            else {
                precision = 5;
            }
            char[] array;
            if (index != -1 && n2 != -1) {
                array = (s.substring(0, index) + s.substring(index + 1, n2)).toCharArray();
            }
            else if (index != -1) {
                array = (s.substring(0, index) + s.substring(index + 1)).toCharArray();
            }
            else if (n2 != -1) {
                array = s.substring(0, n2).toCharArray();
            }
            else {
                array = s.toCharArray();
            }
            int i;
            if (array[0] != '0') {
                i = 0;
            }
            else {
                for (i = 0; i < array.length; ++i) {
                    if (array[i] != '0') {
                        break;
                    }
                }
            }
            if (i + precision < array.length - 1) {
                boolean b2 = this.checkForCarry(array, i + precision + 1);
                if (b2) {
                    b2 = this.startSymbolicCarry(array, i + precision, i);
                }
                if (b2) {
                    final char[] array2 = new char[i + precision + 1];
                    array2[i] = '1';
                    for (int j = 0; j < i; ++j) {
                        array2[j] = '0';
                    }
                    int n5 = i;
                    for (int k = i + 1; k < precision + 1; ++k) {
                        array2[k] = array[n5];
                        ++n5;
                    }
                    ++int1;
                    array = array2;
                }
            }
            int n6;
            if (Math.abs(int1) < 100 && !this.optionalL) {
                n6 = 4;
            }
            else {
                n6 = 5;
            }
            char[] array3;
            if (this.alternateForm || !this.precisionSet || this.precision != 0) {
                array3 = new char[2 + precision + n6];
            }
            else {
                array3 = new char[1 + n6];
            }
            int n7;
            if (array[0] != '0') {
                array3[0] = array[0];
                n7 = 1;
            }
            else {
                for (n7 = 1; n7 < ((n2 == -1) ? array.length : n2) && array[n7] == '0'; ++n7) {}
                if ((n2 != -1 && n7 < n2) || (n2 == -1 && n7 < array.length)) {
                    array3[0] = array[n7];
                    int1 -= n7;
                    ++n7;
                }
                else {
                    array3[0] = '0';
                    n7 = 2;
                }
            }
            int l;
            if (this.alternateForm || !this.precisionSet || this.precision != 0) {
                array3[1] = '.';
                l = 2;
            }
            else {
                l = 1;
            }
            for (int n8 = 0; n8 < precision && n7 < array.length; ++n7, ++l, ++n8) {
                array3[l] = array[n7];
            }
            while (l < array3.length - n6) {
                array3[l] = '0';
                ++l;
            }
            array3[l++] = c;
            if (int1 < 0) {
                array3[l++] = '-';
            }
            else {
                array3[l++] = '+';
            }
            final int abs = Math.abs(int1);
            if (abs >= 100) {
                switch (abs / 100) {
                    case 1: {
                        array3[l] = '1';
                        break;
                    }
                    case 2: {
                        array3[l] = '2';
                        break;
                    }
                    case 3: {
                        array3[l] = '3';
                        break;
                    }
                    case 4: {
                        array3[l] = '4';
                        break;
                    }
                    case 5: {
                        array3[l] = '5';
                        break;
                    }
                    case 6: {
                        array3[l] = '6';
                        break;
                    }
                    case 7: {
                        array3[l] = '7';
                        break;
                    }
                    case 8: {
                        array3[l] = '8';
                        break;
                    }
                    case 9: {
                        array3[l] = '9';
                        break;
                    }
                }
                ++l;
            }
            switch (abs % 100 / 10) {
                case 0: {
                    array3[l] = '0';
                    break;
                }
                case 1: {
                    array3[l] = '1';
                    break;
                }
                case 2: {
                    array3[l] = '2';
                    break;
                }
                case 3: {
                    array3[l] = '3';
                    break;
                }
                case 4: {
                    array3[l] = '4';
                    break;
                }
                case 5: {
                    array3[l] = '5';
                    break;
                }
                case 6: {
                    array3[l] = '6';
                    break;
                }
                case 7: {
                    array3[l] = '7';
                    break;
                }
                case 8: {
                    array3[l] = '8';
                    break;
                }
                case 9: {
                    array3[l] = '9';
                    break;
                }
            }
            ++l;
            switch (abs % 10) {
                case 0: {
                    array3[l] = '0';
                    break;
                }
                case 1: {
                    array3[l] = '1';
                    break;
                }
                case 2: {
                    array3[l] = '2';
                    break;
                }
                case 3: {
                    array3[l] = '3';
                    break;
                }
                case 4: {
                    array3[l] = '4';
                    break;
                }
                case 5: {
                    array3[l] = '5';
                    break;
                }
                case 6: {
                    array3[l] = '6';
                    break;
                }
                case 7: {
                    array3[l] = '7';
                    break;
                }
                case 8: {
                    array3[l] = '8';
                    break;
                }
                case 9: {
                    array3[l] = '9';
                    break;
                }
            }
            int n9 = 0;
            if (!this.leftJustify && this.leadingZeros) {
                int n10 = 0;
                if (this.thousands) {
                    int n11 = 0;
                    if (array3[0] == '+' || array3[0] == '-' || array3[0] == ' ') {
                        n11 = 1;
                    }
                    int n12;
                    for (n12 = n11; n12 < array3.length && array3[n12] != '.'; ++n12) {}
                    n10 = (n12 - n11) / 3;
                }
                if (this.fieldWidthSet) {
                    n9 = this.fieldWidth - array3.length;
                }
                if ((!b && (this.leadingSign || this.leadingSpace)) || b) {
                    --n9;
                }
                n9 -= n10;
                if (n9 < 0) {
                    n9 = 0;
                }
            }
            int n13 = 0;
            char[] array4;
            if ((!b && (this.leadingSign || this.leadingSpace)) || b) {
                array4 = new char[array3.length + n9 + 1];
                ++n13;
            }
            else {
                array4 = new char[array3.length + n9];
            }
            if (!b) {
                if (this.leadingSign) {
                    array4[0] = '+';
                }
                if (this.leadingSpace) {
                    array4[0] = ' ';
                }
            }
            else {
                array4[0] = '-';
            }
            for (int n14 = 0; n14 < n9; ++n14) {
                array4[n13] = '0';
                ++n13;
            }
            for (int n15 = 0; n15 < array3.length && n13 < array4.length; ++n15, ++n13) {
                array4[n13] = array3[n15];
            }
            int n16 = 0;
            if (array4[0] == '+' || array4[0] == '-' || array4[0] == ' ') {
                n16 = 1;
            }
            int n17;
            for (n17 = n16; n17 < array4.length && array4[n17] != '.'; ++n17) {}
            final int n18 = n17 / 3;
            if (n17 < array4.length) {
                array4[n17] = PrintfFormat.this.dfs.getDecimalSeparator();
            }
            char[] array5 = array4;
            if (this.thousands && n18 > 0) {
                array5 = new char[array4.length + n18 + n16];
                array5[0] = array4[0];
                int n19 = n16;
                int n20 = n16;
                while (n19 < n17) {
                    if (n19 > 0 && (n17 - n19) % 3 == 0) {
                        array5[n20] = PrintfFormat.this.dfs.getGroupingSeparator();
                        array5[n20 + 1] = array4[n19];
                        n20 += 2;
                    }
                    else {
                        array5[n20] = array4[n19];
                        ++n20;
                    }
                    ++n19;
                }
                while (n19 < array4.length) {
                    array5[n20] = array4[n19];
                    ++n19;
                    ++n20;
                }
            }
            return array5;
        }
        
        private final boolean checkForCarry(final char[] array, final int n) {
            boolean b = false;
            if (n < array.length) {
                if (array[n] == '6' || array[n] == '7' || array[n] == '8' || array[n] == '9') {
                    b = true;
                }
                else if (array[n] == '5') {
                    int n2;
                    for (n2 = n + 1; n2 < array.length && array[n2] == '0'; ++n2) {}
                    boolean b2 = false;
                    if (n2 < array.length) {
                        b2 = true;
                    }
                    b = b2;
                    if (!b && n > 0) {
                        boolean b3 = false;
                        if (array[n - 1] == '1' || array[n - 1] == '3' || array[n - 1] == '5' || array[n - 1] == '7' || array[n - 1] == '9') {
                            b3 = true;
                        }
                        b = b3;
                    }
                }
            }
            return b;
        }
        
        private final boolean startSymbolicCarry(final char[] array, final int n, final int n2) {
            boolean b = true;
            for (int n3 = n; b && n3 >= n2; --n3) {
                b = false;
                switch (array[n3]) {
                    case '0': {
                        array[n3] = '1';
                        break;
                    }
                    case '1': {
                        array[n3] = '2';
                        break;
                    }
                    case '2': {
                        array[n3] = '3';
                        break;
                    }
                    case '3': {
                        array[n3] = '4';
                        break;
                    }
                    case '4': {
                        array[n3] = '5';
                        break;
                    }
                    case '5': {
                        array[n3] = '6';
                        break;
                    }
                    case '6': {
                        array[n3] = '7';
                        break;
                    }
                    case '7': {
                        array[n3] = '8';
                        break;
                    }
                    case '8': {
                        array[n3] = '9';
                        break;
                    }
                    case '9': {
                        array[n3] = '0';
                        b = true;
                        break;
                    }
                }
            }
            return b;
        }
        
        private final String eFormatString(final double n, final char c) {
            char[] array;
            if (Double.isInfinite(n)) {
                if (n == Double.POSITIVE_INFINITY) {
                    if (this.leadingSign) {
                        array = "+Inf".toCharArray();
                    }
                    else if (this.leadingSpace) {
                        array = " Inf".toCharArray();
                    }
                    else {
                        array = "Inf".toCharArray();
                    }
                }
                else {
                    array = "-Inf".toCharArray();
                }
            }
            else if (Double.isNaN(n)) {
                if (this.leadingSign) {
                    array = "+NaN".toCharArray();
                }
                else if (this.leadingSpace) {
                    array = " NaN".toCharArray();
                }
                else {
                    array = "NaN".toCharArray();
                }
            }
            else {
                array = this.eFormatDigits(n, c);
            }
            return new String(this.applyFloatPadding(array, false));
        }
        
        private final char[] applyFloatPadding(final char[] array, final boolean b) {
            char[] array2 = array;
            if (this.fieldWidthSet) {
                if (this.leftJustify) {
                    final int n = this.fieldWidth - array.length;
                    if (n > 0) {
                        array2 = new char[array.length + n];
                        int i;
                        for (i = 0; i < array.length; ++i) {
                            array2[i] = array[i];
                        }
                        for (int j = 0; j < n; ++j, ++i) {
                            array2[i] = ' ';
                        }
                    }
                }
                else if (!this.leadingZeros || b) {
                    final int n2 = this.fieldWidth - array.length;
                    if (n2 > 0) {
                        array2 = new char[array.length + n2];
                        int k;
                        for (k = 0; k < n2; ++k) {
                            array2[k] = ' ';
                        }
                        for (int l = 0; l < array.length; ++l) {
                            array2[k] = array[l];
                            ++k;
                        }
                    }
                }
                else if (this.leadingZeros) {
                    final int n3 = this.fieldWidth - array.length;
                    if (n3 > 0) {
                        array2 = new char[array.length + n3];
                        int n4 = 0;
                        int n5 = 0;
                        if (array[0] == '-') {
                            array2[0] = '-';
                            ++n4;
                            ++n5;
                        }
                        for (int n6 = 0; n6 < n3; ++n6) {
                            array2[n4] = '0';
                            ++n4;
                        }
                        while (n5 < array.length) {
                            array2[n4] = array[n5];
                            ++n4;
                            ++n5;
                        }
                    }
                }
            }
            return array2;
        }
        
        private final String printFFormat(final double n) {
            return this.fFormatString(n);
        }
        
        private final String printEFormat(final double n) {
            if (this.conversionCharacter == 'e') {
                return this.eFormatString(n, 'e');
            }
            return this.eFormatString(n, 'E');
        }
        
        private final String printGFormat(final double n) {
            final int precision = this.precision;
            char[] array;
            if (Double.isInfinite(n)) {
                if (n == Double.POSITIVE_INFINITY) {
                    if (this.leadingSign) {
                        array = "+Inf".toCharArray();
                    }
                    else if (this.leadingSpace) {
                        array = " Inf".toCharArray();
                    }
                    else {
                        array = "Inf".toCharArray();
                    }
                }
                else {
                    array = "-Inf".toCharArray();
                }
            }
            else if (Double.isNaN(n)) {
                if (this.leadingSign) {
                    array = "+NaN".toCharArray();
                }
                else if (this.leadingSpace) {
                    array = " NaN".toCharArray();
                }
                else {
                    array = "NaN".toCharArray();
                }
            }
            else {
                if (!this.precisionSet) {
                    this.precision = 6;
                }
                if (this.precision == 0) {
                    this.precision = 1;
                }
                String s;
                int n2;
                if (this.conversionCharacter == 'g') {
                    s = this.eFormatString(n, 'e').trim();
                    n2 = s.indexOf(101);
                }
                else {
                    s = this.eFormatString(n, 'E').trim();
                    n2 = s.indexOf(69);
                }
                int n3 = n2 + 1;
                int int1 = 0;
                if (s.charAt(n3) == '-') {
                    ++n3;
                    while (n3 < s.length() && s.charAt(n3) == '0') {
                        ++n3;
                    }
                    if (n3 < s.length()) {
                        int1 = -Integer.parseInt(s.substring(n3));
                    }
                }
                else {
                    if (s.charAt(n3) == '+') {
                        ++n3;
                    }
                    while (n3 < s.length() && s.charAt(n3) == '0') {
                        ++n3;
                    }
                    if (n3 < s.length()) {
                        int1 = Integer.parseInt(s.substring(n3));
                    }
                }
                String s4;
                if (!this.alternateForm) {
                    String s2;
                    if (int1 >= -4 && int1 < this.precision) {
                        s2 = this.fFormatString(n).trim();
                    }
                    else {
                        s2 = s.substring(0, n2);
                    }
                    int n4;
                    for (n4 = s2.length() - 1; n4 >= 0 && s2.charAt(n4) == '0'; --n4) {}
                    if (n4 >= 0 && s2.charAt(n4) == '.') {
                        --n4;
                    }
                    String s3;
                    if (n4 == -1) {
                        s3 = "0";
                    }
                    else if (!Character.isDigit(s2.charAt(n4))) {
                        s3 = s2.substring(0, n4 + 1) + '0';
                    }
                    else {
                        s3 = s2.substring(0, n4 + 1);
                    }
                    if (int1 >= -4 && int1 < this.precision) {
                        s4 = s3;
                    }
                    else {
                        s4 = s3 + s.substring(n2);
                    }
                }
                else if (int1 >= -4 && int1 < this.precision) {
                    s4 = this.fFormatString(n).trim();
                }
                else {
                    s4 = s;
                }
                if (this.leadingSpace && n >= 0.0) {
                    s4 = " " + s4;
                }
                array = s4.toCharArray();
            }
            final char[] applyFloatPadding = this.applyFloatPadding(array, false);
            this.precision = precision;
            return new String(applyFloatPadding);
        }
        
        private final String printDFormat(final short n) {
            return this.printDFormat(Short.toString(n));
        }
        
        private final String printDFormat(final long n) {
            return this.printDFormat(Long.toString(n));
        }
        
        private final String printDFormat(final int n) {
            return this.printDFormat(Integer.toString(n));
        }
        
        private final String printDFormat(String s) {
            int n = 0;
            int n2 = 0;
            int n3 = 0;
            int i = 0;
            int n4 = 0;
            if (s.charAt(0) == '-') {
                n4 = 1;
            }
            final int n5 = n4;
            if (s.equals("0") && this.precisionSet && this.precision == 0) {
                s = "";
            }
            if (n5 == 0) {
                if (this.precisionSet && s.length() < this.precision) {
                    n = this.precision - s.length();
                }
            }
            else if (this.precisionSet && s.length() - 1 < this.precision) {
                n = this.precision - s.length() + 1;
            }
            if (n < 0) {
                n = 0;
            }
            if (this.fieldWidthSet) {
                n2 = this.fieldWidth - n - s.length();
                if (n5 == 0 && (this.leadingSign || this.leadingSpace)) {
                    --n2;
                }
            }
            if (n2 < 0) {
                n2 = 0;
            }
            if (this.leadingSign) {
                ++n3;
            }
            else if (this.leadingSpace) {
                ++n3;
            }
            final char[] array = new char[n3 + n2 + n + s.length()];
            if (this.leftJustify) {
                if (n5 != 0) {
                    array[i++] = '-';
                }
                else if (this.leadingSign) {
                    array[i++] = '+';
                }
                else if (this.leadingSpace) {
                    array[i++] = ' ';
                }
                final char[] charArray = s.toCharArray();
                final int n6 = n5;
                for (int j = 0; j < n; ++j) {
                    array[i] = '0';
                    ++i;
                }
                for (int k = n6; k < charArray.length; ++k, ++i) {
                    array[i] = charArray[k];
                }
                for (int l = 0; l < n2; ++l) {
                    array[i] = ' ';
                    ++i;
                }
            }
            else {
                if (!this.leadingZeros) {
                    for (i = 0; i < n2; ++i) {
                        array[i] = ' ';
                    }
                    if (n5 != 0) {
                        array[i++] = '-';
                    }
                    else if (this.leadingSign) {
                        array[i++] = '+';
                    }
                    else if (this.leadingSpace) {
                        array[i++] = ' ';
                    }
                }
                else {
                    if (n5 != 0) {
                        array[i++] = '-';
                    }
                    else if (this.leadingSign) {
                        array[i++] = '+';
                    }
                    else if (this.leadingSpace) {
                        array[i++] = ' ';
                    }
                    for (int n7 = 0; n7 < n2; ++n7, ++i) {
                        array[i] = '0';
                    }
                }
                for (int n8 = 0; n8 < n; ++n8, ++i) {
                    array[i] = '0';
                }
                final char[] charArray2 = s.toCharArray();
                for (int n9 = n5; n9 < charArray2.length; ++n9, ++i) {
                    array[i] = charArray2[n9];
                }
            }
            return new String(array);
        }
        
        private final String printXFormat(final short n) {
            String s = null;
            if (n == -32768) {
                s = "8000";
            }
            else if (n < 0) {
                String s2;
                if (n == -32768) {
                    s2 = "0";
                }
                else {
                    s2 = Integer.toString(~(-n - 1) ^ 0xFFFF8000, 16);
                    if (s2.charAt(0) == 'F' || s2.charAt(0) == 'f') {
                        s2 = s2.substring(16, 32);
                    }
                }
                Label_0403: {
                    switch (s2.length()) {
                        case 1: {
                            s = "800" + s2;
                            break;
                        }
                        case 2: {
                            s = "80" + s2;
                            break;
                        }
                        case 3: {
                            s = "8" + s2;
                            break;
                        }
                        case 4: {
                            switch (s2.charAt(0)) {
                                case '1': {
                                    s = "9" + s2.substring(1, 4);
                                    break Label_0403;
                                }
                                case '2': {
                                    s = "a" + s2.substring(1, 4);
                                    break Label_0403;
                                }
                                case '3': {
                                    s = "b" + s2.substring(1, 4);
                                    break Label_0403;
                                }
                                case '4': {
                                    s = "c" + s2.substring(1, 4);
                                    break Label_0403;
                                }
                                case '5': {
                                    s = "d" + s2.substring(1, 4);
                                    break Label_0403;
                                }
                                case '6': {
                                    s = "e" + s2.substring(1, 4);
                                    break Label_0403;
                                }
                                case '7': {
                                    s = "f" + s2.substring(1, 4);
                                    break Label_0403;
                                }
                            }
                            break;
                        }
                    }
                }
            }
            else {
                s = Integer.toString(n, 16);
            }
            return this.printXFormat(s);
        }
        
        private final String printXFormat(final long n) {
            String s = null;
            if (n == Long.MIN_VALUE) {
                s = "8000000000000000";
            }
            else if (n < 0L) {
                final String string = Long.toString(-n - 1L ^ -1L ^ Long.MIN_VALUE, 16);
                Label_0697: {
                    switch (string.length()) {
                        case 1: {
                            s = "800000000000000" + string;
                            break;
                        }
                        case 2: {
                            s = "80000000000000" + string;
                            break;
                        }
                        case 3: {
                            s = "8000000000000" + string;
                            break;
                        }
                        case 4: {
                            s = "800000000000" + string;
                            break;
                        }
                        case 5: {
                            s = "80000000000" + string;
                            break;
                        }
                        case 6: {
                            s = "8000000000" + string;
                            break;
                        }
                        case 7: {
                            s = "800000000" + string;
                            break;
                        }
                        case 8: {
                            s = "80000000" + string;
                            break;
                        }
                        case 9: {
                            s = "8000000" + string;
                            break;
                        }
                        case 10: {
                            s = "800000" + string;
                            break;
                        }
                        case 11: {
                            s = "80000" + string;
                            break;
                        }
                        case 12: {
                            s = "8000" + string;
                            break;
                        }
                        case 13: {
                            s = "800" + string;
                            break;
                        }
                        case 14: {
                            s = "80" + string;
                            break;
                        }
                        case 15: {
                            s = "8" + string;
                            break;
                        }
                        case 16: {
                            switch (string.charAt(0)) {
                                case '1': {
                                    s = "9" + string.substring(1, 16);
                                    break Label_0697;
                                }
                                case '2': {
                                    s = "a" + string.substring(1, 16);
                                    break Label_0697;
                                }
                                case '3': {
                                    s = "b" + string.substring(1, 16);
                                    break Label_0697;
                                }
                                case '4': {
                                    s = "c" + string.substring(1, 16);
                                    break Label_0697;
                                }
                                case '5': {
                                    s = "d" + string.substring(1, 16);
                                    break Label_0697;
                                }
                                case '6': {
                                    s = "e" + string.substring(1, 16);
                                    break Label_0697;
                                }
                                case '7': {
                                    s = "f" + string.substring(1, 16);
                                    break Label_0697;
                                }
                            }
                            break;
                        }
                    }
                }
            }
            else {
                s = Long.toString(n, 16);
            }
            return this.printXFormat(s);
        }
        
        private final String printXFormat(final int n) {
            String s = null;
            if (n == Integer.MIN_VALUE) {
                s = "80000000";
            }
            else if (n < 0) {
                final String string = Integer.toString(~(-n - 1) ^ Integer.MIN_VALUE, 16);
                Label_0470: {
                    switch (string.length()) {
                        case 1: {
                            s = "8000000" + string;
                            break;
                        }
                        case 2: {
                            s = "800000" + string;
                            break;
                        }
                        case 3: {
                            s = "80000" + string;
                            break;
                        }
                        case 4: {
                            s = "8000" + string;
                            break;
                        }
                        case 5: {
                            s = "800" + string;
                            break;
                        }
                        case 6: {
                            s = "80" + string;
                            break;
                        }
                        case 7: {
                            s = "8" + string;
                            break;
                        }
                        case 8: {
                            switch (string.charAt(0)) {
                                case '1': {
                                    s = "9" + string.substring(1, 8);
                                    break Label_0470;
                                }
                                case '2': {
                                    s = "a" + string.substring(1, 8);
                                    break Label_0470;
                                }
                                case '3': {
                                    s = "b" + string.substring(1, 8);
                                    break Label_0470;
                                }
                                case '4': {
                                    s = "c" + string.substring(1, 8);
                                    break Label_0470;
                                }
                                case '5': {
                                    s = "d" + string.substring(1, 8);
                                    break Label_0470;
                                }
                                case '6': {
                                    s = "e" + string.substring(1, 8);
                                    break Label_0470;
                                }
                                case '7': {
                                    s = "f" + string.substring(1, 8);
                                    break Label_0470;
                                }
                            }
                            break;
                        }
                    }
                }
            }
            else {
                s = Integer.toString(n, 16);
            }
            return this.printXFormat(s);
        }
        
        private final String printXFormat(String s) {
            int n = 0;
            int n2 = 0;
            if (s.equals("0") && this.precisionSet && this.precision == 0) {
                s = "";
            }
            if (this.precisionSet) {
                n = this.precision - s.length();
            }
            if (n < 0) {
                n = 0;
            }
            if (this.fieldWidthSet) {
                n2 = this.fieldWidth - n - s.length();
                if (this.alternateForm) {
                    n2 -= 2;
                }
            }
            if (n2 < 0) {
                n2 = 0;
            }
            int n3 = 0;
            if (this.alternateForm) {
                n3 += 2;
            }
            final char[] array = new char[n3 + n + s.length() + n2];
            int n4 = 0;
            if (this.leftJustify) {
                if (this.alternateForm) {
                    array[n4++] = '0';
                    array[n4++] = 'x';
                }
                for (int i = 0; i < n; ++i, ++n4) {
                    array[n4] = '0';
                }
                final char[] charArray = s.toCharArray();
                for (int j = 0; j < charArray.length; ++j, ++n4) {
                    array[n4] = charArray[j];
                }
                for (int k = 0; k < n2; ++k, ++n4) {
                    array[n4] = ' ';
                }
            }
            else {
                if (!this.leadingZeros) {
                    for (int l = 0; l < n2; ++l, ++n4) {
                        array[n4] = ' ';
                    }
                }
                if (this.alternateForm) {
                    array[n4++] = '0';
                    array[n4++] = 'x';
                }
                if (this.leadingZeros) {
                    for (int n5 = 0; n5 < n2; ++n5, ++n4) {
                        array[n4] = '0';
                    }
                }
                for (int n6 = 0; n6 < n; ++n6, ++n4) {
                    array[n4] = '0';
                }
                final char[] charArray2 = s.toCharArray();
                for (int n7 = 0; n7 < charArray2.length; ++n7, ++n4) {
                    array[n4] = charArray2[n7];
                }
            }
            String upperCase = new String(array);
            if (this.conversionCharacter == 'X') {
                upperCase = upperCase.toUpperCase();
            }
            return upperCase;
        }
        
        private final String printOFormat(final short n) {
            String s = null;
            if (n == -32768) {
                s = "100000";
            }
            else if (n < 0) {
                final String string = Integer.toString(~(-n - 1) ^ 0xFFFF8000, 8);
                switch (string.length()) {
                    case 1: {
                        s = "10000" + string;
                        break;
                    }
                    case 2: {
                        s = "1000" + string;
                        break;
                    }
                    case 3: {
                        s = "100" + string;
                        break;
                    }
                    case 4: {
                        s = "10" + string;
                        break;
                    }
                    case 5: {
                        s = "1" + string;
                        break;
                    }
                }
            }
            else {
                s = Integer.toString(n, 8);
            }
            return this.printOFormat(s);
        }
        
        private final String printOFormat(final long n) {
            String s = null;
            if (n == Long.MIN_VALUE) {
                s = "1000000000000000000000";
            }
            else if (n < 0L) {
                final String string = Long.toString(-n - 1L ^ -1L ^ Long.MIN_VALUE, 8);
                switch (string.length()) {
                    case 1: {
                        s = "100000000000000000000" + string;
                        break;
                    }
                    case 2: {
                        s = "10000000000000000000" + string;
                        break;
                    }
                    case 3: {
                        s = "1000000000000000000" + string;
                        break;
                    }
                    case 4: {
                        s = "100000000000000000" + string;
                        break;
                    }
                    case 5: {
                        s = "10000000000000000" + string;
                        break;
                    }
                    case 6: {
                        s = "1000000000000000" + string;
                        break;
                    }
                    case 7: {
                        s = "100000000000000" + string;
                        break;
                    }
                    case 8: {
                        s = "10000000000000" + string;
                        break;
                    }
                    case 9: {
                        s = "1000000000000" + string;
                        break;
                    }
                    case 10: {
                        s = "100000000000" + string;
                        break;
                    }
                    case 11: {
                        s = "10000000000" + string;
                        break;
                    }
                    case 12: {
                        s = "1000000000" + string;
                        break;
                    }
                    case 13: {
                        s = "100000000" + string;
                        break;
                    }
                    case 14: {
                        s = "10000000" + string;
                        break;
                    }
                    case 15: {
                        s = "1000000" + string;
                        break;
                    }
                    case 16: {
                        s = "100000" + string;
                        break;
                    }
                    case 17: {
                        s = "10000" + string;
                        break;
                    }
                    case 18: {
                        s = "1000" + string;
                        break;
                    }
                    case 19: {
                        s = "100" + string;
                        break;
                    }
                    case 20: {
                        s = "10" + string;
                        break;
                    }
                    case 21: {
                        s = "1" + string;
                        break;
                    }
                }
            }
            else {
                s = Long.toString(n, 8);
            }
            return this.printOFormat(s);
        }
        
        private final String printOFormat(final int n) {
            String s = null;
            if (n == Integer.MIN_VALUE) {
                s = "20000000000";
            }
            else if (n < 0) {
                final String string = Integer.toString(~(-n - 1) ^ Integer.MIN_VALUE, 8);
                switch (string.length()) {
                    case 1: {
                        s = "2000000000" + string;
                        break;
                    }
                    case 2: {
                        s = "200000000" + string;
                        break;
                    }
                    case 3: {
                        s = "20000000" + string;
                        break;
                    }
                    case 4: {
                        s = "2000000" + string;
                        break;
                    }
                    case 5: {
                        s = "200000" + string;
                        break;
                    }
                    case 6: {
                        s = "20000" + string;
                        break;
                    }
                    case 7: {
                        s = "2000" + string;
                        break;
                    }
                    case 8: {
                        s = "200" + string;
                        break;
                    }
                    case 9: {
                        s = "20" + string;
                        break;
                    }
                    case 10: {
                        s = "2" + string;
                        break;
                    }
                    case 11: {
                        s = "3" + string.substring(1);
                        break;
                    }
                }
            }
            else {
                s = Integer.toString(n, 8);
            }
            return this.printOFormat(s);
        }
        
        private final String printOFormat(String s) {
            int n = 0;
            int n2 = 0;
            if (s.equals("0") && this.precisionSet && this.precision == 0) {
                s = "";
            }
            if (this.precisionSet) {
                n = this.precision - s.length();
            }
            if (this.alternateForm) {
                ++n;
            }
            if (n < 0) {
                n = 0;
            }
            if (this.fieldWidthSet) {
                n2 = this.fieldWidth - n - s.length();
            }
            if (n2 < 0) {
                n2 = 0;
            }
            final char[] array = new char[n + s.length() + n2];
            if (this.leftJustify) {
                int i;
                for (i = 0; i < n; ++i) {
                    array[i] = '0';
                }
                final char[] charArray = s.toCharArray();
                for (int j = 0; j < charArray.length; ++j, ++i) {
                    array[i] = charArray[j];
                }
                for (int k = 0; k < n2; ++k, ++i) {
                    array[i] = ' ';
                }
            }
            else {
                int l;
                if (this.leadingZeros) {
                    for (l = 0; l < n2; ++l) {
                        array[l] = '0';
                    }
                }
                else {
                    for (l = 0; l < n2; ++l) {
                        array[l] = ' ';
                    }
                }
                for (int n3 = 0; n3 < n; ++n3, ++l) {
                    array[l] = '0';
                }
                final char[] charArray2 = s.toCharArray();
                for (int n4 = 0; n4 < charArray2.length; ++n4, ++l) {
                    array[l] = charArray2[n4];
                }
            }
            return new String(array);
        }
        
        private final String printCFormat(final char c) {
            final int n = 1;
            int fieldWidth = this.fieldWidth;
            if (!this.fieldWidthSet) {
                fieldWidth = n;
            }
            final char[] array = new char[fieldWidth];
            if (this.leftJustify) {
                array[0] = c;
                for (int i = 1; i <= fieldWidth - n; ++i) {
                    array[i] = ' ';
                }
            }
            else {
                int j;
                for (j = 0; j < fieldWidth - n; ++j) {
                    array[j] = ' ';
                }
                array[j] = c;
            }
            return new String(array);
        }
        
        private final String printSFormat(final String s) {
            int n = s.length();
            int fieldWidth = this.fieldWidth;
            if (this.precisionSet && n > this.precision) {
                n = this.precision;
            }
            if (!this.fieldWidthSet) {
                fieldWidth = n;
            }
            int n2 = 0;
            if (fieldWidth > n) {
                n2 += fieldWidth - n;
            }
            int n3;
            if (n >= s.length()) {
                n3 = n2 + s.length();
            }
            else {
                n3 = n2 + n;
            }
            final char[] array = new char[n3];
            if (this.leftJustify) {
                int i;
                if (n >= s.length()) {
                    final char[] charArray = s.toCharArray();
                    for (i = 0; i < s.length(); ++i) {
                        array[i] = charArray[i];
                    }
                }
                else {
                    final char[] charArray2 = s.substring(0, n).toCharArray();
                    for (i = 0; i < n; ++i) {
                        array[i] = charArray2[i];
                    }
                }
                for (int j = 0; j < fieldWidth - n; ++j, ++i) {
                    array[i] = ' ';
                }
            }
            else {
                int k;
                for (k = 0; k < fieldWidth - n; ++k) {
                    array[k] = ' ';
                }
                if (n >= s.length()) {
                    final char[] charArray3 = s.toCharArray();
                    for (int l = 0; l < s.length(); ++l) {
                        array[k] = charArray3[l];
                        ++k;
                    }
                }
                else {
                    final char[] charArray4 = s.substring(0, n).toCharArray();
                    for (int n4 = 0; n4 < n; ++n4) {
                        array[k] = charArray4[n4];
                        ++k;
                    }
                }
            }
            return new String(array);
        }
        
        private final boolean setConversionCharacter() {
            boolean b = false;
            this.conversionCharacter = '\0';
            if (this.pos < this.fmt.length()) {
                final char char1 = this.fmt.charAt(this.pos);
                if (char1 == 'i' || char1 == 'd' || char1 == 'f' || char1 == 'g' || char1 == 'G' || char1 == 'o' || char1 == 'x' || char1 == 'X' || char1 == 'e' || char1 == 'E' || char1 == 'c' || char1 == 's' || char1 == '%' || char1 == 'n') {
                    this.conversionCharacter = char1;
                    ++this.pos;
                    b = true;
                }
            }
            return b;
        }
        
        private final void setOptionalHL() {
            this.optionalh = false;
            this.optionall = false;
            this.optionalL = false;
            if (this.pos < this.fmt.length()) {
                final char char1 = this.fmt.charAt(this.pos);
                if (char1 == 'h') {
                    this.optionalh = true;
                    ++this.pos;
                }
                else if (char1 == 'l') {
                    this.optionall = true;
                    ++this.pos;
                }
                else if (char1 == 'L') {
                    this.optionalL = true;
                    ++this.pos;
                }
            }
        }
        
        private final void setPrecision() {
            final int pos = this.pos;
            this.precisionSet = false;
            if (this.pos < this.fmt.length() && this.fmt.charAt(this.pos) == '.') {
                ++this.pos;
                if (this.pos < this.fmt.length() && this.fmt.charAt(this.pos) == '*') {
                    ++this.pos;
                    if (!this.setPrecisionArgPosition()) {
                        this.variablePrecision = true;
                        this.precisionSet = true;
                    }
                    return;
                }
                while (this.pos < this.fmt.length() && Character.isDigit(this.fmt.charAt(this.pos))) {
                    ++this.pos;
                }
                if (this.pos > pos + 1) {
                    this.precision = Integer.parseInt(this.fmt.substring(pos + 1, this.pos));
                    this.precisionSet = true;
                }
            }
        }
        
        private final void setFieldWidth() {
            final int pos = this.pos;
            this.fieldWidth = 0;
            this.fieldWidthSet = false;
            if (this.pos < this.fmt.length() && this.fmt.charAt(this.pos) == '*') {
                ++this.pos;
                if (!this.setFieldWidthArgPosition()) {
                    this.variableFieldWidth = true;
                    this.fieldWidthSet = true;
                }
            }
            else {
                while (this.pos < this.fmt.length() && Character.isDigit(this.fmt.charAt(this.pos))) {
                    ++this.pos;
                }
                if (pos < this.pos && pos < this.fmt.length()) {
                    this.fieldWidth = Integer.parseInt(this.fmt.substring(pos, this.pos));
                    this.fieldWidthSet = true;
                }
            }
        }
        
        private final void setArgPosition() {
            int pos;
            for (pos = this.pos; pos < this.fmt.length() && Character.isDigit(this.fmt.charAt(pos)); ++pos) {}
            if (pos > this.pos && pos < this.fmt.length() && this.fmt.charAt(pos) == '$') {
                this.positionalSpecification = true;
                this.argumentPosition = Integer.parseInt(this.fmt.substring(this.pos, pos));
                this.pos = pos + 1;
            }
        }
        
        private final boolean setFieldWidthArgPosition() {
            boolean b = false;
            int pos;
            for (pos = this.pos; pos < this.fmt.length() && Character.isDigit(this.fmt.charAt(pos)); ++pos) {}
            if (pos > this.pos && pos < this.fmt.length() && this.fmt.charAt(pos) == '$') {
                this.positionalFieldWidth = true;
                this.argumentPositionForFieldWidth = Integer.parseInt(this.fmt.substring(this.pos, pos));
                this.pos = pos + 1;
                b = true;
            }
            return b;
        }
        
        private final boolean setPrecisionArgPosition() {
            boolean b = false;
            int pos;
            for (pos = this.pos; pos < this.fmt.length() && Character.isDigit(this.fmt.charAt(pos)); ++pos) {}
            if (pos > this.pos && pos < this.fmt.length() && this.fmt.charAt(pos) == '$') {
                this.positionalPrecision = true;
                this.argumentPositionForPrecision = Integer.parseInt(this.fmt.substring(this.pos, pos));
                this.pos = pos + 1;
                b = true;
            }
            return b;
        }
        
        boolean isPositionalSpecification() {
            return this.positionalSpecification;
        }
        
        int getArgumentPosition() {
            return this.argumentPosition;
        }
        
        boolean isPositionalFieldWidth() {
            return this.positionalFieldWidth;
        }
        
        int getArgumentPositionForFieldWidth() {
            return this.argumentPositionForFieldWidth;
        }
        
        boolean isPositionalPrecision() {
            return this.positionalPrecision;
        }
        
        int getArgumentPositionForPrecision() {
            return this.argumentPositionForPrecision;
        }
        
        private final void setFlagCharacters() {
            this.thousands = false;
            this.leftJustify = false;
            this.leadingSign = false;
            this.leadingSpace = false;
            this.alternateForm = false;
            this.leadingZeros = false;
            while (this.pos < this.fmt.length()) {
                final char char1 = this.fmt.charAt(this.pos);
                if (char1 == '\'') {
                    this.thousands = true;
                }
                else if (char1 == '-') {
                    this.leftJustify = true;
                    this.leadingZeros = false;
                }
                else if (char1 == '+') {
                    this.leadingSign = true;
                    this.leadingSpace = false;
                }
                else if (char1 == ' ') {
                    if (!this.leadingSign) {
                        this.leadingSpace = true;
                    }
                }
                else if (char1 == '#') {
                    this.alternateForm = true;
                }
                else {
                    if (char1 != '0') {
                        break;
                    }
                    if (!this.leftJustify) {
                        this.leadingZeros = true;
                    }
                }
                ++this.pos;
            }
        }
        
        private final /* synthetic */ void this() {
            this.thousands = false;
            this.leftJustify = false;
            this.leadingSign = false;
            this.leadingSpace = false;
            this.alternateForm = false;
            this.leadingZeros = false;
            this.variableFieldWidth = false;
            this.fieldWidth = 0;
            this.fieldWidthSet = false;
            this.precision = 0;
            this.variablePrecision = false;
            this.precisionSet = false;
            this.positionalSpecification = false;
            this.argumentPosition = 0;
            this.positionalFieldWidth = false;
            this.argumentPositionForFieldWidth = 0;
            this.positionalPrecision = false;
            this.argumentPositionForPrecision = 0;
            this.optionalh = false;
            this.optionall = false;
            this.optionalL = false;
            this.conversionCharacter = '\0';
            this.pos = 0;
        }
        
        ConversionSpecification() {
            this.this();
        }
        
        ConversionSpecification(final String fmt) throws IllegalArgumentException {
            this.this();
            if (fmt == null) {
                throw new NullPointerException();
            }
            if (fmt.length() == 0) {
                throw new IllegalArgumentException("Control strings must have positive lengths.");
            }
            if (fmt.charAt(0) != '%') {
                throw new IllegalArgumentException("Control strings must begin with %.");
            }
            this.fmt = fmt;
            this.pos = 1;
            this.setArgPosition();
            this.setFlagCharacters();
            this.setFieldWidth();
            this.setPrecision();
            this.setOptionalHL();
            if (!this.setConversionCharacter()) {
                throw new IllegalArgumentException("Malformed conversion specification=" + fmt);
            }
            if (this.pos == fmt.length()) {
                if (this.leadingZeros && this.leftJustify) {
                    this.leadingZeros = false;
                }
                if (this.precisionSet && this.leadingZeros && (this.conversionCharacter == 'd' || this.conversionCharacter == 'i' || this.conversionCharacter == 'o' || this.conversionCharacter == 'x')) {
                    this.leadingZeros = false;
                }
                return;
            }
            throw new IllegalArgumentException("Malformed conversion specification=" + fmt);
        }
    }
}
