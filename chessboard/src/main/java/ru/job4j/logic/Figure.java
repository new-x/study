package ru.job4j.logic;

import ru.job4j.Board;
import ru.job4j.Exceptions.FigureNotFoundException;
import ru.job4j.Exceptions.OccupiedWayException;
import ru.job4j.figure.Elephant;

/**
 * Class Figure
 *
 * @author alekseev
 * @since mm-dd-yyyy
 */
public abstract class Figure {
    //private int positionOne, positionTwo, numberOne, numberTwo = 0;
    //public String[][] boardPosition = new String[7][7];
    //public final static String ELEPHANT = "Elephant";
    public Board board = new Board();

    public Figure(){

    }

    public void CellPosition(int positionOne, int positionTwo, int numberOne, int numberTwo) {

        if(Integer.parseInt(board.boardPosition[numberOne][numberTwo]) == 0) { //When numberOne and Two == 0 figure not Found.
            throw new FigureNotFoundException("Figure not Found.");
        }
        if(Integer.parseInt(board.boardPosition[positionOne][positionTwo]) != 0) {
            throw new OccupiedWayException("This position is occupied."); // When  positionOne and Two is occupied.
        }
        else {
            if (board.boardPosition[numberOne][numberTwo].equals(board.allFigure[4])) { // When figure Elephant call method Elephant with option.
                Elephant elephant = new Elephant();
                if(elephant.Elephant(positionOne, positionTwo, numberOne, numberTwo) == true){
                    board.boardPosition[positionOne][positionTwo] = board.boardPosition[numberOne][numberTwo];
                }
            }
        }

    }

}
