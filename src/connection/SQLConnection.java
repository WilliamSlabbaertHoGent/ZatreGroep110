package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection {

    final String URL = "jdbc:mysql://ID373150_g110.db.webhosting.be/ID373150_g110";
    final String USER = "ID373150_g110";
    final String PASS = "Banaan110!";
    Connection connection;

    public Connection connect() throws SQLException
    {
    	this.connection = DriverManager.getConnection(URL, USER, PASS);
        return this.connection;
    }
    
    public void closeConnection() throws SQLException
    {
    	this.connection.close();
    }

}
