package com.study.java.util.list.test;

import java.util.ArrayList;
import java.util.Iterator;

import com.study.java.util.list.Person;
import com.study.java.util.list.ReArrayList;

/**
 * @author 叶林生
 * @date：2017年6月24日 上午12:27:03
 * @version 1.0
 * 
 */
public class TestArrayList {

	public static void main(String[] args) {
		// singleElement();
		overrideEquals();
	}

	/**
	 *  String类型的数据之所以能够在list集合中使用contains方法是因为String类本身就复写了equals方法，用于比较值是否相等而不是比较地址是否相等
	 */
	public static void singleElement() {
		ArrayList<String> arrayList = new ArrayList<String>();
		ReArrayList<String> myAL = new ReArrayList<String>();

		arrayList.add("arr1");
		arrayList.add("arr1");
		arrayList.add("arr2");
		arrayList.add("arr2");
		arrayList.add("arr3");
		arrayList.add("arr4");
		arrayList.add("arr3");

		arrayList = myAL.singleElement(arrayList);

		Iterator<String> iterator = arrayList.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	
	/**
	 * 复写了equals方法之后list集合contains方法和remove方法会在底层自动调用equals方法按照指定的规则进行去除重复和移除元素
	 */
	public static void overrideEquals(){
		ArrayList<Person> al = new ArrayList<Person>();
		ReArrayList<Person> ral = new ReArrayList<Person>();
		
		al.add(new Person("lisi1", 20));
		al.add(new Person("lisi2", 21));
		al.add(new Person("lisi2", 21));
		al.add(new Person("lisi3", 22));
		al.add(new Person("lisi4", 23));
		al.add(new Person("lisi5", 24));
		al.add(new Person("lisi6", 25));
		al.add(new Person("lisi7", 26));
		al.add(new Person("lisi7", 26));
		
		al = ral.singleElement(al);
		//al.remove(new Person("lisi7", 26));//remove方法依赖底层equals方法
		
		for (Iterator<Person> iterator2 = al.iterator(); iterator2.hasNext();) {
			Person person = (Person) iterator2.next();
			System.out.println("name:" + person.getName() + "        age:" + person.getAge());
		}
	}

}
