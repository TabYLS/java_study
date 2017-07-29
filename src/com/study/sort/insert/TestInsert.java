package com.study.sort.insert;

import java.util.Arrays;

/**
* @author 叶林生 
* @date：2017年7月29日 下午9:18:22
* @version 1.0
* 
*/
public class TestInsert {
	
	public static void main(String[] args) {
		int[] arr = {0,90,56,896,5,48,96,65,8,49,92};
		InsertSort sort = new InsertSort(arr);
		sort.sort();
		System.out.println(Arrays.toString(arr));
	}

}
