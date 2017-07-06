package com.study.java.util.list;
/**
* @author 叶林生 
* @date：2017年6月23日 下午10:32:40
* @version 1.0
* 
* 队列的数据结构是先进先出
* 
* 使用LinkedList来模仿队列,因为队列的数据结构是先进先出，所以对于取出需要移除，添加只有从头开始
* 
*/

import java.util.LinkedList;


public class MyQueue<E> {
	
	private LinkedList<E> linkedList;
	
	public MyQueue() {
		linkedList = new LinkedList<E>();
	}
	
	public E myGet(){//获取元素之后就删除
		return linkedList.removeLast();
	}
	
	public void myAdd(E e){//添加元素从第一个开始添加
		linkedList.addFirst(e);
	}
	
	public boolean isNull(){
		return linkedList.isEmpty();
	}

}


