package com.study.java.thread.proAndCon;

/**
 * Created by YLS on 2017/6/1.
 */
public class ProducerConsumer {

    public static void main(String[] args) {
        Resource resource = new Resource();

        /*
        只有两个线程的时候可以使用notify，但是多个的时候应该小心考虑用notify还是notifyAll
        new Thread(new Produce(resource)).start();
        new Thread(new Consumer(resource)).start();*/

        new Thread(new Produce(resource)).start();
        new Thread(new Produce(resource)).start();
        new Thread(new Consumer(resource)).start();
        new Thread(new Consumer(resource)).start();
    }
}

class Produce implements Runnable {

    private Resource resource;

    public Produce(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        while (true) {
            this.resource.set("张三");
        }
    }
}

class Consumer implements Runnable {

    private Resource resource;

    public Consumer(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        while(true) {
            this.resource.out();
        }
    }
}
