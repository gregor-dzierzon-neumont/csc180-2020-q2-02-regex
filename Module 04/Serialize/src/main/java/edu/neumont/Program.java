package edu.neumont;

import edu.neumont.models.Address;
import edu.neumont.models.Employee;
import edu.neumont.models.Team;

import java.io.*;

public class Program {

    public static void main(String[] args)
    {
        Team team = new Team();
        System.out.println("\nSerializing...\n");
        Address address = new Address("123 Main St","SLC","UT","84111");
        Employee employee = new Employee("John", "Williams", address);

        team.add(employee);

        serialize("data.txt", employee);
        Employee returnVal = deserialize("data.txt");
        System.out.println(returnVal);
    }

    private static void serializeText(String filePath, Employee employee)
    {
        try {
            FileWriter fileOut = new FileWriter(filePath);
            BufferedWriter writer = new BufferedWriter(fileOut);
            writer.write(employee.toString());
            writer.flush();
            writer.close();
            fileOut.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print("Serialized: ");
    }

    private static void serialize(String filePath, Employee employee)
    {
        try {
            FileOutputStream fileOut = new FileOutputStream(filePath);
            ObjectOutputStream writer = new ObjectOutputStream(fileOut);
            writer.writeObject(employee);

            writer.flush();
            writer.close();
            fileOut.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print("Serialized: ");
    }

    private static Employee deserialize(String filePath)
    {
        System.out.println("\nDeserializing...\n");
        Employee employee = null;
        try {
            FileInputStream fileIn = new FileInputStream(filePath);
            ObjectInputStream reader = new ObjectInputStream(fileIn);
            employee = (Employee)reader.readObject();

            reader.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return employee;
    }

}
