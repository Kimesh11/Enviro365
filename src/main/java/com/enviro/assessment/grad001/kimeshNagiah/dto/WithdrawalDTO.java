package com.enviro.assessment.grad001.kimeshNagiah.dto;

import java.time.LocalDate;

import com.enviro.assessment.grad001.kimeshNagiah.model.Investors;
import com.enviro.assessment.grad001.kimeshNagiah.model.Products;

public class WithdrawalDTO {
	
	private String idNumber;
	private String accountType;
	private LocalDate date;
	private double amountWithdrawn;
	private String accountNumber;
	
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public double getAmountWithdrawn() {
		return amountWithdrawn;
	}
	public void setAmountWithdrawn(double amountWithdrawn) {
		this.amountWithdrawn = amountWithdrawn;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	
}
