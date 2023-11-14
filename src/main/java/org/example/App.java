package org.example;

import org.example.model.Item;
import org.example.model.Passport;
import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import javax.security.auth.login.AppConfigurationEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Passport.class);

       SessionFactory sessionFactory= configuration.buildSessionFactory();
       Session Session = sessionFactory.getCurrentSession();

       try {

           Session.beginTransaction();

          /* Person person = new Person("Девлет", 35);
           //Item item = new Item("Гитара", person);

           person.addItem(new Item("Item1"));
           person.addItem(new Item("Item2"));
           person.addItem(new Item("Item3"));
           //person.setItems(new ArrayList<>(Collections.singletonList(item)));

          // Session.save(person); // тут вместо вызова метода save вызываем метот persist
           // session.persist(item)

            Session.save(person);*/
          /* Person person = new Person("Чувак", 25);
           Passport passport = new Passport(212037);
           person.setPassport(passport);

           Session.save(person);*/
           Person person = Session.get(Person.class,1);
           System.out.println(person.getPassport().getPassportNumber());

           Session.getTransaction().commit();

       }finally {
           sessionFactory.close(); //Обязательно нужно закрыть сессию
       }

    }
}
