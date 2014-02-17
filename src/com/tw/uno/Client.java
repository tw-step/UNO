package com.tw.uno;

import javax.swing.*;

public class Client extends JFrame {

    private Players players;
    private ActivityLog activityLog;
    private MyCards myCards;

    public Client() {
        try {
            activityLog = new ActivityLog();
            myCards = new MyCards();
            players = new Players();
        } catch (Exception e) {
            e.printStackTrace();
        }

        activityLog.setBounds(1550, 5, 360, 1110);
        players.setBounds(40, 0, 1300, 180);

        myCards.setBounds(400, 925, 850, 190);

        add(activityLog);
        add(myCards);
        add(players);

        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public static void main(String[] args) {
        new Client();
    }

}
