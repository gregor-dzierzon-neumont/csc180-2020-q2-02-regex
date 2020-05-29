package edu.neumont.api;

import edu.neumont.dtos.Planet;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlanetApiTest
{

    @Test
    void getAll()
    {
        //arrange
        PlanetApi api = new PlanetApi();

        //act
        List<Planet> planets = api.getAll();

        //assert
        assertEquals(60,planets.size());
    }

    @Test
    void getPage()
    {
        //arrange
        PlanetApi api = new PlanetApi();

        //act
        List<Planet> planets = api.getPage("https://swapi.dev/api/planets/?page=3");

        //assert
        assertEquals(10,planets.size());
    }

    @Test
    void get()
    {

        //arange
        PlanetApi api = new PlanetApi();

        //act
        Planet planet = api.get("https://swapi.dev/api/planets/53/");

        //assert
        assertEquals("Concord Dawn", planet.getName());
    }

}