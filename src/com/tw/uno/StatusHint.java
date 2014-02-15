package com.tw.uno;

import org.swixml.SwingEngine;

import javax.swing.*;

public class StatusHint extends JInternalFrame{
    public StatusHint(int x, int y, int width, int height) throws Exception {
        new SwingEngine( this ).render("Views/StatusHintView.xml").setVisible(true);
        this.setBounds(x,y,width,height);
    }
}
