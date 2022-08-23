package com.felipe.compasso.MSCustomer.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String state;
	
	private String city;
	
	private String district;
	
	private String street;
	
	private Integer number;
	
	private String cep;
	
	private String complement;
	
	@OneToOne
	private Customer customerId;

}
