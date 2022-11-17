package com.niit.jap.service;

import com.niit.jap.Domain.Customer;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Service
public class JwtSecurityTokenGeneratorImpl implements SecurityTokenGenerator {
    public Map<String, String> generateToken(Customer customer) {

        String jwtToken = null;
        jwtToken = Jwts.builder()
                .setSubject(customer.getCustomerName())
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,"mykey").compact();
        Map<String,String> map= new HashMap<>();
        map.put("token",jwtToken);
        map.put("message","User Successfully logged in");

        return map;
    }
}
