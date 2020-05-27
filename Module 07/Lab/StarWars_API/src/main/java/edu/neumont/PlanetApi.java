package edu.neumont;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.neumont.dtos.Person;
import edu.neumont.dtos.Planet;
import edu.neumont.models.PeopleResponse;
import edu.neumont.models.PlanetResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlanetApi extends ApiBase<Planet>
{
    private static final String url = baseUrl + "planets/";

    @Override
    public List<Planet> getAll()
    {
        List<Planet> planets = new ArrayList<>();
        try
        {
            String responseString = call(url);
            ObjectMapper mapper = new ObjectMapper();
            PlanetResponse response = mapper.readValue(responseString, PlanetResponse.class);
            Planet[] planetArray = response.getResults();
            planets.addAll(Arrays.asList(planetArray));

            while(response.getNext() != null)
            {
                responseString = call(response.getNext());
                response = mapper.readValue(responseString, PlanetResponse.class);
                planetArray = response.getResults();
                planets.addAll(Arrays.asList(planetArray));
            }

        }
        catch (IOException | InterruptedException e)
        {
            e.printStackTrace();
        }

        return planets;
    }

    @Override
    public List<Planet> getPage(String page)
    {
        List<Planet> planets = new ArrayList<>();
        try
        {
            String responseString = call(page);
            ObjectMapper mapper = new ObjectMapper();
            PlanetResponse response = mapper.readValue(responseString, PlanetResponse.class);
            Planet[] planetArray = response.getResults();
            planets.addAll(Arrays.asList(planetArray));

        }
        catch (IOException | InterruptedException e)
        {
            e.printStackTrace();
        }

        return planets;
    }

    @Override
    public Planet get(String planetUrl)
    {
        Planet planet = null;

        try
        {
            String planetResponse = call(planetUrl);
            ObjectMapper mapper = new ObjectMapper();
            planet = mapper.readValue(planetResponse, Planet.class);

        }
        catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return planet;
    }
}
