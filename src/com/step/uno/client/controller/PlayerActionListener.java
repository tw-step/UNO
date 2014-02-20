package com.step.uno.client.controller;

import com.step.communication.factory.CommunicationFactory;
import com.step.uno.client.model.GameClient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerActionListener implements ActionListener {
    private int playerIndex;
    private GameClient gameClient = new GameClient(new CommunicationFactory());

    public PlayerActionListener(int playerIndex) {
        this.playerIndex = playerIndex;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        gameClient.catchUno(playerIndex);
    }
}
