package com.study.java.net.tcp.trans;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
* @author 叶林生 
* @date：2017年6月27日 下午8:58:57
* @version 1.0
* 
*/
public class Server {
	
	/*
	 * 服务器端的版本1
	 * public static void main(String[] args) {
		//1，建立服务端的socket服务。ServerSocket();并监听一个端口。
		ServerSocket ssk =null;
		Socket sk = null;
		BufferedReader buffIn = null;
		PrintWriter out = null;
		try {
			ssk = new ServerSocket(9001);
			//2，获取连接过来的客户端对象。
			//通过ServerSokcet的 accept方法。没有连接就会等，所以这个方法阻塞式的。
			sk = ssk.accept();
			
			//3，客户端如果发过来数据，那么服务端要使用对应的客户端对象，并获取到该客户端对象的读取流来读取发过来的数据。
			//并打印在控制台。
			
			buffIn = new BufferedReader(new InputStreamReader(sk.getInputStream()));
			out = new PrintWriter(sk.getOutputStream(),true);//这种方式就不用手动刷新了
			String line = null;
			
			String ip = sk.getInetAddress().getHostAddress();
			int port = sk.getPort();
			while((line = buffIn.readLine()) != null) {
				System.out.println("ip:  " + ip + "  port:  " + port + ":   " + line);
				out.println(line.toUpperCase());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (buffIn != null) {
					buffIn.close();
				}
				if (sk != null) {
					sk.close();
				}
				if (ssk != null) {
					ssk.close();
				}//可选操作，服务器可以不关
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}*/
	
	/**
	 * 服务器端的版本2
	 * @param args
	 */
	public static void main(String[] args) {
		//1，建立服务端的socket服务。ServerSocket();并监听一个端口。
		ServerSocket ssk =null;
		Socket sk = null;
		BufferedReader buffIn = null;
		PrintWriter out = null;
		try {
			ssk = new ServerSocket(9001);
			//2，获取连接过来的客户端对象。
			//通过ServerSokcet的 accept方法。没有连接就会等，所以这个方法阻塞式的。
			sk = ssk.accept();
			
			//3，客户端如果发过来数据，那么服务端要使用对应的客户端对象，并获取到该客户端对象的读取流来读取发过来的数据。
			//并打印在控制台。
			
			buffIn = new BufferedReader(new InputStreamReader(sk.getInputStream()));
			out = new PrintWriter(sk.getOutputStream(),true);//这种方式就不用手动刷新了
			String line = null;
			
			String ip = sk.getInetAddress().getHostAddress();
			int port = sk.getPort();
			while(true) {
				line = buffIn.readLine();
				if ("bye".equals(line)) {//接到客户端的终止命令结束
					if (out != null) {
						out.close();
					}
					if (buffIn != null) {
						buffIn.close();
					}
					if (sk != null) {
						sk.close();
					}
				} else if (line != null) {
					System.out.println("ip:  " + ip + "  port:  " + port + ":   " + line);
					out.println(line.toUpperCase());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ssk != null) {
					ssk.close();
				}//可选操作，服务器可以不关
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
