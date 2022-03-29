package com.crm.autodesk.GenericUtility;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;
/**
 * 
 * @author CHANNAKESHVA REDDY
 *
 */
public class JavaUtility {
	/**
	 * its used to generated random number
	 * @return int data
	 */
	public int getRanDomNum() {		
		Random random = new Random(); 
		int intRandom=random.nextInt(10000); 
		return intRandom;		 
	}
	/**
	 * its used to get system date in YYYY-MM-DD
	 * @return 
	 * @return
	 */
	public String getSystemDateWithFormate() {
		Date date = new Date();
		String dateAndTime = date.toString();
		
		int month = date.getMonth()+1;
		String year = dateAndTime.split(" ")[5];
		String Date = dateAndTime.split(" ")[2];
		String yymmdd = year+"-"+month+"-"+Date;
		return yymmdd;
	}
	 public String getSystemTime() {
		 String time = LocalDateTime.now().toString().replace(":","-");
		 return time;
	 }
}
