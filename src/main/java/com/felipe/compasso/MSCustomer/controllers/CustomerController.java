package com.felipe.compasso.MSCustomer.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipe.compasso.MSCustomer.DTO.CustomerDTO;
import com.felipe.compasso.MSCustomer.entities.Customer;
import com.felipe.compasso.MSCustomer.services.CustomerService;

@RestController
@RequestMapping("/v1")
public class CustomerController {
	
	@Autowired
	private CustomerService customerServ;
	
	
	@PostMapping("/login")
	public void login() {	
		//implementar posteriormente
	}
	
	@PostMapping("/customers")
	public CustomerDTO addCustomer(@Valid @RequestBody Customer customer) {
		return customerServ.addCustomer(customer);
	}
	
	@GetMapping("/customers/{id}")
	public CustomerDTO findCustomerById(@PathVariable Long id) {
		return customerServ.findCustomerById(id);
	}

}
