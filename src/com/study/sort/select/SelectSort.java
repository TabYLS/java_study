package com.study.sort.select;

/**
 * @author 叶林生
 * @date：2017年7月29日 下午7:49:53
 * @version 1.0
 * 
 */
public class SelectSort {

	private int[] arr = {};

	public SelectSort(int[] arr) {
		this.arr = arr;
	}
	
	public void sort(){
		int index = 0;
		int len = arr.length - 1;
		for(int i = 0; i < len; i ++) {
			index = i;
			for(int j = i + 1; j < len + 1; j ++) {
				if(arr[index] < arr[j]) {
					index = j;
				}
			}
			swap(index, i);
		}
	}
	
	public void swap(int i, int j) {
		int temp = 0;
		temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
