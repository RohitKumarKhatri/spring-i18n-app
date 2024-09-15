package com.demo.springi18napp.util;

import java.text.NumberFormat;
import java.time.format.FormatStyle;
import java.util.Currency;
import java.util.Locale;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Commons {

    public static final String LANG = "lang";
    public static final String GREETING_VIEW = "greeting";

    public static String formatCurrencyForLocale(double amount, Locale locale) {
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        currencyFormatter.setCurrency(Currency.getInstance(locale));
        return currencyFormatter.format(amount);
    }


    public static String formatDateForLocale(LocalDate date, Locale locale) {
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).withLocale(locale);
        return date.format(formatter);
    }

}
