package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExProgram
{

    public static void main(String[] args)
    {
        parseCsv2();
    }

    public static void parseDates()
    {

        String str = "John was hired on 4/13/2012. His annual review is due by 4/18/2020";

        String datePattern = "(\\d{1,2}/\\d{1,2}/\\d{4})";

        Pattern regex = Pattern.compile(datePattern);
        Matcher matches = regex.matcher(str);

        while (matches.find()) {
            System.out.println(matches.group());
        }
    }

    public static void parseCsv1()
    {

        String str = "John Jones,4/13/2012";

        String namePattern = "(\\w*) (\\w*)";
        String datePattern = "(\\d{1,2}/\\d{1,2}/\\d{4})";


        //find name
        Pattern regex = Pattern.compile(namePattern);
        Matcher matches = regex.matcher(str);
        if (matches.find()) {
            System.out.print("Name: ");
            System.out.println(matches.group());
        }

        //find date
        regex = Pattern.compile(datePattern);
        matches = regex.matcher(str);
        if (matches.find()) {
            System.out.print("Hire Date: ");
            System.out.println(matches.group());
        }


    }

    public static void parseCsv2()
    {

        String str = "John Jones,4/13/2012";

        String namePattern = "(\\w*) (\\w*)";
        String datePattern = "(\\d{1,2}\\/\\d{1,2}\\/\\d{4})";

        String allPatterns = String.format("%s|%s", namePattern, datePattern);

        Pattern regex = Pattern.compile(allPatterns);
        Matcher matches = regex.matcher(str);

        while (matches.find()) {
            System.out.println(matches.group());
        }

    }
}
