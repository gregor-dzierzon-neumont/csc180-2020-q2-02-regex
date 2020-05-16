package edu.neumont;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Employee implements ISerializable
{
    String firstName;
    String lastName;

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    String state;

    @Override
    public String toString()
    {
        return "{" +
                "\"firstName\":\"" + firstName + "\"" +
                ", \"lastName\":\"" + lastName + "\"" +
                ", \"state\":\"" + state + "\"" +
                "}";
    }

    //implement the ISerializable interface methods
    @Override
    public String serialize()
    {
        return this.toString();
    }

    @Override
    public void deserialize(String content)
    {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Employee obj = mapper.readValue(content, Employee.class);
            this.firstName = obj.firstName;
            this.lastName = obj.lastName;
            this.state = obj.state;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Employee()
    {}

    public Employee(String firstName, String lastName, String state)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.state = state;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
}
