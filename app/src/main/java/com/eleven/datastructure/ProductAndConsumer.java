package com.eleven.datastructure;

public class ProductAndConsumer {


    public static void main(String []args){
        Clerk clerk = new Clerk();

        new Thread(new Productor(clerk),"t1").start();
        new Thread(new Consumer(clerk),"t2").start();
    }
}

class Clerk {
    private int product=0;
        //  进货
    public synchronized   void get(){
        if(product>=10) {
            System.out.println("产品已满");
        }else {
            product++;
            System.out.println(Thread.currentThread().getName()+"生产了" +
                    ":"+product);
        }
    }

    //卖货
    public synchronized void sale(){
        if(product<=0) {
            System.out.println("缺货");
        }else {
            System.out.println(Thread.currentThread().getName()+"消费了" +
                    ":"+product--);
        }
    }
}


class Productor implements Runnable{
    private Clerk clerk;

    public Productor(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i=1;i<=20;i++){
            clerk.get();
        }
    }
}

class Consumer implements Runnable{
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i=1;i<=20;i++){
            clerk.sale();
        }
    }
}
