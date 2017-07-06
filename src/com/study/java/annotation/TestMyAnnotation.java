package com.study.java.annotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

/**
 *
 * @author 叶林生
 *
 * @date 2017年6月21日 上午11:20:11
 *
 * @version 1.0
 * 
 *          通过反射来获取注解信息
 */
public class TestMyAnnotation {

	// 通过注解描述属性
	@Test
	public void fieldAnno() {
		Class<Student> clazz = Student.class;
		try {
			Student stu = clazz.newInstance();
			Field field = clazz.getDeclaredField("age");
			field.setAccessible(true);
			// 获取属性的注解，age在Student类中添加了注解来描述，所以要获得注解属性，就可以通过这种方式来获取
			MyAnnotaion myAnnotaion = field.getAnnotation(MyAnnotaion.class);
			System.out.println(field.get(stu));// 直接通过反射获取到的属性
			System.out.println(myAnnotaion.value1());
			System.out.println(myAnnotaion.value2());// 通过反射和注解得到的属性值
		} catch (InstantiationException | IllegalAccessException
				| NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
	}

	// 通过注解描述方法
	@Test
	public void methodAnno() {
		Class<Student> clazz = Student.class;
		try {
			Student stu = clazz.newInstance();// 通过反射的默认方式创建对象，必须提供无参构造函数
			Method method = clazz.getDeclaredMethod("annoMethod",
					new Class[] { String.class });
			method.invoke(stu, new Object[] { "反射调用方法" });
			if (method.isAnnotationPresent(MyAnnotaion.class)) {
				MyAnnotaion myAnnotaion = method
						.getAnnotation(MyAnnotaion.class);
				System.out.println(myAnnotaion.value1());

			}
		} catch (InstantiationException | IllegalAccessException
				| SecurityException | NoSuchMethodException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	// 通过注解描述构造方法
	@Test
	public void consAnno() {
		Class<Student> clazz = Student.class;
		try {
			// 这里调用的构造方法一定要是使用注解标识的，参数和参数类型要严格对应，否则使用注解失败
			Constructor<Student> constructor = clazz
					.getConstructor(new Class[] { String.class, int.class });
			Student stu = constructor.newInstance(new Object[] {
					"通过反射调用有参构造方法创建对象", 50 });
			// 通过反射调用有参构造方法创建对象
			System.out.println(stu);
			MyAnnotaion myAnnotaion = constructor
					.getAnnotation(MyAnnotaion.class);
			System.out.println(myAnnotaion.value1() + ","
					+ myAnnotaion.value2());
			// 第三个是数组
			for (String obj : myAnnotaion.value3()) {
				System.out.println(obj);
			}
			// 第四个是默认数
			System.out.println(myAnnotaion.value4());
		} catch (InstantiationException | IllegalAccessException
				| SecurityException | IllegalArgumentException
				| NoSuchMethodException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	// 通过注解描述局部变量
	@Test
	public void localVariableAnno() {
		Class<Student> clazz = Student.class;
		try {
			Constructor<Student> constructor = clazz
					.getConstructor(new Class[] { String.class, int.class });
			Student stu = constructor.newInstance(new Object[] { "易阳", 20 });
			Method method = clazz.getMethod("annoLocalVaria",
					new Class[] { String.class });
			method.invoke(stu, new Object[] { "局部变量的描述" });
			System.out.println(method.isAnnotationPresent(MyAnnotaion.class));
			if (method.isAnnotationPresent(MyAnnotaion.class)) {
				MyAnnotaion myAnnotaion = method
						.getAnnotation(MyAnnotaion.class);
				System.out.println("annotation:  " + myAnnotaion.value1() + ","
						+ myAnnotaion.value2() + "," + myAnnotaion.value3()
						+ "," + myAnnotaion.value4());
			}
		} catch (SecurityException | IllegalArgumentException
				| NoSuchMethodException | IllegalAccessException
				| InvocationTargetException | InstantiationException e) {
			e.printStackTrace();
		}
	}

}
