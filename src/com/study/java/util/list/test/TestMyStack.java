package com.study.java.util.list.test;

import com.study.java.util.list.MyStack;

/**
* @author 叶林生 
* @date：2017年6月23日 下午11:41:10
* @version 1.0
* 
*/
public class TestMyStack {
	
	public static void main(String[] args) {
		MyStack<String> stack = new MyStack<String>();
		stack.myAdd("stack1");
		stack.myAdd("stack2");
		stack.myAdd("stack3");
		stack.myAdd("stack4");
		stack.myAdd("stack5");
		
		while(!stack.isNull()) {
			System.out.println(stack.myRemove());
		}
	}

}
