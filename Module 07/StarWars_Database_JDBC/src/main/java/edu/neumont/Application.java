package edu.neumont;

import edu.neumont.dtos.Person;
import edu.neumont.dtos.Planet;
import edu.neumont.interfaces.IApi;
import edu.neumont.interfaces.IRepository;

import javax.naming.InsufficientResourcesException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Application
{
    IApi<Person> personApi;
    IApi<Planet> planetApi;

    IRepository<Person> personRepo;

    Scanner scanner;

    public Application(IApi<Person> personApi,
                       IApi<Planet> planetApi,
                       IRepository<Person> personRepo)
    {
        this.personApi = personApi;
        this.planetApi = planetApi;

        this.personRepo = personRepo;

        scanner = new Scanner(System.in);
    }

    public void run()
    {
        displayPeople();
    }

    public void displayPeople()
    {

        System.out.println("Getting characters from the API...\n");
        List<Person> people = personApi.getAll();
        for(Person person : people)
        {
            // add each person to the database
            personRepo.save(person);

            //System.out.printf("%s \t%s \n",person.getId(), person.getName());
        }

        System.out.println("All people added to the database.");
//
//        System.out.println();
//        System.out.print("Select and id to display more info: ");
//        String id = scanner.nextLine();
//
//        Optional<Person> person = people.stream()
//                .filter(p -> p.getId().equals(id))
//                .findFirst();
//
//        if(person.isPresent())
//        {
//
//            System.out.println();
//            System.out.printf("Name: %s \n",person.get().getName());
//            System.out.printf("Height: %s \n",person.get().getHeight());
//
//            Planet planet = planetApi.get(person.get().getHomeworld());
//
//            System.out.printf("Home Planet: %s \n",planet.getName());
//
//
//        }
    }
}
