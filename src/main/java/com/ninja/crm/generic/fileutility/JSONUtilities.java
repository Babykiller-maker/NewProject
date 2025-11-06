package com.ninja.crm.generic.fileutility;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONUtilities {
	public String toReadDataFromJsonFile(String key) throws IOException, ParseException {
		// Create the java representation of physical json file
		FileReader fr = new FileReader("./resources/commondata.json");

		// Parse the java representation of json file
		JSONParser jp = new JSONParser();
		Object javaObj = jp.parse(fr);

		// Downcast java object to json object
		JSONObject jObj = (JSONObject) javaObj;

		// Read the data from json file
		String data = jObj.get(key).toString();
		return data;

	}
}
