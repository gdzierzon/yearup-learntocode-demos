package org.yearup.models;

import java.util.ArrayList;
import java.util.Collections;

public class Deck
{
    private ArrayList<Card> cards = new ArrayList<>();

    public Deck()
    {
        // create all cards for the deck
        String[] suits = {"Hearts","Spades","Diamonds","Clubs"};
        String[] values = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};

        for(String suit : suits)
        {
            for(String value : values)
            {
                Card card = new Card(suit, value);
                cards.add(card);
            }
        }
    }

    public int countCards()
    {
        return cards.size();
    }

    public Card deal()
    {
        // take a card off the deck
        return cards.remove(0);
    }

    public void shuffle()
    {
        Collections.shuffle(cards);
    }
}
