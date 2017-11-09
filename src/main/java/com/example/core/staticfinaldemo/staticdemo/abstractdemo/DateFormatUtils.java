package com.example.core.staticfinaldemo.staticdemo.abstractdemo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public abstract class DateFormatUtils {

    private static final String DATE_FORMAT = "DD/MM/YYYY";

    public abstract DateFormat getReportsDateFormat();

    public static DateFormat getDateFormat() {
        return new SimpleDateFormat(DATE_FORMAT);
    }
}
