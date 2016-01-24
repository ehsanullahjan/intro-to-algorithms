package org.practice.algorithms.stack;

import org.practice.algorithms.adt.Stack;

public class FixedArrayStack<T> implements Stack<T> {
    @SuppressWarnings("unchecked")
    private Object[] items;
    int count;

    public FixedArrayStack(int size) {
        items = new Object[size];
        count = 0;
    }

    @Override
    public void push(T item) {
        if (count > 7) {
            throw new IllegalStateException("Stack overflow");
        }
        items[count] = item;
        count++;
    }

    @Override
    public T pop() {
        if(items[0]==null){
            throw new IllegalStateException("Stack underflow");
        }
        Object ElementSave = items[items.length - 1];
        items[items.length - 1] = null;
        count--;
        return (T) ElementSave;
    }

    @Override
    public T peek() {
        if(items[0]==null){
           throw new IllegalStateException("Stack underflow");
            }
        return (T) items[items.length - 1];
    }

    @Override
    public int size() {
        return items.length;
    }

    @Override
    public boolean isFull() {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                return true;
            }
        }
        return false;
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

        /*
        if (stack is full) {
            throw new IllegalStateException("Stack overflow");
        }

        ...


        if (stack is empty) {
            throw new IllegalStateException("Stack underflow");
        }

       */
    }
}
