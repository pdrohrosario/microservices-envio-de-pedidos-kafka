package com.base.stockservice.service;

import com.base.stockservice.models.Customer;
import com.base.stockservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public Customer findUserByName(String name) {
        return this.repository.findCustomerByName(name);
    }
}