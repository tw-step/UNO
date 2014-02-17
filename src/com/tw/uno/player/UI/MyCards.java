package com.tw.uno.player.UI;

import org.swixml.SwingEngine;

import javax.swing.*;

public class MyCards extends JPanel {
    public MyCards() throws Exception {
        new SwingEngine(this).render("views/MyCards.xml").setVisible(true);
    }

}