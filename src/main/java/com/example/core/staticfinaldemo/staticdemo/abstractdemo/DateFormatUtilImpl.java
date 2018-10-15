package com.example.core.staticfinaldemo.staticdemo.abstractdemo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DateFormatUtilImpl extends DateFormatUtils {

    @Override
    public DateFormat getReportsDateFormat() {
        return new SimpleDateFormat("MM/DD/YYYY");
    }

}
