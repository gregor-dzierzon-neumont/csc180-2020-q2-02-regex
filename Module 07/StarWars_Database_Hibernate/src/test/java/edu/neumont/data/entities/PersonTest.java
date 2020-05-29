package edu.neumont.data.entities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;

import java.io.ObjectInputFilter;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest
{

    @Test
    public void should_insert()
    {
        //arrange
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Person person = new Person("test123", "some name","123","444","brown","green","yellow","4ct19","male","https://test/api/planet/1/","1/1/2020","1/21/2020");

        //act
        session.save(person);
        session.getTransaction().commit();
        session.close();

        //assert
        assertTrue(true);
    }


}