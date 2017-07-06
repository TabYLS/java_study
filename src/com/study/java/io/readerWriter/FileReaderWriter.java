package com.study.java.io.readerWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



import org.junit.Test;

/**
 * 练习FileReader和RileWriter
 * 使用FileReader和FileWriter来实现文件的拷贝
 * 
 * read方法的返回值：作为一个整数（其范围从 0 到 65535 (0x00-0xffff)）读入的字符，如果已到达流末尾，则返回 -1 
 * @author YLS
 *
 */
public class FileReaderWriter {
	
	/**
	 * 读一个字符，就写一个字符。
	 */
	@Test
	public void copy_1(){
		FileReader reader = null;
		FileWriter writer = null;
		try {
			//读取文件，与已有文件关联
			reader = new FileReader(".\\src\\com\\study\\java\\io\\readerWriter\\FileReaderWriter.java");
			
			//创建目标文件
			writer = new FileWriter("./src/com/study/java/io/readerWriter/FileReaderWriter_copy_1.java");
			
			int ch = 0;
			while((ch = reader.read()) != -1) {
				writer.write(ch);//读一个写一个
			}
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
				/*if(writer != null){
					writer.close();//writer写入磁盘一定记得要么close要么flush，不然数据无法刷新到磁盘
				}*/
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void copy_2() {
		FileReader fr = null;
		FileWriter fw = null;
		
		try {
			//读取文件，与已有文件关联
			fr = new FileReader(".\\src\\com\\study\\java\\io\\readerWriter\\FileReaderWriter.java");
			//创建目标文件
			fw = new FileWriter("./src/com/study/java/io/readerWriter/FileReaderWriter_copy_2.java");
			
			char[] ch = new char[1024];
			int len = 0;
			
			while((len = fr.read(ch)) != -1){//read(char[] cbuf)方法的返回值：读取的字符数，如果已到达流的末尾，则返回 -1
				fw.write(ch, 0, len);//将数组当中的内容，从第一个位置开始一直到刚刚读到的内容，而不会包含上一次的内容或者空数据（防止脏数据）
				//read(ch)方法采用的是覆盖的模式，就是说，每一次都是从零这个位置开始一直覆盖上一次的内容，直到数组ch填满为止
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//throw new RuntimeException("读写失败");
			System.out.println("读写失败");
			e.printStackTrace();
		}finally {
			try {
				if (fr != null) {
					fr.close();
				}
				if(fw != null){
					fw.close();//writer写入磁盘一定记得要么close要么flush，不然数据无法刷新到磁盘
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
