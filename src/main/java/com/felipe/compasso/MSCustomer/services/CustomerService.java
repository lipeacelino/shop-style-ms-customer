package com.felipe.compasso.MSCustomer.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.felipe.compasso.MSCustomer.DTO.CustomerDTO;
import com.felipe.compasso.MSCustomer.entities.Customer;
import com.felipe.compasso.MSCustomer.repositories.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRep;
	
	@Autowired
	private PasswordEncoder passEncoder;
	
	public CustomerDTO addCustomer(Customer customer) {
		
		customer.setPassword(passEncoder.encode(customer.getPassword()));
		
		Customer customerBd = customerRep.save(customer);
		
		return CustomerDTO.builder()
				.id(customerBd.getId())
				.cpf(customerBd.getCpf())
				.firstName(customerBd.getFirstName())
				.lastName(customerBd.getLastName())
				.sex(customerBd.getSex())
				.birthdate(convertDateToString(customerBd.getBirthdate()))
				.email(customerBd.getEmail())
				.password(customerBd.getPassword())
				.active(customerBd.isActive())
				.build();
	}
	
	public CustomerDTO findCustomerById(Long id) {
		
		Customer customerBd = customerRep.findById(id).get();
		
		return CustomerDTO.builder()
				.id(customerBd.getId())
				.cpf(customerBd.getCpf())
				.firstName(customerBd.getFirstName())
				.lastName(customerBd.getLastName())
				.sex(customerBd.getSex())
				.birthdate(convertDateToString(customerBd.getBirthdate()))
				.email(customerBd.getEmail())
				.password(customerBd.getPassword())
				.active(customerBd.isActive())
				.build();
	}
	
	public CustomerDTO setCustomer(Long id, Customer customer) {
		
		Customer customerBd = customerRep.findById(id).get();
		customerBd.setCpf(customer.getCpf());
		customerBd.setFirstName(customer.getFirstName());
		customerBd.setLastName(customer.getLastName());
		customerBd.setSex(customer.getSex());
		customerBd.setBirthdate(customer.getBirthdate());
		customerBd.setEmail(customer.getEmail());
		customerBd.setPassword(passEncoder.encode(customer.getPassword()));
		customerRep.save(customerBd);
		
		return CustomerDTO.builder()
				.id(customerBd.getId())
				.cpf(customerBd.getCpf())
				.firstName(customerBd.getFirstName())
				.lastName(customerBd.getLastName())
				.sex(customerBd.getSex())
				.birthdate(convertDateToString(customerBd.getBirthdate()))
				.email(customerBd.getEmail())
				.password(customerBd.getPassword())
				.build();
	}
	
	public CustomerDTO updateCustomerPassword(Long id, Map<String, String> password) {
		
		Customer customerBd = customerRep.findById(id).get();
		customerBd.setPassword(passEncoder.encode(password.get("password")));
		customerRep.save(customerBd);
		
		return CustomerDTO.builder()
				.id(customerBd.getId())
				.cpf(customerBd.getCpf())
				.firstName(customerBd.getFirstName())
				.lastName(customerBd.getLastName())
				.sex(customerBd.getSex())
				.birthdate(convertDateToString(customerBd.getBirthdate()))
				.email(customerBd.getEmail())
				.password(customerBd.getPassword())
				.build();
	}
	
	public String convertDateToString(Date date) {
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");	
		String dateString = df.format(date);
		return dateString;
		
	}
	
}
