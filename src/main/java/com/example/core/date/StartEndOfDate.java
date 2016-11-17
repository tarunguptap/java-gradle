package com.example.core.date;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;
import org.joda.time.DateTime;

public class StartEndOfDate {
    public static void main(String[] args) {
        // java util date time
        utilDateTime();

        //Joda Date Time
        jadaDateTimeStartEnd();
    }

    /*
     * With Joda Date Time Example -- starts here
     */
    private static void jadaDateTimeStartEnd() {
        System.out.println("currentDate " + new DateTime().toDate());

        DateTime startOfCurrentDate = new DateTime().withTimeAtStartOfDay();
        Date startDate = startOfCurrentDate.toDate();
        System.out.println("@@ joda startOfCurrentDate " + startOfCurrentDate);
        System.out.println("@@ joda startDate " + startDate);

        DateTime endOfCurrentDate = new DateTime().millisOfDay().withMaximumValue();
        Date endDate = endOfCurrentDate.toDate();
        System.out.println("@@ joda endOfCurrentDate " + endOfCurrentDate);
        System.out.println("@@ joda endDate " + endDate);
    }

    /*
     * With Joda Date Time Example -- ends here 
     */

    /*
     * With Java util Date Time Example -- Starts here
     */

    private static void utilDateTime() {
        System.out.println("startDate " + getStartOfCurrentDate());
        System.out.println("endDate " + getEndOfCurrentDate());
    }
    private static Date getEndOfCurrentDate() {
        Date end = DateUtils.addDays(new Date(), 1);
        return getDatePart(end);
    }

    private static Date getStartOfCurrentDate() {
        return getDatePart(new Date());
    }

    private static Date getDatePart(Date date) {
        return DateUtils.truncate(date, Calendar.DATE);
    }

    /*
     * With Date Time Example -- Ends here
     */
}
