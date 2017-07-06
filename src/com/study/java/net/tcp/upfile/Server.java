package com.study.java.net.tcp.upfile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
* @author 叶林生 
* @date：2017年6月28日 下午1:31:43
* @version 1.0
* 
*/
public class Server {
	
	public static void main(String[] args) {
		ServerSocket ssk = null;
		Socket sk = null;
		ObjectInputStream objIn = null;
		BufferedReader reader = null;
		PrintWriter out = null;
		try {
			ssk = new ServerSocket(9003);
			sk = ssk.accept();
			String ip = sk.getInetAddress().getHostAddress();
			int port = sk.getPort();
			System.out.println("ip:  " + ip + "  port:  " + port + "connection.....");
			objIn = new ObjectInputStream(sk.getInputStream());
			File file = (File) objIn.readObject();
			reader = new BufferedReader(new InputStreamReader(sk.getInputStream()));
			String fileName = file.getName();
			String path = file.getPath();
			System.out.println(path);
			out = new PrintWriter(new FileWriter(path.replace(fileName, fileName + "server.txt")), true);
			String line = null;
			while((line = reader.readLine()) != null) {
				out.println(line);
			}
			PrintWriter pw = new PrintWriter(sk.getOutputStream(),true);
			pw.println("上传成功！");
			out.close();
			reader.close();
			objIn.close();
			sk.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
