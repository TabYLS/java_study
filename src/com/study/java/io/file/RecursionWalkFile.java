package com.study.java.io.file;

import java.io.File;

/**
 * @author 叶林生
 * @date 2017年6月13日 下午2:59:13
 * @version 1.0
 * 
 * 
 * 递归查找文件，如果遇到文件夹下面还有文件夹则一直递归查找下去。
 */
public class RecursionWalkFile {
	
	public static void main(String[] args) {
		File file = new File("D:\\NEON_vision\\workspace\\java_study");
		//System.out.println(file.getAbsolutePath());
		showDir(file);
	}
	
	public static void showDir(File file){
		File[] files = file.listFiles();
		System.out.println("目录： "+file);
		for (File file2 : files) {
			if (file2.isDirectory()) {//如果是文件夹，则递归查找
				showDir(file2);
			}
			System.out.println(file2);
		}
		
	}

}
