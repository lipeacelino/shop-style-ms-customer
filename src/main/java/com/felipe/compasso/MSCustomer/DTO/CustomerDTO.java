package com.felipe.compasso.MSCustomer.DTO;

import com.felipe.compasso.MSCustomer.entities.Sex;

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
public class CustomerDTO {
	
	private Long id;
	private String cpf;
	private String firstName;
	private String lastName;
	private Sex sex;
	private String birthdate;
	private String email;
	private String password;
	private boolean active;
	
}
