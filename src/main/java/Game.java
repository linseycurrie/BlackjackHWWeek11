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
}
