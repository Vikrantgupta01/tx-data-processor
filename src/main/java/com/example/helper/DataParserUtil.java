package com.example.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataParserUtil {


    public static int getInteger(String value) {
        return Integer.parseInt(value.trim());

    }

    public static String getString(String value) {
        return value.trim();

    }

    public static double getDouble(String value, int precision) {
        return Long.parseLong(value.trim()) / Math.pow(10, precision);

    }

    public static Date getDate(String value, String format) {
        try {
            return new SimpleDateFormat(format).parse(value.trim());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static void main(String[] args) {
       // System.out.println(Integer.parseInt("92500000000000".trim()));
        System.out.println(getDouble("000092500000090",7));
    }


}
