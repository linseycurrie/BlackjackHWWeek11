import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestGame {

    private Dealer dealer;
    private Player player1;
    private Player player2;
    private Game game;

    @Before
    public void before() {
        dealer = new Dealer();
        game = new Game(dealer);
        player1 = new Player("Bob");
        player2 = new Player("John");
        game.addPlayer(player1);
        game.addPlayer(player2);

    }

    @Test
    public void canAddPlayers() {
        assertEquals(2, game.getNumOFPlayers());
    }

    @Test
    public void canDeal2CardsToPlayers() {
        game.dealTheCards();
        assertEquals(2, player1.getNumberOfCardsInHand());
    }

    @Test
    public void dealerGets2CardsInHand() {
        game.dealTheCards();
        assertEquals(2, dealer.getNumOfCardsInHand());
    }
}

