package edu.neumont.api;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.neumont.dtos.Person;
import edu.neumont.api.models.PeopleResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonApi extends ApiBase<Person>
{
    private static final String url = baseUrl + "people/";


    @Override
    public List<Person> getAll()
    {
        List<Person> people = new ArrayList<>();
        try
        {
            String responseString = call(url);
            ObjectMapper mapper = new ObjectMapper();
            PeopleResponse response = mapper.readValue(responseString, PeopleResponse.class);
            Person[] peopleArray = response.getResults();
            people.addAll(Arrays.asList(peopleArray));

            while(response.getNext() != null)
            {
                responseString = call(response.getNext());
                response = mapper.readValue(responseString, PeopleResponse.class);
                peopleArray = response.getResults();
                people.addAll(Arrays.asList(peopleArray));
            }

        }
        catch (IOException | InterruptedException e)
        {
            e.printStackTrace();
        }

        return people;
    }

    @Override
    public List<Person> getPage(String page)
    {
        List<Person> people = new ArrayList<>();
        try
        {
            String responseString = call(page);
            ObjectMapper mapper = new ObjectMapper();
            PeopleResponse response = mapper.readValue(responseString, PeopleResponse.class);
            Person[] peopleArray = response.getResults();
            people.addAll(Arrays.asList(peopleArray));
        }
        catch (IOException | InterruptedException e)
        {
            e.printStackTrace();
        }

        return people;
    }

    @Override
    public Person get(String s)
    {
        Person person = null;
        try
        {
            String responseString = call(s);
            ObjectMapper mapper = new ObjectMapper();
            person = mapper.readValue(responseString, Person.class);
        }
        catch (IOException | InterruptedException e)
        {
            e.printStackTrace();
        }

        return person;
    }
}
