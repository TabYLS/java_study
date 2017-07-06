package com.study.java.net.tcp.login;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
* @author 叶林生 
* @date：2017年6月29日 下午4:52:00
* @version 1.0
* 
*/
public class Server {
	
	public static void main(String[] args) {
		ServerSocket ssk = null;
		try {
			ssk = new ServerSocket(9000);
			while(true) {
				Socket sk = ssk.accept();
				new Thread(new UserThread(sk)).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
