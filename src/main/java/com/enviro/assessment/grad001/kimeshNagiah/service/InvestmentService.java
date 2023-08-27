package com.enviro.assessment.grad001.kimeshNagiah.service;

import com.enviro.assessment.grad001.kimeshNagiah.repository.InvestorsRepository;
import com.enviro.assessment.grad001.kimeshNagiah.repository.ProductsRepository;
import com.enviro.assessment.grad001.kimeshNagiah.repository.TransactionRepository;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enviro.assessment.grad001.kimeshNagiah.dto.InvestmentDTO;
import com.enviro.assessment.grad001.kimeshNagiah.interfaces.InvestmentServiceInterface;
import com.enviro.assessment.grad001.kimeshNagiah.model.Investors;
import com.enviro.assessment.grad001.kimeshNagiah.model.Products;
import com.enviro.assessment.grad001.kimeshNagiah.model.Transaction;

@Service
public class InvestmentService implements InvestmentServiceInterface {
	
	@Autowired
	private InvestorsRepository investorsRepository;
	
	@Autowired
	private ProductsRepository productsRepository;
	
	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public List<Investors> getInvestors() {
		return (List<Investors>) investorsRepository.findAll();
	}

	@Override
	public InvestmentDTO saveAccount(InvestmentDTO investmentDTO) {
		InvestmentDTO savedInvestors = new InvestmentDTO();
		System.out.println("in save account");
		if(investmentDTO != null) {
			System.out.println("in save account2");
			if(investmentDTO.getInvestors() != null ) { //&& investmentDTO.getProducts() != null
				Investors investors = investorsRepository.save(investmentDTO.getInvestors());
				//investmentDTO.getProducts().setUserId(investors.getUserId());
				//Products products = productsRepository.save(investmentDTO.getProducts());
				
//				investmentDTO.getTransaction().setUserId(investors.getUserId());
//				Transaction transaction = transactionRepository.save(investmentDTO.getTransaction());
				
				savedInvestors.setInvestors(investors);
				//savedInvestors.setProducts(products);
				//savedInvestors.setTransaction(transaction);
			}
		}
		// returning an error here
		return savedInvestors;
	}

	@Override
	public Investors getInvestorById(int id) {
		return investorsRepository.findById(id).get();
	}

	@Override
	public Products getProductsByUserId(int userId) {
		InvestmentDTO investmentDTO = new InvestmentDTO();
		investmentDTO.setProducts(this.productsRepository.findByuserId(userId));
		return investmentDTO.getProducts();
	}

	@Override
	public Products updateProductBalanceByUserId(int userId, Products products) {
		Products currentProducts = this.getProductsByUserId(userId);
		currentProducts.setCurrentBalance(products.getCurrentBalance());
		return currentProducts;
	}

	@Override
	public void withdrawInvestmentFunds(int userId, int transactionId, String accountType, double amount, Date withdrawalDate, String recipientBankingDetails) {
		Investors investor = this.getInvestorById(userId); 
		if (investor == null) {
			throw new IllegalArgumentException("");
		} 
		Products products = new Products();
		List<String> productTypes = this.getProductsByUserId(investor.getUserId()).getAllAccountTypes();
		
		for (int i = 0; i < productTypes.size(); i++) {
			if (products.getType().equalsIgnoreCase(accountType)) {
				if (accountType.equalsIgnoreCase("retirement")) {
					if (investor.getInvestorAge() > 65) {
						products.withdraw(transactionId, amount, withdrawalDate, recipientBankingDetails);
					}
				} else  {
					throw new IllegalArgumentException("");
				}
				
			} else {
				products.withdraw(transactionId, amount, withdrawalDate, recipientBankingDetails);
			}
		}
		
	}
}
