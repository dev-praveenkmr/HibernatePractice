package com.hibernatepractice.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Test_Jdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user = "hbstudent";
		String pass = "hbstudent";
		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			
			Connection myConn = 
					DriverManager.getConnection(jdbcUrl,user,pass);
			
			System.out.println("Connection successfull!!!");
		}
		catch (Exception exc) {
			exc.printStackTrace();		}

	}

}
 