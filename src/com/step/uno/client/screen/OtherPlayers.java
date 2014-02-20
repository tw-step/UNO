package com.step.uno.client.screen;

import com.step.communication.factory.CommunicationFactory;
import com.step.uno.client.controller.GameClientController;
import com.step.uno.messages.Snapshot;
import com.step.uno.model.PlayerSummary;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class OtherPlayers extends JPanel{

    private JPanel playerNames = new JPanel();
    //UI components
    JScrollPane scrollPane = new JScrollPane();

    private GameClientController controller;
    private boolean arePlayerPresent;
    private final Panel panel;

    public OtherPlayers(GameClientController controller,Snapshot snapshot) {
        this.controller = controller;
        panel = new Panel();

        scrollPane.setPreferredSize(new Dimension(1400, 120));

        PlayerSummary[] summaries = snapshot.playerSummaries;
        for (PlayerSummary summary : summaries) {
            playerNames.add(new JButton(summary.name + " : " + summary.cardsInHand));
        }
        scrollPane.add(playerNames);
        panel.add(scrollPane);

        arePlayerPresent = true;

        setSize(200, 200);
        panel.setVisible(true);
    }
    public static void main(String[] args) {
        Snapshot snapshot = new Snapshot();
        snapshot.playerSummaries = Arrays.asList(new PlayerSummary("suraj", 3, false), new PlayerSummary("shweta", 3, false)).toArray(new PlayerSummary[2]);

        OtherPlayers players = new OtherPlayers(new GameClientController(new CommunicationFactory()),snapshot);

        JFrame frame = new JFrame();
        frame.add(players);

        frame.setVisible(true);

    }

}
