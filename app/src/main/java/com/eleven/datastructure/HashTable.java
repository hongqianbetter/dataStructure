package com.eleven.datastructure;

import java.util.TreeMap;

public class HashTable<K,V> {

    private TreeMap<K,V>[] hashtable;
    private int M;
    private int size;

    public HashTable(int m) {
        M = m;
        size=0;
        hashtable=new TreeMap[M];
    }

    public HashTable() {
        this(97);
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
        }
        return ret;
    }

    public boolean contains(K key){
        return hashtable[hash(key)].containsKey(key);

    }
}
