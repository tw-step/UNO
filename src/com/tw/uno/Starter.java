package com.tw.uno;

import org.swixml.SwingEngine;

import javax.swing.*;

public class Starter extends JFrame {
    private static final String DESCRIPTOR = "views/Starter.xml";
    private SwingEngine engine = new SwingEngine(this);

    private Starter() {
        try {
            engine.render(Starter.DESCRIPTOR).setVisible(true);
        } catch (Exception e) {
            throw new RuntimeException("rendering failed" + e);
        }
    }

    public static void main(String[] args) {
        new Starter();
    }
}