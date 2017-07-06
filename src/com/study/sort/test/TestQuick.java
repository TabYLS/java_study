package com.study.sort.test;

import com.study.sort.quick.QuickSort;

/**
 *
 * @author 叶林生
 *
 * @date 2017年6月14日 下午8:41:48
 *
 * @version 1.0
 * 
 */
public class TestQuick {
	
	public static void main(String[] args) {
		int[] r = {0,90,56,896,5,48,96,65,8,49,92};//数组的第一个是作为支点用的，一定要先给一个做为存放支点的
		QuickSort quickSort = new QuickSort(r);
		quickSort.quick(1, r.length - 1);//数组是传递的地址
		System.out.println();
		for (int a : r) {
			System.out.print(a + ",");
		}
	}

}
