package wm;

import javax.swing.KeyStroke;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;
import java.lang.reflect.Method;
import javax.swing.JOptionPane;
import java.lang.reflect.InvocationTargetException;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.JTextPane;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JMenuItem;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import java.awt.LayoutManager;
import java.awt.Container;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.JScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeModel;
import java.util.Collection;
import javax.swing.tree.TreePath;
import java.util.LinkedList;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.JPopupMenu;
import javax.swing.JCheckBox;
import javax.swing.JTree;
import javax.swing.JPanel;

public class WorkingMemoryDebugger extends JPanel
{
    private static final int wmeEditButtonContainerHeight = 47;
    private static final int labelAndFieldHeight = 21;
    private static final int minimumEditFieldWidth = 20;
    private static final int labelFieldHSeparation = 20;
    private WorkingMemory wmBeingDebugged;
    private JTree wmTree;
    private JCheckBox wmUpdateTreeButton;
    private JPopupMenu classNodePopup;
    private JPopupMenu wmeNodePopup;
    private JPopupMenu noNodePopup;
    private WME selectedWME;
    private String selectedClass;
    
    private final LinkedList getAllLeafPaths(final TreeNode treeNode, final DefaultTreeModel defaultTreeModel) {
        final LinkedList<TreePath> list = new LinkedList<TreePath>();
        final int childCount = treeNode.getChildCount();
        if (childCount == 0) {
            list.add(new TreePath(defaultTreeModel.getPathToRoot(treeNode)));
            return list;
        }
        for (int i = 0; i < childCount; ++i) {
            list.addAll(this.getAllLeafPaths(treeNode.getChildAt(i), defaultTreeModel));
        }
        return list;
    }
    
    public void update() {
        this.wmTree.setModel(this.wmBeingDebugged.getWMTreeModel());
    }
    
    public void updateIfMonitoring() {
        if (this.wmUpdateTreeButton.isSelected()) {
            this.update();
        }
    }

    public void clearWMView() {
        this.wmTree.setModel(new DefaultTreeModel(new DefaultMutableTreeNode()));
    }

    static /* synthetic */ void access$3(final WorkingMemoryDebugger workingMemoryDebugger, final String selectedClass) {
        workingMemoryDebugger.selectedClass = selectedClass;
    }

    static /* synthetic */ void access$6(final WorkingMemoryDebugger workingMemoryDebugger, final WME selectedWME) {
        workingMemoryDebugger.selectedWME = selectedWME;
    }

