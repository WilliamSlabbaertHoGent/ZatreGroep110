package testing;

import controller.DomainController;
import domain.Player;
import junit.framework.TestCase;

import java.sql.SQLException;

public class DomainControllerTest extends TestCase {
    private DomainController controller;

    protected void setUp() throws SQLException {
        this.controller = new DomainController();
    }

    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!//
    //---------------------------------------//
    //-----Needs a delete player function----//
    //---------------------------------------//
    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!//


    public void testRegisterPlayer(){
        controller.registerPlayer(new Player("testCase",1998));
        var temp = controller.getPlayer("testCase",1998);
        assertEquals(temp[1], "testCase");
        assertEquals(Integer.parseInt(temp[2].toString()),1998);
    }
}
