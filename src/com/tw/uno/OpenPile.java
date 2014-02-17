package com.tw.uno;

import org.swixml.SwingEngine;

import javax.swing.*;


public class OpenPile extends JFrame{

    public OpenPile() {
        try {
            new SwingEngine(this).render("views/OpenPile.xml").setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception{
        new OpenPile();
    }
}
