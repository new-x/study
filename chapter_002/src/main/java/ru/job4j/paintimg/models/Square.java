package ru.job4j.paintimg.models;

import ru.job4j.paintimg.start.Shape;

/**
 * @author alekseev
 * @since mm-dd-yyyy
 */
public class Square implements Shape {
    public String pic(Shape shape) {
        StringBuilder sb = new StringBuilder();
        sb.append("++++++++");
        sb.append("+      +");
        sb.append("+      +");
        sb.append("++++++++");
        return sb.toString();
    }
}
