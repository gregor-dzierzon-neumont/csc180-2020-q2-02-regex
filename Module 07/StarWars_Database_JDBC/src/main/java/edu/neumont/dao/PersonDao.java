package edu.neumont.dao;

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
            Person person = mapPersonFromRow(rows);
            people.add(person);
        }

        return people;
    }

    private Person mapPersonFromRow(SqlRowSet rows)
    {
        Person person = new Person();
        //populate
        person.setUrl(rows.getString("url"));
        person.setName(rows.getString("name"));
        person.setHeight(rows.getString("height"));
        person.setMass(rows.getString("mass"));
        person.setHair_color(rows.getString("hair_color"));
        person.setSkin_color(rows.getString("skin_color"));
        person.setEye_color(rows.getString("eye_color"));
        person.setBirth_year(rows.getString("birth_year"));
        person.setGender(rows.getString("gender"));
        person.setHomeworld(rows.getString("homeworld"));
        person.setCreated(rows.getString("created"));
        person.setEdited(rows.getString("edited"));
        return person;
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
                "WHERE url = ?;";

        // query is now a prepared statement
        SqlRowSet rows = jdbcTemplate.queryForRowSet(query, id);

        if(rows.next()){
            person = mapPersonFromRow(rows);
        }

        return person;
    }

    @Override
    public void save(Person person)
    {
        //define the query
        String query = "INSERT INTO person( " +
                " url," +
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
                ") " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?); ";

        jdbcTemplate.update(query
                , person.getUrl()
                , person.getName()
                , person.getHeight()
                , person.getMass()
                , person.getHair_color()
                , person.getSkin_color()
                , person.getEye_color()
                , person.getBirth_year()
                , person.getGender()
                , person.getHomeworld()
                , person.getCreated()
                , person.getEdited()
        );
    }

    @Override
    public void update(String id, Person person)
    {
        // define the query
        // make sure that you update all required fields
        String query = "UPDATE person " +
                "SET name = ?," +
                " height = ? " +
                "WHERE url = ? ";

        jdbcTemplate.update(query,
                person.getName(),
                person.getHeight(),
                id);

    }

    @Override
    public void delete(String id)
    {
        //define the query
        String query = "DELETE FROM person " +
                "WHERE url = ?";

        jdbcTemplate.update(query, id);

    }
}
