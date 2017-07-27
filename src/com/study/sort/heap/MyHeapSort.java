package com.study.sort.heap;

import java.util.Arrays;

/**
 * @author 叶林生
 * @date：2017年7月27日 下午3:00:56
 * @version 1.0
 * 
 */
public class MyHeapSort {
	
	public static void main(String[] args) {
		int[] arr = {12,15,10,11,9,8,7,6,5,4,3,2,1};
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void sort(int[] arr) {
		//从上至下从最后一个非叶子节点的节点开始，初始化堆
		for(int i = arr.length/2 - 1; i >= 0; i --) {//之所以要循环每一个节点，是因为初始的时候不是一个堆
			ajustHeap(arr, i, arr.length);
		}
		for (int i = arr.length - 1; i >0 ; i--) {//每循环一次堆就少一个节点
			swap(arr, 0, i);
			ajustHeap(arr, 0, i);//在交换一次之后只要调整一次就好了，这里和初始化的时候不一样
		}
	}

	/**
	 * 调整堆的结构，将它变成符合堆定义的结构，大顶堆，或者小顶堆
	 * 
	 * @param arr
	 *            堆
	 * @param i
	 *            当前节点（一般指的是从根到节点的最后一个非叶子节点arr.length/2-1）
	 * @param len
	 *            堆的大小
	 */
	private static void ajustHeap(int[] arr, int i, int len) {
		// 1.取出当前元素
		int temp = arr[i];
		//
		for (int k = 2 * i + 1; k < len; k = 2 * k + 1) {// 从左孩子开始
			if ((k + 1 < len )&& arr[k] < arr[k + 1]) {
				k ++;
			}
			if (arr[k] > temp) {
				arr[i] = arr[k];
				i = k;
			} else {
				break;
			}
		}
		arr[i] = temp;
	}

	private static void swap(int[] arr, int pre, int next) {
		int temp = arr[pre];
		arr[pre] = arr[next];
		arr[next] = temp;
	}

}
