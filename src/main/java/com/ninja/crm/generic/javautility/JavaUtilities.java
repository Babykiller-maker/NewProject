package com.ninja.crm.generic.javautility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class JavaUtilities {


	public int getRandomNumber() {
		Random rm  = new Random();
		int ranNum = rm.nextInt();
		return ranNum;
	}
	
	public String selectExpectedDate(int expDate) {
		Date date = new Date();//java.util
		SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy");
		sim.format(date);
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,expDate);
		String expDate1 = sim.format(cal.getTime());
		return expDate1;
	}
	public String generateRandomData() {
		UUID uniqueNum = UUID.randomUUID();
		String ranData = uniqueNum.toString().replaceAll("[^a-zA-Z]", "");
		return ranData;
	}
}
