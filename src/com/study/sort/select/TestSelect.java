package com.study.sort.select;

import java.util.Arrays;

/**
* @author 叶林生 
* @date：2017年7月29日 下午8:26:44
* @version 1.0
* 
*/
public class TestSelect {
	
	public static void main(String[] args) {
		int[] arr = {0,90,56,896,5,48,96,65,8,49,92};
		SelectSort sort = new SelectSort(arr);
		sort.sort();
		System.out.println(Arrays.toString(arr));
		
	}

}
