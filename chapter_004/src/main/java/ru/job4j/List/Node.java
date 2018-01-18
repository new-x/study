package ru.job4j.List;

public class Node<E> {
    private E element;
    private Node<E> next;
    private Node<E> previous;

    public Node(Node<E> previous, E current) {
        this.element = current;
        this.previous = previous;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public Node<E> getNext() {
        return next;
    }

    public E getElement() {
        return element;
    }

    public void setPrevious(Node<E> previous) {
        this.previous = previous;
    }

    public Node<E> getPrevious() {
        return previous;
    }
}
