package com.tw.uno.player.UI;

import org.swixml.SwingEngine;

import javax.swing.*;


public class ClosePile extends JPanel {

    public ClosePile() throws Exception {
        new SwingEngine<>(this).render("views/ClosePile.xml").setVisible(true);
    }

}
