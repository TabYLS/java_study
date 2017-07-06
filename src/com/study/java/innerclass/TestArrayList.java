package com.study.java.innerclass;

import java.util.Iterator;

import org.junit.Test;

/**
* @author 叶林生 
* @date：2017年6月23日 上午10:28:07
* @version 1.0
* 
*/
public class TestArrayList {
	
	@Test
	public void test(){
		ArrayList arrayList = new ArrayList();
		arrayList.add("你好");
		arrayList.add("好吗？");
		arrayList.add(32);
		
		Iterator it = arrayList.iterator();
		it.next();
		it.remove();
	}

}
