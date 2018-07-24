package ru.job4j.parser;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.parser
 * Create WORK: 13.07.2018 16:40
 */

public class Parser {
    private static final Logger LOGGER = LogManager.getLogger(Parser.class);
    private final String[] BADWORDS = {"java script", "javascript"};
    private final String URLSERVER = "http://www.sql.ru/forum/job-offers/";
    private final Work WORK = new Work();
    private boolean chekcer = true;

    public void findJobs(String path) {
        LOGGER.info("Старт парсинга.");
        WORK.initCon(path);
        int index = 1;
        while (this.chekcer) {
            try {
                addJobs(Jsoup.connect(this.URLSERVER + index).get());
            } catch (IOException e) {
                LOGGER.error(e);
            }
            index++;
        }
    }

    public void addJobs(Document document) {
        Elements elements = document.getElementsByTag("tr");
        for (Element element : elements) {
            if (checkName(element.child(1).text())) {
                    this.chekcer =  WORK.checker(element.child(1).text(),
                                    element.child(1).getElementsByTag("a").attr("href"),
                                    element.child(5).text());
                    if (!chekcer) {
                        LOGGER.info("Остановка парсера.");
                        break;
                    }
            }
        }
    }

    public boolean checkName(String text) {
        boolean result = false;
        if (text.toLowerCase().contains("java")) {
            result = true;
        }
        for (String badWord : BADWORDS) {
            if (text.toLowerCase().contains(badWord)) {
                result = false;
            }
        }
        return result;
    }

    public void close() {
        try {
            WORK.close();
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }
}