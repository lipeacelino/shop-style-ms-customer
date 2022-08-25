package com.felipe.compasso.MSCustomer.DTO;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressDtoInsertion {

	@NotNull
	private String state;
	
	@NotEmpty
	private String city;
	
	@NotEmpty
	private String district;
	
	@NotEmpty
	private String street;
	
	@NotEmpty
	private String number;
	
	@NotEmpty
	private String cep;
	
	private String complement;
	
	@JsonAlias("customer_id")
	private Long customerId;
	
}
