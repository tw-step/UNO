package com.tw.uno;

import org.swixml.SwingEngine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class Cards {

    private static final String DESCRIPTOR = "xml/MyCards.xml";
    private SwingEngine swix = new SwingEngine( this );

    /** panel with a CardLayout */
    public JPanel pnl;

    private Cards() throws Exception {
        swix.render( Cards.DESCRIPTOR ).setVisible( true );
        this.showAction.actionPerformed( null );
    }

    /** shows the next card */
    public Action nextAction = new AbstractAction() {
        public void actionPerformed( ActionEvent e ) {
            CardLayout cl = (CardLayout) ( pnl.getLayout() );
            cl.next( pnl );
        }
    };

    /** shows the card with the id requested in the actioncommand */
    public Action showAction = new AbstractAction() {
        public void actionPerformed( ActionEvent e ) {
            //System.err.println( "ActionCommand=" + e.getActionCommand() );
            CardLayout cl = (CardLayout) ( pnl.getLayout() );
            if (e!=null) {
                cl.show( pnl, e.getActionCommand() );
            }
        }
    };

    public static void main( String[] args ) {
        try {
            new Cards();
        } catch (Exception e) {
            System.err.println( e.getMessage() );
        }
    }

}