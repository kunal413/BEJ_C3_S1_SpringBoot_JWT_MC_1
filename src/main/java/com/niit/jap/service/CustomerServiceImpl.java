package com.niit.jap.service;

import com.niit.jap.Domain.Customer;
import com.niit.jap.exception.CustomerAlreadyExistException;
import com.niit.jap.exception.CustomerNotFoundException;
import com.niit.jap.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;
    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }


    @Override
    public Customer saveUser(Customer customer) throws CustomerAlreadyExistException {

        return customerRepository.save(customer);
    }

    @Override
    public Customer findByCustomerNameAndCustomerPassword(String customerName, String customerPassword) throws CustomerNotFoundException {
        Customer customer= customerRepository.findByCustomerNameAndCustomerPassword(customerName,customerPassword);
        if (customer==null){
            throw new CustomerNotFoundException();
        }
        return customer;
    }

    @Override
    public List<Customer> getAllUsers() {
        return customerRepository.findAll();
    }

    @Override
    public boolean deleteCustomer(int customerId) throws CustomerNotFoundException {
        if (customerRepository.findById(customerId).isEmpty()){
            throw new CustomerNotFoundException();
        }else {
            customerRepository.deleteById(customerId);
        }
        return true;
    }
}
