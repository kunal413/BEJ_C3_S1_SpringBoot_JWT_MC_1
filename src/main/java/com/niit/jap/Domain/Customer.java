package com.niit.jap.Domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
    @Id
    private int customerId;
    private String customerName;
    private  String CustomerUserName;
    private String CustomerUserPassword;

    public Customer(int customerId, String customerName, String customerUserName, String customerUserPassword) {
        this.customerId = customerId;
        this.customerName = customerName;
        CustomerUserName = customerUserName;
        CustomerUserPassword = customerUserPassword;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerUserName() {
        return CustomerUserName;
    }

    public void setCustomerUserName(String customerUserName) {
        CustomerUserName = customerUserName;
    }

    public String getCustomerUserPassword() {
        return CustomerUserPassword;
    }

    public void setCustomerUserPassword(String customerUserPassword) {
        CustomerUserPassword = customerUserPassword;
    }

    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", CustomerUserName='" + CustomerUserName + '\'' +
                ", CustomerUserPassword='" + CustomerUserPassword + '\'' +
                '}';
    }
}
