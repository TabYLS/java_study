package com.study.java.io.readerWriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class LineNumberReaderDemo {
	
	public static void main(String[] args) {
		FileReader reader;
		try {
			reader = new FileReader(".\\src\\com\\study\\java\\io\\readerWriter\\LineNumberReaderDemo.java");
			LineNumberReader lineNumberReader = new LineNumberReader(reader);
			String line = null;
			lineNumberReader.setLineNumber(100);//设置初始索引
			try {
				while((line = lineNumberReader.readLine()) != null ) {
					System.out.println(lineNumberReader.getLineNumber() + ":" +line);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
