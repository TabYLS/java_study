package com.study.java.net.udp.chart;

import java.net.DatagramSocket;
import java.net.SocketException;

/**
* @author 叶林生 
* @date：2017年6月26日 下午9:59:06
* @version 1.0
* 
*/
public class Chart {
	
	public static void main(String[] args) {
		try {
			DatagramSocket send = new DatagramSocket(9001);
			DatagramSocket receive = new DatagramSocket(8888);
			
			new Thread(new Receive(receive)).start();
			new Thread(new Send(send)).start();
		} catch (SocketException e) {
			e.printStackTrace();
		}
		
	}

}
