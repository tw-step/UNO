package com.tw.uno.player.UI;

import com.tw.uno.desk.ChannelFactory;
import com.tw.uno.player.Player;
import org.swixml.SwingEngine;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Starter extends JFrame {
    private static final String DESCRIPTOR = "views/Starter.xml";
    private SwingEngine engine = new SwingEngine<>(this);

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
            String serverAddress = masterName.getText();
            String playerName = name.getText();
            new ClientWaitingWindow();

            new Player(new ChannelFactory(),playerName).connectTo(serverAddress);

        }
    };

    public static void main(String[] args) {
        new Starter();
    }
}