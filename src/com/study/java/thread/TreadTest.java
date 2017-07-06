package com.study.java.thread;

/**
 * Created by YLS on 2017/5/30.
 */
public class TreadTest {



    public static void main(String[] args) {

        Tread1 thread1 = new Tread1("one");
        Tread1 thread2 = new Tread1("two");

        thread1.start();
        thread2.start();

       for (int i = 0; i < 1000; i++) {
           System.out.println("mian run---"+i+"..........线程一："+thread1.isAlive()+".........线程二："+thread2.isAlive());
        }
    }
}
