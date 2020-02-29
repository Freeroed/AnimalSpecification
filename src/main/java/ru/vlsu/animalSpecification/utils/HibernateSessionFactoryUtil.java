package ru.vlsu.animalSpecification.utils;

import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import ru.vlsu.animalSpecification.domain.Region;

/*В этом классе мы создаем новый объект конфигураций Configuration, и передаем ему те
 классы, которые он должен воспринимать как сущности.
 Задача класса — создавать для нашего приложения фабрику сессий для работы с БД*/

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
                configuration.addAnnotatedClass(Region.class);
                // все setProperty добавлены хрен знает зачем
               configuration.setProperty("hibernate.connection.username", "root");
                configuration.setProperty("hibernate.connection.password", "root");
                configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");

                //configuration.addResource("hibernate/Region.hbm.xml");
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println("Исключение!" + e);
            }
        }
        return sessionFactory;
    }
}
