package com.study.java.thread.cave;

/**
 * Created by YLS on 2017/6/4.
 */
public class Referee implements Runnable {

    private Cave cave;
    public Referee(Cave cave){
        this.cave = cave;
    }
    @Override
    public void run() {
        cave.readyGo();
    }
}
