package hibernate.xml.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateSessionFactory {
    private static SessionFactory sessionFactory;

    private CreateSessionFactory() {
    }

    public static synchronized SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                sessionFactory = new Configuration()
                        .configure("hibernate.cfg.xml")
                        .buildSessionFactory();
                System.out.println("=== Hibernate configuration loaded.");

            } catch (Throwable e) {
                System.out.println("=== Failed to create sessionFactory object === " + e);

            }

        }
        return sessionFactory;
    }
}
