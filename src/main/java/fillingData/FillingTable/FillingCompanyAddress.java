package fillingData.FillingTable;

import jdbc.connection.ConnectionSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FillingCompanyAddress implements FillingTable {

    private static final String INSERT_INTO_COMPANY_ADDRESS =
            "INSERT INTO company_address (fid_company, fid_address) VALUES (?, ?)";

    public void fill() {
        Connection connection = ConnectionSingleton.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_COMPANY_ADDRESS);

            for(int i = 1; i <= 50; ++i) {
                preparedStatement.setInt(1,(int)(1 + Math.random() * 50));
                preparedStatement.setInt(2,(int)(1 + Math.random() * 50));
                preparedStatement.executeUpdate();
            }
            preparedStatement.close();
            connection.close();

            System.out.println("Filling the Company_Address table is completed.");

        } catch (SQLException e) {
            System.err.println("SQL error in FillingCompanyAddress == " + e);
            try {
                connection.rollback();
                System.err.println("Rollback is done in FillingCompanyAddress!");
            } catch (SQLException e1) {
                System.err.println("SQL error rollback " + e);
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
