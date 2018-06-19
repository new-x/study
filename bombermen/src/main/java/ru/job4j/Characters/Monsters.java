package ru.job4j.Characters;

import ru.job4j.Cell;
import ru.job4j.Exceptions.IncorrectCoordinateException;
import ru.job4j.Logic.LogicBoard;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j
 * Create data: 29.05.2018 20:07
 */

public class Monsters extends LogicBoard implements Runnable {

    private Cell initMonster() {
        boolean check = false;
        int x = 0;
        int y = 0;
        while (!check) {
            x = (int) (this.board.size().getX() * Math.random());
            y = (int) (this.board.size().getY() * Math.random());
            check = this.board.initMonster(new Cell(x, y));
        }
        return new Cell(x, y);
    }

    private Cell stepMonster(Cell source) {
        int x = source.getX();
        int y = source.getY();
        boolean check = true;
        while (check) {
            if (source.getX() + 1 != this.board.size().getX() && source.getY() + 1 == this.board.size().getY()) {
                if (move(source, new Cell(source.getX() + 1, 0))) {
                    x = source.getX() + 1;
                    y = 0;
                    board.stepMonster(source, new Cell(x, y));
                    return new Cell(x, y);
                }
            }
            if (source.getX() + 1 == this.board.size().getX() && source.getY() + 1 == this.board.size().getY()) {
                if (move(source, new Cell(0, 0))) {
                    x = 0;
                    y = 0;
                    board.stepMonster(source, new Cell(x, y));
                    return new Cell(x, y);
                }
            }
            if (source.getY() + 1 >= 0 && source.getY() + 1 < this.board.size().getY()) {
                if (move(source, new Cell(x, source.getY() + 1))) {
                    y = source.getY() + 1;
                    board.stepMonster(source, new Cell(x, y));
                    return new Cell(x, y);
                }
            }
            if (source.getX() + 1 >= 0 && source.getX() + 1 < this.board.size().getX()) {
                if (move(source, new Cell(source.getX() + 1, y))) {
                    x = source.getX() + 1;
                    board.stepMonster(source, new Cell(x, y));
                    return new Cell(x, y);
                }
            }
        }
        throw new IncorrectCoordinateException("Error in coordinate monster.");
    }

    @Override
    public void run() {
        Cell source;
        source = initMonster();
        while (!Thread.interrupted()) {
            source = stepMonster(source);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
