import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void testFirstPlayerWin() {
        Player oleg = new Player(1, "Олег", 20);
        Player sasha = new Player(2, "Саша", 10);
        Game game = new Game();

        game.register(oleg);
        game.register(sasha);

        int actual = game.round("Олег", "Саша");
        int expected = 1;

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void testSecondPlayerWin() {
        Player oleg = new Player(1, "Олег", 20);
        Player sasha = new Player(2, "Саша", 30);
        Game game = new Game();

        game.register(oleg);
        game.register(sasha);

        int actual = game.round("Олег", "Саша");
        int expected = 2;

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void testWhenDraw() {
        Player oleg = new Player(1, "Олег", 20);
        Player sasha = new Player(2, "Саша", 20);
        Game game = new Game();

        game.register(oleg);
        game.register(sasha);

        int actual = game.round("Олег", "Саша");
        int expected = 0;

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void testWhenFirstPlayerNotFound() {
        Player sasha = new Player(2, "Саша", 30);
        Game game = new Game();

        game.register(sasha);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Олег", "Саша"));
    }

    @Test
    public void testWhenSecondPlayerNotFound() {
        Player sasha = new Player(2, "Саша", 30);
        Game game = new Game();

        game.register(sasha);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Саша", "Ваня"));
    }
}
