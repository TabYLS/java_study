package com.study.java.io.properties;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
* @author 叶林生 
* @date：2017年7月4日 下午4:26:52
* @version 1.0
* 
*/
public class PropertiesTest {
	
	public static void main(String[] args) throws IOException {
		BufferedReader bufr = new BufferedReader(new FileReader(".\\src\\com\\study\\java\\io\\properties\\info.txt"));

		String line = null;
		Properties prop = new Properties();


		while((line=bufr.readLine())!=null)
		{
			if (!line.contains("="))
				continue;
			String[] arr = line.split("=");
			System.out.println(arr[0]+"...."+arr[1]);
			prop.setProperty(arr[0],arr[1]);
		}

		bufr.close();

		System.out.println(prop);
	}

}
