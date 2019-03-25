package hibernate.annotation.view;

import hibernate.annotation.util.CreateSessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class RunSelect {

    private static final String QUERY1 =
            "select city.city, country.country, address.street " +
                    "from Address address " +
                    "inner join address.city city " +
                    "inner join city.country country ";

    private static final String QUERY =
            "select " +
                    "employee.firstName, " +
                    "employee.lastName, " +
                    "employeeAddress.street, " +
                    "employeeCity.city, " +
                    "employeeCountry.country, " +
                    /*"company.position " +*/
                        "from Employee as employee " +
                            "join employee.address as employeeAddress " +
                            "join employeeAddress.city as employeeCity " +
                            "join employeeCity.country as employeeCountry " +
                            /*"join employee.companyEmployees as company " +*/
                            " ";


    private static SessionFactory sessionFactory = CreateSessionFactory.getSessionFactory();

    public static void main(String[] args) {

        new RunSelect().listSelect2();

    }

    public void listSelect2() {

        Session session = sessionFactory.getCurrentSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List<Object[]> selectFrom = session.createQuery(QUERY).list();

            for (Object[] rawReturn : selectFrom) {
                String firstName = (String) rawReturn[0];
                String lastName = (String) rawReturn[1];
                String employeeAddress = (String) rawReturn[2];
                String employeeCity = (String) rawReturn[3];
                String employeeCountry = (String) rawReturn[4];

                System.out.println(
                        firstName + " \t" +
                        lastName + " \t" +
                        employeeAddress + "  \t" +
                        employeeCity + " \t" +
                        employeeCountry + " \t" );
            }

            System.out.println();


            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
                System.out.println("=== Hibernate exception in SELECT method === " + e);
            }
        } finally {
            session.close();
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
    }

    public void listSelect() {

        Session session = sessionFactory.getCurrentSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List<Object[]> selectFrom = session.createQuery(QUERY).list();

            for (Object[] rawReturn : selectFrom) {
                String city = (String) rawReturn[0];
                String country = (String) rawReturn[1];
                String street = (String) rawReturn[2];
                System.out.println(city + " " + country + " " + street);
            }


            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
                System.out.println("=== Hibernate exception in SELECT method === " + e);
            }
        } finally {
            session.close();
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
    }

}
