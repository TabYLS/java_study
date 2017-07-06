package com.study.java.reflect.singleton;
/**
 *
 * @author 叶林生
 *
 * @date 2017年6月20日 下午5:44:33
 *
 * @version 1.0
 * 
 */
public class SingletonAvoidAttachByReflect {
	
	private static boolean flag = false;
	private static SingletonAvoidAttachByReflect singleton = new SingletonAvoidAttachByReflect();
	
	private SingletonAvoidAttachByReflect(){
		if (!flag) {
			flag = true;
		} else {
			throw new RuntimeException("单利禁止多次创建对象");
		}
	}
	
	public static SingletonAvoidAttachByReflect getInstance(){
		return singleton;
	}

}
