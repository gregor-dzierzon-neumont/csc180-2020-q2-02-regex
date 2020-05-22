package edu.neumont;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.neumont.dtos.Planet;

import java.io.IOException;
import java.util.List;

public class PlanetApi extends ApiBase<Planet>
{
    @Override
    public List<Planet> getAll()
    {
        return null;
    }

    @Override
    public List<Planet> getPage(String s)
    {
        return null;
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
