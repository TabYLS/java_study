package com.study.java.reflect.homework;
/**
 *
 * @author 叶林生
 *
 * @date 2017年6月20日 下午7:31:32
 *
 * @version 1.0
 * 
 */
public class Student {
	
	private String name;
	private int age;
	private String sex;
	
	public Student(){}

	public Student(String name, int age, String sex) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	public Student(String name, String sex) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = 22;
	}
	
	public void show(){
		System.out.println("show打印：。。。。。"+toString());
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}
	
}
