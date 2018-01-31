package ru.job4j.List;

public class ListCyclical<E> {
    public boolean hasCycle(Node<E> one, int lenght) {
        Node<E> element = one;
        Node<E> nextElement = one.next;
        int indexStep = 1;
        for (int index = 0; index < lenght; index++) {
            for (int i = 0; i < indexStep; i++) {
                if (element.element.equals(nextElement.element)) {
                    return true;
                } else {
                    element = element.next;
                }
            }
            element = one;
            nextElement = nextElement.next;
            indexStep++;
        }
        return false;
    }
}
