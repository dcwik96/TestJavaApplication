package com.projekt.projekt2.repository;

import com.projekt.projekt2.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

    ArrayList<Customer> findByFirstname(String firstname);

    ArrayList<Customer> findByLastname(String lastname);

    Customer findByEmail(String email);

    Customer findCustomerById(Long id);

    Customer findByFirstnameAndLastnameAndEmail(String firstname, String lastname, String email);
}
