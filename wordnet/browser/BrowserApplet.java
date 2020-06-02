package wordnet.browser;

import java.net.URL;
import java.awt.Component;
import wordnet.wn.DictionaryDatabase;
import wordnet.wn.FileBackedDictionary;
import wordnet.wn.RemoteFileManager;
import java.applet.Applet;

public class BrowserApplet extends Applet
{
    public void init() {
        final URL codeBase = this.getCodeBase();
        System.out.println("url = " + codeBase);
        String s = codeBase.getHost();
        if (codeBase.getPort() != -1) {
            s = s + ':' + codeBase.getPort();
        }
        System.out.println("hostname = " + s);
        FileBackedDictionary fileBackedDictionary;
        try {
            fileBackedDictionary = new FileBackedDictionary(RemoteFileManager.lookup(s));
        }
        catch (Exception ex) {
            throw new RuntimeException(ex.toString());
        }
        System.out.println("dictionary = " + fileBackedDictionary);
        this.add(new BrowserPanel(fileBackedDictionary));
    }
}
