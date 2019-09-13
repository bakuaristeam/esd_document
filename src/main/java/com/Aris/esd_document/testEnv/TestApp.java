package com.Aris.esd_document.testEnv;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestApp {

    public static void main(String[] args) throws ParseException {
//
//
//        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        String testDate = "2019-01-12 00:12:12";
//        Date date = formatter.parse(testDate);
//        System.out.println(date.getTime());

        String string_date = "";

        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            Date d = f.parse(string_date);
            long milliseconds = d.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}
