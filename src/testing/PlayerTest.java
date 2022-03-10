package testing;

import domain.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    Player player;

    @Test
    public void test_gamesCountInitialize_assert_5() {
        this.player = new Player("testCase", 1997);
        Assertions.assertEquals(5, this.player.getGamesCount());
    }

    @Test
    public void test_newPlayerYoungerThanSix_throws_InvalidArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            this.player = new Player("testCase", 2017);
        });
    }

    @Test
    public void test_newPlayerTurnsSixThisYear_doesNotThrow_InvalidArgumentException() {
        Assertions.assertDoesNotThrow(() -> {
            this.player = new Player("testCase", 2016);
        });
    }

    @Test
    public void test_newPlayerPlayerNameTooShort_throws_InvalidArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            this.player = new Player("test", 1997);
        });
    }

    @Test
    public void test_newPlayerPlayerNameEmpty_throws_InvalidArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            this.player = new Player("", 1997);
        });
    }
}
