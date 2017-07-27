package com.study.sort.bub;

import org.junit.Test;

import com.study.sort.ISort;

/**
* @author 叶林生 
* @date：2017年7月26日 上午12:05:52
* @version 1.0
* 
*/
public class TestObjectBub {
	
	@Test
	public void testTreeSetDemo3() {
		TreeSetDemo3[] treeSetDemos = {new TreeSetDemo3("asdl", 12),
										new TreeSetDemo3("asdl", 12),
										new TreeSetDemo3("asdl", 13),
										new TreeSetDemo3("abca", 12),
										new TreeSetDemo3("aabd", 12),
										new TreeSetDemo3("cdft", 12),
										new TreeSetDemo3("bcde", 12),
										new TreeSetDemo3("bcde", 14)};
		
		//Integer[] integers = {123,1,5,6,8,7,9,2,3};
		
		ISort sortb = new ObjectBub();
		sortb.sort(treeSetDemos);
		for (int i = 0; i < treeSetDemos.length; i++) {
			System.out.println(treeSetDemos[i]);
		}
	}

}
