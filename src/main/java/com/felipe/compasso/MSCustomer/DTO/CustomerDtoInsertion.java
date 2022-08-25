package com.felipe.compasso.MSCustomer.DTO;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.caelum.stella.bean.validation.CPF;
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
public class CustomerDtoInsertion {
	
	@CPF(formatted = true)
	private String cpf;
	
	@Size(min=3)
	private String firstName;
	
	@Size(min=3)
	private String lastName;
	
	@NotNull
	private String sex;
	
	@NotEmpty
	private String birthdate;
	
	@Email
	@Column(unique = true)
	@NotEmpty
	private String email;
	
	@Size(min=6)
	private String password;
	
	private boolean active;
	
}
