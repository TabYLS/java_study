package com.study.java.net.udp.chart;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
* @author 叶林生 
* @date：2017年6月26日 下午9:53:58
* @version 1.0
* 
*/
public class Receive implements Runnable {
	
	private DatagramSocket socket;
	public Receive(DatagramSocket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			while(true){
				byte[] buf = new byte[1024];
				DatagramPacket data = new DatagramPacket(buf, buf.length);
				socket.receive(data);
				
				String ip = data.getAddress().getHostAddress();
				int port = data.getPort();
				String message = new String(data.getData(), 0, data.getLength());
				System.out.println("ip: " + ip + "  port: " + port + "  message: " + message);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (socket != null) {
				socket.close();
			}
		}

	}

}
