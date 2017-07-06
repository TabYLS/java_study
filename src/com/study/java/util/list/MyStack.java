package com.study.java.util.list;
/**
* @author 叶林生 
* @date：2017年6月23日 下午10:52:30
* @version 1.0
* 
* 堆栈的数据结构是先进后出
* 
* 使用LinkedList模仿堆栈，从堆栈的数据结构中可以得出，这种数据结构是适合来当容器使用，而不适合用来操作数据，也就是装入和取出就行了
*/

import java.util.LinkedList;

public class MyStack<E> {
	
	private LinkedList<E> linkedList;
	
	public MyStack() {
		linkedList = new LinkedList<E>();
	}
	
	public void myAdd(E e) {//堆的数据结构决定每次插入的都是在上面
		linkedList.addFirst(e);
	}
	
	public E myRemove() {//堆的数据结构决定每次删除的都是后面进来的
		return linkedList.removeFirst();
	}
	
	public boolean isNull(){
		return linkedList.isEmpty();
	}

}
