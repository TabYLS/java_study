package com.study.java.thread.proAndCon;
/*
package com.study.java.thread.proAndCon;

*/
/**
 * Created by YLS on 2017/6/1.
 *//*

public class Resource3 {

    private String name;
    private int cout;
    private boolean flag = false;

    public synchronized void set(String name){
        if (flag)
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        this.name = name + "-----" + cout++;
        System.out.println(Thread.currentThread().getName() + ".....生产者....." + this.name);
        flag = true;
        this.notify();
    }

    public synchronized void out(){
        if (!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + ".....消费者....." + this.name);
        this.notify();
        flag = false;
    }
}
*/
