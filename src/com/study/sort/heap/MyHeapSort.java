package com.study.sort.heap;
/**
* @author 叶林生 
* @date：2017年7月27日 下午3:00:56
* @version 1.0
* 
*/
public class MyHeapSort {
	
	/**
	 * 调整堆的结构，将它变成符合堆定义的结构，大顶堆，或者小顶堆
	 * @param arr   堆
	 * @param i     当前节点（一般指的是第一个非叶子节点arr.length/2-1）
	 * @param len
	 */
	public void ajustHeap(int[] arr, int i, int len) {
		//1.取出当前元素
		int temp = arr[i];
		//
		for(int k = 2 * i + 1; k < len; k = 2 * k + 1) {//从左孩子开始
			if((k + 1) > len && arr[k] < arr[k + 1]) {
				k += 1;
			}
			if (arr[k] > temp) {
				arr[i] = arr[k];
			} else {
				break;
			}
		}
	}

}
