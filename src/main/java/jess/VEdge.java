package jess;

import java.awt.Color;

class VEdge
{
    int m_from;
    int m_to;
    Color m_c;
    
    VEdge(final int from, final int to, final Color c) {
        this.m_from = from;
        this.m_to = to;
        this.m_c = c;
    }
}
