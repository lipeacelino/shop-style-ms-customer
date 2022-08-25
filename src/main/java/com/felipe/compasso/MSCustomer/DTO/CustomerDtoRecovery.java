package com.felipe.compasso.MSCustomer.DTO;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

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
public class CustomerDtoRecovery {

	private Long id;
	private String cpf;
	private String firstName;
	private String lastName;
	private String sex;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date birthdate;
	private String email;
	private String password;
	private boolean active;
	
}
