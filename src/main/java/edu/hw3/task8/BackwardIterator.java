package edu.hw3.task8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class BackwardIterator<T> implements Iterator<T>, Iterable<T> {

    private final List<T> list = new ArrayList<>();

    public BackwardIterator(List<T> list) {
        this.list.addAll(list);
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        return list.size() > 0;
    }

    @Override
    public T next() {
        T temp = list.get(list.size() - 1);
        remove();
        return temp;
    }

    @Override
    public void remove() {
        list.remove(list.size() - 1);
    }
}
