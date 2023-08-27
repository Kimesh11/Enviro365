package com.enviro.assessment.grad001.kimeshNagiah.dto;

import com.enviro.assessment.grad001.kimeshNagiah.model.Investors;
import com.enviro.assessment.grad001.kimeshNagiah.model.Products;
import com.enviro.assessment.grad001.kimeshNagiah.model.Transaction;

public class InvestmentDTO {
	
	private Investors investors;
	private Products products;
	private Transaction transaction;
	
	public Investors getInvestors() {
		return investors;
	}
	public void setInvestors(Investors investors) {
		this.investors = investors;
	}
	public Products getProducts() {
		return products;
	}
	
	public void setProducts(Products products) {
		this.products = products;
	}
	
	public Transaction getTransaction() {
		return transaction;
	}
	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
	
	
}
