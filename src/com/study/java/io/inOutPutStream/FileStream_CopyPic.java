package com.study.java.io.inOutPutStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStream_CopyPic {
	
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream(".\\src\\com\\study\\java\\io\\inOutPutStreanm\\ptec.jpg");
			fos = new FileOutputStream(".\\src\\com\\study\\java\\io\\inOutPutStreanm\\ptec_copy.jpg");
			
			byte[] buff = new byte[1024];
			int ch = 0;
			
			while((ch = fis.read(buff)) != -1) {
				fos.write(buff, 0, ch);
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("复制文件失败！");
		} finally {
			try {
				if(fos != null)
					fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("读取关闭失败");
			} finally {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new RuntimeException("写入关闭失败");
				}
			}
			
		}
	}

}
