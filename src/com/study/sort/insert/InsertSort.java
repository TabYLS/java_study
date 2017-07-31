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
			for(int j = i; j > 0 && arr[j] < arr[j - 1]; j --) {
				swap(j, j - 1);
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
