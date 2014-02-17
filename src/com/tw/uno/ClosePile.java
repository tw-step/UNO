package com.tw.uno;

import org.swixml.SwingEngine;

import javax.swing.*;


public class ClosePile extends JFrame{

    public ClosePile() {
        try {
            new SwingEngine(this).render("views/ClosePile.xml").setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception{
        new ClosePile();
    }
}
