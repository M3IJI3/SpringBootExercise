package com.jiemei.data;

import com.jiemei.model.OrderEntity;
import com.jiemei.model.OrderModel;
import jakarta.annotation.Resource;
import org.modelmapper.ModelMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class OrderDataServiceForRepository implements OrdersDataAccessInterface<OrderModel> {

    @Resource
    OrdersRepositoryInterface ordersRepository;

    private JdbcTemplate jdbcTemplate;

    public OrderDataServiceForRepository(DataSource dataSource)
    {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public OrderModel getById(long id) {
        OrderEntity entity = ordersRepository.findById(id).orElse(null);
//        OrderModel model = new OrderModel(id,
//                            entity.getOrderNo(),
//                            entity.getProductName(),
//                            entity.getPrice(),
//                            entity.getQuantity());

        OrderModel model = modelMapper.map(entity, OrderModel.class);
        return model;
    }

    @Override
    public List<OrderModel> getOrders() {
        Iterable<OrderEntity> ordersEntity = ordersRepository.findAll();
        List<OrderModel> models = new ArrayList<>();
        for(OrderEntity item: ordersEntity)
        {
            // add item to the list of orderModel
            models.add(modelMapper.map(item, OrderModel.class));
        }
        return models;
    }

    @Override
    public List<OrderModel> searchOrders(String searchTerm) {
        return null;
    }

    @Override
    public long addOne(OrderModel object) {
        return 0;
    }

    @Override
    public boolean deleteOne(long id) {
        return false;
    }

    @Override
    public OrderModel updateOne(long id, OrderModel object) {
        return null;
    }
}
