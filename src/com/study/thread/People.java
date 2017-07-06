package com.study.thread;

/**
 * Created by YLS on 2017/6/4.
 */
public class People implements Runnable {

    private String name;
    private Cave cave;
    public People(Cave cave,String name){
        this.name = name;
        this.cave = cave;
    }

    @Override
    public void run() {
        cave.through(this.name);
    }
}
