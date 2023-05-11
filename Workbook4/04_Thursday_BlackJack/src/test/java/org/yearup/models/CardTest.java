package org.yearup.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest
{

    @Test
    public void getColor_should_return_redForDiamonds()
    {
        // arrange
        Card card = new Card("Diamonds", "Q");
        String expected = "Red";
        card.flip();

        // act
        String actual = card.getColor();

        // assert
        assertEquals(expected, actual, "Because the card is a Queen of Diamonds");

    }

    @Test
    public void getColor_should_return_blackForSpades()
    {
        // arrange
        Card card = new Card("Spades", "Q");
        String expected = "Black";
        card.flip();

        // act
        String actual = card.getColor();

        // assert
        assertEquals(expected, actual, "Because the card is a Queen of Spades");

    }

    @Test
    public void getColor_should_return_unknownWhenFaceDown()
    {
        // arrange
        Card card = new Card("Diamonds", "Q");
        String expected = "unknown";
        // guarantee that card is face down
        if(card.isFaceUp())
        {
            card.flip();
        }

        // act
        String actual = card.getColor();

        // assert
        assertEquals(expected, actual, "Because the card is face down");

    }

    @Test
    public void getValue_should_returnTheNumberOfTheFaceValue()
    {
        // arrange
        Card card = new Card("Diamonds", "7");
        int expected = 7;
        card.flip();

        // act
        int actual = card.getValue();

        // assert
        assertEquals(expected, actual, "Because it is a 7 of Diamonds");
    }

    @Test
    public void getValue_should_return10ForKQJ()
    {
        // arrange
        Card card = new Card("Diamonds", "K");
        int expected = 10;
        card.flip();

        // act
        int actual = card.getValue();

        // assert
        assertEquals(expected, actual, "Because it is a King of Diamonds");
    }

    @Test
    public void getValue_should_return11ForAce()
    {
        // arrange
        Card card = new Card("Diamonds", "A");
        int expected = 11;
        card.flip();

        // act
        int actual = card.getValue();

        // assert
        assertEquals(expected, actual, "Because it is a Ace of Diamonds");
    }

    @Test
    public void getValue_should_return0_whenCardIsFaceDown()
    {
        // arrange
        Card card = new Card("Diamonds", "A");
        int expected = 0;
        if(card.isFaceUp())
        {
            card.flip();
        }

        // act
        int actual = card.getValue();

        // assert
        assertEquals(expected, actual, "Because the card is face down");
    }

}