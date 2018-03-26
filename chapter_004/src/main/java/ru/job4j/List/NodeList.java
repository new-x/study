package ru.job4j.List;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

@ThreadSafe
public class NodeList<E> implements SimpleContainer<E> {
    @GuardedBy("this")
    private Node<E> previous;
    @GuardedBy("this")
    private Node<E> first;
    @GuardedBy("this")
    private Node<E> current;
    private int length = 0;
    private int modCount = 0;

    private synchronized Node<E> getNode(int index) {
        if (index >= this.length) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> findElement = this.first;
        for (int i = 0; i < index; i++) {
            findElement = findElement.next;
        }
        return findElement;
    }

    public synchronized int size() {
        return length;
    }

    @Override
    public synchronized void add(E e) {
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
    public synchronized E remove(int index) {
        Node<E> element = getNode(index);
        if (index == 0) {
            element.next.previous = this.first.previous;
            this.first = element.next;
        }
        if (index == length - 1) {
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
    public synchronized E get(int index) {
        return (E) getNode(index).element;
    }

    @Override
    public synchronized boolean hasDuplicate(E e) {
        for (int index = 0; index < length; index++) {
            if (this.get(index).equals(e)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public synchronized Iterator<E> iterator() {
        int state = this.modCount;
        return new Iterator<E>() {
            int index = 0;
            Node<E> element = first;
            Node<E> nextElement = first;

            @Override
            public synchronized boolean hasNext() {
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
            public synchronized E next() {
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
