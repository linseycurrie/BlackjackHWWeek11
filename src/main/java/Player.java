import DeckOfCards.Card;
import java.util.ArrayList;
import java.util.Scanner;

public class Player {

    private String name;
    private ArrayList<Card> hand;

    public Player(String name) {
        this.name = name;
        hand = new ArrayList<Card>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void addCardToHand(Card card) {
        this.hand.add(card);
    }

    public int getNumberOfCardsInHand(){
        return this.hand.size();
    }

    public void showCardsInHand() {
        for (Card eachCard : hand) {
            System.out.println(eachCard.getRank() + " of " + eachCard.getSuit());
        }
    }

    public int getTotalHandValue(){
        int total = 0;
        for(Card card : this.hand) {
            total += card.getRank().getValue();
        }
        if( total > 21){
            total -= 10;
            }
        return total;
    }


}
