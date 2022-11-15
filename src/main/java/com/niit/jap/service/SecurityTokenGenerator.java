package com.niit.jap.service;

import com.niit.jap.Domain.Customer;

import java.util.Map;

public interface SecurityTokenGenerator {
    Map<String,String>generateToken(Customer customer);
}
