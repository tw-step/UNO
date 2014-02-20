package com.step.uno.client.screen;

import com.step.uno.client.model.GameClient;
import com.step.uno.client.view.PlayerView;
import com.step.uno.messages.Snapshot;
import com.step.uno.model.Card;
import com.step.uno.model.Colour;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class MyCards extends JPanel implements PlayerView {
    private List<Card> cards = new ArrayList<>();
    private JPanel panel = new JPanel();
    private JScrollPane scrollPane = new JScrollPane();
    private GameClient gameClient;
    private Snapshot snapshot = null;

    public MyCards(GameClient gameClient, Snapshot snapshot) {
        this.gameClient = gameClient;
        this.snapshot = snapshot;
        Collections.addAll(this.cards, snapshot.myCards);
        setCards();
    }

    public void setCards() {
        createCards();
        scrollPane.getViewport().add(panel);
        scrollPane.setPreferredSize(new Dimension(600, 120));
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        add(scrollPane);

        JButton uno = new JButton("UNO");
        uno.setPreferredSize(new Dimension(100, 100));
        uno.setFont(new Font("Verdana", Font.BOLD,16));
        add(uno);
        uno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameClient.declareUno();
            }
        });
    }

    private void createCards() {
        Map<Colour, Color> colors = new HashMap<>();
        colors.put(Colour.Black, Color.black);
        colors.put(Colour.Blue, Color.blue);
        colors.put(Colour.Green, Color.green);
        colors.put(Colour.Red, Color.red);
        colors.put(Colour.Yellow, Color.yellow);
        for (final Card card : cards) {
            JButton jButton = new JButton();
            jButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (card.colour == Colour.Black)
                        gameClient.play(card, card.colour);
                    else
                        gameClient.play(card);
                }
            });
            jButton.setForeground(Color.BLACK);
            jButton.setText(card.sign.name());
            jButton.setBackground(colors.get(card.colour));
            jButton.setPreferredSize(new Dimension(100, 100));
            jButton.setVisible(true);
            panel.add(jButton);
        }
    }

    @Override
    public void showDisconnected() {

    }

    @Override
    public void update(Snapshot snapshot) {
        for (int i = 0; i < snapshot.myCards.length; i++) {
            Card card = snapshot.myCards[i];
            cards.set(i, card);
        }
    }
}