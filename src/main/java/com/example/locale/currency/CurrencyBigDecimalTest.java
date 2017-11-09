package com.example.locale.currency;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class CurrencyBigDecimalTest {

    static Currency currency;

    public static void main(String[] args) {
        BigDecimal Amount = new BigDecimal(7575);
        BigDecimal otherAmount = new BigDecimal(5);
        BigDecimal newAmount = Amount.divide(otherAmount, 4, RoundingMode.HALF_UP);
        System.out.println(newAmount);
        System.out.println(newAmount.multiply(otherAmount));

        currency = Currency.getInstance(Locale.US);
        System.out.println("Currency.getSymbol() = " + currency.getSymbol());

        Locale userLocale = new Locale("en", "US");
        System.out.println(userLocale);
        String currencyCode = currency.getSymbol(Locale.US);
        System.out.println("currencyCode " + currencyCode);
        NumberFormat nf = NumberFormat.getInstance(userLocale);
        System.out.println(nf);

        System.out.println(currencyCode + nf.format(Amount));

        System.out.println(currencyCode + Amount.setScale(2, RoundingMode.HALF_UP));
    }

}
