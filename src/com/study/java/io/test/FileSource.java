package com.study.java.io.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author 叶林生
 *
 * @date 2017年6月14日 下午8:51:52
 *
 * @version 1.0
 * 
 */
public class FileSource {
	
	private int source;
	public boolean flag;
	public ReentrantLock lock = new ReentrantLock();
	public Condition input = lock.newCondition();
	public Condition output = lock.newCondition();
	
	
	public int getSource() {
		return source;
	}
	public void setSource(int source) {
		this.source = source;
	}
	
	

}
