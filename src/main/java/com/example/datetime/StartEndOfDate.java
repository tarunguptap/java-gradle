package com.example.datetime;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;

public class StartEndOfDate {
    public static void main(String[] args) {
        System.out.println("startDate " + getStartOfCurrentDate());
        System.out.println("endDate " + getEndOfCurrentDate());
    }

    /**
     * This method returns the End of current date
     * 
     * @return date
     */
    private static Date getEndOfCurrentDate() {
        Date end = DateUtils.addDays(new Date(), 1);
        return getDatePart(end);
    }

    /**
     * This method returns the start of current date
     * 
     * @return date
     */
    private static Date getStartOfCurrentDate() {
        return getDatePart(new Date());
    }

    /**
     * This method returns the date without time stamp
     * 
     * @param date
     * @return date
     */
    private static Date getDatePart(Date date) {
        return DateUtils.truncate(date, Calendar.DATE);
    }
}
