package edu.neumont;

import edu.neumont.controllers.CustomerController;

import java.util.Scanner;

public class Program {

    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);
        // display some options
        CustomerController controller = new CustomerController();

        System.out.print("Enter a customer id: ");
        int id = console.nextInt();

        controller.customerDetails(id);
    }

}
