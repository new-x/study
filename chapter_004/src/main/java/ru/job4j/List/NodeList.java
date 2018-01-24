package ru.job4j.List;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class NodeList<E> implements SimpleContainer<E> {
    private Node<E> previous;
    private Node<E> first;
    private Node<E> current;
    private int length = 0;
    private int modCount = 0;

    public Node<E> getNode(int index) {
        if (index >= this.length) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> findElement = this.first;
        for (int i = 0; i < index; i++) {
            findElement = findElement.next;
        }
        return findElement;
    }

    public int size() {
        return length;
    }

    @Override
    public void add(E e) {
        if (this.previous == null) {
            this.first = new Node<>(null, e);
            this.previous = this.first;
        } else {
            this.current = new Node(this.previous, e);
            this.previous.next = this.current;
            this.first.previous = this.current;
            this.previous = this.current;

        }
        modCount++;
        length++;
    }

    @Override
    public E remove(int index) {
        Node<E> element = getNode(index);
        if (index == 0) {
            element.next.previous = this.first.previous;
            this.first = element.next;
        }
        if (index == length -1) {
            this.first.previous = element.previous;
            element.previous.next = this.first;
        } else {
            element.next.previous = element.previous;
            element.previous.next = element.next;
        }
        modCount++;
        length--;
        return (E) element.element;
    }

    @Override
    public E get(int index) {
        return (E) getNode(index).element;
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
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (index == 0) {
                    nextElement = element.next;
                } else {
                    element = nextElement;
                    nextElement = nextElement.next;
                }
                index++;
                return (E) element.element;
            }
        };
    }
}
