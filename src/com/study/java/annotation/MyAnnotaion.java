package com.study.java.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author 叶林生
 *
 * @date 2017年6月21日 上午9:51:06
 *
 * @version 1.0
 * 该注解用于Student
 * 
 * 写好了注解之后还要使用元注解@Rentention来修饰这个注解到底要存留多久，
 * 是编译期，RetentionPolicy.SOURCE
 * 是源文件，RetentionPolicy.CLASS
 * 还是运行时期，RetentionPolicy.RUNTIME
 * 
 * 还有@Target来指明清楚需要运用于什么（类、构造方法、方法、属性、局部变量）
 */
@Target({ElementType.TYPE,ElementType.METHOD,ElementType.FIELD,ElementType.LOCAL_VARIABLE,ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotaion {

	//使用无参方法来表示注解的成员
	String value1();//修改name
	int value2();
	String[] value3();//数组
	int value4() default 22;//给默认值
}
