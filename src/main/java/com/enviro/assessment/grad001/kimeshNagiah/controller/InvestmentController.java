package com.enviro.assessment.grad001.kimeshNagiah.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.enviro.assessment.grad001.kimeshNagiah.dto.DownloadTransactionsDTO;
import com.enviro.assessment.grad001.kimeshNagiah.dto.InvestmentDTO;
import com.enviro.assessment.grad001.kimeshNagiah.dto.WithdrawalDTO;
import com.enviro.assessment.grad001.kimeshNagiah.model.Investors;
import com.enviro.assessment.grad001.kimeshNagiah.model.Products;
import com.enviro.assessment.grad001.kimeshNagiah.model.Transaction;
import com.enviro.assessment.grad001.kimeshNagiah.service.InvestmentService;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class InvestmentController {
	
	@Autowired
	private InvestmentService investmentService;
	
	@GetMapping("/getInvestors") 
	public List<Investors> getInvestorAccounts() {
        List<Investors> investors = investmentService.getInvestors();
        return investors;
    }
	
	@PostMapping("/createInvestor") 
	public InvestmentDTO createInvestorAccount(@RequestBody InvestmentDTO investmentDTO) {
		return investmentService.saveAccount(investmentDTO);
	}
	
	@GetMapping("/investorsWithProducts")
	public List<InvestmentDTO> getAllInvestorsWithProducts() {
        return investmentService.getAllInvestorsWithProducts();
    }
	
	@PutMapping("/investor/product/updateBalance/{id}")
	public Products updateBalanceByUserId(@PathVariable("id") int userId, @RequestBody Products products) {
		return investmentService.updateProductBalanceByUserId(userId, products);
	}	
	
	@PostMapping("/investor/withDrawFunds")
	public WithdrawalDTO withDrawFunds(@RequestBody WithdrawalDTO withdrawalDTO) {
	    investmentService.withdrawInvestmentFunds(withdrawalDTO);
	    return withdrawalDTO;
	}
	
	@GetMapping("/downloadTransactions")
    public void downloadTransactions(
            HttpServletResponse response,
            @RequestBody DownloadTransactionsDTO downloadTransactionsDTO) throws IOException {

        List<Transaction> transactions = investmentService.getTransactionsByAccountTypeAndDateRange(downloadTransactionsDTO);
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=\"transactions.csv\"");

        CSVPrinter csvPrinter = new CSVPrinter(response.getWriter(), CSVFormat.DEFAULT);

        csvPrinter.printRecord("Transaction ID", "Account Type", "Amount", "Account Number", "Previous Balance", "Current Balance", "Withdrawal Date");

        for (Transaction transaction : transactions) {
            csvPrinter.printRecord(
                transaction.getTransactionId(),
                transaction.getAccountType(),
                transaction.getWithdrawalAmount(),
                transaction.getAccountNumber(),
                transaction.getPreviousBalance(),
                transaction.getUpdatedBalance(),
                transaction.getWithdrawalDate()
            );
        }
        csvPrinter.close();
    }
}
