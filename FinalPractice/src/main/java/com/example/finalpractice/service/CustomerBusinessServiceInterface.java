package com.example.finalpractice.service;

import com.example.finalpractice.model.CustomerModel;

import java.util.List;

public interface CustomerBusinessServiceInterface {
    List<CustomerModel> getAllCustomers();
    CustomerModel getCustomerById(String custid);
    List<CustomerModel> getCustomerByName(String custname);
    CustomerModel updateCustomer(String custid, CustomerModel customer);
    boolean deleteCustomer(CustomerModel customerModel);
    void addCustomer(CustomerModel customer);
}
