package com.study.search;

import java.util.Comparator;

public class MyCompare<T> implements Comparator<T> {

	@Override
	public int compare(T o1, T o2) {
		Integer num1 = (Integer) o1;
		Integer num2 = (Integer) o2;
		int num = num1.compareTo(num2);
		
		return num;
	}
}