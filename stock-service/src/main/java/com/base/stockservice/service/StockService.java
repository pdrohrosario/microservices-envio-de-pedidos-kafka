package com.base.stockservice.service;

import com.base.domains.dto.RequestDTO;
import com.base.stockservice.models.Customer;
import com.base.stockservice.models.Request;
import com.base.stockservice.repository.CustomerRepository;
import com.base.stockservice.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.UUID;

@Service
public class StockService {

    @Autowired
    private StockRepository repository;

    @Autowired
    private CustomerRepository customerRepository;

    public void create(RequestDTO dto){
        Request order = new Request();
        order.setId(Long.getLong(UUID.randomUUID().toString()));
        order.setName(dto.getName());
        order.setPrice(dto.getPrice());
        order.setQuantity(dto.getQuantity());

        Customer requestingUser = this.customerRepository.findCustomerByName(dto.getRequestingCustomer());
        Assert.notNull(requestingUser ,"Requesting user wasnt informaed! ");

        order.setCustomer(requestingUser);
        this.repository.save(order);
    }

}
