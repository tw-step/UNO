package com.step.uno.client;

import com.step.communication.factory.CommunicationFactory;
import com.step.uno.client.controller.GameClientController;
import com.step.uno.client.view.PlayerView;
import com.step.uno.messages.GameSnapshot;

public class UnoClient {
    public static void main(String[] args) {
        PlayerView view = new PlayerView() {
            @Override
            public void showDisconnected() {
                System.out.println("disconnected");
            }

            @Override
            public void update(GameSnapshot snapshot) {
                System.out.println("Got a snapshot");
            }
        };
        GameClientController controller = new GameClientController(new CommunicationFactory(), view);
        controller.join("127.0.0.1");
    }
}
