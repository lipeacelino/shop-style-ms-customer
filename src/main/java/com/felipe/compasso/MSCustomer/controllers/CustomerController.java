package com.felipe.compasso.MSCustomer.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	@ResponseStatus(HttpStatus.CREATED)
	public CustomerDTO addCustomer(@Valid @RequestBody Customer customer) {
		return customerServ.addCustomer(customer);
	}
	
	@PutMapping("/customers/{id}")
	@ResponseStatus(HttpStatus.OK)
	public CustomerDTO updateCustomer(@Valid @PathVariable Long id,  @RequestBody Customer customer) {
		return customerServ.setCustomer(id, customer);
	}
	
	@PutMapping("/customers/{id}/password")
	@ResponseStatus(HttpStatus.OK)
	public CustomerDTO updateCustomerPassword(@Valid @PathVariable Long id,  @RequestBody Map<String, String> password) {
		return customerServ.updateCustomerPassword(id, password);
	}
	
	@GetMapping("/customers/{id}")
	@ResponseStatus(HttpStatus.OK)
	public CustomerDTO findCustomerById(@PathVariable Long id) {
		return customerServ.findCustomerById(id);
	}

}
