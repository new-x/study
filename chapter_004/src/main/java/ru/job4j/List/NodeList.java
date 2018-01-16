package ru.job4j.List;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class NodeList<E> implements SimpleContainer<E> {
    private Node<E> previous;
    private Node<E> first;
    private Node<E> current;
    private int length = 0;
    private int modCount = 0;


    @Override
    public void add(E e) {
        if (this.previous == null) {
            this.first = new Node<>(null, e);
            this.previous = this.first;
        } else {
            this.current = new Node(this.previous, e);
            this.previous.setNext(this.current);
            this.previous = this.current;

        }
        modCount++;
        length++;
    }

    @Override
    public E get(int index) {
        if (index >= this.length) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> findElement = this.first;
        for (int i = 0; i < index; i++) {
            findElement = findElement.getNext();
        }
        return (E) findElement.getElement();
    }

    @Override
    public Iterator<E> iterator() {
        int state = this.modCount;
        return new Iterator<E>() {
            int index = 0;
            Node<E> element = first;
            Node<E> nextElement = first;

            @Override
            public boolean hasNext() {
                if (state == modCount) {
                    if (nextElement != null) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    throw new ConcurrentModificationException("Mod count exception.");
                }
            }

            @Override
            public E next() {
                if (hasNext()) {
                    if (index == 0) {
                        nextElement = element.getNext();
                        index++;
                        return (E) element.getElement();
                    } else {
                        element = nextElement;
                        nextElement = nextElement.getNext();
                        index++;
                        return (E) element.getElement();
                    }

                }
                return null;
            }
        };
    }
}
