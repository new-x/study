package ru.job4j.figure;


import ru.job4j.Cell;
import ru.job4j.logic.Figure;

/**
 * Class Elephant
 *
 * @author alekseev
 * @since mm-dd-yyyy
 */
public class Elephant extends Figure {

    public Elephant(String colourFigure) {
        super(colourFigure + "Elephant");
    }
    /*
    @param source - The position of the figure.
    @param distance - Moving point.
     */

    @Override
    public Cell[] way(Cell source, Cell distance) { // The method checks the logic of the elephant.
        Cell[] point = new Cell[Math.abs(source.getPositionOneX() - distance.getPositionOneX())];
        if ((Math.abs(distance.getPositionOneX() - source.getPositionOneX()) - Math.abs(distance.getPositionTwoY() - source.getPositionTwoY()) == 0)) {
            if (source.getPositionOneX() > distance.getPositionOneX() | source.getPositionTwoY() > distance.getPositionTwoY()) {
                int positionOne = source.getPositionOneX(); // Assign a position along the axis x of the figure to a temporary variable.
                int positionTwo = source.getPositionTwoY(); // Assign a position along the axis y of the figure to a temporary variable.
                for (int index = 0; index < point.length; index++) {
                    point[index] = new Cell(--positionOne, --positionTwo);
                }
            }
        } else {
            point[0] = new Cell(8, 8);
        }
        return point;
    }
}
