package ru.job4j.tracker.start;

/**
 * Class MenuOutExeption.
 *
 * @author alekseev
 * @since mm-dd-yyyy
 */
public class MenuOutExeption extends RuntimeException {
    public MenuOutExeption(String msg) {
        super(msg);
    }
}
