package com.controller.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminDao {
	private static String  url="jdbc:mysql://localhost:3306/java";
	private static String username="root";
	private static String password="Raksha@123";
	private static Statement s=null;
private static Connection con=null;
	private static ResultSet rs=null;
	private static String checkQuery="select * from admin1";
	public static boolean checkLogin(String user,String pass)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, username, password);
			s=con.createStatement();
			rs = s.executeQuery(checkQuery);
			while(rs.next())
			{
				String name = rs.getString("name");
				String pass1 = rs.getString("password");
				
				if(name.equals(user) && pass1.equals(pass))
				{
					return true;
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				rs.close();
				s.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
		
	}
	

}
