package com.study.java.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author 叶林生
 * @date：2017年6月26日 下午9:04:25
 * @version 1.0
 * 
 *          需求： 定义一个应用程序，用于接收udp协议传输的数据并处理的。
 * 
 * 
 *          定义udp的接收端。 
 *          思路： 
 *          1，定义udpsocket服务。通常会监听一个端口。其实就是给这个接收网络应用程序定义数字标识。
 *          方便于明确哪些数据过来该应用程序可以处理。
 *          2，定义一个数据包，因为要存储接收到的字节数据。 因为数据包对象中有更多功能可以提取字节数据中的不同数据信息。
 *          3，通过socket服务的receive方法将收到的数据存入已定义好的数据包中。
 *          4，通过数据包对象的特有功能。将这些不同的数据取出。打印在控制台上。
 *          5，关闭资源。
 * 
 */
public class UdpReceive {
	
	public static void main(String[] args) {
		DatagramSocket socket = null;
		try {
			//1.创建udp socket连接，确定端口
			socket = new DatagramSocket(8888);
			while(true) {
				//2.定义数据包，用来接收数据
				byte[] bufr = new byte[1024];
				DatagramPacket data = new DatagramPacket(bufr, bufr.length);
				//3.通过服务的receive方法将数据存放到数据包中
				socket.receive(data);//阻塞式方法
				String message = new String(data.getData(), 0, data.getLength());
				String ip = data.getAddress().getHostAddress();
				int port = data.getPort();
				System.out.println("ip: " + ip + "  port: " + port + "  message: " + message);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//4.关闭资源
			if (socket != null)
				socket.close();
		}
	}

}
