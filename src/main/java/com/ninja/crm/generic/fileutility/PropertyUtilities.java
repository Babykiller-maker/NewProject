package com.ninja.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtilities {
	public String toReadDataFromPropertyFile(String key) throws IOException {
		// Read the data from properties file
		// Step1 - Create the object or create java respresentation of physical file
		FileInputStream fis = new FileInputStream("./resources/commondata.properties");

		// step 2-Create object of properties file
		Properties pr = new Properties();

		// Step 3- load all the keys
		pr.load(fis);
		
		//To read the data
		return pr.getProperty(key);
	}
}
