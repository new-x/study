package ru.job4j;

/**
 * Created by aleks on 06.08.2017.
 */
public class Cell {
    private int positionOneX; //Position on the x-axis.
    private int positionTwoY; //Position on the y-axis.

    public Cell(int positionOneX, int positionTwoY) {
        this.positionOneX = positionOneX;
        this.positionTwoY = positionTwoY;
    }

    public int getPositionOneX() {
        return positionOneX;
    }

    public int getPositionTwoY() {
        return positionTwoY;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "positionOneX=" + positionOneX +
                ", positionTwoY=" + positionTwoY +
                '}';
    }
}
