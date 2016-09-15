package com.tengke.android.eventbus;

import java.util.Calendar;

public class SelectCalendarEvent {
    private int year;
    private int month;
    private int day;
    private int week;

    public void setData(int year, int month, int day, int week) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.week = week;
    }

    public String getData() {
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
        return String.format("%d月%d日%s", month, day, weekStr);
    }
}
