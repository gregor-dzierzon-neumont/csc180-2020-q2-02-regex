package edu.neumont;

public class Employee implements ISerializable<Employee>
{
    String firstName;
    String lastName;

    @Override
    public String toString()
    {
        return "{" +
                "\"firstName\":\"" + firstName + "\"" +
                ", \"lastName\":\"" + lastName + "\"" +
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
        Employee obj = new Employee();
        try {
            this.firstName = obj.firstName;
            this.lastName = obj.lastName;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Employee()
    {}

    public Employee(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
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
