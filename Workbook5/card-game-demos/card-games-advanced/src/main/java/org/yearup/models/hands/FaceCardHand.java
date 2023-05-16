package org.yearup.models.hands;

import org.yearup.models.cards.Card;
import org.yearup.models.cards.facecards.FaceCard;

import java.util.ArrayList;
import java.util.List;

public class FaceCardHand extends Hand
{
    public List<FaceCard> getFaceCards()
    {
        List<FaceCard> cards = new ArrayList<>();
        for(Card card : this.cards)
        {
            cards.add((FaceCard)card);
        }
        return cards;
    }

    @Override
    public void deal(Card card)
    {
        if(card instanceof FaceCard)
            super.deal(card);
    }
}
