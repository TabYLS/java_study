package com.study.java.net.test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestNet {
	
	public static void main(String[] args) {
		try {
			InetAddress ip = InetAddress.getLocalHost();
			System.out.println(ip.getHostName());
			System.out.println(ip.getHostAddress());
			System.out.println(ip.getAddress()[3]);
			
			InetAddress ip2 = InetAddress.getByName("www.baidu.com");
			System.out.println(ip2.getHostAddress());
			System.out.println(ip2.getCanonicalHostName());
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
