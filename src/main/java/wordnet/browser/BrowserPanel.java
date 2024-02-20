package wordnet.browser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Label;
import wordnet.wn.PointerTarget;
import wordnet.wn.Synset;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import wordnet.wn.IndexWord;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import wordnet.wn.PointerType;
import java.util.Vector;
import wordnet.wn.POS;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.FlowLayout;
import java.awt.Choice;
import java.awt.Checkbox;
import java.awt.TextArea;
import java.awt.TextField;
import wordnet.wn.DictionaryDatabase;
import java.awt.Panel;

public class BrowserPanel extends Panel
{
    protected DictionaryDatabase dictionary;
    protected TextField searchField;
    protected TextArea resultTextArea;
    protected Checkbox[] posBoxes;
    protected Choice[] posChoices;
    
    public void setVisible(final boolean visible) {
        this.searchField.requestFocus();
        super.setVisible(visible);
    }
    
    protected Panel makePointerPanel() {
        final Panel panel = new Panel();
        panel.setLayout(new FlowLayout(0));
        panel.setBackground(Color.lightGray);
        final CheckboxGroup checkboxGroup = new CheckboxGroup();
        for (int i = 0; i < POS.CATS.length; ++i) {
            final POS pos = POS.CATS[i];
            final Checkbox[] posBoxes = this.posBoxes;
            final int n = i;
            final Checkbox checkbox = new Checkbox(pos.getLabel(), checkboxGroup, false);
            posBoxes[n] = checkbox;
            final Checkbox checkbox2 = checkbox;
            final Choice[] posChoices = this.posChoices;
            final int n2 = i;
            final Choice choice = new Choice();
            posChoices[n2] = choice;
            final Choice choice2 = choice;
            final Vector<PointerType> vector = new Vector<PointerType>();
            choice2.addItem("Senses");
            for (int j = 0; j < PointerType.TYPES.length; ++j) {
                final PointerType pointerType = PointerType.TYPES[j];
                if (pointerType.appliesTo(pos)) {
                    choice2.addItem(pointerType.getLabel());
                    vector.addElement(pointerType);
                }
            }
            final ItemListener itemListener = new ItemListener() {
                final /* synthetic */ Vector val$pointerTypes = vector;
                
                public final void itemStateChanged(final ItemEvent itemEvent) {
                    checkboxGroup.setSelectedCheckbox(checkbox2);
                    final IndexWord lookupIndexWord = BrowserPanel.this.dictionary.lookupIndexWord(pos, BrowserPanel.this.searchField.getText());
                    final int selectedIndex = choice2.getSelectedIndex();
                    if (selectedIndex == 0) {
                        BrowserPanel.this.displaySenses(lookupIndexWord);
                    }
                    else {
                        BrowserPanel.this.displaySenseChain(lookupIndexWord, (PointerType)this.val$pointerTypes.elementAt(selectedIndex - 1));
                    }
                }
            };
            checkbox2.addItemListener(itemListener);
            choice2.addItemListener(itemListener);
            final Panel panel2 = new Panel(new GridBagLayout());
            final GridBagConstraints gridBagConstraints = new GridBagConstraints();
            panel2.add(checkbox2, gridBagConstraints);
            gridBagConstraints.gridy = -1;
            gridBagConstraints.gridx = 0;
            panel2.add(choice2, gridBagConstraints);
            panel.add(panel2);
            checkbox2.setEnabled(false);
            choice2.setEnabled(false);
        }
        return panel;
    }
    
    synchronized void setWord(final IndexWord indexWord) {
        this.searchField.setText(indexWord.getLemma());
        this.displayOverview();
    }
    
    protected synchronized void displayOverview() {
        final String text = this.searchField.getText();
        final StringBuffer sb = new StringBuffer();
        int n = 0;
        for (int i = 0; i < POS.CATS.length; ++i) {
            final IndexWord lookupIndexWord = this.dictionary.lookupIndexWord(POS.CATS[i], text);
            this.appendSenses(lookupIndexWord, sb);
            int n2 = 0;
            if (lookupIndexWord != null) {
                n2 = 1;
            }
            final boolean b = n2 != 0;
            this.posBoxes[i].setEnabled(b);
            this.posChoices[i].setEnabled(b);
            n |= (b ? 1 : 0);
        }
        if (n == 0) {
            sb.append("\"" + text + "\" is not defined.");
        }
        this.resultTextArea.setText(sb.toString());
    }
    
    protected synchronized void displaySenses(final IndexWord indexWord) {
        final StringBuffer sb = new StringBuffer();
        this.appendSenses(indexWord, sb);
        this.resultTextArea.setText(sb.toString());
    }
    
