package ru.job4j.Set;

import ru.job4j.List.NodeList;

public class SimpleSetList<E> {
    NodeList<E> elements = new NodeList<>();

    public void add(E e) {
        if (!elements.hasDuplicate(e)) {
            elements.add(e);
        }
    }
}
