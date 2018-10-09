package ru.job4j;

public class Work {
    private final int[][] field;
    private final int lengthY;
    private int bypass = 0;


    public Work(int[][] field) {
        this.field = field;
        this.lengthY = this.field.length;
    }


    public int cell(int x, int y, Node node) {
        Node currentNode = new Node(x, y);
        if (y == lengthY - 1 && x == this.field[y].length - 1) {
            countSteps(node);
            bypass++;
            System.out.println("Finish bypass: " + bypass);
        }
        if (checkLength(x + 1, y)) {
            if (field[y][x + 1] == 1) { //Ход вправо.
                currentNode.setParent(node);
                currentNode.setRight(new Node(x + 1, y));
                cell(x + 1, y, currentNode);
            }
        }
        if (checkLength(x, y + 1)) {
            if (field[y + 1][x] == 1) { // Ход вниз.
                currentNode.setParent(node);
                currentNode.setLeft(new Node(x, y + 1));
                cell(x, y + 1, currentNode);
            }
        }
        return bypass;
    }

    private void countSteps(Node node) {
        int count = 0;
        if (node != null) {
            while (node.getParent() != null) {
                node = node.getParent();
                count++;
            }
        }
        System.out.println("Steps: " + count);
    }

    private boolean checkLength(int x, int y) {
        boolean result = false;
        if (y < lengthY && x < this.field[y].length) {
            result = true;
        }
        return result;
    }
}
