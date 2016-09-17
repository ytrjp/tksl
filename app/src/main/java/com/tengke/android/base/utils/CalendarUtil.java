package com.tengke.android.base.utils;


import java.util.Calendar;
import java.util.Date;

public class CalendarUtil {
    public static Calendar getCalendarOfDays(Calendar calendar, int days) {
        calendar.add(Calendar.DATE, days);
        return calendar;
    }

    public static String getWeek(Calendar calendar) {
        int week = calendar.get(Calendar.WEEK_OF_MONTH);
        String weekStr = "";
        switch (week) {
            case Calendar.MONDAY:
                weekStr = "周一";
                break;
            case Calendar.TUESDAY:
                weekStr = "周二";
                break;
            case Calendar.WEDNESDAY:
                weekStr = "周二";
                break;
            case Calendar.THURSDAY:
                weekStr = "周二";
                break;
            case Calendar.FRIDAY:
                weekStr = "周二";
                break;
            case Calendar.SATURDAY:
                weekStr = "周二";
                break;
            case Calendar.SUNDAY:
                weekStr = "周末";
                break;
        }
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return String.format("%d月%d日%s", month, day, weekStr);
    }
}
