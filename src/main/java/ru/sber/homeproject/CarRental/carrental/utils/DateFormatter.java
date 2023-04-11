package ru.sber.homeproject.CarRental.carrental.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatter {
    private DateFormatter(){

    }
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static LocalDate formatStringToDate(final String dateFormat){
        return LocalDate.parse(dateFormat, FORMATTER);
    }

}
