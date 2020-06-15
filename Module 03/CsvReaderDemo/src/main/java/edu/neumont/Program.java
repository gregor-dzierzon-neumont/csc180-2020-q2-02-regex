package edu.neumont;

import edu.neumont.models.RegExParser;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Program {
    private static final String namePattern = "\\w* \\w* \\w*|\\w* \\w*";
    private static final String phonePattern = "((\\d{3}-){2}\\d{4})";
    private static final String ssnPattern = "(\\d{3}-\\d{2}-\\d{4})";
    private static final String emailPattern = "([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})";

    public static void main(String[] args)
    {
        String one = "10";
        String two = "2";

        System.out.println(one.compareTo(two));
    }

    public static void run()
    {

        try {
            //get input from the user
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Welcome to my faux database");
            System.out.print("Enter a name to search (leave blank to show all): ");

            String searchName = console.readLine().trim().toLowerCase();


            //open file
            FileReader fileReader = new FileReader("people.to.regex.csv");
            BufferedReader reader = new BufferedReader(fileReader);

            String line = reader.readLine(); // skip[ the header row
            line = reader.readLine(); // get the first data row

            String format = "%-25s | %-15s | %-35s | %s";

            //header
            System.out.println(String.format(format, "Name", "Phone", "Email", "SSN"));

            //print dashed line for header
            for (int i = 0; i < 100; i++) {
                System.out.print("-");
            }
            System.out.println();


            while(line != null) {

                String name = RegExParser.parse(line, namePattern);

                if(searchName.equals("") || name.toLowerCase().contains(searchName)) {

                    String phone = RegExParser.parse(line, phonePattern);
                    String ssn = RegExParser.parse(line, ssnPattern);
                    String email = RegExParser.parse(line, emailPattern);

                    String formattedString = String.format(format, name, phone, email, ssn);

                    System.out.println(formattedString);
                }

                line = reader.readLine();
            }


            //loop through the lines
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
