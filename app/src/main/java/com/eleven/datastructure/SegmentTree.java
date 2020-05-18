package com.eleven.datastructure;

import java.util.PropertyResourceBundle;

public class SegmentTree<E> {
    private E[] data;
    private E[] tree;
    private Merge<E> merge;

    public SegmentTree(E[] arr, Merge<E> merge) {
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        tree = (E[]) new Object[data.length * 4];

        this.merge = merge;

        buildSegemntTree(0, 0, data.length - 1);
    }

    private void buildSegemntTree(int treeIndex, int l, int r) {
        if (l == r) {
            tree[treeIndex] = data[l];
            return;
        }
        int leftIndex = leftChild(treeIndex);
        int rightIndex = rightChild(treeIndex);
        int mid = (l + (r - l) / 2);

        buildSegemntTree(leftIndex, l, mid);
        buildSegemntTree(rightIndex, mid + 1, r); //以求和为例
        if (merge != null) {
            tree[treeIndex] = merge.merge(tree[leftIndex], tree[rightIndex]);
        }

    }

    public E query(int queryL,int queryR){
        if(queryL<0 || queryL>=data.length ||queryR<0 || queryR<queryL || queryR>=data.length) {
            throw new IllegalArgumentException("index is not illegal");
        }

        return query(0,0,data.length-1,queryL,queryR);
    }

    //在以treeID为根的线段树中[l...r] 搜索区间[queryL，queryR]的值
    private E query(int treeIndex, int l, int r, int queryL, int queryR) {

        if(l==queryL && r == queryR) {
            return tree[treeIndex]; //区间是通过 /2 这种方式计算的
        }
        int mid=l+(r-l)/2;

        int leftIndex=leftChild(treeIndex);
        int rightIndex=rightChild(treeIndex);

        if(queryL>mid+1) {
            return query(rightIndex,mid+1,r,queryL,queryR);
        }else if(queryR<=mid) {
            return query(leftIndex,l,mid,queryL,queryR);
        }else {
           E leftResult= query(leftIndex,l,mid,queryL,mid);
           E rightResult= query(rightIndex,mid+1,r,mid+1,queryR);
           return   merge.merge(leftResult,rightResult);
        }

    }

    public void set(int index,E e){
        if(index<0 || index>=data.length ) {
            throw new IllegalArgumentException("index is not illegal");
        }
        data[index]=e;
        set(0,0,index,data.length-1,e);
    }

    //在以treeIndex为根的线段树中更新index的值为e
    public void set(int treeIndex,int l,int r,int index,E e){
          if(l==r) {
              tree[treeIndex]=e;
              return ;
          }
        int mid=l+(r-l)/2;
        int leftIndex=leftChild(treeIndex);
        int rightIndex=rightChild(treeIndex);
        
        if(index>=mid+1) {
            set(rightIndex,mid+1,r,index,e);
        }else {
            set(leftIndex,0,mid,index,e);
        }

        tree[treeIndex]=merge.merge(tree[leftIndex],tree[rightIndex]);

    }


    public E get(int index) {
        if (index < 0 || index > data.length) {
            throw new IllegalArgumentException("get Failed,index is illegal");
        }
        return data[index];
    }

    //返回完全二叉树的数组表示中,一个索引所表示的元素的左孩子的索引
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    //返回完全二叉树的数组表示中,一个索引所表示的元素的右孩子的索引
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    public int getSize() {
        return data.length;
    }


}