    protected void appendSenses(final IndexWord indexWord, final StringBuffer sb) {
        if (indexWord != null) {
            final Synset[] senses = indexWord.getSenses();
            final int taggedSenseCount = indexWord.getTaggedSenseCount();
            sb.append("The " + indexWord.getPOS().getLabel() + ' ' + indexWord.getLemma() + " has " + senses.length + " sense" + ((senses.length == 1) ? "" : "s") + ' ');
            sb.append("(");
            if (taggedSenseCount == 0) {
                sb.append("no senses from tagged texts");
            }
            else {
                sb.append("first " + taggedSenseCount + " from tagged texts");
            }
            sb.append(")\n\n");
            for (int i = 0; i < senses.length; ++i) {
                sb.append(i + 1 + ". " + senses[i].getLongDescription());
                sb.append('\n');
            }
            sb.append('\n');
        }
    }
    
    protected synchronized void displaySenseChain(final IndexWord indexWord, final PointerType pointerType) {
        final StringBuffer sb = new StringBuffer();
        final Synset[] senses = indexWord.getSenses();
        sb.append(senses.length + " senses of " + indexWord.getLemma() + "\n\n");
        for (int i = 0; i < senses.length; ++i) {
            if (senses[i].getTargets(pointerType).length > 0) {
                sb.append("Sense " + (i + 1) + '\n');
                PointerType hypernym = PointerType.HYPERNYM;
                PointerType pointerType2 = pointerType;
                if (pointerType.equals(hypernym) || pointerType.symmetricTo(hypernym)) {
                    hypernym = pointerType;
                    pointerType2 = null;
                }
                this.appendSenseChain(sb, senses[i], hypernym, pointerType2);
                sb.append('\n');
            }
        }
        this.resultTextArea.setText(sb.toString());
    }
    
    void appendSenseChain(final StringBuffer sb, final PointerTarget pointerTarget, final PointerType pointerType, final PointerType pointerType2) {
        this.appendSenseChain(sb, pointerTarget, pointerType, pointerType2, 0, null);
    }
    
    void appendSenseChain(final StringBuffer sb, final PointerTarget pointerTarget, final PointerType pointerType, final PointerType pointerType2, final int n, final Link link) {
        for (int i = 0; i < n; ++i) {
            sb.append(' ');
        }
        if (n > 0) {
            sb.append("<=v ");
        }
        sb.append(pointerTarget.getDescription());
        sb.append('\n');
        if (pointerType2 != null) {
            final PointerTarget[] targets = pointerTarget.getTargets(pointerType2);
            for (int j = 0; j < targets.length; ++j) {
                for (int k = 0; k < n; ++k) {
                    sb.append(' ');
                }
                sb.append(pointerType2.getLabel());
                sb.append(":  ");
                sb.append(targets[j].getDescription());
                sb.append('\n');
            }
        }
        if (link == null || !link.contains(pointerTarget)) {
            final Link link2 = new Link(pointerTarget, link);
            final PointerTarget[] targets2 = pointerTarget.getTargets(pointerType);
            for (int l = 0; l < targets2.length; ++l) {
                this.appendSenseChain(sb, targets2[l], pointerType, pointerType2, n + 4, link2);
            }
        }
    }
    
    private final /* synthetic */ void this() {
        this.posBoxes = new Checkbox[POS.CATS.length];
        this.posChoices = new Choice[POS.CATS.length];
    }
    
    public BrowserPanel(final DictionaryDatabase dictionary) {
        this.this();
        this.dictionary = dictionary;
        this.setLayout(new GridBagLayout());
        final GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = -1;
        gridBagConstraints.fill = 1;
        final Panel panel = new Panel(new FlowLayout(0));
        panel.setBackground(Color.lightGray);
        panel.add(new Label("Search IndexWord:"));
        (this.searchField = new TextField("", 20)).setBackground(Color.white);
        panel.add(this.searchField);
        this.add(panel, gridBagConstraints);
        this.add(this.makePointerPanel(), gridBagConstraints);
        final GridBagConstraints gridBagConstraints2 = gridBagConstraints;
        final GridBagConstraints gridBagConstraints3 = gridBagConstraints;
        final double n = 1.0;
        gridBagConstraints3.weighty = n;
        gridBagConstraints2.weightx = n;
        (this.resultTextArea = new TextArea(80, 24)).setBackground(Color.white);
        this.resultTextArea.setEditable(false);
        this.add(this.resultTextArea, gridBagConstraints);
        this.searchField.addActionListener(new ActionListener() {
            public final void actionPerformed(final ActionEvent actionEvent) {
                BrowserPanel.this.displayOverview();
            }
        });
        this.validate();
    }
    
    protected class Link
    {
        Object object;
        Link link;
        
        boolean contains(final Object o) {
            for (Link link = this; link != null; link = link.link) {
                if (link.object.equals(o)) {
                    return true;
                }
            }
            return false;
        }
        
        Link(final Object object, final Link link) {
            this.object = object;
            this.link = link;
        }
    }
}
