package ru.job4j.parser;

import org.quartz.*;
import org.quartz.Job;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.parser
 * Create data: 11.07.2018 23:17
 */

public class Start implements Job {
    private final Parser parser = new Parser();
    private static String path;

    public static void main(String[] args) throws SchedulerException {
        path = args[0];
        //path = "app.properties";
        Cron cron = new Cron();
        cron.initCron(path);

        /*String path = "app.properties";
        Parser parser = new Parser();

        parser.findJobs(path);
        parser.close();*/
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        this.parser.findJobs(path);
        this.parser.close();
    }
}
