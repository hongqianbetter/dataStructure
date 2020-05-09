package com.eleven.datastructure;

public class ArrayStack<E> implements Stack<E> {
    private Array<E> array;
    public ArrayStack() {
        array=new Array<>();
    }

    public ArrayStack(int capacity) {
        array=new Array<>(capacity);
    }


    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(E e) {
        array.addLast(e);

    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.get(array.getSize()-1);
    }


    public int getCapacity(){
        return array.getCapacity();
    }
}
