package edu.neumont.dao;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class CustomerDao extends DaoBase
{
    public void GetCustomerOrders()
    {
        String query = "";

        SqlRowSet rows = jdbcTemplate.queryForRowSet(query);

        while(rows.next())
        {
            // do something with the row
        }
    }
}
