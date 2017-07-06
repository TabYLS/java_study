package com.study.java.util.list.test;

import com.study.java.util.list.MyQueue;

/**
* @author 叶林生 
* @date：2017年6月23日 下午10:46:07
* @version 1.0
* 
*/
public class TestMyQueue {

	public static void main(String[] args) {
		MyQueue<String> queue = new MyQueue<String>();
		
		queue.myAdd("str1");
		queue.myAdd("str2");
		queue.myAdd("str3");
		queue.myAdd("str4");
		queue.myAdd("str5");
		
		while(!queue.isNull()){
			System.out.println(queue.myGet());
		}
	}
}
