package ru.job4j.List;

public class SimpleStack<E> extends NodeList<E> {
    private NodeList<E> listStack = new NodeList<>();
    public E poll(){
        E element = listStack.remove(listStack.size() - 1);
        return element;
    }

    public void push(E value){
        this.listStack.add(value);
    }
}
