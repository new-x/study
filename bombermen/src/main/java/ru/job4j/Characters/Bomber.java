package ru.job4j.Characters;

import ru.job4j.Cell;
import ru.job4j.Logic.LogicBoard;

import java.util.Scanner;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j
 * Create data: 29.05.2018 20:06
 */

public class Bomber extends LogicBoard implements Runnable  {
    private static final Scanner inScan = new Scanner(System.in);
    private Cell source = new Cell(0, 0);

    private void init() {
        board.initBomberman(this.source);
    }


    private void step(Cell source) {
        boolean check = false;
        int x = 0;
        int y = 0;
        while (!check) {
            System.out.print("Enter fields for the axis step Х: ");
            x = this.inScan.nextInt();
            System.out.print("Enter fields for the axis step Y: ");
            y = this.inScan.nextInt();
            if (move(source, new Cell(x, y))) {
                this.board.stepBomberman(source, new Cell(x, y));
                check = true;
            }
        }
        this.source = new Cell(x, y);
    }

    @Override
    public void run() {
        init();
        while (!Thread.interrupted()) {
            step(this.source);
        }
    }

}
