package com.tw.uno;

import org.swixml.SwingEngine;

import javax.swing.*;


public class Cards {

    private static final String DESCRIPTOR = "xml/MyCards.xml";
    private SwingEngine swix = new SwingEngine( this );

    /** panel with a CardLayout */
    public JPanel pnl;

    private Cards() throws Exception {
        swix.render( Cards.DESCRIPTOR ).setVisible(true);
    }

    public static void main( String[] args ) {
        try {
            new Cards();
        } catch (Exception e) {
            System.err.println( e.getMessage() );
        }
    }


}