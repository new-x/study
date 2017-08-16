package ru.job4j;

import ru.job4j.Exceptions.FigureNotFoundException;
import ru.job4j.Exceptions.ImposibleMoveException;
import ru.job4j.Exceptions.OccupiedWayException;
import ru.job4j.figure.Elephant;
import ru.job4j.figure.Empty;
import ru.job4j.logic.Figure;

/**
 * Class Board
 *
 * @author alekseev
 * @since mm-dd-yyyy
 */
public class Board {
    public Figure[][] boardPosition = new Figure[8][8]; // Create the Board 8 x 8.
    private Empty empty = new Empty(); // Create an empty point.
    public String[] colourFigure = {"White", "Black"}; // Colour figure 0 - white, 1 - black.

    public void placementFigure() { // Arrange the figures on the Board.
        boardPosition[0][2] = new Elephant(colourFigure[0]);
        boardPosition[0][5] = new Elephant(colourFigure[0]);
        boardPosition[7][2] = new Elephant(colourFigure[1]);
        boardPosition[7][5] = new Elephant(colourFigure[1]);
        boardPosition[6][4] = new Empty();
        boardPosition[5][3] = new Empty();
        boardPosition[4][2] = new Empty();
        boardPosition[3][1] = new Empty();
        boardPosition[2][0] = new Empty();

    }
    /*
    @param source - The position of the figure.
    @param distance - Moving point.
     */

    public boolean move(Cell source, Cell distance) {
        boolean check = false;
        Figure figure = this.boardPosition[source.getPositionOneX()][source.getPositionTwoY()];
        if (figure.empty()) { //When in selected position, no figures.
            throw new FigureNotFoundException("Figure not found on this position.");
        } else { // In this position there is a figure.
            if (empty.equals(this.boardPosition[distance.getPositionOneX()][distance.getPositionTwoY()])) { // When position to move free.
                Cell[] cells = figure.way(source, distance);
                if (cells[0].getPositionOneX() == cells[0].getPositionTwoY()) { // When the logic of the figure is broken.
                    throw new ImposibleMoveException("The operation is performed.");
                } else { // If the logic of the figures is correct, check the employment positions.
                    for (Cell position : cells) {
                        if (this.boardPosition[position.getPositionOneX()][position.getPositionTwoY()].equals(empty)) {
                            check = true;
                        } else { // When position to move busy.
                            throw new ImposibleMoveException("The operation is performed.");
                        }
                    }
                }
            } else { // When position to move busy.
                throw new OccupiedWayException("This position is busy. ");
            }
        }
        if (check = true) { // When the logic of the figure is correct, and the movement may make a move.
            this.boardPosition[distance.getPositionOneX()][distance.getPositionTwoY()] = this.boardPosition[source.getPositionOneX()][source.getPositionTwoY()];
            this.boardPosition[source.getPositionOneX()][source.getPositionTwoY()] = new Empty();
        }
        return check;
    }
}
