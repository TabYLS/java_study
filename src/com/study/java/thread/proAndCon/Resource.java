package com.study.java.thread.proAndCon;

/**
 * Created by YLS on 2017/6/1.
 */
public class Resource {

    private String name;
    private int cout;
    private boolean flag = false;

    public synchronized void set(String name){
        while (flag)
            try {
                this.wait();//当两个己方线程都在wait状态的时候，己方唤醒的可能是自己的线程因此要用while来判断，此时就要把notify改成notifyAll
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        this.name = name + "-----" + cout++;
        System.out.println(Thread.currentThread().getName() + ".....生产者....." + this.name);
        flag = true;
        this.notifyAll();
    }

    public synchronized void out(){
        while (!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + ".....消费者........................" + this.name);
        this.notifyAll();
        flag = false;
    }
}
