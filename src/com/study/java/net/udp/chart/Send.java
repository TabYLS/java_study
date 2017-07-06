package com.study.java.net.udp.chart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
* @author 叶林生 
* @date：2017年6月26日 下午9:47:36
* @version 1.0
* 
*/
public class Send implements Runnable {
	
	private DatagramSocket socket;
	public Send(DatagramSocket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		try {
			while((line = reader.readLine()) != null) {
				if (line.equals("bye"))
					break;
				DatagramPacket p = new DatagramPacket(line.getBytes(), line.getBytes().length, InetAddress.getByName("192.168.73.4"), 8888);
				socket.send(p);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (socket != null) {
				socket.close();
			}
		}
	}

}
