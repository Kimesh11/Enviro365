package com.enviro.assessment.grad001.kimeshNagiah.model;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Investors {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	private String userName;
	private String idNumber;
	private String address;
	private String contact;
	
	public Investors() {
		
	}
	
	public Investors(int userId, String userName, String idNumber, String address, String contact) {
		this.userId = userId;
		this.userName = userName;
		this.idNumber = idNumber;
		this.address = address;
		this.contact = contact;
	}


	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	
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
