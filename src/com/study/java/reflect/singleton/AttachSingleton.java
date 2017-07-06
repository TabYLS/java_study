package com.study.java.reflect.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

/**
 *
 * @author 叶林生
 *
 * @date 2017年6月20日 下午4:37:15
 *
 * @version 1.0
 * 
 * 利用反射攻击单利设计模式
 */
public class AttachSingleton {
	
	public static void main(String[] args) {
		Singleton singleton1 = Singleton.getInstance();
		Singleton singleton2 = Singleton.getInstance();
		System.out.println(singleton1 == singleton2);
		/*=======================================*/
		//通过反射的方式，取消权限控制调用私有的构造方法
		Class clazz = Singleton.class;
		try {
			Constructor[] constructor = clazz.getDeclaredConstructors();
			constructor[0].setAccessible(true);
			Singleton singleton3 = (Singleton) constructor[0].newInstance();
			System.out.println("================================");
			System.out.println(singleton2 == singleton3);
		} catch (SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	@Test
	public void test(){
		SingletonAvoidAttachByReflect singleton1 = SingletonAvoidAttachByReflect.getInstance();
		SingletonAvoidAttachByReflect singleton2 = SingletonAvoidAttachByReflect.getInstance();
		System.out.println(singleton1 == singleton2);
		/*=======================================*/
		//通过反射的方式，取消权限控制调用私有的构造方法
		Class clazz = SingletonAvoidAttachByReflect.class;
		try {
			Constructor[] constructor = clazz.getDeclaredConstructors();
			constructor[0].setAccessible(true);
			SingletonAvoidAttachByReflect singleton3 = (SingletonAvoidAttachByReflect) constructor[0].newInstance();
			System.out.println("================================");
			System.out.println(singleton2 == singleton3);
		} catch (SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
