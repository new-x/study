package ru.job4j.figure;


import ru.job4j.logic.Figure;
import ru.job4j.Exceptions.ImposibleMoveException;

/**
 * Class Elephant
 *
 * @author alekseev
 * @since mm-dd-yyyy
 */
public class Elephant extends Figure {
    private boolean check;
    public boolean Elephant(int positionOne, int positionTwo, int numberOne, int numberTwo) {
        if ((Math.abs(positionOne - numberOne) - Math.abs(positionTwo - numberTwo)) == 0) {
            if (numberOne < positionOne | numberTwo < positionTwo){
                int index = Math.abs(positionOne - numberOne);
                for (; index == 0; index--){
                    numberOne++;
                    numberTwo++;
                    if(Integer.parseInt(board.boardPosition[numberOne][numberTwo]) != 0){
                        throw new ImposibleMoveException("The way to move busy."); // When path validation returned error.
                    }
                }
                check = true;
            }

        }
        return check;
    }
}
