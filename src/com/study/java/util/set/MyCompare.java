package com.study.java.util.set;

import java.util.Comparator;

/**
 * @author 叶林生
 * @date：2017年6月26日 上午9:14:39
 * @version 1.0
 * @param <T>
 * 
 *            原本是以年龄为主要条件，但是现在需求改变需要变成以姓名为主要条件，年龄为次要条件
 * 
 *            这个时候应该定义一个自定义的比较器 自定义比较器可以让没有实现Comparable接口的类也可以进行比较
 * 
 */
public class MyCompare<T> implements Comparator<T> {

	@Override
	public int compare(T o1, T o2) {// 现在是按照姓名为主要条件排序
		TreeSetDemo3 set1 = (TreeSetDemo3) o1;
		TreeSetDemo3 set2 = (TreeSetDemo3) o2;
		int num = set1.getName().compareTo(set2.getName());
		if (num == 0)
			return new Integer(set1.getNum()).compareTo(new Integer(set2.getNum()));
		return num;
	}
}