    public WorkingMemoryDebugger(final WorkingMemory wmBeingDebugged) {
        this.wmBeingDebugged = null;
        this.wmTree = null;
        this.wmUpdateTreeButton = null;
        (this.wmBeingDebugged = wmBeingDebugged).setWMDebugger(this);
        (this.wmTree = new JTree(this.wmBeingDebugged.getWMTreeModel())).setCellRenderer(new WMCellRenderer());
        this.wmTree.setRootVisible(false);
        (this.wmUpdateTreeButton = new JCheckBox("Continuously update working memory")).addActionListener(new ActionListener() {
            public final void actionPerformed(final ActionEvent actionEvent) {
                if (WorkingMemoryDebugger.this.wmUpdateTreeButton.isSelected()) {
                    WorkingMemoryDebugger.this.update();
                }
            }
        });
        final JScrollPane scrollPane = new JScrollPane(this.wmTree);
        scrollPane.getViewport().setScrollMode(2);
        this.setLayout(new BoxLayout(this, 1));
        this.add(this.wmUpdateTreeButton);
        this.add(scrollPane);
        this.setBorder(BorderFactory.createTitledBorder("Working Memory"));
        final PopupMenuActionListener popupMenuActionListener = new PopupMenuActionListener();
        this.classNodePopup = new JPopupMenu();
        final JMenuItem menuItem = new JMenuItem("Add...");
        menuItem.addActionListener(popupMenuActionListener);
        this.classNodePopup.add(menuItem);
        final JMenuItem menuItem2 = new JMenuItem("Delete all");
        menuItem2.addActionListener(popupMenuActionListener);
        this.classNodePopup.add(menuItem2);
        this.wmeNodePopup = new JPopupMenu();
        final JMenuItem menuItem3 = new JMenuItem("Modify...");
        menuItem3.addActionListener(popupMenuActionListener);
        this.wmeNodePopup.add(menuItem3);
        final JMenuItem menuItem4 = new JMenuItem("Delete");
        menuItem4.addActionListener(popupMenuActionListener);
        this.wmeNodePopup.add(menuItem4);
        this.noNodePopup = new JPopupMenu();
        final JMenuItem menuItem5 = new JMenuItem("Add WME...");
        menuItem5.addActionListener(popupMenuActionListener);
        this.noNodePopup.add(menuItem5);
        this.wmTree.addMouseListener(new MouseAdapter() {
            public final void mouseClicked(final MouseEvent mouseEvent) {
                if ((mouseEvent.getModifiers() & 0x4) == 0x4) {
                    final TreePath pathForLocation = WorkingMemoryDebugger.this.wmTree.getPathForLocation(mouseEvent.getX(), mouseEvent.getY());
                    if (pathForLocation != null) {
                        final WorkingMemory.WMTreeNode wmTreeNode = (WorkingMemory.WMTreeNode)pathForLocation.getLastPathComponent();
                        if (wmTreeNode.getIsClassNode()) {
                            WorkingMemoryDebugger.access$3(WorkingMemoryDebugger.this, (String)wmTreeNode.getUserObject());
                            WorkingMemoryDebugger.this.classNodePopup.show(mouseEvent.getComponent(), mouseEvent.getX(), mouseEvent.getY());
                        }
                        else {
                            WorkingMemoryDebugger.access$6(WorkingMemoryDebugger.this, (WME)wmTreeNode.getUserObject());
                            WorkingMemoryDebugger.this.wmeNodePopup.show(mouseEvent.getComponent(), mouseEvent.getX(), mouseEvent.getY());
                        }
                    }
                    else {
                        WorkingMemoryDebugger.this.noNodePopup.show(mouseEvent.getComponent(), mouseEvent.getX(), mouseEvent.getY());
                    }
                }
            }
        });
    }
    
    class PopupMenuActionListener implements ActionListener
    {
        public void actionPerformed(final ActionEvent actionEvent) {
            final String actionCommand = actionEvent.getActionCommand();
            if (actionCommand.equals("Delete")) {
                WorkingMemoryDebugger.this.wmBeingDebugged.deleteWME(WorkingMemoryDebugger.this.selectedWME);
            }
            else if (actionCommand.equals("Delete all")) {
                WorkingMemoryDebugger.this.wmBeingDebugged.deleteAllWMEClass(WorkingMemoryDebugger.this.selectedClass);
            }
            else if (actionCommand.equals("Add...")) {
                new AddWMEDialog(WorkingMemoryDebugger.this.wmBeingDebugged.lookupWME(WorkingMemoryDebugger.this.selectedClass).get(0).getClass()).setVisible(true);
            }
            else if (actionCommand.equals("Modify...")) {
                new ModifyWMEDialog(WorkingMemoryDebugger.this.selectedWME).setVisible(true);
            }
            else if (actionCommand.equals("Add WME...")) {
                new ChooseWMEDialog().setVisible(true);
            }
            if (!WorkingMemoryDebugger.this.wmUpdateTreeButton.isSelected()) {
                WorkingMemoryDebugger.this.update();
            }
        }
    }
    
    protected class WMCellRenderer extends JTextPane implements TreeCellRenderer
    {
        private final DefaultTreeCellRenderer defaultRenderer;
        
        public Component getTreeCellRendererComponent(final JTree tree, final Object o, final boolean b, final boolean b2, final boolean b3, final int n, final boolean b4) {
            if (b2) {
                this.defaultRenderer.getOpenIcon();
            }
            else if (b3) {
                this.defaultRenderer.getLeafIcon();
            }
            else {
                this.defaultRenderer.getClosedIcon();
            }
            Color background;
            if (b) {
                background = this.defaultRenderer.getBackgroundSelectionColor();
            }
            else {
                background = this.defaultRenderer.getBackgroundNonSelectionColor();
            }
            final DefaultMutableTreeNode defaultMutableTreeNode = (DefaultMutableTreeNode)o;
            if (defaultMutableTreeNode.getUserObject() != null) {
                this.setDocument(this.getEditorKit().createDefaultDocument());
                if (defaultMutableTreeNode.getUserObject().getClass().getName().equals("java.lang.String")) {
                    this.setText("<font size = \"-1\" face=\"Helvetica, Arial, sans-serif\">" + (String)defaultMutableTreeNode.getUserObject());
                }
                else {
                    this.setText(((WME)defaultMutableTreeNode.getUserObject()).toString_HTML());
                }
            }
            this.setBackground(background);
            return this;
        }
        
