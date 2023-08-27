package com.enviro.assessment.grad001.kimeshNagiah.helpers;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.enviro.assessment.grad001.kimeshNagiah.model.Investors;

public class Helper {
	
	public int getInvestorAge() {
	Investors investors = new Investors();
	investors.getUserId(); // might not need
	String investorID = investors.getIdNumber();
	String birthYear = investorID.substring(0, 2);
	
    Date date = new Date();
    Calendar calendar = new GregorianCalendar();
    calendar.setTime(date);
    int currentYear = calendar.get(Calendar.YEAR);
    String YOB;
    
    if (Integer.parseInt(birthYear) == 0 || Integer.parseInt(birthYear) <= (currentYear - 2000)) {
        YOB = "20" + birthYear;
    } else {
        YOB = "19" + birthYear;
    }
    return currentYear - Integer.parseInt(YOB);
}
}
