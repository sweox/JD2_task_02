package hibernate.xml.view;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RunSelect {
    private static SessionFactory sessionFactory;
    public static void main(String[] args) {

        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .buildSessionFactory();
        } catch (Throwable e) {
            System.out.println("Failed to create sessionFactory object === " + e);
        }

    }
}
