package com.tw.uno;

import org.swixml.SwingEngine;

import javax.swing.*;

public class Draw extends JPanel {
    private static final String DESCRIPTOR = "xml/Draw.xml";
    private SwingEngine engine = new SwingEngine(this);

    private Draw() {
        try {
            engine.render(Draw.DESCRIPTOR).setVisible(true);
        } catch (Exception e) {
            throw new RuntimeException("rendering failed" + e);
        }
    }

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.add(new Draw()).setVisible(true);
        jFrame.setVisible(true);
        jFrame.setBounds(0,0,500,500);
    }
}