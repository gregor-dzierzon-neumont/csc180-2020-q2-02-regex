package edu.neumont;

import edu.neumont.models.Employee;

import java.util.ArrayList;
import java.util.List;

public class Program {

    public static void main(String[] args)
    {

        //create the objects to store
        Employee employee1 = new Employee("John", "Williams", "123 Main Street", "SLC","UT","84111");
        Employee employee2 = new Employee("Judy", "Carter", "72 Hilltop Way", "Murray","UT","84014");
        Employee employee3 = new Employee("Garret", "Jones", "11715 Park Lane", "Sandy","UT","84092");

        List<ISerializable<Employee>> emps = new ArrayList<>();
        emps.add(employee1);
        emps.add(employee2);
        emps.add(employee3);


        //create the file database object
        Database<Employee> db = new Database<>();

        //serialize the objects
        db.serialize("filedb.txt", emps);

        //deserialize the objects
        //the second argument here now passes the class as a type
        List<ISerializable<Employee>> employees = db.deserialize("filedb.txt", Employee.class);

        //prove that the deserialization worked
        for(ISerializable<Employee> employee: employees)
        {
            Employee emp = (Employee)employee;
            System.out.println(emp.getFirstName());
        }
    }

}
