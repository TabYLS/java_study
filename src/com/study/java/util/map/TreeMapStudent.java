package com.study.java.util.map;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
* @author 叶林生 
* @date：2017年7月3日 下午3:22:57
* @version 1.0
* 
* 先按照年龄为主要条件，后面改成以姓名为主要条件
* 
*/
public class TreeMapStudent {
	
	public static void main(String[] args) {
		sort_2();
	}
	
	public static void sort_2() {//后面改成以姓名为主要条件
		TreeMap<Student, String> tm = new TreeMap<>(new StuNameComparator());// 1.7的新特性之后可以按照这种写法,申明引用的的时候使用泛型在创建对象的时候可以不用再使用泛型
		tm.put(new Student("zhangsan3", 23), "南昌3");
		tm.put(new Student("zhangsan4", 21), "南昌4");
		tm.put(new Student("zhangsan4", 21), "南昌5");
		tm.put(new Student("zhangsan4", 22), "南昌6");
		tm.put(new Student("zhangsan1", 21), "南昌1");
		tm.put(new Student("zhangsan2", 22), "南昌2");
		tm.put(new Student("zhangsan2", 22), "北京");//相同的键，后面的值会被覆盖
		
		Set<Map.Entry<Student, String>> entry = tm.entrySet();
		Iterator<Map.Entry<Student, String>> it = entry.iterator();
		while(it.hasNext()) {
			Map.Entry<Student, String> me = it.next();
			Student key = me.getKey();
			String value = me.getValue();
			System.out.println("key: " + key + "  value: " + value);
		}
	}
	
	public static void sort_1() {//先按照年龄为主要条件
		TreeMap<Student, String> tm = new TreeMap<>();// 1.7的新特性之后可以按照这种写法,申明引用的的时候使用泛型在创建对象的时候可以不用再使用泛型
		tm.put(new Student("zhangsan1", 21), "南昌1");
		tm.put(new Student("zhangsan2", 22), "南昌2");
		tm.put(new Student("zhangsan3", 23), "南昌3");
		tm.put(new Student("zhangsan4", 21), "南昌4");
		tm.put(new Student("zhangsan4", 21), "南昌5");
		tm.put(new Student("zhangsan4", 22), "南昌6");
		
		Set<Map.Entry<Student, String>> entry = tm.entrySet();
		Iterator<Map.Entry<Student, String>> it = entry.iterator();
		while(it.hasNext()) {
			Map.Entry<Student, String> me = it.next();
			Student key = me.getKey();
			String value = me.getValue();
			System.out.println("key: " + key + "  value: " + value);
		}
	}

}
