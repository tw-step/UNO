package com.tw.uno.player.UI;

import com.tw.uno.desk.Channel;
import com.tw.uno.master.GameServerListener;
import org.swixml.SwingEngine;

import javax.swing.*;
import java.awt.event.ActionEvent;


public class WaitingWindow extends JFrame implements GameServerListener {

    private int numberOfPlayersLeft;
    private SwingEngine engine = new SwingEngine<>(this);
    JLabel noOfPlayers;

    public WaitingWindow(int numberOfPlayersLeft) {
        this.numberOfPlayersLeft = numberOfPlayersLeft;
        try {
            engine.render("views/WaitingWindow.xml").setVisible(true);
            engine.setActionListener(noOfPlayers, decreasePlayerCount); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onNewConnection(Channel channel) {
        numberOfPlayersLeft--;
        System.out.println(numberOfPlayersLeft);
    }

    Action decreasePlayerCount = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            noOfPlayers.setText("Waiting....... Number Of People Left : " + String.valueOf(numberOfPlayersLeft));
        }
    };

    @Override
    public void onError(Exception e) {
        throw new RuntimeException(e);
    }
}
