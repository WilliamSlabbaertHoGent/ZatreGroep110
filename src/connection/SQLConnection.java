package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection {

    final String URL = "jdbc:mysql://localhost/ZATRE_G110";
    final String USER = "mysqladmin";
    final String PASS = "P@ssw0rd";
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