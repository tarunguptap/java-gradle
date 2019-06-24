package com.example.core.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddDaysToCurrentDate {
    public static void main(String[] args) throws ParseException {
        Calendar cal = Calendar.getInstance();
        cal.set(2019, 3, 10);
        Date expiredDate = cal.getTime();
        System.out.println("Calander Date @@@" + expiredDate);

        SimpleDateFormat droolsDateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss.SSS");
        String dateString = droolsDateFormat.format(expiredDate);
        System.out.println("dateString @@@@ " + dateString);

        Date date = droolsDateFormat.parse(dateString);

        System.out.println("parsed date @@@  " + date);

    }
}
