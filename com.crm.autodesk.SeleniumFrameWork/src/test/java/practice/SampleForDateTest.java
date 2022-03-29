package practice;

import java.time.LocalDateTime;
import java.util.Date;

public class SampleForDateTest {

	public static void main(String[] args) {
		
		Date dateObj = new Date();
		String dateAndTime = dateObj.toString();
		System.out.println(dateAndTime);
		
		int month = dateObj.getMonth()+1;
		String year = dateAndTime.split(" ")[5];
		String Date = dateAndTime.split(" ")[2];
		String yymmdd = year+"-"+month+"-"+Date;
		System.out.println(yymmdd);
		
		LocalDateTime DateAndTime = LocalDateTime.now();
		System.out.println(DateAndTime);
		String gettingDate = DateAndTime.toString();
		String actualDate = gettingDate.split("T")[0];
		System.out.println(actualDate);

	}

}
