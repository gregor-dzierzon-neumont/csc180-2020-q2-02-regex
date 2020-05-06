package edu.neumont.models;


public class Employee
{
    String firstName;
    String lastName;
    Address address;

    @Override
    public String toString()
    {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                '}';
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

    public Address getAddress()
    {
        return address;
    }

    public void setAddress(Address address)
    {
        this.address = address;
    }

    public Employee()
    {}


    public Employee(String firstName, String lastName, Address address)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }
}
