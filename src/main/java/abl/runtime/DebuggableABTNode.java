package abl.runtime;

import javax.swing.tree.MutableTreeNode;

interface DebuggableABTNode
{
    int getNestLevel();
    
    MutableTreeNode getTree();
}
