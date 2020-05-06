package edu.neumont.models;

import java.util.ArrayList;
import java.util.List;

public class Team
{
    List<Employee> employees = new ArrayList<>();

    public List<Employee> getEmployees()
    {
        return employees;
    }

    public void setEmployees(List<Employee> employees)
    {
        this.employees = employees;
    }

    public void add(Employee e)
    {
        employees.add(e);
    }

    @Override
    public String toString()
    {
        return "Team{" +
                "employees=" + employees +
                '}';
    }
}
