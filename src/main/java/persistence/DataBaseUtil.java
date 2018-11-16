package persistence;

import entities.db.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class DataBaseUtil {

    private static SessionFactory sessionFactory = buildSessionFactory();

    private DataBaseUtil() {}

    private static SessionFactory buildSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure("configs/db.cfg.xml");

                configuration.addAnnotatedClass(dbBuildingtableEntity.class);
                configuration.addAnnotatedClass(dbFlattableEntity.class);
                configuration.addAnnotatedClass(dbHouseholdtableEntity.class);
                configuration.addAnnotatedClass(dbHumantableEntity.class);
                configuration.addAnnotatedClass(dbMigrationtableEntity.class);
                configuration.addAnnotatedClass(dbSalariestableEntity.class);

                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println("Исключение!" + e);
            }
        }
        return sessionFactory;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}