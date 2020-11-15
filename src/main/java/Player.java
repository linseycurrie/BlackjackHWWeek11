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
        System.out.println("Please enter your name ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.toString();
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

    public void showCardsInHand() {
        for (Card eachCard : hand) {
            System.out.println(eachCard.getRank().getValue() + " of " + eachCard.getSuit());
        }
    }


}
