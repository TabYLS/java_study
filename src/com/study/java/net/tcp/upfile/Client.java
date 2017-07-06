package com.study.java.net.tcp.upfile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
* @author 叶林生 
* @date：2017年6月28日 下午1:31:59
* @version 1.0
* 
*/
public class Client {
	
	public static void main(String[] args) {
		Socket sk = null;
		ObjectOutputStream objOut = null;
		PrintWriter out = null;
		BufferedReader reader = null;
		try {
			//1.开启socket服务
			sk = new Socket("192.168.73.4", 9003, InetAddress.getByName("192.168.73.4"), 9004);
			//2.得到上传资源的文件对象
			///java_study/
			objOut = new ObjectOutputStream(sk.getOutputStream());
			//3.获取网络传输流
			out = new PrintWriter(sk.getOutputStream(), true);
			//4.先将要上传的文件对象传到服务器,把文件对象传到服务器中方便服务器中对上传文件的操作
			objOut.writeObject(new File("D:\\NEON_vision\\workspace\\java_study\\.\\src\\com\\study\\java\\net\\tcp\\upfile\\Client.java"));
			//5.用输入流获取资源
			reader = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\NEON_vision\\workspace\\java_study\\.\\src\\com\\study\\java\\net\\tcp\\upfile\\Client.java"), "utf-8"));
			//6.将资源流通过网络输出流输出到服务器
			String line = null;
			while((line = reader.readLine()) != null) {
				out.println(line);
			}
			//7.文件上传完成之后关闭socket并通知服务器
			sk.shutdownOutput();
			reader = new BufferedReader(new InputStreamReader(sk.getInputStream()));
			System.out.println(reader.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try{
				reader.close();
				out.close();
				objOut.close();
				sk.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
