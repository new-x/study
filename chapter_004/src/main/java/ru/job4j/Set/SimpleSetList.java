package ru.job4j.Set;

import java.util.Iterator;
import java.util.List;

public class SimpleSetList<E> implements SimpleContainer<E> {
    List<E> elements;
    private int index = 0;

    public SimpleSetList(List elements) {
        this.elements = elements;
    }

    @Override
    public void add(E e) {
        if (!check(e)) {
            elements.add(e);
        }
    }

    @Override
    public boolean check(E e) {
        for (E element : elements) {
            if (element.equals(e)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        List<E> element = elements;
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                if (element.size() > index){
                    return element.get(index) != null ? true : false;
                } else {
                    throw new IndexOutOfBoundsException();
                }

            }

            @Override
            public E next() {
                if (hasNext()){
                    return (E) element.get(index++);
                }
                return null;
            }
        };
    }
}
