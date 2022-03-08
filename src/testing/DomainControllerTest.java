package testing;

import controller.DomainController;
import domain.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;
import java.util.NoSuchElementException;

public class DomainControllerTest {
    private DomainController controller;

    @BeforeEach
    protected void before() throws SQLException {
        this.controller = new DomainController();
    }

    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!//
    //---------------------------------------//
    //-----Needs a delete player function----//
    //---------------------------------------//
    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!//

    @Test
    public void testRegisterPlayer(){
        controller.registerPlayer(new Player("testCase",1998));
        var temp = controller.getPlayer("testCase",1998);
        Assertions.assertEquals(temp[0], "testCase");
        Assertions.assertEquals(Integer.parseInt(temp[1].toString()),1998);
    }

    @Test
    public void testGetPlayer_emptyPlayerName_throws_IllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
           this.controller.getPlayer("", 1998);
        });
    }

    @Test
    public void testGetPlayer_emptyYear_throws_IllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            this.controller.getPlayer("testCase", 0);
        });
    }

    @Test
    public void testGetPlayer_unknownPlayer_throws_NoSuchElementException() {
        Assertions.assertThrows(NoSuchElementException.class, () -> {
           this.controller.getPlayer("randomName", 1997);
        });
    }

    @Test
    public void testGetPlayer_playerNotEnoughGames_throws_IllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
           this.controller.getPlayer("playerWithNoGames", 1997);
        });
    }
}
