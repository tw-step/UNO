package com.step.uno.client.screen;

import com.step.uno.client.controller.GameClientController;
import com.step.uno.client.controller.PlayerActionListener;
import com.step.uno.client.view.PlayerView;
import com.step.uno.messages.Snapshot;
import com.step.uno.model.PlayerSummary;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PlayersView extends JPanel implements PlayerView {

    //UI components
    private JScrollPane scrollPane = new JScrollPane();
    private JPanel playerNames = new JPanel();
    private JLabel direction = new JLabel();

    private ArrayList<JButton> players = new ArrayList<>();

    public PlayersView(Snapshot snapshot) {

        createPlayerButtons(snapshot.playerSummaries);

        setDirection(snapshot.isInAscendingOrder);

        playerNames.setVisible(true);
        scrollPane.getViewport().add(playerNames);

        scrollPane.setPreferredSize(new Dimension(1400, 120));

        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane);
        add(direction);
        setSize(200, 200);
        setVisible(true);

    }

    private void setDirection(boolean isInAscendingOrder) {
        if (isInAscendingOrder)
            direction.setText("==>>");
        else
            direction.setText("<<==");
    }

    private void createPlayerButtons(PlayerSummary[] summaries) {

        for (PlayerSummary summary : summaries) {
            players.add(new JButton(summary.name + " : " + summary.cardsInHand));
            JButton playerButton = players.get(players.size() - 1);
            playerButton.addActionListener(new PlayerActionListener(players.indexOf(playerButton)));
            playerNames.add(playerButton);
        }
    }

    @Override
    public void showDisconnected() {
        //do nothing
    }

    @Override
    public void update(Snapshot snapshot) {
        PlayerSummary[] summaries = snapshot.playerSummaries;
        for (int i = 0; i < players.size(); i++) {
            players.get(i).setText(summaries[i].name + " : " + summaries[i].cardsInHand);
        }

    }
}

