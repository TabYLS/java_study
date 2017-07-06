package com.study.java.io.inOutPutStream;

import java.io.IOException;
import java.io.InputStream;

public class MyBufferedStream {
	
	private int count = 0;//计数器，用以统计流对象读取到的个数
	private int pos = 0;//指针，用以返回结果的下标
	private byte[] buff = new byte[1024 * 4];
	private InputStream is;
	
	public MyBufferedStream(InputStream is) {
		this.is = is;
	}
	
	public int myRead() throws IOException{
		if (count == 0) {
			count = is.read(buff);
			if (count < 0) 
				return -1;
			pos = 0;
			byte b = buff[pos];
			pos ++;
			count --;
			return b & 255;//计算机中通常采用补码的方式存储数据，八位表示一个字节，为了避免出现八个一一起出现的情况，应使高位补零，所以与上255（255的码取低八位：11111111 11111111 11111111 11111111 ）
		} else if(count > 0){
			byte b = buff[pos];
			pos ++;
			count --;
			return b & 0xff;//0xff是十六进制的表示方式
		}
		return -1;
	}
	
	public void close() throws IOException{
		is.close();
	}

}
