package ru.job4j.paintimg.models;

import ru.job4j.paintimg.start.Shape;

/**
 * @author alekseev
 * @since mm-dd-yyyy
 */
public class Triangle implements Shape {
    /**
     * Create Triangle.
     *
     * @return String with Triangle.
     *
     */
    public String pic() {
        int size = 1;
        String separator = System.getProperty("line.separator");
        StringBuilder resultStringBuilder = new StringBuilder();

        for (int index = 1; index < 6; index++) {
            for (int space = index; space < 5; space++){
                resultStringBuilder.append(" ");
            }
            for (int lenght = 0; lenght < size; lenght++) {
                resultStringBuilder.append("+");
            }
            size = size + 2;
            resultStringBuilder.append(separator);
        }
        return resultStringBuilder.toString();
    }
}
