package com.enviro.assessment.grad001.kimeshNagiah.interfaces;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.enviro.assessment.grad001.kimeshNagiah.dto.DownloadTransactionsDTO;
import com.enviro.assessment.grad001.kimeshNagiah.dto.InvestmentDTO;
import com.enviro.assessment.grad001.kimeshNagiah.dto.WithdrawalDTO;
import com.enviro.assessment.grad001.kimeshNagiah.model.Investors;
import com.enviro.assessment.grad001.kimeshNagiah.model.Products;
import com.enviro.assessment.grad001.kimeshNagiah.model.Transaction;

public interface InvestmentServiceInterface {
	
	public List<Investors> getInvestors();
	
	public InvestmentDTO saveAccount(InvestmentDTO investmentDTO);
	
	public Investors getInvestorById(int id);
	
	public List<Products> getProductsByUserId(int userId);
	public Products getProductByUserId(int userId);
	
	public Products updateProductBalanceByUserId(int userId, Products products);

	public void withdrawInvestmentFunds(WithdrawalDTO withdrawalDTO);
	
	public void sendWithdrawalNotice(String recipientEmail, String subject, String message);

	public List<Transaction> getTransactionsByAccountTypeAndDateRange(DownloadTransactionsDTO downLoadTransactionsDTO);

	public List<InvestmentDTO> getAllInvestorsWithProducts();
}
