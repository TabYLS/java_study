package com.study.sort.shell;

import java.util.Arrays;

/**
 * @author 叶林生
 * @date：2017年7月30日 下午5:05:47
 * @version 1.0
 * 
 */
public class ShellSort {

	private int[] arr;

	public ShellSort(int[] arr) {
		this.arr = arr;
	}

	public void sort() {
		// 增量gap，并逐步缩小增量
		for (int gap = arr.length / 2; gap > 0; gap /= 2) {
			// 从第gap个元素，逐个对其所在组进行直接插入排序操作
			for (int i = gap; i < arr.length; i++) {
				int j = i;
				int temp = arr[j];
				System.out.println(j + "  :  " + (j - gap));
				System.out.println(arr[j] + "  :  " + arr[j - gap]);
				if (arr[j] < arr[j - gap]) {
					System.out.println("before move: " + Arrays.toString(arr));
					while (j - gap >= 0 && temp < arr[j - gap]) {
						// 移动法
						arr[j] = arr[j - gap];
						j -= gap;
						System.out.println("move: " + Arrays.toString(arr));
					}
					arr[j] = temp;
					System.out.println("after move: " + Arrays.toString(arr));
				}
			}
		}
	}

}
