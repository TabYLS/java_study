package com.study.sort;

import java.util.Comparator;

/**
* @author 叶林生 
* @date：2017年7月25日 下午9:37:01
* @version 1.0
* 
* 排序器接口(策略模式: 将算法封装到具有共同接口的独立的类中使得它们可以相互替换)
* 使用策略模式封装算法
* 
*/
public interface ISort {
	
	/**
	 * 凡是具备比较性的（实现了Comparable接口的）对象都可以进行比较
	 * @param list 待比较的集合
	 */
	public <T extends Comparable<T>> void sort(T[] list);
	
	/**
	 * 即使不具备比较性的（没有实现Comparable接口的）对象或者想要覆盖原有的比较器的也可以通过自定义比较器进行比较
	 * @param list  待比较的集合
	 * @param comp  自定义比较器
	 */
	public <T>void sort(T[] list, Comparator<T> comp);

}
