package com.felipe.compasso.MSCustomer.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.felipe.compasso.MSCustomer.DTO.CustomerDtoInsertion;
import com.felipe.compasso.MSCustomer.DTO.CustomerDtoRecovery;
import com.felipe.compasso.MSCustomer.entities.Customer;
import com.felipe.compasso.MSCustomer.entities.Sex;
import com.felipe.compasso.MSCustomer.repositories.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRep;
	
	@Autowired
	private PasswordEncoder passEncoder;
	
	public CustomerDtoRecovery addCustomer(CustomerDtoInsertion customerDtoPost) {

		customerDtoPost.setPassword(passEncoder.encode(customerDtoPost.getPassword()));
		
		Customer customer = new ModelMapper().map(customerDtoPost, Customer.class);
		customer.setSex(Sex.valueOf(customerDtoPost.getSex().toUpperCase()));
		customer.setBirthdate(convertStringToDate(customerDtoPost.getBirthdate()));
		
		Customer customerBd = customerRep.save(customer);
		
		CustomerDtoRecovery customerDtoRec = new ModelMapper().map(customerBd, CustomerDtoRecovery.class);
		customerDtoRec.setSex(customerBd.getSex().getDescription());
		customerDtoRec.setBirthdate(customerBd.getBirthdate());
		
		return customerDtoRec;
		
	}
	
	public CustomerDtoRecovery findCustomerById(Long id) {
		
		Customer customerBd = customerRep.findById(id).get();
		
		CustomerDtoRecovery customerRec = new ModelMapper().map(customerBd, CustomerDtoRecovery.class);
		
		return customerRec;
		
	}
	
	public CustomerDtoRecovery setCustomer(Long id, CustomerDtoInsertion customerDtoPost) {
		
		Customer customerBd = customerRep.findById(id).get();
		customerBd.setCpf(customerDtoPost.getCpf());
		customerBd.setFirstName(customerDtoPost.getFirstName());
		customerBd.setLastName(customerDtoPost.getLastName());
		customerBd.setSex(Sex.valueOf(customerDtoPost.getSex().toUpperCase()));
		customerBd.setBirthdate(convertStringToDate(customerDtoPost.getBirthdate()));
		customerBd.setEmail(customerDtoPost.getEmail());
		customerBd.setPassword(passEncoder.encode(customerDtoPost.getPassword()));
		
		customerRep.save(customerBd);
		
		CustomerDtoRecovery customerDtoRec = new ModelMapper().map(customerBd, CustomerDtoRecovery.class);
		customerDtoRec.setSex(customerBd.getSex().getDescription());
		
		return customerDtoRec;
		
	}
	
	public CustomerDtoRecovery updateCustomerPassword(Long id, Map<String, String> password) {
		
		Customer customerBd = customerRep.findById(id).get();
		customerBd.setPassword(passEncoder.encode(password.get("password")));
		customerRep.save(customerBd);
		
		CustomerDtoRecovery customerDtoRec = new ModelMapper().map(customerBd, CustomerDtoRecovery.class);
		customerDtoRec.setSex(customerBd.getSex().getDescription());
		
		return customerDtoRec;
		
	}
	
	public Date convertStringToDate(String dateString) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		
		Date date = null;
		
		try {
			date = sdf.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return date;
		
	}
	
	
	public String convertDateToString(Date date) {
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");	
		String dateString = df.format(date);
		return dateString;
		
	}
	
}
