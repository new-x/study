package ru.job4j;

/**
 * Created by aleks on 21.08.2017.
 */
public class Node {
    public int valueOne;
    public int valueTwo;
    public int valueThree;

    public Node(int valueOne, int valueTwo, int valueThree) {
        this.valueOne = valueOne;
        this.valueTwo = valueTwo;
        this.valueThree = valueThree;
    }

    @Override
    public String toString() {
        return "Node{" +
                "valueOne=" + valueOne +
                ", valueTwo=" + valueTwo +
                ", valueThree=" + valueThree +
                '}';
    }
}
