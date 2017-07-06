package com.study.java.util.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author 叶林生
 * @date：2017年7月3日 下午2:27:13
 * @version 1.0 
 * 每一个学生都有对应的归属地。 学生Student，地址String。 学生属性：姓名，年龄。
 * 注意：姓名和年龄相同的视为同一个学生。 保证学生的唯一性。
 * 
 * 
 *  这个例子是演示获取所有的map集合，是一次性获取去所有，而不是一次获取一个 通过迭代器的方式遍历
 * 
 */
public class HashMapStudent {

	public static void main(String[] args) {
		testEntrySet();
	}

	public static void testEntrySet() {
		HashMap<Student, String> hm = new HashMap<>();// 1.7的新特性之后可以按照这种写法,申明引用的的时候使用泛型在创建对象的时候可以不用再使用泛型
		hm.put(new Student("zhangsan1", 21), "南昌1");
		hm.put(new Student("zhangsan2", 22), "南昌2");
		hm.put(new Student("zhangsan3", 23), "南昌3");
		hm.put(new Student("zhangsan4", 21), "南昌4");
		hm.put(new Student("zhangsan4", 21), "南昌5");
		hm.put(new Student("zhangsan4", 22), "南昌6");

		Set<Map.Entry<Student, String>> hs = hm.entrySet();// 返回此映射中包含的键的 Set
															// 视图。通过先获取键，再获取值
		Iterator<Map.Entry<Student, String>> it = hs.iterator();// 通过迭代器的方式获取
		while (it.hasNext()) {
			Map.Entry<Student, String> me = it.next();
			Student key = me.getKey();
			String value = me.getValue();
			System.out.println("key: " + key + "  value: " + value);

		}
	}

	public static void testKeySet() {
		HashMap<Student, String> hm = new HashMap<>();// 1.7的新特性之后可以按照这种写法,申明引用的的时候使用泛型在创建对象的时候可以不用再使用泛型
		hm.put(new Student("zhangsan1", 21), "南昌1");
		hm.put(new Student("zhangsan2", 22), "南昌2");
		hm.put(new Student("zhangsan3", 23), "南昌3");
		hm.put(new Student("zhangsan4", 21), "南昌4");
		hm.put(new Student("zhangsan4", 21), "南昌5");
		hm.put(new Student("zhangsan4", 22), "南昌6");

		Set<Student> hs = hm.keySet();// 返回此映射中包含的键的 Set 视图。通过先获取键，再获取值
		Iterator<Student> it = hs.iterator();// 通过迭代器的方式获取
		while (it.hasNext()) {
			Student key = (Student) it.next();
			String value = hm.get(key);
			System.out.println("key: " + key + "  value: " + value);

		}
	}

}
