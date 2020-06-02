package edu.neumont.dao;

import edu.neumont.models.Customer;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class CustomerDao extends DaoBase
{
    public Customer GetCustomer(int id)
    {
        Customer customer = null;

        String query = "SELECT customerid " +
                " , companyname " +
                "FROM customers " +
                "WHERE customerid = ?";

        SqlRowSet rows = jdbcTemplate.queryForRowSet(query, id);

        if(rows.next())
        {
            customer = new Customer();
            customer.setCustomerId(rows.getInt("customerid"));
            customer.setCompanyName(rows.getString("companyname"));
        }

        return customer;
    }
}
