package com.study.java.util.list;
/**
* @author 叶林生 
* @date：2017年6月25日 上午10:47:01
* @version 1.0
* 
*/
public class Person {
	
	private String name;
	private int age;
	
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	@Override
	public boolean equals(Object obj) {//复写父类方法，年龄相同，返回true
		if(!(obj instanceof Person))
			return false;
		Person person = (Person) obj;
		//this.name.equals(person.name)调用的是String类的equals方法
		return this.name.equals(person.name) && this.age == person.age;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	

}
