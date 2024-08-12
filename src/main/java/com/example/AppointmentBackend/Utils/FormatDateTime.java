package com.example.AppointmentBackend.Utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class FormatDateTime {

    public static String formatDate(String date) {
        LocalDate localDate = LocalDate.parse(date);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM, yyyy");
        return localDate.format(formatter);
    }

    public static String formatTime(String time) {
        LocalTime localTime = LocalTime.parse(time);
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("h:mm a 'IST'");
        return localTime.format(timeFormatter);
    }
}
