package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connections {
	
	public Connection getConnections() {
		//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
	   // return  dataSource.getConnection();
		Connection conn;
		try {
			/*Class.forName("org.postgresql.Driver");*/
			DriverManager.registerDriver(new org.postgresql.Driver());
			//String url = "jdbc:postgresql://localhost:5432/"+"mangustl";
			//conn = DriverManager.getConnection(url, "root","root");
			String url = "jdbc:postgresql://"+"ec2-54-75-231-3.eu-west-1.compute.amazonaws.com:5432"+
                    "/d71657i1s0mdue?sslmode=require";
			String pass= "0259dacdea548593985b7839e1d0f170817def9e16f9327093a88cf323c21a1e";
			String user = "uwgrzqaagrtwzf";
			conn = DriverManager.getConnection(url, user, pass);
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Connection : ");
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
}
