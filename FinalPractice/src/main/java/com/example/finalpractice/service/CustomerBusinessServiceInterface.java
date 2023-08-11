package com.example.finalpractice.service;

import com.example.finalpractice.model.CustomerModel;

import java.util.List;

public interface CustomerBusinessServiceInterface {
    List<CustomerModel> getAllCustomers();
    CustomerModel getCustomerById(String custid);
    CustomerModel getCustomerByName(String custname);
    CustomerModel updateCustomer(String custid, CustomerModel customer);
    boolean deleteCustomer(String custid);
    void addCustomer(CustomerModel customer);
}
