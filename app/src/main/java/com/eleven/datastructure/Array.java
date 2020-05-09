package com.eleven.datastructure;

import java.util.Arrays;

public class Array<E> {
    private E[] data;
    private int size; //长度 也可代表即将添加的索引

    public Array(int capacity) {
        this.data = (E[]) new Object[capacity];
        size=0;
    }

    public Array() {
        this(10);
    }


    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void addLast(E e){
        add(size,e);
    }

    private void addFirst(E e) {
       add(0,e);
    }

    //在第index位置,插入元素e
    public void add(int index,E e){

        if(index < 0 || index > size) {
            throw new IllegalArgumentException("Add Failed,index is not in Range");
        }
        if(size==data.length) {
           resize(2*data.length);
        }
        for (int i=size-1;i>=index;i--){
            data[i+1]=data[i];
        }
        data[index]=e;
        size++;
    }

    private void resize(int newCapacity) {
      E[] newData= (E[]) new Object[newCapacity];
      for (int i=0;i<size;i++){
          newData[i]=data[i];
      }
      data=newData;
    }


    public E remove(int index){

        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("remove Failed,index is not illegal");
        }
        E ret=data[index];
        for (int i=index+1;i<size;i++){
            data[i-1]=data[i];
        }

        data[size-1]=null;
        size--;
        if(size==data.length/4&&data.length/2!=0) {
            resize(data.length/2);
        }
        return ret;
    }

    public E removeFirst(){
        return remove(0);
    }
    public E removeLast(){
        return remove(size-1);
    }

    public void removeElement(E e){
        int index = find(e);
        if(index!=-1) {
            remove(index);
        }
    }

    public E get(int index){
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("get Failed,index is illegal");
        }
        return data[index];
    }

    public void set(int index,E e){
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("set Failed,index is illegal");
        }
         data[index]=e;
    }

    public boolean contains(E e){
        for (int i=0;i<size;i++){
            if (data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    public int find(E e){
        for (int i=0;i<size;i++){
            if (data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
//        return "Array{" +
//                "data=" + Arrays.toString(data) +
//                ", size=" + size +
//                '}';
        StringBuilder builder = new StringBuilder();
        for (int i=0;i<size;i++){
            builder.append(data[i]+",");
        }
        return builder.toString();
    }
}
