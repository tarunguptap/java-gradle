package com.example.core.date.dateutil;

import java.util.Date;

import org.apache.commons.lang.time.DateUtils;

public class DateNullCompare {

    public static void main(String[] args) {
        Date currDate = new Date();
        Integer days = 0;
        Date endDate = DateUtils.addDays(currDate, days);
        if (currDate.compareTo(endDate) < 0) {
            System.out.println("Enddate is greated");
        } else {
            System.out.println("Enddate is lesser");
        }
        // Out Put : Enddate is lesser

        days = null;
        Date endDate1 = DateUtils.addDays(currDate, days);
        if (currDate.compareTo(endDate1) < 0) {
            System.out.println("Enddate is greated");
        } else {
            System.out.println("Enddate is lesser");
        }
    }

}
