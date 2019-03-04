package com.major.springsource.code;

import java.util.*;

public class Stack<T> {
    private List<T> elements;
    private int size = 0;
    public static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new ArrayList<>(DEFAULT_INITIAL_CAPACITY);
    }

    public void push(T t) {
        ensureCapacity();
        elements.set(size++, t);
    }

    public <T> T pop() {
        if (size == 0) throw new EmptyStackException();
        T t = (T) elements.get(--size);
        elements.set(size,null);
        return t;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (elements.size() == size) {
            List<T> dest= new ArrayList<>(2*size+1);
            Collections.copy(dest,elements);
            elements = dest;
        }
    }

}
