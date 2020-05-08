package com.eleven.datastructure;

public class LinkedList2<E> {

    private Node dumpHead;
    private int size;
    public LinkedList2(){
        dumpHead=new Node();
        size=0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty(){
        return  size==0;
    }

    public void addFirst(E e){
      add(0,e);
    }

    public void addLast(E e){
        add(size,e);
    }

    public void add(int index,E e){
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("add Failed,index is not illegal");
        }

        if(index ==0) {
            addFirst(e);
        } else{
          Node prev=dumpHead;
          for (int i =0;i<index;i++){
              prev=prev.next;

                  Node node = new Node(e);
                  node.next=prev.next;
                  prev.next=node;
                  size++;
          }

        }

    }

    public E get(int index){
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("get Failed,index is not illegal");
        }
        Node cur = dumpHead.next;
        for (int i=0;i<index;i++){
            cur = cur.next;
        }
        return cur.e;
    }
    public E getFirst(){
        return get(0);
    }
    public E getLast(){
        return get(size-1);
    }

    public void set(int index,E e){
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("get Failed,index is not illegal");
        }

        Node cur = dumpHead.next;
        for (int i=0;i<index;i++){
            cur = cur.next;
        }
        cur.e=e;
    }

    public boolean contains(E e){
        Node cur = dumpHead.next;
        while (cur!=null){
            if(cur.e.equals(e)) {
                return true;
            }
            cur=cur.next;
        }

        return false;
    }

    public E remove(int index){
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("remove Failed,index is not illegal");
        }
        Node pre= dumpHead.next;
        for (int i=0;i<index-1;i++){
               pre=pre.next;
        }
        Node retNode = pre.next;
        pre.next=retNode.next;
        retNode.next=null;
        size--;
        return retNode.e;

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
}
