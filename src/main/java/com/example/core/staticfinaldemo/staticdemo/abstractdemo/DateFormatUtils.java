package com.example.core.staticfinaldemo.staticdemo.abstractdemo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public abstract class DateFormatUtils {

    private static final String DATE_FORMAT = "DD/MM/YYYY";

    public abstract DateFormat getReportsDateFormat();

    public static DateFormat getDateFormat() {
        return new SimpleDateFormat(DATE_FORMAT);
    }

    public static DateFormat getUTCZDateFormat() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        return df;
    }
}
