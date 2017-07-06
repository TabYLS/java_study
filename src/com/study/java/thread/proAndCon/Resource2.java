package com.study.java.thread.proAndCon;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by YLS on 2017/6/1.
 */
public class Resource2 {

    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private String name;
    private int cout;
    private boolean flag = false;

    public void set(String name){
        lock.lock();
        try {
            if (flag) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.name = name + "-----" + cout++;
            System.out.println(Thread.currentThread().getName() + ".....生产者....." + this.name);
            flag = true;
            condition.signal();
        } finally {
            lock.unlock();
        }

    }

    public void out(){
        lock.lock();
        try {
            if (!flag){
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + ".....消费者........................" + this.name);
            condition.signal();
            flag = false;
        } finally {
            lock.unlock();
        }

    }
}
