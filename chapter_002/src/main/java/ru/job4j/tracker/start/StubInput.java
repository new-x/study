package ru.job4j.tracker.start;

/**
 * Created by Nastasia on 09.06.2017.
 */
public class StubInput implements Input {
    private String[] answers;
    private int position = 0;

    public StubInput(String[] answers) {
        this.answers = answers;

    }

    public String ask(String question) {
        return answers[position++];
    }

}
