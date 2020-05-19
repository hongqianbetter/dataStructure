package com.eleven.datastructure;

public class UnionFind1 implements UF {

    private int[] id;

    public UnionFind1(int size){
        id=new int[size];

        for (int i=0;i<id.length;i++){
            id[i]=i; //每个元素所属不同集合
        }
    }


    @Override
    public boolean isConnected(int p, int q) {
        return find(p)==find(q);
    }

    @Override
    public void unionElements(int p, int q) {
             int pID=find(p);
             int qID=find(p);

             if(pID==qID) {
                 return;
             }

             for (int i=0;i<id.length;i++){
                  if(id[i]==qID) {
                      id[i]=pID;
                  }

             }

    }

    private int find(int p){
        if(p<0&&p>=id.length) {
            throw new IllegalArgumentException("p is out of bound");
        }
        return id[p];
    }



    @Override
    public int getSize() {
        return id.length;
    }
}
