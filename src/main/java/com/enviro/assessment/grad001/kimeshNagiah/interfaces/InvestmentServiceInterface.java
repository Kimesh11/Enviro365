package com.enviro.assessment.grad001.kimeshNagiah.interfaces;

import java.util.Date;
import java.util.List;

import com.enviro.assessment.grad001.kimeshNagiah.dto.InvestmentDTO;
import com.enviro.assessment.grad001.kimeshNagiah.model.Investors;
import com.enviro.assessment.grad001.kimeshNagiah.model.Products;

public interface InvestmentServiceInterface {
	
	public List<Investors> getInvestors();
	
	public InvestmentDTO saveAccount(InvestmentDTO investmentDTO);
	
	public Investors getInvestorById(int id);
	
	public Products getProductsByUserId(int userId);
	
	public Products updateProductBalanceByUserId(int userId, Products products);
	

	public void withdrawInvestmentFunds(int userId, int transactionId, String accountType, double amount, Date withdrawalDate, String recipientBankingDetails);
}
