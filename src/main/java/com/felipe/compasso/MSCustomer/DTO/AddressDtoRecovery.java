package com.felipe.compasso.MSCustomer.DTO;

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
public class AddressDtoRecovery {
	
	private Long id;
	
	private String state;
	
	private String city;
	
	private String district;
	
	private String street;
	
	private String number;
	
	private String cep;
	
	private String complement;
	
	private CustomerDtoRecovery customer;

}
