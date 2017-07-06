package com.study.java.net.tcp.upfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
* @author 叶林生 
* @date：2017年6月28日 下午9:10:10
* @version 1.0
* 
*/
public class ClientThread {
	public static void main(String[] args) {
		//args[0] = args[0].replaceAll("\\", "/");
		if(!check(args))//检查用户输入是否合法，不合法则结束
			return;
		Socket sk = null;
		ObjectOutputStream objOut = null;
		OutputStream out = null;
		InputStream input = null;
		File file = new File(args[0]);
		try {
			//1.开启socket服务
			//sk = new Socket("192.168.73.4", 9003, InetAddress.getByName("192.168.73.4"), 9002);
			sk = new Socket("192.168.91.4", 9003);
			//2.得到上传资源的文件对象
			///java_study/
			objOut = new ObjectOutputStream(sk.getOutputStream());
			//3.获取网络传输流
			out = sk.getOutputStream();
			//4.先将要上传的文件对象传到服务器,把文件对象传到服务器中方便服务器中对上传文件的操作
			//bjOut.writeObject(new File("D:\\NEON_vision\\workspace\\java_study\\.\\src\\com\\study\\java\\net\\tcp\\upfile\\Client.java"));
			objOut.writeObject(file);
			//5.用输入流获取资源
			//input = new FileInputStream("D:\\NEON_vision\\workspace\\java_study\\.\\src\\com\\study\\java\\net\\tcp\\upfile\\Client.java");
			input = new FileInputStream(file);
			//6.将资源流通过网络输出流输出到服务器
			byte[] bufr = new byte[1024];
			int len = 0;
			while((len = input.read(bufr)) != -1) {
				out.write(bufr, 0, len);
			}
			//7.文件上传完成之后关闭socket并通知服务器
			sk.shutdownOutput();
			input.close();//本地流使用完了要关闭，不然再在使用socket的输入流的时候会发生流没有关闭的警告。
			input = sk.getInputStream();
			byte[] callback = new byte[1024];
			int num = input.read(callback);
			System.out.println(new String(callback, 0, num));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try{
				sk.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static boolean check(String[] args) {
		if(args.length!=1)
		{
			System.out.println("请选择一个文件");
			return false;
		}

		File file = new File(args[0]);
		if(!(file.exists() && file.isFile()))
		{
			System.out.println("该文件有问题，要么不存在，要么不是文件");
			return false;

		}

		/*if(!file.getName().endsWith(".jpg"))
		{
			System.out.println("图片格式错误,请重新选择");
			return false;
		}*/

		if(file.length()>1024*1024*5)
		{
			System.out.println("文件过大，没安好心");
			return false;
		}
		return true;
	}

}
