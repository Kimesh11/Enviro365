package com.enviro.assessment.grad001.kimeshNagiah.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.enviro.assessment.grad001.kimeshNagiah.dto.InvestmentDTO;
import com.enviro.assessment.grad001.kimeshNagiah.model.Investors;
import com.enviro.assessment.grad001.kimeshNagiah.model.Products;
import com.enviro.assessment.grad001.kimeshNagiah.service.InvestmentService;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class InvestmentController {
	
	@Autowired
	private InvestmentService investmentService;
	
	@GetMapping("/getInvestors") 
	public List<Investors> getInvestorAccounts() {
		return investmentService.getInvestors();
	}
	
	@PostMapping("/createInvestor") 
	public InvestmentDTO createInvestorAccount(@RequestBody InvestmentDTO investmentDTO) {
		return investmentService.saveAccount(investmentDTO);
	}
	
	@PutMapping("/investor/product/updateBalance/{id}")
	public Products updateBalanceByUserId(@PathVariable("id") int userId, @RequestBody Products products) {
		return investmentService.updateProductBalanceByUserId(userId, products);
	}	
}
