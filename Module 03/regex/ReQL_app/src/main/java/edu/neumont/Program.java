package edu.neumont;

import edu.neumont.views.BuildQuery;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Program {
    private static Scanner console;

    public static void main(String[] args) throws IOException {

        BuildQuery qb;
        console = new Scanner(System.in);

        qb = new BuildQuery("Please define the table structure: ");
        String createString = qb.display();
        System.out.println();
        System.out.println("The table has been created. >>>");
        System.out.println(createString);
        System.out.println();

        qb = new BuildQuery("Please define the SELECT statement: ");
        String selectString = qb.display();
        System.out.println();
        System.out.println("The following query will be executed: ");
        System.out.println(selectString);
        System.out.println();

        System.out.println("//Display results of the query here.");

    }

}
