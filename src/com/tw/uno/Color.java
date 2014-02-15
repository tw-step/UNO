package com.tw.uno;

import org.swixml.SwingEngine;

import javax.swing.*;

public class Color extends JDialog {

    public Color() throws Exception {
        new SwingEngine( this ).render("xml/ColorDialogBox.xml").setVisible(true);
    }

}

