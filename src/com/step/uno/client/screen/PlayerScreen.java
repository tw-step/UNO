package com.step.uno.client.screen;

import com.step.uno.client.model.GameClient;
import com.step.uno.client.view.PlayerView;
import com.step.uno.messages.Snapshot;

import javax.swing.*;
import java.awt.*;

public class PlayerScreen extends JFrame implements PlayerView {

    private GameClient gameClient;
    private Snapshot snapshot;

    private OpenPile openPile;
    private ClosePile closePile;
    private PlayersView playersView;
    private MyCards myCards;
    private JPanel currentPlayer;
    private JLabel player;
    private ActivityLog activityLog;

    public PlayerScreen(GameClient gameClient, Snapshot snapshot) {
        this.gameClient = gameClient;
        this.snapshot = snapshot;
        this.setTitle((this.snapshot.playerSummaries[this.snapshot.myPlayerIndex].name));
        openPile = new OpenPile(this.snapshot);
        closePile = new ClosePile(this.gameClient,this.snapshot);
        playersView = new PlayersView(this.gameClient,this.snapshot);
        myCards = new MyCards(this.gameClient,this.snapshot);
        activityLog =new ActivityLog();
        currentPlayer = new JPanel();
        player = new JLabel(snapshot.playerSummaries[snapshot.currentPlayerIndex].name+"\'s turn");
        player.setFont(new Font("vardana",Font.BOLD,25));

        openPile.setBounds(500, 300, 250, 300);
        closePile.setBounds(300, 300, 250, 300);
        playersView.setBounds(100, 0, 800, 1800);
        myCards.setBounds(0, 0, 900, 200);

        setLayout(new BorderLayout());
        currentPlayer.setBounds(450,200,200,50);
        currentPlayer.add(player);
        currentPlayer.setPreferredSize(new Dimension(200, 200));
        currentPlayer.setVisible(true);

        add(currentPlayer);
        add(openPile);
        add(closePile,BorderLayout.CENTER);
        add(playersView);
        add(myCards,BorderLayout.SOUTH);
        add(activityLog,BorderLayout.EAST);
        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    @Override
    public void showDisconnected() {
        setVisible(false);
    }

    @Override
    public void update(Snapshot snapshot) {
        this.snapshot = snapshot;
        closePile.update(snapshot);
        openPile.update(snapshot);
        playersView.update(snapshot);
        myCards.update(snapshot);
        player.setText(snapshot.playerSummaries[snapshot.currentPlayerIndex].name+"\'s turn");

    }
}
