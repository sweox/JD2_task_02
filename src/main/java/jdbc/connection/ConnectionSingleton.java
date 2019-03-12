package jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSingleton {

    private static Connection connection;
    private static ConnectionSingleton instance = null;

    public synchronized static Connection getConnection() {
        if (instance == null) {
            instance = new ConnectionSingleton();
            instance.getConnectionJDBC();
        }
        instance.getConnectionJDBC();
        return connection;
    }

    private Connection getConnectionJDBC() {

        final String CONNECT_TO = "jdbc:mysql://127.0.0.1/task_02_2";
        final String LOGIN = "root";
        final String PASSWORD = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(CONNECT_TO, LOGIN, PASSWORD);
//            connection.setAutoCommit(false);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found" + e);
        } catch (SQLException e) {
            System.err.println("SQL Exception " + e);
        }

        return connection;
    }
}
