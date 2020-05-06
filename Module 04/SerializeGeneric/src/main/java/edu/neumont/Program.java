package edu.neumont;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.neumont.models.Address;
import edu.neumont.models.Employee;
import edu.neumont.models.Team;

import java.io.*;
import java.util.List;

public class Program {

    public static void main(String[] args)
    {
        Team team = new Team();
        System.out.println("\nSerializing...\n");
        Address address = new Address("123 Main St","SLC","UT","84111");
        Employee employee = new Employee("John", "Williams", address);

        team.add(employee);
        team.add(employee);
        team.add(employee);

        serialize("data.json", team);
        Team returnVal = deserialize("data.json", Team.class);
        System.out.println(returnVal);
    }

    private static <T> void serialize(String filePath, T target)
    {
        try {
            FileOutputStream fileOut = new FileOutputStream(filePath);
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(fileOut, target);
            fileOut.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print("Serialized: ");
        System.out.println(target);
    }

    private static <T> T deserialize(String filePath, Class<?> target)
    {
        System.out.println("\nDeserializing...\n");
        T obj = null;
        try {
            FileInputStream fileIn = new FileInputStream(filePath);
            ObjectMapper mapper = new ObjectMapper();
            JavaType type = mapper.getTypeFactory().constructType(Class.forName(target.getName()));
            obj = mapper.readValue(fileIn, type);
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
