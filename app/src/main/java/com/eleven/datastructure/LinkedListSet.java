package com.eleven.datastructure;

import java.util.Objects;

public class LinkedListSet<E> implements Set<E> {
   LinkedList2<E> list;
    public LinkedListSet() {
        list=new LinkedList2<>();
    }

    @Override
    public void add(E e) {
        if(!list.contains(e)) {
            list.addFirst(e);
        }

    }

    @Override
    public void remove(E e) {
        list.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
