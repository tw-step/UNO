package com.step.uno.client.screen;

import com.step.uno.model.Card;
import com.step.uno.model.Colour;
import com.step.uno.model.Player;
import com.step.uno.model.Sign;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cards extends JPanel {
    private Player player;
    private JScrollPane scrollPane = new JScrollPane();
    private List<Card> cards;
    private JPanel panel = new JPanel();

    public Cards(Player player) {
        this.player = player;
        cards = player.getCards();
        setCards();
    }

    public void setCards() {
        Map<Colour, Color> colors = new HashMap<>();
        colors.put(Colour.Black, Color.black);
        colors.put(Colour.Blue, Color.blue);
        colors.put(Colour.Green, Color.green);
        colors.put(Colour.Red, Color.red);
        colors.put(Colour.Yellow, Color.yellow);
        for (Card card : cards) {
            JButton jButton = new JButton();
            jButton.setText(card.sign.name());
            jButton.setBackground(colors.get(card.colour));
            panel.add(jButton);
        }
        scrollPane.add(panel);
        JButton uno = new JButton("UNO");
        uno.setPreferredSize(new Dimension(80, 70));
        uno.setFont(new Font("Verdana", 16, 16));
        add(scrollPane);
    }

    public static void main(String[] args) {
        Player taj = new Player("Taj");

        Card card = new Card();
        card.colour = Colour.Black;
        card.sign = Sign._4;

        taj.take(card);

        new JFrame().add(new Cards(taj)).setVisible(true);
    }
}
