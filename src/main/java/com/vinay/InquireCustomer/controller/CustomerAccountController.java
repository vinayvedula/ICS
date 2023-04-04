package com.vinay.InquireCustomer.controller;

import com.vinay.InquireCustomer.exception.ResourceNotFoundException;
import com.vinay.InquireCustomer.model.CustomerAccountModel;
import com.vinay.InquireCustomer.repository.CustomerAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerAccountController {
	
	@Autowired
	CustomerAccountRepository customerAccountRepository;
	
	@GetMapping("/notes")
	public List<CustomerAccountModel> getAllCustomerAccounts() {
		return customerAccountRepository.findAll();
	}

	@PostMapping("/notes")
	public CustomerAccountModel createCustomerAccount(@Valid @RequestBody CustomerAccountModel camodel) {
		return customerAccountRepository.save(camodel);
	}
	
	@GetMapping("/notes/{id}")
	public CustomerAccountModel 
	getCustomerAccountById(@PathVariable(value = "id") Long customerAccountId) {
		return customerAccountRepository.findById(customerAccountId)
				.orElseThrow(() -> new ResourceNotFoundException("CustomerAccountNote", "id", customerAccountId));
	}
	
	@PutMapping("/notes/{id}")
	public CustomerAccountModel 
	updateCustomerAccount(@PathVariable(value = "id") Long customerAccountId, 
			@Valid @RequestBody CustomerAccountModel CustomerAccountDetails) {
		CustomerAccountModel camodel = customerAccountRepository.findById(customerAccountId)
				.orElseThrow(() -> new ResourceNotFoundException("CustomerAccountNote", "id", customerAccountId));
		camodel.setContent(CustomerAccountDetails.getContent());
		camodel.setTitle(CustomerAccountDetails.getTitle());
		CustomerAccountModel updateCustomerAccount = customerAccountRepository.save(camodel);
		return updateCustomerAccount;
	}
	
	@DeleteMapping("/notes/{id}")
	public ResponseEntity<?> 
	deleteCustomerAccount(@PathVariable(value = "id") Long customerAccountId) {
		CustomerAccountModel camodel = customerAccountRepository.findById(customerAccountId)
				.orElseThrow(() -> new ResourceNotFoundException("CustomerAccountNote", "id", customerAccountId));
		customerAccountRepository.delete(camodel);
		return ResponseEntity.ok().build();
	}
}
