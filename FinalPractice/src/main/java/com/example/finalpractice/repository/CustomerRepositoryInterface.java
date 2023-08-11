package com.example.finalpractice.repository;

import com.example.finalpractice.model.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepositoryInterface extends CrudRepository<CustomerEntity, Long> {
    List<CustomerEntity> findAllByCustnameContainingIgnoreCase(String custname);
}
