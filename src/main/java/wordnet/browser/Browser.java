package wordnet.browser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.awt.MenuShortcut;
import java.awt.Component;
import wordnet.wn.DictionaryDatabase;
import wordnet.wn.FileBackedDictionary;
import wordnet.wn.RemoteFileManager;
import java.rmi.registry.LocateRegistry;
import java.rmi.RMISecurityManager;
import java.awt.MenuItem;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.Frame;

public class Browser extends Frame
{
    protected MenuBar mainMenuBar;
    protected Menu fileMenu;
    protected MenuItem miSearch;
    protected MenuItem miExit;
    protected Menu editMenu;
    protected MenuItem miCut;
    protected MenuItem miCopy;
    protected MenuItem miPaste;
    protected Menu helpMenu;
    protected MenuItem miAbout;
    protected Frame searchWindow;
    
    public static void main(final String[] array) {
        String s = null;
        String s2 = null;
        boolean b = false;
        for (int i = 0; i < array.length; ++i) {
            if (array[i].equals("-hostname")) {
                s2 = array[++i];
            }
            else if (array[i].equals("-server")) {
                b = true;
            }
            else {
                if (array[i].startsWith("-") || s != null) {
                    displayUsageError();
                    return;
                }
                s = array[i];
            }
        }
        if (s2 != null && b) {
            displayUsageError();
            return;
        }
        if (b) {
            try {
                System.setSecurityManager(new RMISecurityManager());
                LocateRegistry.createRegistry(1099);
            }
            catch (Exception ex3) {}
            try {
                if (s != null) {
                    new RemoteFileManager(s).bind();
                }
                else {
                    new RemoteFileManager().bind();
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(ex.toString());
            }
            s2 = "127.0.0.1";
        }
        FileBackedDictionary fileBackedDictionary;
        if (s2 != null) {
            try {
                fileBackedDictionary = new FileBackedDictionary(RemoteFileManager.lookup(s2));
            }
            catch (Exception ex2) {
                throw new RuntimeException(ex2.toString());
            }
        }
        else if (s != null) {
            fileBackedDictionary = new FileBackedDictionary(s);
        }
        else {
            fileBackedDictionary = new FileBackedDictionary();
        }
        new Browser(fileBackedDictionary).setVisible(true);
    }
    
    protected static void displayUsageError() {
        System.err.println("usage: Browser [-hostname | -server] [searchDir]");
    }
    
    public Browser(final DictionaryDatabase dictionaryDatabase) {
        super("WordNet Browser");
        this.setVisible(false);
        this.setLocation(50, 50);
        this.setSize(500, 400);
        final BrowserPanel browserPanel = new BrowserPanel(dictionaryDatabase);
        this.add(browserPanel);
        this.mainMenuBar = new MenuBar();
        this.fileMenu = new Menu("File");
        this.miSearch = new MenuItem("Substring Search");
        this.fileMenu.add(this.miSearch);
        this.fileMenu.addSeparator();
        this.miExit = new MenuItem("Exit");
        this.fileMenu.add(this.miExit);
        this.mainMenuBar.add(this.fileMenu);
        this.editMenu = new Menu("Edit");
        (this.miCut = new MenuItem("Cut")).setShortcut(new MenuShortcut(88, false));
        this.editMenu.add(this.miCut);
        (this.miCopy = new MenuItem("Copy")).setShortcut(new MenuShortcut(67, false));
        this.editMenu.add(this.miCopy);
        (this.miPaste = new MenuItem("Paste")).setShortcut(new MenuShortcut(86, false));
        this.editMenu.add(this.miPaste);
        this.mainMenuBar.add(this.editMenu);
        this.helpMenu = new Menu("Help");
        this.mainMenuBar.setHelpMenu(this.helpMenu);
        this.miAbout = new MenuItem("About..");
        this.helpMenu.add(this.miAbout);
        this.mainMenuBar.add(this.helpMenu);
        this.setMenuBar(this.mainMenuBar);
        this.addWindowListener(new WindowAdapter() {
            public final void windowClosing(final WindowEvent windowEvent) {
                Browser.this.setVisible(false);
                Browser.this.dispose();
            }
        });
        final ActionListener actionListener = new ActionListener() {
            public final void actionPerformed(final ActionEvent actionEvent) {
                final Object source = actionEvent.getSource();
                final Browser this$0 = Browser.this;
                if (source == Browser.this.miAbout) {
                    new AboutDialog(this$0);
                }
                else if (source == Browser.this.miSearch) {
                    if (Browser.this.searchWindow == null) {
                        Browser.this.searchWindow = new SearchFrame(browserPanel);
                    }
                    Browser.this.searchWindow.toFront();
                    Browser.this.searchWindow.show();
                }
                else if (source == Browser.this.miExit) {
                    new QuitDialog(this$0, true).setVisible(true);
                }
            }
        };
        this.miSearch.addActionListener(actionListener);
        this.miAbout.addActionListener(actionListener);
        this.miExit.addActionListener(actionListener);
        this.setVisible(true);
    }
}
