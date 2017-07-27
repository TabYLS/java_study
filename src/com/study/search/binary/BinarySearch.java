package com.study.search.binary;

import java.util.Comparator;

/**
* @author 叶林生 
* @date：2017年7月26日 上午10:16:49
* @version 1.0
* 
*/
public class BinarySearch {
	
	/**
	 * 需要注意的是计算中间位置时不应该使用(high+ low) / 2的方式，
	 * 因为加法运算可能导致整数越界，
	 * 这里应该使用以下三种方式之一：
	 * low + (high – low) / 2
	 * 或low + (high – low) >> 1
	 * 或(low + high) >>> 1（>>>是逻辑右移，是不带符号位的右移）
	 * @param t
	 * @param low
	 * @param hight
	 * @param key
	 * @return
	 */
	public static <T extends Comparable<T>> int binarySearch(T[] t, int low, int high, T key) {
		if (low < 0 || high >= t.length) {
			System.out.println("参数范围不合法！");
			return -1;
		}
		if (low <= high) {
			int mid = (low + high) >>> 1;
			if (key.compareTo(t[mid]) == 0) {
				return mid;
			} else if (key.compareTo(t[mid]) < 0) {
				return binarySearch(t, low, mid - 1, key);
			} else {
				return binarySearch(t, mid + 1, high, key);
			}
		}
		return -1;
	}
	
	/**
	 * 给不具有比较性的对象使用，或者覆盖原有比较性
	 * @param t
	 * @param low
	 * @param high
	 * @param key
	 * @param com
	 * @return
	 */
	public static <T> int binarySearch(T[] t, int low, int high, T key, Comparator<T> com){
		while(low <= high) {
			int mid = low + ((high - low) >> 1);
			int temp = com.compare(key, t[mid]);
			if (temp < 0) {
				high = mid -1;
			} else if (temp > 0) {
				low = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

}
