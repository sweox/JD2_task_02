package fillingData.FillingTable;

import jdbc.connection.ConnectionSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FillingCompanyEmployee implements FillingTable {

    private static final String INSERT_INTO_COMPANY_EMPLOYEE =
            "INSERT INTO company_employee (fid_company, fid_employee, position) VALUES (?, ?, ?)";

    public void fill() {
        Connection connection = ConnectionSingleton.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_COMPANY_EMPLOYEE);

            for(int i = 1; i <= 50; ++i) {
                preparedStatement.setInt(1,(int)(1 + Math.random() * 50));
                preparedStatement.setInt(2,(int)(1 + Math.random() * 100));
                preparedStatement.setString(3, "Position " + (int) (1 + Math.random() * 20));
                preparedStatement.executeUpdate();
            }
            preparedStatement.close();
            connection.close();

            System.out.println("Filling the Company_Employee table is completed.");

        } catch (SQLException e) {
            System.err.println("SQL error in FillingCompanyEmployee == " + e);
            try {
                connection.rollback();
                System.err.println("Rollback is done in FillingCompanyEmployee!");
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
