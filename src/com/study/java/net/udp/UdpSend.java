package com.study.java.net.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author 叶林生
 * @date：2017年6月26日 下午8:32:05
 * @version 1.0
 * 
 *          需求：通过udp传输方式，将一段文字数据发送出去。， 定义一个udp发送端。 
 *          思路：
 *           1，建立updsocket服务。
 *           2，提供数据，并将数据封装到数据包中。
 *           3，通过socket服务的发送功能，将数据包发出去。
 *           4，关闭资源。
 * 
 * 
 */
public class UdpSend {

	public static void main(String[] args) {
		//1.通过DatagramSocket建立udp服务
		DatagramSocket socket = null;
		try {
			socket = new DatagramSocket(9001);//给发送端确定一个端口，可以不显式定义，虚拟机会隐式的分配
			//2.确定数据源
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String line = null;
			while((line = reader.readLine()) != null) {
				if (line.equals("bye"))
					break;
				//3.将数据通过DatagramPacket封装成数据包，监听接收端的端口
				DatagramPacket p = new DatagramPacket(line.getBytes(), line.getBytes().length, InetAddress.getByName("192.168.73.4"), 8888);
				//4.通过socket服务将数据包发送出去
				socket.send(p );
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (socket != null) {
				//5.将资源关闭
				socket.close();
			}
		}
	}

}
