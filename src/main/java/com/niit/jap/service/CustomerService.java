package com.niit.jap.service;

import com.niit.jap.Domain.Customer;
import com.niit.jap.exception.CustomerNotFoundException;

import java.util.List;

public interface CustomerService {
    public Customer saveUser(Customer customer);
    public Customer findByCustomerUsernameAndCustomerUserPassword(String customerUsername,String customerUserPassword)throws CustomerNotFoundException;
    List<Customer> getAllUsers();
    boolean deleteCustomer(int customerId)throws CustomerNotFoundException;

}
