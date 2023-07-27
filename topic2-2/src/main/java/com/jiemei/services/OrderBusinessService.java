package com.jiemei.services;

import com.jiemei.data.OrdersDataAccessInterface;
import com.jiemei.model.OrderModel;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * To enable dependency injection,
 * don't forget to add @Service to any Service.java
 * this annotation will treat the class as service
 * waiting to be injected.
 * **/
//@Service
public class OrderBusinessService implements OrderBusinessServiceInterface {

//    @Resource
    @Resource
    OrdersDataAccessInterface<OrderModel> orderDAO;

    @Override
    public void test() {
        System.out.println("OrderBusinessService is working!");
    }

    @Override
    public OrderModel getById(long id) {
        return orderDAO.getById(id);
    }

    @Override
    public List<OrderModel> getOrders() {
        return orderDAO.getOrders();
    }

    @Override
    public List<OrderModel> searchOrders(String searchTerm) {
        return orderDAO.searchOrders(searchTerm);
    }

    @Override
    public long addOne(OrderModel object) {
        return orderDAO.addOne(object);
    }

    @Override
    public boolean deleteOne(long id) {
        return orderDAO.deleteOne(id);
    }

    @Override
    public OrderModel updateOne(long id, OrderModel object) {
        return orderDAO.updateOne(id, object);
    }
}
