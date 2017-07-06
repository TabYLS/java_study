package com.study.java.reflect.singleton;
/**
 *
 * @author 叶林生
 *
 * @date 2017年6月20日 下午4:35:30
 *
 * @version 1.0
 * 
 */
public class Singleton {
	
	private static Singleton singleton = new Singleton();
	
	private Singleton(){}
	
	public static Singleton getInstance(){
		return singleton;
	}

}
