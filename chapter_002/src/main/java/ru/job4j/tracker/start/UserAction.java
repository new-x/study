package ru.job4j.tracker.start;

/**
 * Interface UserAction.
 *
 * @author alekseev
 * @since mm-dd-yyyy
 */
public interface UserAction {
    int key();

    void execute(Input input, Tracker tracker);

    String info();
}
