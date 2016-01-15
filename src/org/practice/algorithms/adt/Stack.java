package org.practice.algorithms.adt;

public interface Stack<T> {
    void push(T item);
    T pop();
    T peek();

    int size();
    boolean isFull();
    boolean isEmpty();
}
