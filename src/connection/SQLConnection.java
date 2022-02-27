package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection {

    final String URL = "jdbc:mysql://localhost/ZATRE_G110";
    final String USER = "mysqladmin";
    final String PASS = "P@ssw0rd";

    public Connection connect() throws SQLException
    {
        return DriverManager.getConnection(URL, USER, PASS);
    }

}
