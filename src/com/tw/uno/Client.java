package com.tw.uno;

import javax.swing.*;
import java.awt.Color;

public class Client extends JFrame {

    private Players players;
    private ActivityLog activityLog;
    private MyCards myCards;
    private JPanel bgPanel = new JPanel();

    public Client() {
        try {
            activityLog = new ActivityLog();
            myCards = new MyCards();
            players = new Players();
        } catch (Exception e) {
            e.printStackTrace();
        }

        activityLog.setBounds(1550, 5, 360, 1110);
        players.setBounds(40, 0, 1500, 180);

        myCards.setBounds(400, 925, 850, 190);

        bgPanel.setBackground(new Color(3, 128, 4));

        add(activityLog);
        add(players);
        add(myCards);
        add(bgPanel);

        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public static void main(String[] args) {
        new Client();
    }

}
