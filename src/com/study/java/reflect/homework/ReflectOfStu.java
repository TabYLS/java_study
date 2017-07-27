package com.study.java.reflect.homework;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 *
 * @author 叶林生
 *
 * @date 2017年6月20日 下午7:41:15
 *
 * @version 1.0
 * 
 *          1、有一个学生类 姓名，年龄，性别（属性私有），提供三个构造方法
 *          一个默认构造方法，一个给全部属性赋值的构造方法，一个只提供的姓名和性别，年龄给默认值，一个show()方法，该方法显示学生的基本信息，
 *          1）请利用反射，构造student对象，
 *          2）利用反射修改年龄 
 *          3）利用反射调用show最后把学生的信息存入Arraylist，原有的ArrayList<String>list=new ArrayList();//学生姓名
 *          4）通过反射绕过泛型检查
 * 
 * 
 * 
 */
public class ReflectOfStu {

	public static void main(String[] args) {
		Class<Student> clazz = Student.class;
		try {
			// 1.通过调用有参数的构造方法创建对象
			Student stu = (Student) clazz.getConstructor(
					new Class[] { String.class, String.class }).newInstance(
					new Object[] { "盼盼", "女" });

			// 2.通过反射修改年龄
			Field field = clazz.getDeclaredField("age");
			System.out.println(stu);
			field.setAccessible(true);
			System.out.println(field.get(stu));
			field.set(stu, 24);
			System.out.println(field.get(stu));

			// 3.利用反射调用show方法
			Method method = clazz.getDeclaredMethod("show");
			
			// 4.通过反射绕过泛型检查
			ArrayList<String> list = new ArrayList<String>();
			list.add("易阳");
			Class<ArrayList> class_list = ArrayList.class;
			Method method_list = class_list.getDeclaredMethod("add",
					new Class[] { Object.class });
			method_list.invoke(list, stu);
			System.out.println(list);
		} catch (InstantiationException | IllegalAccessException
				| NoSuchFieldException | SecurityException
				| IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException e) {
			e.printStackTrace();
		}
	}

}
