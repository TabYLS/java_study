package com.study.java.io.test;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author 叶林生
 *
 * @date 2017年6月15日 上午9:06:44
 *
 * @version 1.0
 * 
 */
public class FileOutput implements Runnable {
	
	private FileSource source = null;
	private FileOutputStream out = null;
	
	public FileOutput(FileSource source, FileOutputStream out) {
		this.source = source;
		this.out = out;
	}

	@Override
	public void run() {
		long start1 = System.currentTimeMillis();
		BufferedOutputStream bos = null;
		source.lock.lock();
		try {
			while(true) {
				if (source.getSource() == -1)
					break;
				if (!source.flag) {
					source.output.await();
				} else {
					bos = new BufferedOutputStream(out);
					bos.write(source.getSource());
					source.flag = false;
					source.input.signal();
				}
			}
		} catch (InterruptedException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			source.lock.unlock();
			if(bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		long end1 = System.currentTimeMillis();
		System.out.println("输出。。。。。。。。。。。。 "+(end1 - start1));
	}

}
