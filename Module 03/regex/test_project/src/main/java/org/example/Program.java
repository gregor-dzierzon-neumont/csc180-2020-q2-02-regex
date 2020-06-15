package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

public class Program {

    public static void main(String[] args) {

//        //test if string is a number
//        String pattern = "^\\d+$";
//        String userInput = "1232-4323";
//
//        // the String.matches(pattern) function validates the string
//        // against the regular expression
//        if(userInput.matches(pattern)){
//            System.out.println("Success");
//        }
//        else {
//            System.out.println("Failure");
//        }
        matchNumeric();
        matchWord();

    }

    public static void matchNumeric(){

        //must be numeric - starts and ends with at least one number
        String pattern = "^\\d+$";

        System.out.print("\n\nValidating: /");
        System.out.print(pattern);
        System.out.println("/");
        System.out.println("***************");

        List<String> values = new ArrayList<>();
        values.add("456");
        values.add("44-3");
        values.add("s6");
        values.add("9");
        values.add("172983");

        for (String value : values) {
            System.out.println(String.format("%s : %b", value, value.matches(pattern)));
        }
    }

    public static void matchWord(){

        //3 letter word that ends with _at
        String pattern = "^(.)at$";

        System.out.print("\n\nValidating: /");
        System.out.print(pattern);
        System.out.println("/");
        System.out.println("***************");

        List<String> values = new ArrayList<>();
        values.add("cat");
        values.add("hat");
        values.add("rat");
        values.add("that");
        values.add("chat");

        for (String value : values) {
            System.out.println(String.format("%s : %b", value, value.matches(pattern)));
        }
    }

}
