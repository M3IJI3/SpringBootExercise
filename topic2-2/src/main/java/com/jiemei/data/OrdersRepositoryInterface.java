package com.jiemei.data;

import com.jiemei.model.OrderEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrdersRepositoryInterface extends CrudRepository<OrderEntity, Long> {

    // use CrudRepository class in spring to do the data operations on mysql
    // already implies that we will use save, findall, findbyid deletebyid, etc.

    List<OrderEntity> findByProductNameContainingIgnoreCase(String searchTerm);

}
