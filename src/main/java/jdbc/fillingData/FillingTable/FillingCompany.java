package jdbc.fillingData.FillingTable;

import jdbc.connection.ConnectionSingleton;
import jdbc.fillingData.FillingTable.FillingTable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FillingCompany implements FillingTable {

    private static final String INSERT_NEW_COMPANY_INTO_COMPANY =
            "INSERT INTO company (name_company) VALUES (?)";

    public void fill() {
        Connection connection = ConnectionSingleton.getConnection();
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement =
                    connection.prepareStatement(INSERT_NEW_COMPANY_INTO_COMPANY);

            for (int i = 1; i <= 50; i++) {
                preparedStatement.setString(1,"Company " + i);
                preparedStatement.executeUpdate();
            }
            connection.commit();

            preparedStatement.close();
            connection.close();

            System.out.println("Filling the Company table is completed.");

        } catch (SQLException e) {
            System.err.println("SQL error in FillingCompany == " + e);

            try {
                connection.rollback();
                System.err.println("Rollback is done in FillingCompany!");
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
//            System.out.println("Start finale in FillingCompany");
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
