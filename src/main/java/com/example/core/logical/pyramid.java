package com.example.core.logical;

public class pyramid {

    public static void main(String[] args) {
        asteriskPyramid(6);
    }

    // http://www.c-sharpcorner.com/blogs/creating-pyramid-in-c-sharp1
    private static void asteriskPyramid(int numberOfLayer) {
        int numberoflayer = 6, Space, Number;
        System.out.println("Print paramid");
        for (int i = 1; i <= numberoflayer; i++) {// Total number of layer for pramid
            for (Space = 1; Space <= (numberoflayer - i); Space++)
                // Loop For Space
                System.out.print(" ");
            for (Number = 1; Number <= i; Number++)
                // increase the value
                System.out.print("*");
            for (Number = (i - 1); Number >= 1; Number--)
                // decrease the value
                System.out.print("*");
            System.out.println();
        }
    }
}
