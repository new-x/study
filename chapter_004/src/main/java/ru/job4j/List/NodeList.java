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
            findElement = findElement.getNext();
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
            this.previous.setNext(this.current);
            this.first.setPrevious(this.current);
            this.previous = this.current;

        }
        modCount++;
        length++;
    }

    @Override
    public E remove(int index) {
        Node<E> element = getNode(index);
        if (index == 0) {
            element.getNext().setPrevious(this.first.getPrevious());
            this.first = element.getNext();
        }
        if (index == length -1) {
            this.first.setPrevious(element.getPrevious());
            element.getPrevious().setNext(this.first);
        } else {
            element.getNext().setPrevious(element.getPrevious());
            element.getPrevious().setNext(element.getNext());
        }
        modCount++;
        length--;
        return (E) element.getElement();
    }

    @Override
    public E get(int index) {
        return (E) getNode(index).getElement();
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
                    nextElement = element.getNext();
                } else {
                    element = nextElement;
                    nextElement = nextElement.getNext();
                }
                index++;
                return (E) element.getElement();
            }
        };
    }
}
