package com.study.java.util.set;

import java.util.Iterator;
import java.util.TreeSet;

/**
* @author 叶林生 
* @date：2017年6月25日 下午8:40:40
* @version 1.0
* 
*/
public class TreeSetDemo1 {
	
	public static void main(String[] args) {
		TreeSet t = new TreeSet();
		t.add(32);
		t.add(25);
		t.add(36);
		for(Iterator it = t.iterator(); it.hasNext();) {
			System.out.println(it.next());
		}
	}

}
