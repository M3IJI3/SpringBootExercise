package com.csis3275.finalexam.repository.Item;

import com.csis3275.finalexam.model.ItemEntity;
import com.csis3275.finalexam.model.ItemModel;
import jakarta.annotation.Resource;
import org.modelmapper.ModelMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ItemRepository implements ItemDAOInterface<ItemModel> {

    @Resource
    ItemRepositoryInterface itemRepositoryInterface;

    public JdbcTemplate jdbcTemplate;

    public ItemRepository(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<ItemModel> getAllItems() {
        Iterable<ItemEntity> itemEntities = itemRepositoryInterface.findAll();

        List<ItemModel> itemModels = new ArrayList<>();

        for(ItemEntity itemEntity : itemEntities)
        {
            itemModels.add(modelMapper.map(itemEntity, ItemModel.class));
        }
        return itemModels;
    }
}
