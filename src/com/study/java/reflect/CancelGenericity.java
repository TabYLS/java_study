package com.study.java.reflect;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.junit.Test;

/**
 *
 * @author 叶林生
 *
 * @date 2017年6月20日 上午11:23:41
 *
 * @version 1.0
 * 
 */
public class CancelGenericity {
	
	public static void main(String[] args) throws Exception {
		ArrayList<String> strings = new ArrayList<String>();
		strings.add("我来破坏泛型！！！");
		Class clazz = ArrayList.class;
		//返回一个 Method 对象，但是这里的方法是本类申明的方法，所谓申明就是自己本身申明的方法，从父类继承过来的就不算
		//Method method = clazz.getDeclaredMethod("add", new Class[]{int.class});
		//返回一个 Method 对象，这里返回的是所有的公共成员方法，包括从父类集成过来的
		Method method = clazz.getMethod("add", new Class[]{Object.class});
		//通过反射调用方法
		method.invoke(strings, new Object[]{11});
		System.out.println(strings);
	}
	
	@Test
	public void test(){
		//Integer.class 表示的是Integer包装类的Class对象
		//Integer.TYPE 表示的是基本数据类型的Class对象
		//int.class 表示的是基本数据类型的Class对象
		System.out.println(Integer.class == int.class);
		System.out.println(Integer.class == Integer.TYPE);
		System.out.println(Integer.TYPE == int.class);
	}

}
