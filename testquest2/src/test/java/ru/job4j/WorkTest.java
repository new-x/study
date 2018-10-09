package ru.job4j;

import org.junit.Test;

public class WorkTest {

    @Test
    public void byPassOne() {
        Node nodeDefault = new Node(0, 0);
        nodeDefault.setParent(null);
        int[][] field = new int[][]{{1, 1, 1, 1, 0}, {0, 1, 1, 1, 1}, {0, 1, 0, 0, 0}, {0, 1, 1, 1, 1}, {0, 0, 1, 1, 1}};
        Work work = new Work(field);
        System.out.println("Count bypass: " + work.cell(0, 0, new Node(0, 0)));
    }
}