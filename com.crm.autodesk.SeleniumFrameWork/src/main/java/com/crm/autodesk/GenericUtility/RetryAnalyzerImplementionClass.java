package com.crm.autodesk.GenericUtility;

import java.util.Iterator;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/**
 * this class which is used execute failed testscript multiple times
 * @author CHANNAKESHVA REDDY
 *
 */
public class RetryAnalyzerImplementionClass implements IRetryAnalyzer{
	/**
	 * this method is execute multiples times until condition is satisfied
	 */

	int i=0;
	int j=5;
	public boolean retry(ITestResult result) {
	    if(i<j) {
	    	i++;
	    	
	    
	    	return true;
	    }		
		return false;
	}
	

}
