package com.crm.autodesk.GenericUtility;

import java.util.Iterator;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerImplementionClass implements IRetryAnalyzer{

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
