package ru.job4j.tracker.start;

/**
 * Class Input.
 *
 * @author alekseev
 * @since mm-dd-yyyy
 */

public interface Input {
    /**
     * Method ask - принимает значение question, но ничего не возвращает.
     *
     * @param question - передаем задание.
     * @return ничего не возвращаем.
     */
    String ask(String question);

    int ask(String question, int[] range);
}
