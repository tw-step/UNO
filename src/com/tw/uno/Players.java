package com.tw.uno;

import org.swixml.SwingEngine;

import javax.swing.*;


public class Players extends JFrame {

    public Players() {
        try {
            new SwingEngine(this).render("players.xml").setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception{
            new Players();
    }
}
