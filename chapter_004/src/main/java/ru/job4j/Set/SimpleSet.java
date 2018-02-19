package ru.job4j.Set;


import ru.job4j.List.Container;

public class SimpleSet<E> {
    Container container = new Container();

    public void add(E e) {
        if (!container.hasDuplicate(e)) {
            container.add(e);
        }
    }
}
