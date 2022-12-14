package com.felipe.compasso.MSCustomer.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

@Entity(name = "customer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@CPF(formatted = true)
	private String cpf;
	
	@Size(min=3)
	private String firstName;
	
	@Size(min=3)
	private String lastName;
	
	@Enumerated(EnumType.STRING)
	@NotNull
	private Sex sex;
	
	@NotNull
	private Date birthdate;
	
	@Email
	@Column(unique = true)
	@NotEmpty
	private String email;
	
	@Size(min=6)
	private String password;
	
	private boolean active;

}
