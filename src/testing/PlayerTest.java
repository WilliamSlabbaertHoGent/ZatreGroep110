package testing;

import domain.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import static domain.ConstantInterface.*;

import java.time.Year;

public class PlayerTest {
    Player player;

    /*** UC1 ***/
    @Test
    public void test_gamesCountInitialize_assert_5() {
        this.player = new Player("testCase", 1997);
        Assertions.assertEquals(5, this.player.getGamesCount());
    }

    @Test
    public void test_newPlayerYoungerThanSix_throws_InvalidArgumentException() {
        int currentYear = Year.now().getValue();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            this.player = new Player("testCase", currentYear - MIN_AGE + 1);
        });
    }

    @Test
    public void test_newPlayerTurnsSixThisYear_doesNotThrow_InvalidArgumentException() {
        int currentYear = Year.now().getValue();

        Assertions.assertDoesNotThrow(() -> {
            this.player = new Player("testCase", currentYear - MIN_AGE);
        });
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = { "    ", "test" })
    public void test_newPlayerP_throws_InvalidArgumentException(String input) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            this.player = new Player(input, 1997);
        });
    }
}
