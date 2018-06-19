package ru.job4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j
 * Create data: 29.05.2018 20:47
 */

public class Board {
    private final ReentrantLock[][] board;


    public Board(int x, int y) {
        this.board = new ReentrantLock[x][y];
        for (int indexX = 0; indexX < this.board.length; indexX++) {
            for (int indexY = 0; indexY < this.board[0].length; indexY++) {
                this.board[indexX][indexY] = new ReentrantLock();
            }
        }
    }

    public Cell size() {
        return new Cell(board.length, board[0].length);
    }

    public void stepBomberman(Cell source, Cell dist) {
        try {
            if (board[dist.getX()][dist.getY()].tryLock(500, TimeUnit.MILLISECONDS)) {
                System.out.println("Bomberman position: " + dist.getX() + " " + dist.getY());
                if (board[source.getX()][source.getY()].isLocked()) {
                    board[source.getX()][source.getY()].unlock();
                    System.out.println("Unlock Bomber.");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void initBomberman(Cell source) {
        this.board[source.getX()][source.getY()].lock();
        System.out.println("Bomberman position: " + source.getX() + " " + source.getY());
    }


    public void stepMonster(Cell source, Cell dist) {
        try {
            if (board[dist.getX()][dist.getY()].tryLock(500, TimeUnit.MILLISECONDS)) {
                //System.out.println("Monster position: " + dist.getX() + " " + dist.getY());
                if (board[source.getX()][source.getY()].isLocked()) {
                    board[source.getX()][source.getY()].unlock();
                    //System.out.println("Unlock Monster.");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean initMonster(Cell source) {
        try {
            if (this.board[source.getX()][source.getY()].tryLock(500, TimeUnit.MILLISECONDS)) {
                //System.out.println("Monster position: " + source.getX() + " " + source.getY());
                return true;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }


}