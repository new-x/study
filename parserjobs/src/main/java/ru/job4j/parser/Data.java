package ru.job4j.parser;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.parser
 * Create data: 14.07.2018 20:18
 */

public class Data {
    private Calendar lastDate;
    private final Calendar STARTDATE;
    private final String WEEKDAY[] = {"сегодня", "вчера"};
    private final DateFormat DF = new SimpleDateFormat("d MMM y", new Locale("ru"));
    private final DateFormat CONVERT = new SimpleDateFormat("d MMM y, HH:mm", new Locale("ru"));
    private static final Logger LOGGER = LogManager.getLogger(Data.class);

    public Data(int year, int month, int day, int hours, int minute, int seconds, Calendar lastDate) {
        this.STARTDATE = new GregorianCalendar(year, month, day, hours, minute, seconds);
        this.lastDate = lastDate;
    }

    public Calendar parsingDate(String time) {
        Calendar calendar = new GregorianCalendar();
        String[] subTime = time.split(" ");
        try {
            if (subTime[0].contains(WEEKDAY[0])) {
                String curentData = DF.format(calendar.getTime()) + ", " + subTime[1];
                calendar.setTime(CONVERT.parse(curentData));
                return calendar;

            } else if (subTime[0].contains(WEEKDAY[1])) {
                calendar.add(Calendar.DATE, -1);
                String curentData = DF.format(calendar.getTime()) + ", " + subTime[1];
                calendar.setTime(CONVERT.parse(curentData));
                return calendar;
            } else {
                calendar.setTime(CONVERT.parse(time));
            }
        } catch (ParseException e) {
            LOGGER.error(e);
        }

        return calendar;
    }

    public boolean checkDate(Calendar dateThread) {
        boolean result = false;
        if (this.lastDate == null && dateThread.after(this.STARTDATE)) {
                result = true;
        } else if (this.lastDate != null) {
            if (this.lastDate.after(dateThread) && dateThread.after(this.STARTDATE)) {
                result = true;
            }
        }
        return result;
    }
}