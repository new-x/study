package ru.job4j.paintimg.models;

import ru.job4j.paintimg.start.Shape;

/**
 * @author alekseev
 * @since mm-dd-yyyy
 */
public class Square implements Shape {
    /**
     * Create Square.
     * @return string with Square.
     */
    public String pic() {
        String separator = System.getProperty("line.separator");
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder resultStringBuilder = new StringBuilder();
        for (int index = 0; index < 8; index++) {
            stringBuilder.append("+");
        }
        stringBuilder.append(separator);
        for (int index = 0; index < 8; index++) {
            resultStringBuilder.append(stringBuilder);
        }
        resultStringBuilder.append(separator);
        return resultStringBuilder.toString();
    }
}
