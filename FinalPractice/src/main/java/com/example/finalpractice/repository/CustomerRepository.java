package com.example.finalpractice.repository;

import com.example.finalpractice.model.CustomerEntity;
import com.example.finalpractice.model.CustomerModel;
import jakarta.annotation.Resource;
import org.modelmapper.ModelMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepository implements CustomerDAOInterface<CustomerModel> {

    @Resource
    CustomerRepositoryInterface customerRepositoryInterface;

    public JdbcTemplate jdbcTemplate;

    public CustomerRepository(DataSource dataSource)
    {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<CustomerModel> getAllCustomers() {
        Iterable<CustomerEntity> customerEntities = customerRepositoryInterface.findAll();
        List<CustomerModel> customerModels = new ArrayList<>();

        for(CustomerEntity customerEntity : customerEntities)
        {
            customerModels.add(modelMapper.map(customerEntity, CustomerModel.class));
        }

        return customerModels;
    }

    @Override
    public CustomerModel getCustomerById(String custid) {
        return null;
    }

    @Override
    public List<CustomerModel> getCustomerByName(String custname) {
        List<CustomerEntity> customerEntities =
                customerRepositoryInterface.findAllByCustnameContainingIgnoreCase(custname);
        List<CustomerModel> customerModels = new ArrayList<>();

        for(CustomerEntity customerEntity : customerEntities)
        {
            customerModels.add(modelMapper.map(customerEntity, CustomerModel.class));
        }
        return customerModels;
    }

    @Override
    public CustomerModel updateCustomer(String custid, CustomerModel customer) {
        CustomerEntity customerEntity = modelMapper.map(customer, CustomerEntity.class);
        CustomerEntity result = customerRepositoryInterface.save(customerEntity);
        return modelMapper.map(result, CustomerModel.class);
    }

    @Override
    public boolean deleteCustomer(CustomerModel customerModel) {
        customerRepositoryInterface.delete(modelMapper.map(customerModel, CustomerEntity.class));
        return true;
    }

    @Override
    public void addCustomer(CustomerModel customer) {
        CustomerEntity customerEntity = modelMapper.map(customer, CustomerEntity.class);
        customerRepositoryInterface.save(customerEntity);
    }
}
