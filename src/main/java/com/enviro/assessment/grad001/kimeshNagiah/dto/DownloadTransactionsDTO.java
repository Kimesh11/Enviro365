package com.enviro.assessment.grad001.kimeshNagiah.dto;

import java.time.LocalDate;

public class DownloadTransactionsDTO {
	
	private String accountType;
	private LocalDate startDate;
	private LocalDate endDate;
	
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	
	
}
