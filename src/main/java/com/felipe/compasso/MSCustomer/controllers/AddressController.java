package com.felipe.compasso.MSCustomer.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.felipe.compasso.MSCustomer.DTO.AddressDtoWithCustomerId;
import com.felipe.compasso.MSCustomer.DTO.AddressDtoRecovery;
import com.felipe.compasso.MSCustomer.services.AddressService;

@RestController
@RequestMapping("/v1/address")
public class AddressController {
	
	@Autowired
	private AddressService addressServ;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public AddressDtoRecovery addAddress(@Valid @RequestBody AddressDtoWithCustomerId addressDtoIns) {
		return addressServ.addAddress(addressDtoIns);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public AddressDtoRecovery editAddress(@PathVariable Long id, @Valid @RequestBody AddressDtoWithCustomerId addressDtoIns) {
		return addressServ.editAddress(id, addressDtoIns);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteAddress(@PathVariable Long id) {
		addressServ.deleteAddress(id);
	}

}
