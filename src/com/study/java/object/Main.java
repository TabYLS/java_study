package com.study.java.object;
/**
* @author 叶林生 
* @date：2017年6月25日 上午10:53:20
* @version 1.0
* 
*/
public class Main {

	public static void main(String[] args) {
		Person person = new Person("张三", 35, "男");
		Person person2 = new Person("李四", 35, "男");
		Animal animal = new Animal();
		System.out.println(person.equals(animal));
		System.out.println(person.equals(person2));

	}

}
