package com.study.java.net.tcp.myserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
* @author 叶林生 
* @date：2017年6月30日 下午3:26:36
* @version 1.0
* 
*/
public class MyServer {

	public static void main(String[] args) throws IOException {
		ServerSocket ssk = new ServerSocket(9000);
		Socket s = ssk.accept();
		s.setSoTimeout(3000);
		InputStream in = s.getInputStream();
		byte[] buffr = new byte[1024];
		int len = 0;
		while((len = in.read(buffr)) != -1) {//read方法读取网络数据的时候会发生阻塞，原因不详，所以在这里一直无法返回读取到数值停在这里
			System.out.println(new String(buffr, 0, len));
		}
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		out.println("<font color='red' size='7'>客户端你好</font>");

		s.close();
		ssk.close();
	}
	
	public void test1() throws IOException {
		ServerSocket ssk = new ServerSocket(9000);
		
		Socket s = ssk.accept();
		System.out.println(s.getInetAddress().getHostAddress());

		InputStream in = s.getInputStream();

		byte[] buf = new byte[1024];

		int len = in.read(buf);

		System.out.println(new String(buf,0,len));


		PrintWriter out = new PrintWriter(s.getOutputStream(),true);

		out.println("<font color='red' size='7'>客户端你好</font>");

		s.close();

		ssk.close();
	}
}
