package com.step.uno.client.screen;

import com.step.uno.client.model.GameClient;
import com.step.uno.messages.Snapshot;
import com.step.uno.model.Card;
import com.step.uno.model.Colour;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class MyCards extends JPanel {
    Map<Colour, Color> colors = new HashMap<>();
    private JPanel panel = new JPanel();
    JPanel innerPanel = new JPanel();
    private JScrollPane scrollPane = new JScrollPane();
    private GameClient gameClient;
    private Snapshot snapshot = null;

    public MyCards(GameClient gameClient, Snapshot snapshot) {
        this.gameClient = gameClient;
        this.snapshot = snapshot;
        setCards();
    }

    public void setCards() {
        createCards();
        scrollPane.getViewport().add(panel);
        scrollPane.setPreferredSize(new Dimension(750, 180));
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        JButton uno = new JButton("UNO");
        uno.setPreferredSize(new Dimension(100, 100));
        uno.setFont(new Font("Vardana", Font.BOLD, 16));

        innerPanel.add(uno);
        innerPanel.add(scrollPane);

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
        for (final Card card : snapshot.myCards) {
            panel.add(createCardButton(card));
        }
    }

    private JButton createCardButton(Card card) {
        JButton jButton = new JButton();
        jButton.addActionListener(new PlayCardActionListener(card, gameClient, panel, snapshot));
        jButton.setForeground(Color.BLACK);
        String sign = card.sign.name();
        String part = card.sign.name();
        if (sign.startsWith("_"))
            part = sign.split("_")[1];
        jButton.setText(part);
        jButton.setEnabled(snapshot.currentPlayerIndex == snapshot.myPlayerIndex);
        jButton.setFont(new Font("Vardana", Font.BOLD, 24));
        jButton.setBackground(colors.get(card.colour));
        if (card.colour == Colour.Black)
            jButton.setForeground(new Color(255, 255, 255));
        jButton.setPreferredSize(new Dimension(100, 150));
        jButton.setVisible(true);
        return jButton;
    }

    private void initColors() {
        colors.put(Colour.Black, new Color(10, 18, 42));
        colors.put(Colour.Red, new Color(254, 46, 46));
        colors.put(Colour.Green, new Color(1, 223, 58));
        colors.put(Colour.Blue, new Color(46, 204, 250));
        colors.put(Colour.Yellow, new Color(247, 254, 46));
    }

    public void update(Snapshot snapshot) {
        this.snapshot = snapshot;
        panel.removeAll();
        createCards();
        panel.revalidate();
    }
}
