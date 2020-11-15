import DeckOfCards.Card;
import DeckOfCards.Deck;
import DeckOfCards.Rank;
import DeckOfCards.Suit;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestDeck {

    private Deck deck;

    @Before
    public void before(){
        deck = new Deck();
        deck.fillDeck();
    }

    @Test
    public void deckIsFilledWithCards(){
        assertEquals(false, deck.deckEmpty());
    }

    @Test
    public void canDealCard(){
        Card firstCard = deck.dealTopCard();
        Suit suit = firstCard.getSuit();
        Rank rank = firstCard.getRank();
        assertEquals(Suit.CLUBS, firstCard.getSuit());
        assertEquals(Rank.ACE, firstCard.getRank());
    }

}
