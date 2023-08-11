package com.example.finalpractice.service;

import com.example.finalpractice.model.CustomerModel;
import com.example.finalpractice.repository.CustomerDAOInterface;
import com.example.finalpractice.repository.CustomerRepositoryInterface;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerBusinessService implements CustomerBusinessServiceInterface {

    @Resource
    CustomerDAOInterface<CustomerModel> customerDAO;

    @Override
    public List<CustomerModel> getAllCustomers() {
        return customerDAO.getAllCustomers();
    }

    @Override
    public CustomerModel getCustomerById(String custid) {
        return customerDAO.getCustomerById(custid);
    }

    @Override
    public CustomerModel getCustomerByName(String custname) {
        return customerDAO.getCustomerByName(custname);
    }

    @Override
    public CustomerModel updateCustomer(String custid, CustomerModel customer) {
        return null;
    }

    @Override
    public boolean deleteCustomer(String custid) {
        return false;
    }

    @Override
    public void addCustomer(CustomerModel customer) {
        customerDAO.addCustomer(customer);
    }
}
