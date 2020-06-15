package edu.neumont.models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExParser
{
    public static String parse(String line, String pattern)
    {
        String value = null;

        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(line);

        if(matcher.find()){
            value = matcher.group();
        }

        return value;
    }
}
