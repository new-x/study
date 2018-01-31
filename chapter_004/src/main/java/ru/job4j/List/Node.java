package ru.job4j.List;

public class Node<E> {
    E element;
    Node<E> next;
    Node<E> previous;

    public Node(Node<E> previous, E element) {
        this.element = element;
        this.previous = previous;
    }

    public Node(E element) {
        this.element = element;
    }
}
