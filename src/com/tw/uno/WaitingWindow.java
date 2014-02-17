package com.tw.uno;

import com.tw.uno.serverChannel.Channel;
import com.tw.uno.serverChannel.GameServerListener;
import org.swixml.SwingEngine;

import javax.swing.*;


public class WaitingWindow extends JFrame implements GameServerListener {

    private int numberOfPlayersLeft;


    public WaitingWindow(int numberOfPlayersLeft) {
        this.numberOfPlayersLeft = numberOfPlayersLeft;
        try {
            new SwingEngine(this).render("views/WaitingWindow.xml").setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onNewConnection(Channel channel) {
        numberOfPlayersLeft--;
    }

    @Override
    public void onError(Exception e) {
        throw new RuntimeException(e);
    }
}
