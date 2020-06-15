package edu.neumont.models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExParser {


    public static String parse(String line, String pattern){

        String match = null;

        //find pattern
        Pattern regex = Pattern.compile(pattern);
        Matcher matches = regex.matcher(line);

        if (matches.find()) {
            match = matches.group();
        }

        return match;
    }
}
