package com.tw.uno;

import org.swixml.SwingEngine;

import javax.swing.*;

public class Draw extends JPanel {

    public Draw() {
        try {
            new SwingEngine(this).render("views/Draw.xml").setVisible(true);
        } catch (Exception e) {
            throw new RuntimeException("rendering failed" + e);
        }
    }
}