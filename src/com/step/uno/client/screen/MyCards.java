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
    Map<Colour, Color> colors = new HashMap<>();
    private List<Card> cards = new ArrayList<>();
    private JPanel panel = new JPanel();
    JPanel innerPanel = new JPanel();
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
        scrollPane.setPreferredSize(new Dimension(775, 180));
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        JButton uno = new JButton("UNO");
        uno.setPreferredSize(new Dimension(100, 100));
        uno.setFont(new Font("Vardana", Font.BOLD, 16));

        innerPanel.add(scrollPane);
        innerPanel.add(uno);

        add(innerPanel);
        uno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameClient.declareUno();
            }
        });
        setVisible(true);
    }

    private void createCards() {
        initColors();
        for (final Card card : cards) {
            JButton jButton = new JButton();
            jButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (card.colour == Colour.Black) {
                        gameClient.play(card, card.colour);
                    } else {
                        gameClient.play(card);
                    }
                    cards.remove(card);
                    update(snapshot);
                }
            });
            jButton.setForeground(Color.BLACK);
            jButton.setText(card.sign.name());
            jButton.setFont(new Font("Vardana",Font.BOLD,24));
            jButton.setBackground(colors.get(card.colour));
            jButton.setPreferredSize(new Dimension(100, 150));
            jButton.setVisible(true);
            panel.add(jButton);
        }
    }

    private void initColors() {
        colors.put(Colour.Black, Color.black);
        colors.put(Colour.Blue, Color.blue);
        colors.put(Colour.Green, Color.green);
        colors.put(Colour.Red, Color.red);
        colors.put(Colour.Yellow, Color.yellow);
    }

    @Override
    public void showDisconnected() {

    }

    @Override
    public void update(Snapshot snapshot) {

        for (int i = cards.size(); i < snapshot.myCards.length; i++) {
            Card card = snapshot.myCards[i];
            cards.add(card);
        }
        panel.removeAll();
        createCards();
    }
}