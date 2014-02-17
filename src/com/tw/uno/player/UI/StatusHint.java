package com.tw.uno.player.UI;

import org.swixml.SwingEngine;

import javax.swing.*;

public class StatusHint extends JPanel{
    public StatusHint(int x, int y, int width, int height) throws Exception {
        new SwingEngine( this ).render("views/StatusHintView.xml").setVisible(true);
        this.setBounds(x,y,width,height);
    }
}