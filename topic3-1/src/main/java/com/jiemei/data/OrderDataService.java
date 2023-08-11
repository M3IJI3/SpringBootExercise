package com.jiemei.data;

import com.jiemei.model.OrderModel;
import com.jiemei.model.OrdersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
public class OrderDataService implements OrdersDataAccessInterface<OrderModel> {

    // see application.properties file to get the detail on mysql connection
    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public OrderModel getById(long id) {
        List<OrderModel> orderModels =
                jdbcTemplate.query("select * from ORDERS where id = ?", new OrdersMapper(), id);
        if (orderModels.size() > 0)
        {
            return orderModels.get(0);
        }
        else{
            return null;
        }
    }

    @Override
    public List<OrderModel> getOrders() {
        List<OrderModel> results = jdbcTemplate.query("SELECT * FROM ORDERS", new OrdersMapper());
        return results;
    }

    @Override
    public List<OrderModel> searchOrders(String searchTerm) {
        List<OrderModel> results = jdbcTemplate.query("select * from ORDERS where PRODUCT_NAME like ?",
                new OrdersMapper(), "%" + searchTerm + "%");

        return results;
    }

    @Override
    public long addOne(OrderModel object) {
        long result = jdbcTemplate.update("insert into orders " +
                "(ORDER_NUMBER, PRODUCT_NAME, PRICE, QTY) values (?,?,?,?)",
                object.getOrderNo(),
                object.getProductName(),
                object.getPrice(),
                object.getQuantity());
//        SimpleJdbcInsert simpleInsert = new SimpleJdbcInsert(jdbcTemplate);
//        simpleInsert.withTableName("ORDERS").usingGeneratedKeyColumns("ID");
//
//        // create a map of the column names
//        Map<String, Object> parameters =  new HashMap<>();
//
//        parameters.put("ORDER_NUMBER", object.getOrderNo());
//        parameters.put("PRODUCT_NAME", object.getProductName());
//        parameters.put("PRICE", object.getPrice());
//        parameters.put("QTY", object.getQuantity());
//
//        Number result =  simpleInsert.executeAndReturnKey(parameters);

        return result;
    }

    @Override
    public boolean deleteOne(long id) {
//        jdbcTemplate.query("delete * from ORDERS where id = ?", id);
        int flag = jdbcTemplate.update("delete from ORDERS where id = ?", id);

        if(flag > 0){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public OrderModel updateOne(long id, OrderModel object) {
         int flag =  jdbcTemplate.update("UPDATE ORDERS SET ORDER_NUMBER = ?, " +
                "PRODUCT_NAME = ?, PRICE = ?, QTY = ? WHERE ID = ?",
                object.getOrderNo(),
                object.getProductName(),
                object.getPrice(),
                object.getQuantity(), id);

         if (flag > 0)
         {
             return object;
         }else{
            return null;
         }
    }
}
