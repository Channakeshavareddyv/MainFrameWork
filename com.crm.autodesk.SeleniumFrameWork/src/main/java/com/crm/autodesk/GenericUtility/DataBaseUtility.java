package com.crm.autodesk.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

/**
 * this class is used to perform the actions on Database
 * @author CHANNAKESHVA REDDY
 *
 */
public class DataBaseUtility {
	/**
	 * this method is used to connect to the database
	 */
	Connection conn;
	Statement stat;
	public void connectToDataBase() {
		try {
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			conn = DriverManager.getConnection(IPathConstant.JDBC_URL, IPathConstant.USERNAME, IPathConstant.PASSWORD);	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	/**
	 * this method is used to close the database connection
	 */
	public void closeToDataBase() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * this method is used to get or fetch the data from the database
	 * @param query
	 * @return
	 */
	public ResultSet getDataFromDataBase(String query) {
		try {
			stat = conn.createStatement();
			ResultSet result = stat.executeQuery(query);
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * this method is used to write data into the DataBase
	 * @param query
	 * @return
	 */
	public boolean WriteTheDataIntoDataBase(String query) {
		int result = 0;
		try {
			result = stat.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean value=false;
		if(result==1) {
			System.out.println("Data writen in the DataBase");
			value=true;
			return value;
		}
		else {
			System.out.println("Data not written in the DataBase");
		}
		return value;
	}

}
