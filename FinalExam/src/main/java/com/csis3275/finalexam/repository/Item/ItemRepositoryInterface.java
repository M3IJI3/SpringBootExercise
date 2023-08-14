package com.csis3275.finalexam.repository.Item;

import com.csis3275.finalexam.model.ItemEntity;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepositoryInterface extends CrudRepository<ItemEntity, Long> {

}
