package jdbc.fillingData.FillingTable;

import jdbc.connection.ConnectionSingleton;
import jdbc.fillingData.FillingTable.FillingTable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FillingCountry implements FillingTable {


    private static final String INSERT_NEW_COUNTRY_INTO_COUNTRY =
            "INSERT INTO country(country, population_country) VALUES (?, ?)";


    public void fill() {

        Connection connection = ConnectionSingleton.getConnection();

        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_COUNTRY_INTO_COUNTRY);

            for (int i = 1; i <= 100; i++) {
                preparedStatement.setString(1, "Country " + i);
                preparedStatement.setInt(2, (int) (1 + Math.random() * 50000));
                preparedStatement.execute();
            }
            connection.commit();

            preparedStatement.close();
            connection.close();

            System.out.println("Filling the Country table is completed.");

        } catch (SQLException e) {
            System.err.println("SQL error in FillingCountry == " + e);
            try {
                connection.rollback();
                System.err.println("Rollback is done in FillingCountry!");
            } catch (SQLException e1) {
                System.err.println("SQL error rollback " + e);
            }
        } finally {
//            System.out.println("Start finale in FillingCountry");
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
