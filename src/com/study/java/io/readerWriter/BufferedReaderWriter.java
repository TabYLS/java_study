package com.study.java.io.readerWriter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

/**
 * 练习使用BufferedReader和BufferedWriter
 * 
 * 使用BufferedReader和BufferedWriter来实现拷贝文件
 * @author YLS
 *
 */
public class BufferedReaderWriter {
	
	@Test
	public void copy(){
		BufferedReader bufr = null;//可以读一个字符read()也可以读一整行readLine()
		BufferedWriter bufw = null;
		
		String line = null;
		try {
			FileReader fileReader = new FileReader(".\\src\\com\\study\\java\\io\\readerWriter\\BufferedReaderWriter.java");
			bufr = new BufferedReader(fileReader);//使用缓冲之前一定先有流对象
			bufw = new BufferedWriter(new FileWriter("./src/com/study/java/io/readerWriter/FileReaderWriter_copy.java"));
			
			//readLine()的返回值：包含该行内容的字符串，不包含任何行终止符，如果已到达流末尾，则返回 null
			int cout = 0;
			while((line = bufr.readLine()) != null){
				bufw.write(line);
				if (++cout%10 == 0) {
					bufw.write("/*拷贝文件拷贝文件*/");
				}
				bufw.newLine();//这个换行符具有跨平台性
				bufw.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (bufr != null) {
					bufr.close();
				}
				if (bufw != null) {
					bufw.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
