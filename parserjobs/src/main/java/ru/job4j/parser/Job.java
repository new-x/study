package ru.job4j.parser;

import java.sql.Timestamp;
import java.util.Calendar;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.parser
 * Create data: 14.07.2018 14:19
 */

public class Job {
    String thread;
    String url;
    Calendar creat_date;

    public Job(String thread, String url, Calendar creat_date) {
        this.thread = thread;
        this.url = url;
        this.creat_date = creat_date;
    }

    public String getThread() {
        return thread;
    }

    public String getUrl() {
        return url;
    }

    public Calendar getCreat_date() {
        return creat_date;
    }

    @Override
    public String toString() {
        return "Job{" +
                "thread='" + thread + '\'' +
                ", url='" + url + '\'' +
                ", creat_date=" + creat_date +
                '}';
    }
}
