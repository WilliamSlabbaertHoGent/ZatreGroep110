package testing;

import domain.Player;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    Player player;

    @BeforeEach
    public void before() {
        this.player = new Player();
    }

    @Test
    public void test_gamesCountInitialize_assert_5() {
        Assertions.assertEquals(5, this.player.getGamesCount());
    }

    @Test
    public void test_newPlayerYoungerThanSix_throws_InvalidArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            this.player.setYearOfBirth(2017);
        });
    }

    @Test
    public void test_newPlayerTurnsSixThisYear_doesNotThrow_InvalidArgumentException() {
        Assertions.assertDoesNotThrow(() -> {
            this.player.setYearOfBirth(2016);
        });
    }

    @Test
    public void test_newPlayerPlayerName_throws_InvalidArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
           this.player.setPlayerName("test");
        });
    }

}
