package com.study.java.string;

/**
 *
 * @author 叶林生
 *
 * @date 2017年6月22日 上午8:25:50
 *
 * @version 1.0
 * 
 *          获取一个字符串在另一个字符串中出现的次数。 "abkkcdkkefkkskk" kk
 * 
 *          思路： 1，定义个计数器。 
 *          	  2，获取kk第一次出现的位置。
 *          	  3，从第一次出现位置后剩余的字符串中继续获取kk出现的位置。
 *                   每获取一次就计数一次。 
 *         		  4，当获取不到时，计数完成。
 * 
 */
public class CountStrNum {
	
	public static void main(String[] args) {
		String src = "abkkcdkkefkkskk";
		String key = "kk";
		int count = countStr(src, key);
		System.out.println(count);
	}
	
	public static int countStr(String src, String key){
		int index = 0;
		int count = 0;
		while((index = src.indexOf(key, index)) != -1) {
			index += key.length();
			count ++;
		}
		return count;
	}

}
