package com.tw.uno;

import org.swixml.SwingEngine;

import javax.swing.*;
import java.awt.event.ActionEvent;


public class Settings extends JFrame {

    private JTextField noOfPlayers;
    private JTextField noOfPacks;
    private JButton start;
    private int numberOfPlayers;
    private int numberOfPacks;
    SwingEngine swingEngine;

    public Settings() {
        try {
            swingEngine = new SwingEngine(this);
            swingEngine.render("views/Settings.xml").setVisible(true);
            swingEngine.setActionListener(start, onStart);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Action onStart = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            numberOfPlayers = Integer.parseInt(noOfPlayers.getText());
            numberOfPacks = Integer.parseInt(noOfPacks.getText());
            try {
               new ServerWaitingWindow(numberOfPlayers,numberOfPacks);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    };
}