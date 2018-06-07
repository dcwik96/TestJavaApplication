package com.projekt.projekt2.service;

import com.projekt.projekt2.entity.Customer;
import com.projekt.projekt2.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    public Customer save(Customer customer) {
        if (customerRepo.findByEmail(customer.getEmail()) == null)
            return customerRepo.save(customer);
        else
            throw new IllegalArgumentException("Email is used");
    }

    public Customer updateFirstName(Customer customer, String newFirstName) {
        if (customerRepo.findByEmail(customer.getEmail()) != null) {
            customer.setFirstname(newFirstName);
            return customerRepo.save(customer);
        }
        return null;
    }

    public Customer updateLastName(Customer customer, String newLastName) {
        if (customerRepo.findByEmail(customer.getEmail()) != null) {
            customer.setLastname(newLastName);
            return customerRepo.save(customer);
        }
        return null;
    }

    public Customer updateEmail(Customer customer, String newEmail) {
        if (customerRepo.findByEmail(customer.getEmail()) != null && customerRepo.findByEmail(newEmail) == null) {
            customer.setEmail(newEmail);
            return customerRepo.save(customer);
        }
        return null;
    }


}
