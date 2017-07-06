package com.study.java.util.map;

import java.util.Comparator;

/**
* @author 叶林生 
* @date：2017年7月3日 下午3:44:25
* @version 1.0
* 
*/
public class StuNameComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		int num = o1.getName().compareTo(o2.getName());
		if (num == 0) 
			return new Integer(o1.getAge()).compareTo(new Integer(o2.getAge()));
		return num;
	}

}
