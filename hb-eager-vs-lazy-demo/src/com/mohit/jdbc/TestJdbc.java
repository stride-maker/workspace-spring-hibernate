package com.mohit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-03-one-to-many?useSSL=false";
		String user = "hbstudent";
		String password = "hbstudent";
		
		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			
			Connection conn = DriverManager.getConnection(jdbcUrl, user, password);
			
			System.out.println("Connection Successful!!: " + conn);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
