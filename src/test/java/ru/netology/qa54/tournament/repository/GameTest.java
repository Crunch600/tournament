package ru.netology.qa54.tournament.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.qa54.tournament.domain.Player;
import ru.netology.qa54.tournament.exceptions.NotRegisterException;

public class GameTest {
    Game game = new Game();
    Player player1 = new Player(1, "Vasya", 300);
    Player player2 = new Player(3, "Kolya", 670);
    Player player3 = new Player(4, "Petya", 70);
    Player player4 = new Player(7, "Seva", 70);
    Player player5 = new Player(8, "Olya", 930);

    @BeforeEach
    void setup() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
    }

    @Test

    public void resultWhenSecondPlayerStronger() {

        int expected = 1;
        int actual = game.round("Olya", "Petya");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void resultWhenFirstPlayerStronger() {

        int expected = -1;
        int actual = game.round("Vasya", "Kolya");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void resultWhenPlayerEquals() {

        int expected = 0;
        int actual = game.round("Petya", "Seva");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void resultWhenPlayerFirstNotExist() {

        Assertions.assertThrows(NotRegisterException.class,
                () -> game.round("Tanya", "Seva")
        );

    }

    @Test
    public void resultWhenPlayerSecondNotExist() {

        Assertions.assertThrows(NotRegisterException.class,
                () -> game.round("Seva", "Tanya")
        );

    }

    @Test
    public void resultWhenPlayersNotExist() {

        Assertions.assertThrows(NotRegisterException.class,
                () -> game.round("Asya", "Tanya")
        );

    }

}
