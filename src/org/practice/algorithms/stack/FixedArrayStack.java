package org.practice.algorithms.stack;

import org.practice.algorithms.adt.Stack;

import java.util.NoSuchElementException;

public class FixedArrayStack<T> implements Stack<T> {
    private T[] items;
    int top;

    @SuppressWarnings("unchecked")
    public FixedArrayStack(int size) {
        items = (T[])new Object[size];
        top = 0;
    }

    @Override
    public void push(T item) {
        if (size() == capacity()) {
            throw new IllegalStateException("Stack overflow");
        }
        items[top++] = item;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        T element = items[top - 1];
        items[top - 1] = null;
        top--;
        return element;
    }

    @Override
    public T peek() {
        if (items[0] == null) {
            throw new NoSuchElementException();
        }

        return items[top - 1];
    }

    @Override
    public int size() {
        return top;
    }

    @Override
    public boolean isFull() {
        return size() == capacity();
    }

    private int capacity() { return items.length;
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    public static void main(String[] args) {
        Stack<String> stack = new FixedArrayStack<>(8);
        assert stack.isEmpty() : "New stack must be empty";

        stack.push("Johny");
        stack.push("Manny");
        assert stack.size() == 2;
        assert !stack.isEmpty();

        assert stack.pop().equals("Manny");
        assert stack.size() == 1;
        assert !stack.isEmpty();

        assert stack.peek().equals("Johny");
        assert stack.size() == 1;

        assert stack.pop().equals("Johny");
        assert stack.size() == 0;
        assert stack.isEmpty();

        stack.push("Tommy");
        assert stack.size() == 1;
        assert stack.pop().equals("Tommy");
    }
}
