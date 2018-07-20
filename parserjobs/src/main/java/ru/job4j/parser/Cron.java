package ru.job4j.parser;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.parser
 * Create data: 20.07.2018 15:25
 */

public class Cron{

    public void initCron(String path) throws SchedulerException {
        Properties config = new Properties();
        try {
            config.load(getClass().getClassLoader().getResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JobDetail job = JobBuilder.newJob(Start.class)
                .withIdentity("StartParser", "group1").build();

        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("initTriggerParser", "group1")
                .withSchedule(CronScheduleBuilder.cronSchedule(config.getProperty("cron.time")))
                .build();

        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();
        scheduler.scheduleJob(job, trigger);
    }
}
