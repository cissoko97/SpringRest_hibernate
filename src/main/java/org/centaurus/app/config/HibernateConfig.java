package org.centaurus.app.config;

import org.centaurus.app.models.Comment;
import org.centaurus.app.models.Person;
import org.centaurus.app.models.Student;
import org.centaurus.app.models.trader.Article;
import org.centaurus.app.models.trader.Category;
import org.centaurus.app.models.trader.Fournisseur;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateConfig {

    private SessionFactory sessionFactory;

    public HibernateConfig() {
        configure();
        createSessionFactory();
    }

    private Configuration configure() {
        Configuration configuration = new Configuration();

        //configuration de la persistance pour la base de donnée réel!!!
        /*configuration
                .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
                .setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver")
                .setProperty("hibernate.connection.url", "jdbc:mysql://127.0.0.1:3306/enterprise")
                .setProperty("hibernate.connection.username", "root")
                .setProperty("hibernate.connection.password", "")
                .setProperty("hibernate.hbm2ddl.auto", "update")
                .setProperty("hibernate.show_sql","true")
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Comment.class)
                .addAnnotatedClass(Branche.class);*/

        //Configuration de la persistance dans la BD embarqué
                /*.addAnnotatedClass(Person.class)
                .addAnnotatedClass(Comment.class)
                .addAnnotatedClass(Student.class)*/
        configuration
                .setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect")
                .setProperty("hibernate.connection.driver_class", "org.h2.Driver")
                .setProperty("hibernate.connection.url", "jdbc:h2:./TestBD;INIT=CREATE SCHEMA IF NOT EXISTS testBD")
                .setProperty("hibernate.hbm2ddl.auto", "update")
                .setProperty("hibernate.default_schema", "testBD")
                .setProperty("hibernate.show_sql", "true")
                .setProperty("hibernate.connection.username", "root")
                .setProperty("hibernate.connection.password", "")
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Comment.class)
                .addAnnotatedClass(Student.class);

        return configuration;
    }

    private SessionFactory createSessionFactory() {
        return this.sessionFactory = configure().buildSessionFactory();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
