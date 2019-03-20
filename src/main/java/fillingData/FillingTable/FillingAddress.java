package fillingData.FillingTable;

import jdbc.connection.ConnectionSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FillingAddress implements FillingTable {

    private static final String INSERT_NEW_ADDRESS_INTO_ADDRESS =
            "INSERT INTO address (street, fid_city) VALUES (?, ?)";

    public void fill() {
        Connection connection = ConnectionSingleton.getConnection();

        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_ADDRESS_INTO_ADDRESS);

            for (int i = 1; i <= 130; i++) {
                preparedStatement.setString(1, "Street " + i);
                preparedStatement.setInt(2, (int) (1 + Math.random() * 100));

                preparedStatement.execute();
            }
            connection.commit();

            preparedStatement.close();
            connection.close();

            System.out.println("Filling the Address table is completed.");

        } catch (SQLException e) {
            System.err.println("SQL error in FillingAddress === " + e);

            try {
                connection.rollback();
                System.err.println("Rollback is done in FillingAddress!");
            } catch (SQLException e1) {
                System.out.println("Error during rollback === "+ e1);
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
