package org.practice.algorithms.stack;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.TopLevelAttribute;
import org.practice.algorithms.adt.Stack;

/**
 * Created by kainat on 1/22/2016.
 */
/*New Homework:
        Provide new implementation of Stack<T> called DynamicArrayStack<T>. When item is pushed and stack
        is full, resize the stack to be double its current size.
        When item is popped and stack is 1/4th full, then shrink the stack to be half its current size.

        8 item on stack: on pushing 9th item, stack should be resized to 8 * 2 = 16
        3 item on stack: on pop, before returning if size is 2 itesm (i.e., stack is 1/4th full), helaf the satck: 8/2 = 4.
        */
public class DynamicArrayStack<T> implements Stack<T> {
    private Object[] items;
    int Top;

    public DynamicArrayStack(int size) {
        items = new Object[size];
        Top = 0;
    }

    @Override
    public void push(T item) {
        if (isFull() == true) {
         //   items = GrowStack(items);
            items=ResizingArray(items,items.length);
        }
        items[Top++] = item;
    }

    public Object[] GrowStack(Object[] items) {
        Object[] ReplaceArray = new Object[(items.length*2)];
        for (int i = 0; i < items.length; i++) {
            ReplaceArray[i] = items[i];
        }
        return ReplaceArray;
    }

    public Object[] ResizingArray(Object[] items, int count) {
        Object[] ReplaceArray = new Object[(items.length + count)];
         for (int i = 0; i < items.length; i++) {
            ReplaceArray[i] = items[i];
        }
        return ReplaceArray;
    }

    @Override
    public T pop() {
        if(isEmpty()== true) {
            throw new IllegalStateException("Stack underflow");
        }
        Object ElementSave = items[items.length - 1];
        items[items.length - 1] = null;
        if (Top == ArrayShrinking()) {
          // = ShrinkStack(items);
            items = ResizingArray(items, -(items.length / 2));
        }
        Top--;
        return (T) ElementSave;
    }
     public Object[] ShrinkStack(Object[] items){
         Object[] ReplaceArray = new Object[(items.length/2)];
         for (int i = 0; i < items.length; i++) {
             ReplaceArray[i] = items[i];
         }
         return ReplaceArray;
     }

    public int ArrayShrinking() {
        return items.length / 4;
    }

    @Override
    public boolean isFull() {
        if(size() == capacity()){
            return true;
        }
        return false;
    }

    @Override
    public T peek() {
        if(isEmpty()==true){
            throw new IllegalStateException("Stack underflow");
        }
        return (T) items[(Top-1)];
    }

    @Override
    public int size() {
        return Top;
    }
    @Override
    public boolean isEmpty() {
        if(Top == 0){
            return true;
        }
        return false;
    }

    private int capacity() { return items.length;
    }

    public static void main(String[] args) {
        Stack<Integer> stack =new DynamicArrayStack<>(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        assert stack.size()== 6;
        stack.peek();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        assert stack.size()== 1;

    }
}

