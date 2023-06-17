package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {
    public static String convertToHtmlDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }
}
