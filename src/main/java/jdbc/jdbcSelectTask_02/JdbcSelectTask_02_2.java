package jdbc.jdbcSelectTask_02;

import jdbc.connection.ConnectionSingleton;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcSelectTask_02_2 {
    public static void main(String[] args) {
        new JdbcSelectTask_02_2().jdbcSelectTask_02();
    }


    private static final String SELECT = "SELECT CONCAT_WS('    ', " +
            "                 employee.first_name, " +
            "                 employee.last_name)        AS 'Name', " +
            "       CONCAT_WS(', ', " +
            "                 address.street, " +
            "                 city.city, " +
            "                 country.country)           AS 'Address', " +
            "       CONCAT_WS(', ', " +
            "                 company.name_company, " +
            "                 companyCity.city, " +
            "                 companyCountry.country, " +
            "                 companyAddress.street, " +
            "                 count(company_employee.fid_company), " +
            "                 company_employee.position) AS 'Offices' " +
            "FROM employee " +
            "       JOIN address ON employee.fid_address = address.id_address " +
            "       JOIN company_employee ON employee.id_employee = company_employee.fid_employee " +
            "       JOIN company ON company_employee.fid_company = company.id_company " +
            "       JOIN city ON address.fid_city = city.id_city " +
            "       JOIN country ON city.fid_country = country.id_country " +
            "       JOIN company_address ON company.id_company = company_address.fid_company " +
            "       JOIN address companyAddress ON company_address.fid_address = companyAddress.id_address " +
            "       JOIN city companyCity ON companyAddress.fid_city = companyCity.id_city " +
            "       JOIN country companyCountry ON companyCity.fid_country = companyCountry.id_country " +
            "" +
            "GROUP BY employee.first_name " +
            "ORDER BY employee.id_employee " +
            "LIMIT 100 " +
            ";";

    public void jdbcSelectTask_02() {
        Connection connection = ConnectionSingleton.getConnection();

        try {

            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT);

            while (resultSet.next()) {
                String name = resultSet.getString("Name");
                String address = resultSet.getString("Address");
                String offices = resultSet.getString("Offices");

                System.out.println(name + " \t||\t" + address + "\t||\t" + offices);
            }


        } catch (SQLException e) {
            System.err.println("SQL error in jdbcSelectTask_02 ==  " + e);

            try {
                connection.rollback();
                System.err.println("Rollback is done in jdbcSelectTask_02!");
            } catch (SQLException e1) {
                System.err.println("Error rollback " + e1);
            }
        } finally {
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
