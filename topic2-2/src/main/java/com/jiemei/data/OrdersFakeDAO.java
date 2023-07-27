package com.jiemei.data;

import com.jiemei.model.OrderModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/** @Repository: a specific kind of managed bean,
 *               it is useful when doing data access.
 *               Identify this as SpringBean.
 **/
@Repository
public class OrdersFakeDAO implements OrdersDataAccessInterface<OrderModel>{
    List<OrderModel> orders = new ArrayList<>();

    public OrdersFakeDAO(){
        orders.add(new OrderModel(0L,"AAA","Big mac", 2.0f, 30));
        orders.add(new OrderModel(1L,"BBB","Fries", 2.0f, 4));
        orders.add(new OrderModel(2L,"CCC","Coke", 3.0f, 2));
        orders.add(new OrderModel(3L,"DDD","Chicken Nuggets", 12.4f, 100));
        orders.add(new OrderModel(4L,"EEE","Spicy Chicken Burger", 13.0f, 78));
        orders.add(new OrderModel(5L,"FFF","Muffin cake", 3.2f, 3));
        orders.add(new OrderModel(6L,"GGG","Fish Burger", 10.5f, 30));
        orders.add(new OrderModel(7L,"HHH","Fried Chicken", 2.5f, 40));
        orders.add(new OrderModel(8L,"III","Apple Pie", 4.0f, 10));
        orders.add(new OrderModel(9L,"JJJ","Large Fries", 3.0f, 10));
    }

    @Override
    public OrderModel getById(long id) {
        for(int i = 0; i < orders.size() ; i++)
        {
            if (orders.get(i).getId() == id){
                // return model if finding something matched
                return orders.get(i);
            }
        }
        // nothing if none match
        return null;
    }

    @Override
    public List<OrderModel> getOrders() {
        return orders;
    }

    @Override
    public List<OrderModel> searchOrders(String searchTerm) {
        // given a search term. create a list of items whose description is matched
//        List<OrderModel> foundItems = new ArrayList<>();
//         for(int i = 0 ; i < orders.size(); i++)
//         {
//            if (orders.get(i).getProductName().toLowerCase().contains(searchTerm))
//            {
//                foundItems.add(orders.get(i));
//            }
//         }
        List<OrderModel> foundItems = orders
                .stream()
                .filter(order -> order.getProductName().toLowerCase().contains(searchTerm.toLowerCase()))
                .collect(Collectors.toList());
        return foundItems;
    }

    @Override
    public long addOne(OrderModel object) {
        boolean success = orders.add(object);

        if(success){
            return 1;
        }
        else
        {
            return 0;
        }
    }

    @Override
    public boolean deleteOne(long id) {
        for(int i =0 ; i < orders.size() ; i++)
        {
            if(orders.get(i).getId() == id)
            {
                orders.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public OrderModel updateOne(long id, OrderModel object) {
        for(int i = 0 ; i < orders.size() ; i++)
        {
            if(orders.get(i).getId() == id)
            {
                orders.set(i, object);
                return orders.get(i);
            }
        }
        return null;
    }
}
