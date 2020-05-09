package com.eleven.datastructure;

public class LinkedListQueue<E> implements Queue<E> {
    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    //尾部进行添加操作
    @Override
    public void enqueue(E e) {
           if(tail==null) {
               tail=new Node(e);
               head=tail;
           }else {
               tail.next=new Node(e);
               tail=tail.next;
           }
           size++;
    }

    @Override //头部进行出队
    public E dequeue() {
        if(isEmpty()) {
            throw new IllegalArgumentException("------");
        }
        Node retNode = this.head;
        head=head.next;
        retNode.next=null;
        if(head==null) {
            tail=null;
        }
        size--;
        return retNode.e;
    }

    @Override
    public E getFront() {
        if(isEmpty()) {
            throw new IllegalArgumentException("------");
        }
        return head.e;
    }


    private class Node{
        public E e;
        public  Node next;


        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e,null);
        }
        public Node(){

        }
    }

    private Node head,tail;
    private int size;

    public LinkedListQueue() {
        head=tail=null;
        size=0;
    }
}
