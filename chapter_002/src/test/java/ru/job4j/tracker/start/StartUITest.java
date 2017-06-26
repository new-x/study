package ru.job4j.tracker.start;


/**
 * Class SrartUITest.
 *
 * @author alekseev
 * @since mm-dd-yyyy
 */

public class StartUITest {
    /**
     *
     * @param args передается в метод main.
     */
    public static void main(String[] args) {
        Input input = new StubInput(new String[]{"create task question"});
        new StartUI(input).menu();
    }
}
