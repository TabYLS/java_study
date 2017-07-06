package com.study.java.thread.cave;

/**
 * Created by YLS on 2017/6/4.
 * 
 * 1、编写多线程应用程序，模拟多个人通过一个山洞。这个山洞每次只能通过一个人，每个人通过山洞的时间为5秒，随机生成10个人，同时准备过此山洞，
 * 显示一下每次通过山洞人的姓名。
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
