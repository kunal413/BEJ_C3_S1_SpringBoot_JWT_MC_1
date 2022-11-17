package com.niit.jap.service;

import com.niit.jap.Domain.Customer;
import com.niit.jap.exception.CustomerAlreadyExistException;
import com.niit.jap.exception.CustomerNotFoundException;

import java.util.List;

public interface CustomerService {
    public Customer saveUser(Customer customer) throws CustomerAlreadyExistException;
    public Customer findByCustomerNameAndCustomerPassword(String customerName,String customerPassword)throws CustomerNotFoundException;
    List<Customer> getAllUsers();
    boolean deleteCustomer(int customerId)throws CustomerNotFoundException;

}
