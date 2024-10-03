package com.VTiger.crm.generic.javautility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public int getRandomNumber() {
		Random ran=new Random();
		int r=ran.nextInt(5000);
		return r;
	}
	
	public String getSystemDate() {
		Date date=new Date();
		
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String actDate=sim.format(date);
		return actDate;
	}
	public String getRequiredYYYYMMdd(int days) {
		Date dobj=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		sim.format(dobj);
		
        Calendar cal=sim.getCalendar();
        cal.add(Calendar.DAY_OF_MONTH, days);
        String dateRequires=sim.format(cal.getTime());
        return dateRequires;
	} 
	public String getSysDate() {
		String sysdate=new Date().toString().replace(" ","_").replace(":","_");
		return sysdate;
		
	}

}
