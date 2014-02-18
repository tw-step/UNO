package com.tw.uno.player.UI;

import org.swixml.SwingEngine;

import javax.swing.*;

public class OpenPile extends JPanel {
    public OpenPile() throws Exception {
        new SwingEngine<>(this).render("views/OpenPile.xml").setVisible(true);
    }
}
