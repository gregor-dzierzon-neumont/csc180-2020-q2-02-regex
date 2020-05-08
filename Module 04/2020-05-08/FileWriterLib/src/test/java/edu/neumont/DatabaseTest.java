package edu.neumont;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest
{


    @Test
    void should_serialze_and_deserialize()
    {
        Employee employee1 = new Employee("John", "Williams");
        Employee employee2 = new Employee("Judy", "Carter");
        Employee employee3 = new Employee("Garret", "Jones");

        List<ISerializable<Employee>> emps = new ArrayList<>();
        emps.add(employee1);
        emps.add(employee2);
        emps.add(employee3);

        Database<Employee> db = new Database<>();

        db.serialize("filedb.txt", emps);
        //the second argument here now passes the class as a type
        List<ISerializable<Employee>> e = db.deserialize("filedb.txt", Employee.class);

        assertEquals(3,e.size());
    }
}