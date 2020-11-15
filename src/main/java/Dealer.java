import DeckOfCards.Card;
import DeckOfCards.Deck;

import java.util.ArrayList;

public class Dealer {

    private Deck deck;
    private ArrayList<Card> hand;

    public Dealer(){
        hand = new ArrayList<Card>();
        deck = new Deck();
        deck.fillDeck();
        deck.shuffleDeck();
    }

    public void addCardToHand(Card card) {
        this.hand.add(card);
    }

    public Card dealTopCard(){
        return deck.dealTopCard();
    }

    public void showOneCard(){
        Card firstCard = this.hand.get(0);
        System.out.println("The Dealer has " + firstCard.getRank().getValue() + " of " + firstCard.getSuit());
    }



}
