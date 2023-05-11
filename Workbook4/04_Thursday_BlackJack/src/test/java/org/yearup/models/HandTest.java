package org.yearup.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandTest
{

    @Test
    public void getValue_should_returnTotalValueOfAllCards()
    {
        // arrange
        Card card1 = new Card("Spades", "10");
        Card card2 = new Card("Hearts", "5");
        Hand hand = new Hand("Joe Tester");
        hand.deal(card1);
        hand.deal(card2);
        int expected = 15;

        // act
        int actual = hand.getValue();

        // assert
        assertEquals(expected, actual, "Because I dealt a 10 of Spades and a 5 of Hearts");
    }

}