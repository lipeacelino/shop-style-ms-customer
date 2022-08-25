package com.felipe.compasso.MSCustomer.services;

import java.util.HashMap;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipe.compasso.MSCustomer.DTO.AddressDtoInsertion;
import com.felipe.compasso.MSCustomer.DTO.AddressDtoRecovery;
import com.felipe.compasso.MSCustomer.entities.Address;
import com.felipe.compasso.MSCustomer.entities.BrazilianStates;
import com.felipe.compasso.MSCustomer.entities.Customer;
import com.felipe.compasso.MSCustomer.repositories.AddressRepository;
import com.felipe.compasso.MSCustomer.repositories.CustomerRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRep;
	
	@Autowired
	private CustomerRepository customerRep;
	
	public AddressDtoRecovery addAddress(AddressDtoInsertion addressDtoIns) {
		
		Customer customerBd = customerRep.findById(addressDtoIns.getCustomerId()).get();
		
		Address address = new ModelMapper().map(addressDtoIns, Address.class);
		address.setState(this.getStateLikeEnum(addressDtoIns.getState()));
		address.setCustomer(customerBd);
		addressRep.save(address);
		
		AddressDtoRecovery addressDtoRec = new ModelMapper().map(address, AddressDtoRecovery.class);
		
		return addressDtoRec;
		
	}
	
	private BrazilianStates getStateLikeEnum(String name) {
	
		Map<String, String> states = new HashMap<String, String>();
		
		states.put("Acre", "AC");
		states.put("Alagoas", "AL");
		states.put("Amapá", "AP");
		states.put("Amazonas","AM");
		states.put("Bahia","BA");
		states.put("Ceará","CE");
		states.put("Distrito Federal", "DF");
		states.put("Espírito Santo","ES");
		states.put("Goiás","GO");
		states.put("Maranhão","MA");
		states.put("Mato Grosso","MT");
		states.put("Mato Grosso do Sul","MS");
		states.put("Minas Gerais","MG");
		states.put("Pará","PA");
		states.put("Paraíba","PB");
		states.put("Paraná","PA");
		states.put("Pernambuco","PE");
		states.put("Piauí","PI");
		states.put("Rio de Janeiro","RJ");
		states.put("Rio Grande do Norte","RN");
		states.put("Rio Grande do Sul","RS");
		states.put("Rondônia","RO");
		states.put("Roraima","RR");
		states.put("Santa Catarina","SC");
		states.put("São Paulo","SP");
		states.put("Sergipe","SE");
		states.put("Tocantins","TO");
		
		String stateFound = states.get(name);
		
		return BrazilianStates.valueOf(stateFound);
		
	}
	
}
