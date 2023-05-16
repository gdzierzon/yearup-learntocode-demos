package org.yearup.models.players;

import org.yearup.models.cards.Card;
import org.yearup.models.hands.Hand;

public class Player
{
    private String name;
    private Hand hand;

    public Player(String name)
    {
        this.name = name;
        this.hand = new Hand();
    }

    public Player(String name, Hand hand)
    {
        this.name = name;
        this.hand = hand;
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

    public boolean hasCards()
    {
        return hand.getCards().size() > 0;
    }

    public Card getNextCard()
    {
        if(hasCards())
        {
            return hand.getCards().get(0);
        }
        return null;
    }

    public void discard(Card card)
    {
        hand.discard(card);
    }
}
