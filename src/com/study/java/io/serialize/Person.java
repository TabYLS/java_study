package com.study.java.io.serialize;

import java.io.Serializable;

/**
 *
 * @author 叶林生
 *
 * @date 2017年6月16日 上午8:58:44
 *
 * @version 1.0
 * 
 *          类通过实现 java.io.Serializable 接口以启用其序列化功能。
 *          未实现此接口的类将无法使其任何状态序列化或反序列化。
 * 
 */
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;
	//private int id;
	private String name;
	private int age;

	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

}
