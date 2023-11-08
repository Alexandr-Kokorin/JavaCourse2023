package edu.hw3.task8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BackwardIterator<T> implements Iterator<T> {

    private final List<T> list;
    private int index;

    public BackwardIterator(List<T> list) {
        this.list = new ArrayList<>(list);
        index = list.size() - 1;
    }

    @Override
    public boolean hasNext() {
        return index >= 0;
    }

    @Override
    public T next() {
        T temp = list.get(index);
        remove();
        return temp;
    }

    @Override
    public void remove() {
        index--;
    }
}
