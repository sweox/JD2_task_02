package hibernate.xml.view;


import hibernate.xml.util.CreateSessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import java.util.List;


public class RunSelect {

    private static final String QUERY =
            "select city.city, country.country, address.street " +
                    "from Address address " +
                    "inner join address.city city " +
                    "inner join city.country country ";


    private static SessionFactory sessionFactory = CreateSessionFactory.getSessionFactory();

    public static void main(String[] args) {

        new RunSelect().listSelect();

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
