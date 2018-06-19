package ru.job4j.Logic;

import ru.job4j.Cell;
import ru.job4j.Exceptions.IncorrectCoordinateException;
import ru.job4j.Game;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.Logic
 * Create data: 18.06.2018 18:05
 */

public class LogicBoard extends Game {
    public boolean move(Cell source, Cell dist) {
        if (Math.abs(dist.getX() - source.getX()) <= 1 && Math.abs(dist.getY() - source.getY()) <= 1) {
            return true;
        }
        if(Math.abs(dist.getX() - source.getX()) <= 1 && dist.getY() == 0) {
            return true;
        }
        if(dist.getX() == 0 && dist.getY() == 0) {
            return true;
        }
        else {
            System.out.println("Coordinate error. Write others.");
            return false;
        }
    }
}
