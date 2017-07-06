package com.study.java.io.test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author 叶林生
 *
 * @date 2017年6月15日 上午9:06:22
 *
 * @version 1.0
 * 
 */
public class FileInput implements Runnable {
	
	private FileSource source = null;
	private FileInputStream in = null;
	
	public FileInput(FileSource source, FileInputStream in) {
		this.source = source;
		this.in = in;
	}

	@Override
	public void run() {
		long start1 = System.currentTimeMillis();
		BufferedInputStream bis = null;
		int b_source = 0;
		source.lock.lock();
		try {
			bis = new BufferedInputStream(in);
			while((b_source = bis.read()) != -1) {
				if (source.flag) {//如果输入流读取到了文件，则等待输出流取走
					source.input.await();
				} else {
					source.setSource(b_source);
					source.flag = true;//关闭输入
					source.output.signal();//唤醒输出
				}
			}
			source.setSource(-1);
		} catch (IOException |InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			source.lock.unlock();//释放锁
			if (bis != null) {
				try {
					bis.close();//释放资源
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		long end1 = System.currentTimeMillis();
		System.out.println("读取........... "+(end1 - start1));

	}

}
