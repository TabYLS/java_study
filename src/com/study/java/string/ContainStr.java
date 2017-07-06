package com.study.java.string;

/**
 * @author 叶林生
 * @date：2017年6月22日 下午3:15:25
 * @version 1.0
 * 
 * 
 *          4，获取两个字符串中最大相同子串。
 *             第一个动作：将短的那个串进行长度一次递减的子串打印。
 *            "abcwerthelloyuiodef"   "cvhellobnm"
 *            思路： 1，将短的那个子串按照长度递减的方式获取到。 
 *                  2，将每获取到的子串去长串中判断是否包含，
 *                     如果包含，已经找到！。
 */
public class ContainStr {

	public static void main(String[] args) {
		String result  = getMaxSubString("abcwerthelloyuiodef","cvhellobnm");
		System.out.println(result);
	}
	
	public static String getMaxSubString(String s1, String s2) {
		String max = (s1.length() >= s2.length()) ? s1 : s2;
		String min = (max == s1) ? s2 : s1;
		String temp = "";
		for (int i = 0; i < min.length(); i++) {
			for (int j = min.length() - i,index = 0; j < min.length(); j++, index ++) {
				temp = min.substring(index, j);
				if (max.contains(temp)) 
					return temp;
			}
			
		}
		return "";
	}

}
