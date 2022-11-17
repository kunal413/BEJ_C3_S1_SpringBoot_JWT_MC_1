package com.niit.jap.controller;

import com.niit.jap.Domain.Customer;
import com.niit.jap.exception.CustomerAlreadyExistException;
import com.niit.jap.exception.CustomerNotFoundException;
import com.niit.jap.service.CustomerService;
import com.niit.jap.service.SecurityTokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CustomerController {
        private ResponseEntity responseEntity;
        private CustomerService customerService;
        private SecurityTokenGenerator securityTokenGenerator;

        @Autowired
        public CustomerController(CustomerService customerService, SecurityTokenGenerator securityTokenGenerator) {
            this.customerService = customerService;
            this.securityTokenGenerator = securityTokenGenerator;
        }
    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody Customer customer) throws CustomerNotFoundException {
        Map<String, String> map = null;
        try {
            Customer customer1 = customerService.findByCustomerNameAndCustomerPassword(customer.getCustomerName(), customer.getCustomerPassword());
            if (customer1.getCustomerName().equals(customer.getCustomerName())) {
                map = securityTokenGenerator.generateToken(customer);
            }
            responseEntity = new ResponseEntity<>(map, HttpStatus.OK);

        } catch (CustomerNotFoundException e) {
            throw new CustomerNotFoundException();
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>("Try after sometime!!!", HttpStatus.INTERNAL_SERVER_ERROR);

        }
        return responseEntity;
    }

    @PostMapping("/register")
    public ResponseEntity saveUser(@RequestBody Customer customer) throws CustomerAlreadyExistException {
        Customer createdUser = customerService.saveUser(customer);
        return responseEntity = new ResponseEntity<>("User Created", HttpStatus.CREATED);

    }

    @GetMapping("/api/v1/customerservice/customers")
    public ResponseEntity getAllUsers() throws CustomerNotFoundException {
        List<Customer> list = customerService.getAllUsers();
        responseEntity = new ResponseEntity<>(list, HttpStatus.OK);
        return responseEntity;
    }
    @DeleteMapping("/api/v1/customerservice/{customerId}")
    public ResponseEntity deleteUserById(@PathVariable("customerId") int customerId) throws CustomerNotFoundException {
        ResponseEntity responseEntity =null;
        try {
            customerService.deleteCustomer(customerId);
            responseEntity = new ResponseEntity("Successfully deleted the 1 record",HttpStatus.OK);
        }
        catch (CustomerNotFoundException cnfe){
            throw  new CustomerNotFoundException();
        }catch (Exception exception){
            responseEntity = new ResponseEntity<>(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }


}
