package ru.job4j.Exceptions;

/**
 * Created by aleks on 02.08.2017.
 */
public class FigureNotFoundException extends RuntimeException {
    public FigureNotFoundException(String message) {
        super(message);
    }
}
