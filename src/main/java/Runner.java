import java.io.IOException;

public class Runner {

    public static void main(String[] args) throws IOException {
        Dealer dealer = new Dealer();
        Game game = new Game(dealer);
//        game.getNumOfPlayers();

        Player player1 = new Player("Bob");
        Player player2 = new Player("Susie");
        game.addPlayer(player1);
        game.addPlayer(player2);

        game.dealTheCards();
        System.out.println("Player 1 holds ....");
        player1.showCardsInHand();
        game.twistOrStick(player1);
        System.out.println("Player 2 holds...");
        player2.showCardsInHand();
        game.twistOrStick(player2);

        game.calculateTotals();




    }
}
