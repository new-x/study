package ru.job4j.Exceptions;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.Exceptions
 * Create data: 29.05.2018 20:04
 */

public class IncorrectCoordinateException extends RuntimeException {
    public IncorrectCoordinateException(String message) {
        super(message);
    }
}
