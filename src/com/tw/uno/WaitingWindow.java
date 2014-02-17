package com.tw.uno;

import org.swixml.SwingEngine;

import javax.swing.*;


public class WaitingWindow extends JFrame{

    public WaitingWindow() {
        try {
            new SwingEngine(this).render("views/WaitingWindow.xml").setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception{
        new WaitingWindow();
    }
}
