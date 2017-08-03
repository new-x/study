package ru.job4j.Exceptions;

/**
 * Created by aleks on 02.08.2017.
 */
public class OccupiedWayException extends  RuntimeException {
    public OccupiedWayException(String message) {
        super(message);
    }
}
