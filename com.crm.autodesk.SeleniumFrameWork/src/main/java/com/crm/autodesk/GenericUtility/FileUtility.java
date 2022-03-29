package com.crm.autodesk.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * it is present java util package
 * @author CHANNAKESHVA REDDY
 *
 */
public class FileUtility {
	 /**
	  * it used to read the common data from properties File based on key which you pass an argument
	  * @param key
	 * @return 
	 * @throws IOException 
	  */
	public String getPropertyKeyValue(String key) throws IOException {
		String file = ".\\src\\test\\resources\\CommonData\\crenditials.properties";
		FileInputStream fis = new FileInputStream(file);
		Properties properties = new Properties();
		properties.load(fis);
		String value = properties.getProperty(key);
		return value;
	}

}
