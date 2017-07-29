package com.study.sort.insert;
/**
* @author 叶林生 
* @date：2017年7月29日 下午9:05:32
* @version 1.0
* 
*/
public class InsertSort {
	
	private int[] arr;
	
	public InsertSort(int[] arr) {
		this.arr = arr;
	}
	
	public void sort() {
		for(int i = 1 ; i < arr.length; i ++) {
			int insertNode = arr[i];
			for(int j = i - 1; j >= 0; j --) {
				if (insertNode > arr[j]) {
					arr[j + 1] =insertNode;
					break;
				}
				arr[j + 1] = arr[j];//在没有找到位置的时候就一直的将数组往后移动
			}
		}
	}
	
	public void swap(int i, int j) {
		int temp = 0;
		temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
