package jess;

class ParseException extends JessException
{
    ParseException(final String s, final String s2) {
        super(s, s2, "");
    }
}
