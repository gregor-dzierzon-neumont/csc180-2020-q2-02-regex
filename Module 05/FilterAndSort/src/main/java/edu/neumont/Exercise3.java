package edu.neumont;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.neumont.models.Person;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Exercise3
{

    public static void main(String[] args) throws IOException
    {
        ObjectMapper mapper = new ObjectMapper();

        URL url;
        url = new URL("file:lambda.people.json");
        Person[] peopleArray = mapper.readValue(url, Person[].class);
        List<Person> people = new ArrayList<>(Arrays.asList(peopleArray));

        List<Person> floridians = new ArrayList<>();
        for(Person person : people){
            if(person.getState().equals("FL")){
                floridians.add(person);
            }
        }
    }

}
