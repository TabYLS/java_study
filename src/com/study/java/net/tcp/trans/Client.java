package com.study.java.net.tcp.trans;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
* @author 叶林生 
* @date：2017年6月27日 下午8:37:40
* @version 1.0
* 
*/
public class Client {
	
	public static void main(String[] args) {
		//1.建立服务
		Socket sk = null;
		BufferedWriter buffOut = null;
		BufferedReader buffIn = null;
		try {
			sk = new Socket("192.168.73.4", 9001, InetAddress.getByName("192.168.73.4"), 9008);
			//2.读取键盘录入
			BufferedReader reader = 
					new BufferedReader(new InputStreamReader(System.in));
			//3.从socket中获取输出流，向服务器发送数据
			buffOut = new BufferedWriter(new OutputStreamWriter(sk.getOutputStream()));
			//4.从socket中获取输入流从服务器中接收数据
			buffIn = new BufferedReader(new InputStreamReader(sk.getInputStream()));
			String line = null;
			String ip = sk.getInetAddress().getHostAddress();
			int port = sk.getPort();
			while((line = reader.readLine()) != null) {//5.发送和接受数据
				if ("bye".equals(line))
					break;
				buffOut.write(line);
				buffOut.newLine();//这里要加上换行符号，因为readLine在读取到换行符号之后才会停止，不然服务器端会一直等待
				buffOut.flush();//写在缓存中的数据需要刷新
				
				String callback = buffIn.readLine();
				System.out.println("ip:  " + ip + "  port:  " + port + ":   " + callback);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (buffIn != null) {
					buffIn.close();
				}
				if (buffOut != null) {
					buffOut.close();
				}
				if (sk != null) {
						sk.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
