package com.step.uno.client.screen;

import com.step.uno.client.model.GameClient;
import com.step.uno.messages.Snapshot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClosePile extends JPanel {

    private JButton draw;
    private GameClient gameClient;
    private Snapshot snapshot;

    public ClosePile(GameClient gameClient, Snapshot snapshot) {
        this.gameClient = gameClient;

        this.snapshot = snapshot;

        draw = new JButton("Draw Cards");
        draw.setPreferredSize(new Dimension(100, 150));
        draw.addActionListener(new OnClick());
        draw.setFont(new Font("vardana", Font.BOLD, 18));
        add(draw);
        setVisible(true);
    }

    public void update(Snapshot snapshot) {
        this.snapshot = snapshot;
    }

    private class OnClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            gameClient.draw();
        }
    }

}
