package jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Test {
	// jdbc 測試
	public static void main(String[] args) throws FileNotFoundException, IOException {
		String driver = "com.mysql.cj.jdbc.Driver";
		String username ="root";
		String password = "###";
		String Dbname = "LoginTest";
		String url = "jdbc:mysql://localhost:3306/"+ Dbname +"?allowPublicKeyRetrieval=true&useSSL=false";
		String coding = "&useUnicode=ture&characterEncoding=UTF-8";
		Connection conn = null;
		
		Properties props = new Properties();
		props.load(new FileInputStream("application.properties"));
		
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,username,password);
			if(!conn.isClosed()) {
				System.out.println("成功連到數據庫");
				
				Statement Statement = conn.createStatement();
				
				String sql = "select * from account ";
				ResultSet rs = Statement.executeQuery(sql);
				while(rs.next()) {
					System.out.println(rs.getString("name"));
					System.out.println(rs.getString("password"));

				}
				conn.close();
			}
		}
	
		catch(Exception e) {
			e.printStackTrace();
		}
	
	}
}
