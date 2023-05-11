package org.yearup.application;

import org.yearup.models.Card;
import org.yearup.models.Deck;
import org.yearup.models.Hand;

import java.util.ArrayList;

public class Game
{
    private Deck deck;
    private ArrayList<Hand> players;


    public Game()
    {
        deck = new Deck();
        players = new ArrayList<>();

        players.add(new Hand("Susan"));
        players.add(new Hand("Gary"));
    }

    public Hand getWinner()
    {
        Hand player1 = players.get(0);
        Hand player2 = players.get(1);

        if(player1.getValue() > player2.getValue())
        {
            return player1;
        }
        else
        {
            return player2;
        }

    }

    public void play()
    {
        Hand player1 = players.get(0);
        Hand player2 = players.get(1);
        Card card;

        deck.shuffle();

        for (int i = 0; i < 2; i++)
        {
            card = deck.deal();
            player1.deal(card);

            card = deck.deal();
            player2.deal(card);

        }

        System.out.printf("%s has %d\n", player1.getPlayerName(), player1.getValue());
        System.out.printf("%s has %d\n", player2.getPlayerName(), player2.getValue());

        System.out.println();
        System.out.println("---------------");
        System.out.println("WINNER: " + getWinner().getPlayerName());
        System.out.println("---------------");
    }


}
