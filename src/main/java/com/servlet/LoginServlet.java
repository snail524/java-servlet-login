package com.servlet;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.sql.*;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.User;
import com.dao.UserDao;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/LoginServlet")
@WebServlet(name = "LoginServlet" , urlPatterns = { "/LoginServlet2" , "/abc" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     UserDao userDao = new UserDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		request.getRequestDispatcher("login.jsp").forward(request, response);
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		if(userDao.findbone(name, password)) {
			System.out.println("登入成功");
			response.sendRedirect(request.getContextPath() +"/Success.jsp");
		}else {
			System.out.println("登入失敗");
			response.sendRedirect(request.getContextPath() +"/Error.jsp");

		}
//		
//		Properties props = new Properties();
//		InputStream is = LoginServlet.class.getClassLoader().getResourceAsStream("application.properties");
//		props.load(is);
//		
//		Connection conn = null;
//		
//		try {
//			Class.forName( props.getProperty("driver"));
//			conn=DriverManager.getConnection( props.getProperty("url"), props.getProperty("sqlUsername"), props.getProperty("sqlPassword"));
//			if(!conn.isClosed()) {
//				System.out.println("成功連到數據庫");
//				
//				Statement Statement = conn.createStatement();
//				
//				String sql = "select * from account ";
//				ResultSet rs = Statement.executeQuery(sql);
//				while(rs.next()) {
//					
//					if(name.equals(rs.getString("name")) ) {
//						if( password.equals(rs.getString("password"))) {
//							System.out.println("login success");
//							request.setAttribute("myname", name);
//							request.getRequestDispatcher("Success.jsp").forward(request, response);
//							conn.close();
//							return;
//						}
//						//password error
//						else {
//							System.out.println("password error");
//							request.getRequestDispatcher("Error.jsp").forward(request, response);
//							conn.close();
//							return;
//						}
//					}
//				}
//				conn.close();
//				System.out.println("login fail");
//				request.getRequestDispatcher("Error.jsp").forward(request, response);
//			}
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}

	}

}
