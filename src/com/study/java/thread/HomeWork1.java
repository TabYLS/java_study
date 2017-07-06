package com.study.java.thread;

import org.junit.Test;

/**
 * Created by YLS on 2017/5/30.
 *
 *
 * 需求：简单的卖票程序。
 * 多个窗口同时买票。
 */
public class HomeWork1 {

    /**
     * 检测继承的方式
     */
    @Test
    public void testTickt1() {
        Ticket1 t1 = new Ticket1();
        Ticket1 t2 = new Ticket1();
        Ticket1 t3 = new Ticket1();
        Ticket1 t4 = new Ticket1();

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

    /**
     * 检测实现Runnable的方式
     */
    @Test
    public void testTicket2(){
        Ticket2 ticket = new Ticket2();

        Thread t1 = new Thread(ticket);
        Thread t2 = new Thread(ticket);
        Thread t3 = new Thread(ticket);
        Thread t4 = new Thread(ticket);

        t1.start();
        t2.start();
        t3.start();
        t4.start();


    }

}

class Ticket1 extends Thread {
    private static int tickt = 100;//应该设置成静态资源；所有的对象共享一百张票

    @Override
    public void run() {
        while (true){
            if (tickt >0)
                System.out.println(this.getName()+" sale: "+ tickt--);
            else
                System.exit(0);
        }
    }
}

class Ticket2 implements Runnable {//适合多个线程共享一个资源
    private int tickt = 100;//这里不用设置成static，也是表示所有对象共用一百张票

    @Override
    public void run() {
//        System.out.println("df");
        while (true){
            if (tickt >0)
                System.out.println(Thread.currentThread().getName()+" sale: "+ tickt--);
            else
                System.exit(0);
        }
    }
}