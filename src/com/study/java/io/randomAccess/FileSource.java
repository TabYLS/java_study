package com.study.java.io.randomAccess;

import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author 叶林生
 *
 * @date 2017年6月19日 上午10:57:36
 *
 * @version 1.0
 * 
 */
public class FileSource {
	
	/*每个线程需要处理部分文件的大小*/
	public final long EACH_PART_SIZE = 1024 * 1024 * 600;//600M
	/*文件的大小*/
	private float file_size = 0;
	/*读取一个文件所需要的线程的个数*/
	private int threadNum = 0;
	
	public FileSource(String fileDir){
		try {
			file_size = new FileInputStream(fileDir).available();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int getThreadNum() {//得到线程数量
		threadNum = (int) (file_size / EACH_PART_SIZE == 0 ? file_size / EACH_PART_SIZE : file_size / EACH_PART_SIZE + 1);
		return threadNum;
	}

	public float getFile_size() {
		return file_size;
	}
	
}
