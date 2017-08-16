package ru.job4j;

import org.junit.Test;
import ru.job4j.figure.Elephant;
import ru.job4j.figure.Empty;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class GameTest
 *
 * @author alekseev
 * @since mm-dd-yyyy
 */
public class GameTest {
    @Test
    public void whenFigureOneEqualsFigureTwo() {
        Board board = new Board();
        board.placementFigure();
        Elephant elephantTest = new Elephant(board.colourFigure[1]);
        assertThat(board.boardPosition[7][2], is(elephantTest));
    }

    @Test
    public void whenEmptyIsEmpty() {
        Board board = new Board();
        board.placementFigure();
        Empty emptyTest = new Empty();
        assertThat(board.boardPosition[2][0], is(emptyTest));
    }

    @Test
    public void whenFigureBoardPositionEqualsSourse() {
        Board board = new Board();
        board.placementFigure();
        Cell sourse = new Cell(7, 5);
        Cell distance = new Cell(2, 0);
        boolean result = board.move(sourse, distance);
        assertThat(result, is(true));
    }

    @Test
    public void elephant() {
        Cell sourse = new Cell(7, 5);
        Cell distance = new Cell(2, 0);
        Elephant elephant = new Elephant("BlackElephant");
        Cell[] result = elephant.way(sourse, distance);
        assertThat(result, is(true));
    }
}
