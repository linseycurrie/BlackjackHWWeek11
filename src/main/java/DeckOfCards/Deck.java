package DeckOfCards;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> cards;

    public Deck(){
        cards = new ArrayList<Card>();
    }

    public void fillDeck() {
        int i = 0;
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                Card newCard = new Card(rank, suit);
                cards.add(newCard);
                i++;
            }
        }
    }

    public boolean deckEmpty(){
        return cards.isEmpty();
    }

    public void shuffleDeck(){
        Collections.shuffle(this.cards);
    }

    public Card dealTopCard(){
        return cards.remove(0);
    }

}
