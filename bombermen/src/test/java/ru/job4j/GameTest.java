package ru.job4j;

import org.junit.Test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j
 * Create data: 27.05.2018 22:16
 */

public class GameTest {
    private ReentrantLock[][] board;

    @Test
    public void testGame() throws InterruptedException {

       /* this.board = new ReentrantLock[10][10];
        for (int indexX = 0; indexX < this.board.length; indexX++) {
            for (int indexY = 0; indexY < this.board[0].length; indexY++) {
                this.board[indexX][indexY] = new ReentrantLock();
            }
        }
        Game game = new Game(this.board);

        Thread thread1 = new Thread(() -> {
            int posX = 1;
            int posY = 1;
                if (posX < this.board[0].length && posY < this.board.length && posX >= 0 && posY >=0) {
                    //game.user(new Cell(0, 0), new Cell(0, 1));
                } else {
                    System.out.println("The starting position of the user violates not within the Board.");
                }
        });

        Thread thread2 = new Thread(() -> {
            game.lockTable();
        });

        //thread2.start();
        thread1.start();
        thread1.join();*/
    }
}
