package edu.neumont;

import edu.neumont.dtos.Person;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class PersonDao extends DaoBase<Person>
{

    @Override
    public List<Person> get()
    {
        List<Person> people = new ArrayList<>();

        String query = "SELECT url," +
                " name," +
                " height, " +
                " mass, " +
                " hair_color, " +
                " skin_color, " +
                " eye_color, " +
                " birth_year, " +
                " gender, " +
                " homeworld, " +
                " created, " +
                " edited " +
                "FROM person;";

        SqlRowSet rows = jdbcTemplate.queryForRowSet(query);

        while(rows.next()){
            Person person = new Person();
            //populate
            person.setUrl(rows.getString(1));
            person.setName(rows.getString(2));

            people.add(person);
        }

        return people;
    }

    @Override
    public Person get(String id)
    {
        Person person = null;

        //define the query
        String query = "SELECT url," +
                " name," +
                " height, " +
                " mass, " +
                " hair_color, " +
                " skin_color, " +
                " eye_color, " +
                " birth_year, " +
                " gender, " +
                " homeworld, " +
                " created, " +
                " edited " +
                "FROM person " +
                "WHERE url = '" + id + "';";

        SqlRowSet rows = jdbcTemplate.queryForRowSet(query);

        if(rows.next()){
            person = new Person();
            //populate
            person.setUrl(rows.getString(1));
            person.setName(rows.getString(2));
        }

        return person;
    }

    @Override
    public void save(Person person)
    {


    }

    @Override
    public void update(String s, Person person)
    {

    }

    @Override
    public void delete(String s)
    {

    }
}
