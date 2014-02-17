package com.tw.uno;

import javax.swing.*;

public class Client extends JFrame {

//    private StatusHint statusHint;
    private Players players;
    private ActivityLog activityLog;
    private MyCards myCards;
//    private Draw draw;

    public Client() {
        try {
            activityLog = new ActivityLog();
            myCards = new MyCards();
//            statusHint = new StatusHint(700, 700, 200, 100);
            players = new Players();
//            draw = new Draw();
        } catch (Exception e) {
            e.printStackTrace();
        }

        activityLog.setBounds(1350, 0, 310, 1010);
        players.setBounds(40, 0, 1300, 180);
//        draw.setBounds(0,0,100,100);

        myCards.setBounds(350, 800, 850, 300);

        add(activityLog);
        add(myCards);
        add(players);
//        add(statusHint);
//        add(draw);

        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public static void main(String[] args) {
        new Client();
    }
}
