package com.VTiger.crm.generic.databaseutility;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {

	Connection con;
	ResultSet result;
	
	public void getConnection() throws SQLException {
		try{
			Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		con=DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects/","root@%","root");
	       } catch(Exception e) { }
	}
	
	public ResultSet executeSelectQuery(String query) throws SQLException {
	
		try {
		Statement stat=con.createStatement();
		result=stat.executeQuery(query);}
		catch(Exception e) {	}
		return result;
	}
	
	public int executeNonSelectQuery(String query) {
		int result=0;
		try {
			Statement stat=con.createStatement();
			result=stat.executeUpdate(query);
		} 
		catch(Exception e) {}
		return result;
	}
	
	public void closeConnection() throws SQLException {
		try {con.close();} 
		catch(Exception e) {}
	}
}
