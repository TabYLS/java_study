package com.study.java.util.list;
/**
* @author 叶林生 
* @date：2017年6月23日 下午11:57:31
* @version 1.0
* 
* 去除ArrayList中的重复元素,
* list的contains方法依赖于equals方法，如果被比较的对象没有复写equals方法会默认比较地址，复写了equals方法之后就会按照制定规则进行比较
* remove方法也是依赖与equals方法
*/

import java.util.ArrayList;
import java.util.Iterator;

public class ReArrayList<E> {
	
	public ArrayList<E> singleElement(ArrayList<E> oldAl) {
		ArrayList<E> newAl = new ArrayList<E>();
		/*
		 * 这种方式比较消耗内存，因为当循环结束之后iterator变量还是存在于内存中
		 * Iterator<E> iterator = oldAl.iterator();
		while(iterator.hasNext()){
			E e = iterator.next();
			if (!newAl.contains(e)) {
				newAl.add(e);
			}
		}*/
		
		//这中方式消耗的资源比较少，因为循环一旦结束，iterator变量就会销毁
		for (Iterator<E> iterator = oldAl.iterator(); iterator.hasNext();) {
			E e = (E) iterator.next();//一定要用一个变量来装，不然连续取出两个元素的话，会报异常，因为调用一次.next()方法之后，指针会下移一位
			if (!newAl.contains(e)) 
				newAl.add(e);
		}
		return newAl;
	}

}
