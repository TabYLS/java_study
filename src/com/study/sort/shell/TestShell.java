package com.study.sort.shell;

import java.util.Arrays;

/**
* @author 叶林生 
* @date：2017年7月30日 下午6:54:26
* @version 1.0
* 
*/
public class TestShell {
	
	public static void main(String[] args) {
		/*int[] arr = {8,9,1,7,2,3,5,4,6,0};
		ShellSort sort = new ShellSort(arr);
		sort.sort();
		System.out.println(Arrays.toString(arr));*/
		
		int[] arr = {0,90,56,896,5,48,96,65,8,49,92};
		MyShellSort sort = new MyShellSort(arr);
		sort.sort(arr.length);
		System.out.println(Arrays.toString(arr));
	}

}
