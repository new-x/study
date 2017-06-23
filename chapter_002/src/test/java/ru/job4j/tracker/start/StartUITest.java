package ru.job4j.tracker.start;

/**
 * Created by Nastasia on 09.06.2017.
 */
public class StartUITest {
    public static void main(String[] args) {
        Input input = new StubInput(new String[] {"create task question"});
        new StartUI(input).menu();
    }
}
