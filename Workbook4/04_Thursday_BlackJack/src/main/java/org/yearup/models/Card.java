package org.yearup.models;

public class Card
{
    private String suit;
    private String faceValue;
    private boolean isFaceUp;

    public Card(String suit, String faceValue)
    {
        this.suit = suit;
        this.faceValue = faceValue;
        isFaceUp = false;
    }

    public String getSuit()
    {
        if(!isFaceUp) return "unknown";

        return suit;
    }

    public String getFaceValue()
    {
        if(!isFaceUp) return "unknown";

        return faceValue;
    }

    public int getValue()
    {
        if(!isFaceUp) return 0;

        switch (faceValue)
        {
            case "A":
                return 11;
            case "K":
            case "Q":
            case "J":
                return 10;
            default:
                return Integer.parseInt(faceValue);
        }
    }

    public boolean isFaceUp()
    {
        return isFaceUp;
    }

    public String getColor()
    {
        if(isFaceUp)
        {
            switch (suit)
            {
                case "Diamonds":
                case "Hearts":
                    return "Red";
                case "Spades":
                case "Clubs":
                default:
                    return "Black";
            }
        }

        return "unknown";
    }

    public void flip()
    {
//        if(isFaceUp)
//        {
//            isFaceUp = false;
//        }
//        else
//        {
//            isFaceUp = true;
//        }

        isFaceUp = !isFaceUp;
    }
}
