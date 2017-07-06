package com.study.java.reflect.proxy;
/**
 *
 * @author 叶林生
 *
 * @date 2017年6月20日 下午3:17:18
 *
 * @version 1.0
 * 
 */
public class Ticket_Station implements Ticket {

	@Override
	public int buy() {
		System.out.println("买两张票");
		return 123;
	}

}
