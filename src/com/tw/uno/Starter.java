package com.tw.uno;

import org.swixml.SwingEngine;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Starter extends JFrame {
    private static final String DESCRIPTOR = "views/Starter.xml";
    private SwingEngine engine = new SwingEngine(this);
    
    JTextField masterName;
    JTextField name;
    JButton join;

    private Starter() {
        try {
            engine.render(Starter.DESCRIPTOR).setVisible(true);
            engine.setActionListener(join, OnClick);
        } catch (Exception e) {
            throw new RuntimeException("rendering failed" + e);
        }
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    Action OnClick = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String serverIp = (masterName.getText());
            String clientName = (name.getText());
            System.out.println(clientName + "   " + serverIp);
//            new WaitingWindow();
            new ClientWaitingWindow();
        }
    };

    public static void main(String[] args) {
        new Starter();
    }
}