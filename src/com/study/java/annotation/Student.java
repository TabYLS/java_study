package com.study.java.annotation;
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
	//使用注解描述属性
	@MyAnnotaion(value1 = "嘻嘻嘻", value2 = 23, value3 = { "" })
	private int age;
	private String sex;
	
	public Student(){}
	
	//使用注解描述构造方法
	@MyAnnotaion(value1 = "", value2 = 33, value3 = { "张三，李四","李思思" })
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

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
	
	//使用注解描述方法
	@MyAnnotaion(value1 = "注解方法", value2 = 0, value3 = { "" })
	public void annoMethod(String name){
		this.name = name;
		System.out.println(this.name);
	}
	
	//注解描述局部变量
	public void annoLocalVaria(String text){
		//使用注解描述局部变量
		@MyAnnotaion(value1 = "注解描述局部变量", value2 = 500, value3 = { "" })
		int testAnnotation = 300;
		System.out.println("message: "+text+"   testAnnotation:"+testAnnotation);
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}
	
}
