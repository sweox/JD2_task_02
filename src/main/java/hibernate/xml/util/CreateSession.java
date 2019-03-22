package hibernate.xml.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateSession {
    private static SessionFactory sessionFactory;

    private CreateSession() {  }

    public static synchronized SessionFactory getSession() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .buildSessionFactory();
        }
        return sessionFactory;
    }
}
