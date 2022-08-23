package com.felipe.compasso.MSCustomer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.felipe.compasso.MSCustomer.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
