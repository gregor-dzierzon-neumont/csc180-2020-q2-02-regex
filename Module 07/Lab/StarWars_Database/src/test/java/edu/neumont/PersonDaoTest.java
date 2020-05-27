package edu.neumont;

import edu.neumont.dtos.Person;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonDaoTest
{

    @Test
    void should_get_all_people()
    {
        //arrange
        PersonDao dao = new PersonDao();
        List<Person> people = null;

        //act
        people = dao.get();

        //assert
        assertNotNull(people);
        assertEquals(1, people.size());
        Person person = people.get(0);
        assertEquals("John Doe", person.getName());

    }

    @Test
    void get()
    {
        //arrange
        PersonDao dao = new PersonDao();
        Person person = null;

        //act
        person = dao.get("http://mysite.com/people/1/");

        //assert
        assertNotNull(person);
        assertEquals("John Doe", person.getName());
    }
}