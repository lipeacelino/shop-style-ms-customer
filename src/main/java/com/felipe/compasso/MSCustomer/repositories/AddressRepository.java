package com.felipe.compasso.MSCustomer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.felipe.compasso.MSCustomer.entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