        public WMCellRenderer() {
            this.defaultRenderer = new DefaultTreeCellRenderer();
            this.setContentType("text/html");
        }
    }
    
    class WMEActionListener implements ActionListener
    {
        static final int ADD_WME = 0;
        static final int MODIFY_WME = 1;
        private int actionToPerform;
        private WME wmeToModify;
        private EditWMEDialog dialog;
        
        private final void modifyWME() {
            WME wme;
            try {
                wme = (WME)this.wmeToModify.getClass().getConstructor((Class<?>[])null).newInstance((Object[])null);
                wme.assign(this.wmeToModify);
            }
            catch (Exception ex) {
                throw new WmeReflectionError(ex);
            }
            try {
                for (int i = 0; i < this.dialog.wmeFieldTypes.length; ++i) {
                    final String fieldValue = ((WMEFieldEditor)this.dialog.fieldContainer.getComponent(i)).getFieldValue();
                    final String text = ((JLabel)this.dialog.labelContainer.getComponent(i)).getText();
                    try {
                        final Method getSetMethod = this.wmeToModify._getSetMethod(text, this.dialog.wmeFieldTypes[i]);
                        if (this.dialog.wmeFieldTypes[i] == Boolean.TYPE) {
                            if (!fieldValue.equals("true") && !fieldValue.equals("false")) {
                                throw new IllegalWMEFieldValueException(fieldValue, this.dialog.wmeFieldTypes[i]);
                            }
                            getSetMethod.invoke(wme, Boolean.parseBoolean(fieldValue));
                        }
                        try {
                            if (this.dialog.wmeFieldTypes[i] == Byte.TYPE) {
                                getSetMethod.invoke(wme, Byte.parseByte(fieldValue));
                            }
                            if (this.dialog.wmeFieldTypes[i] == Integer.TYPE) {
                                getSetMethod.invoke(wme, Integer.parseInt(fieldValue));
                            }
                            if (this.dialog.wmeFieldTypes[i] == Long.TYPE) {
                                getSetMethod.invoke(wme, Long.parseLong(fieldValue));
                            }
                            if (this.dialog.wmeFieldTypes[i] == Short.TYPE) {
                                getSetMethod.invoke(wme, Short.parseShort(fieldValue));
                            }
                            if (this.dialog.wmeFieldTypes[i] == Float.TYPE) {
                                getSetMethod.invoke(wme, Float.parseFloat(fieldValue));
                            }
                            if (this.dialog.wmeFieldTypes[i] == Double.TYPE) {
                                getSetMethod.invoke(wme, Double.parseDouble(fieldValue));
                            }
                        }
                        catch (NumberFormatException ex6) {
                            throw new IllegalWMEFieldValueException(fieldValue, this.dialog.wmeFieldTypes[i]);
                        }
                        if (this.dialog.wmeFieldTypes[i] == Character.TYPE) {
                            final char[] charArray = fieldValue.toCharArray();
                            if (charArray.length != 1) {
                                throw new IllegalWMEFieldValueException(fieldValue, this.dialog.wmeFieldTypes[i]);
                            }
                            getSetMethod.invoke(wme, charArray[0]);
                        }
                        if (this.dialog.wmeFieldTypes[i].getName().equals("java.lang.String")) {
                            getSetMethod.invoke(wme, fieldValue);
                        }
                    }
                    catch (NoSuchFieldException ex7) {}
                }
                if (this.actionToPerform == 1) {
                    WorkingMemoryDebugger.this.wmBeingDebugged.modifyWME(this.wmeToModify, wme);
                }
                else if (this.actionToPerform == 0) {
                    WorkingMemoryDebugger.this.wmBeingDebugged.addWME(wme);
                }
                this.dialog.dispose();
            }
            catch (InvocationTargetException ex2) {
                throw new WmeReflectionError(ex2);
            }
            catch (IllegalAccessException ex3) {
                throw new WmeReflectionError(ex3);
            }
            catch (WorkingMemoryException ex4) {
                throw new WorkingMemoryError(ex4.getMessage());
            }
            catch (IllegalWMEFieldValueException ex5) {
                JOptionPane.showMessageDialog(this.dialog, "Field value " + ex5.fieldValue + " is not a valid " + ex5.fieldType);
            }
        }
        
