package com.enviro.assessment.grad001.kimeshNagiah.service;

import com.enviro.assessment.grad001.kimeshNagiah.repository.InvestorsRepository;
import com.enviro.assessment.grad001.kimeshNagiah.repository.ProductsRepository;
import com.enviro.assessment.grad001.kimeshNagiah.repository.TransactionRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.enviro.assessment.grad001.kimeshNagiah.dto.DownloadTransactionsDTO;
import com.enviro.assessment.grad001.kimeshNagiah.dto.InvestmentDTO;
import com.enviro.assessment.grad001.kimeshNagiah.dto.WithdrawalDTO;
import com.enviro.assessment.grad001.kimeshNagiah.helpers.Helper;
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
	
	@Autowired
    private JavaMailSender javaMailSender;
	
	private Helper helper;
	
	@Override
	public List<Investors> getInvestors() {
		List<Investors> investors = new ArrayList<>();
		investors = (List<Investors>) investorsRepository.findAll();
		if (investors != null && !investors.isEmpty()) {
			return investors;
		} else {
			throw new IllegalArgumentException("No Investors found.");
		}
	}

	@Override
	public InvestmentDTO saveAccount(InvestmentDTO investmentDTO) {
		try {
			InvestmentDTO savedInvestors = new InvestmentDTO();
			if(investmentDTO != null) {
				if(investmentDTO.getInvestors() != null && investmentDTO.getProducts() != null) {
					Investors investors = investorsRepository.save(investmentDTO.getInvestors());

					List<Products> tempProducts = new ArrayList<Products>();
					tempProducts.addAll(investmentDTO.getProducts());
					for(Products product : tempProducts) {
							product.setUserId(investors.getUserId());

					}
					ArrayList<Products> products = (ArrayList<Products>) productsRepository.saveAll(tempProducts);
					
					savedInvestors.setInvestors(investors);
					savedInvestors.setProducts(products);
				}
			}
			return savedInvestors;
		} catch (Exception e) {
			throw new IllegalArgumentException("Account could not be saved!", e);
		}	
	}

	@Override
	public Investors getInvestorById(int id) {
		return investorsRepository.findById(id).get();
	}

	@Override
	public List<Products> getProductsByUserId(int userId) {

		return this.productsRepository.findAllByuserId(userId);
	}

	@Override
	public Products getProductByUserId(int userId){
		return this.productsRepository.findByuserId(userId);
	}
	
	@Override
	public List<InvestmentDTO> getAllInvestorsWithProducts() {
	    List<InvestmentDTO> investorsWithProducts = new ArrayList<>();

	    List<Investors> allInvestors = (List<Investors>) investorsRepository.findAll();

	    if (allInvestors == null || allInvestors.isEmpty()) {
	        throw new IllegalArgumentException("No investors found.");
	    }

	    for (Investors investor : allInvestors) {
	        List<Products> products = productsRepository.findAllByuserId(investor.getUserId());

	        InvestmentDTO investorWithProducts = new InvestmentDTO();
	        investorWithProducts.setInvestors(investor);
	        investorWithProducts.setProducts(products);

	        investorsWithProducts.add(investorWithProducts);
	    }

	    return investorsWithProducts;
	}

	@Override
	public Products updateProductBalanceByUserId(int userId, Products products) {
		Products currentProducts = this.getProductByUserId(userId);
		currentProducts.setCurrentBalance(products.getCurrentBalance());
		return currentProducts;
	}

	@Override
	public void withdrawInvestmentFunds(WithdrawalDTO withdrawalDTO) {
		
        Investors investor = investorsRepository.findByIdNumber(withdrawalDTO.getIdNumber());
        if (investor == null) {
            throw new IllegalArgumentException("Investor not found");
        }
        
        Products product = productsRepository.findByUserIdAndType(investor.getUserId(), withdrawalDTO.getAccountType());
        if (product == null) {
            throw new IllegalArgumentException("Product not found");
        }
        
        double amount = withdrawalDTO.getAmountWithdrawn();

        if (withdrawalDTO.getAccountType().equalsIgnoreCase("retirement")) {
            int investorAge = helper.getInvestorAge();
            if (investorAge < 65) {
                throw new IllegalArgumentException("Investor is not of retirement age");
            }
        }

        if (amount <= 0 || amount > product.getCurrentBalance() || amount > (0.9 * product.getCurrentBalance())) {
            throw new IllegalArgumentException("Invalid withdrawal amount");
        }
        
        double currentBalanceBeforeWithdrawal = product.getCurrentBalance();
        double updatedBalance = currentBalanceBeforeWithdrawal - amount;
        product.setCurrentBalance(updatedBalance);
        productsRepository.save(product);

        Transaction transaction = new Transaction(product.getType(), amount, withdrawalDTO.getDate().now(), investor.getAccountNumber(), currentBalanceBeforeWithdrawal, updatedBalance , investor.getUserId());
        transactionRepository.save(transaction);
//        this.sendWithdrawalNotice(investor.getEmail(), "Withdrawal Notice", 
//        		"Account Type: " + product.getType() + "\n" +
//                "Previous Balance: $" + currentBalanceBeforeWithdrawal + "\n" +
//                "Amount Withdrawn: $" + amount + "\n" +
//                "Updated Balance: $" + updatedBalance );
	}

	@Override
	public void sendWithdrawalNotice(String recipientEmail, String subject, String message) {
		SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientEmail);
        email.setSubject(subject);
        email.setText(message);
        javaMailSender.send(email);
	}
	
	@Override
	public List<Transaction> getTransactionsByAccountTypeAndDateRange(DownloadTransactionsDTO downLoadTransactionsDTO) {
		String accountType = downLoadTransactionsDTO.getAccountType();
	    LocalDate startDate = downLoadTransactionsDTO.getStartDate();
	    LocalDate endDate = downLoadTransactionsDTO.getEndDate();

	    if (accountType == null || accountType.isEmpty()) {
	        throw new IllegalArgumentException("Account type is required.");
	    }

	    if (startDate == null || endDate == null || startDate.isAfter(endDate)) {
	        throw new IllegalArgumentException("Invalid date range.");
	    }

	    return transactionRepository.findByAccountTypeAndWithdrawalDateBetween(accountType, startDate, endDate);
    }
}
