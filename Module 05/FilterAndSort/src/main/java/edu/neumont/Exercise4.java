package edu.neumont;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.neumont.models.Person;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class Exercise4
{

    public static void main(String[] args) throws IOException
    {
        ObjectMapper mapper = new ObjectMapper();

        URL url;
        url = new URL("file:lambda.people.json");
        Person[] peopleArray = mapper.readValue(url, Person[].class);
        List<Person> people = new ArrayList<>(Arrays.asList(peopleArray));

        Map<String, Person> peopleMap = new HashMap<>();
        for(Person person : people){
            peopleMap.put(person.getSsn(), person);
        }
    }

}
