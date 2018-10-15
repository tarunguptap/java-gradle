package com.example.core.date;

import java.util.Date;

public class NullCasting {

    public static void main(String[] args) {
        Object date = null;
        printDate((Date) date);
    }

    private static void printDate(Date date) {
        System.out.println("date is : " + date);
    }
}
