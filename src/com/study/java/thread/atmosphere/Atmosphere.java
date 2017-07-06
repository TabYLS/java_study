package com.study.java.thread.atmosphere;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by YLS on 2017/6/5.
 */
public class Atmosphere {

    /*温度*/
    private String temperature;
    /*湿度*/
    private String humidity;
    /*风速*/
    private String windSpeed;
    
    public final ReentrantLock lock = new ReentrantLock();
    Condition sensor = lock.newCondition();
    Condition computer = lock.newCondition();

    public Atmosphere(String temperature, String humidity, String windSpeed){
        this.temperature = temperature;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
    }
    
    public void setData(String temperature, String humidity, String windSpeed){
    	this.temperature = temperature;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
    }
    
    public String getDataBySensor(){
    	lock.lock();
    	String result = "Atmosphere [temperature=" + temperature + ", humidity="
				+ humidity + ", windSpeed=" + windSpeed + "]";
    	lock.unlock();
    	return result;
    }

	@Override
	public String toString() {
		return "Atmosphere [temperature=" + temperature + ", humidity="
				+ humidity + ", windSpeed=" + windSpeed + "]";
	}

}
