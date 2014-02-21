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
    public PlayerScreen(GameClient gameClient, Snapshot snapshot) {
        this.gameClient = gameClient;
        this.snapshot = snapshot;

        openPile = new OpenPile(this.snapshot);
        closePile = new ClosePile(this.gameClient,this.snapshot);
        playersView = new PlayersView(this.gameClient,this.snapshot);
        myCards = new MyCards(this.gameClient,this.snapshot);

        openPile.setBounds(900, 400, 250, 300);
        closePile.setBounds(600, 400, 250, 300);
<<<<<<< HEAD
        playersView.setBounds(40, 0, 1200, 300);
        myCards.setBounds(200, 0, 900, 200);

=======
        playersView.setBounds(40, 0, 1500, 180);
>>>>>>> fb959651a4639c6cd7fe9e590642a117dfa19bcd
        setLayout(new BorderLayout());
        myCards.setBounds(300, 0, 900, 200);

        add(openPile);
        add(closePile);
        add(playersView);
        add(myCards,BorderLayout.SOUTH);

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
    }
}
