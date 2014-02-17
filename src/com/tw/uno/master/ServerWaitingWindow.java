package com.tw.uno.master;

import com.tw.uno.player.UI.WaitingWindow;
import com.tw.uno.desk.ChannelFactory;
import org.swixml.SwingEngine;

import javax.swing.*;

public class ServerWaitingWindow extends JFrame {
    public ServerWaitingWindow(int numberOfPlayers, int numberOfPacks) {
        try {

            new SwingEngine(this).render("views/WaitingWindow.xml").setVisible(true);
            GameServer uno = new GameServer(new ChannelFactory());
            uno.startGame(new WaitingWindow(numberOfPlayers));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

