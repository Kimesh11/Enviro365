package com.enviro.assessment.grad001.kimeshNagiah.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int transactionId;
    private String accountType;
    private double withdrawalAmount;
    private LocalDate withdrawalDate;
    private String accountNumber;
    private double previousBalance;
    private double updatedBalance;
    private int userId;
    
    public Transaction() {
    	
    }
    
    public Transaction(String accountType, double withdrawalAmount, LocalDate withdrawalDate, String accountNumber,
    		double previousBalance, double updatedBalance ,int userId) {
        this.accountType = accountType;
        this.withdrawalAmount = withdrawalAmount;
        this.withdrawalDate = withdrawalDate;
        this.accountNumber = accountNumber;
        this.previousBalance = previousBalance;
        this.updatedBalance = updatedBalance;
        this.userId = userId;
    }

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getWithdrawalAmount() {
		return withdrawalAmount;
	}

	public void setWithdrawalAmount(double withdrawalAmount) {
		this.withdrawalAmount = withdrawalAmount;
	}

	public LocalDate getWithdrawalDate() {
		return withdrawalDate;
	}

	public void setWithdrawalDate(LocalDate withdrawalDate) {
		this.withdrawalDate = withdrawalDate;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getPreviousBalance() {
		return previousBalance;
	}

	public void setPreviousBalance(double previousBalance) {
		this.previousBalance = previousBalance;
	}

	public double getUpdatedBalance() {
		return updatedBalance;
	}

	public void setUpdatedBalance(double updatedBalance) {
		this.updatedBalance = updatedBalance;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
