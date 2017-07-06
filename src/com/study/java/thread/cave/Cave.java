package com.study.java.thread.cave;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by YLS on 2017/6/4.
 */
public class Cave {
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private final Condition condition1 = lock.newCondition();

    public void through(String name){
        lock.lock();
        try {
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(Thread.currentThread().getName() + "......"+ name +"....穿过山洞。。。。。。。");
        } finally {
            lock.unlock();
        }
    }

    public void readyGo() {
        lock.lock();
        try {
            condition.signalAll();
        } finally {
            lock.unlock();
        }

    }
}
