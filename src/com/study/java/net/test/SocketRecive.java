package com.study.java.net.test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class SocketRecive {
	
	public static void main(String[] args) {
		DatagramSocket socket = null;
		try {
			socket = new DatagramSocket(9001);
			
			byte[] buf = new byte[1024];
			DatagramPacket packet = new DatagramPacket(buf , buf.length);
			
			socket.receive(packet);
			String message = new String(buf, 0, buf.length);
			System.out.println(message);
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
