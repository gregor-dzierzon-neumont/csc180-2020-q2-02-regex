package edu.neumont;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.neumont.models.Person;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo
{

    public static void main(String[] args) throws IOException
    {
        Person person = new Person();
        person.setName("John Doe");
        person.setSsn("555-111-1234");
        person.setEmail("john.doe@email.com");
        person.setStreet("123 Main Street");
        person.setCity("Salt Lake City");
        person.setState("UT");
        person.setZip("84111");

        boolean livesInUtah = isUtahn(person);

        System.out.println(livesInUtah);

    }

    public static boolean isUtahn(Person person)
    {
        return person.getState().equals("UT");
    }

}
