package com.study.java.thread;

/**
 * Created by YLS on 2017/5/30.
 */
public class Tread1 extends Thread {
    private String name = "";
    public Tread1(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            if (i == 20)
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            System.out.println(this.name+" run----"+i);
        }
    }
}
