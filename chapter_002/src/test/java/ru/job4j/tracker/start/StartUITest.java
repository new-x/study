package ru.job4j.tracker.start;


/**
 * Class SrartUITest.
 *
 * @author alekseev
 * @since mm-dd-yyyy
 */

public class StartUITest {
    /**
     * @param args передается в метод main.
     */
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"create task question"});
        new StartUI(input, tracker).menu();
    }
}
