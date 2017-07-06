package com.study.java.util.map;
/**
* @author 叶林生 
* @date：2017年7月3日 下午2:00:29
* @version 1.0
* 
* 描述学生：姓名，年龄
* 为了让学生能够存入TreeSet中，需要实现comparable接口（排序）
* 
* 为了存入哈希数据结构的中，需要重写hashCode方法和equals方法，先调用hashCode方法再调用equals方法（去除重复元素）
*
*/
public class Student implements Comparable<Student> {

	private String name;
	private int age;
	
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Student o) {//先按照年龄排序再按照名字排序
		int num = new Integer(this.age).compareTo(new Integer(o.age));
		if (num == 0) 
			return this.name.compareTo(o.name);
		return num;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {//年龄和姓名相同则视为同一个人
		if (!(obj instanceof Student)) 
			throw new ClassCastException(obj + "不是Student类型。。。");
		Student stu = (Student) obj;
		return this.name.equals(stu.name) && this.age == stu.age;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
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

}
