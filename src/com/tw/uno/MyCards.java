package com.tw.uno;

import org.swixml.SwingEngine;

import javax.swing.*;


public class MyCards extends JFrame {

    private static final String DESCRIPTOR = "xml/MyCards.xml";
    private SwingEngine swix = new SwingEngine( this );

    /** panel with a CardLayout */
    public JPanel pnl;

    private MyCards() throws Exception {
        swix.render( MyCards.DESCRIPTOR ).setVisible(true);
    }

    public static void main( String[] args ) {
        try {
            new MyCards();
        } catch (Exception e) {
            System.err.println( e.getMessage() );
        }
    }


}