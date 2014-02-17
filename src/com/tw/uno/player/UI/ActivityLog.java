package com.tw.uno.player.UI;

import org.swixml.SwingEngine;

import javax.swing.*;

public class ActivityLog extends JPanel {

    public ActivityLog() throws Exception {
        new SwingEngine(this).render("views/ActivityLog.xml").setVisible(true);
    }

}
