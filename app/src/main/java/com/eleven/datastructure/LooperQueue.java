package com.eleven.datastructure;

public class LooperQueue<E> implements Queue<E> {
    private E data[];
    private int front;
    private int tail;
    int size;

    public LooperQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LooperQueue() {
        this(10);
    }

    @Override
    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public boolean isEmpty() {
//        return size==0;
        return front == tail; //tail 代表即将添加的元素的位置
    }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front) //队列是满的
            //扩容
            resize(getCapacity() * 2);

        data[tail] = e;
        tail=(tail+1)%data.length;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[((front + i) % data.length)];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public E dequeue() {
        if (isEmpty())
              throw new IllegalStateException("can not dequeue fron an empty queue");
            E ret = data[front];
            data[front]=null;
            front=(front+1)%data.length;
            size--;
            if(size==getCapacity()/4&& getCapacity()/2!=0) {
                resize(getCapacity()/2);
            }
            return  ret;
    }

    @Override
    public E getFront() {

        return null;
    }
}
