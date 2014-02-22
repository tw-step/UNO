package com.step.uno.client.screen;

import com.step.uno.client.model.GameClient;
import com.step.uno.model.Card;
import com.step.uno.model.Colour;
import com.step.uno.model.Sign;
import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class PlayCardActionListenerTest {
    @Test
    public void allowsToPlayTheCardIfColorMatchesToTheCardOnOpenPile() {
        Card card = new Card();
        card.sign = Sign._1;
        card.colour = Colour.Blue;

        GameClient gameClient = mock(GameClient.class);
        JPanel panel = new JPanel();

        Card openCard = new Card();
        openCard.colour = Colour.Blue;
        openCard.sign = Sign._2;

        PlayCardActionListener actionListener = new PlayCardActionListener(card, gameClient, panel, openCard);
        assertTrue(actionListener.canPlay(card, openCard));

    }

    @Test
    public void allowsToPlayTheCardIfNumberMatchesToTheCardOnOpenPile() {
        Card card = new Card();
        card.sign = Sign._1;
        card.colour = Colour.Blue;

        GameClient gameClient = mock(GameClient.class);
        JPanel panel = new JPanel();

        Card openCard = new Card();
        openCard.colour = Colour.Green;
        openCard.sign = Sign._1;

        PlayCardActionListener actionListener = new PlayCardActionListener(card, gameClient, panel, openCard);
        assertTrue(actionListener.canPlay(card, openCard));

    }
}
