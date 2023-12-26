package com.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

import com.servlet.LoginServlet;

public class JDBCUtils {
	private static String driverClass;
	private static String url;
	private static String username;
	private static String password;
	private static Connection con;
	
	static {
		try {
			InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("application.properties");
			Properties prop = new Properties();
			prop.load(is);
			
			driverClass = prop.getProperty("driver");
			url = prop.getProperty("url");
			username = prop.getProperty("sqlUsername");
			password = prop.getProperty("sqlPassword");
			
			Class.forName(driverClass);
					
		}
		catch(IOException e){
			e.printStackTrace();
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public  static Connection getConnection() {
		try {
			con = DriverManager.getConnection(url,username,password);
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return con;
	}
	
	public static void close(Connection con , Statement sta, ResultSet rs) {
		if(con != null) {
			try {
				con.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(rs != null) {
			try {
				rs.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(Connection con , Statement sta) {
		if(con != null) {
			try {
				con.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
