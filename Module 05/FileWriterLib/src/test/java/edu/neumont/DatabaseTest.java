package edu.neumont;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest
{
    private static final String tempFilePath = "tempfiledb.txt";
    private static final String filePath = "filedb.txt";


    @BeforeEach
    void setup()
    {
        File file = new File(tempFilePath);
        if(file.exists())
        {
            file.delete();
        }
    }

    private List<Employee> getEmployees()
    {
        List<Employee> emps = new ArrayList<>();
        emps.add(new Employee("John", "Williams", "UT"));
        emps.add(new Employee("Judy", "Carter", "CA"));
        emps.add(new Employee("Walter", "Andrews", "NV"));
        emps.add(new Employee("Garret", "Jones", "UT"));
        emps.add(new Employee("Zoe", "Smithson", "NY"));

        return emps;
    }

    private void createFile(String file)
    {
        List<Employee> emps = getEmployees();

        Database<Employee> db = new Database<>(file,Employee.class);
        db.add(emps);

        db.save();
    }

    @AfterEach
    void cleanup()
    {
        File tempFile = new File(tempFilePath);
        if(tempFile.exists())
        {
            tempFile.delete();
        }

        File file = new File(filePath);
        if(file.exists())
        {
            file.delete();
        }
    }


    @Test
    void should_serialze()
    {
        //arrange
        List<Employee> emps = getEmployees();

        Database<Employee> db = new Database<>(tempFilePath,Employee.class);
        db.add(emps);

        //act
        db.save();
        File file = new File(tempFilePath);
        //assert
        assertTrue(file.exists());
    }

    @Test
    void should_deserialze()
    {
        //arrange
        createFile(filePath);

        //act
        Database<Employee> db = new Database<>(filePath,Employee.class);
        List<Employee> emps = db.get();

        //assert
        assertEquals(5, emps.size());
    }

    @Test
    void should_search_for_john()
    {
        //arrange
        createFile(filePath);
        Database<Employee> db = new Database<>(filePath,Employee.class);

        //act
        List<Employee> emps = db.search(e -> e.firstName.toLowerCase().equals("john"));

        //assert
        assertEquals(1, emps.size());
    }

    @Test
    void should_search_for_john_and_judy()
    {
        //arrange
        createFile(filePath);
        Database<Employee> db = new Database<>(filePath, Employee.class);
        Predicate<Employee> john = e -> e.firstName.toLowerCase().equals("john");
        Predicate<Employee> judy = e -> e.firstName.toLowerCase().equals("judy");

        //act
        List<Employee> emps = db.search(john.or(judy));

        //assert
        assertEquals(2, emps.size());
    }

    @Test
    void should_search_for_utah()
    {
        //arrange
        createFile(filePath);
        Database<Employee> db = new Database<>(filePath,Employee.class);
        Predicate<Employee> utah = e -> e.state.equals("UT");

        //act
        List<Employee> emps = db.search(utah);

        //assert
        assertEquals(2, emps.size());
    }

}