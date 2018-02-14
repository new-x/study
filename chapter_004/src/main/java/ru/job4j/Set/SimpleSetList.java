package ru.job4j.Set;

import ru.job4j.List.NodeList;

import java.util.Iterator;

public class SimpleSetList<E> implements SimpleContainer<E> {
    NodeList<E> elements = new NodeList<>();

    @Override
    public void add(E e) {
        if (check(e)) {
            elements.add(e);
        }
    }

    @Override
    public boolean check(E e) {
        for (int index = 0; index < elements.size(); index++) {
            if (elements.get(index).equals(e)) {
                return false;
            }
        }
        return true;
    }


    @Override
    public Iterator<E> iterator() {
        NodeList<E> element = elements;
        return new Iterator<E>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                if (element.size() > index) {
                    return element.get(index) != null ? true : false;
                } else {
                    throw new IndexOutOfBoundsException();
                }

            }

            @Override
            public E next() {
                if (hasNext()) {
                    return (E) element.get(index++);
                }
                return null;
            }
        };
    }
}
