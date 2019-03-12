package jdbc.fillingData.FillingTable;

import jdbc.connection.ConnectionSingleton;
import jdbc.fillingData.FillingTable.FillingTable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FillingEmployee implements FillingTable {

    private static final String INSERT_EMPLOYEE_INTO_EMPLOYEE =
            "INSERT INTO employee (first_name, last_name, email, fid_address) VALUES (?, ?, ?, ?)";

    public void fill() {
        Connection connection = ConnectionSingleton.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_INTO_EMPLOYEE);

            for (int i = 1; i <= 100; ++i) {
                preparedStatement.setString(1, "First Name " + i);
                preparedStatement.setString(2, "Last Name " + i);
                preparedStatement.setString(3, "email " + i);
                preparedStatement.setInt(4, (int) (1 + Math.random() * 100));
                preparedStatement.execute();
            }

            preparedStatement.close();
            connection.close();

            System.out.println("Filling the Employee table is completed.");

        } catch (SQLException e) {
            System.err.println("SQL error in FillingEmployee == " + e);
            try {
                connection.rollback();
                System.err.println("Rollback is done in FillingEmployee!");
            } catch (SQLException e1) {
                System.err.println("SQL error rollback " + e);
            }
        } finally {
//            System.out.println("Start finale in FillingEmployee");
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
