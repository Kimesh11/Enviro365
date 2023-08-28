package com.enviro.assessment.grad001.kimeshNagiah.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Products {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;
	private String type;
	private String name;
	private double currentBalance;
	private int userId;
	
	@Transient
	private List<String> accountTypes = new ArrayList<>();
	//private List<Transaction> transactionHistory = new ArrayList<>();
	
	public Products() {
		
	}
	
	public Products(int productId, String type, String name, double currentBalance, int userId) {
		this.productId = productId;
		this.type = type;
		this.name = name;
		this.currentBalance = currentBalance;
		this.userId = userId;
	}
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	@Transient
	public List<String> getAllAccountTypes() {
        return new ArrayList<>(accountTypes);
    }
	
	
	
//	public List<Transaction> getTransactionHistory() {
//        return transactionHistory;
//    }
	
	//Remove once transaction one is completed
//	public void withdraw(double amount) {
//        if (amount > 0 && amount < 0.9 * currentBalance && !(amount > currentBalance)  ) {
//        	currentBalance -= amount;
//        } else {
//        	throw new IllegalArgumentException("");
//        }
//        // withdrawal method in service check type against retirement
//    }

//	public void withdraw(int transactionId, double amount, Date withdrawalDate, String recipientBankingDetails) {
//        if (amount > 0 && amount < 0.9 * currentBalance && !(amount > currentBalance)) {
//        	this.setCurrentBalance(currentBalance -= amount);
//            Transaction transaction = new Transaction(type, amount, withdrawalDate, recipientBankingDetails, userId);
//            //transactionHistory.add(transaction);
//        } else {
//        	throw new IllegalArgumentException("");
//        }
//    }
	
}
