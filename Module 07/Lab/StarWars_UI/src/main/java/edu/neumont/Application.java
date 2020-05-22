package edu.neumont;

import edu.neumont.dtos.Person;
import edu.neumont.interfaces.IApi;

import java.util.List;

public class Application
{
    IApi<Person> api;

    public Application(IApi<Person> api)
    {
        this.api = api;
    }

    public void run()
    {
        displayPeople();
    }

    public void displayPeople()
    {
        List<Person> people = api.getAll();
        for(Person person : people)
        {
            System.out.printf("%s \t%s \n",person.getId(), person.getName());
        }
    }
}
