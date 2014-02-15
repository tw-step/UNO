package com.tw.uno;

import org.swixml.SwingEngine;
import javax.swing.*;

public class Draw extends JPanel {
    private SwingEngine swix = new SwingEngine(this);

    private Draw() {
        try {
            swix.render("Views/Draw.xml").setVisible(true);
        } catch (Exception e) {
            throw new RuntimeException("rendering failed" + e);
        }
    }
}
