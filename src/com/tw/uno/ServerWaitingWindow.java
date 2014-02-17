package com.tw.uno;

import org.swixml.SwingEngine;

import javax.swing.*;

public class ServerWaitingWindow extends JFrame {
    public ServerWaitingWindow(int numberOfPlayers, int numberOfPacks) {
        try {
            new SwingEngine(this).render("views/WaitingWindow.xml").setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

