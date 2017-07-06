package com.study.thread;

/**
 * Created by YLS on 2017/6/4.
 */
public class Main {

    public static void main(String[] args) {
        Cave cave = new Cave();
        for (int i = 0; i < 10; i++) {
            People people = new People(cave, "张三" + i);
            new Thread(people).start();
        }
        Referee referee = new Referee(cave);
        new Thread(referee).start();

    }
}
