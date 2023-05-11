package org.yearup.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest
{

    @Test
    public void newDeck_should_have52Cards()
    {
        // arrange
        Deck deck = new Deck();
        int expected = 52;

        // act
        int actual = deck.countCards();

        // assert
        assertEquals(expected, actual, "Because I have not dealt any cards from this deck.");
    }

    @Test
    public void deal_should_dealACardFromDeck()
    {
        // arrange
        Deck deck = new Deck();
        String expecedSuit = "Hearts";
        int expecedValue = 2;
        int expectedDeckSize = 51;

        // act
        Card card = deck.deal();

        // assert
        assertNotNull(card);
        card.flip();
        assertEquals(expecedSuit, card.getSuit(), "Suit: because we have not shuffled the deck");
        assertEquals(expecedValue, card.getValue(), "Value: because we have not shuffled the deck");
        assertEquals(expectedDeckSize, deck.countCards(), "Deck size: because I dealt one card from this deck.");
    }

    @Test
    public void shuffle_should_shuffleCardsInDeck()
    {
        // arrange
        Deck deck = new Deck();
        String expecedValue = "2_Hearts";
        deck.shuffle();

        // act
        Card card = deck.deal();

        // assert
        assertNotNull(card);
        card.flip();
        String actualValue = card.getFaceValue() + "_" + card.getSuit();
        assertNotEquals(expecedValue, actualValue, "Because I shuffled the deck");
    }

}