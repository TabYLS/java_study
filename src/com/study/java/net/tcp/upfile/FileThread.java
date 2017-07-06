package com.study.java.net.tcp.upfile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
* @author 叶林生 
* @date：2017年6月28日 下午9:11:30
* @version 1.0
* 
*/
public class FileThread implements Runnable {
	private Socket sk = null;
	
	public FileThread(Socket sk) {
		this.sk = sk;
	}

	@Override
	public void run() {
		int count = 1;
		ObjectInputStream objIn = null;
		InputStream in = null;
		OutputStream out = null;
		try {
			
			String ip = sk.getInetAddress().getHostAddress();
			int port = sk.getPort();
			System.out.println("ip:  " + ip + "  port:  " + port + "connection.....");
			objIn = new ObjectInputStream(sk.getInputStream());
			File file = (File) objIn.readObject();//文件对象，包含的是文件信息
			//System.out.println(new InputStreamReader(sk.getInputStream()).getEncoding());查看流的编码
			in = sk.getInputStream();
			String fileName = file.getName();
			//String path = file.getPath();
			
			//File file2 = new File(path.replace(fileName, ip + "server.txt"));
			File file2 = new File("D:/" + fileName);
			
			while(file2.exists())
				//file2 = new File(path.replace(fileName, ip + "(" + (count++) + ")" + "server.txt"));
				file2 = new File("D:/" + ip + (count ++) + fileName);
			
			out = new FileOutputStream(file2);
			byte[] bufr = new byte[1024];
			int len = 0;
			while((len = in.read(bufr)) != -1) {
				out.write(bufr, 0, len);
			}
			PrintWriter pw = new PrintWriter(sk.getOutputStream(),true);
			pw.println("上传成功！");
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (sk != null) {
					sk.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
