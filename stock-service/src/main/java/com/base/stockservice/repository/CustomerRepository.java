package com.base.stockservice.repository;

import com.base.stockservice.models.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findCustomerByName(String name);
}
