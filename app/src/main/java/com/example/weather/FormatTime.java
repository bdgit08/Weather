package com.example.weather;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FormatTime {
    public static Date convertStringToDate(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date;
        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException e) {
            date = new Date();
        }
        return date;
    }

    public static String convertDateToString(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy", Locale.getDefault());
        return dateFormat.format(date);
    }

    public static String convertDateToTime(Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
        return dateFormat.format(date);
    }
}
