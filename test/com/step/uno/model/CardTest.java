package com.step.uno.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

public class CardTest {
    @Test
    public void twoCardsAreEqualWhenTheirColorAndSignAreSame() {
        Card first_1_black = new Card();
        Card second_1_black = new Card();
        second_1_black.colour = Colour.Black;
        first_1_black.colour = Colour.Black;

        first_1_black.sign = Sign._1;
        second_1_black.sign = Sign._1;

        assertEquals(first_1_black, second_1_black);
    }

    @Test
    public void twoCardsAreNotEqualWhenTheirColorOrSignDoNotMatch() {
        Card _1_black = new Card();
        _1_black.colour = Colour.Black;
        _1_black.sign = Sign._1;
        Card _1_blue = new Card();
        _1_blue.colour = Colour.Blue;
        _1_blue.sign = Sign._1;
        assertNotSame(_1_blue,_1_black);
    }
}
