package edu.neumont.controllers;

import edu.neumont.dao.CustomerDao;
import edu.neumont.dao.OrdersDao;
import edu.neumont.models.Customer;
import edu.neumont.models.Order;

public class CustomerController
{
    public void customerDetails(int id)
    {
        //create DAOs
        CustomerDao db = new CustomerDao();
        OrdersDao orderDb = new OrdersDao();

        //get customer
        Customer customer = db.GetCustomer(id);
        customer.setOrders(orderDb.getOrdersByCustomerId(id));

        //create the view and have it display the customer
        System.out.println(customer.getCustomerId());
        System.out.println(customer.getCompanyName());
        System.out.println("------");

        for(Order order : customer.getOrders()) {
            System.out.println(order.getOrderDate());
        }

    }
}
