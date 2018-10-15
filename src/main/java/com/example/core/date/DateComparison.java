package com.example.core.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class DateComparison {

    private static final String DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ssXXX";
    private static final String END_DATE = "2018-01-08T019:00:00Z";

    public static void main(String[] args) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN);
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        dateFormat.setLenient(false);

        Date endDate = dateFormat.parse(END_DATE);

        Date currentDate = DateTime.now(DateTimeZone.UTC).toDate();

        if (endDate.before(currentDate)) {
            System.out.println(endDate + "End Date value cannot be before the current date." + currentDate);
        } else {
            System.out.println(endDate + " : End Date is greater than current date :" + currentDate);
        }
    }

}
