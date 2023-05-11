package org.yearup.models;

import java.util.ArrayList;

public class Hand
{
    private ArrayList<Card> cards = new ArrayList<>();
    private String playerName;

    public Hand(String playerName)
    {
        this.playerName = playerName;
    }

    public String getPlayerName()
    {
        return playerName;
    }

    public void deal(Card card)
    {
        cards.add(card);
    }

    public int getValue()
    {
        // create the aggregator
        int handValue = 0;

        // add all card values
        for(Card card: cards)
        {
            // peek at card
            card.flip();
            handValue += card.getValue();
            // hide card again
            card.flip();
        }

        // return the total
        return handValue;
    }
}
