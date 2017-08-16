package ru.job4j.logic;

import ru.job4j.Cell;

/**
 * Class Board
 *
 * @author alekseev
 * @since mm-dd-yyyy
 */
public abstract class Figure {
    private String nameFigure; // Stored the name of the figure.

    public Figure(String nameFigure) {
        this.nameFigure = nameFigure;
    }

    @Override
    public String toString() {
        return "Figure{" +
                "nameFigure='" + nameFigure + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Figure figure = (Figure) o;

        return nameFigure != null ? nameFigure.equals(figure.nameFigure) : figure.nameFigure == null;
    }

    @Override
    public int hashCode() {
        return nameFigure != null ? nameFigure.hashCode() : 0;
    }

    public boolean empty() {
        return false;
    }

    public abstract Cell[] way(Cell sourse, Cell distance);


}
