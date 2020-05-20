package edu.neumont;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.neumont.models.Person;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class Exercise4
{

    public static void main(String[] args) throws IOException
    {
        ObjectMapper mapper = new ObjectMapper();

        URL url;
        url = new URL("file:lambda.people.json");
        Person[] peopleArray = mapper.readValue(url, Person[].class);
        List<Person> people = new ArrayList<>(Arrays.asList(peopleArray));

        // requirement 1 - List of all SSNs
        List<String> ssns = people.stream()
                .map(Person::getSsn)
                .sorted((s1, s2) -> s1.compareTo(s2))
                .collect(Collectors.toList());
//
//        for(String ssn : ssns)
//        {
//            System.out.println(ssn);
//        }

//        Map<String, Person> peopleMap = new HashMap<>();
//        for(Person person : people){
//            if(person.getState().equals("GA"))
//                peopleMap.put(person.getSsn(), person);
//        }


        //toMap - Key and value
        Map<String, Person> peopleMap = people.stream()
                .filter(person -> person.getState().equals("GA"))
                .sorted(Comparator.comparing(Person::getSsn))
                .collect(Collectors.toMap(
                        person -> person.getSsn(),
                        person -> person,
                        (firstPerson, secondPerson) -> firstPerson,
                        TreeMap::new
                ));
//
//        for(Map.Entry<String, Person> kvp: peopleMap.entrySet())
//        {
//            Person person = kvp.getValue();
//            System.out.println(kvp.getKey() + ": " + person.getName() + " - " + person.getState());
//        }


        //requirement 3 reduce the content into a single value
        List<Integer> phones = people.stream()
            .filter(person -> person.getState().equals("UT"))
            .map(person -> Integer.parseInt(person.getPhone().substring(8,12)))
            .collect(Collectors.toList());

//        // replacing the regular loop
//        int total = 0;
//        for(Integer phone : phones)
//        {
//            total += phone;
//        }
//
//        System.out.println(total);
//        System.out.println(total/phones.size());

        //reduce using SUM
        Optional<Integer> reduceTotal = phones.stream()
                    .reduce((one, two) -> one + two) ;

//        if(reduceTotal.isEmpty())
//        {
//            System.out.println("No numbers to reduce");
//        }
//        else
//        {
//            System.out.println(reduceTotal.get());
//            System.out.println(reduceTotal.get()/ phones.size());
//        }
//
//        //reduce to csv using concatenation
//        Optional<String> csv = phones.stream()
//                .map(Object::toString)
//                .reduce((one, two) -> one + ", " + two);
//
//        System.out.println(csv.get());

        people.stream()
                .filter(person -> person.getName().toLowerCase().contains("l"))
                .forEach(person -> System.out.printf("%s,%s,%s,%s \n",person.getName(), person.getSsn(), person.getEmail(), person.getState()));

    }

}
