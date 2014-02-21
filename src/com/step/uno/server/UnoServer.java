package com.step.uno.server;

import com.step.communication.factory.CommunicationFactory;
import com.step.uno.server.controller.GameMasterController;

public class UnoServer{
    public static void main(String[] args) {
        int numberOfPlayers = Integer.parseInt(args[0]);
        int numberOfPacks = Integer.parseInt(args[1]);

        new GameMasterController(numberOfPlayers, numberOfPacks, new CommunicationFactory()).waitForConnections();
    }
}
