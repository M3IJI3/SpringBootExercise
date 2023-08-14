package com.csis3275.finalexam.service;

import com.csis3275.finalexam.model.ItemModel;
import com.csis3275.finalexam.repository.Item.ItemDAOInterface;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService implements ItemServiceInterface {

    @Resource
    ItemDAOInterface<ItemModel> itemModelItemDAOInterface;

    @Override
    public List<ItemModel> getAllItems() {
        return itemModelItemDAOInterface.getAllItems();
    }
}
