import DeckOfCards.Card;
import DeckOfCards.Rank;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private Dealer dealer;
    private ArrayList<Player> players;
    private Scanner scanner;

    public Game(Dealer dealer){
        this.dealer = dealer;
        players = new ArrayList<Player>();
        scanner = new Scanner(System.in);
    }

    public int getNumOFPlayers(){
        return this.players.size();
    }

//    public void getNumOfPlayers() throws IOException {
//        System.out.println("How many Players are playing today ? ");
//        int numberOfPlayers = scanner.nextInt();
//
//        for (int i = 0; i < numberOfPlayers; i++) {
//            System.out.println("Name of player: ");
//            System.in.read();
//            String playersName = scanner.nextLine();
//            Player player = new Player(playersName);
//        }
//    }

    public void addPlayer(Player player){
        this.players.add(player);
    }

    public void dealTheCards() {
        for (int i = 0; i < 2; i++) {
            dealer.addCardToHand(dealer.dealTopCard());
            for (Player player : players) {
                player.addCardToHand(dealer.dealTopCard());
            }
        }
        dealer.showOneCard();
    }

    public void twistOrStick(Player player) throws IOException {
        String answer = "yes";
        while (answer.equalsIgnoreCase("yes")) {
            System.out.println("Would you like another card ? yes or no?");
            Scanner scanner = new Scanner(System.in);
            answer = scanner.nextLine();
            System.in.read();
            if(answer.equalsIgnoreCase("yes")){
                player.addCardToHand(dealer.dealTopCard());
                player.showCardsInHand();
            }
        }
    }

    public void twistOrStick(Dealer dealer) throws IOException {
        String answer = "yes";
        while (answer.equalsIgnoreCase("yes")) {
            System.out.println("Would you like another card ? yes or no?");
            Scanner scanner = new Scanner(System.in);
            answer = scanner.nextLine();
            System.in.read();
            if(answer.equalsIgnoreCase("yes")){
                dealer.addCardToHand(dealer.dealTopCard());
                dealer.showCardsInHand();
            }
        }
    }

    public void calculateTheWinner(){
        Player winner = players.get(0);
        int winningScore = 0;

        for(Player player: players){
            int card1Value = player.getHand().get(0).getRank().getValue();
            int card2Value = player.getHand().get(1).getRank().getValue();
            if(card1Value == 10 | card2Value == 10 && player.getHand().contains(Rank.ACE)){
                System.out.println("The winner is ");
                player.getName();
                System.out.println("With Blackjack!!");
                player.getTotalHandValue();
                break;
            }
        }

        for(Player player: players){
            if(player.getTotalHandValue() < 21 &&  player.getTotalHandValue() > winner.getTotalHandValue()){
                winner = player;
                winningScore = player.getTotalHandValue();
            }
        }

        if(dealer.getTotalHandValue() < 21 && dealer.getTotalHandValue() > winningScore){
            System.out.println("The Dealer wins with is the ");
            dealer.showCardsInHand();
        } else {
            System.out.println(String.format("The winner is %s with a score of %s", winner.getName(), winningScore));
        }

    }
}
