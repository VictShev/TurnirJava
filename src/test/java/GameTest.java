import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test

    public void BothPlayerHaveSameStrength() {
        Game game = new Game();
        Player Oscar = new Player(1, "Oscar", 99);
        Player Leo = new Player(2, "Leo", 99);

        game.register(Oscar);
        game.register(Leo);
        int expected = 0;
        int actual = game.round("Oscar", "Leo");

        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void FirstPlayerStronger() {
        Game game = new Game();
        Player Oscar = new Player(1, "Oscar", 110);
        Player Leo = new Player(2, "Leo", 99);

        game.register(Oscar);
        game.register(Leo);
        int expected = 1;
        int actual = game.round("Oscar", "Leo");

        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void SecondPlayerStronger() {
        Game game = new Game();
        Player Oscar = new Player(1, "Oscar", 99);
        Player Leo = new Player(2, "Leo", 120);

        game.register(Oscar);
        game.register(Leo);
        int expected = 2;
        int actual = game.round("Oscar", "Leo");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void FirstPlayerDoesnotExist() {
        Game game = new Game();
        Player Oscar = new Player(1, "Oscar", 99);
        Player Leo = new Player(2, "Leo", 120);

        game.register(Oscar);
        game.register(Leo);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Chris", "Leo")
        );
    }

    @Test
    public void SecondPlayerDoesnotExist() {
        Game game = new Game();
        Player Oscar = new Player(1, "Oscar", 99);
        Player Leo = new Player(2, "Leo", 120);

        game.register(Oscar);
        game.register(Leo);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Oscar", "Nadya")
        );

    }
}
