package com.step.uno.client.screen;

import com.step.uno.client.model.GameClient;
import com.step.uno.model.Card;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayCardActionListener implements ActionListener {
    private Card card;
    private GameClient gameClient;
    private JPanel panel;
    private Card openCard;

    public PlayCardActionListener(Card card, GameClient gameClient, JPanel panel, Card openCard) {
        this.card = card;
        this.gameClient = gameClient;
        this.panel = panel;
        this.openCard = openCard;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();

        if (canPlay(card, openCard)) {
            gameClient.play(card, card.colour);
            button.setVisible(false);
            panel.remove(button);
            panel.revalidate();
        } else
            button.setToolTipText("You cannot play this card on " + openCard);
    }

    public boolean canPlay(Card playedCard, Card openPileCard) {
        return playedCard.colour.equals(openPileCard.colour) || playedCard.sign.equals(openPileCard.sign);
    }
}
