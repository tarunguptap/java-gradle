package com.example.java8feature.datedemo;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

public class DateFormatDemo {
    public static void main(String[] args) {
        System.out.println("DateTimeFormatter" + getFormattedDateStringFromLocalDateTime());
        System.out.println("Date " + getFormattedDateStringFromUtilDate());
    }

    
    public static String getFormattedDateStringFromLocalDateTime() {
        LocalDateTime dateToFormat = LocalDateTime.now();
        return getFormattedDate(dateToFormat);
    }
    
    public static String getFormattedDateStringFromUtilDate() {
        Date date = new Date();
        return getFormattedDate(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
    }

    public static String getFormattedDate(TemporalAccessor dateToFormat) {
        String b2bDateFormat = "dd/MM/yyyy";
        DateTimeFormatter b2bDateFormatter = DateTimeFormatter.ofPattern(b2bDateFormat);
        return b2bDateFormatter.format(dateToFormat);
    }
}
