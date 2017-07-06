package com.study.java.io.inOutPutStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 演示avi视频的复制。通过缓冲区。 BufferedOutputStream BufferedInputStream
 * 
 * 缓冲区是为了提高效率而存在的，因此在创建缓冲区之前一定要先有流对象，不管是字符流还是字节流
 */
public class BufferedStream_CopyAVI {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		copy_2();
		long end = System.currentTimeMillis();
		
		System.out.println((end - start) + "毫秒");
	}
	
	public static void copy_1(){
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			FileInputStream fis = new FileInputStream(".\\src\\com\\study\\java\\io\\inOutPutStream\\1.avi");
			FileOutputStream fos = new FileOutputStream(".\\src\\com\\study\\java\\io\\inOutPutStream\\1_copy.avi");
			
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			
			int ch = 0;
			while((ch = bis.read()) >= 0){//注意这里使用的判断条件，最好使用!= -1,一定不能使用 (ch = bis.read()) > 0,因为ch的值可以为0
				//System.out.println(ch);
				bos.write(ch);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("拷贝文件失败");
		} finally {
			try {
				if(bos != null)
					bos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				throw new RuntimeException("写入关闭失败");
			} finally {
				if (bis != null)
					try {
						bis.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
						throw new RuntimeException("读取关闭失败");
					}
			}
		}
	}
	
	public static void copy_2(){
		MyBufferedStream bis = null;
		BufferedOutputStream bos = null;
		try {
			FileInputStream fis = new FileInputStream(".\\src\\com\\study\\java\\io\\inOutPutStream\\1.avi");
			FileOutputStream fos = new FileOutputStream(".\\src\\com\\study\\java\\io\\inOutPutStream\\2_copy.avi");
			
			bis = new MyBufferedStream(fis);
			bos = new BufferedOutputStream(fos);
			
			int ch = 0;
			while((ch = bis.myRead()) >= 0){//注意这里使用的判断条件，最好使用!= -1,一定不能使用 (ch = bis.read()) > 0,因为ch的值可以为0
				//System.out.println(ch);
				bos.write(ch);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new RuntimeException("拷贝文件失败");
		} finally {
			try {
				if(bos != null)
					bos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				throw new RuntimeException("写入关闭失败");
			} finally {
				if (bis != null)
					try {
						bis.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
						throw new RuntimeException("读取关闭失败");
					}
			}
		}
	}
	
}
