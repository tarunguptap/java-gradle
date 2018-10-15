package com.project;

import java.util.Calendar;
import java.util.Date;

public class AdjustedDate {
    public static void main(String[] args) {
        System.out.println(getAdjustedDate(40));
        System.out.println(getAdjustedDate(-40));
    }

    /**
     * @param daysToAdjust
     * @return Date
     */
    private static Date getAdjustedDate(int daysToAdjust) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, daysToAdjust);
        return calendar.getTime();
    }
}
