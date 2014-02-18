package com.tw.uno.player.UI;

import org.swixml.SwingEngine;

import javax.swing.*;

public class FinishPage extends JFrame{

    public FinishPage() {
        try {
            new SwingEngine<>(this).render("views/FinishPage.xml").setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception{
        new FinishPage();
    }
}
