package edu.neumont.api.models;

import edu.neumont.dtos.Planet;

public class PlanetResponse extends ResponseBase
{
    Planet[] results;

    public Planet[] getResults()
    {
        return results;
    }

    public void setResults(Planet[] results)
    {
        this.results = results;
    }
}
