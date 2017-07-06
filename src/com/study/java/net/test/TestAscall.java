package com.study.java.net.test;
/**
* @author 叶林生 
* @date：2017年7月1日 上午11:19:39
* @version 1.0
* 
*/
public class TestAscall {
	public static void main(String[] args) {
		String string="abc";
		byte[] b=string.getBytes();
		for (byte c : b) {
			System.out.println(c);
		}
		
	}
}
