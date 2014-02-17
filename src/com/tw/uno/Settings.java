package com.tw.uno;

import org.swixml.SwingEngine;

import javax.swing.*;
import java.awt.event.ActionEvent;


public class Settings extends JFrame {

    JTextField noOfPlayers;
    JTextField noOfPacks;
    JButton start;

    public Settings() {
        SwingEngine swingEngine;
        try {
            swingEngine = new SwingEngine(this);
            swingEngine.render("views/Settings.xml").setVisible(true);
            swingEngine.setActionListener(start, OnClick);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Action OnClick = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int numberOfPlayers = Integer.parseInt(noOfPlayers.getText());
            int numberOfPacks = Integer.parseInt(noOfPacks.getText());
            System.out.println(numberOfPacks + "   " + numberOfPlayers);
        }
    };
    public static void main(String[] args) throws Exception {
        new Settings();
    }
}