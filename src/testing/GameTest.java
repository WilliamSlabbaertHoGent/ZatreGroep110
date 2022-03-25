package testing;

import domain.Game;
import domain.Player;
import exceptions.PlayerNotFoundException;
import exceptions.PlayerSelectedException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GameTest {
    Game game;

    /*** UC2 ***/

    @BeforeEach
    public void before() {
        this.game = new Game();
    }

    @Test
    public void test_addPlayerNull_throws_PlayerNotFoundException() {
        Assertions.assertThrows(PlayerNotFoundException.class, () -> {
            this.game.addPlayer(null);
        });
    }

    @Test
    public void test_addPlayer_samePlayers_throws_PlayerSelectedException() {
        Player player1 = new Player("testcase", 1997);

        this.game.addPlayer(player1);
        Assertions.assertThrows(PlayerSelectedException.class, () -> {
            this.game.addPlayer(player1);
        });
    }

    @Test
    public void test_addPlayer_maxPlayers_throws_PlayerSelectedException() {

        int yearOfBirth = 1997;
        List<Player> players = new ArrayList<>();

        // add four players
        for (int x = 1; x <= 4; x++) {
            this.game.addPlayer(
              new Player(String.format("testcase%d", x), yearOfBirth)
            );
        }

        Assertions.assertThrows(PlayerSelectedException.class, () -> {
           this.game.addPlayer(new Player("testcase5", yearOfBirth));
        });
    }

    @Test
    public void test_addPlayer_notEnoughGames_throws_PlayerSelectedException() {
        Assertions.assertThrows(PlayerSelectedException.class, () -> {
            this.game.addPlayer(
                    new Player(
                            "testcase",
                            1997,
                            0
                    )
            );
        });
    }
}
