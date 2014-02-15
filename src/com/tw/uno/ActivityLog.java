package com.tw.uno;

import org.swixml.SwingEngine;

import javax.swing.*;

public class ActivityLog extends JFrame{
    private static final String DESCRIPTOR = "views/ActivityLog.xml";
    private SwingEngine swix = new SwingEngine( this );

    public ActivityLog() throws Exception {
        swix.render( ActivityLog.DESCRIPTOR ).setVisible(true);
    }
    public static void main( String[] args ) {
        try {
            new ActivityLog();
        } catch (Exception e) {
            System.err.println( e.getMessage() );
        }
    }
}
