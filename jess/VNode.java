package jess;

import java.awt.Color;

class VNode
{
    int m_x;
    int m_y;
    Node m_node;
    Color m_c;
    
    VNode(final int x, final int y, final Color c, final Node node) {
        this.m_x = x;
        this.m_y = y;
        this.m_node = node;
        this.m_c = c;
    }
}
