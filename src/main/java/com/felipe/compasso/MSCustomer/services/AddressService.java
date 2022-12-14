package com.felipe.compasso.MSCustomer.services;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipe.compasso.MSCustomer.DTO.AddressDtoWithCustomerId;
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
	
	public AddressDtoRecovery addAddress(AddressDtoWithCustomerId addressDtoIns) {
		
		Customer customerBd = customerRep.findById(addressDtoIns.getCustomerId()).get();
		
		Address address = new ModelMapper().map(addressDtoIns, Address.class);
		address.setState(this.getStateLikeEnum(addressDtoIns.getState()));
		address.setCustomer(customerBd);
		addressRep.save(address);
		
		AddressDtoRecovery addressDtoRec = new ModelMapper().map(address, AddressDtoRecovery.class);
		
		return addressDtoRec;
		
	}
	
	public AddressDtoRecovery editAddress(Long id, @Valid AddressDtoWithCustomerId addressDtoIns) {

		Address addressBd = addressRep.findById(id).get();
		Customer customerBd = customerRep.findById(addressDtoIns.getCustomerId()).get();
		
		addressBd.setState(getStateLikeEnum(addressDtoIns.getState()));
		addressBd.setCity(addressDtoIns.getCity());
		addressBd.setDistrict(addressDtoIns.getDistrict());
		addressBd.setStreet(addressDtoIns.getStreet());
		addressBd.setNumber(addressDtoIns.getNumber());
		addressBd.setCep(addressDtoIns.getCep());
		addressBd.setComplement(addressDtoIns.getComplement());
		addressBd.setCustomer(customerBd);
		
		addressRep.save(addressBd);
		
		AddressDtoRecovery addressDtoRec = new ModelMapper().map(addressBd, AddressDtoRecovery.class);
		
		return addressDtoRec;
	}
	
	private BrazilianStates getStateLikeEnum(String name) {
	
		Map<String, String> states = new HashMap<String, String>();
		
		states.put("Acre", "AC");
		states.put("Alagoas", "AL");
		states.put("Amap??", "AP");
		states.put("Amazonas","AM");
		states.put("Bahia","BA");
		states.put("Cear??","CE");
		states.put("Distrito Federal", "DF");
		states.put("Esp??rito Santo","ES");
		states.put("Goi??s","GO");
		states.put("Maranh??o","MA");
		states.put("Mato Grosso","MT");
		states.put("Mato Grosso do Sul","MS");
		states.put("Minas Gerais","MG");
		states.put("Par??","PA");
		states.put("Para??ba","PB");
		states.put("Paran??","PA");
		states.put("Pernambuco","PE");
		states.put("Piau??","PI");
		states.put("Rio de Janeiro","RJ");
		states.put("Rio Grande do Norte","RN");
		states.put("Rio Grande do Sul","RS");
		states.put("Rond??nia","RO");
		states.put("Roraima","RR");
		states.put("Santa Catarina","SC");
		states.put("S??o Paulo","SP");
		states.put("Sergipe","SE");
		states.put("Tocantins","TO");
		
		String stateFound = states.get(name);
		
		return BrazilianStates.valueOf(stateFound);
		
	}

	public void deleteAddress(Long id) {
		addressRep.deleteById(id);
	}
	
}
