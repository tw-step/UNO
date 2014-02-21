package com.step.uno.client.screen;

import com.step.uno.client.model.GameClient;
import com.step.uno.client.view.PlayerView;
import com.step.uno.messages.Snapshot;
import com.step.uno.model.PlayerSummary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PlayersView extends JPanel implements PlayerView {

    //UI components
    private JScrollPane scrollPane = new JScrollPane();
    private JPanel playerNames = new JPanel();
    ImageIcon forward = new ImageIcon("src/com/step/uno/client/images/forward11.jpg");
    ImageIcon backward = new ImageIcon("src/com/step/uno/client/images/backward.jpg");
    private JLabel Fdirection = new JLabel(forward);
    private JLabel Bdirection = new JLabel(backward);

    private ArrayList<JButton> players = new ArrayList<>();
    private GameClient gameClient;

    public PlayersView(GameClient gameClient,Snapshot snapshot) {
        this.gameClient = gameClient;

        createPlayerButtons(snapshot.playerSummaries);

        playerNames.setVisible(true);
        scrollPane.getViewport().add(playerNames);

        scrollPane.setPreferredSize(new Dimension(1400, 120));

        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        Fdirection.setVisible(false);
        Bdirection.setVisible(false);
        setDirection(snapshot.isInAscendingOrder);

        add(Fdirection).setPreferredSize(new Dimension(150, 105));
        add(Bdirection).setPreferredSize(new Dimension(150, 105));

        add(scrollPane);
        setSize(200, 200);
        setVisible(true);

    }

    private void setDirection(boolean isInAscendingOrder) {
        if (isInAscendingOrder)
            Fdirection.setVisible(true);
        else
            Bdirection.setVisible(true);
    }

    private void createPlayerButtons(PlayerSummary[] summaries) {

        for (PlayerSummary summary : summaries) {
            players.add(new JButton(summary.name + " : " + summary.cardsInHand));
            JButton playerButton = players.get(players.size() - 1);
            playerButton.setPreferredSize(new Dimension(150,100));
            playerButton.setFont(new Font("vardana", Font.BOLD, 18));
            final int playerIndex1 = players.indexOf(playerButton);
            playerButton.addActionListener(new ActionListener() {
                private int playerIndex = playerIndex1;

                @Override
                public void actionPerformed(ActionEvent e) {
                    gameClient.catchUno(playerIndex);
                }
            });
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
        setDirection(snapshot.isInAscendingOrder);
        highlightCurrentPlayer(snapshot.currentPlayerIndex);
    }

    private void highlightCurrentPlayer(int currentPlayerIndex) {
        players.get(currentPlayerIndex).setBackground(new Color(255,0,0));
    }
}

