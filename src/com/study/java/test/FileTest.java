package com.study.java.test;

import java.io.File;

/**
* @author 叶林生 
* @date：2017年6月28日 下午3:02:29
* @version 1.0
* 
*/
public class FileTest {
	
	public static void main(String[] args) {
		for (String string : args) {
			System.out.println(string);
		}
		File file = new File(".\\src\\com\\study\\java\\net\\tcp\\upfile\\Client.java");
		//File file = new File("D:\\");
		int test = 111_555;
		System.out.println(test);
		System.out.println(file.getName());
		System.out.println(file.getPath());
		System.out.println(file.getAbsolutePath());
	}

}
