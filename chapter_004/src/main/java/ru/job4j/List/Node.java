package ru.job4j.List;

public class Node<E> {
    E element;
    Node<E> next;
    Node<E> previous;

    public Node(Node<E> previous, E current) {
        this.element = current;
        this.previous = previous;
    }

    public Node(E current){
        this.element = current;
    }
}
