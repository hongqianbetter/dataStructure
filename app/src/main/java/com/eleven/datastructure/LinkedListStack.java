package com.eleven.datastructure;

public class LinkedListStack<E> implements Stack<E> {

    private final LinkedList2<E> linkedList;

    public LinkedListStack() {
        linkedList = new LinkedList2<>();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public E pop() {
        return linkedList.remove(0);
    }

    @Override
    public E peek() {
        return linkedList.get(0);
    }

    @Override
    public void push(E e) {
        linkedList.add(0,e);
    }


}
