package com.felipe.compasso.MSCustomer.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="address")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private BrazilianStates state;
	
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
	
	@OneToOne
	private Customer customer;

}
