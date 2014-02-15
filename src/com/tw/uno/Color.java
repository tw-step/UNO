package com.tw.uno;

import org.swixml.SwingEngine;

import javax.swing.*;

public class Color extends JFrame {
    private static final String DESCRIPTOR = "xml/ColorDialogBox.xml";
    private SwingEngine swix;

    /** panel with a CardLayout */
    public JPanel pnl;
    public JPanel c1;

    private Color() throws Exception {
        swix = new SwingEngine( this );
        swix.render( Color.DESCRIPTOR ).setVisible(true);
    }

    public static void main( String[] args ) {
        try {
            new Color();
        } catch (Exception e) {
            System.err.println( e.getMessage() );
        }
    }
}
