package com.jiemei.data;

import com.jiemei.model.OrderEntity;
import com.jiemei.model.OrderModel;
import jakarta.annotation.Resource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
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
        Iterable<OrderEntity> entities = ordersRepository
                .findByProductNameContainingIgnoreCase(searchTerm);

        List<OrderModel> orders = new ArrayList<>();

        for(OrderEntity entity : entities)
        {
            orders.add(modelMapper.map(entity, OrderModel.class));
        }
        return orders;
    }

    @Override
    public long addOne(OrderModel object) {
        OrderEntity entity = modelMapper.map(object, OrderEntity.class);
        OrderEntity result = ordersRepository.save(entity);

        if(result == null)
        {
            return 0;
        }

        return result.getId();
    }

    @Override
    public boolean deleteOne(long id) {
        ordersRepository.deleteById(id);
        return true;
    }

    @Override
    public OrderModel updateOne(long id, OrderModel object) {
        OrderEntity entity = modelMapper.map(object, OrderEntity.class);
        OrderEntity result = ordersRepository.save(entity);
        OrderModel order = modelMapper.map(result, OrderModel.class);
        return order;
    }
}
