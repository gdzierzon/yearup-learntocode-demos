package org.yearup.models.players;

import org.yearup.models.cards.Card;
import org.yearup.models.hands.BlackJackHand;
import org.yearup.models.hands.Hand;

public class Player
{
    private String name;
    private BlackJackHand hand;

    public Player(String name)
    {
        this.name = name;
        this.hand = new BlackJackHand();
    }

    public void deal(Card card)
    {
        hand.deal(card);
    }

    public String getName()
    {
        return name;
    }

    public Hand showHand()
    {
        hand.show();
        return hand;
    }

    public int getHandValue()
    {
        return hand.getValue();
    }
}
