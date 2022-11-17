package com.niit.jap.repository;

import com.niit.jap.Domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    public Customer findByCustomerNameAndCustomerPassword(String customerName,String customerPassword);
}
