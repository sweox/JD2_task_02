package hibernate.xml.view;


import hibernate.xml.model.City;
import hibernate.xml.model.Country;
import hibernate.xml.util.CreateSessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Iterator;
import java.util.List;



public class RunSelect {


    private static final String QUERY2 = "select country from Country";
    private static final String QUERY3 = "select city, country from City";
    private static final String QUERY =
            "select city.city, country.country " +
                    "from City city " +
                    "inner join city.country country";

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

            for(Object[] rawSelectQuery:selectFrom) {
                String city = (String) rawSelectQuery[0];
                String country = (String) rawSelectQuery[1];
                System.out.println(city + " " + country);
            }

//            for(Iterator iterator = selectFrom.iterator(); iterator.hasNext(); ) {
//                System.out.println(iterator.next());
//            }

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