        public void actionPerformed(final ActionEvent actionEvent) {
            this.modifyWME();
        }
        
        WMEActionListener(final EditWMEDialog dialog, final WME wmeToModify) {
            this.actionToPerform = 1;
            this.wmeToModify = wmeToModify;
            this.dialog = dialog;
        }
        
        WMEActionListener(final EditWMEDialog dialog, final Class clazz) {
            this.actionToPerform = 0;
            this.dialog = dialog;
            try {
                this.wmeToModify = (WME) clazz.getConstructor((Class<?>[])null).newInstance((Object[])null);
            }
            catch (NoSuchMethodException ex) {
                throw new WmeReflectionError(ex.getMessage());
            }
            catch (InstantiationException ex2) {
                throw new WmeReflectionError(ex2.getMessage());
            }
            catch (IllegalAccessException ex3) {
                throw new WmeReflectionError(ex3.getMessage());
            }
            catch (InvocationTargetException ex4) {
                throw new WmeReflectionError(ex4.getMessage());
            }
        }
        
        class IllegalWMEFieldValueException extends Exception
        {
            public String fieldValue;
            public Class fieldType;
            
            public IllegalWMEFieldValueException(final String fieldValue, final Class fieldType) {
                this.fieldValue = fieldValue;
                this.fieldType = fieldType;
            }
        }
    }
    
    class DefaultFieldEditor extends JTextField implements WMEFieldEditor
    {
        public String getFieldValue() {
            return this.getText();
        }
        
        public void setFieldValue(final String text) {
            this.setText(text);
        }
    }
    
    class EditWMEDialog extends JDialog
    {
        JButton okButton;
        JButton cancelButton;
        JPanel contentPane;
        JPanel labelsAndFields;
        JScrollPane labelsAndFieldsView;
        JPanel labelContainer;
        JPanel fieldContainer;
        JPanel buttonContainer;
        String[] wmeFieldNames;
        Class[] wmeFieldTypes;
        final EditWMEDialog me;
        
        protected void initializeDialog(final WME wme) {
            this.setTitle("Modify WME of class " + wme.getClass().getName());
            this.setContentPane(this.contentPane = new JPanel());
            this.contentPane.setLayout(new BoxLayout(this.contentPane, 1));
            (this.labelsAndFields = new JPanel()).setLayout(new BoxLayout(this.labelsAndFields, 0));
            this.labelsAndFields.setBorder(BorderFactory.createEtchedBorder());
            this.labelsAndFieldsView = new JScrollPane(this.labelsAndFields);
            this.labelsAndFieldsView.getViewport().setScrollMode(2);
            (this.labelContainer = new JPanel()).setLayout(new BoxLayout(this.labelContainer, 1));
            this.labelContainer.setAlignmentY(0.0f);
            (this.fieldContainer = new JPanel()).setLayout(new BoxLayout(this.fieldContainer, 1));
            this.fieldContainer.setAlignmentY(0.0f);
            (this.buttonContainer = new JPanel()).setLayout(new BoxLayout(this.buttonContainer, 0));
            this.buttonContainer.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            this.getContentPane().add(this.labelsAndFieldsView);
            this.labelsAndFields.add(this.labelContainer);
            this.labelsAndFields.add(Box.createHorizontalStrut(20));
            this.labelsAndFields.add(this.fieldContainer);
            this.getContentPane().add(this.buttonContainer);
            this.okButton = new JButton("OK");
            (this.cancelButton = new JButton("Cancel")).addActionListener(new ActionListener() {
                public final void actionPerformed(final ActionEvent actionEvent) {
                    EditWMEDialog.this.me.dispose();
                }
            });
            this.buttonContainer.add(Box.createHorizontalGlue());
            this.buttonContainer.add(this.okButton);
            this.buttonContainer.add(Box.createHorizontalStrut(10));
            this.buttonContainer.add(this.cancelButton);
            this.buttonContainer.setMinimumSize(new Dimension(this.buttonContainer.getMinimumSize().width, 47));
            this.buttonContainer.setMaximumSize(new Dimension(this.buttonContainer.getMaximumSize().width, 47));
            this.buttonContainer.setPreferredSize(new Dimension(this.buttonContainer.getPreferredSize().width, 47));
            int n = 0;
            int width = 0;
            int n2 = 0;
            int width2 = 0;
            this.wmeFieldTypes = wme._getFieldTypes();
            this.wmeFieldNames = wme._getFieldNames();
            for (int i = 0; i < this.wmeFieldNames.length; ++i) {
                final JLabel label = new JLabel(this.wmeFieldNames[i]);
                final Dimension preferredSize = label.getPreferredSize();
                preferredSize.height = 21;
                label.setMinimumSize(preferredSize);
                label.setMaximumSize(preferredSize);
                label.setPreferredSize(preferredSize);
                n += label.getPreferredSize().height;
                if (label.getPreferredSize().width > width) {
                    width = label.getPreferredSize().width;
                }
                label.setAlignmentY(0.0f);
                this.labelContainer.add(label);
                JComponent component;
                try {
                    component = (JComponent)wme.getClass().getMethod("_get" + WME.uppercaseFirstCharacter(this.wmeFieldNames[i]) + "Editor", (Class<?>[])null).invoke(wme, (Object[])null);
                }
                catch (Exception ex) {
                    component = new DefaultFieldEditor();
                }
                final Dimension preferredSize2 = component.getPreferredSize();
                preferredSize2.height = 21;
                component.setPreferredSize(preferredSize2);
                final Dimension maximumSize = component.getMaximumSize();
                maximumSize.height = 21;
                component.setMaximumSize(maximumSize);
                component.setAlignmentY(0.0f);
                n2 += label.getPreferredSize().height;
                if (component.getPreferredSize().width > width2) {
                    width2 = component.getPreferredSize().width;
                }
                this.fieldContainer.add(component);
            }
            this.labelContainer.setPreferredSize(new Dimension(width, n));
            this.labelContainer.setMinimumSize(new Dimension(width, n));
            this.fieldContainer.setPreferredSize(new Dimension(width2, n2));
            this.fieldContainer.setMinimumSize(new Dimension(width2, n2));
            this.labelsAndFieldsView.setMinimumSize(new Dimension(this.labelContainer.getMinimumSize().width + this.fieldContainer.getMinimumSize().width + 20, 63));
            this.pack();
        }
        
