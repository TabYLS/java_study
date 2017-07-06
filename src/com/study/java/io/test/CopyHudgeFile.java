package com.study.java.io.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 
 * @author YLS
 * 
 * 通过读写各创建一个线程来实现
 *
 */
public class CopyHudgeFile {
	
	public static void main(String[] args) throws IOException {
		long start1 = System.currentTimeMillis();
		FileInputStream in = new FileInputStream("H:\\鍙舵灄鐢焅\\涓嬭浇.rar");
		long end1 = System.currentTimeMillis();
		System.out.println(end1 - start1);
		
		//FileOutputStream out = new FileOutputStream("H:\\鍙舵灄鐢焅\\涓嬭浇_copy.rar");
		long start2 = System.currentTimeMillis();
		copy_1(in);
		//copy_2(in, out);
		long end2 = System.currentTimeMillis();
		System.out.println(end2 - start2);
		
	}
	
	/**
	 * 通过单个线程消耗101911 时间为milliseconds毫秒
	 * @param in
	 * @throws IOException
	 */
	public static void copy_1(InputStream in) throws IOException{
		FileOutputStream out = new FileOutputStream("H:\\鍙舵灄鐢焅\\缃戦〉鍒朵綔thread_copy.rar");
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			bis = new BufferedInputStream(in);
			bos = new BufferedOutputStream(out);
			
			int b = 0;
			while((b = bis.read()) != -1) {
				bos.write(b);
			}
		} finally {
			if (bos != null) {
				bos.close();
			}
			if (bis != null) {
				bis.close();
			}
		}
	}
	
	public static void copy_2(FileInputStream in, FileOutputStream out){
		FileSource source = new FileSource();
		
		FileInput input = new FileInput(source, in);
		FileOutput output = new FileOutput(source, out);
		
		Thread input_thread = new Thread(input);
		Thread output_thread = new Thread(output);
		
		input_thread.start();
		output_thread.start();
	}
	

}
