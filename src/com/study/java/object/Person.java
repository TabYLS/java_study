package com.study.java.object;
/**
* @author 叶林生 
* @date：2017年6月25日 上午10:47:01
* @version 1.0
* 
*/
public class Person {
	
	private String name;
	private int age;
	private String sex;
	
	
	public Person(String name, int age, String sex) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	@Override
	public boolean equals(Object obj) {//复写父类方法，年龄相同，返回true
		if(!(obj instanceof Person))
			return false;
		Person person = (Person) obj;
		return this.age == person.age;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	

}
