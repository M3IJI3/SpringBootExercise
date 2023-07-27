package com.jiemei.services;

import com.jiemei.model.OrderModel;
import java.util.List;

public interface OrderBusinessServiceInterface {
    void test();
    OrderModel getById(long id);
    List<OrderModel> getOrders();
    List<OrderModel> searchOrders(String searchTerm);
    long addOne(OrderModel object);
    boolean deleteOne(long id);
    OrderModel updateOne(long id, OrderModel object);
}
