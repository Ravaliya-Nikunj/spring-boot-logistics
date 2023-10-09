package com.example.logistics.serviceImplementors;

import com.example.logistics.models.Customer;
import com.example.logistics.repositories.CustomerRepository;
import com.example.logistics.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void register(Customer customer) {
        System.out.println("Customer register");
        customerRepository.save(customer);
    }
}
