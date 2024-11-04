package com.learn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.learn.bean.UserBean;

public class UserDAO {
	public UserBean getUserBean(UserBean userBean) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		try(Connection conn1=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "mysqlroot")){
			PreparedStatement stmt1=conn1.prepareStatement("select * from user where username=? and password=?");
			stmt1.setString(1, userBean.getUsername());
			stmt1.setString(2, userBean.getPassword());
			ResultSet rs1=stmt1.executeQuery();
			while (rs1.next()) {
				userBean.setFirstName(rs1.getString(1));
				System.out.println(rs1.getString(1));
				userBean.setLastName(rs1.getString(2));
			}
		}
		
//		conn.close();
 catch (SQLException e) {
		
		e.printStackTrace();
	}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		return userBean;
	}

	public String createUserBean(UserBean userBean) {
		String error=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		try(Connection conn1=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "-----")){
			PreparedStatement stmt1=conn1.prepareStatement("INSERT INTO user (firstname,lastname,username,password) VALUES (?,?,?,?)");
			stmt1.setString(1, userBean.getFirstName());
			stmt1.setString(2, userBean.getLastName());
			stmt1.setString(3, userBean.getUsername());
			stmt1.setString(4, userBean.getPassword());
			int rs1=stmt1.executeUpdate();
			
			if(rs1>0) {
				return error;
			}else {
				error="Error in inserting data";
				return error;
			}
			
//			while (rs1.next()) {
//				userBean.setFirstName(rs1.getString(1));
//				System.out.println(rs1.getString(1));
//				userBean.setLastName(rs1.getString(2));
//			}
		}
		
//		conn.close();
 catch (SQLException e) {
		
		e.printStackTrace();
	}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		return error;
		
	}

	public int getUserDetails(UserBean userBean) {
		int usrs=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		try(Connection conn1=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "mysqlroot")){
			PreparedStatement stmt1=conn1.prepareStatement("select * from user where firstname=? and lastname=?");
			stmt1.setString(1, userBean.getFirstName());
			stmt1.setString(2, userBean.getLastName());
			ResultSet rs1=stmt1.executeQuery();
			if (rs1.next()) {
			while (rs1.next()) {
				usrs++;
				// ... retrieve other columns as needed
				String firstName = rs1.getString(1);
		        String lastName = rs1.getString(2);
		        String userName = rs1.getString(3);
		        
		        
		        // Process the data
		        System.out.println("Found user: " + firstName + " " + lastName+" "+userName);
			}
			System.out.println("No of users: "+usrs);
			}
			else {
				System.out.println("No matching users found");
			}
			
		}
		
//		conn.close();
 catch (SQLException e) {
		
		e.printStackTrace();
	}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		return usrs;
	}
}
