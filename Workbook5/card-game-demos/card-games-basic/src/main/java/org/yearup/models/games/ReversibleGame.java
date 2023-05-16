package org.yearup.models.games;

import org.yearup.models.players.Player;
import org.yearup.models.cards.Deck;

import java.util.Stack;

public abstract class ReversibleGame extends CardGame
{
    public ReversibleGame(Deck deck)
    {
        super(deck);
    }

    public void reverse()
    {
        Stack<Player> stack = new Stack<>();
        for(Player player : players)
        {
            stack.push(player);
        }

        players.clear();

        while(!stack.isEmpty())
        {
            Player player = stack.pop();
            players.offer(player);
        }
    }
}
