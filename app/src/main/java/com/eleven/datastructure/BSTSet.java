package com.eleven.datastructure;

public class BSTSet<E extends Comparable<E>> implements Set<E> {
     BinaryST<E> bst;
    public BSTSet() {
        bst=new BinaryST<>();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
          bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
