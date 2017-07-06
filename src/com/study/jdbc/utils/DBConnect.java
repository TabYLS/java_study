package com.study.jdbc.utils;
/**
* @author 叶林生 
* @date：2017年7月2日 下午12:38:22
* @version 1.0
* 
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	
	private static Connection con = null;
	
	private final static String DRIVER = "com.mysql.jdbc.Driver";
	private final static String URL = "jdbc:mysql//localhost:3306/test?useUnicode=true&amp;characterEncoding=UTF-8";
	private final static String USER = "root";
	private final static String PASSWORD = "123456";

	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
