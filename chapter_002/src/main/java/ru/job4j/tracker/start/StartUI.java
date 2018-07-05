package ru.job4j.tracker.start;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Class Tracker.
 *
 * @author alekseev
 * @since mm-dd-yyyy
 */

public class StartUI {
    /*
     * Init Logger.
     */
    private static final Logger Log = LoggerFactory.getLogger(Tracker.class);
    /**
     * Init array menu.
     */
    private int[] ranges = new int[]{0, 1, 2, 3, 4, 5};
    /**
     * Входящее значение.
     */
    private Input input;
    /**
     * Создаем объект tracker, класса трекер.
     */
    private Tracker tracker;

    /**
     * @param input   входно значение введенное значение с клавиатуры.
     * @param tracker входное значение данные по заявке.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public static void main(String[] args) throws Exception {
        try(Tracker tracker = new Tracker()) {
            tracker.init();
            new StartUI(new ValidateInput(), tracker).init();
        }
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        do {
            menu.show();
            menu.select(input.ask("Select: ", ranges));
        } //while (true);
        while (!"y".equals(this.input.ask("Exit?(y): ")));
    }
}
