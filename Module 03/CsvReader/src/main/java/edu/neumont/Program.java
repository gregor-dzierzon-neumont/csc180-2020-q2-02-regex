package edu.neumont;

import edu.neumont.models.RegExParser;

import java.io.*;

public class Program {
    private static final String namePattern = "(\\w*) (\\w*)";
    private static final String phonePattern = "((\\d{3}-){2}\\d{4})";
    private static final String ssnPattern = "(\\d{3}-\\d{2}-\\d{4})";
    private static final String emailPattern = "([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})";

    public static void main(String[] args) {

        try{
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Welcome");
            System.out.println();

            System.out.print("Enter a name to search: ");
            String searchName = console.readLine().toLowerCase();


            FileReader reader = new FileReader("./people.to.regex.csv");

            BufferedReader br = new BufferedReader(reader);

            String line = br.readLine();//skip line headings
            line = br.readLine();
            while( line != null)
            {
                String name = RegExParser.parse(line, namePattern);
                String ssn = RegExParser.parse(line, ssnPattern);
                String phone = RegExParser.parse(line, phonePattern);
                String email = RegExParser.parse(line, emailPattern);

                if(searchName == "" || name.toLowerCase().contains(searchName)) {
                    String formattedLine = String.format("%-20s %-15s %-35s %-15s", name, phone, email, ssn);
                    System.out.println(formattedLine);
                }

                line = br.readLine();
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
