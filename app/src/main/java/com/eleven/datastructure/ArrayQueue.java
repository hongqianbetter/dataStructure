package com.eleven.datastructure;

public class ArrayQueue<E> implements Queue<E> {
    private Array<E> array;

    public ArrayQueue(int capacity) {
        array=new Array<>(capacity);
    }
    public ArrayQueue() {
        array=new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override //入队操作比较多 队尾
    public void enqueue(E e) {
       array.addLast(e);
    }

    @Override  //出队操作比较少
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.get(0);
    }
}
