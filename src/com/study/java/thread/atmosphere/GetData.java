package com.study.java.thread.atmosphere;

import java.util.concurrent.TimeUnit;

/**
 * Created by YLS on 2017/6/5. 
 * 2、编写线程同步模拟应用程序： (1) 大气环境数据为：温度，湿度，风速。 (2)
 * 一个大气环境传感器测量环境数据需要5秒时间。 (3) 一个计算机读取传感器的环境数据需要0.01秒时间。
 * 模拟一个计算机读取大气环境传感器的读取的随机的温度，湿度和风速的100次。
 * 
 * 思路：电脑可以一直从传感器中读取数据，但是传感器只能每5秒取一次数据，所以当传感器等待时间到了之后就应该让电脑暂时放弃cpu，让传感器去读取大气的数据
 */
public class GetData {

	public static void main(String[] args) {
		Atmosphere atmosphere = new Atmosphere("28", "18.0", "7");
		
		Sensor sensor = new Sensor(atmosphere);
		Thread sensor_thread = new Thread(sensor);
		Thread computer_thread = new Thread(new Computer(atmosphere, sensor, sensor_thread));
		sensor_thread.start();
		computer_thread.start();
	}

}

class Sensor implements Runnable {
	private Atmosphere atmosphere;
	private int count = 0;
	
	public Sensor(Atmosphere atmosphere) {
		this.atmosphere = atmosphere;
	}

	@Override
	public void run() {
		while(true){
			this.atmosphere.lock.lock();
			try {
				this.atmosphere.sensor.await(1, TimeUnit.SECONDS);
				
				this.atmosphere.setData(String.valueOf(28 + Math.random()), String.valueOf(18.0 + Math.random()), String.valueOf(7 + Math.random()));
				System.out.println("传感器第"+ count++ +"次从大气中获取数据。。。。。" + this.atmosphere.toString());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				this.atmosphere.lock.unlock();
			}
		}
	}

	public String getData() {
		// TODO Auto-generated method stub
		return atmosphere.toString();
	}
}

class Computer implements Runnable {
	
	private Atmosphere atmosphere;
	private Sensor sensor;
	private Thread thread;
	
	public Computer(Atmosphere atmosphere, Sensor sensor, Thread thread) {                                            
		this.atmosphere = atmosphere;                                                             
		this.sensor = sensor;
		this.thread = thread;
	}                                                       
                                                            
	@Override                                               
	public void run() {
		int i = 0;
		//for (int i = 0; i < 10000; i++) {
		while(true) {
			this.atmosphere.lock.lock();
			try {
				if (!this.thread.getState().equals(Thread.State.TIMED_WAITING)) {//TIMED_WAITING具有指定等待时间的某一等待线程的线程状态。
					this.atmosphere.computer.await(3, TimeUnit.MILLISECONDS);//如果传感器等待的时间到了，则当前的线程先等待一下让传感器先取时间
				}
				this.atmosphere.computer.await(10,TimeUnit. MILLISECONDS);//0.01秒取一次数据
				System.out.println("computer " + i++ + " get data from sensor........" + sensor.getData());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				this.atmosphere.lock.unlock();
			}
			
		}

	}
}
