package com.study.search;
/**
* @author 叶林生 
* @date：2017年7月26日 上午11:33:45
* @version 1.0
* 
*/

import org.junit.Test;

import com.study.search.binary.BinarySearch;

public class TestSearch {
	
	@Test
	public void binarySearch() {
		Integer[] integers = {1,2,3,4,5,6,7,8,9,10,11};
		//int index = BinarySearch.binarySearch(integers, 0, 11, 5);
		int index = BinarySearch.binarySearch(integers, 0, 11, 5, new MyCompare<>());
		System.out.println(index);
	}

}
