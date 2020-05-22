package edu.neumont;

import edu.neumont.dtos.Person;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonApiTest
{

    @Test
    void getAll()
    {
        //arrange
        PersonApi api = new PersonApi();

        //act
        List<Person> people = api.getAll();

        //assert
        assertEquals(82,people.size());
    }

    @Test
    void getPage()
    {
        //arange
        PersonApi api = new PersonApi();

        //act
        List<Person> people = api.getPage("https://swapi.dev/api/people/?page=3");

        //assert
        assertEquals(10,people.size());
    }

    @Test
    void get()
    {
        //arange
        PersonApi api = new PersonApi();

        //act
        Person person = api.get("https://swapi.dev/api/people/1/");

        //assert
        assertEquals("Luke Skywalker", person.getName());
    }
}