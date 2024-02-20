package wordnet.wn;

import java.util.Enumeration;

public interface DictionaryDatabase
{
    IndexWord lookupIndexWord(final POS p0, final String p1);
    
    String lookupBaseForm(final POS p0, final String p1);
    
    Enumeration searchIndexWords(final POS p0, final String p1);
    
    Enumeration synsets(final POS p0);
}
