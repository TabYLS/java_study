package com.study.java.innerclass;

import java.util.Iterator;

/**
* @author 叶林生 
* @date：2017年6月23日 上午10:17:52
* @version 1.0
* 
*/
public class ArrayList<E> {
	
	private java.util.ArrayList<E> arrayList = new java.util.ArrayList<E>();
	
	public void add(E e){
		arrayList.add(e);
	}
	
	public Iterator<E> iterator(){
		return new Itr();
	}
	
	private class Itr implements Iterator<E>{

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public E next() {
			System.out.println("内部类Iterator调用next()方法。。。。。。。。。。。。。。");
			for (E e : arrayList) {
				System.out.println(e);
			}
			return null;
		}

		@Override
		public void remove() {
			System.out.println("内部类Iterator调用remove()方法。。。。。。。。。。。。。。。");
			
		}
		
	}

}
