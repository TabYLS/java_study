package com.study.sort.shell;

/**
* @author 叶林生 
* @date：2017年7月30日 下午8:29:14
* @version 1.0
* 
*/
public class MyShellSort {
	
	private int[] arr;
	
	public MyShellSort(int[] arr) {
		this.arr = arr;
	}
	
	public void sort(int gap) {
		gap = gap/2;
		if (gap <= 0) {
			return;
		}
		for(int i = gap; i < arr.length; i ++) {
			for (int j = i; j - gap >= 0 && arr[j] < arr[j - gap]; j -= gap) {//只查询同一个组的
				swap(j, j - gap);
			}
		}
		sort(gap);
	}
	
	private void swap(int i, int j) {
		int temp = 0;
		temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
