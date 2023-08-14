package com.example.finalpractice;

import com.example.finalpractice.model.CustomerEntity;
import com.example.finalpractice.model.CustomerModel;
import com.example.finalpractice.repository.CustomerRepository;
import com.example.finalpractice.repository.CustomerRepositoryInterface;
import com.example.finalpractice.service.CustomerBusinessService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;

public class CustomerCRUDTest {
    @InjectMocks
    private CustomerBusinessService customerBusinessService;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private CustomerRepositoryInterface customerRepositoryInterface;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    ModelMapper modelMapper = new ModelMapper();

    @Test
    public void testAddNewCustomer()
    {
        CustomerModel customerModel = new CustomerModel();
        customerModel.setCustno("200");
        customerModel.setCustname("Test");
        customerModel.setCustdep(1200.0);
        customerModel.setNyears(1);
        customerModel.setSavtype("Saving");

        CustomerEntity customerEntity = modelMapper.map(customerModel, CustomerEntity.class);

        Mockito.when(customerRepositoryInterface.save(customerEntity)).thenReturn(customerEntity);

        customerBusinessService.addCustomer(customerModel);

        assertNotNull(customerModel);
        assertEquals("Test", customerModel.getCustname());
        assertEquals("Saving", customerModel.getSavtype());

    }

    @Test
    public void testGetAllCustomer()
    {
        List<CustomerModel> customerModelList = new ArrayList<>();

        CustomerModel customerModel1 = new CustomerModel();
        customerModel1.setCustno("100");
        customerModel1.setCustname("Jie Mei");
        customerModel1.setCustdep(1000.1);
        customerModel1.setNyears(1);
        customerModel1.setSavtype("Cheque");
        customerModelList.add(customerModel1);

        CustomerModel customerModel2 = new CustomerModel();
        customerModel2.setCustno("101");
        customerModel2.setCustname("Steven Jobs");
        customerModel2.setCustdep(1399.3);
        customerModel2.setNyears(9);
        customerModel2.setSavtype("Saving");
        customerModelList.add(customerModel2);

        Mockito.when(customerRepository.getAllCustomers()).thenReturn(customerModelList);

        List<CustomerModel> retrievedCustomers = customerBusinessService.getAllCustomers();
        System.out.println(retrievedCustomers);
        assertNotNull(retrievedCustomers);
        assertEquals(2, retrievedCustomers.size());

        CustomerModel retrievedCustomer1 = retrievedCustomers.get(0);
        assertEquals("Jie Mei", retrievedCustomer1.getCustname());
        assertEquals("Cheque", retrievedCustomer1.getSavtype());

        CustomerModel retrievedCustomer2 = retrievedCustomers.get(1);
        assertEquals("Steven Jobs", retrievedCustomer2.getCustname());
        assertEquals("Saving", retrievedCustomer2.getSavtype());

        Mockito.verify(customerRepository, times(1)).getAllCustomers();
    }

    @Test
    public void testDeleteCustomer()
    {
        CustomerModel customerModel = new CustomerModel();
        customerModel.setCustno("200");
        customerModel.setCustname("Test");
        customerModel.setCustdep(1200.0);
        customerModel.setNyears(1);
        customerModel.setSavtype("Saving");

        customerBusinessService.deleteCustomer(customerModel);

        Mockito.verify(customerRepository, times(1)).deleteCustomer(customerModel);
    }
}
