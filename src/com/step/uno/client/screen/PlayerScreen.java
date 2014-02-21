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
    private ActivityLog activityLog;
    private MyCards myCards;
    private final JPanel currentPlayer;
    private final JLabel player;

    public PlayerScreen(GameClient gameClient, Snapshot snapshot) {
        this.gameClient = gameClient;
        this.snapshot = snapshot;

        closePile = new ClosePile(this.gameClient,this.snapshot);
        playersView = new PlayersView(this.gameClient,this.snapshot);
        myCards = new MyCards(this.gameClient,this.snapshot);
        openPile = new OpenPile(this.snapshot);
        activityLog =new ActivityLog();
        currentPlayer = new JPanel();
        player = new JLabel(snapshot.playerSummaries[snapshot.currentPlayerIndex].name+"\'s turn");
        player.setFont(new Font("vardana",Font.BOLD,25));

        openPile.setBounds(900, 400, 250, 300);
        closePile.setBounds(600, 400, 250, 300);
        playersView.setBounds(40, 0, 1200, 300);
        myCards.setBounds(300, 0, 900, 200);
        currentPlayer.setBounds(600,200,300,200);
        setLayout(new BorderLayout());
        currentPlayer.add(player);
        currentPlayer.setPreferredSize(new Dimension(200, 200));
        currentPlayer.setVisible(true);
        add(currentPlayer);
        add(openPile);
        add(closePile);
        add(playersView);
        add(activityLog,BorderLayout.EAST);
        add(myCards, BorderLayout.SOUTH);
        setVisible(true);
        setResizable(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    @Override
    public void showDisconnected() {

    }

    @Override
    public void update(Snapshot snapshot) {
        this.snapshot = snapshot;
        closePile.update(snapshot);
        openPile.update(snapshot);
        playersView.update(snapshot);
        activityLog.update(snapshot);
        myCards.update(snapshot);
        player.setText(snapshot.playerSummaries[snapshot.currentPlayerIndex].name+"\'s turn");

    }
}
