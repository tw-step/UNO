package com.tw.uno;

import org.swixml.SwingEngine;

import javax.swing.*;

public class Color extends JDialog {

    public Color() throws Exception {
        new SwingEngine( this ).render("views/ColorDialogBox.xml").setVisible(true);
    }

    public static void main(String[] args) {
        try {
            new Color();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

