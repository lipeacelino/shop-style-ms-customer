package com.felipe.compasso.MSCustomer.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.felipe.compasso.MSCustomer.entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
	
	@Query(" SELECT a FROM address a WHERE a.customer.id = :id ")
	List<Address> findAllAddresOfCustomer(@Param("id") Long customerId);

}
