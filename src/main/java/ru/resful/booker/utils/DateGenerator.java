package ru.resful.booker.utils;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class DateGenerator {

    private static String format = "yyyy-MM-dd";



    public static String getDate(){
        DateFormat dateFormat = new SimpleDateFormat(format);
        Date date = new Date();
        return dateFormat.format(date);
    }


    public static String getDateWithShift(int days){
        DateFormat dateFormat = new SimpleDateFormat(format);
        Date date = new Date();

        // convert date to calendar
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, days);

        //convert calendar to date
        date = c.getTime();
        return dateFormat.format(date);
    }


}