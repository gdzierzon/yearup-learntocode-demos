import org.yearup.models.cards.facecards.FaceCard;
import org.yearup.models.cards.facecards.builders.CardBuilder;
import org.yearup.models.cards.facecards.cards.King;
import org.yearup.models.cards.facecards.constants.Suits;
import org.yearup.models.games.BlackJack;
import org.yearup.models.hands.BlackJackHand;
import org.yearup.models.players.BlackJackPlayer;
import org.yearup.models.players.Player;
import org.yearup.ui.UserOutput;

import java.util.ArrayList;
import java.util.List;

public class Samples
{
    public static void main(String[] args)
    {
        List<String> names = new ArrayList<>();
        names.add("test");
        King king = new King(Suits.SPADES);

        FaceCard q = CardBuilder.QUEEN_DIAMONDS();
        FaceCard k = CardBuilder.KING_DIAMONDS();

    }

    public static void demo()
    {
        Player player = new Player("Gregor");
        player.deal(CardBuilder.QUEEN_DIAMONDS());
        player.deal(CardBuilder.TWO_CLUBS());
        player.deal(CardBuilder.EIGHT_SPADES());
        player.deal(CardBuilder.THREE_SPADES());
        player.deal(CardBuilder.ACE_HEARTS());
        player.deal(CardBuilder.ACE_SPADES());
        player.deal(CardBuilder.TWO_DIAMONDS());

        UserOutput.showHand(player);
    }



    public void run()
    {
        BlackJack game = new BlackJack();

        BlackJackPlayer gary = new BlackJackPlayer("Gary");
        BlackJackPlayer sarah = new BlackJackPlayer("Sarah");
        BlackJackPlayer steph = new BlackJackPlayer("Steph");

        game.join(gary);
        game.join(sarah);
        game.join(steph);

        game.dealPlayersIn();

        for (int i = 0; i < 5; i++)
        {
            for(Player player : game.getPlayers())
            {
                BlackJackHand hand = (BlackJackHand) player.showHand();
                if(!hand.isBust() && hand.getValue() + 6 < 21)
                {
                    game.hit(player);
                }
            }
        }

        for(Player player : game.getPlayers())
        {
            UserOutput.showHand(player);
        }

        // declares winner
        game.endGame();

        UserOutput.winner(game.getWinner());
    }
}
