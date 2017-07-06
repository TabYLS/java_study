package com.study.java.net.test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SocketSend {
	
	public static void main(String[] args) {
		DatagramSocket socket = null;
		try {
			//发送端，创建socket对象时是不需要ip地址的
			socket = new DatagramSocket();
			
			String data = "你好啊！！！！！！";
			byte[] bufr = data.getBytes();//3520
			
			DatagramPacket packet = new DatagramPacket(bufr, bufr.length, InetAddress.getByName("192.168.73.55"), 55058);
			
			socket.send(packet);
			
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
