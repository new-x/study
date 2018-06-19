package ru.job4j;

import ru.job4j.Characters.Bomber;
import ru.job4j.Characters.Monsters;

import java.util.Scanner;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j
 * Create data: 26.05.2018 23:09
 */

public class Game {
    private static final Scanner inScan = new Scanner(System.in);
    protected static Board board;

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the field size along the axis Х: ");
        int x = scanner.nextInt();
        System.out.print("Enter the field size along the axis Y: ");
        int y = scanner.nextInt();
        board = new Board(x, y);
        Thread bomber = new Thread(new Bomber());
        bomber.start();
        startMonsters();
        //bomber.join();
    }

    public static void startMonsters() {
        Thread[] monsters = new Thread[4];
        for (Thread monster : monsters) {
            monster = new Thread(new Monsters());
            monster.start();
        }
    }

    public void initBoard() {
        System.out.print("Enter the field size along the axis Х: ");
        int x = this.inScan.nextInt();
        System.out.print("Enter the field size along the axis Y: ");
        int y = inScan.nextInt();
        this.board = new Board(x, y);
    }
}
