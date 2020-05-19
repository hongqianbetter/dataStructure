package com.eleven.datastructure;

public class UnionFind2 implements UF {
    private int[] parent;

    public UnionFind2(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i; //各个元素之间木有链接关系 且 value 代表 自己指向的父元素的下标
            //一开始各个元素的value都是自己 也就是说各个元素刚开始都指向自己
        }


    }

    private int find(int p) { //p代表节点 这里指数组的第几个元素 而value代表此元素指向的父元素
        if (p < 0 && p >= parent.length) {
            throw new IllegalArgumentException("p is out of bound");
        }
        while (p != parent[p]) { //如果不指向自己
            p = parent[p];
        }
        return p;
    }

    //查看元素p和元素q是否所属同一个集合
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q); //判断
    }

    //合并元素p和元素q是否所属一个集合
    //O(h) 复杂度,h为树的高度
    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        parent[pRoot] = qRoot;
    }

    @Override
    public int getSize() {
        return 0;
    }
}