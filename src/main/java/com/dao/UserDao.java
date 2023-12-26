package com.dao;

import java.sql.*;
import java.util.List;

import com.bean.User;
import com.utils.JDBCUtils;

public class UserDao implements BaseDao<User>{

	JDBCUtils jdb = new JDBCUtils();
	
	@Override
	public boolean add(User user) {
		// TODO Auto-generated method stub
		
		Connection con = null;
		PreparedStatement stat = null;
		int i = 0;
		try {
			con = JDBCUtils.getConnection();
			stat = con.prepareStatement("INSERT INTO account VALUES(?,?)");
			stat.setString(1, user.getUsername());
			stat.setString(2, user.getPassword());
			i = stat.executeUpdate();
			System.out.println(i);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.close(con, stat);
		}
		if(i>0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public void delete(User user) {
		Connection con = null;
		Statement stat = null;
		try {
			con = JDBCUtils.getConnection();
			stat = con.createStatement();
			String sql = "DELETE FROM user WHERE id ='" + user.getUsername() +"'";
			stat.executeUpdate(sql);
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.close(con, stat);
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void upadate(User e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean findbone(String name, String password) {
		Connection con = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		boolean result = false;
		try {

			con = JDBCUtils.getConnection();

			stat = con.prepareStatement("SELECT * FROM account WHERE name = ? and password = ? ");
			stat.setString(1 , name);
			stat.setString(2 , password);
			rs = stat.executeQuery();
			if(rs.next()) {
				result = true;
			}else {
				result = false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCUtils.close(con, stat ,rs);
		}
		
		return result;
	}

	@Override
	public List<User> findall() {
		// TODO Auto-generated method stub
		return null;
	}

}
