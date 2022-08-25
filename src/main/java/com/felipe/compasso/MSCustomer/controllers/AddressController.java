package com.felipe.compasso.MSCustomer.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.felipe.compasso.MSCustomer.DTO.AddressDtoInsertion;
import com.felipe.compasso.MSCustomer.DTO.AddressDtoRecovery;
import com.felipe.compasso.MSCustomer.services.AddressService;

@RestController
@RequestMapping("/v1/address")
public class AddressController {
	
	@Autowired
	private AddressService adressServ;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public AddressDtoRecovery addAdress(@Valid @RequestBody AddressDtoInsertion addressDtoIns) {
		return adressServ.addAddress(addressDtoIns);
	}

}
