package com.tw.uno.player.UI;

import org.swixml.SwingEngine;

import javax.swing.*;


public class Players extends JPanel {

    public Players() {
        try {
            new SwingEngine(this).render("views/players.xml").setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
