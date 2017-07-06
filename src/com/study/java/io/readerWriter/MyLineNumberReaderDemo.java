package com.study.java.io.readerWriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;


/**
 * 模拟一个LineNumberReader
 * @author YLS
 *
 */
public class MyLineNumberReaderDemo {
	
	public static void main(String[] args) {
		FileReader reader = null;
		MyLineNumberReader myLineNumberReader = null;
		try {
			reader = new FileReader(".\\src\\com\\study\\java\\io\\readerWriter\\MyLineNumberReaderDemo.java");
			myLineNumberReader = new MyLineNumberReader(reader);
			String line = null;
			while((line = myLineNumberReader.myReadLine()) != null)
				System.out.println(line);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(myLineNumberReader != null)
					myLineNumberReader.myClose();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

/*class MyLineNumberReader {
	
	private Reader reader;//首先有流对象去读取
	
	private int lineNumber = 0;
	
	public MyLineNumberReader(Reader reader) {
		this.reader = reader;
	}
	
	public String readLine() {
		this.lineNumber ++;
		int ch = 0;
		StringBuilder sb = new StringBuilder();
		try {
			while ((ch = this.reader.read()) > 0) {
				if(ch == '\r')
					continue;
				if(ch == '\n') {
					return sb.toString();
				} else {
					sb.append((char)ch);
				}
			}
			if (sb.length() != 0)
				return sb.toString();
			else
				return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void myClose() throws IOException{
		this.reader.close();
	}
	
	*//**
	 * 返回当前的行数
	 * @return
	 *//*
	public int getLineNumber() {
        return lineNumber;
    }

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}
	
}
*/

/**
 * 优化代码，因为发现LineNumberReader继承了BufferedReader从而调用了BufferedReader的readLine方法
 * 所以，MyLineNumberReader也可以继承MyBufferedReaderDemo
 * @author YLS
 *
 */
class MyLineNumberReader extends MyBufferedReader {
	
	private Reader reader;//首先有流对象去读取
	
	private int lineNumber = 0;
	
	public MyLineNumberReader(Reader reader) {
		super(reader);
		this.reader = reader;
	}
	
	public String myReadLine() {
		this.lineNumber ++;
		return super.myReadLine();
	}
	
	public void myClose() throws IOException{
		this.reader.close();
	}
	
	/*
	 * 返回当前的行数
	 * @return
	 */
	public int getLineNumber() {
        return lineNumber;
    }

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}
	
}