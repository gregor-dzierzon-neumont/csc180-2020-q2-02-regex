package edu.neumont.cs180.dzierzon.gregor;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Program {

    public static void main(String[] args) throws IOException {


        List<Course> courses = new ArrayList<Course>();
        courses.add(new Course(12, "Java"));
        courses.add(new Course(34, "C#"));

        Person person = new Person();
        person.setId(1);
        person.setFirstName("Johnny");
        person.setLastName("Student");
        person.setCourses(courses);

        OutputStream outputStream       = new FileOutputStream("testfile.html");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);

        outputStreamWriter.write("<!DOCTYPE html>");
        outputStreamWriter.write("<html><body>");

        outputStreamWriter.write(String.format("<h3>(%d) %s %s</h3>", person.getId(), person.getFirstName(), person.getLastName()));

//        outputStreamWriter.write("<table>");
//        for (Course course:person.getCourses()) {
//            // write each row here
//
//        }
//        outputStreamWriter.write("</table>");

        outputStreamWriter.write("</body></html>");

        outputStreamWriter.close();

    }
}
