package com.eleven.datastructure;

import java.security.Permission;
import java.security.acl.NotOwnerException;

public class LinkLedListMap<K,V> implements Map<K,V> {

 private Node dummyHead;
private int Size;

    public LinkLedListMap() {
        dummyHead=new Node( );
        Size=0;
    }

    @Override  //相当于put
    public void add(K key, V value) {
        Node node = getNode(key);
        if(node==null) { //在链表头添加
            dummyHead.next=new Node(key,value,dummyHead.next);
            Size++;
        }else {
              node.value=value;
        }
    }

    @Override
    public V remove(K key) {
        Node prev = this.dummyHead;
        while (prev.next!=null){
            if(prev.next.key.equals(key)) {
                break;
            }
            prev=prev.next;
        }
        if(prev.next!=null) {
            Node delNode = prev.next;
            prev.next= delNode.next;
            delNode.next=null;
            Size--;
            return delNode.value;
        }
        return null;

    }

    @Override
    public boolean contains(K key) {
        return get(key)!=null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node!=null?node.value:null;
    }

    private Node getNode(K key) {
        Node cur = dummyHead.next;
        while (cur!=null){
            if(cur.key.equals(key)) {
                return cur;
            }
            cur=cur.next;
        }

        return null;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);
        if(node==null) {
            throw new  IllegalArgumentException(key+"doessnot exist！");
        }else {
            node.value=newValue;
        }
    }

    @Override
    public int getSize() {
        return Size;
    }

    @Override
    public boolean isEmpty() {
        return Size==0;
    }


    private class Node{
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Node() {
        }
    }
}
