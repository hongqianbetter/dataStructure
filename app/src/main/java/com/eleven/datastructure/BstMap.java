package com.eleven.datastructure;

import org.w3c.dom.Node;

import java.util.IllegalFormatCodePointException;

public class BstMap<K extends Comparable<K>, V> implements Map<K, V> {

    private Node root;
    private int size;

    public BstMap() {
        this.root = null;
        size = 0;
    }

    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    private Node add(Node node, K key, V value) {
        if (node == null) {
            node = new Node(key, value);
            size++;
            return node;
        }
        if (node.key.compareTo(key) > 0) {

            node.right = add(node.right, key, value);
            return node;

        } else if (node.key.compareTo(key) < 0) {
            node.left= add(node.left, key, value);
            return node;
        } else {
            node.value=value;
            return node;
        }
    }

    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if(node!=null) {
            root=remove(root,key);
            return node.value;
        }


        return null;
    }

    private Node remove(Node node,K key){
        if(node==null) {
            return null;
        }
        if(key.compareTo(node.key)<0) {
            node.left=remove(node.left,key);
            return node;
        }else if(key.compareTo(node.key)>0) {
            node.right=remove(node.right,key);
            return node;
        }else  {
            if(node.left==null) {
                Node right = node.right;
                node.right=null;
                size--;
                return right;
            }
            if(node.right==null) {
                Node left = node.left;
                node.left=null;
                size--;
                return left;
            }
            //后继实现
            Node successor=minimum(node);
            successor.right=removeMin(node.right);
            successor.left=node.left;
            node.left=node.right=null;
            return successor;
        }

    }

    private Node minimum(Node node){
        if(node.left==null) {
            return node;
        }
        return minimum(node.left);
    }
    //删除以node为根的二分搜索树的最小节点
    //返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node){
        if(node.left==null) {
            Node right = node.right;
            node.right=null;
            size--;
            return right;
        }
        node.left=removeMin(node.left);
        return node;
    }

    @Override
    public boolean contains(K key) {
        return getNode(root,key)!=null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);

        return node!=null?node.value:null;
    }

    private Node getNode(Node node, K key){
         if(node==null) {
             return null;
         }
         if(key.compareTo(node.key)==0) {
            return node;
         }else if(key.compareTo(node.key)<0) {
          return getNode(node.left,key);
         }else {
             return getNode(node.right,key);
         }
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if(node==null) {
            throw new IllegalArgumentException(key+"doesnot exist!");
        }
        node.value=newValue;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private class Node {
        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
