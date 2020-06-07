package com.example.helper;

import java.text.DateFormat;
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

    public static String getDateInString(Date date, String format) {
        DateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }

    public static java.util.Date verifyDateInput(String input, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        if (input != null) {
            try {
                java.util.Date ret = sdf.parse(input.trim());
                if (sdf.format(ret).equals(input.trim())) {
                    return ret;
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


}
