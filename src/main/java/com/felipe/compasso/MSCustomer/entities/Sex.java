package com.felipe.compasso.MSCustomer.entities;

import lombok.Getter;

@Getter
public enum Sex {
	
	MASCULINO("Masculino"),
	FEMININO("Feminino");
	
	private String description;
	
	Sex(String description) {
		this.description = description;
	}
	
}
