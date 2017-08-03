package ru.job4j;

import ru.job4j.logic.Figure;

/**
 * Class Board
 *
 * @author alekseev
 * @since mm-dd-yyyy
 */
public class Board extends Figure {
    public String[][] boardPosition = new String[7][7];
    public String[] allFigure = {"Pawn", "Rook", "Horse", "Elephant", "King", "Quin"};
}
