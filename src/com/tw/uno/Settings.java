package com.tw.uno;

import org.swixml.SwingEngine;

import javax.swing.*;


public class Settings extends JFrame {

    public Settings() {
        try {
            new SwingEngine(this).render("views/Settings.xml").setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception{
        new Settings();
    }
}
