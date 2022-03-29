package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Sample_NoSql_ProgramTest {

	public static void main(String[] args) throws SQLException {
		
		Connection conn=null;
		int result=0;
	    try{
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testyantra","root","root");
		Statement stat = conn.createStatement();
		
		String query = "insert into students_info values('7','hima','bindu','v')";
		result = stat.executeUpdate(query);
	    }
	    catch(Exception e) {
	    }finally {
	    	 if(result==1) {
	        	 System.out.println("inserted successful====pass");
	         }
	         else {
	        	 System.out.println("Not inserted successful====fail");
	         }
	    	 conn.close();
	    	 System.out.println("===Connection close");
	    }
	    
	}

}
