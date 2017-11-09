package com.example.locale.currency;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class CurrencyDemo {

    public static void main(String[] args) {
        // When user locale is Canada and currency is also CAD then output will be $1,234.23, its understood that $ is
        // canadian dollar
        Locale.setDefault(new Locale("en", "CA"));
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.getDefault());
        Currency currency = Currency.getInstance("CAD");
        nf.setCurrency(currency);
        System.out.println(nf.format(1234.23434));

        // When user locale is US and currency is CAD then output will be CAD1,234.23, it depicts that currency is
        // canadian
        Locale.setDefault(new Locale("en", "US"));
        nf = NumberFormat.getCurrencyInstance(Locale.getDefault());
        currency = Currency.getInstance("CAD");
        nf.setCurrency(currency);
        System.out.println(nf.format(1234.23434));

        // When user locale is CA and currency is USD then output will be US$1,234.23, it depicts that currency is
        // US dollar
        Locale.setDefault(new Locale("en", "CA"));
        nf = NumberFormat.getCurrencyInstance(Locale.getDefault());
        currency = Currency.getInstance("USD");
        nf.setCurrency(currency);
        System.out.println(nf.format(1234.23434));
    }
}
