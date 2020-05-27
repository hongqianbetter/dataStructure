package com.eleven.datastructure;

import java.util.TreeMap;

public class HashTable<K,V> {

    private static final int UpperTol=10;
    private static final int LowerTol=2;
    private static final int InitCapacity=7;

    private TreeMap<K,V>[] hashtable;
    private int M;
    private int size;

    public HashTable(int m) {
        M = m;
        size=0;
        hashtable=new TreeMap[M];
    }

    public HashTable() {
        this(InitCapacity);
    }

    private int hash(K key){
        return key.hashCode()&0x7ffffff%M;
    }

    public int getSize(){
        return size;
    }

    public void add(K key,V value){
        TreeMap<K, V> map = hashtable[hash(key)];
        if(map.containsKey(key)) {
            map.put(key,value);
        }else {
            map.put(key,value);
            size++;
            if(size>=UpperTol*M) {  //size*M>UpperTol
                resize(2*M);
            }
        }
    }

    public void set(K key,V value){
        TreeMap<K, V> map = hashtable[hash(key)];
        if(map.containsKey(key)) {
            map.put(key,value);
        }else {
            throw new IllegalArgumentException(key +"does not exit");
        }
    }

    public V remove(K key){
        TreeMap<K, V> map = hashtable[hash(key)];
        V ret=null;
        if(map.containsKey(key)) {
           ret= map.remove(key);
            size--;
            if(size<LowerTol*M&& M/2>=InitCapacity) {  //size*M>UpperTol
                resize(M/2);
            }
        }
        return ret;
    }

    public boolean contains(K key){
        return hashtable[hash(key)].containsKey(key);

    }

    public void resize(int newCapacity){
        TreeMap<K,V>[] maps = new TreeMap[newCapacity];
        for (int i=0;i<maps.length;i++){
            maps[i]=new TreeMap();
        }
        int oldM=M;
        this.M=newCapacity;
        for (int i=0;i<oldM;i++){
            TreeMap<K, V> map = hashtable[i];
            for (K key:map.keySet()){
                maps[hash(key)].put(key,map.get(key));
            }
        }
    }
}
