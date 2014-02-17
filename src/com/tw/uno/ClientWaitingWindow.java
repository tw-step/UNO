package com.tw.uno;

import org.swixml.SwingEngine;

import javax.swing.*;


public class ClientWaitingWindow extends JFrame{

    public ClientWaitingWindow() {
        try {
            new SwingEngine(this).render("views/WaitingWindow.xml").setVisible(true);
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Client();
    }

}
