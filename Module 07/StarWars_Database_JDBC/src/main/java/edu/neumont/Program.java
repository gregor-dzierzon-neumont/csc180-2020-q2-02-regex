package edu.neumont;

import edu.neumont.api.PersonApi;
import edu.neumont.api.PlanetApi;
import edu.neumont.dao.PersonDao;

import javax.sound.midi.Soundbank;

public class Program {

    public static void main(String[] args)
    {
        Application app = new Application(new PersonApi(), new PlanetApi(), new PersonDao());
        app.run();

    }

}
