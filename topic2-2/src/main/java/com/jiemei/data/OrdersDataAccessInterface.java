package com.jiemei.data;

import com.jiemei.model.OrderModel;

import java.util.List;

public interface OrdersDataAccessInterface<T> {
    T getById(long id);
    List<T> getOrders();
    List<T> searchOrders(String searchTerm);
    long addOne(T object);
    boolean deleteOne(long id);
    T updateOne(long id, T object);
}
