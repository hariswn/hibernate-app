package com.tekicons.config;

import com.tekicons.entity.Account;
import com.tekicons.entity.onetomany.Course;
import com.tekicons.entity.onetomany.TrainingCenter;
import com.tekicons.entity.onetoone.Instructor;
import com.tekicons.entity.onetoone.InstructorDetail;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateConfig {

    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/mydb?useSSL=false");
                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, "Harry@12345");
                settings.put(Environment.SHOW_SQL, "true");

                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                /*validate: validate the schema, makes no changes to the database.
                create-only: database creation will be generated.
                drop: database dropping will be generated.
                update: update the schema.
                create: creates the schema, destroying previous data.
                create-drop: drop the schema when the SessionFactory is closed explicitly, typically when the application is stopped.
                none: does nothing with the schema, makes no changes to the database*/

                settings.put(Environment.HBM2DDL_AUTO, "update");

                configuration.setProperties(settings);

                configuration.addAnnotatedClass(Account.class);
                configuration.addAnnotatedClass(Instructor.class);
                configuration.addAnnotatedClass(InstructorDetail.class);
                configuration.addAnnotatedClass(TrainingCenter.class);
                configuration.addAnnotatedClass(Course.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
