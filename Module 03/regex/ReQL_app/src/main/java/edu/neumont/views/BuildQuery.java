package edu.neumont.views;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BuildQuery {

    private String message;

    public BuildQuery(String message) {
        this.message = message;
    }

    public String display() throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(message);
        System.out.println();

        StringBuilder builder = new StringBuilder();
        boolean complete = false;

        while(!complete){
            System.out.print("> ");
            String line = console.readLine();
            builder.append(line + " ");
            if(line.endsWith(";")){
                complete = true;
            }
        }

        return builder.toString();
    }
}
