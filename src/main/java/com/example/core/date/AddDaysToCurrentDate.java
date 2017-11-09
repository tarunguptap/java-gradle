package com.example.core.date;

import java.util.Calendar;
import java.util.Date;

public class AddDaysToCurrentDate {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, 30);
        Date expiredDate = c.getTime();
        System.out.println(expiredDate);

    }
}
