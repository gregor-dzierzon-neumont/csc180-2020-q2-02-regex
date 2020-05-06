package edu.neumont;

import edu.neumont.models.Circle;
import edu.neumont.models.Shape;
import edu.neumont.models.Square;

import java.util.ArrayList;
import java.util.List;

public class Program {

    public static void main(String[] args)
    {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle());
        shapes.add(new Circle());
        shapes.add(new Circle());

        displayItems(shapes);
    }

    public static void displayItems(List<Shape> items)
    {
        for(Shape item: items){
            System.out.println(item);
        }
    }
}
