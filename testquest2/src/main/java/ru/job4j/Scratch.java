package ru.job4j;

public class Scratch {
    int[][] arr = new int[5][5];
    void method(int x, int y) {
        System.out.println("In method " + x + " " + y);
        if (x < 2) {
            method(x + 1, y);
        } else {
            System.out.println("finish " + x + " " + y );
        }
        if(y < 2) {
            method(x, y + 1);
        } else {
            System.out.println("finish " + x + " " + y );
        }
    }
    public static void main(String[] args) {
        Scratch test = new Scratch();
        test.method(0,0);
    }
}
