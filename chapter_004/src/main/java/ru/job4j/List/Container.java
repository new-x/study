package ru.job4j.List;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

@ThreadSafe
public class Container<E> implements SimpleContainer<E> {
    private int modCount = 0;
    @GuardedBy("this")
    private Object[] objects = new Object[2];
    private int position = 0;

    @Override
    public synchronized void add(E e) {
        if (this.objects.length - 1 > this.position) {
            this.objects[this.position++] = e;
            modCount++;
        } else {
            this.objects = Arrays.copyOf(this.objects, position + 3);
            this.objects[position++] = e;
            modCount++;
        }
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public synchronized E get(int index) {
        if (index < position) {
            return (E) this.objects[index];
        }
        return null;
    }

    @Override
    public synchronized boolean hasDuplicate(E e) {
        for (Object node : this.objects) {
            if (node != null) {
                if (node.equals(e)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public synchronized Iterator<E> iterator() {
        Object[] array = this.objects;
        int state = modCount;
        return new Iterator<E>() {
            int index = 0;

            @Override
            public synchronized boolean hasNext() {
                if (state == modCount) {
                    return index < position;
                } else {
                    throw new ConcurrentModificationException("Mod count exception.");
                }
            }

            @Override
            public synchronized E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) array[index++];
            }
        };
    }
}
