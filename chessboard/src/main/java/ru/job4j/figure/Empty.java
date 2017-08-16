package ru.job4j.figure;

import ru.job4j.Cell;
import ru.job4j.logic.Figure;

/**
 * Created by aleks on 06.08.2017.
 */
public class Empty extends Figure {

    public Empty() {
        super("Пусто");
    }

    @Override
    public boolean empty() {
        return true;
    }

    @Override
    public Cell[] way(Cell source, Cell distance) {
        return new Cell[0];
    }
}
