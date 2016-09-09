package com.example.datetime;

import java.util.Calendar;
import java.util.Date;

public class CalendarDemo {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, 5);
        Date expiredDate = c.getTime();
        System.out.println(expiredDate);
        System.out.println(new Date());
        
        if (new Date().compareTo(c.getTime()) >= 0) {
            System.out.println("current date is greater");
        } else {
            System.out.println("current date is lesser");
        }
    }
}
