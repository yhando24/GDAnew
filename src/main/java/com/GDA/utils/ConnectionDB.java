package main.java.com.GDA.utils;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;




public class ConnectionDB {

	public static void main(String[] args) {
		
		Connection connect = null;
		
		try {
			System.out.println("Connection in progress...");
			connect = ConnectionDB.getConnection();
			System.out.println("Connection successful");
			
		} catch (Exception e) {
		
		} finally {
			try {
				
				connect.close();
				System.out.println("Connection closed");
			} catch (Exception e2) {
			}
		}
	}
	
	public static Connection getConnection () throws Exception {
				
		// Get DataSource
		Context ctx = new InitialContext();
		DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/mydatabase");
		// Get Connection and Statement
		Connection c = ds.getConnection();
		
		return c;
		
	}
}
