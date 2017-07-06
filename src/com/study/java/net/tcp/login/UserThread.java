package com.study.java.net.tcp.login;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
* @author 叶林生 
* @date：2017年6月29日 下午4:52:52
* @version 1.0
* 
*/
public class UserThread implements Runnable {
	
	private Socket sk = null;
	
	public UserThread(Socket sk) {
		this.sk = sk;
	}

	@Override
	public void run() {
		BufferedReader fileReader = null;
		try {
			System.out.println(this.getClass().getResource("/").getPath());
			BufferedReader readerTCP = new BufferedReader(new InputStreamReader(sk.getInputStream()));
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(sk.getOutputStream()));
			//PrintWriter out = new PrintWriter(new OutputStreamWriter(sk.getOutputStream()), true);
			String line = null;
			outer: for(int i = 0; i < 3; i ++) {
				fileReader = new BufferedReader(new FileReader("D:\\NEON_vision\\workspace\\java_study\\.\\src\\com\\study\\java\\net\\tcp\\login\\userInfo.txt"));//在第一层循环结束之后就会让流读到末尾，所以应该每次进入循环都要重新获取数据
				String name = readerTCP.readLine();//获取名字应该放在for循环里面，因为每次建立连接之后都会先循环的获取用户名（因为用户建立一次的连接之后可以连续输入三次），然后达到三次之后就会断开链接
				if (name == null)
					break;
				while((line = fileReader.readLine()) != null) {
					if (line.equals(name)) {
						System.out.println(name + "登陆成功。。。。。");
						out.write(name + "欢迎你,你已成功登陆！");
						out.newLine();//这里要加上换行符号，因为readLine在读取到换行符号之后才会停止，不然服务器端会一直等待
						out.flush();
						//out.println(name + "欢迎你,你已成功登陆！");
						break outer;//跳出外层循环
					}
				}
				System.out.println(name + "尝试登陆！");
				out.write("用户名不存在，登陆失败！");
				out.newLine();//这里要加上换行符号，因为readLine在读取到换行符号之后才会停止，不然服务器端会一直等待
				out.flush();
				//out.println("用户名不存在，登陆失败！");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileReader != null) {
				try {
					fileReader.close();
				} catch (IOException e) {
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
