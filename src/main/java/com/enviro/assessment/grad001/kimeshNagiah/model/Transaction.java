package com.enviro.assessment.grad001.kimeshNagiah.model;

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
    private Date withdrawalDate;
    private String recipientBankingDetails;
    private int userId;
    
    public Transaction() {
    	
    }
    
    public Transaction(int transactionId, String accountType, double withdrawalAmount, Date withdrawalDate, String recipientBankingDetails, int userId) {
        this.transactionId = transactionId;
        this.accountType = accountType;
        this.withdrawalAmount = withdrawalAmount;
        this.withdrawalDate = withdrawalDate;
        this.recipientBankingDetails = recipientBankingDetails;
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

	public Date getWithdrawalDate() {
		return withdrawalDate;
	}

	public void setWithdrawalDate(Date withdrawalDate) {
		this.withdrawalDate = withdrawalDate;
	}

	public String getRecipientBankingDetails() {
		return recipientBankingDetails;
	}

	public void setRecipientBankingDetails(String recipientBankingDetails) {
		this.recipientBankingDetails = recipientBankingDetails;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
    
    
}
