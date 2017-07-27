package com.study.sort.bub;

import java.util.Comparator;

import com.study.sort.ISort;

/**
* @author 叶林生 
* @date：2017年7月25日 下午9:43:16
* @version 1.0
* 
*/
public class ObjectBub implements ISort {

	@Override
	public <T extends Comparable<T>> void sort(T[] list) {
		int per_index = list.length - 1;//记录每次交换的最后一个位置
		int last_index = 0;//记录最后一次的交换位置
		T temp = null;
		for (int i = 0 ; i < list.length; i++) {
			last_index = per_index;
			for(int j = 0 ; j < last_index; j++) {
				if (list[j].compareTo(list[j + 1]) > 0) {
					temp = list[j];
					list[j] = list[j + 1];
					list[j + 1] = temp;
					per_index = j;
				}
			}
		}

	}

	@Override
	public <T> void sort(T[] list, Comparator<T> comp) {
		int per_index = list.length - 1;//记录每次交换的最后一个位置
		int last_index = 0;//记录最后一次的交换位置
		T temp = null;
		for (int i = 0 ; i < list.length; i ++) {
			last_index = per_index;
			for(int j = 0 ; j < last_index; j ++) {
				if (comp.compare(list[j], list[j + 1]) > 0) {
					temp = list[j];
					list[j] = list[j + 1];
					list[j + 1] = temp;
					per_index = j;
				}
			}
		}
	}

}
