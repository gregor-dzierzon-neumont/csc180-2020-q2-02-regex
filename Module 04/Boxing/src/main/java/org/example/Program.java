package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Program {

    public static void main(String[] args)
    {
        List<String> names = new ArrayList<>();
        Map<Integer, String> items = new HashMap<>();

        Pair<Integer> pair = new Pair<>(5, 6);
        System.out.println(String.format("left %s : right %s", pair.getLeft(), pair.getRight()));

        pair.swap();
        System.out.println(String.format("left %s : right %s", pair.getLeft(), pair.getRight()));

        int i = 5;

        Integer j = i;

        int k = j.intValue();

        int x = 4;
        int y = 3;
        Box z = new Box();

        int answer = divide(x, y, z);

        System.out.println(answer);
        System.out.println(z.getValue());


    }
//
//    public static int divide(int dividend, int divisor, int remainder) {
//        remainder = dividend % divisor;
//        return dividend / divisor;
//    }
////
    public static int divide(int dividend, int divisor, Box remainderBox) {
        remainderBox.setValue(dividend % divisor);
        return dividend / divisor;
    }

}
