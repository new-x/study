package ru.job4j.Generic;

public class AbstractStore<T extends Base> implements Store<T> {
    private final SimpleArray<T> array;

    private int size;

    public AbstractStore(int size) {
        this.array = new SimpleArray<>(size);
        this.size = size;
    }

    @Override
    public void add(T model) {
        if (model != null) {
            this.array.add(model);
        }
    }

    @Override
    public boolean replace(String id, T model) {
        if (this.array.get(findById(id)) != null) {
            this.array.update(findById(id), model);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        if (this.array.get(findById(id)) != null) {
            this.array.delete(findById(id));
            this.size--;
            return true;
        }
        return false;
    }

    @Override
    public int findById(String id) {
        for (int index = 0; index < size; index++) {
            if (String.valueOf(this.array.get(index)).equals(id)) {
                return index;
            }
        }
        return -1;
    }
}
