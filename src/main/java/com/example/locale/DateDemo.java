package com.example.locale;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang.time.FastDateFormat;

public class DateDemo {

    public static void main(String[] args) {
        Locale localeFrCAD = new Locale("fr", "CA");
        String dateStyleFrCAD = FastDateFormat.getDateInstance(FastDateFormat.SHORT, localeFrCAD).getPattern();
        System.out.println(dateStyleFrCAD);

        Format formatterFrCAD = new SimpleDateFormat(dateStyleFrCAD);
        System.out.println(formatterFrCAD.format(new Date()));

        Locale localeUS = new Locale("en", "US");
        String dateStyleUS = FastDateFormat.getDateInstance(FastDateFormat.SHORT, localeUS).getPattern();
        System.out.println(dateStyleUS);

        Format formatterUS = new SimpleDateFormat(dateStyleUS);
        System.out.println(formatterUS.format(new Date()));

        Locale localeCAD = new Locale("en", "CA");
        String dateStyleCAD = FastDateFormat.getDateInstance(FastDateFormat.SHORT, localeCAD).getPattern();
        System.out.println(dateStyleCAD);

        Format formatterCAD = new SimpleDateFormat(dateStyleCAD);
        System.out.println(formatterCAD.format(new Date()));

        // Java 8
        DateTimeFormatter pattern = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(Locale.FRANCE);
        LocalDate localDate = LocalDate.now();
        System.out.println(pattern.format(localDate));

    }

}
