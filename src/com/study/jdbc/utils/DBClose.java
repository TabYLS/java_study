package com.study.jdbc.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
* @author 叶林生 
* @date：2017年7月2日 下午1:11:11
* @version 1.0
* 
*/
public class DBClose {
	
	public static void close(ResultSet rs, PreparedStatement ps, Connection con) {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (ps != null) {
				ps.close();
				ps = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(PreparedStatement ps, Connection con) {
		try {
			if (ps != null) {
				ps.close();
				ps = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
		} catch (SQLException e) {
			System.out.println("SQLState:" + e.getSQLState());
			System.out.println("Message:" + e.getMessage());
			e.printStackTrace();
		}
	}

}
