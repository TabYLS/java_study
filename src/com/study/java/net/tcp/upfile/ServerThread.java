package com.study.java.net.tcp.upfile;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
* @author 叶林生 
* @date：2017年6月28日 下午9:10:21
* @version 1.0
* 
*/
public class ServerThread {
	
	public static void main(String[] args) {
		ServerSocket ssk;
		try {
			ssk = new ServerSocket(9003);
			while(true) {
				Socket sk = ssk.accept();
				System.out.println(sk.getInetAddress().getHostAddress());
				new Thread(new FileThread(sk)).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
