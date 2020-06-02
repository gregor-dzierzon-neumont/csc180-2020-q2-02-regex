package edu.neumont.dao;

import edu.neumont.models.Customer;
import edu.neumont.models.Order;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class OrdersDao extends DaoBase
{
    public List<Order> getOrdersByCustomerId(int id)
    {

        List<Order> orders = new ArrayList<>();

        String query = "SELECT orderid " +
                " , customerid " +
                " , orderdate " +
                "FROM orders " +
                "WHERE customerid = ?";

        SqlRowSet rows = jdbcTemplate.queryForRowSet(query, id);

        while(rows.next())
        {
            Order order = new Order();

            order.setOrderId(rows.getInt("orderid"));
            order.setCustomerId(rows.getInt("customerid"));
            order.setOrderDate(rows.getDate("orderdate"));

            orders.add(order);
        }

        return orders;
    }
}
