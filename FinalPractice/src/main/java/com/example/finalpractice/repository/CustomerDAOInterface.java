package com.example.finalpractice.repository;

import java.util.List;

public interface CustomerDAOInterface<T> {
    List<T> getAllCustomers();
    T getCustomerById(String custid);

    T getCustomerByName(String custname);
    T updateCustomer(String custid, T customer);
    boolean deleteCustomer(String custid);
    void addCustomer(T customer);
}
