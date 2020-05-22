package edu.neumont.models;

import edu.neumont.dtos.Person;

public class PeopleResponse extends ResponseBase
{
    Person[] results;

    public Person[] getResults()
    {
        return results;
    }

    public void setResults(Person[] results)
    {
        this.results = results;
    }
}
