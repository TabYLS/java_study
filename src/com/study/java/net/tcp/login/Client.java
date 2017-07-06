package com.study.java.net.tcp.login;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
* @author 叶林生 
* @date：2017年6月29日 下午4:52:09
* @version 1.0
* 
*/
public class Client {
	
	public static void main(String[] args) {
		Socket sk = null;
		BufferedReader reader = null;
		try {
			sk = new Socket("192.168.73.4", 9000);
			reader = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter writer = new PrintWriter(sk.getOutputStream(), true);
			
			BufferedReader buffr = new BufferedReader(new InputStreamReader(sk.getInputStream()));
			for(int i = 0; i < 3; i ++) {
				String line = reader.readLine();
				if (line == null)
					break;
				writer.println(line);
				
				String result = buffr.readLine();
				System.out.println(result);
				if (result.contains("欢迎")) {
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					if (sk != null) {
						try {
							sk.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

}
