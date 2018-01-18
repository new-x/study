package ru.job4j.List;

public class SimpleQueue<E> extends NodeList<E> {
    private NodeList<E> listQueue = new NodeList<>();
    public E poll(){
        E element = listQueue.remove(0);
        return element;
    }

    public void push(E value){
        this.listQueue.add(value);
    }
}
