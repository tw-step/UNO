package com.tw.uno;

import org.swixml.SwingEngine;

import javax.swing.*;

public class FinishPage extends JFrame {
    public FinishPage() {
        try {
            new SwingEngine(this).render("views/FinishPage.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
        setVisible(true);
    }

    public static void main(String[] args) {
        new FinishPage();
    }
}
