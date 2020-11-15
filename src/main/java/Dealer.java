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

    public void showCardsInHand() {
        for (Card eachCard : hand) {
            System.out.println(eachCard.getRank() + " of " + eachCard.getSuit());
        }
    }

    public int getTotalHandValue(){
        int total = 0;
        for(Card card : this.hand){
            total += card.getRank().getValue();
            if( total > 21){
                total -= 10;
            }
        }
        return total;
    }

    public int getNumOfCardsInHand() {
        return this.hand.size();
    }
}
