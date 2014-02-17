package com.tw.uno.player.UI;

import javax.swing.*;
import java.awt.Color;

public class Client extends JFrame {

    private Players players;
    private ActivityLog activityLog;
    private MyCards myCards;
    private StatusHint statusHint;
    private OpenPile openPile;
    private ClosePile closePile;
    private JPanel bgPanel = new JPanel();

    public Client() {
        try {
            activityLog = new ActivityLog();
            myCards = new MyCards();
            players = new Players();
            statusHint = new StatusHint(750, 750, 300, 100);
            openPile = new OpenPile();
            closePile = new ClosePile();
        } catch (Exception e) {
            e.printStackTrace();
        }

        activityLog.setBounds(1550, 5, 360, 1110);
        players.setBounds(40, 0, 1500, 180);

        myCards.setBounds(400, 925, 850, 190);
        openPile.setBounds(900,400,250,300);
        closePile.setBounds(600,400,250,300);
        bgPanel.setBackground(new Color(3, 128, 4));

        add(activityLog);
        add(players);
        add(myCards);
        add(statusHint);
        add(openPile);
        add(closePile);
        add(bgPanel);

        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public static void main(String[] args) {
        new Client();
    }
}
