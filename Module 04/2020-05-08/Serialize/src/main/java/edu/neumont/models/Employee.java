package edu.neumont.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.neumont.ISerializable;

import java.io.IOException;

public class Employee implements ISerializable<Employee>
{
    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    String zip;

    @Override
    public String toString()
    {
        return "{" +
                "\"firstName\":\"" + firstName + "\"" +
                ", \"lastName\":\"" + lastName + "\"" +
                ", \"address\":\"" + address + "\"" +
                ", \"city\":\"" + city + "\"" +
                ", \"state\":\"" + state + "\"" +
                ", \"zip\":\"" + zip + "\"" +
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
        Employee obj;
        try {
            ObjectMapper mapper = new ObjectMapper();
            obj = mapper.readValue(content, Employee.class);
            this.firstName = obj.firstName;
            this.lastName = obj.lastName;
            this.address = obj.address;
            this.city   = obj.city;
            this.state = obj.state;
            this.zip = obj.zip;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Employee()
    {}

    public Employee(String firstName, String lastName, String address, String city, String state, String zip)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
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

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getZip()
    {
        return zip;
    }

    public void setZip(String zip)
    {
        this.zip = zip;
    }
}