        EditWMEDialog(final Class clazz) {
            (this.me = this).setModal(true);
            try {
                this.initializeDialog((WME) clazz.getConstructor((Class<?>[])null).newInstance((Object[])null));
            }
            catch (Exception ex) {
                throw new WmeReflectionError(ex);
            }
        }
        
        EditWMEDialog(final WME wme) {
            (this.me = this).setModal(true);
            this.initializeDialog(wme);
        }
    }
    
    class ModifyWMEDialog extends EditWMEDialog
    {
        ModifyWMEDialog(final WME wme) {
            super(wme.getClass());
            this.okButton.addActionListener(new WMEActionListener(this, wme));
            try {
                for (int i = 0; i < this.wmeFieldTypes.length; ++i) {
                    final Method getGetMethod = wme._getGetMethod(this.wmeFieldNames[i]);
                    if (this.wmeFieldTypes[i] == Boolean.TYPE) {
                        ((WMEFieldEditor)this.fieldContainer.getComponent(i)).setFieldValue(((Boolean)getGetMethod.invoke(wme, (Object[])null)).toString());
                    }
                    else if (this.wmeFieldTypes[i] == Byte.TYPE) {
                        ((WMEFieldEditor)this.fieldContainer.getComponent(i)).setFieldValue(((Byte)getGetMethod.invoke(wme, (Object[])null)).toString());
                    }
                    else if (this.wmeFieldTypes[i] == Integer.TYPE) {
                        ((WMEFieldEditor)this.fieldContainer.getComponent(i)).setFieldValue(((Integer)getGetMethod.invoke(wme, (Object[])null)).toString());
                    }
                    else if (this.wmeFieldTypes[i] == Long.TYPE) {
                        ((WMEFieldEditor)this.fieldContainer.getComponent(i)).setFieldValue(((Long)getGetMethod.invoke(wme, (Object[])null)).toString());
                    }
                    else if (this.wmeFieldTypes[i] == Short.TYPE) {
                        ((WMEFieldEditor)this.fieldContainer.getComponent(i)).setFieldValue(((Short)getGetMethod.invoke(wme, (Object[])null)).toString());
                    }
                    else if (this.wmeFieldTypes[i] == Float.TYPE) {
                        ((WMEFieldEditor)this.fieldContainer.getComponent(i)).setFieldValue(((Float)getGetMethod.invoke(wme, (Object[])null)).toString());
                    }
                    else if (this.wmeFieldTypes[i] == Double.TYPE) {
                        ((WMEFieldEditor)this.fieldContainer.getComponent(i)).setFieldValue(((Double)getGetMethod.invoke(wme, (Object[])null)).toString());
                    }
                    else if (this.wmeFieldTypes[i] == Character.TYPE) {
                        ((WMEFieldEditor)this.fieldContainer.getComponent(i)).setFieldValue(((Character)getGetMethod.invoke(wme, (Object[])null)).toString());
                    }
                    else if (this.wmeFieldTypes[i].getName().equals("java.lang.String")) {
                        ((WMEFieldEditor)this.fieldContainer.getComponent(i)).setFieldValue((String)getGetMethod.invoke(wme, (Object[])null));
                    }
                    else {
                        final Object invoke = getGetMethod.invoke(wme, (Object[])null);
                        if (invoke != null) {
                            ((WMEFieldEditor)this.fieldContainer.getComponent(i)).setFieldValue(invoke.toString());
                        }
                        else {
                            ((WMEFieldEditor)this.fieldContainer.getComponent(i)).setFieldValue("null");
                        }
                        ((JTextField)this.fieldContainer.getComponent(i)).setEditable(false);
                    }
                }
            }
            catch (IllegalAccessException ex) {
                throw new WmeReflectionError(ex);
            }
            catch (InvocationTargetException ex2) {
                throw new WmeReflectionError(ex2);
            }
            catch (NoSuchFieldException ex3) {
                throw new WmeReflectionError(ex3);
            }
        }
    }
    
