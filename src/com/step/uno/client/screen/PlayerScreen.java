package com.step.uno.client.screen;

import com.step.uno.client.model.GameClient;
import com.step.uno.client.view.PlayerView;
import com.step.uno.messages.Snapshot;

import javax.swing.*;

public class PlayerScreen extends JFrame implements PlayerView {


    private GameClient gameClient;
    private Snapshot snapshot;

    private OpenPile openPile;
    private ClosePile closePile;
    private PlayersView playersView;

    public PlayerScreen(GameClient gameClient, Snapshot snapshot) {
        this.gameClient = gameClient;
        this.snapshot = snapshot;

        openPile = new OpenPile(this.snapshot);
        closePile = new ClosePile(this.gameClient,this.snapshot);
        playersView = new PlayersView(this.gameClient,this.snapshot);

        openPile.setBounds(900, 400, 250, 300);
        closePile.setBounds(600, 400, 250, 300);
        playersView.setBounds(40, 0, 1500, 180);

        add(openPile);
        add(closePile);
        add(playersView);

        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    @Override
    public void showDisconnected() {

    }

    @Override
    public void update(Snapshot snapshot) {
        closePile.update(snapshot);
        openPile.update(snapshot);
    }
}
