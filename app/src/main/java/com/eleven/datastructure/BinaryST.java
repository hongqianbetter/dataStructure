package com.eleven.datastructure;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.Queue;

public class BinaryST<E extends Comparable<E>> {
    private Node root;
    private int size;


    public void add(E e) {
//        if (root == null) {
//            root = new Node(e);
//            size++;
//        } else {
//            add(root, e);
//        }
        root=add(root,e);


    }

    private Node add(Node node, E e) {
          if(node==null) {
              size++;
              return new Node(e);
          }
          if(e.compareTo(node.e)<0) {
              node.left=add(node.left,e);
          }else if(e.compareTo(node.e)>0) {
              node.right=add(node.right,e);
          }
          return node;
    }

    public boolean contains(E e){
      return   contains(root,e);
    }

    private boolean contains(Node node, E e) {
        if(node==null) {
            return false;
        }
        if(e.compareTo(node.e)==0) {
            return true;
        }else if(e.compareTo(node.e)<0) {
           return contains(node.left,e);
        }else {
            return contains(node.right,e);
        }
    }

    //前序遍历
    public void preOrder(){
         preOrder(root);
    }

    private void preOrder(Node node) {
         if(node==null) {
             return;
         }
         System.out.println(node.e+"--------");
         preOrder(node.left);
         preOrder(node.right);
    }

    private void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node) {
        if(node==null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e+"--------");
        inOrder(node.right);
    }

    private void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node) {
        if(node==null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e+"--------");
    }
    
    //寻找二分搜索树的最小值
    public E minimum(){
        if(size==0) {
            throw new IllegalStateException("the tree is empty");
        }
       return minimum(root).e;
    }

    private Node minimum(Node node) {
        if(node.left==null) {
            return node;
        }
      return   minimum(node.left);
    }

    //寻找二分搜索树的最大值
    public E maxmum(){
        if(size==0) {
            throw new IllegalStateException("the tree is empty");
        }
        return maxmum(root).e;
    }

    private Node maxmum(Node node) {
        if(node.right==null) {
            return node;
        }
        return   maxmum(node.right);
    }

    //二叉树层序遍历
    public void levelOrder(){
        Queue<Node> queue=new java.util.LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node cur = queue.remove();

            System.out.println(cur.e+"---------");
            if(cur.left!=null) {
                queue.add(cur.left);
            }
            if(cur.right!=null) {
                queue.add(cur.right);
            }

        }


    }


//         private void add(Node node,E e){
//             if(node.e.equals(e)) {
//                 return;
//             }
//
//             if(node.e.compareTo(e)>0 && node.left==null) {
//                   node.left=new Node(e);
//                   size++;
//                   return;
//             }else if(node.e.compareTo(e)<0 && node.right==null) {
//                 node.right = new Node(e);
//                 size++;
//                 return;
//             }
//
//             if(e.compareTo(node.e)>0) {
//                 add(node.right,e);
//             }else {
//                 add(node.left,e);
//             }
//
//         }


    public BinaryST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }


    public E removeMin(){
        E ret = minimum();
       root=removeMin(root);
        return ret;
    }

    private Node removeMin(Node node) {
        if(node.left==null) {
                Node right = node.right;
                node.right=null;
                size--;
                return right;
        }
       node.left=removeMin(node.left);
        return node;
    }

    public void remove(E e){
        root=remove(root,e);
    }

    private Node remove(Node node, E e) {
        if (node==null){
            return null;
        }
            if(e.compareTo(node.e)<0) {
               node.left=remove(node.left,e);
                return node;
            }else if(e.compareTo(node.e)>0){
             node.right=remove(node.right,e);
             return node;
            }else { //相等
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

               Node successor = minimum(node.right);
                successor.right = removeMin(node.right);
                 successor.left=node.left;
                 node.left=node.right=null;
                 return successor;
            }
    }


    public E removeMax(){
        E ret = maxmum();
        root=removeMax(root);
        return ret;
    }

    private Node removeMax(Node node) {
        if(node.right==null) {
            Node left = node.left;
            node.left=null;
            size--;
            return left;
        }
        node.right=removeMin(node.right);
        return node;
    }
}