    class AddWMEDialog extends EditWMEDialog
    {
        AddWMEDialog(final Class clazz) {
            super(clazz);
            this.okButton.addActionListener(new WMEActionListener(this, clazz));
        }
    }
    
    class ChooseWMEDialog extends JDialog
    {
        ChooseWMEDialog me;
        
        ChooseWMEDialog() {
            (this.me = this).setModal(true);
            final JPanel contentPane = new JPanel();
            contentPane.setLayout(new BoxLayout(contentPane, 1));
            this.setContentPane(contentPane);
            final JLabel label = new JLabel("Enter the fully qualified name of a WME");
            label.setAlignmentX(0.0f);
            label.setHorizontalAlignment(2);
            final JComboBox comboBox = new JComboBox(new String[] { "facade.characters.wmedef.DAWME", "facade.characters.wmedef.PlayerGestureWME" });
            comboBox.setEditable(true);
            comboBox.setSelectedItem("");
            ((JTextField)comboBox.getEditor().getEditorComponent()).getKeymap().removeKeyStrokeBinding(KeyStroke.getKeyStroke("ENTER"));
            final JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, 0));
            panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            final JButton defaultButton = new JButton("OK");
            defaultButton.setDefaultCapable(true);
            this.getRootPane().setDefaultButton(defaultButton);
            final JButton button = new JButton("Cancel");
            defaultButton.addActionListener(new ActionListener() {
                public final void actionPerformed(final ActionEvent actionEvent) {
                    try {
                        final Class<?> forName = Class.forName((String)comboBox.getSelectedItem());
                        if (Class.forName("wm.WME").isAssignableFrom(forName)) {
                            ChooseWMEDialog.this.me.dispose();
                            new AddWMEDialog(forName).setVisible(true);
                        }
                        else {
                            JOptionPane.showMessageDialog(ChooseWMEDialog.this.me, "Class " + comboBox.getSelectedItem() + " is not a WME");
                        }
                    }
                    catch (ClassNotFoundException ex) {
                        JOptionPane.showMessageDialog(ChooseWMEDialog.this.me, "Class file for WME " + comboBox.getSelectedItem() + " not found");
                    }
                }
            });
            button.addActionListener(new ActionListener() {
                public final void actionPerformed(final ActionEvent actionEvent) {
                    ChooseWMEDialog.this.me.dispose();
                }
            });
            panel.add(defaultButton);
            panel.add(button);
            contentPane.add(label);
            contentPane.add(comboBox);
            contentPane.add(panel);
            this.pack();
        }
    }
}
