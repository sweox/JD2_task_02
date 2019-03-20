package fillingData.FillingTable;

import jdbc.connection.ConnectionSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FillingCity implements FillingTable {

    private static final String INSERT_NEW_CITY_INTO_CITY =
            "INSERT INTO city (city, fid_country) VALUES (?, ?)";


    private Connection connection;

    public void fill() {


        try {

            connection = ConnectionSingleton.getConnection();
            connection.setAutoCommit(false);

            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_CITY_INTO_CITY);

            for (int i = 1; i <= 100; i++) {
                preparedStatement.setString(1, "City " + i);
                preparedStatement.setInt(2, (int) (1 + Math.random() * 100));
                preparedStatement.executeUpdate();
            }
            connection.commit();

            preparedStatement.close();
            connection.close();

            System.out.println("Filling the City table is completed.");


        } catch (SQLException e) {
            System.err.println("SQL error in FillingCity ==  " + e);

            try {
                connection.rollback();
                System.err.println("Rollback is done in FillingCity!");
            } catch (SQLException e1) {
                System.err.println("Error rollback " + e1);
            }
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Error during close connection === " + e);
                }
            }
        }


    }
}
