package wordnet.browser;

import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Component;
import java.awt.Label;
import java.awt.Panel;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.LayoutManager;
import java.awt.GridBagLayout;
import java.util.Enumeration;
import wordnet.wn.IndexWord;
import java.util.Vector;
import wordnet.wn.POS;
import java.awt.List;
import java.awt.TextField;
import wordnet.wn.DictionaryDatabase;
import java.awt.Frame;

class SearchFrame extends Frame
{
    protected BrowserPanel browser;
    protected DictionaryDatabase dictionary;
    protected TextField searchField;
    protected List resultList;
    protected POS pos;
    
    protected void recomputeResults() {
        final String text = this.searchField.getText();
        this.resultList.removeAll();
        this.resultList.add("Searching for " + text + "...");
        this.resultList.setEnabled(false);
        final Vector<String> vector = new Vector<String>();
        final Enumeration searchIndexWords = this.dictionary.searchIndexWords(this.pos, text);
        while (searchIndexWords.hasMoreElements()) {
            vector.addElement(searchIndexWords.nextElement().getLemma());
        }
        this.resultList.removeAll();
        final Enumeration<String> elements = vector.elements();
        while (elements.hasMoreElements()) {
            this.resultList.add(elements.nextElement());
        }
        this.resultList.setEnabled(true);
    }
    
    private final /* synthetic */ void this() {
        this.pos = POS.CATS[0];
    }
    
    SearchFrame(final BrowserPanel browser) {
        super("Substring Search");
        this.this();
        this.browser = browser;
        this.dictionary = browser.dictionary;
        this.setVisible(false);
        this.setSize(400, 300);
        this.setLocation(browser.getLocation().x + 20, browser.getLocation().y + 20);
        this.setLayout(new GridBagLayout());
        final GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = 1;
        final Panel panel = new Panel(new FlowLayout(0));
        panel.add(new Label("Substring"));
        (this.searchField = new TextField("", 20)).setBackground(Color.white);
        panel.add(this.searchField);
        this.searchField.addActionListener(new ActionListener() {
            public final void actionPerformed(final ActionEvent actionEvent) {
                SearchFrame.this.recomputeResults();
            }
        });
        final Choice choice = new Choice();
        for (int i = 0; i < POS.CATS.length; ++i) {
            choice.add(POS.CATS[i].getLabel());
        }
        choice.addItemListener(new ItemListener() {
            public final void itemStateChanged(final ItemEvent itemEvent) {
                SearchFrame.this.pos = POS.CATS[((Choice)itemEvent.getSource()).getSelectedIndex()];
            }
        });
        panel.add(choice);
        this.add(panel, gridBagConstraints);
        gridBagConstraints.gridx = 0;
        final GridBagConstraints gridBagConstraints2 = gridBagConstraints;
        final GridBagConstraints gridBagConstraints3 = gridBagConstraints;
        final double n = 1.0;
        gridBagConstraints3.weighty = n;
        gridBagConstraints2.weightx = n;
        (this.resultList = new List()).setBackground(Color.white);
        this.resultList.addActionListener(new ActionListener() {
            public final void actionPerformed(final ActionEvent actionEvent) {
                SearchFrame.this.browser.setWord(SearchFrame.this.dictionary.lookupIndexWord(SearchFrame.this.pos, SearchFrame.this.resultList.getSelectedItem()));
            }
        });
        this.add(this.resultList, gridBagConstraints);
        this.addWindowListener(new WindowAdapter() {
            public final void windowClosing(final WindowEvent windowEvent) {
                SearchFrame.this.setVisible(false);
            }
        });
        this.validate();
        this.setVisible(true);
        this.searchField.requestFocus();
    }
}
