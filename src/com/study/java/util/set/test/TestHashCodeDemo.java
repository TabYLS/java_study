package com.study.java.util.set.test;

import java.util.HashSet;
import java.util.Iterator;

import org.junit.Test;

import com.study.java.util.set.HashCodeDemo;

/**
* @author 叶林生 
* @date：2017年6月25日 下午4:39:16
* @version 1.0
* 
* HashSet去除重复元素的原理，是在底层调用根据hashcode的值来判断，如果hashcode相等再调用equals来按照制定规则判断是不是应该存入哈希表中
* 
*/
public class TestHashCodeDemo {

	@Test
	public void test() {
		HashSet<HashCodeDemo> h = new HashSet<>();
		h.add(new HashCodeDemo("李四1", 35));
		h.add(new HashCodeDemo("李四2", 36));
		h.add(new HashCodeDemo("李四2", 36));
		h.add(new HashCodeDemo("李四4", 38));
		
		for (Iterator<HashCodeDemo> iterator = h.iterator(); iterator.hasNext();) {
			HashCodeDemo hashCodeDemo = (HashCodeDemo) iterator.next();
			System.out.println(hashCodeDemo);
		}
		
	}

}
