package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Sample_Sql_Jdbc_ProgramTest {

	public static void main(String[] args) throws SQLException {
		
		Connection conn=null;
		try {
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testyantra","root","root");
		Statement stat = conn.createStatement();
		
		String query = "select * from students_info";
		ResultSet result = stat.executeQuery(query);
	
       while(result.next())	{
    	   System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
       }
	}
		catch(Exception e) {
			System.out.println("fail:Please handle error");
		}
		finally {
			conn.close();
		}
		
	}

}
