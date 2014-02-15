package com.tw.uno;

import org.swixml.SwingEngine;


public class Players {

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
