package com.example.finalpractice.repository;

import com.example.finalpractice.model.CustomerModel;

import java.util.List;

public interface CustomerDAOInterface<T> {
    List<T> getAllCustomers();
    T getCustomerById(String custid);
    List<T> getCustomerByName(String custname);
    T updateCustomer(String custid, T customer);
    boolean deleteCustomer(CustomerModel customerModel);
    void addCustomer(T customer);
}
