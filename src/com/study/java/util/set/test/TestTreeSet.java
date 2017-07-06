package com.study.java.util.set.test;

import java.util.Iterator;
import java.util.TreeSet;

import org.junit.Test;

import com.study.java.util.set.MyCompare;
import com.study.java.util.set.TreeSetDemo2;
import com.study.java.util.set.TreeSetDemo3;

/**
* @author 叶林生 
* @date：2017年6月25日 下午9:12:47
* @version 1.0
* 
*/
public class TestTreeSet {
	
	@Test
	public void testTreeSetDemo2(){
		TreeSet<TreeSetDemo2> treeSet = new TreeSet<TreeSetDemo2>();
		
		treeSet.add(new TreeSetDemo2("李四1", 25));
		treeSet.add(new TreeSetDemo2("李四2", 26));
		treeSet.add(new TreeSetDemo2("李四3", 27));
		treeSet.add(new TreeSetDemo2("李四4", 28));
		treeSet.add(new TreeSetDemo2("李四5", 28));
		treeSet.add(new TreeSetDemo2("李四5", 28));
		
		for(Iterator<TreeSetDemo2> it = treeSet.iterator(); it.hasNext();) {
			TreeSetDemo2 t = it.next();
			System.out.println(t);
		}
	}
	
	@Test
	public void testTreeSetDemo3() {
		TreeSet<TreeSetDemo3> treeSet = new TreeSet<TreeSetDemo3>(new MyCompare<TreeSetDemo3>());
		treeSet.add(new TreeSetDemo3("asdl", 12));
		treeSet.add(new TreeSetDemo3("asdl", 12));
		treeSet.add(new TreeSetDemo3("asdl", 13));
		treeSet.add(new TreeSetDemo3("abca", 12));
		treeSet.add(new TreeSetDemo3("aabd", 12));
		treeSet.add(new TreeSetDemo3("cdft", 12));
		treeSet.add(new TreeSetDemo3("bcde", 12));
		treeSet.add(new TreeSetDemo3("bcde", 14));
		
		for(Iterator<TreeSetDemo3> it = treeSet.iterator(); it.hasNext();) {
			System.out.println(it.next());
		}
	}

}
