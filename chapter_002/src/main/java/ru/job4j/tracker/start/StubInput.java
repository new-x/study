package ru.job4j.tracker.start;

/**
 * Class StubInput.
 *
 * @author alekseev
 * @since mm-dd-yyyy
 */

public class StubInput implements Input {
    /**
     * amswers - массив вопросов.
     */
    private String[] answers;
    /**
     * position - позиция.
     */
    private int position = 0;

    /**
     *
     * @param answers - передаем вопрос.
     */
    public StubInput(String[] answers) {
        this.answers = answers;

    }

    /**
     * @param question - передаем задание.
     * @return ничего не возвращаем.
     */
    public String ask(String question) {
        return answers[position++];
    }

}
